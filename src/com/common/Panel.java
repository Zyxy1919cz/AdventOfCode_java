package com.common;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class Panel extends JPanel
{
	
	
	public Panel()
	{
		setPreferredSize(new Dimension(1000, 700));
		setBackground(Color.black);
		
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawRect(20, 20, 100, 100);
		g.drawRect(100, 40, 0, 200);
	}
	
}
