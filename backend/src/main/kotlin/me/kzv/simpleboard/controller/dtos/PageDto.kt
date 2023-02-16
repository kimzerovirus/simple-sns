package me.kzv.simpleboard.controller.dtos

import org.springframework.data.domain.Page
import java.util.stream.Collectors
import java.util.stream.IntStream
import kotlin.math.ceil

/**
 * Any 는 아무타입이나 사용할 때 * 은 아직 타입이 정해지지 않았지만 한 번 정해지면 계속 그 타입을 유지해야할 경우 사용
 */
data class PageResponseDto(
    val page: Page<*>
) {
    val content: List<*> = page.content
    val totalPage = page.totalPages

    var pageList = mutableListOf<Int>()
    var cpage: Int = 0 // 현재 페이지
    var isPrev: Boolean = false // 이전, 다음 페이지 유무
    var isNext: Boolean = false

    init {
        cpage = page.pageable.pageNumber + 1 // pageable start on 0

        val tempEnd = ceil(cpage / 10.0).toInt() * 10
        val startPage = tempEnd - 9
        val endPage = if (totalPage > tempEnd) tempEnd else totalPage
        isPrev = startPage > 1
        isNext = totalPage > tempEnd
        pageList = IntStream.rangeClosed(startPage, endPage).boxed().collect(Collectors.toList())
    }
}
