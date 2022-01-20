package com.year2019;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.common.ReadFile;
import com.common.Window;

public class Day3 extends ReadFile
{
	private Point2D start = new Point2D.Float(0, 0);
	private Point2D min;
	private List<Line2D> lines1 = new ArrayList<Line2D>();
	private List<Line2D> lines2 = new ArrayList<Line2D>();
	private List<Point2D> points = new ArrayList<Point2D>();

	private Window window;

	public Day3() throws IOException
	{

		init();

		String[] data = readFile(2019, 3);

		String[] half1 = data[0].split(",");
		String[] half2 = data[1].split(",");

		for (int i = 0; i < half1.length; i++)
		{
			determinate(lines1, half1[i], i);
			paint(window.getPanel().getGraphics(), lines1.get(i), Color.red);
		}

		for (int i = 0; i < half2.length; i++)
		{
			determinate(lines2, half2[i], i);
			paint(window.getPanel().getGraphics(), lines2.get(i), Color.blue);
		}

		for (int i = 0; i < lines1.size(); i++)
		{
			for (int j = 1; j < lines2.size(); j++)
			{
				Point2D pon = getCollisionPoint(lines1.get(i), lines2.get(j));
				if (pon != null)
				{
					points.add(pon);
				}
			}
		}

		System.out.println(calcMinManhhatanDist());

		ArrayList<ArrayList<Integer>> numberOfSteps = new ArrayList<ArrayList<Integer>>();

		System.out.println(points.toString());

		int lineStep1 = 0;
		int lineStep2 = 0;
		
		Integer[][] garb = new Integer[points.size()][2];
		
			for (int i = 0; i < lines1.size(); i++)
			{
				for (int j = 0; j < points.size(); j++)
				{
					if(lines1.get(i).ptLineDistSq(points.get(j)) == 0.0)
					{
						System.out.println("here");
						lineStep1 += calcSteps(lines1.get(i), points.get(j));
						System.out.println(calcSteps(lines1.get(i), points.get(j)));
						i++;
						garb[j][0] = lineStep1;
						break;
					}else
					{
						j++;
						continue;
					}
				}
				lineStep1 += calcSteps(lines1.get(i));
				System.out.println(calcSteps(lines1.get(i)));
				
				
			}
			
			System.out.println(lineStep1);	
			System.out.println(garb[1][0]);
		}		

//		numberOfSteps.sort(null);
//		System.out.println(numberOfSteps.toString());
//
//		System.out.println(numberOfSteps.get(0));

	private int calcMinManhhatanDist()
	{
		min = points.get(0);

		for (int i = 1; i < this.points.size(); i++)
		{
			if (!((Math.abs(min.getX())
					+ Math.abs(min.getY())) < (int) (Math.abs(points.get(i).getX()) + Math.abs(points.get(i).getY()))))
				min = points.get(i);
		}

		return (int) (Math.abs(min.getX()) + Math.abs(min.getY()));
	}

	private int calcSteps(Line2D line)
	{
		return (int) (Math.abs(line.getX1() - line.getX2()) + Math.abs(line.getY1() - line.getY2()));
	}

	private int calcSteps(Line2D line, Point2D point)
	{
		return (int) (Math.abs(line.getX1() - point.getX()) + Math.abs(line.getY1() - point.getY()));
	}

	private void init()
	{
		window = new Window("Day3");
	}

	private void determinate(List<Line2D> lines, String input, int i)
	{
		double xStart = this.start.getX(), yStart = this.start.getY(), xCoor, yCoor;

		if (i == 0)
		{
			xCoor = xStart;
			yCoor = yStart;

		} else
		{
			xCoor = lines.get(i - 1).getX2();
			yCoor = lines.get(i - 1).getY2();
			xStart = lines.get(i - 1).getX2();
			yStart = lines.get(i - 1).getY2();
		}

		switch (input.charAt(0))
		{
		case 'D':
			yCoor += strToInt(input);
			break;
		case 'U':
			yCoor -= strToInt(input);
			break;
		case 'L':
			xCoor += strToInt(input);
			break;
		case 'R':
			xCoor -= strToInt(input);
			break;
		}

		Line2D line = new Line2D.Float();
		line.setLine(xStart, yStart, xCoor, yCoor);

		lines.add(line);
	}

	public int strToInt(String input)
	{
		input = input.replaceAll("[^\\d]", "").trim();
		return Integer.parseInt(input);
	}

	public void paint(Graphics g, Shape s, Color color)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		g2.draw(s);
	}

	public static Point2D getCollisionPoint(Line2D line1, Line2D line2)
	{
		if (line1.intersectsLine(line2))
		{
			double a1 = line1.getY2() - line1.getY1();
			double b1 = line1.getX1() - line1.getX2();
			double c1 = (a1 * line1.getX1()) + (b1 * line1.getY1());

			double a2 = line2.getY2() - line2.getY1();
			double b2 = line2.getX1() - line2.getX2();
			double c2 = (a2 * line2.getX1()) + (b2 * line2.getY1());

			double delta = (a1 * b2) - (a2 * b1);

			return new Point2D.Double(((b2 * c1) - (b1 * c2)) / delta, ((a1 * c2) - (a2 * c1)) / delta);
		}
		return null;
	}

	public static void main(String[] args) throws IOException
	{
		new Day3();
	}
}
