package Components;

import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.LineBorder;

import Colors.colors;
import Colors.colors.Palettes;

public class Menu{
	public static class menuItem extends JMenuItem{
		public menuItem(String text,ActionListener action) {
			super.setText(text);
			super.addActionListener(action);
			super.setBackground(Settings.Initalize.Menu.menuItemBackground);
		}
	}
	public static class menu extends JMenu{
		public menu(String text,menuItem[] items) {
			super.setText(text);
			for (int i = 0; i < items.length; i++) {
				super.add(items[i]);
			}
		}
	}
	public static class menuBar extends JMenuBar {
		public menuBar(){
			menuItem[] items = {new menuItem("Exit",new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Language.Application.exitApplication();
				}
				
			})};
			JMenu main = new menu("Options",items);
			super.add(main);
		}
		public menuBar(menu[] items) {
			for (int i = 0; i < items.length; i++) {
				super.add(items[i]);
			}
		}
		@Override
		public void paintComponent(Graphics g) {
			// y = height
			// x = width
		    Graphics2D g2 = (Graphics2D) g.create();
		    g2.setPaint(new GradientPaint(new Point(0, 0), Palettes.White.Whitesmoke, new Point(0,getHeight()),Palettes.White.White));
		    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
		    g2.setPaint(getForeground());
		    g2.dispose();
		}
	}
}