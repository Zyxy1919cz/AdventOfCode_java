package com.year2015;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import com.common.ReadFile;

public class Day7 extends ReadFile
{
	public Day7() throws IOException
	{
		String[] data = readFile(2015, 7);
		
		String[] reverse = new String[data.length];
		
		
		
		Arrays.sort(reverse);
		
		System.out.println(Arrays.toString(reverse));
		
		HashMap<String, Integer> cuircut = new HashMap<String, Integer>();
		
//		for (String split : data)
//		{
//			String[] strArr = split.replace(" -> ", " ").split(" ");
//			choise(strArr, cuircut);
//		}
//		
//		System.out.printf("Stored signals at identifiers are: %s\n" ,cuircut);
//		
//		System.out.printf("Signal at a is: %s", cuircut.get("a"));
	}

	public static void main(String[] args) throws IOException
		{
			new Day7();
		}

	private void choise(String[] input, HashMap<String, Integer> in)
	{			
		if(input.length == 2)
		{
			operationSet(input[1], Integer.parseInt(input[0]), in);

		}else if(input.length == 3)
		{
			operationNOT(input, in);
			
		}else if(input.length == 4)
		{
			if(input[1].contains("AND"))
				operationAND(input, in);
			if(input[1].contains("OR"))
				operationOR(input, in);
			if(input[1].contains("LSHIFT"))
				operationLSHIFT(input, in);
			if(input[1].contains("RSHIFT"))
				operationRSHIFT(input, in);
		}
	}
	
	private void operationSet(String identifier, Integer signalIn, HashMap<String, Integer> in)
	{		
		in.put(identifier, signalIn);
	}
	
	private void operationNOT(String[] input, HashMap<String, Integer> in)
	{
		Integer signal = in.get(input[1]) ^ 65535;
		
		if(in.containsKey(input[2]))
		{
			in.replace(input[2], in.get(input[2]), signal);
		}else
		{
			operationSet(input[2], signal, in);
		}
	}
	
	private void operationAND(String[] input, HashMap<String, Integer> in)
	{
		int a = in.get(input[0]);
		int b = in.get(input[2]);
		
		Integer signal = a & b;
		
		if(in.containsKey(input[3]))
		{
			in.replace(input[3], in.get(input[3]), signal);
		}else
		{
			operationSet(input[3], signal, in);
		}
	}
	
	private void operationOR(String[] input, HashMap<String, Integer> in)
	{
			int a = in.get(input[0]);
			int b = in.get(input[2]);
			
			Integer signal = a | b;
			
			if(in.containsKey(input[3]))
			{
				in.replace(input[3], in.get(input[3]), signal);
			}else
			{
				operationSet(input[3], signal, in);
			}
	}
	
	private void operationLSHIFT(String[] input, HashMap<String, Integer> in)
	{
			int a = in.get(input[0]);
			int b = Integer.parseInt(input[2]);
			
			Integer signal = a << b;
			
			if(in.containsKey(input[3]))
			{
				in.replace(input[3], in.get(input[3]), signal);
			}else
			{
				operationSet(input[3], signal, in);
			}
	}
	
	private void operationRSHIFT(String[] input, HashMap<String, Integer> in)
	{
			int a = in.get(input[0]);
			int b = Integer.parseInt(input[2]);
			
			Integer signal = a >>> b;
			
			if(in.containsKey(input[3]))
			{
				in.replace(input[3], in.get(input[3]), signal);
			}else
			{
				operationSet(input[3], signal, in);
			}
	}
}
