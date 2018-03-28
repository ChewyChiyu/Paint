package com.chewychiyu.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
@SuppressWarnings("serial")
public class PaintPanel extends JPanel{

	public ToolBar tool_bar;

	private List<Stroke> strokes = new ArrayList<Stroke>();

	private Point mouse = new Point();



	public PaintPanel(){
		panel();
		brush();
	}

	public void brush(){	
		MouseAdapter mouse_adapter = new MouseAdapter(){

			Stroke s;

			@Override
			public void mousePressed(MouseEvent e) {
				switch(tool_bar.current_tool){
				case BRUSH:
					s = new Stroke(Style.colors[tool_bar.current_color_index], tool_bar.current_stroke);
					s.add(e.getPoint());
					strokes.add(s);
					break;
				default:
					break;

				}
				repaint();
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				switch(tool_bar.current_tool){
				case BRUSH:
					s.add(e.getPoint());
					break;
				default:
					break;

				}
				repaint();
			}

			@Override
			public void mouseReleased(MouseEvent e){
				switch(tool_bar.current_tool){
				case BRUSH:
					s.add(e.getPoint());
					break;
				default:
					break;

				}
				repaint();

			}

			public void mouseMoved(MouseEvent e){
				mouse = e.getPoint();
				repaint();
			}
		};

		addMouseListener(mouse_adapter);
		addMouseMotionListener(mouse_adapter);
	}

	public void panel(){
		setPreferredSize(Style.paint_panel_dim);
		setBackground(Color.WHITE);
	}

	public void clear(){
		strokes.clear();
		repaint();
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		stroke(g2d);	
		cursor(g2d);
	}

	public void cursor(Graphics2D g2d){
		switch(tool_bar.current_tool){
		case BRUSH:
			int delta  = tool_bar.brush_bar.value;
			g2d.setColor(Style.colors[tool_bar.current_color_index]);
			g2d.fillOval(mouse.x-delta/2, mouse.y-delta/2, delta, delta);
			break;
		default:
			break;

		}
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
