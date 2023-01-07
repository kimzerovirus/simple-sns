package me.kzv.simpleboard.domain.img

import me.kzv.simpleboard.domain.img.entity.ReplyImg
import me.kzv.simpleboard.domain.img.entity.UploadImg
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface UploadImgRepository : JpaRepository<UploadImg, Long> {
    // https://ocwokocw.tistory.com/158
    // join 으로 가져와야할듯 TODO 수정 필요
    // SELECT i.id, i.img_url FROM UPLOAD_IMG i left join board b on board_id = b.id where b.id = 1
//    @Query("select new me.kzv.simpleboard.domain.img.ImgResponse(i.id, i.imgUrl) from UploadImg i join fetch Board b on treat(i as BoardImg).board = b where b.id = :boardId")
    @Query("select new me.kzv.simpleboard.domain.img.ImgResponse(i.id, i.imgUrl) from UploadImg i where treat(i as BoardImg).board.id = :boardId")
    fun getBoardImgsByBoardId(@Param("boardId") boardId: Long): List<ImgResponse>

    @Query("select treat(i as ReplyImg) from UploadImg i where treat(i as ReplyImg ).board.id = :boardId")
    fun getReplyImgsByBoardId(@Param("boardId") boardId: Long): List<ReplyImg>

    @Query("select new me.kzv.simpleboard.domain.img.ImgResponse(i.id, i.imgUrl) from UploadImg i where treat(i as BoardImg).board.id = :boardId or treat(i as ReplyImg).board.id = :boardId")
    fun getImgsByBoardId(@Param("boardId") boardId: Long): List<ImgResponse>

//    @Query("select i from UploadImg i where treat(i as BoardImg).board = :board")
////    @Query("select i from UploadImg i where type(i) in (BoardImg)")
//    fun test(@Param("board") board: Board): List<BoardImg>

}
