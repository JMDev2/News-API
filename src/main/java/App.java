import Dao.Sql2oDepartmentDao;
import Dao.Sql2oDepartmentNewsDao;
import Dao.Sql2oGeneralNewsDao;
import Dao.Sql2oUserDao;
import com.google.gson.Gson;
import models.Department;
import models.DepartmentNews;
import models.GeneralNews;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.Collections;
import responses.ResponseObject;

import static spark.Spark.*;
import static spark.route.HttpMethod.post;

public class App {
    public static void main(String[] args) {
        String connect = "jdbc:postgresql://localhost:5432/newsapi";
        Sql2o sql2o = new Sql2o(connect, "postgres", "MAINA");
        Sql2oUserDao sql2oUserDao = new Sql2oUserDao(sql2o);
        Sql2oDepartmentDao sql2oDepartmentDao = new Sql2oDepartmentDao(sql2o);
        Sql2oGeneralNewsDao sql2oGeneralNewsDao = new Sql2oGeneralNewsDao(sql2o);
        Sql2oDepartmentNewsDao sql2oDepartmentNewsDao = new Sql2oDepartmentNewsDao(sql2o);
        Connection conn = sql2o.open();


        Sql2oUserDao userDao;
        Sql2oDepartmentDao departmentDao;
        Sql2oGeneralNewsDao generalNewsDao;
        Sql2oDepartmentNewsDao departmentNewsDao;
        Connection con;
        Gson gson = new Gson();


//        User user = new User("maina","hr",1,"hr");
//        sql2oUserDao.addUser(user);
//        System.out.println("INSERTED");
//
//        Department department = new Department("hr", "hr", 10);
//        sql2oDepartmentDao.addDepartment(department);
//        System.out.println("INSERTED");
//
//        GeneralNews generalNews = new GeneralNews("sports", "today",1);
//        sql2oGeneralNewsDao.addNews(generalNews);
//        System.out.println("INSERTED");
//
//        DepartmentNews departmentNews = new DepartmentNews("hr", "today", 1);
//        sql2oDepartmentNewsDao.addNews(departmentNews);
//        System.out.println("INSERTED");

        post("/departments/new", (request, response) -> {
            System.out.println(request.body());
            Department department = gson.fromJson(request.body(), Department.class);
            sql2oDepartmentDao.addDepartment(department);
            ResponseObject responseObject = new ResponseObject(201, "success");
            responseObject.setData(new Object());
            response.status(201);

            return gson.toJson(responseObject);

        });
        get("/department", "application/json", (request, response) -> { //accept a request in format JSON from an app
            response.type("application/json");
            return gson.toJson(sql2oDepartmentDao.getAllDepartments());//send it back to be displayed
        });
        get("/department/:id", "application/json", (request, response) -> { //accept a request in format JSON from an app
            response.type("application/json");
            int departmentid = Integer.parseInt(request.params("id"));
            response.type("application/json");
            return gson.toJson(sql2oDepartmentDao.getDepartmentById(departmentid));
        });

        post("/user/new", (request, response) -> {
            System.out.println(request.body());
            User user = gson.fromJson(request.body(), User.class);
            sql2oUserDao.addUser(user);
            ResponseObject responseObject = new ResponseObject(201, "success");
            responseObject.setData(new Object());
            response.status(201);

            return gson.toJson(responseObject);

        });
        get("/users", "application/json" , (request, response) -> { //accept a request in format JSON from an app
            response.type("application/json");
            return gson.toJson(sql2oUserDao.getAllUsers());//send it back to be displayed
        });

        get("/users",  "application/json", ((request, response) -> {
            response.type("application/json");
            int userid = Integer.parseInt(request.params("id"));
            response.type("application/json");
            return gson.toJson(sql2oUserDao.getAllUsers());
        }));


        post("/departmentNews/new", (request, response) -> {
            System.out.println(request.body());
            DepartmentNews departmentNews = gson.fromJson(request.body(), DepartmentNews.class);
            sql2oDepartmentNewsDao.addNews(departmentNews);
            ResponseObject responseObject = new ResponseObject(201, "success");
            responseObject.setData(new Object());
            response.status(201);

            return gson.toJson(responseObject);

        });

        post("/generalNews/new", (request, response) -> {
            System.out.println(request.body());
            GeneralNews generalNews = gson.fromJson(request.body(), GeneralNews.class);
            sql2oGeneralNewsDao.addNews(generalNews);
            ResponseObject responseObject = new ResponseObject(201, "success");
            responseObject.setData(new Object());
            response.status(201);

            return gson.toJson(responseObject);

        });













        after((req, res) ->{
            res.type("application/json");
        });


    }


    }

