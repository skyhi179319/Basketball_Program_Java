package Components;
import Colors.colors.Palettes;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicButtonUI;

public class Button extends javax.swing.JButton{
	int width;
	String text;
	Color foreground;
	Color border;
	Border border2;
	boolean gradient;
	private static class newButtonUI extends BasicButtonUI{
		static Color Color;
		static int Width;
		public newButtonUI(int width,Color color) {
			Color = color;
			Width = width;
	}
	public static newButtonUI MyButton = new newButtonUI(Width,Color);
	protected Border m_borderRaised = UIManager.getBorder("Button.border");
	protected Border m_borderLowered = UIManager.getBorder("Button.borderPressed");
	protected Color m_backgroundNormal = UIManager.getColor("Button.background");
	protected Color m_backgroundPressed = UIManager.getColor("Button.pressedBackground");
	protected Color m_foregroundNormal = UIManager.getColor("Button.foreground");
	protected Color m_foregroundActive = UIManager.getColor("Button.activeForeground");
	protected Color m_focusBorder = UIManager.getColor("Button.focusBorder");
	public static ComponentUI createUI(JComponent c) {
		return MyButton;
	}
	public void installUI(JComponent c) {
	  super.installUI(c);
	}
	public void uninstallUI(JComponent c) {
	  super.uninstallUI(c);
	}
	public void paintComponent(Graphics g,JComponent c) {
			// y = height
			// x = width
		    Graphics2D g2 = (Graphics2D) g.create();
		    AbstractButton b = (AbstractButton) c;
			g2.setFont(c.getFont());
			g2.setColor(Color);
			String caption = b.getText();
			int x = b.getWidth() / 2 - b.getWidth() + Width;
			int y = b.getHeight() / 2 + 4;
			g2.drawString(caption, x, y);
		}
		public Dimension getPreferredSize(JComponent c) {
		    Dimension d = super.getPreferredSize(c);
		    if (m_borderRaised != null) {
		      Insets ins = m_borderRaised.getBorderInsets(c);
		      int x = d.width/ 2 - d.width + Width + 20;
		      d.setSize(new Dimension(68,20));
		    }
		    return d;
		}
	}

	public Button(int Width,String Text,boolean Gradient, Color Foreground,Color Border,MouseListener event) {
		width = Width;
		text = Text;
		foreground = Foreground;
		border = Border;
		gradient = Gradient;
		super.addMouseListener(event);
	}
	public Button(int Width,String Text,boolean Gradient, Color Foreground,Border Border,MouseListener event) {
		width = Width;
		text = Text;
		foreground = Foreground;
		border2 = Border;
		gradient = Gradient;
		super.addMouseListener(event);
		super.setBorder(border2);
	}
	@Override
	public void paintComponent(Graphics g) {
		// y = height
		// x = width
	    Graphics2D g2 = (Graphics2D) g.create();
	    g2.setPaint(new GradientPaint(new Point(0, 0), Palettes.White.Whitesmoke, new Point(0,getHeight()),Palettes.White.White));
	    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
	    setForeground(foreground);
	    setBorder(new LineBorder(border));
	    g2.setPaint(getForeground());
	    int cac = getWidth()/ 2 - getWidth() + width * 2;
	    setText(text);
	    if(gradient == true) {
	    	setUI(new newButtonUI(width,foreground));
	    }
	    else {
	    	
	    }
	    g2.drawString(getText(), cac, getHeight() / 2 + 4);
	    g2.dispose();
	    
	}
}