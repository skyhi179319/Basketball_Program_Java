package Components;

import java.awt.Color;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Table{
	public static class Tables extends JPanel{
		public static DefaultTableModel model = new DefaultTableModel();
		public static ArrayList<JTable> table = new ArrayList<JTable>();
		// One Column
		public Tables(String Column,ArrayList<String> Data,Color Grid,Color Background,Color Foreground, MouseListener event) {
			JTable j;
			j = new JTable(model) {
				public boolean editCellAt(int row, int column, java.util.EventObject e) {
		            return false;
		         }
			};
			model.addColumn(Column);
			for (int i = 0; i < Data.size(); i++) {
				Object[] set = {Data.get(i)};
				model.addRow(set);
			}
			j.setGridColor(Grid);
		    j.setBackground(Background);
		    j.setForeground(Foreground);
		    table.add(j);
			JScrollPane sp = new JScrollPane(j);
			sp.getVerticalScrollBar().setBackground(Colors.colors.lightblue);
			super.add(sp);
			super.show();
			j.addMouseListener(event);
		}
		public Tables(String Column,ArrayList<String> Data,Color Grid,Color Background,Color Foreground) {
			JTable j;
			j = new JTable(model) {
				public boolean editCellAt(int row, int column, java.util.EventObject e) {
		            return false;
		         }
			};
			
			model.addColumn(Column);
			for (int i = 0; i < Data.size(); i++) {
				Object[] set = {Data.get(i)};
				model.addRow(set);
			}
			j.setGridColor(Grid);
		    j.setBackground(Background);
		    j.setForeground(Foreground);
		    table.add(j);
			JScrollPane sp = new JScrollPane(j);
			sp.getVerticalScrollBar().setBackground(Colors.colors.lightblue);
			super.add(sp);
			super.show();
		}
		// Two Columns
		public Tables(String[] Columns,TreeMap<String,String> Data,Color Grid,Color Background,Color Foreground) {
			JTable j;
			j = new JTable(model) {
				public boolean editCellAt(int row, int column, java.util.EventObject e) {
		            return false;
		         }
			};
			for (int i = 0; i < Columns.length; i++) {
				 model.addColumn(Columns[i]);
			}
			for (String i : Data.keySet()) {
		         Object[] set = {i,Data.get(i)};
		         model.addRow(set);
		    }
			j.setGridColor(Grid);
		    j.setBackground(Background);
		    j.setForeground(Foreground);
		    table.add(j);
			JScrollPane sp = new JScrollPane(j);
			sp.getVerticalScrollBar().setBackground(Colors.colors.lightblue);
			super.add(sp);
			super.show();
		}
		// Three Columns
		public Tables(String[] Columns,TreeMap<String,String> Data1and2,String[] Data3,Color Grid,Color Background,Color Foreground) {
			JTable j;
			j = new JTable(model) {
				public boolean editCellAt(int row, int column, java.util.EventObject e) {
		            return false;
		         }
			};
			for (int i = 0; i < Columns.length; i++) {
				 model.addColumn(Columns[i]);
			}
			for (String i : Data1and2.keySet()) {
				int h = 0;
		         Object[] set = {i,Data1and2.get(i),Data3[h]};
		         model.addRow(set);
		         h++;
		    }
			j.setGridColor(Grid);
		    j.setBackground(Background);
		    j.setForeground(Foreground);
		    table.add(j);
			JScrollPane sp = new JScrollPane(j);
			sp.getVerticalScrollBar().setBackground(Colors.colors.lightblue);
			super.add(sp);
			super.show();
		}
	}
	
}