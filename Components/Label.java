package Components;

import java.awt.Color;

import javax.swing.JLabel;

public class Label extends JLabel{
	public Label(String String,Color Foreground) {
		super.setText(String);
		super.setForeground(Foreground);
	}
}