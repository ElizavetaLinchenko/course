package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserResponse {
    @JsonProperty("per_page")
    private int perPage;
    private int total;
    private List<User> data;
    private int page;
    @JsonProperty("total_pages")
    private int totalPages;
    private Support support;

    public int getPerPage() {
        return perPage;
    }

    public int getTotal() {
        return total;
    }

    public List<User> getUser() {
        return data;
    }

    public int getPage() {
        return page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public Support getSupport() {
        return support;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}