package com.year2015;

import java.io.IOException;

import com.common.ReadFile;

public class Day5 extends ReadFile
{
	public Day5() throws IOException
	{
		String[] data = readFile(2015, 5);
		
		int numOfNiceStrings = 0;
		int numOfNiceStringsTwo = 0;
		
		for (int i = 0; i < data.length; i++)
		{
			String word = data[i];
			
			if(isNiceString(word))
				numOfNiceStrings++;
			if(isNiceStringTwo(word))
				numOfNiceStringsTwo++;
		}
		
		
		
		System.out.printf("Number of Nice strings part ONE is: %d\n\n", numOfNiceStrings);
		
		System.out.printf("Number of Nice strings part TWO is: %d", numOfNiceStringsTwo);
		
		
		
	}
	
	public static void main(String[] args) throws IOException
	{
			new Day5();
	}
	
	private boolean isNiceString(String input)
	{
			boolean have = false;
			if((haveThreeVowl(input) && isLetterTwice(input)) && !containString(input))
				have = true;
			
			return have;
	}
	
	private boolean isNiceStringTwo(String input)
	{
			boolean have = false;
			if(iscontainPairOfLeters(input) && isRepetedStepLeter(input))
				have = true;
			
			return have;
	}
	
	private boolean haveThreeVowl(String input)
	{
		boolean have = false;
		
		int numberOfVowels = 0;
		for (int i = 0; i < input.length(); i++)
		{
			if(input.charAt(i) == 'a')
				numberOfVowels++;
			if(input.charAt(i) == 'e')
				numberOfVowels++;
			if(input.charAt(i) == 'i')
				numberOfVowels++;
			if(input.charAt(i) == 'o')
				numberOfVowels++;
			if(input.charAt(i) == 'u')
				numberOfVowels++;
			
			if(numberOfVowels >= 3)
				have = true;
			
			
		}
		
		return have;
	}
	
	private boolean isLetterTwice(String input)
	{
		boolean have = false;
		for (int i = 0; i < input.length() - 1; i++)
		{
				if(input.charAt(i) == input.charAt(i + 1))
				{
					have = true;
					break;
				}
		}
			
		return have;
	}
	
	private boolean containString(String input)
	{
		boolean have = false;
		if(input.contains("ab"))
			have = true;
		if(input.contains("cd"))
			have = true;
		if(input.contains("pq"))
			have = true;
		if(input.contains("xy"))
			have = true;
			
		return have;			
	}
	
	private boolean iscontainPairOfLeters(String input)
	{
		boolean have = false;
		for(int i = 0; i < input.length() - 1; i++)
		{
			String twoLeter = input.substring(i, i + 2);
			
			for (int j = i + 2; j < input.length() - 1; j++)
			{
				String compare = input.substring(j, j + 2);
				
				if(twoLeter.contentEquals(compare))
				{
					have = true;
					break;
				}
			}
		}
		
		return have;
	}
		
	private boolean isRepetedStepLeter(String input)
	{
		boolean have = false;
		for (int i = 0; i < input.length() - 2; i++)
		{
				if(input.charAt(i) == input.charAt(i + 2))
				{
					have = true;
					break;
				}
		}
		
		return have;
	}
}