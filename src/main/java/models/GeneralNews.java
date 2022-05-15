package models;

import java.util.Objects;

public class GeneralNews {
    private int id;
    private String title;
    private String content;
    private int departmentid;

    public GeneralNews(int id, String title, String content, int departmentid) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.departmentid = departmentid;
    }

    public GeneralNews(String title, String content, int departmentid) {
        this.title = title;
        this.content = content;
        this.departmentid = departmentid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralNews that = (GeneralNews) o;
        return id == that.id &&
                departmentid == that.departmentid &&
                Objects.equals(title, that.title) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, departmentid);
    }
}
