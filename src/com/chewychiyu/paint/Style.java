package com.chewychiyu.paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Style {
	
	public static Border line_border = LineBorder.createBlackLineBorder();
    public static Border bevel_border = BorderFactory.createRaisedBevelBorder();
    public static Border bevel_line_border = new CompoundBorder(bevel_border, line_border);
    
    public static TitledBorder color_bar_title = new TitledBorder(bevel_line_border,"Colors",TitledBorder.CENTER,TitledBorder.TOP);
    public static TitledBorder color_changer_title = new TitledBorder(bevel_line_border,"Hue",TitledBorder.CENTER,TitledBorder.TOP);
    public static TitledBorder misc_bar_title = new TitledBorder(bevel_line_border,"Misc",TitledBorder.CENTER,TitledBorder.TOP);
    public static TitledBorder brush_bar_title = new TitledBorder(bevel_line_border,"Brush",TitledBorder.CENTER,TitledBorder.TOP);

    public static Dimension app_dim = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
    public static Dimension tool_bar_dim = new Dimension(app_dim.width,app_dim.height/9);
	public static Dimension paint_panel_dim = new Dimension(app_dim.width,(int)(app_dim.height*.9));
	public static Dimension color_bar_dim = new Dimension(tool_bar_dim.width/4,(int)(tool_bar_dim.height*.85));
	public static Dimension color_changer_dim = new Dimension(tool_bar_dim.width/20,(int)(tool_bar_dim.height*.85));
	public static Dimension color_changer_slider_dim = new Dimension(color_changer_dim.width,(int)(color_changer_dim.height*0.8));
	public static Dimension misc_bar_dim = new Dimension(tool_bar_dim.width/20,(int)(tool_bar_dim.height*.85));
	public static Dimension brush_bar_dim = new Dimension(tool_bar_dim.width/20,(int)(tool_bar_dim.height*.85));
	public static Dimension brush_bar_slider_dim = new Dimension(brush_bar_dim.width,(int)(brush_bar_dim.height*0.8));

	public static GridLayout color_bar_layout = new GridLayout(2,5);
	public static FlowLayout tool_bar_layout = new FlowLayout(Style.FLOW_BUFFER);
	public static GridLayout misc_bar_layout = new GridLayout(2,1);

	public static final int FLOW_BUFFER = 20;
		
	public static final Font font = new Font("Aerial",Font.BOLD,10);
	
	public static final Color[] colors = new Color[10];
	public static final String[] default_color = new String[]{"255 0 0","255 127 0","255 255 0","0 255 0","0 0 255","75 0 130","148 0 211","0 0 0","255 255 255","211 211 211"};

}
