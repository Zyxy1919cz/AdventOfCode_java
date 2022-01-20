package com.year2015;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;

import com.common.ReadFile;

public class Day3 extends ReadFile
{
	public Day3() throws IOException
	{
		ArrayList<ArrayList<Integer>> cordinatesOne = new ArrayList<ArrayList<Integer>>();
		
		String[] data = readFile(2015, 3);
		
		String str = Arrays.toString(data);
		
		int start_x = 0;
		int start_y = 0;
		int numOfHomes = 1;
		
		addElementToList(start_x, start_y, cordinatesOne);
		
		for (int i = 0; i < str.length(); i += 2)
		{
			switch(str.charAt(i))
			{
			
			case '>':
				start_x++;
				break;
			case '<':
				start_x--;
				break;
			case '^':
				start_y++;
				break;
			case 'v':
				start_y--;
				break;
			
			}
			if(!isContain(start_x, start_y, cordinatesOne))
				numOfHomes++;
			
			addElementToList(start_x, start_y, cordinatesOne);
		}
		
		start_x = 0;
		start_y = 0;
		
		for (int c = 1; c < str.length(); c += 2)
		{
			switch(str.charAt(c))
			{
			
			case '>':
				start_x++;
				break;
			case '<':
				start_x--;
				break;
			case '^':
				start_y++;
				break;
			case 'v':
				start_y--;
				break;
			
			}
			if(!isContain(start_x, start_y, cordinatesOne))
				numOfHomes++;
			addElementToList(start_x, start_y, cordinatesOne);
			
			
		}
		System.out.println(cordinatesOne.toString());
		System.out.println(numOfHomes);	
		System.out.println(cordinatesOne.size());
	}
	
	private boolean isContain(int x, int y, ArrayList<ArrayList<Integer>> list)
	{
			boolean swi = false;
			for(int i = 0; i < list.size() ; i++)
			{
				
				if((list.get(i).get(0) == x) && (list.get(i).get(1) == y))
				{
					swi = true;
					break;
				}else
				{
					swi = false;
				}
			}
			return swi;
	}
	
	private void addElementToList(int x, int y, ArrayList<ArrayList<Integer>> list)
	{
			if(!isContain(x, y, list))
				list.add(new ArrayList<Integer>(Arrays.asList(x, y)));
	}

	public static void main(String[] args) throws IOException
		{
			new Day3();
		}

}
