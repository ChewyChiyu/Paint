package com.chewychiyu.paint;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MiscBar extends JPanel{
	
	private ToolBar tool_bar;
	
	public MiscBar(ToolBar tool_bar){
		this.tool_bar = tool_bar;
		panel();
		addElements();
	}
	
	public void addElements(){
		JButton clear = new JButton("Clear");
		JButton exit = new JButton("Exit");

		clear.addActionListener(e->{tool_bar.paint_panel.clear();});
		exit.addActionListener(e->{System.exit(0);});
		
		add(clear);
		add(exit);
	}
	
	public void panel(){
		setPreferredSize(Style.misc_bar_dim);
		setBorder(Style.misc_bar_title);
		setLayout(Style.misc_bar_layout);
	}
	
}
