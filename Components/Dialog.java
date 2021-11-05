package Components;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import Colors.colors;

public class Dialog extends JDialog{
	public static ArrayList<JPanel> buttonComponents = new ArrayList<JPanel>();
	public static ArrayList<JButton> buttonsComponent = new ArrayList<JButton>();
	public static ArrayList<JDialog> dialog = new ArrayList<JDialog>();
	private void close() {
		super.dispose();
	} 
	public Dialog(int X,int Y, int Width,int Height,String Title,String Message,MouseListener eventYes) {
		super.setBounds(X, Y, Width, Height);
		super.setTitle(Title);
		JPanel closingMessage = new JPanel();
	    JPanel closingButtons = new JPanel();
	    JButton Yes = new  Components.Button(28, "Yes", true, colors.Black,colors.white, eventYes);
	    closingButtons.add(Yes);
	    closingMessage.add(new Components.Label(Message, colors.Black));
	    super.getContentPane().add(closingMessage, BorderLayout.CENTER);
	    super.getContentPane().add(closingButtons, BorderLayout.SOUTH);
	    buttonComponents.add(closingButtons);
	    dialog.add(this);
	    super.show();
	}
	public Dialog(int X,int Y, int Width,int Height,String Title,String Message,MouseListener eventYes,MouseListener eventNo, boolean closeDialog) {
		super.setBounds(X, Y, Width, Height);
		super.setTitle(Title);
		JPanel closingMessage = new JPanel();
	    JPanel closingButtons = new JPanel();
	    JButton Yes = new  Components.Button(28, "Yes", true, colors.Black,colors.white, eventYes);
	    JButton No;
	    if(closeDialog == true) {
	    	closingButtons.add(Yes);
	    	No = new  Components.Button(28, "No", true, colors.Black,colors.white, new MouseAdapter() {
	    		@Override
			  	public void mouseClicked(MouseEvent e) {
	    			close();
				}
	    	});
	    	closingButtons.add(No);
	    } else {
	    	No = new  Components.Button(28, "No", true, colors.Black,colors.white, eventNo);
	    	closingButtons.add(Yes);
	    	closingButtons.add(No);
	    }
	    closingMessage.add(new Components.Label(Message, colors.Black));
	    super.getContentPane().add(closingMessage, BorderLayout.CENTER);
	    super.getContentPane().add(closingButtons, BorderLayout.SOUTH);
	    buttonComponents.add(closingButtons);
	    buttonsComponent.add(No);
	    dialog.add(this);
	    super.show();
	}
}