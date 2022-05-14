package interfaces;

import models.DepartmentNews;

import java.util.List;

public interface DepartmentNewsDao {
    //Create
    void addNews(DepartmentNews departmentNews);

    //Read
    List<DepartmentNews> getAllNews();
    DepartmentNews getDepartmentNewsById(int id);

    //Update

    //Delete
    void deleteDepartmentNews(int id);
}
