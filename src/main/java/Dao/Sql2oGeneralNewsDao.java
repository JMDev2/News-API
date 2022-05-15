package Dao;

import models.GeneralNews;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oGeneralNewsDao implements GeneralNewsDao {
    private final Sql2o sql2o;
    public Sql2oGeneralNewsDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }
    @Override
    public void addNews(GeneralNews generalNews) {
        String sql = "INSERT INTO generalnews (title, content, departmentid) VALUES (:title, :content, :departmentid)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(generalNews)
                    .executeUpdate()
                    .getKey();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public List<GeneralNews> getAllNews() {
        String sql = "SELECT * FROM generalnews";
        try (Connection con = sql2o.open()) {
           return con.createQuery(sql, true)
                    .executeAndFetch(GeneralNews.class);
        }
    }

    @Override
    public GeneralNews getGeneralNewsById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM generalnews WHERE id=:id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(GeneralNews.class);

        }
    }

    @Override
    public void deleteGeneralNews(int id) {
        String sql = "DELETE FROM generalnews WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();

        }catch (Sql2oException ex){
            System.out.println(ex);
        }

    }
}
