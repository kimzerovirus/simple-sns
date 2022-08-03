package me.kzv.okvue.modules.like;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentLikeRepository extends JpaRepository<ReplyLike, Long> {
}
