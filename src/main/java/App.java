import Dao.Sql2oDepartmentDao;
import Dao.Sql2oDepartmentNewsDao;
import Dao.Sql2oGeneralNewsDao;
import Dao.Sql2oUserDao;
import apiException.ApiException;
import com.google.gson.Gson;
import models.Department;
import models.DepartmentNews;
import models.GeneralNews;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import responses.ResponseObject;

import static spark.Spark.*;
import static spark.route.HttpMethod.post;

public class App {
    public static void main(String[] args) {
        String connect = "jdbc:postgresql://localhost:5432/newsapi";
        Sql2o sql2o = new Sql2o(connect,"postgres","MAINA");



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


//            posting data in the department

        get("/departments", "application/json", (request, response) -> {
            if(sql2oDepartmentDao.getAllDepartments().size()>0){
                return gson.toJson(sql2oDepartmentDao.getAllDepartments());
            }else {
                return "{\"message\":\"No departments found.\"}";
            }
        });

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


        get("/users/:id",  "application/json", (request, response) -> {
            response.type("application/json");
            int userid = Integer.parseInt(request.params("id"));
//            response.type("application/json");
//            return gson.toJson(sql2oUserDao.getAllUsers());
            if (sql2oUserDao.getUsersById(userid) == null) {
                throw new ApiException(404, String.format("No user with the id: \"%s\" exists",
                        request.params("id")));
            }else{
                return gson.toJson(sql2oUserDao.getUsersById(userid));
            }
        });

        post("/departmentNews/new", (request, response) -> {
            System.out.println(request.body());
            DepartmentNews departmentNews = gson.fromJson(request.body(), DepartmentNews.class);
            sql2oDepartmentNewsDao.addNews(departmentNews);
            ResponseObject responseObject = new ResponseObject(201, "success");
            responseObject.setData(new Object());
            response.status(201);

            return gson.toJson(responseObject);

        });
        get("/departmentNews", "application/json", ((request, response) -> {
            response.type("application/json");
            return gson.toJson(sql2oDepartmentNewsDao.getAllNews());
        }));

        get("/departmentNews", "application/json", ((request, response) -> {
            response.type("application/json");
            int depid = Integer.parseInt(request.params("id"));
            response.type("application/json");
            return gson.toJson(sql2oDepartmentNewsDao.getDepartmentNewsById(depid));
        }));

        post("/generalNews/new", (request, response) -> {
            System.out.println(request.body());
            GeneralNews generalNews = gson.fromJson(request.body(), GeneralNews.class);
            sql2oGeneralNewsDao.addNews(generalNews);
            ResponseObject responseObject = new ResponseObject(201, "success");
            responseObject.setData(new Object());
            response.status(201);

            return gson.toJson(responseObject);

        });
        get("/generalNews", "application/json", (request, response) -> {
            response.type("application/json");
            return gson.toJson(sql2oGeneralNewsDao.getAllNews());
        });

        get("/generalNews", "application/json", (request, response) -> {
            response.type("application/json");
            int genId = Integer.parseInt(request.params("id"));
            response.type("application/json");
            return gson.toJson(sql2oGeneralNewsDao.getGeneralNewsById(genId));
        });


//
//            getting specific department
        get("/departments/:id", "application/json", (request, response) -> {
            int departmentid = Integer.parseInt(request.params("id"));

            if (sql2oDepartmentDao.getDepartmentById(departmentid) == null){
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", request.params("id")));
            }

            else {
                return gson.toJson(sql2oDepartmentDao.getDepartmentById(departmentid));
            }
        });


        post("/users/:userid/department/:departmentid", "application/json", (request, response) -> {
            int userid=Integer.parseInt(request.params("userid"));
            int departmentid=Integer.parseInt(request.params("department_id"));
            Department department=sql2oDepartmentDao.getDepartmentById(departmentid);
            User users=sql2oUserDao.getUsersById(userid);
            if(department==null){
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists",
                        request.params("departmentid")));
            }
            if(users==null){
                throw new ApiException(404, String.format("No user with the id: \"%s\" exists",
                        request.params("user_id")));
            }
            sql2oDepartmentDao.addUserDepartment(users,department);

            List<User> departmentUser=sql2oDepartmentDao.getDepartmentUsers(department.getId());

            response.status(201);
            return gson.toJson(departmentUser);

        });


//        getting users in a department
        get("/departments/:id/users", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("id"));

            Department departmentToFind = sql2oDepartmentDao.getDepartmentById(departmentId);

            if (departmentToFind == null){
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", req.params("id")));
            }

            return gson.toJson(sql2oDepartmentDao.getDepartmentNews(departmentToFind));
        });


        exception(ApiException.class, (exc, req, res) -> {
            ApiException err = (ApiException) exc;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json"); //after does not run in case of an exception.
            res.status(err.getStatusCode()); //set the status
            res.body(gson.toJson(jsonMap));  //set the output.
        });


        after((req, res) ->{
            res.type("application/json");
        });

    }


    }

