package com.year2015;

import java.io.IOException;
import java.util.Arrays;

import com.common.ReadFile;

public class Day2 extends ReadFile
{
	public Day2() throws IOException
	{
					int feetsOfPaper = 0;
					int feetsOfRibbon = 0;
					String[] data = readFile(2015, 2);
					
					for (String str : data)
					{
						String[] cut = str.split("x");
						
						int[] cutarr = new int[cut.length];
						for(int i = 0; i < cut.length; i++)
						{
							cutarr[i] = Integer.parseInt(cut[i]);
						}
						
						Arrays.sort(cutarr);
						int sum_paper = 2 * (cutarr[0] * cutarr[1] + cutarr[1] * cutarr[2] + cutarr[2] * cutarr[0]) + cutarr[0] * cutarr[1];
						int sum_ribbon =(cutarr[0] + cutarr[0] + cutarr[1] + cutarr[1]) + (cutarr[0] * cutarr[1] * cutarr[2]);
						
						feetsOfPaper += sum_paper;
						feetsOfRibbon += sum_ribbon;
						
						
					}
					System.out.printf("Feets of paper to order is: %d.\nFeets of ribbon to order is: %d." ,feetsOfPaper, feetsOfRibbon);
	}

	public static void main(String[] args) throws IOException
	{
		new Day2();
		
	}

}
