package com.rifat.io;

import java.io.File;
import java.util.Scanner;

import com.rifat.domain.Question;

public class QuestionGenerator {

	private Question qBank[];
	public Question[] generate()
	{
		File f=new File("input.txt");
	    String arr[]=new String[12];
	    try
	    {
	    Scanner sc=new Scanner(f);
	    int i=0;
	    while(sc.hasNextLine())
	     {
	          arr[i]=sc.nextLine();
	          //System.out.println(arr[i]);
	          i++;
	     }
	    qBank=new Question[10];
	    RandomQuetionSelector rnd=new RandomQuetionSelector();
	    int queNumber[]=new int[10];
	    
	    
	    for(int c=0;c<qBank.length;c++)
	    {
	        
	    	int num=rnd.uniqueNumber(1, arr.length-1, queNumber);
	    	//System.out.println("-- "+num+" -- ");
	        
	        
	        
	        	
	            
	          //System.out.println("NUmber is Uniques and it is  "+num+" and the loop is on count : "+c);
	         
	          
	          queNumber[c]=num;
	         String questionGroup=arr[num];
	         String qGroupArr[]=questionGroup.split("!!B9QC!!");    
	         Question q=new Question(qGroupArr[0],qGroupArr[1],qGroupArr[2],qGroupArr[3],qGroupArr[4],qGroupArr[5]);
	         qBank[c]=q;
	         
	        
	    	
	    	
	    	
	        
	    }
	    
	   
	    
	    // debugging purpose 
	       for(int c=0;c<qBank.length;c++)
	    	{
	         //System.out.println(qBank[c]);
	    	}
	       return qBank;
	    
	    }
	    catch(Exception e)
	    {
	     System.out.println(e);
	     return null;
	    }
	    
	    
	 }
	
}
