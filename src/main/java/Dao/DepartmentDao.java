package Dao;

import models.Department;
import models.DepartmentNews;
import models.User;

import java.util.List;

public interface DepartmentDao {
    //    CREATE
    void addDepartment(Department department);
    void addUserDepartment(User user, Department department);

    //    READ
    List<Department> getAllDepartments();
    List<User> getDepartmentUsers(int departmentid);
    List<DepartmentNews> getDepartmentNews(Department department);




    Department getDepartmentById(int id);


//    DELETE
    void deleteDepartment(int id);

}
