package Components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.Arrays;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.text.View;

import Colors.colors.Palettes;

public class Tabs extends JTabbedPane{
	public static class TabDesign extends BasicTabbedPaneUI {
		public static Color select = Settings.Initalize.Tabs.select;
		public static Color deselect = Settings.Initalize.Tabs.deselect;
	      private Color selectColor;
	      private Color deSelectColor;
	      private int inclTab = 4;
	      private int FolderWidth = 18;
	      private Polygon shape;
	      public static ComponentUI createUI(JComponent c) {
	         return new TabDesign();
	      }
	      // installing the defaults
	      @Override
	      protected void installDefaults() {
	         super.installDefaults();
	         // default Colors
	         selectColor = select;
	         deSelectColor = deselect;
	         tabAreaInsets.right = FolderWidth;
	      }
	      // drawing the tabs
	      @Override
	      protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {
	         if (runCount > 1) {
	            int lines[] = new int[runCount];
	            for (int i = 0; i < runCount; i++) {
	               lines[i] = rects[tabRuns[i]].y + (tabPlacement == TOP ? maxTabHeight : 0);
	            }
	            Arrays.sort(lines);
	            if (tabPlacement == TOP) {
	               int row = runCount;
	               for (int i = 0; i < lines.length - 1; i++, row--) {
	                  Polygon carp = new Polygon();
	                  carp.addPoint(0, lines[i]);
	                  carp.addPoint(tabPane.getWidth() - 2 * row - 2, lines[i]);
	                  carp.addPoint(tabPane.getWidth() - 2 * row, lines[i] + 3);
	                  if (i < lines.length - 2) {
	                     carp.addPoint(tabPane.getWidth() - 2 * row, lines[i + 1]);
	                     carp.addPoint(0, lines[i + 1]);
	                  } else {
	                     carp.addPoint(tabPane.getWidth() - 2 * row, lines[i] + rects[selectedIndex].height);
	                     carp.addPoint(0, lines[i] + rects[selectedIndex].height);
	                  }
	                  carp.addPoint(0, lines[i]);
	                  g.fillPolygon(carp);
	                  g.drawPolygon(carp);
	               }
	            } else {
	               int row = 0;
	               for (int i = 0; i < lines.length - 1; i++, row++) {
	                  Polygon carp = new Polygon();
	                  carp.addPoint(0, lines[i]);
	                  carp.addPoint(tabPane.getWidth() - 2 * row - 1, lines[i]);
	                  carp.addPoint(tabPane.getWidth() - 2 * row - 1, lines[i + 1] - 3);
	                  carp.addPoint(tabPane.getWidth() - 2 * row - 3, lines[i + 1]);
	                  carp.addPoint(0, lines[i + 1]);
	                  carp.addPoint(0, lines[i]);
	                  g.fillPolygon(carp);
	                  g.drawPolygon(carp);
	               }
	            }
	         }
	         super.paintTabArea(g, tabPlacement, selectedIndex);
	      }
	      // paint tab background
	      @Override
	      protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
	         Graphics2D g2D = (Graphics2D) g;
	         GradientPaint DeSelectedgradientShadow = null;
	         GradientPaint SelectedgradientShadow = null;
	         int xp[] = null;
	         int yp[] = null;
	         switch (tabPlacement) {
	            case LEFT:
	               xp = new int[]{x, x, x + w, x + w, x};
	               yp = new int[]{y, y + h - 3, y + h - 3, y, y};
	               break;
	            case RIGHT:
	               xp = new int[]{x, x, x + w - 2, x + w - 2, x};
	               yp = new int[]{y, y + h - 3, y + h - 3, y, y};
	               break;
	            case BOTTOM:
	               xp = new int[]{x, x, x + 3, x + w - inclTab - 6, x + w - inclTab - 2, x + w - inclTab, x + w - 3, x};
	               yp = new int[]{y, y + h - 3, y + h, y + h, y + h - 1, y + h - 3, y, y};
	               break;
	            case TOP:
	            default:
	               xp = new int[]{x, x, x + 3, x + w - inclTab - 6, x + w - inclTab - 2, x + w - inclTab, x + w - inclTab, x};
	               yp = new int[]{y + h, y + 3, y, y, y + 1, y + 3, y + h, y + h};
	               break;
	         }
	         // ;
	         shape = new Polygon(xp, yp, xp.length);
	         if (isSelected) {
	            SelectedgradientShadow = new GradientPaint(0, y + h / 2, selectColor, 0, y + h / 3, Palettes.Default.Info);
	            g2D.setPaint(SelectedgradientShadow);
	         } else {
	            if (tabPane.isEnabled() && tabPane.isEnabledAt(tabIndex)) {
	               DeSelectedgradientShadow = new GradientPaint(0, y + h / 2, deSelectColor, 0, y + h / 3, Palettes.Default.Info);
	               g2D.setPaint(DeSelectedgradientShadow);
	            }
	         }
	         g2D.fill(shape);
	      }

	      @Override
	      protected void paintText(Graphics g, int tabPlacement, Font font, FontMetrics metrics, int tabIndex, String title, Rectangle textRect, boolean isSelected) {
	         super.paintText(g, tabPlacement, font, metrics, tabIndex, title, textRect, isSelected);
	         g.setFont(font);
	         View v = getTextViewForTab(tabIndex);
	         if (v != null) {
	            v.paint(g, textRect);
	         }
	      }
	      @Override
	      protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
	         return 20 + inclTab + super.calculateTabWidth(tabPlacement, tabIndex, metrics);
	      }
	   }
	public Tabs(String[] Tabs, JPanel[] Panels,Color[] Foreground,int Width, int Height) {
		for (int i = 0; i < Panels.length; i++) {
			super.addTab(Tabs[i],Panels[i]);
			super.setBackgroundAt(i,Foreground[i]);
		}
		super.setPreferredSize(new Dimension(Width, Height));
		super.setUI(new TabDesign());
	}
}