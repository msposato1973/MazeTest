package com.maze;

import com.maze.util.Constant;
import com.maze.util.Position;

public class MazeSolver {

	private char[][] result;	//The solution
	private Position srt_pos, end_pos;
	private int[][] maze;
	
	public MazeSolver(int[][] maze, Position srt_pos, Position end_pos) {
		this.maze = maze;
		this.srt_pos = srt_pos;
		this.end_pos = end_pos;
		result = new char[maze.length][maze[0].length];
	}
	
	/**
	 * 
	 * The maze with the selected path from
	 * starting to ending point.
	 * 
	 * @return char[][] the maze with the path
	 */
	public char[][] getResult() {
		return result;
	}
	
	/**
	 * Starts by editing the result field by adding '#'
	 * character in the same position where the maze is 1.
	 * Then adds a 'S' and 'E' character at the starting and
	 * ending point.
	 * 
	 * Solves the maze by using the path_finder method.
	 * 
	 * Removes the 'N' characters (used to highlight dead-end paths)
	 * and adds once more the 'S' and 'E' characters. (Previously 
	 * removed by the path_finder method) 
	 * 
	 * @return char 'X' if the maze was solved, 'N' alternatively
	 * 
	 */
	public char solver(){
		//Create walls and the start and end points.
		result[srt_pos.getX()][srt_pos.getY()] =  Constant.STRING_START ;
		result[end_pos.getX()][end_pos.getY()] = Constant.STRING_END;
		
		for(int i=0; i<maze.length; i++) {
			for(int j=0; j<maze[i].length; j++)	{
				if(maze[i][j] == 1) result[i][j] = Constant.STRING_WALL;
			}
		}	
		//Recursively find a correct path from S to E
		char succ = getFindPath(maze, srt_pos);
		
		//Clear the result
		for(int i=0; i<maze.length; i++) {
			for(int j=0; j<maze[i].length; j++)	{
				if(result[i][j] == Constant.STRING_NORD) result[i][j] = ' ';	
			}	
		}
		
		result[srt_pos.getX()][srt_pos.getY()] = Constant.STRING_START  ;
		result[end_pos.getX()][end_pos.getY()] = Constant.STRING_END;
		
		return succ;
	}
	
	/**
	 * Print the result 2d array
	 * 
	 */
	public void print_result(){
		for(int i=0; i<result.length; i++) {
			for(int j=0; j<result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * A method that finds a successful path from the starting
	 * to the ending point using recursion.
	 * 
	 * @param maze The maze that needs to be solved.
	 * @param pos The starting position.
	 * @return char 'N' if the path is a dead-end, 'X' alternatively
	 */
	private char getFindPath(int[][] maze, Position pos){
		
		if(result[pos.getY()][pos.getX()] == Constant.STRING_END) {
			return Constant.STRING_PATH;	//Found the end.
		}else {
			
			char c = 0;
			result[pos.getY()][pos.getX()] = Constant.STRING_VISITED;	//Visited
			
			int offset = pos.getY() + 1;
			if(offset >= maze.length) offset = 0;
			
			char south = result[offset][pos.getX()];
			if(south == 0 || south == Constant.STRING_END){
				//Go south
				c = getFindPath(maze, new Position(offset, pos.getX()));
				result[offset][pos.getX()] = c;
				if(c == Constant.STRING_PATH) return Constant.STRING_PATH;
			}
			
			offset = pos.getX() + 1;
			if(offset >= maze[0].length) offset = 0;
			
			char east = result[pos.getY()][offset];
			if(east == 0 || east == Constant.STRING_END){
				//Go east
				c = getFindPath(maze, new Position(pos.getY() , offset));
				result[pos.getY()][offset] = c;
				if(c == Constant.STRING_PATH) return Constant.STRING_PATH;
			}
			
			offset = pos.getX() - 1;
			if(offset < 0) offset = maze[0].length - 1;
			
			char west = result[pos.getY()][offset];
			if(west == 0 || west == Constant.STRING_END){
				//Go west
				c = getFindPath(maze, new Position(pos.getY() , offset));
				result[pos.getY()][offset] = c;
				if(c == Constant.STRING_PATH) return Constant.STRING_PATH;
			} 
			
			offset = pos.getY() - 1;
			if(offset < 0) offset = maze.length - 1;
			
			char north = result[offset][pos.getX()];
			if(north == 0 || north == Constant.STRING_END){
				//Go north
				c = getFindPath(maze, new Position(offset, pos.getX()));
				result[offset][pos.getX()] = c;
				if(c == Constant.STRING_PATH) return Constant.STRING_PATH;
			}
			
		}
		
		return Constant.STRING_NORD;	//Dead-end go back
		
	}
}