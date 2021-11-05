package Components;

import java.awt.Dimension;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class Toolbar extends JToolBar{
	public Toolbar(int Width,int Height,JButton[] Buttons,boolean Floatable) {
		super.setSize(new Dimension(Width,Height));
		super.setOrientation(SwingConstants.VERTICAL);
		super.setBackground(SystemColor.menu);
		super.setFloatable(Floatable);
		for (int i = 0; i < Buttons.length; i++) {
			 super.add(Buttons[i]);
		}
	}
}