package com.chewychiyu.paint;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class Style {
	
	public static Border line_border = LineBorder.createBlackLineBorder();
    public static Border bevel_border = BorderFactory.createRaisedBevelBorder();
    public static Border bevel_line_border = new CompoundBorder(bevel_border, line_border);
    
}
