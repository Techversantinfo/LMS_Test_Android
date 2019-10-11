package com.example.lmsmobileapp.Model.StudentModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pagination {

    @SerializedName("totalRecords")
    @Expose
    private Integer totalRecords;
    @SerializedName("perPage")
    @Expose
    private Integer perPage;
    @SerializedName("totalPages")
    @Expose
    private Integer totalPages;
    @SerializedName("start")
    @Expose
    private Integer start;
    @SerializedName("currentPage")
    @Expose
    private Integer currentPage;

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}
