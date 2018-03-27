package com.chewychiyu.paint;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class Style {
	
	public static Border line_border = LineBorder.createBlackLineBorder();
    public static Border bevel_border = BorderFactory.createRaisedBevelBorder();
    public static Border bevel_line_border = new CompoundBorder(bevel_border, line_border);
    
    public static Dimension app_dim = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
    public static Dimension tool_bar_dim = new Dimension(app_dim.width,app_dim.height/9);
	public static Dimension paint_panel_dim = new Dimension(app_dim.width,(int)(app_dim.height*.9));
	public static Dimension color_bar_dim = new Dimension(tool_bar_dim.width/4,(int)(tool_bar_dim.height*.85));

	public static final int FLOW_BUFFER = 20;
}
