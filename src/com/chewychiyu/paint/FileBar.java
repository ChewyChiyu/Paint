package com.chewychiyu.paint;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class FileBar extends JPanel{
	
	private ToolBar tool_bar;
	
	public FileBar(ToolBar tool_bar){
		this.tool_bar = tool_bar;
		panel();
		addElements();
	}
	
	public void addElements(){
		JButton save = new JButton("Save");
		JButton open = new JButton("Open");
		save.addActionListener(e -> {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Choose Directory");   
			int user_selection = fileChooser.showSaveDialog(getRootPane());
			if (user_selection == JFileChooser.APPROVE_OPTION) {
			    File fileToSave = fileChooser.getSelectedFile();
			    try{ImageIO.write(tool_bar.paint_panel.canvas,"png",fileToSave);}catch(Exception a) { }
			}
		});
		open.addActionListener(e->{
			 JFileChooser chooser = new JFileChooser();
		        FileFilter image_filter = new FileNameExtensionFilter(
		        	    "Image files", ImageIO.getReaderFileSuffixes());
		        chooser.setFileFilter(image_filter);
		        int user_selection = chooser.showOpenDialog(null);
		        if(user_selection == JFileChooser.APPROVE_OPTION) {
		           try{
		        	   BufferedImage image = ImageIO.read(chooser.getSelectedFile());
		        	   tool_bar.paint_panel.mask(image);
		           }catch(Exception a){}
		        }
		});
		
		add(save);
		add(open);
	}
	
	public void panel(){
		setPreferredSize(Style.file_bar_dim);
		setLayout(Style.file_bar_layout);
		setBorder(Style.file_bar_title);
	}
	
}
