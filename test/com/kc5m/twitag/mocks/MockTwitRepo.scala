package com.kc5m.twitag.mocks

import java.util.UUID

import com.kc5m.twitag.domains.entities.Twit
import com.kc5m.twitag.repositories.TwitRepo

import scala.concurrent.{ExecutionContext, Future}

class MockTwitRepo(implicit ec: ExecutionContext) extends TwitRepo {
  val list: Future[Seq[Twit]] = Future {
    Vector(
      Twit(
        msg = "mock1",
        tags = Seq("Funny", "Fresh")
      ),
      Twit(
        msg = "mock2",
        tags = Seq("Surprise", "Fresh")
      )
    )
  }
  def add(twiTag: Twit): Future[Unit] = Future { println("fake") }

  def delete(id: UUID): Future[Unit] = Future { println("fake") }
}
