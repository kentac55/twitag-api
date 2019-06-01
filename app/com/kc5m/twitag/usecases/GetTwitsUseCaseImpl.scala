package com.kc5m.twitag.usecases

import com.kc5m.twitag.dto.req.GetTwitsReq
import com.kc5m.twitag.dto.res.TwitsRes
import com.kc5m.twitag.repositories.TwitRepo

import scala.concurrent.{ExecutionContext, Future}

class GetTwitsUseCaseImpl(implicit repo: TwitRepo, ec: ExecutionContext)
    extends GetTwitsUseCase {
  def exec(ro: GetTwitsReq): Future[TwitsRes] = {
    repo.list().map(twits => TwitsRes(twits.toList.map(entityToResponse)))
  }
}
