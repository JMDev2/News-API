package models;

import java.util.Objects;

public class GeneralNews {
    private int id;
    private String title;
    private String content;
    private int departmentId;

    public GeneralNews(int id, String title, String content, int departmentId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.departmentId = departmentId;
    }

    public GeneralNews(String title, String content, int departmentId) {
        this.title = title;
        this.content = content;
        this.departmentId = departmentId;
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

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralNews that = (GeneralNews) o;
        return id == that.id &&
                departmentId == that.departmentId &&
                Objects.equals(title, that.title) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, departmentId);
    }
}
