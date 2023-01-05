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
        // native query
        // select b.id as board_id, b.title, m.nickname as writer, count(r.id) as reply_count from board b, reply r left join member m on member_id = m.id where b.id = r.board_id group by b.id;
        val content = queryFactory
            .select(
                QBoardWithReplyCount(
                    board.id.`as`("boardId"),
                    board.title,
                    board.content,
                    member.nickname.`as`("writer"),
                    reply.count().`as`("replyCount")
                )
            )
            .from(board, reply)
            .leftJoin(board.writer, member)
            .where(board.eq(reply.board))
            .groupBy(board)
            .offset(pageable.offset)
            .limit(pageable.pageSize.toLong())
            .fetch()

        val countQuery = queryFactory
            .select(board.count())
            .from(board)
            .leftJoin(board.writer, member)

        return PageDto(PageableExecutionUtils.getPage(content, pageable) { countQuery.fetchOne()!! })
    }

    override fun getOneWithReplyCount(boardId: Long): BoardWithReplyCount? {
        return queryFactory
            .select(
                QBoardWithReplyCount(
                    board.id.`as`("boardId"),
                    board.title,
                    board.content,
                    member.nickname.`as`("writer"),
                    reply.count().`as`("replyCount")
                ))
            .from(board, reply)
            .leftJoin(board.writer, member)
            .where(board.id.eq(boardId).and(reply.board.id.eq(boardId)))
            .groupBy(board)
            .fetchOne()
    }
}