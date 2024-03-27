package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mysql.cj.jdbc.Driver; // Класс для установления подключения к БД

@WebServlet("/read")
public class ReadServlet extends HttpServlet {
    private Connection connection;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        sc.getRequestDispatcher("/jsp/read.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver(); // Драйвер для подключения к MySQL
            DriverManager.registerDriver(driver); // Указание диспетчеру драйверов какой драйвер загружается
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybdtest", "root", "root"); // Установление соединения с БД
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.setContentType("application/json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String query = String.format("select * from users");
        ArrayList<Screw> screws = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query); // Выполнение SQL инструкции
            while (resultSet.next()) {
                Screw tempScrews = new Screw(resultSet.getString("name"),
                        resultSet.getString("material"),
                        resultSet.getString("head"),
                        resultSet.getString("height"),
                        resultSet.getInt("amount"),
                        resultSet.getInt("id"));
                screws.add(tempScrews);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        String jsonArrayString = "";
        if (screws.size() != 0) {
            jsonArrayString = gson.toJson(screws);
        }
        out.print(jsonArrayString);
        out.close();
    }
}