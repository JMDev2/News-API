package Dao;

import models.Department;
import models.DepartmentNews;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
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
    public void addUserDepartment(User user, Department department) {
        String sql = "INSERT INTO user_department (userid, departmentid) VALUES (:userid, :departmentid)";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)

                    .addParameter("userid", user.getId())
                    .addParameter("departmentid", department.getId())
                    .executeUpdate();

            String sizeQuery="SELECT userid FROM user_department";
            List<Integer> size=con.createQuery(sizeQuery)
                    .executeAndFetch(Integer.class);
            String updateDepartmentSize="UPDATE departments SET size=:size WHERE id=:id";
            con.createQuery(updateDepartmentSize).addParameter("id",department.getId())
                    .addParameter("size",size.size())
                    .executeUpdate();


        }

    }




    @Override
    public List<DepartmentNews> getDepartmentNews(Department department) {
        String sql = "SELECT * FROM departmentnews WHERE departmentid=:id";
        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id",department.getId())
                    .executeAndFetch(DepartmentNews.class);
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
    public List<User> getDepartmentUsers(int departmentid) {
        List<User> users=new ArrayList<>();
        try (Connection con=sql2o.open()){
            String sql= "SELECT userid FROM userdepartment WHERE departmentid=:departmentid";
            List<Integer> userIds=con.createQuery(sql)
                    .addParameter("departmentid",departmentid)
                    .executeAndFetch(Integer.class);
            for(Integer id : userIds){
                String userResults="SELECT * FROM users WHERE id=:id";
                users.add(con.createQuery(userResults)
                        .addParameter("id",id)
                        .executeAndFetchFirst(User.class));
            }
            return users;
        }
    }


    @Override
    public Department getDepartmentById(int id) {
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM departments WHERE id = :id")
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
