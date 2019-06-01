package com.kc5m.twitag.domains.valueobjects

import org.scalatestplus.play.PlaySpec

class TagSpec extends PlaySpec {
  "Tag object" should {
    "be created correctly" in {
      val tag = Tag("foo")
      tag.toString mustBe "foo"
    }
  }
}
