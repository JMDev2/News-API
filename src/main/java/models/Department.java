package models;

import java.util.Objects;

public class Department {
    private String depName;
    private String depDescription;
    private int depEmplNo;
    private int id;

    public Department(String depName, String depDescription, int depEmplNo, int id) {
        this.depName = depName;
        this.depDescription = depDescription;
        this.depEmplNo = depEmplNo;
        this.id = id;
    }

    public Department(String depName, String depDescription, int depEmplNo) {
        this.depName = depName;
        this.depDescription = depDescription;
        this.depEmplNo = depEmplNo;


    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepDescription() {
        return depDescription;
    }

    public void setDepDescription(String depDescription) {
        this.depDescription = depDescription;
    }

    public int getDepEmplNo() {
        return depEmplNo;
    }

    public void setDepEmplNo(int depEmplNo) {
        this.depEmplNo = depEmplNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return depEmplNo == that.depEmplNo &&
                id == that.id &&
                Objects.equals(depName, that.depName) &&
                Objects.equals(depDescription, that.depDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(depName, depDescription, depEmplNo, id);
    }
}
