package com.kc5m.twitag.usecases

import com.kc5m.twitag.dto.req.GetTwitsReq
import com.kc5m.twitag.dto.res.TwitsRes

import scala.concurrent.Future

trait GetTwitsUseCase extends TwitUseCase {
  def exec(ro: GetTwitsReq): Future[TwitsRes]
}
