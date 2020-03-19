package com.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileDAO {
	private File dir=new File("src\\com.project");
	private File file=new File("dir","filenames.txt");
	private Scanner sc=null;
	private PrintStream ps=null;
	
	private static FileDAO instance =new FileDAO();
	
	public static FileDAO getInstance() {
		return instance;
	}
	
	public ArrayList<String> getFilePath(){
		ArrayList<String> filePath=new ArrayList<String>();
		try {
			sc=new Scanner(file);
			while(sc.hasNextLine()) {
				filePath.add(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			closeConnection(sc,ps);
		}		
		return filePath;
	}
	
	public ArrayList<String> getFileName(){
		ArrayList<String> fileName=new ArrayList<String>();
		String tmp="";
		try {
			sc=new Scanner(file);
			while(sc.hasNextLine()) {
				
				fileName.add(tmp);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			closeConnection(sc, ps);
		}
		return null;
	}
	
	private void closeConnection(Scanner sc, PrintStream ps) {
		if(sc!=null) sc.close();
		if(ps!=null) ps.close();
	}
}
