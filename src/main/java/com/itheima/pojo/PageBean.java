package com.itheima.pojo;


import java.util.List;

//完成分页查询的JavaBean
public class PageBean<T> {


    private int totalCount;

    private List<T> rows;


    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getTotalCount() {
        return totalCount;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", rows=" + rows +
                '}';
    }

    public List<T> getRows() {
        return rows;
    }
}
