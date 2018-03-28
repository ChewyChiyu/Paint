package com.chewychiyu.paint;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.plaf.metal.MetalButtonUI;

@SuppressWarnings("serial")
public class ColorBar extends JPanel{
	
	public JButton[] colors = new JButton[10];
	private ToolBar tool_bar;
	
	public ColorBar(ToolBar tool_bar){
		this.tool_bar = tool_bar;
		panel();
		addElements();
	}
	
	public void addElements(){
		for(int colorIndex = 0; colorIndex < colors.length; colorIndex++){
			colors[colorIndex] = new JButton(); 
			colors[colorIndex].setUI(new MetalButtonUI());
			colors[colorIndex].setBackground(Style.colors[colorIndex]);
			colors[colorIndex].setBorder(Style.bevel_border);
			add(colors[colorIndex]);
		}
		
		colors[0].addActionListener(e->{tool_bar.current_color_index = 0;});
		colors[1].addActionListener(e->{tool_bar.current_color_index = 1;});
		colors[2].addActionListener(e->{tool_bar.current_color_index = 2;});
		colors[3].addActionListener(e->{tool_bar.current_color_index = 3;});
		colors[4].addActionListener(e->{tool_bar.current_color_index = 4;});
		colors[5].addActionListener(e->{tool_bar.current_color_index = 5;});
		colors[6].addActionListener(e->{tool_bar.current_color_index = 6;});
		colors[7].addActionListener(e->{tool_bar.current_color_index = 7;});
		colors[8].addActionListener(e->{tool_bar.current_color_index = 8;});
		colors[9].addActionListener(e->{tool_bar.current_color_index = 9;});
	}
	
	public void refresh(){
		for(int colorIndex = 0; colorIndex < colors.length; colorIndex++){
			colors[colorIndex].setBackground(Style.colors[colorIndex]);
		}
	}
	
	public void panel(){
		setPreferredSize(Style.color_bar_dim);
		setBorder(Style.bevel_line_border);
		setLayout(Style.color_bar_layout);
	}
	
	public void paintComponent(Graphics g){
		
	}
	
}
