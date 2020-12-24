package com.lkl.utils;

public class Page {
    //当前页
    private int curPageNo;
    //页面大小
    private int pageSize;
    //总记录数
    private int totalCount;
    //总页数
    private int pageTotalCount;

    public int getCurPageNo() {
        return curPageNo;
    }

    public void setCurPageNo(int curPageNo) {
        this.curPageNo = curPageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount % pageSize == 0) {
            pageTotalCount = totalCount / pageSize;
        }else{
            pageTotalCount = totalCount / pageSize + 1;
        }
        this.totalCount = totalCount;
    }

    public int getPageTotalCount() {
        return pageTotalCount;
    }

/*    public void setPageTotalCount(int pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }*/
}
