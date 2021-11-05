package Components;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class Textarea extends JTextArea{
	public Textarea(int Columns,int Rows,Color Foreground,Color Border) {
		Border border = BorderFactory.createLineBorder(Border);
		super.setColumns(Columns);
		super.setRows(Rows);
		super.setForeground(Foreground);
		super.setBorder(border);
	}
}
