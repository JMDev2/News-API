package models;

import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String position;
    private int departmentId;
    private String role;

    public User(int id, String name, String position, int departmentId, String role) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.departmentId = departmentId;
        this.role = role;
    }

    public User(String name, String position, int departmentId, String role) {
        this.name = name;
        this.position = position;
        this.departmentId = departmentId;
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
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
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
                departmentId == user.departmentId &&
                Objects.equals(name, user.name) &&
                Objects.equals(position, user.position) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, position, departmentId, role);
    }
}
