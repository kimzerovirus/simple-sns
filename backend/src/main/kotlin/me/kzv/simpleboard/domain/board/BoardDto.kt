package me.kzv.simpleboard.domain.board

import com.querydsl.core.annotations.QueryProjection
import me.kzv.simpleboard.domain.board.entity.Board
import me.kzv.simpleboard.domain.img.ImgResponse
import me.kzv.simpleboard.domain.reply.ReplyResponse

data class BoardSaveRequest(
    val title: String,
    val content: String,
)

data class BoardWithReplyCount @QueryProjection constructor(
    val boardId: Long,
    val title: String,
    val content: String,
    val writer: String,
    val replyCount: Long,
){
    var imgs: List<ImgResponse> = mutableListOf()
}

data class BoardResponse (
    val board: BoardWithReplyCount,
    val reply: List<ReplyResponse>
)
