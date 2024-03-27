package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/read")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext sc = getServletContext();
        sc.getRequestDispatcher("/jsp/read.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pathStr = "C:\\Users\\krugo\\IdeaProjects\\untitled4\\demo\\src\\main\\webapp\\myData.dat";
		Path path = Paths.get(pathStr);
		response.setContentType("application/json");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String datArrayString="1";
		if(Files.exists(path)) {
			datArrayString = Files.readString(path);
			System.out.println(datArrayString);
		}
		PrintWriter out = response.getWriter();
		String jsonArrayString="";
		if(!Objects.equals(datArrayString, "")) {
			ArrayList<Screw> screws = FileHandler.readScrewsFromFile();
			jsonArrayString = gson.toJson(screws);
		}
		out.print(jsonArrayString);
		out.close();
	}

}
