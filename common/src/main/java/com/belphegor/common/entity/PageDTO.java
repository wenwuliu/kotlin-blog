package com.belphegor.common.entity;

public class PageDTO {
    private Integer pageSize;
    private Integer pageIndex;
    private Integer currentPage;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        if(currentPage != null){
            pageIndex = (currentPage - 1)*pageSize;
        }
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
        if(pageSize != null){
            pageIndex = (currentPage - 1)*pageSize;
        }
    }
}
