package com.chewychiyu.paint;

import java.awt.BasicStroke;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JSlider;

@SuppressWarnings("serial")
public class BrushBar extends JPanel{
	
	private JSlider girth_adjust;

	private final int MAX_VAL = 30;
	private final int MIN_VAL = 1;
	private int initial_val = 10;
	private ToolBar tool_bar;
	
	public BrushBar(ToolBar tool_bar){
		this.tool_bar = tool_bar;
		panel();
		addElement();
	}
	
	public void addElement(){
		girth_adjust = new JSlider(JSlider.VERTICAL,
				MIN_VAL, MAX_VAL, initial_val);
		girth_adjust.addChangeListener(e -> {
			JSlider source = (JSlider) e.getSource();
			int girth_val = (int)source.getValue();
			tool_bar.current_stroke = new BasicStroke(girth_val , BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		});
		girth_adjust.setPreferredSize(Style.brush_bar_slider_dim);
		add(girth_adjust, BorderLayout.NORTH);
	}
	
	public void panel(){
		setPreferredSize(Style.brush_bar_dim);
		setBorder(Style.brush_bar_title);
	}
	
}
