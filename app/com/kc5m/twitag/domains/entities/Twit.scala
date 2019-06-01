package com.kc5m.twitag.domains.entities

import java.time.OffsetDateTime
import java.util.UUID

import com.kc5m.twitag.domains.valueobjects.{Msg, Tag}

case class Twit(
    id: UUID = UUID.randomUUID(),
    msg: Msg,
    tags: Seq[Tag] = Nil,
    createdAt: OffsetDateTime = OffsetDateTime.now()
)

object Twit {
  def apply(msg: String): Twit = new Twit(msg = Msg(msg))
  def apply(msg: String, tags: Seq[String]): Twit =
    new Twit(msg = Msg(msg), tags = tags.map(Tag))
}
