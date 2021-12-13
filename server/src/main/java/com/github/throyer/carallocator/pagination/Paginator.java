package com.github.throyer.carallocator.pagination;

import static java.util.Objects.nonNull;
import static org.springframework.data.domain.PageRequest.of;

import org.springframework.data.domain.Pageable;

public class Paginator {

    private static final int FIRST_PAGE = 0;

    private static final int DEFAULT_SIZE = 10;
    private static final int MIN_SIZE = 1;
    private static final int MAX_SIZE = 500;

    private int page = FIRST_PAGE;
    private int size = DEFAULT_SIZE;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        if (nonNull(page) && page >= FIRST_PAGE) {
            this.page = page;
        } else {
            this.page = FIRST_PAGE;
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (nonNull(size) && size >= MIN_SIZE && size <= MAX_SIZE) {
            this.size = size;
        } else {
            this.size = DEFAULT_SIZE;
        }
    }

    public Pageable pageable() {
        return of(page, size);
    }

    public Integer getLimit() {
        return this.size;
    }

    public Integer getOffset() {
        return (this.size * (this.page + 1)) - this.size;
    }
}
