package com.kc5m.twitag.repositories

import java.time.OffsetDateTime
import java.util.UUID

import com.kc5m.twitag.domains.entities.Twit
import com.kc5m.twitag.domains.valueobjects.{Msg, Tag}

import scala.concurrent.{ExecutionContext, Future}

class MemRepo(implicit ec: ExecutionContext) extends TwitRepo {
  private var twits: Seq[Twit] = Vector(
    Twit(
      UUID.randomUUID(),
      Msg("hoge"),
      List(Tag("Funny"), Tag("Fresh")),
      OffsetDateTime.now()
    ),
    Twit(
      UUID.randomUUID(),
      Msg("fuga"),
      List(Tag("Surprise"), Tag("Fresh")),
      OffsetDateTime.now()
    )
  )
  def list(): Future[Seq[Twit]]       = Future { twits }
  def add(twiTag: Twit): Future[Unit] = Future { twits = twits :+ twiTag }
  def delete(id: UUID): Future[Unit] = Future {
    twits = twits.filterNot(x => x.id == id)
  }
}
