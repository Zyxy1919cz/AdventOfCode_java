package com.year2015;

import java.io.IOException;

import com.common.ReadFile;

public class Day8 extends ReadFile
{
	public Day8() throws IOException
	{
		String[] data = readFile(2015, 8);
		
		int[] resultOfUncode = new int[2];
		int[] resultOfDecode = new int[2];
			
		for (String strArr : data)
		{
			resultOfUncode[0] += countOfChars(strArr)[0];
			resultOfUncode[1] += countOfChars(strArr)[1];
		}
		
		for (String strArr : data)
		{			
			String decode = decodeString(strArr);
			
			System.out.println(decode);
			
			resultOfDecode[0] += countOfChars(decode)[0];
			resultOfDecode[1] += countOfChars(decode)[1];
		}
		
		System.out.printf("Number of characters in CODE is: %d\n", resultOfUncode[0]);
		System.out.printf("Number of characters in STRING is: %d\n", resultOfUncode[1]);
		
		int sum = resultOfUncode[0] - resultOfUncode[1];
		System.out.printf("Total size is: %d\n", sum);
	}

	public static void main(String[] args) throws IOException
		{
			new Day8();
		}

	private int[] countOfChars(String input)
	{
			int[] sum = new int[2];
			
			int code = 0;
			int string = 0;
			
			for (int i = 0; i < input.length(); i++)
			{
				switch(input.charAt(i))
				{
				case '"':
					code++;
					break;
				case '\\':
					if(input.charAt(i + 1) == '\\')
					{
						i++;
						code += 2;
						string++;
						break;
					}else if(input.charAt(i + 1) == 'x')
					{
						i += 3;
						code += 4;
						string++;
						break;
					}
					code++;
					string++;
					
					break;
				default:
					code++;
					string++;
					break;
				}					
			}
			
			sum[0] = code;
			sum[1] = string;
			
			return sum;
	}
	
	private String decodeString(String input)
	{
		StringBuffer decoded = new StringBuffer(input);
		
		for (int i = 0; i < decoded.length(); i++)
		{
			switch (decoded.charAt(i))
			{
			case '\\':
				if (decoded.charAt(i + 1) == '"')
				{
					decoded.replace(i, i, "\\\\\\");
				}else
					decoded.replace(i, i, "\\\\");
				break;
			default:
				break;
			}
		}
		
		decoded.replace(0, 0, Character.toString('"') + "\\" + Character.toString('"'));
		decoded.replace(decoded.lastIndexOf(Character.toString('"')), decoded.lastIndexOf(Character.toString('"')) , "\\" + Character.toString('"') + Character.toString('"'));
		
		System.out.println(decoded.toString());
		
		return decoded.toString();
	}
}
