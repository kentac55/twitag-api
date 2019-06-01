package com.kc5m.twitag.domains.valueobjects

import org.scalatestplus.play.PlaySpec

class MsgSpec extends PlaySpec {
  "Msg object" should {
    "be created correctly" in {
      val msg = Msg("foo")
      msg.toString mustBe "foo"
    }
  }
}
