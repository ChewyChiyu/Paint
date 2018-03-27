package com.chewychiyu.paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
@SuppressWarnings("serial")
public class PaintPanel extends JPanel{
	
	private Dimension dim;
	private ToolBar tool_bar;
	
	private List<Stroke> strokes = new ArrayList<Stroke>();
	
	
	public PaintPanel(Dimension dim, ToolBar tool_bar){
		this.tool_bar = tool_bar;
		this.dim = dim;
		panel();
		brush();
	}
	
	public void brush(){
		
		MouseAdapter mouse_adapter = new MouseAdapter(){
			
			Stroke s;
			
            @Override
            public void mousePressed(MouseEvent e) {
            		s = new Stroke(tool_bar.current_color, tool_bar.current_stroke);
            		s.add(e.getPoint());
            		strokes.add(s);
                repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
            		s.add(e.getPoint());
                repaint();
            }
            
            
		};
		
		addMouseListener(mouse_adapter);
        addMouseMotionListener(mouse_adapter);
	}
	
	
	public void panel(){
		setPreferredSize(dim);
		setBackground(Color.WHITE);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		stroke(g2d);
		
	}
	
	public void stroke(Graphics2D g2d){
		if(strokes.isEmpty()) { return; }
		for(int strokeIndex = 0; strokeIndex < strokes.size(); strokeIndex++){
			Stroke stroke = strokes.get(strokeIndex);
			g2d.setColor(stroke.c);
			g2d.setStroke(stroke.girth);
			for(int index = 0; index < stroke.size()-1; index++){
				Point draw_from = stroke.get(index);
				Point draw_to = stroke.get(index+1);
				g2d.drawLine(draw_from.x, draw_from.y, draw_to.x, draw_to.y);
			}
		}
	}
}