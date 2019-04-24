package com.maze.main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.Scanner;

import com.maze.enu.Level;
import com.maze.util.RiassebleMaze;

/**
 * 
 * @author maxp
 *
 */
public class Solution {
	 
	   
/**
 * 
 * @param args
 */
	    public static void main(String[] args) {
	    	String filePath = null;
	        
	    	System.out.println("Please, Select n*1 for input.txt ");
	        System.out.println("Please, Select n*2 for large_input.txt");
	        System.out.println("Please, Select n*3 for medium_input.txt");
	        System.out.println("Please, select n*4 for small-input.txt");
	        System.out.println("Please, select n*5 for small_wrap_input.txt");
	        System.out.println("Please, select n*6 for sparse_large.txt");
	        System.out.println("Please, select n*7 for sparse_medium.txt");
	        System.out.println("or - Ask for file path");
	        
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        
	        String selected = null;
	        
	        try {
		        	selected = reader.readLine();
		            switch (Integer.parseInt(selected)) {
		            	case 1:  
		            		filePath =   Level.imput.getDescription() ;
		            	break;
		         	
		            	case 2:  
		            		filePath =  Level.largeInput.getDescription() ;
		            	break;
		         	
		            	case 3:  
		            		filePath =  Level.mediumInput.getDescription() ;
		            	break;
		         	
		            	case 4: 
		            		filePath =  Level.smallInput.getDescription() ;
		            	break;
		         	
		            	case 5:  
		            		filePath =  Level.smallWInput.getDescription() ;
		            	break;
		            	
		            	case 6:  
		            		filePath = Level.sparseLarge.getDescription() ;
		            	break;
		            	
		            	case 7:  
		            		filePath =  Level.sparseMedium.getDescription() ;
		            	break;
		         	
		            	default: 
		            		filePath = null;
		            		System.out.println("\n\n!!!! Please. !!!!");
		            		System.out.println("\n\n!!!! Ask for file path. !!!!");
		            		Scanner userInput = new Scanner(System.in);
		            		System.out.print("Enter maze file : ");
		            		filePath = userInput.nextLine();
		            		userInput.close();
		            	break;
		         	
		          }
	            
		         if(filePath!=null) {
		        	 long startTime = System.currentTimeMillis();
		        	 RiassebleMaze rMaze =new RiassebleMaze();
		        	 rMaze.execute(filePath);
		         	 long endTime = System.currentTimeMillis();
		             long totalTime = endTime - startTime;
		             
		             System.out.println("total time: " + totalTime + "m.s.");
		         }else {
		         	System.out.println(filePath + " \"!!!! INVALID SELECTION !!!!\"");
		         }
	         
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (URISyntaxException e) {
				e.printStackTrace();
			} 
	  }  

	    
	          
	     
}
