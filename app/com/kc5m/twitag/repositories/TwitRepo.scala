package com.kc5m.twitag.repositories

import java.util.UUID

import com.kc5m.twitag.domains.entities.Twit

import scala.concurrent.Future

trait TwitRepo {
  def list(): Future[Seq[Twit]]
  def add(twiTag: Twit): Future[Unit]
  def delete(id: UUID): Future[Unit]
}
