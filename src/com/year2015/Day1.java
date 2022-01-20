package com.year2015;

import java.io.IOException;
import java.util.Arrays;

import com.common.ReadFile;

public class Day1 extends ReadFile
{
	public Day1() throws IOException
	{
		String[] data = readFile(2015, 1);
		
		String input = Arrays.toString(data);
		int numberOfFloor = 0;
		
		boolean heEntered = false;
		
		for (int i = 0; i < input.length(); i++)
		{
			switch(input.charAt(i))
			{
			case '(':
				numberOfFloor++;
				break;
			case ')':
				numberOfFloor--;
				break;
			default:
				break;				
			}
			
			
			if(numberOfFloor == -1 && !heEntered)
			{
				heEntered = true;
				System.out.printf("Position of character that causes Santa to enter the basement is: %d\n", i);
			}			
		}
		
		System.out.printf("Santa ends at floor number: %d", numberOfFloor);
		
	}

	public static void main(String[] args) throws IOException
		{
			new Day1();
		}

}
