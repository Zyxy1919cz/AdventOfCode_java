package com.common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReadFile
{	
	public int year, day;
	
	protected static String[] readFile(int year, int day) throws IOException
	{
			List<String> lines = new ArrayList<String>();
			
			BufferedReader input = null;
			
			
			try
			{
				input = Files.newBufferedReader(Path.of(ReadFile.class.getResource("/" + year + "/day" + day + ".txt").toURI()), StandardCharsets.UTF_8);
							
				String line = input.toString();
				
				while((line = input.readLine()) != null)
				{
					lines.add(line);
				}
				
					
			}catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("C");
			
			}catch (URISyntaxException e) {
				e.printStackTrace();
				
			}finally {
				input.close();
			}
			
				
			return lines.toArray(new String[0]);
	}

}
