package com.kc5m.twitag.viewmodels

import com.kc5m.twitag.dto.res.{TwitRes, TwitsRes}
import play.api.libs.json.{Json, Writes}

trait TwitEncoder {
  implicit val twitWrites: Writes[TwitRes] = (res: TwitRes) =>
    Json.obj(
      "id"         -> res.id.toString,
      "msg"        -> res.msg,
      "tags"       -> res.tags,
      "created_at" -> res.createdAt.toString
    )
  implicit val twitsWrites: Writes[TwitsRes] = (res: TwitsRes) =>
    Json.obj(
      "twiTags" -> res.TwiTags
    )
}
