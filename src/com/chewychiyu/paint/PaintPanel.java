package com.chewychiyu.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import javax.swing.JPanel;
@SuppressWarnings("serial")
public class PaintPanel extends JPanel{

	public ToolBar tool_bar;

	private Stroke stroke;

	private Point mouse = new Point();

	public BufferedImage canvas = new BufferedImage(Style.paint_panel_dim.width,Style.paint_panel_dim.height,BufferedImage.TYPE_INT_RGB);
	private Graphics2D canvas_graphics = (Graphics2D) canvas.getGraphics();

	public PaintPanel(){
		panel();
		click();
		clear();
	}

	public void click(){	
		MouseAdapter mouse_adapter = new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				switch(tool_bar.current_tool){
				case BRUSH:
					stroke = new Stroke(Style.colors[tool_bar.current_color_index],tool_bar.current_stroke);
					stroke.add(e.getPoint());

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
					if(stroke.size()>Stroke.MAX_LENGTH){
						stroke.truncate();
					}
					stroke.add(e.getPoint());
					stroke(canvas_graphics);
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
					stroke.add(e.getPoint());
					stroke(canvas_graphics);
					break;
				case BUCKET:
					bucketFill(e.getPoint());
					break;
				default:
					break;

				}
				repaint();
			}

			public void mouseMoved(MouseEvent e){
				mouse =  e.getPoint();
				repaint();
			}
		};
		addMouseListener(mouse_adapter);
		addMouseMotionListener(mouse_adapter);
	}

	public void panel(){
		setPreferredSize(Style.paint_panel_dim);
	}

	public void clear(){
		if(stroke!=null){stroke.clear();}
		canvas_graphics.setColor(Style.WHITE); 
		canvas_graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		repaint();
	}

	public void mask(BufferedImage image){
		clear();
		canvas = image;
		canvas_graphics = (Graphics2D) canvas.getGraphics();
	}

	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		render(g2d);
		render(canvas_graphics);
		canvas(g2d);
		cursor(g2d);
		g2d.dispose();
	}

	public void render(Graphics2D g2d){
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
	}

	public void canvas(Graphics2D g2d){
		g2d.drawImage(canvas,0,0,canvas.getWidth(),canvas.getHeight(),this);
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
		if(stroke==null||stroke.isEmpty()) { return; }
		g2d.setColor(stroke.c);
		g2d.setStroke(stroke.girth);
		for(int index = 0; index < stroke.size()-1; index++){
			Point draw_from = stroke.get(index);
			Point draw_to = stroke.get(index+1);
			g2d.drawLine(draw_from.x, draw_from.y, draw_to.x, draw_to.y);
		}
	}

	public void bucketFill(Point mouse){
		if(mouse.x < 0 || mouse.x > canvas.getWidth() || mouse.y < 0 || mouse.y > canvas.getHeight() ){ return; }
		canvas_graphics.setColor(Style.colors[tool_bar.current_color_index]);
		int seek = canvas.getRGB(mouse.x, mouse.y);
		if(seek == Style.colors[tool_bar.current_color_index].getRGB()){ return; }
		LinkedList<Point> pixels = new LinkedList<Point>();
		pixels.addFirst(mouse);
		while(!pixels.isEmpty()){
			Point pixel = pixels.removeFirst();
			if(canvas.getRGB(pixel.x, pixel.y) == seek){
				canvas_graphics.fillRect(pixel.x, pixel.y, 1, 1);
				if(pixel.x-1 > 0 && canvas.getRGB(pixel.x-1, pixel.y) == seek){
					pixels.addLast(new Point(pixel.x-1,pixel.y));
				}
				if(pixel.y-1 > 0 && canvas.getRGB(pixel.x, pixel.y-1) == seek){
					pixels.addLast(new Point(pixel.x,pixel.y-1));
				}
				if(pixel.x+1 < canvas.getWidth() && canvas.getRGB(pixel.x+1, pixel.y) == seek){
					pixels.addLast(new Point(pixel.x+1,pixel.y));
				}
				if(pixel.y+1 < canvas.getHeight() && canvas.getRGB(pixel.x, pixel.y+1) == seek){
					pixels.addLast(new Point(pixel.x,pixel.y+1));
				}
			}
		}
	}
}
