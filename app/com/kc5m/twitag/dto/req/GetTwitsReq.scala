package com.kc5m.twitag.dto.req

import java.util.UUID

case class GetTwitsReq(
    from: Option[UUID],
    to: Option[UUID],
    tags: Option[String]
)
