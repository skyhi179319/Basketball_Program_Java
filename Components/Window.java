package Components;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.WindowAdapter;

import javax.swing.JFrame;

import Colors.colors;

public class Window extends JFrame{
	public Window(int X,int Y , int Width,int Height,String Title,Component North,Component East,Component South,Component West,Component Center) {
		super.setBounds(X, Y, Width, Height);
		super.setTitle(Title);
		super.getContentPane().add(North,BorderLayout.NORTH);
		super.getContentPane().add(East,BorderLayout.EAST);
		super.getContentPane().add(South,BorderLayout.SOUTH);
		super.getContentPane().add(West,BorderLayout.WEST);
		super.getContentPane().add(Center,BorderLayout.CENTER);
		super.show();
	}
	public Window(int X,int Y , int Width,int Height,String Title,Component North,Component East,Component South,Component West,Component Center,WindowAdapter opened) {
		super.setBounds(X, Y, Width, Height);
		super.setTitle(Title);
		super.getContentPane().add(North,BorderLayout.NORTH);
		super.getContentPane().add(East,BorderLayout.EAST);
		super.getContentPane().add(South,BorderLayout.SOUTH);
		super.getContentPane().add(West,BorderLayout.WEST);
		super.getContentPane().add(Center,BorderLayout.CENTER);
		super.show();
		super.addWindowListener(opened);
	}
}