package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class FileHandler {
	private static String pathStr = "C:\\Users\\krugo\\IdeaProjects\\untitled4\\demo\\src\\main\\webapp\\myData.dat";
	private static Path path = Paths.get(pathStr);
	public static void writeScrewToFile(Screw screw) throws IOException {
		String screwString = "";
		screwString+=screw.getName()+",";
		screwString+=screw.getMaterial()+",";
		screwString+=screw.getHead()+",";
		screwString+=screw.getHeight()+",";
		screwString+=screw.getPrice()+"\n";
		if(!Files.exists(path)) {
			Files.createFile(path);
		}
		Files.write(path, screwString.getBytes(), StandardOpenOption.APPEND);
	}
	public static ArrayList<Screw> readScrewsFromFile() throws IOException {
		if(Files.exists(path)) {
		BufferedReader reader = new BufferedReader(new FileReader(pathStr));
		String data = reader.readLine();
		ArrayList<Screw> screws = new ArrayList<>();
		while(data != null) {
			String[] parameters = data.split(",");
			Screw tempScrew = new Screw(parameters[0],parameters[1],parameters[2],Float.parseFloat(parameters[3]),Float.parseFloat(parameters[4]));
			screws.add(tempScrew);
			data = reader.readLine();
		}
		reader.close();
		return screws;
		}
		return null;
	}
}
