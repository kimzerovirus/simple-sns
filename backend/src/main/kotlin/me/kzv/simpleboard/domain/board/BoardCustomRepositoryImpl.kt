package me.kzv.simpleboard.domain.board

import com.querydsl.jpa.impl.JPAQueryFactory
import me.kzv.simpleboard.domain.PageDto
import me.kzv.simpleboard.domain.board.entity.QBoard.board
import me.kzv.simpleboard.domain.board.entity.SearchType
import me.kzv.simpleboard.domain.member.entity.QMember.member
import me.kzv.simpleboard.domain.reply.entity.QReply.reply
import org.springframework.data.domain.Pageable
import org.springframework.data.support.PageableExecutionUtils

class BoardCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory
) : BoardCustomRepository {

    override fun search(keyword: String?, searchType: SearchType?, pageable: Pageable): PageDto {
        val content = queryFactory
            .select(
                QBoardWithReplyCount(
                    board.id.`as`("boardId"),
                    board.title,
                    member.nickname.`as`("writer"),
                    reply.count().`as`("replyCount")
                )
            )
            .from(board)
            .leftJoin(board.writer, member)
            .groupBy(board.id, reply.board)
            .offset(pageable.offset)
            .limit(pageable.pageSize.toLong())
            .fetch()

        val countQuery = queryFactory
            .select(board.count())
            .from(board)
            .leftJoin(board.writer, member)

        return PageDto(PageableExecutionUtils.getPage(content, pageable) { countQuery.fetchOne()!! })
    }
}