package com.github.throyer.carallocator.pagination;

import java.util.Collection;
import java.util.List;

public class Page<T> {
    private final Collection<T> content;
    private final Integer page;
    private final Integer size;  
    private final Integer totalPages;  
    private final Long totalElements;

    public Page(org.springframework.data.domain.Page<T> page) {
        this.content = page.getContent();
        this.page = page.getNumber();
        this.size = page.getSize();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
    }
    
    public Page(Collection<T> content, Long count, Integer page, Integer size) {
        this.content = content;
        this.page = page;
        this.size = size;
        this.totalPages = (int) Math.ceil(count / size);
        this.totalElements = count;
    }

    public Collection<T> getContent() {
        return content;
    }
    
    public Integer getPage() {
        return page;
    }
    
    public Integer getSize() {
        return size;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public static <T> Page<T> of(org.springframework.data.domain.Page<T> page) {
        return new Page<>(page);
    }
}
