package com.kc5m.twitag.controllers

import akka.actor.ActorSystem
import com.kc5m.twitag.domains.entities.Twit
import com.kc5m.twitag.modules.{
  ControllerContextModule,
  ControllerModule,
  MockTwitRepoModule,
  UseCaseModule
}
import com.kc5m.twitag.viewmodels.TwitEncoder
import org.scalatest.concurrent.ScalaFutures
import org.scalatestplus.play.PlaySpec
import play.api.NoHttpFiltersComponents
import play.api.libs.json.{JsValue, Json}
import play.api.mvc._
import play.api.test.FakeRequest
import play.api.test.Helpers._

import scala.concurrent.duration.Duration.Inf
import scala.concurrent.{Await, Future}

class TwitControllerSpec extends PlaySpec with Results with ScalaFutures {

  "TwitController" should {
    "return all" in {
      val modules: ControllerModule
        with MockTwitRepoModule
        with NoHttpFiltersComponents
        with TwitEncoder
        with UseCaseModule =
        new ControllerModule with MockTwitRepoModule
        with NoHttpFiltersComponents with ControllerContextModule
        with TwitEncoder with UseCaseModule {
          lazy val system: ActorSystem = ActorSystem("db-dispatcher")
          lazy val controllerComponents: ControllerComponents =
            stubControllerComponents()
        }
      val result: Future[Result] =
        modules.twiTagController.get().apply(FakeRequest())
      val body: JsValue     = contentAsJson(result)
      val expect: Seq[Twit] = Await.result(modules.repo.list(), Inf)
      body mustBe Json.obj(
        "twiTags" -> expect
          .map(
            x =>
              Json.obj(
                "id"         -> x.id,
                "msg"        -> x.msg.msg,
                "tags"       -> x.tags.map(_.tag),
                "created_at" -> x.createdAt.toString
            )
          )
      )
    }
  }
}
