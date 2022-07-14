package me.kzv.okvue.web.common.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@NoArgsConstructor
@ToString
@Getter
public class PageResponseDto {
    private List content;
    private int totalPage; // 총 페이지
    private int cpage; // 현재 페이지
    private int size; // 목록 사이즈
    private int startPage, endPage; // 시작 ~ 끝 번호

    private boolean isPrev, isNext; // 이전, 다음 페이지 유무
    private boolean isFirst, isLast; // 첫페이지, 끝페이지 유무
    private List<Integer> pageList; // 페이지 번호 목록

    public PageResponseDto(Page page) {
        content = page.getContent();
        totalPage = page.getTotalPages();
        isFirst = page.isFirst();
        isLast = page.isLast();

        getPageList(page.getPageable());
    }

    private void getPageList(Pageable pageable) {
        cpage = pageable.getPageNumber() + 1; // pageable start on 0
        size = pageable.getPageSize();

        // temp end page
        int tempEnd = (int) (Math.ceil(cpage / 10.0)) * 10;

        startPage = tempEnd - 9;
        endPage = totalPage > tempEnd ? tempEnd : totalPage;
        isPrev = startPage > 1;
        isNext = totalPage > tempEnd;

        pageList = IntStream.rangeClosed(startPage, endPage).boxed().collect(Collectors.toList());
    }
}
