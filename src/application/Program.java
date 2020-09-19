package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class Program {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String path = "/Users/luizclaudiomoraes/temp/in.txt";
		String line;
		
		if(path.isEmpty()) {
			System.out.println("Enter file full path");
			path = sc.nextLine();
		}
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			Set<LogEntry> set = new HashSet<>();
			
			line = br.readLine();
			while(line != null){
				String[] fields = line.split(" ");
				String userName = fields[0];
				Date moment = Date.from(Instant.parse(fields[1]));
				set.add(new LogEntry(userName, moment));
				
				line = br.readLine();
			}
			
			System.out.println("Total users: " + set.size());
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			sc.close();
		}
		
	}
	
}
