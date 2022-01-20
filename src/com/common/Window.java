package com.common;

import javax.swing.JFrame;

public class Window extends JFrame
{
	private Panel panel;
	
	public Window(String title)
	{
		super(title);
		panel = new Panel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(panel);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		
		setVisible(true);		
	}
	
	

	public Panel getPanel()
	{
		return panel;
	}
}
