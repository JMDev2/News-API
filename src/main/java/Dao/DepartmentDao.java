package interfaces;

import models.Department;

import java.util.List;

public interface DepartmentDao {
    //    CREATE
    void addDepartment(Department department);

    //    READ
    List<Department> getAllDepartments();
    Department getDepartmentById(int id);


    //    UPDATE
//    DELETE
    void deleteDepartment(int id);

}
