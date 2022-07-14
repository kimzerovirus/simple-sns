package me.kzv.okvue.web.common.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Builder
@Getter
public class PageRequestDto {

    private int page;
    private int size;
    private String type; // 검색 타입
    private String keyword; // 검색 키워드

    public PageRequestDto() {
        this.page = 1;
        this.size = 10;
    }

    public PageRequestDto(int page, int size, String type, String keyword) {
        this.page = page;
        this.size = size;
        this.type = type;
        this.keyword = keyword;
    }

    public Pageable getPageable() {
        return PageRequest.of(page, size);
    }

    public Pageable getPageable(Sort sort){
        return PageRequest.of(getCurrentPage(page), size, sort);
    }

    private int getCurrentPage(int page) {
        if (page < 0) {
            return 0;
        } else {
            return page - 1;
        }
    }
}
