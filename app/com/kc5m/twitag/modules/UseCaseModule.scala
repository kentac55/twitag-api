package com.kc5m.twitag.modules

import com.kc5m.twitag.repositories.TwitRepo
import com.kc5m.twitag.usecases.{GetTwitsUseCase, GetTwitsUseCaseImpl}
import com.softwaremill.macwire.wire

import scala.concurrent.ExecutionContext

trait UseCaseModule {
  implicit lazy val uc: GetTwitsUseCase = wire[GetTwitsUseCaseImpl]
  implicit def ec: ExecutionContext
  implicit def repo: TwitRepo
}
