package com.maze.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

import com.maze.MazeSolver;

public class RiassebleMaze {

	/**
     * 
     * @param filename
     * @throws URISyntaxException
     */
    public static void execute(String filename) throws URISyntaxException {
    	//Open file
		File fd = new File(filename);
		Scanner sc = null;
		try {
			sc = new Scanner(fd);
		} catch (FileNotFoundException e) {
			System.out.println("File not found! Application terminated\n" + e.toString());
			return;
		}
		

		int width = 0, height = 0;
		Position srt_pos, end_pos;
		int[][] maze;
		
		/*
		 * INPUT:
		 *	<WIDTH> <HEIGHT><CR>
		 *	<START_X> <START_Y><CR>		(x,y) location of the start. (0,0) is upper left and (width-1,height-1) is lower right
		 *	<END_X> <END_Y><CR>		    (x,y) location of the end
		 *	<HEIGHT> rows where each row has <WIDTH> {0,1} integers space delimited
		 * */
		
		width = sc.nextInt();
		height = sc.nextInt();
		srt_pos = new Position(sc.nextInt(), sc.nextInt());
		end_pos = new Position(sc.nextInt(), sc.nextInt());
		maze = new int[height][width];
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				maze[i][j] = sc.nextInt();	
			}
		}
		sc.close();
		
		MazeSolver ms = new MazeSolver(maze, srt_pos, end_pos);
		
		//Call solver method to find a path through the maze
		char succ = ms.solver();
		ms.print_result();
		
		if(succ != Constant.STRING_PATH)
			System.out.println("Maze can not be solved.");
		else
			System.out.println("Maze solved.");
	}
}
