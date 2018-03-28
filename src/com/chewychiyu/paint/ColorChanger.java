package com.chewychiyu.paint;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JSlider;

@SuppressWarnings("serial")
public class ColorChanger extends JPanel{

	private JSlider color_adjust;

	private final int MAX_VAL = 90;
	private final int MIN_VAL = -90;
	private int initial_val = 0;
	private ToolBar tool_bar;

	public ColorChanger(ToolBar tool_bar){
		this.tool_bar = tool_bar;
		panel();
		addElements();
	}

	public void addElements(){
		color_adjust = new JSlider(JSlider.VERTICAL,
				MIN_VAL, MAX_VAL, initial_val);
		color_adjust.addChangeListener(e -> {
			JSlider source = (JSlider) e.getSource();
			float hue_level = (float)source.getValue();
			adjustHue(hue_level/100);
		});
		color_adjust.setPreferredSize(Style.color_changer_slider_dim);
		add(color_adjust, BorderLayout.NORTH);
	}

	public void adjustHue(float value){
		for(int colorIndex = 0; colorIndex < Style.colors.length; colorIndex++){
			Color c = Storage.string_to_color(Style.default_color[colorIndex]);
			
			int red = c.getRed(), green = c.getGreen(), blue = c.getBlue();
			
			red = (int) (red + (red * value));
			green = (int) (green + (green * value));
			blue = (int) (blue + (blue * value));

			if(red>255){red=255;}
			if(green>255){green=255;}
			if(blue>255){blue=255;}
			
			Style.colors[colorIndex] = new Color(red,green,blue);
		}
		
		tool_bar.color_bar.refresh();
	}

	public void panel(){
		setPreferredSize(Style.color_changer_dim);
		setBorder(Style.color_changer_title);
	}

}
