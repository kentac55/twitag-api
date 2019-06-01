package com.kc5m.twitag.dto.res

import java.time.OffsetDateTime
import java.util.UUID

case class TwitRes(
    id: UUID,
    msg: String,
    tags: Seq[String],
    createdAt: OffsetDateTime
)
