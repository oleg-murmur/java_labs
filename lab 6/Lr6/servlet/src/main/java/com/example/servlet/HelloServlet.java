package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

public class HelloServlet extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>V1</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action='lr6' method='post'>");
        out.println("<p>Enter Header: <input type='text' name='header' size='20'/></p>");
        out.println("<p>Enter rows: <input type='text' name='rows' size='20'/></p>");
        out.println("<p>Enter columns: <input type='text' name='columns' size='20'/></p>");
        out.println("<p>Enter color: <input type='text' name='color' size='20'/></p>");
        out.println("<input type='submit' value='Create'/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String header = request.getParameter("header");
        int rows = Integer.parseInt(request.getParameter("rows"));
        int columns = Integer.parseInt(request.getParameter("columns"));
        String color = request.getParameter("color");
        out.println("<html>");
        out.println("<head><title>"+header+"</title></head>");
        out.println("<body>");
        out.println("<h1>" + header + "</h1>");
        out.println("<table style='background-color:"+color+";'>");
        for (int i=0; i < rows; i++) {
            out.println("<tr>");
            for (int j=0; j < columns; j++) {
                out.println("<td>"+i+"/"+j+"</td>");
            }
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body></html>");
    }
}
