package Dao;

import models.Department;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao {
    private final Sql2o sql2o;

    public Sql2oDepartmentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
    @Override
    public void addDepartment(Department department) {
        String sql ="INSERT INTO departments (name, description, employees) VALUES (:name, :description, :employees)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public List<Department> getAllDepartments() {
        String sql = "SELECT * FROM departments";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(Department.class);
        }
    }

    @Override
    public Department getDepartmentById(int id) {
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM users WHERE id=id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Department.class);
        }
    }

    @Override
    public void deleteDepartment(int id) {
        String sql = "DELETE FROM department WHERE id = :id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }

    }
}
