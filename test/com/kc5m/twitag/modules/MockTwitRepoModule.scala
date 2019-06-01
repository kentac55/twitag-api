package com.kc5m.twitag.modules

import com.kc5m.twitag.mocks.MockTwitRepo
import com.kc5m.twitag.repositories.TwitRepo
import com.softwaremill.macwire._

import scala.concurrent.ExecutionContext

trait MockTwitRepoModule {
  implicit lazy val repo: TwitRepo = wire[MockTwitRepo]

  implicit def ec: ExecutionContext
}
