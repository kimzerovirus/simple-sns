package me.kzv.simpleboard.domain.board

import com.querydsl.core.annotations.QueryProjection

data class BoardSaveRequest(
    val title: String,
    val content: String,
)

data class BoardWithReplyCount @QueryProjection constructor(
    val boardId: Long,
    val title: String,
    val writer: String,
    val replyCount: Long,
)