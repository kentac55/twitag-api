package com.kc5m.twitag.domains.entities

import java.time.OffsetDateTime
import java.util.UUID

import com.kc5m.twitag.domains.valueobjects._
import org.scalatestplus.play.PlaySpec

class TwitSpec extends PlaySpec {
  "Twit entity" should {
    "build instance with full params" in {
      val twit = Twit(
        id = UUID.randomUUID(),
        msg = Msg("test"),
        tags = Seq(Tag("testTag")),
        createdAt = OffsetDateTime.now()
      )
      twit.msg mustBe Msg("test")
      twit.tags mustBe Seq(Tag("testTag"))
    }
    "build instance with only msg" in {
      val twit = Twit("test")
      twit.msg mustBe Msg("test")
      twit.tags mustBe Nil
    }
    "build instance with partially params" in {
      val twit = Twit("test", Seq("testTag"))
      twit.msg mustBe Msg("test")
      twit.tags mustBe Seq(Tag("testTag"))
    }
  }
}
