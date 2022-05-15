package models;

import java.util.Objects;

public class Department {
    private int id;
    private String name;
    private String description;
    private int employees;


    public Department(int id, String name, String description, int employees){
        this.id = id;
        this.name = name;
        this.description = description;
        this.employees = employees;

    }

    public Department(String name, String description, int employees) {
        this.name = name;
        this.description = description;
        this.employees = employees;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEmployees() {
        return employees;
    }

    public void setEmployees(int employees) {
        this.employees = employees;
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
        return employees == that.employees &&
                id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, employees, id);
    }
}
