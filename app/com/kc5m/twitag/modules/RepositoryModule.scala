package com.kc5m.twitag.modules

import com.kc5m.twitag.repositories.{MemRepo, TwitRepo}
import com.softwaremill.macwire.wire

import scala.concurrent.ExecutionContext

trait RepositoryModule {
  implicit lazy val repo: TwitRepo = wire[MemRepo]
  implicit def ec: ExecutionContext
}
