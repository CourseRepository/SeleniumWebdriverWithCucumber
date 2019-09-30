package com.webdriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        int a[] = { 12, 3, 6, 1, 6, 9 };
        
        
        
        for(int i = 0; i < a.length; i++){
        	for (int j =  i + 1; j < a.length; j++){
        		for (int k = j + 1; k < a.length; k++){
        			if(a[i] + a[j] + a[k] == 24){
        				System.out.println(a[i] + ":" + a[j] + ":" + a[k]);
        			}
        		}
        	}
        }
    }
}
