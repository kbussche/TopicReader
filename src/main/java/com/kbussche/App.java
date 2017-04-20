package com.noip;

import java.io.IOException;
import java.util.HashMap;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
	Reader reader = new Reader();
	reader.init();
	reader.list();
    }

    public static void printIt()
    {
	
    }
}
