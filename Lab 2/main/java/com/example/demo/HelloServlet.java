package com.example.demo;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;




import jakarta.servlet.ServletContext;


import java.io.IOException;

public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = request.getParameter("button");
        response.setContentType("text/html");
        switch (str) {
            case ("list"):
                RequestDispatcher requestDispatcher1 = request.getRequestDispatcher("index.html");
                requestDispatcher1.forward(request, response);
                break;
            case ("add"):
                RequestDispatcher requestDispatcher2 = request.getRequestDispatcher("write.html");
                requestDispatcher2.forward(request, response);
                break;
        }
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pathStr = "C:\\Users\\krugo\\IdeaProjects\\untitled1\\demo\\src\\main\\webapp\\json.txt";
        Path path = Paths.get(pathStr);



        String  jsonArrayString = Files.readString(path);
        if (!Files.exists(path)) {
            Files.createFile(path);
        }


        String data = request.getReader().readLine();
        if (data != null) {
        StringBuilder sb = new StringBuilder(jsonArrayString);


        sb.delete(jsonArrayString.length()-2,jsonArrayString.length());

        sb.append(",",0,1);

            sb.append(data);


        sb.append("]}");


        Files.write(path,sb.toString().getBytes());
        }
        ServletContext servletContext = getServletContext();
        servletContext.getRequestDispatcher("/write.html").forward(request, response);

    }
}