package com.chewychiyu.paint;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class PaintLauncher{
	
	private Dimension app_dim = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
	private Dimension color_bar_dim = new Dimension(app_dim.width,app_dim.height/9);
	private Dimension paint_panel_dim = new Dimension(app_dim.width,(int)(app_dim.height*.9));

	
	public PaintLauncher(){
		
		JPanel master_panel = new JPanel();
		
		PaintFrame frame = new PaintFrame(app_dim);
		
		ToolBar tool_bar = new ToolBar(color_bar_dim );
		PaintPanel paint_panel = new PaintPanel(paint_panel_dim,tool_bar);

		master_panel.add(tool_bar, BorderLayout.NORTH);
		master_panel.add(paint_panel, BorderLayout.SOUTH);

		frame.addElement(master_panel);
	}
	
	
	public static void main(String[] args){
		new Storage(); //load storage from files
		new PaintLauncher();
	}
	
}
