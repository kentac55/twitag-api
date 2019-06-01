package com.kc5m.twitag.repositories

import java.time.OffsetDateTime
import java.util.UUID

import com.kc5m.twitag.domains.entities.Twit
import com.kc5m.twitag.domains.valueobjects.{Msg, Tag}
import org.scalatestplus.play.PlaySpec

import scala.concurrent.Await
import scala.concurrent.duration.Duration.Inf
import scala.concurrent.ExecutionContext.Implicits.global

class MemRepoSpec extends PlaySpec {
  "MemRepo" should {
    val repo = new MemRepo()
    val uuid = UUID.randomUUID()
    "return entities with list()" in {
      val result: Seq[Twit] = Await.result(repo.list(), Inf)
      result.length mustBe 2
    }
    "add an entity with add()" in {
      val entity: Twit = Twit(uuid, Msg("test"), Nil, OffsetDateTime.now())
      Await.result(repo.add(entity), Inf)
      val result: Seq[Twit] = Await.result(repo.list(), Inf)
      result.length mustBe 3
    }
    "delete an entity with delete()" in {
      Await.result(repo.delete(uuid), Inf)
      val result: Seq[Twit] = Await.result(repo.list(), Inf)
      result.length mustBe 2
    }
  }
}
