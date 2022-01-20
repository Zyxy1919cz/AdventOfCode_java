package com.year2015;

import java.io.IOException;
import java.util.Arrays;

import com.common.ReadFile;

public class Day6 extends ReadFile
{
	public Day6() throws IOException
	{
		Boolean[][] lightBulbs = new Boolean[1000][1000];
		
		for (int i = 0; i < 1000; i++)
		{
			Arrays.fill(lightBulbs[i], false);
		}
		
		String[] data = readFile(2015, 6);
		
		for (String str : data)
		{
			int[] arr = choise(str);
			
			setLightBulbs(arr[0], arr[1], arr[2], arr[3], arr[4], lightBulbs);
		}
		
		int numberLightsOn =0;
		
		for (int i = 0; i < 1000; i++)
		{
			for (int j = 0; j < 1000; j++)
			{
				if(lightBulbs[i][j])
					numberLightsOn++;
			}
		}
		
		System.out.printf("Number of lights ON is: %d\n", numberLightsOn);
	}
	
	public void day6half() throws IOException
	{
		Integer[][][] lightBulbBrightnes = new Integer[1000][1000][1];
		
		for (int i = 0; i < 1000; i++)
		{
			for (int j = 0; j < 1000; j++)
			{
				lightBulbBrightnes[i][j][0] = 0;
			}
		}
		
		String[] data = readFile(2015, 6);
		
		for (String str : data)
		{
			int[] arr = choise(str);
			
			setLightBulbsBrightnes(arr[0], arr[1], arr[2], arr[3], arr[4], lightBulbBrightnes);
		}
		
		int brightnesOfLightBulbs = 0;
		for (int i = 0; i < 1000; i++)
		{
			for (int j = 0; j < 1000; j++)
			{
				brightnesOfLightBulbs += lightBulbBrightnes[i][j][0];
			}
		}
		
		System.out.printf("Brightnes of lights is: %d", brightnesOfLightBulbs);
	}

	public static void main(String[] args) throws IOException
		{
			Day6 day = new Day6();
			day.day6half();
			
		}
	
	private int[] choise(String input)
	{
			String[] cut = input.replace("through", ",").replaceAll("[^0-9,]", "").split(",");
			int[] arr = new int[5];
			
			for(int i = 0; i < cut.length; i++)
			{
				arr[i] = Integer.parseInt(cut[i]);
			}
			
			if(input.contains("turn on"))
				arr[4] = 1;
			if(input.contains("turn off"))
				arr[4] = 0;
			if(input.contains("toggle"))
				arr[4] = 2;
			
			return arr;
	}
		
	private void setLightBulbs(int x, int y, int tox, int toy, int toggle, Boolean[][] boolea)
	{
			
		
		for (int i = x; i <= tox; i++)
		{
			for (int j = y; j <= toy; j++)
			{
				 if(toggle == 0)
				 {
					 boolea[i][j] = false;
				 }
				 else if(toggle == 1)
				 {
					 boolea[i][j] = true; 
				 }
				 else
				 {
					if(boolea[i][j]) 
					{
						boolea[i][j] = false;
					}
					else
						boolea[i][j] = true;
				 }
			}
		}
	}
	
	private void setLightBulbsBrightnes(int x, int y, int tox, int toy, int toggle, Integer[][][] integer)
	{
		for (int i = x; i <= tox; i++)
		{
			for (int j = y; j <= toy; j++)
			{
				if(toggle == 0)
				{
					if((integer[i][j][0] - 1) < 0)
					{
						integer[i][j][0] = 0;
					}else
					{
						integer[i][j][0] -= 1;
					}
				}					
				if(toggle == 1)
					integer[i][j][0] += 1;
				if(toggle == 2)
					integer[i][j][0] += 2;
			}
		}
	}
}


