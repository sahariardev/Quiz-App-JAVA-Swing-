package com.rifat.io;

import java.util.Random;

public class RandomQuetionSelector {

	public int random (int min ,int max)
    {
        Random rn=new Random();
        return rn.nextInt((max-min)+1)+min;
    }
    public boolean isUnique(int arr[],int num)
    {
        for(int c=0;c<arr.length;c++)
        {
            if(arr[c]==num)
            {
            	//System.out.println("I am here ");
                return false;
            }
        }
        return true; 
    }
    
    public int uniqueNumber(int min ,int max,int arr[])
    {
    	int r=random(min ,max);
    	if(isUnique(arr,r))
    	{
    		
    		return r;
    	}
    	else
    	{
    		
    		return uniqueNumber(min,max,arr);
    		
    	}
    	
    }
}
