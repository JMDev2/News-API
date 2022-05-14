package models;

import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String position;
    private int DepartmentId;
    private String role;

    public User(int id, String name, String position, int departmentId, String role) {
        this.id = id;
        this.name = name;
        this.position = position;
        DepartmentId = departmentId;
        this.role = role;
    }

    public User(String name, String position, int departmentId, String role) {
        this.name = name;
        this.position = position;
        DepartmentId = departmentId;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(int departmentId) {
        DepartmentId = departmentId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                DepartmentId == user.DepartmentId &&
                Objects.equals(name, user.name) &&
                Objects.equals(position, user.position) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, position, DepartmentId, role);
    }
}
