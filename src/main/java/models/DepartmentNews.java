package models;

import java.util.Objects;

public class DepartmentNews extends GeneralNews {
    private int did;
    private static final String TYPE = "DepartmenttNews";

    public DepartmentNews(String title, String content, int departmentId, int did) {
        super(title, content, departmentId);
        this.did = did;

    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DepartmentNews that = (DepartmentNews) o;
        return did == that.did;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), did);
    }
}



