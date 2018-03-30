package com.chewychiyu.paint;

import javax.swing.JComboBox;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ToolChanger extends JPanel {

	private ToolBar tool_bar;

	private final Tool[] TOOLS = new Tool[]{Tool.BRUSH, Tool.BUCKET};

	public ToolChanger(ToolBar tool_bar){
		this.tool_bar = tool_bar;
		panel();
		addElements();
	}

	public void addElements(){
		JComboBox<Tool> box = new JComboBox<Tool>(TOOLS);
		box.addActionListener(e-> {
			@SuppressWarnings("unchecked")
			JComboBox<Tool> b = (JComboBox<Tool>) e.getSource();
			Tool next_tool = (Tool) b.getSelectedItem();
			tool_bar.current_tool = next_tool;
		});
		add(box);
	}

	public void panel(){
		setBorder(Style.tool_changer_title);
		setPreferredSize(Style.tool_changer_dim);
	}


}
