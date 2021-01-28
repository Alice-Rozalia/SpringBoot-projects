package org.kuro.community.entity;

/**
 * @Author: 白鸟亦悲否？
 * @Date: 2021/1/28 19:20
 */
public class Page {

    private Integer current = 1;        // 当前页码
    private Integer limit = 10;         // 每页显示条数
    private Integer rows;               // 数据总数
    private String path;                // 查询路径（用于显示分页链接）

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        if (current >= 1) {
            this.current = current;
        }
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        if (limit >= 1 && limit <= 100) {
            this.limit = limit;
        }
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    // 获取当前页的起始行
    public Integer getOffset() {
        return (current - 1) * limit;
    }

    // 获取总页数
    public Integer getTotal() {
        if (rows % limit == 0) {
            return rows / limit;
        } else {
            return rows / limit + 1;
        }
    }

    // 获取起始页码
    public Integer getFrom() {
        Integer from = current - 2;
        return from < 1 ? 1 : from;
    }

    // 获取结束页码
    public Integer getTo() {
        Integer to = current + 2;
        Integer total = getTotal();
        return to > total ? total : to;
    }
}
