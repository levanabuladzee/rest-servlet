package controller;

import dao.UserDao;
import model.User;
import util.BodyReader;
import util.JsonHelper;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/user"})
public class RestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        UserDao dao = new UserDao();

        List<User> getUserList = dao.getUsers();
        JsonArray userJsonArray = JsonHelper.generateGetJson(getUserList); // Generate JSON Array from User List

        if (userJsonArray.size() == 0) {
            resp.sendError(404);
        } else {
            resp.setStatus(200);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            out.println(userJsonArray);
            out.flush();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        UserDao dao = new UserDao();
        String body = BodyReader.getBody(req); // Get request body
        JsonObject user = JsonHelper.getJson(body); // Parse JSON from body

        User postUser = dao.postUser(new User(user.getString("username"), user.getString("password")));
        JsonObject userJsonObject = JsonHelper.generatePostJson(postUser); // Generate JSON Object from User model

        if (postUser.getId() == 0) {
            resp.sendError(400);
        } else {
            resp.setStatus(201);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            out.println(userJsonObject);
            out.flush();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        UserDao dao = new UserDao();
        String body = BodyReader.getBody(req); // Get request body
        JsonObject user = JsonHelper.getJson(body); // Parse JSON from body

        int putUser = dao.putUser(new User(Integer.parseInt(user.getString("id")), user.getString("username"), user.getString("password")));

        if (putUser == 0) {
            resp.sendError(404);
        } else {
            resp.setStatus(204);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        UserDao dao = new UserDao();
        String body = BodyReader.getBody(req); // Get request body
        JsonObject user = JsonHelper.getJson(body); // Parse JSON from body

        int deleteUser = dao.deleteUser(new User(Integer.parseInt(user.getString("id"))));

        if (deleteUser == 0) {
            resp.sendError(404);
        } else {
            resp.setStatus(204);
        }
    }
}
