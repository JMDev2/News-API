package Dao;

import models.DepartmentNews;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentNewsDao implements DepartmentNewsDao {
    private final Sql2o sql2o;
    public Sql2oDepartmentNewsDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }
    @Override
    public void addNews(DepartmentNews departmentNews) {
        String sql = "INSERT INTO departmentnews (title, content, departmentid) VALUES (:title, :content, :departmentid)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(departmentNews)
                    .executeUpdate()
                    .getKey();

        }catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public List<DepartmentNews> getAllNews() {
        String sql = "SELECT * FROM departmentnews";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(DepartmentNews.class);
        }
    }

    @Override
    public DepartmentNews getDepartmentNewsById(int id) {
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM departmentnews WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(DepartmentNews.class);

        }
    }

    @Override
    public void deleteDepartmentNews(int id) {
        String sql = "DELETE FROM departmentnews id = :id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();

        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
