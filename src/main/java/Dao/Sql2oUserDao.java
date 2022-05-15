package Dao;

import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oUserDao implements UserDao{
    private final Sql2o sql2o;
    public Sql2oUserDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO users(name, position, departmentid, role) VALUES (:name, :position, :departmentId, :role)";
        try (Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(user)
                    .executeUpdate()
                    .getKey();
            user.setId(id);
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
            try(Connection con = sql2o.open()){
                return con.createQuery(sql)
                        .executeAndFetch(User.class);
            }
        }

    @Override
    public User getUsersById(int id) {
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM users WHERE id=id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(User.class);
        }
    }

    @Override
    public void deleteUser(int id) {
        String sql = "DELETE from users WHERE id= :id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }

    }
}
