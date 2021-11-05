package Components;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Textfield extends JTextField{
	public Textfield(int Columns,Color Foreground, Color Border) {
		Border border = BorderFactory.createLineBorder(Border);
		super.setColumns(Columns);
		super.setForeground(Foreground);
		super.setBorder(border);
	}
}