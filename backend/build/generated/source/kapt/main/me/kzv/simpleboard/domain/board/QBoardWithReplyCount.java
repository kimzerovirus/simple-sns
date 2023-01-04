package me.kzv.simpleboard.domain.board;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * me.kzv.simpleboard.domain.board.QBoardWithReplyCount is a Querydsl Projection type for BoardWithReplyCount
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QBoardWithReplyCount extends ConstructorExpression<BoardWithReplyCount> {

    private static final long serialVersionUID = 2128059350L;

    public QBoardWithReplyCount(com.querydsl.core.types.Expression<Long> boardId, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> writer, com.querydsl.core.types.Expression<Long> replyCount) {
        super(BoardWithReplyCount.class, new Class<?>[]{long.class, String.class, String.class, long.class}, boardId, title, writer, replyCount);
    }

}

