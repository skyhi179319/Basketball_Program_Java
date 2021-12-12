import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.lang.*;
import java.text.NumberFormat;

import Colors.colors;
import Components.Bundle;
import Components.Button;
import Components.Label;
import Components.Menu.menu;
import Components.Menu.menuItem;

public class main {
	public static class Player{
		private String Name;
		private String Pos;
		private int Game1;
		private int Game2;
		private int Game3;
		private static String Lineup;
		private static int Number;
		public Player(String name, String pos, int game1, int game2, int game3) {
			Name = name;
			Pos = pos;
			Game1 = game1;
			Game2 = game2;
			Game3 = game3;
		}
		public Player(String name, String pos, int number,String lineup) {
			Name = name;
			Pos = pos;
			Number = number;
			Lineup = lineup;
		}
		public String returnName(){
			return Name;
		}
		public String returnPos(){
			return Pos;
		}
		public int returnGame1(){
			return Game1;
		}
		public int returnGame2(){
			return Game2;
		}
		public int returnGame3(){
			return Game3;
		}
		public int returnPoints() {
			return Game1 + Game2 + Game3;
		}
		public static void changeName(JTable table,int row,String value) {
			table.setValueAt(value, row, 0);   
		}
		public static void changeGame1(JTable table,int row,String value) {
			table.setValueAt(value, row, 2);   
		}
		public static void changeGame2(JTable table,int row,String value) {
			table.setValueAt(value, row, 3);   
		}
		public static void changeGame3(JTable table,int row,String value) {
			table.setValueAt(value, row, 4);   
		}
		public static void changePointsTotal(JTable table,int row, int game1, int game2, int game3) {
			int points = game1 + game2 + game3;
			table.setValueAt(points, row, 5);
		}
		public static String returnLineup() {
			return Lineup;
		}
		public static String returnNumber() {
			return Integer.toString(Number);
		}
	}
	public static class functions{
		public static int returnGame1Points(Player Player1, Player Player2, Player Player3, Player Player4, Player Player5){
			int points = Player1.returnGame1() + Player2.returnGame1() + Player3.returnGame1() + Player4.returnGame1() + Player5.returnGame1();
			return points;
		}
		public static int returnGame2Points(Player Player1, Player Player2, Player Player3, Player Player4, Player Player5){
			int points = Player1.returnGame2() + Player2.returnGame2() + Player3.returnGame2() + Player4.returnGame2() + Player5.returnGame2();
			return points;
		}
		public static int returnGame3Points(Player Player1, Player Player2, Player Player3, Player Player4, Player Player5){
			int points = Player1.returnGame3() + Player2.returnGame3() + Player3.returnGame3() + Player4.returnGame3() + Player5.returnGame3();
			return points;
		}
		public static int returnAllPoints(Player Player1, Player Player2, Player Player3, Player Player4, Player Player5) {
			return Player1.returnPoints() + Player2.returnPoints() + Player3.returnPoints() + Player4.returnPoints() + Player5.returnPoints();
		}
		public static String returnAvg(int totalPoints){        
			double points = totalPoints / 3.0;
			return String.format("%.3f",points);
		}
		public static void changeGame1Points(JTable table) {
			String PG = String.valueOf(table.getValueAt(0, 2));
			String SG = String.valueOf(table.getValueAt(1, 2));
			String C = String.valueOf(table.getValueAt(2, 2));
			String PF = String.valueOf(table.getValueAt(3, 2));
			String SF = String.valueOf(table.getValueAt(4, 2));
			int points = Integer.parseInt(PG) + Integer.parseInt(SG) + Integer.parseInt(C) + Integer.parseInt(PF) + Integer.parseInt(SF);
			table.setValueAt(points, 6, 2);
		}
		public static void changeGame2Points(JTable table) {
			String PG = String.valueOf(table.getValueAt(0, 3));
			String SG = String.valueOf(table.getValueAt(1, 3));
			String C = String.valueOf(table.getValueAt(2, 3));
			String PF = String.valueOf(table.getValueAt(3, 3));
			String SF = String.valueOf(table.getValueAt(4, 3));
			int points = Integer.parseInt(PG) + Integer.parseInt(SG) + Integer.parseInt(C) + Integer.parseInt(PF) + Integer.parseInt(SF);
			table.setValueAt(points, 6, 3);
		}
		public static void changeGame3Points(JTable table) {
			String PG = String.valueOf(table.getValueAt(0, 4));
			String SG = String.valueOf(table.getValueAt(1, 4));
			String C = String.valueOf(table.getValueAt(2, 4));
			String PF = String.valueOf(table.getValueAt(3, 4));
			String SF = String.valueOf(table.getValueAt(4, 4));
			int points = Integer.parseInt(PG) + Integer.parseInt(SG) + Integer.parseInt(C) + Integer.parseInt(PF) + Integer.parseInt(SF);
			table.setValueAt(points, 6, 4);
		}
		public static void changeAllPoints(JTable table) {
			String PG = String.valueOf(table.getValueAt(0, 5));
			String SG = String.valueOf(table.getValueAt(1, 5));
			String C = String.valueOf(table.getValueAt(2, 5));
			String PF = String.valueOf(table.getValueAt(3, 5));
			String SF = String.valueOf(table.getValueAt(4, 5));
			int points = Integer.parseInt(PG) + Integer.parseInt(SG) + Integer.parseInt(C) + Integer.parseInt(PF) + Integer.parseInt(SF);
			table.setValueAt(points, 6, 5);
		}
		public static void changeAVG(JTable table) {
			int points = Integer.parseInt(String.valueOf(table.getValueAt(6, 5)));
			table.setValueAt(functions.returnAvg(points), 8, 5);
		}
		public static int returnMax(JTable table) {
			String PG = String.valueOf(table.getValueAt(0, 5));
			String SG = String.valueOf(table.getValueAt(1, 5));
			String C = String.valueOf(table.getValueAt(2, 5));
			String PF = String.valueOf(table.getValueAt(3, 5));
			String SF = String.valueOf(table.getValueAt(4, 5));
			int arr[] = {Integer.parseInt(PG), Integer.parseInt(SG), Integer.parseInt(C), Integer.parseInt(PF), Integer.parseInt(SF)};
	        int max = Arrays.stream(arr).max().getAsInt();
	        return max;
		}
	}
	public static class predictionModel{
		public static double homePrediction;
		public static double awayPrediction;
		private static double returnPrediction(int pointsScored,int pointsAllowed) {
			// Pythagorean Expectation
			double sum1 = java.lang.StrictMath.pow(pointsScored, 2);
		    double sum2 = java.lang.StrictMath.pow(pointsAllowed, 2);
			double math = sum1/(sum1+sum2);
			return math;
		}
		/* Prediction Percentage */
		public static String formatedHomePrediction(int pointsScored,int pointsAllowed) {
			double prediction = returnPrediction(pointsScored,pointsAllowed);
			homePrediction = prediction;
			return "Home: " + String.format("%.3f",prediction);
		}
		public static String formatedAwayPrediction(int pointsScored,int pointsAllowed) {
			double prediction = returnPrediction(pointsScored,pointsAllowed);
			awayPrediction = prediction;
			return "Away: " + String.format("%.3f",prediction);
		}
	}
	public static class pointsTable extends JPanel{
		 public static JTable j;
		 public static Player PG = new Player("Skyler","PG",15,20,18);
		 public static Player SG = new Player("Zane","SG",10,15,12);
		 public static Player C =  new Player("David","C",15,17,13);
		 public static Player PF = new Player("Carson","PF",15,13,17);
		 public static Player SF = new Player("Ethan","SF",17,15,17);
		 public pointsTable(){
			benchEdit.players.put(PG.returnName(), PG);
			benchEdit.players.put(SG.returnName(), SG);
			benchEdit.players.put(C.returnName(), C);
			benchEdit.players.put(PF.returnName(), PF);
			benchEdit.players.put(SF.returnName(), SF);
		    DefaultTableModel model = new DefaultTableModel();
		    int Game1 = functions.returnGame1Points(PG,SG,C,PF,SF);
            int Game2 = functions.returnGame2Points(PG,SG,C,PF,SF);
            int Game3 = functions.returnGame3Points(PG,SG,C,PF,SF);
            int Total = functions.returnAllPoints(PG,SG,C,PF,SF);
            String AVG = functions.returnAvg(Total);
            String[] Columns = {"Name","Pos","Game 1","Game 2","Game 3","Totals"};
		    Object[] PG_Row = {PG.returnName(),PG.returnPos(), PG.returnGame1(),PG.returnGame2(),PG.returnGame3(),PG.returnPoints()};
		    Object[] SG_Row = {SG.returnName(),SG.returnPos(), SG.returnGame1(),SG.returnGame2(),SG.returnGame3(),SG.returnPoints()};
		    Object[] C_Row = {C.returnName(),C.returnPos(), C.returnGame1(),C.returnGame2(),C.returnGame3(),C.returnPoints()};
		    Object[] PF_Row = {PF.returnName(),PF.returnPos(), PF.returnGame1(),PF.returnGame2(),PF.returnGame3(),PF.returnPoints()};
		    Object[] SF_Row = {SF.returnName(),SF.returnPos(), SF.returnGame1(),SF.returnGame2(),SF.returnGame3(),SF.returnPoints()};
		    Object[] Totals = {"Totals:","",Game1,Game2,Game3,Total};
		    Object[] AVGS = {"", "","","","AVG:",AVG};
		    Object[] blanks = {"","","","","",""};
		    
		    j = new JTable(model) {
		            public boolean editCellAt(int row, int column, java.util.EventObject e) {
		        return false;
		     }
		    };
		    for (int i = 0; i < Columns.length; i++) {
		             model.addColumn(Columns[i]);
		    }
		    model.addRow(PG_Row);
		    model.addRow(SG_Row);
		    model.addRow(C_Row);
		    model.addRow(PF_Row);
		    model.addRow(SF_Row);
		    model.addRow(blanks);
		    model.addRow(Totals);
		    model.addRow(blanks);
		    model.addRow(AVGS);
			JScrollPane sp = new JScrollPane(j);
			sp.getVerticalScrollBar().setBackground(Colors.colors.lightblue);
			super.add(sp);
			super.show();
			if(functions.returnMax(j) == Integer.valueOf(String.valueOf(j.getValueAt(0, 5)))) {
				j.addRowSelectionInterval(0, 0);
			}
			if(functions.returnMax(j) == Integer.valueOf(String.valueOf(j.getValueAt(1, 5)))) {
				j.addRowSelectionInterval(0, 0);
			}
			if(functions.returnMax(j) == Integer.valueOf(String.valueOf(j.getValueAt(2, 5)))) {
				j.addRowSelectionInterval(0, 0);
			}
			if(functions.returnMax(j) == Integer.valueOf(String.valueOf(j.getValueAt(3, 5)))) {
				j.addRowSelectionInterval(0, 0);
			}
			if(functions.returnMax(j) == Integer.valueOf(String.valueOf(j.getValueAt(4, 5)))) {
				j.addRowSelectionInterval(0, 0);
			}
		}

	}
	public static class stealsTable extends JPanel{
		public static JTable j;
		public static Player PG = new Player("Skyler","PG",3,2,3);
		public static Player SG = new Player("Zane","SG",1,0,2);
		public static Player C =  new Player("David","C",0,1,2);
		public static Player PF = new Player("Carson","PF",1,1,1);
		public static Player SF = new Player("Ethan","SF",1,1,2);
		public stealsTable(){
		    DefaultTableModel model = new DefaultTableModel();
		    
		    int Game1 = functions.returnGame1Points(PG,SG,C,PF,SF);
            int Game2 = functions.returnGame2Points(PG,SG,C,PF,SF);
            int Game3 = functions.returnGame3Points(PG,SG,C,PF,SF);
            int Total = functions.returnAllPoints(PG,SG,C,PF,SF);
            String AVG = functions.returnAvg(Total);
		    String[] Columns = {"Name","Pos","Game 1","Game 2","Game 3","Totals"};
		    Object[] PG_Row = {PG.returnName(),PG.returnPos(), PG.returnGame1(),PG.returnGame2(),PG.returnGame3(),PG.returnPoints()};
		    Object[] SG_Row = {SG.returnName(),SG.returnPos(), SG.returnGame1(),SG.returnGame2(),SG.returnGame3(),SG.returnPoints()};
		    Object[] C_Row = {C.returnName(),C.returnPos(), C.returnGame1(),C.returnGame2(),C.returnGame3(),C.returnPoints()};
		    Object[] PF_Row = {PF.returnName(),PF.returnPos(), PF.returnGame1(),PF.returnGame2(),PF.returnGame3(),PF.returnPoints()};
		    Object[] SF_Row = {SF.returnName(),SF.returnPos(), SF.returnGame1(),SF.returnGame2(),SF.returnGame3(),SF.returnPoints()};
		    Object[] Totals = {"Totals:","",Game1,Game2,Game3,Total};
		    Object[] AVGS = {"", "","","","Steals:",AVG};
		    Object[] blanks = {"","","","","",""};
		    
		    j = new JTable(model) {
		            public boolean editCellAt(int row, int column, java.util.EventObject e) {
		        return false;
		     }
		    };
		    for (int i = 0; i < Columns.length; i++) {
		             model.addColumn(Columns[i]);
		    }
		    model.addRow(PG_Row);
		    model.addRow(SG_Row);
		    model.addRow(C_Row);
		    model.addRow(PF_Row);
		    model.addRow(SF_Row);
		    model.addRow(blanks);
		    model.addRow(Totals);
		    model.addRow(blanks);
		    model.addRow(AVGS);
			JScrollPane sp = new JScrollPane(j);
			sp.getVerticalScrollBar().setBackground(Colors.colors.lightblue);
			super.add(sp);
			super.show();
			if(functions.returnMax(j) == Integer.valueOf(String.valueOf(j.getValueAt(0, 5)))) {
				j.addRowSelectionInterval(0, 0);
			}
			if(functions.returnMax(j) == Integer.valueOf(String.valueOf(j.getValueAt(1, 5)))) {
				j.addRowSelectionInterval(1, 1);
			}
			if(functions.returnMax(j) == Integer.valueOf(String.valueOf(j.getValueAt(2, 5)))) {
				j.addRowSelectionInterval(2, 2);
			}
			if(functions.returnMax(j) == Integer.valueOf(String.valueOf(j.getValueAt(3, 5)))) {
				j.addRowSelectionInterval(3, 3);
			}
			if(functions.returnMax(j) == Integer.valueOf(String.valueOf(j.getValueAt(4, 5)))) {
				j.addRowSelectionInterval(4, 4);
			}
		}
		
	}
	public static class reboundsTable extends JPanel{
		public static JTable j;
		public static Player PG = new Player("Skyler","PG",6,6,7);
		public static Player SG = new Player("Zane","SG",6,7,8);
		public static Player C =  new Player("David","C",5,6,7);
		public static Player PF = new Player("Carson","PF",8,6,8);
		public static Player SF = new Player("Ethan","SF",7,8,7);
		public reboundsTable(){
		    DefaultTableModel model = new DefaultTableModel();
		    int Game1 = functions.returnGame1Points(PG,SG,C,PF,SF);
            int Game2 = functions.returnGame2Points(PG,SG,C,PF,SF);
            int Game3 = functions.returnGame3Points(PG,SG,C,PF,SF);
            int Total = functions.returnAllPoints(PG,SG,C,PF,SF);
            String AVG = functions.returnAvg(Total);
            String[] Columns = {"Name","Pos","Game 1","Game 2","Game 3","Totals"};
		    Object[] PG_Row = {PG.returnName(),PG.returnPos(), PG.returnGame1(),PG.returnGame2(),PG.returnGame3(),PG.returnPoints()};
		    Object[] SG_Row = {SG.returnName(),SG.returnPos(), SG.returnGame1(),SG.returnGame2(),SG.returnGame3(),SG.returnPoints()};
		    Object[] C_Row = {C.returnName(),C.returnPos(), C.returnGame1(),C.returnGame2(),C.returnGame3(),C.returnPoints()};
		    Object[] PF_Row = {PF.returnName(),PF.returnPos(), PF.returnGame1(),PF.returnGame2(),PF.returnGame3(),PF.returnPoints()};
		    Object[] SF_Row = {SF.returnName(),SF.returnPos(), SF.returnGame1(),SF.returnGame2(),SF.returnGame3(),SF.returnPoints()};
		    Object[] Totals = {"Totals:","",Game1,Game2,Game3,Total};
		    Object[] AVGS = {"", "","","","Rebounds:",AVG};
		    Object[] blanks = {"","","","","",""};
		    
		    j = new JTable(model) {
		            public boolean editCellAt(int row, int column, java.util.EventObject e) {
		        return false;
		     }
		    };
		    for (int i = 0; i < Columns.length; i++) {
		             model.addColumn(Columns[i]);
		    }
		    model.addRow(PG_Row);
		    model.addRow(SG_Row);
		    model.addRow(C_Row);
		    model.addRow(PF_Row);
		    model.addRow(SF_Row);
		    model.addRow(blanks);
		    model.addRow(Totals);
		    model.addRow(blanks);
		    model.addRow(AVGS);
			JScrollPane sp = new JScrollPane(j);
			sp.getVerticalScrollBar().setBackground(Colors.colors.lightblue);
			super.add(sp);
			super.show();
			if(functions.returnMax(j) == Integer.valueOf(String.valueOf(j.getValueAt(0, 5)))) {
				j.addRowSelectionInterval(0, 0);
			}
			if(functions.returnMax(j) == Integer.valueOf(String.valueOf(j.getValueAt(1, 5)))) {
				j.addRowSelectionInterval(1, 1);
			}
			if(functions.returnMax(j) == Integer.valueOf(String.valueOf(j.getValueAt(2, 5)))) {
				j.addRowSelectionInterval(2, 2);
			}
			if(functions.returnMax(j) == Integer.valueOf(String.valueOf(j.getValueAt(3, 5)))) {
				j.addRowSelectionInterval(3, 3);
			}
			if(functions.returnMax(j) == Integer.valueOf(String.valueOf(j.getValueAt(4, 5)))) {
				j.addRowSelectionInterval(4, 4);
			}
		}
	}
	public static class foulsTable extends JPanel{
		public static JTable j;
		public static Player PG = new Player("Skyler","PG",1,2,1);
		public static Player SG = new Player("Zane","SG",1,3,2);
		public static Player C =  new Player("David","C",1,1,2);
		public static Player PF = new Player("Carson","PF",1,0,1);
		public static Player SF = new Player("Ethan","SF",1,0,0);
		public foulsTable(){
		    DefaultTableModel model = new DefaultTableModel();
		    int Game1 = functions.returnGame1Points(PG,SG,C,PF,SF);
            int Game2 = functions.returnGame2Points(PG,SG,C,PF,SF);
            int Game3 = functions.returnGame3Points(PG,SG,C,PF,SF);
            int Total = functions.returnAllPoints(PG,SG,C,PF,SF);
            String AVG = functions.returnAvg(Total);
            String[] Columns = {"Name","Pos","Game 1","Game 2","Game 3","Totals"};
		    Object[] PG_Row = {PG.returnName(),PG.returnPos(), PG.returnGame1(),PG.returnGame2(),PG.returnGame3(),PG.returnPoints()};
		    Object[] SG_Row = {SG.returnName(),SG.returnPos(), SG.returnGame1(),SG.returnGame2(),SG.returnGame3(),SG.returnPoints()};
		    Object[] C_Row = {C.returnName(),C.returnPos(), C.returnGame1(),C.returnGame2(),C.returnGame3(),C.returnPoints()};
		    Object[] PF_Row = {PF.returnName(),PF.returnPos(), PF.returnGame1(),PF.returnGame2(),PF.returnGame3(),PF.returnPoints()};
		    Object[] SF_Row = {SF.returnName(),SF.returnPos(), SF.returnGame1(),SF.returnGame2(),SF.returnGame3(),SF.returnPoints()};
		    Object[] Totals = {"Totals:","",Game1,Game2,Game3,Total};
		    Object[] AVGS = {"", "","","","Fouls:",AVG};
		    Object[] blanks = {"","","","","",""};
		    
		    j = new JTable(model) {
		            public boolean editCellAt(int row, int column, java.util.EventObject e) {
		        return false;
		     }
		    };
		    for (int i = 0; i < Columns.length; i++) {
		             model.addColumn(Columns[i]);
		    }
		    model.addRow(PG_Row);
		    model.addRow(SG_Row);
		    model.addRow(C_Row);
		    model.addRow(PF_Row);
		    model.addRow(SF_Row);
		    model.addRow(blanks);
		    model.addRow(Totals);
		    model.addRow(blanks);
		    model.addRow(AVGS);
			JScrollPane sp = new JScrollPane(j);
			sp.getVerticalScrollBar().setBackground(Colors.colors.lightblue);
			super.add(sp);
			super.show();
			if(functions.returnMax(j) == Integer.valueOf(String.valueOf(j.getValueAt(0, 5)))) {
				j.addRowSelectionInterval(0, 0);
			}
			if(functions.returnMax(j) == Integer.valueOf(String.valueOf(j.getValueAt(1, 5)))) {
				j.addRowSelectionInterval(1, 1);
			}
			if(functions.returnMax(j) == Integer.valueOf(String.valueOf(j.getValueAt(2, 5)))) {
				j.addRowSelectionInterval(2, 2);
			}
			if(functions.returnMax(j) == Integer.valueOf(String.valueOf(j.getValueAt(3, 5)))) {
				j.addRowSelectionInterval(3, 3);
			}
			if(functions.returnMax(j) == Integer.valueOf(String.valueOf(j.getValueAt(4, 5)))) {
				j.addRowSelectionInterval(4, 4);
			}
		}
	}
	public static class editTab extends JPanel{
		public static JTextField tname, tPos,tGame1, tGame2, tGame3; 
		public static JButton buttonSave;
		public editTab() {
			JPanel p1 = new JPanel();
			p1.setLayout(new GridLayout(7, 2));
			  
		    FlowLayout layout = new FlowLayout();
		  
		    JPanel p2 = new JPanel();
		  
		    // set the layout
		    p2.setLayout(layout);
		  
		    JLabel lName, lPos, lGame1, lGame2, lGame3;
		    lName = new Components.Label("NAME:", Colors.colors.darkpurple);
		  
		    tname = new Components.Textfield(20, Colors.colors.purple, Colors.colors.Black);
		    
		    lPos = new Components.Label("POS:", Colors.colors.darkpurple);
			  
		    tPos = new Components.Textfield(20, Colors.colors.purple, Colors.colors.Black);
		    
		    lGame1 = new Components.Label("GAME 1:", Colors.colors.darkpurple);
		  
		    tGame1 = new Components.Textfield(20, Colors.colors.purple, Colors.colors.Black);
		  
		    lGame2 = new Components.Label("GAME 2:", Colors.colors.darkpurple);
		  
		    tGame2 = new Components.Textfield(20, Colors.colors.purple, Colors.colors.Black);new JTextField(20);
		  
		    lGame3 = new Components.Label("GAME 3:", Colors.colors.darkpurple);
		  
		    tGame3 = new Components.Textfield(20, Colors.colors.purple, Colors.colors.Black);
		  
		    p1.add(lName);
		  
		    p1.add(tname);
		    
		    p1.add(lPos);
		    
		    p1.add(tPos);
		  
		    p1.add(lGame1);
		  
		    p1.add(tGame1);
		  
		    p1.add(lGame2);
		  
		    p1.add(tGame2);
		  
		    p1.add(lGame3);
		  
		    p1.add(tGame3);
		  
		    JRadioButton points = new JRadioButton("Points");
		    JRadioButton steals = new JRadioButton("Steals");
		    JRadioButton rebounds = new JRadioButton("Rebounds");
		    JRadioButton fouls = new JRadioButton("Fouls");
		    ButtonGroup ButtonGroup = new ButtonGroup();
		    ButtonGroup.add(points);
		    ButtonGroup.add(steals);
		    ButtonGroup.add(rebounds);
		    ButtonGroup.add(fouls);
		    points.setSelected(true);
		    p2.add(new JLabel("Options:"));
		    p2.add(points);
		    p2.add(steals);
		    p2.add(rebounds);
		    p2.add(fouls);
		    buttonSave = new Components.Button(27, "SAVE", true, getForeground(), Colors.colors.Black, new MouseAdapter() {
		    	@Override
			  	public void mouseClicked(MouseEvent e) {
		    		tname.selectAll();
					tPos.selectAll();
					tGame1.selectAll();
					tGame2.selectAll();
					tGame3.selectAll();
					if(functions.returnMax(pointsTable.j) == Integer.valueOf(String.valueOf(pointsTable.j.getValueAt(0, 5)))) {
						pointsTable.j.removeRowSelectionInterval(0, 0);
					}
					if(functions.returnMax(pointsTable.j) == Integer.valueOf(String.valueOf(pointsTable.j.getValueAt(1, 5)))) {
						pointsTable.j.removeRowSelectionInterval(1, 1);
					}
					if(functions.returnMax(pointsTable.j) == Integer.valueOf(String.valueOf(pointsTable.j.getValueAt(2, 5)))) {
						pointsTable.j.removeRowSelectionInterval(2, 2);
					}
					if(functions.returnMax(pointsTable.j) == Integer.valueOf(String.valueOf(pointsTable.j.getValueAt(3, 5)))) {
						pointsTable.j.removeRowSelectionInterval(3, 3);
					}
					if(functions.returnMax(pointsTable.j) == Integer.valueOf(String.valueOf(pointsTable.j.getValueAt(4, 5)))) {
						pointsTable.j.removeRowSelectionInterval(4, 4);
					}
					if(functions.returnMax(stealsTable.j) == Integer.valueOf(String.valueOf(stealsTable.j.getValueAt(0, 5)))) {
						stealsTable.j.removeRowSelectionInterval(0, 0);
					}
					if(functions.returnMax(stealsTable.j) == Integer.valueOf(String.valueOf(stealsTable.j.getValueAt(1, 5)))) {
						stealsTable.j.removeRowSelectionInterval(1, 1);
					}
					if(functions.returnMax(pointsTable.j) == Integer.valueOf(String.valueOf(stealsTable.j.getValueAt(2, 5)))) {
						stealsTable.j.removeRowSelectionInterval(2, 2);
					}
					if(functions.returnMax(stealsTable.j) == Integer.valueOf(String.valueOf(stealsTable.j.getValueAt(3, 5)))) {
						stealsTable.j.removeRowSelectionInterval(3, 3);
					}
					if(functions.returnMax(stealsTable.j) == Integer.valueOf(String.valueOf(stealsTable.j.getValueAt(4, 5)))) {
						stealsTable.j.removeRowSelectionInterval(4, 4);
					}
					if(functions.returnMax(reboundsTable.j) == Integer.valueOf(String.valueOf(reboundsTable.j.getValueAt(0, 5)))) {
						reboundsTable.j.removeRowSelectionInterval(0, 0);
					}
					if(functions.returnMax(reboundsTable.j) == Integer.valueOf(String.valueOf(reboundsTable.j.getValueAt(1, 5)))) {
						reboundsTable.j.removeRowSelectionInterval(1, 1);
					}
					if(functions.returnMax(reboundsTable.j) == Integer.valueOf(String.valueOf(reboundsTable.j.getValueAt(2, 5)))) {
						reboundsTable.j.removeRowSelectionInterval(2, 2);
					}
					if(functions.returnMax(reboundsTable.j) == Integer.valueOf(String.valueOf(reboundsTable.j.getValueAt(3, 5)))) {
						reboundsTable.j.removeRowSelectionInterval(3, 3);
					}
					if(functions.returnMax(reboundsTable.j) == Integer.valueOf(String.valueOf(reboundsTable.j.getValueAt(4, 5)))) {
						reboundsTable.j.removeRowSelectionInterval(4, 4);
					}
					if(functions.returnMax(foulsTable.j) == Integer.valueOf(String.valueOf(foulsTable.j.getValueAt(0, 5)))) {
						foulsTable.j.removeRowSelectionInterval(0, 0);
					}
					if(functions.returnMax(foulsTable.j) == Integer.valueOf(String.valueOf(foulsTable.j.getValueAt(1, 5)))) {
						foulsTable.j.removeRowSelectionInterval(1, 1);
					}
					if(functions.returnMax(foulsTable.j) == Integer.valueOf(String.valueOf(foulsTable.j.getValueAt(2, 5)))) {
						foulsTable.j.removeRowSelectionInterval(2, 2);
					}
					if(functions.returnMax(foulsTable.j) == Integer.valueOf(String.valueOf(foulsTable.j.getValueAt(3, 5)))) {
						foulsTable.j.removeRowSelectionInterval(3, 3);
					}
					if(functions.returnMax(foulsTable.j) == Integer.valueOf(String.valueOf(foulsTable.j.getValueAt(4, 5)))) {
						foulsTable.j.removeRowSelectionInterval(4, 4);
					}
					
					if(points.isSelected() == true) {
						if(tPos.getSelectedText().equals("PG") || tPos.getSelectedText() == "pg") {
							main.Player.changeName(pointsTable.j, 0, tname.getSelectedText());
							main.Player.changeGame1(pointsTable.j, 0, tGame1.getSelectedText());
							main.Player.changeGame2(pointsTable.j, 0, tGame2.getSelectedText());
							main.Player.changeGame3(pointsTable.j, 0, tGame3.getSelectedText());
							int Game1 = Integer.parseInt(tGame1.getSelectedText());
							int Game2 = Integer.parseInt(tGame2.getSelectedText());
							int Game3 = Integer.parseInt(tGame3.getSelectedText());
							main.Player.changePointsTotal(pointsTable.j, 0, Game1, Game2, Game3);
							main.functions.changeAllPoints(pointsTable.j);
							main.functions.changeGame1Points(pointsTable.j);
							main.functions.changeGame2Points(pointsTable.j);
							main.functions.changeGame3Points(pointsTable.j);
							main.functions.changeAVG(pointsTable.j);
							console.writeLine("Changed PG - Points");
							console.updateConsole(consoleApp.consoleDisplay);
						}
						if(tPos.getSelectedText().equals("SG") || tPos.getSelectedText() == "sg") {
							main.Player.changeName(pointsTable.j, 1, tname.getSelectedText());
							main.Player.changeGame1(pointsTable.j, 1, tGame1.getSelectedText());
							main.Player.changeGame2(pointsTable.j, 1, tGame2.getSelectedText());
							main.Player.changeGame3(pointsTable.j, 1, tGame3.getSelectedText());
							int Game1 = Integer.parseInt(tGame1.getSelectedText());
							int Game2 = Integer.parseInt(tGame2.getSelectedText());
							int Game3 = Integer.parseInt(tGame3.getSelectedText());
							main.Player.changePointsTotal(pointsTable.j, 1, Game1, Game2, Game3);
							main.functions.changeAllPoints(pointsTable.j);
							main.functions.changeGame1Points(pointsTable.j);
							main.functions.changeGame2Points(pointsTable.j);
							main.functions.changeGame3Points(pointsTable.j);
							main.functions.changeAVG(pointsTable.j);
							console.writeLine("Changed SG - Points");
							console.updateConsole(consoleApp.consoleDisplay);
						}
						if(tPos.getSelectedText().equals("C") || tPos.getSelectedText() == "c") {
							main.Player.changeName(pointsTable.j, 2, tname.getSelectedText());
							main.Player.changeGame1(pointsTable.j, 2, tGame1.getSelectedText());
							main.Player.changeGame2(pointsTable.j, 2, tGame2.getSelectedText());
							main.Player.changeGame3(pointsTable.j, 2, tGame3.getSelectedText());
							int Game1 = Integer.parseInt(tGame1.getSelectedText());
							int Game2 = Integer.parseInt(tGame2.getSelectedText());
							int Game3 = Integer.parseInt(tGame3.getSelectedText());
							main.Player.changePointsTotal(pointsTable.j, 2, Game1, Game2, Game3);
							main.functions.changeAllPoints(pointsTable.j);
							main.functions.changeGame1Points(pointsTable.j);
							main.functions.changeGame2Points(pointsTable.j);
							main.functions.changeGame3Points(pointsTable.j);
							main.functions.changeAVG(pointsTable.j);
							console.writeLine("Changed C - Points");
							console.updateConsole(consoleApp.consoleDisplay);
						}
						if(tPos.getSelectedText().equals("PF") || tPos.getSelectedText() == "pf") {
							main.Player.changeName(pointsTable.j, 3, tname.getSelectedText());
							main.Player.changeGame1(pointsTable.j, 3, tGame1.getSelectedText());
							main.Player.changeGame2(pointsTable.j, 3, tGame2.getSelectedText());
							main.Player.changeGame3(pointsTable.j, 3, tGame3.getSelectedText());
							int Game1 = Integer.parseInt(tGame1.getSelectedText());
							int Game2 = Integer.parseInt(tGame2.getSelectedText());
							int Game3 = Integer.parseInt(tGame3.getSelectedText());
							main.Player.changePointsTotal(pointsTable.j, 3, Game1, Game2, Game3);
							main.functions.changeAllPoints(pointsTable.j);
							main.functions.changeGame1Points(pointsTable.j);
							main.functions.changeGame2Points(pointsTable.j);
							main.functions.changeGame3Points(pointsTable.j);
							main.functions.changeAVG(pointsTable.j);
							console.writeLine("Changed PF - Points");
							console.updateConsole(consoleApp.consoleDisplay);
						}
						if(tPos.getSelectedText().equals("SF") || tPos.getSelectedText() == "sf") {
							main.Player.changeName(pointsTable.j, 4, tname.getSelectedText());
							main.Player.changeGame1(pointsTable.j, 4, tGame1.getSelectedText());
							main.Player.changeGame2(pointsTable.j, 4, tGame2.getSelectedText());
							main.Player.changeGame3(pointsTable.j, 4, tGame3.getSelectedText());
							int Game1 = Integer.parseInt(tGame1.getSelectedText());
							int Game2 = Integer.parseInt(tGame2.getSelectedText());
							int Game3 = Integer.parseInt(tGame3.getSelectedText());
							main.Player.changePointsTotal(pointsTable.j, 4, Game1, Game2, Game3);
							main.functions.changeAllPoints(pointsTable.j);
							main.functions.changeGame1Points(pointsTable.j);
							main.functions.changeGame2Points(pointsTable.j);
							main.functions.changeGame3Points(pointsTable.j);
							main.functions.changeAVG(pointsTable.j);
							console.writeLine("Changed SF - Points");
							console.updateConsole(consoleApp.consoleDisplay);
						}
						if(functions.returnMax(pointsTable.j) == Integer.valueOf(String.valueOf(pointsTable.j.getValueAt(0, 5)))) {
							pointsTable.j.addRowSelectionInterval(0, 0);
						}
						if(functions.returnMax(pointsTable.j) == Integer.valueOf(String.valueOf(pointsTable.j.getValueAt(1, 5)))) {
							pointsTable.j.addRowSelectionInterval(1, 1);
						}
						if(functions.returnMax(pointsTable.j) == Integer.valueOf(String.valueOf(pointsTable.j.getValueAt(2, 5)))) {
							pointsTable.j.addRowSelectionInterval(2, 2);
						}
						if(functions.returnMax(pointsTable.j) == Integer.valueOf(String.valueOf(pointsTable.j.getValueAt(3, 5)))) {
							pointsTable.j.addRowSelectionInterval(3, 3);
						}
						if(functions.returnMax(pointsTable.j) == Integer.valueOf(String.valueOf(pointsTable.j.getValueAt(4, 5)))) {
							pointsTable.j.addRowSelectionInterval(4, 4);
						}
					}
					if(steals.isSelected() == true) {
						if(tPos.getSelectedText().equals("PG") || tPos.getSelectedText() == "pg") {
							main.Player.changeName(stealsTable.j, 0, tname.getSelectedText());
							main.Player.changeGame1(stealsTable.j, 0, tGame1.getSelectedText());
							main.Player.changeGame2(stealsTable.j, 0, tGame2.getSelectedText());
							main.Player.changeGame3(stealsTable.j, 0, tGame3.getSelectedText());
							int Game1 = Integer.parseInt(tGame1.getSelectedText());
							int Game2 = Integer.parseInt(tGame2.getSelectedText());
							int Game3 = Integer.parseInt(tGame3.getSelectedText());
							main.Player.changePointsTotal(stealsTable.j, 0, Game1, Game2, Game3);
							main.functions.changeAllPoints(stealsTable.j);
							main.functions.changeGame1Points(stealsTable.j);
							main.functions.changeGame2Points(stealsTable.j);
							main.functions.changeGame3Points(stealsTable.j);
							main.functions.changeAVG(stealsTable.j);
							console.writeLine("Changed PG - Steals");
							console.updateConsole(consoleApp.consoleDisplay);
						}
						if(tPos.getSelectedText().equals("SG") || tPos.getSelectedText() == "sg") {
							main.Player.changeName(stealsTable.j, 1, tname.getSelectedText());
							main.Player.changeGame1(stealsTable.j, 1, tGame1.getSelectedText());
							main.Player.changeGame2(stealsTable.j, 1, tGame2.getSelectedText());
							main.Player.changeGame3(stealsTable.j, 1, tGame3.getSelectedText());
							int Game1 = Integer.parseInt(tGame1.getSelectedText());
							int Game2 = Integer.parseInt(tGame2.getSelectedText());
							int Game3 = Integer.parseInt(tGame3.getSelectedText());
							main.Player.changePointsTotal(stealsTable.j, 1, Game1, Game2, Game3);
							main.functions.changeAllPoints(stealsTable.j);
							main.functions.changeGame1Points(stealsTable.j);
							main.functions.changeGame2Points(stealsTable.j);
							main.functions.changeGame3Points(pointsTable.j);
							main.functions.changeAVG(stealsTable.j);
							console.writeLine("Changed SG - Steals");
							console.updateConsole(consoleApp.consoleDisplay);
						}
						if(tPos.getSelectedText().equals("C") || tPos.getSelectedText() == "c") {
							main.Player.changeName(stealsTable.j, 2, tname.getSelectedText());
							main.Player.changeGame1(stealsTable.j, 2, tGame1.getSelectedText());
							main.Player.changeGame2(stealsTable.j, 2, tGame2.getSelectedText());
							main.Player.changeGame3(stealsTable.j, 2, tGame3.getSelectedText());
							int Game1 = Integer.parseInt(tGame1.getSelectedText());
							int Game2 = Integer.parseInt(tGame2.getSelectedText());
							int Game3 = Integer.parseInt(tGame3.getSelectedText());
							main.Player.changePointsTotal(stealsTable.j, 2, Game1, Game2, Game3);
							main.functions.changeAllPoints(stealsTable.j);
							main.functions.changeGame1Points(stealsTable.j);
							main.functions.changeGame2Points(stealsTable.j);
							main.functions.changeGame3Points(stealsTable.j);
							main.functions.changeAVG(stealsTable.j);
							console.writeLine("Changed C - Steals");
							console.updateConsole(consoleApp.consoleDisplay);
						}
						if(tPos.getSelectedText().equals("PF") || tPos.getSelectedText() == "pf") {
							main.Player.changeName(stealsTable.j, 3, tname.getSelectedText());
							main.Player.changeGame1(stealsTable.j, 3, tGame1.getSelectedText());
							main.Player.changeGame2(stealsTable.j, 3, tGame2.getSelectedText());
							main.Player.changeGame3(stealsTable.j, 3, tGame3.getSelectedText());
							int Game1 = Integer.parseInt(tGame1.getSelectedText());
							int Game2 = Integer.parseInt(tGame2.getSelectedText());
							int Game3 = Integer.parseInt(tGame3.getSelectedText());
							main.Player.changePointsTotal(stealsTable.j, 3, Game1, Game2, Game3);
							main.functions.changeAllPoints(stealsTable.j);
							main.functions.changeGame1Points(stealsTable.j);
							main.functions.changeGame2Points(stealsTable.j);
							main.functions.changeGame3Points(stealsTable.j);
							main.functions.changeAVG(stealsTable.j);
							console.writeLine("Changed PF - Steals");
							console.updateConsole(consoleApp.consoleDisplay);
						}
						if(tPos.getSelectedText().equals("SF") || tPos.getSelectedText() == "sf") {
							main.Player.changeName(stealsTable.j, 4, tname.getSelectedText());
							main.Player.changeGame1(stealsTable.j, 4, tGame1.getSelectedText());
							main.Player.changeGame2(stealsTable.j, 4, tGame2.getSelectedText());
							main.Player.changeGame3(stealsTable.j, 4, tGame3.getSelectedText());
							int Game1 = Integer.parseInt(tGame1.getSelectedText());
							int Game2 = Integer.parseInt(tGame2.getSelectedText());
							int Game3 = Integer.parseInt(tGame3.getSelectedText());
							main.Player.changePointsTotal(stealsTable.j, 4, Game1, Game2, Game3);
							main.functions.changeAllPoints(stealsTable.j);
							main.functions.changeGame1Points(stealsTable.j);
							main.functions.changeGame2Points(stealsTable.j);
							main.functions.changeGame3Points(stealsTable.j);
							main.functions.changeAVG(stealsTable.j);
							console.writeLine("Changed SF - Steals");
							console.updateConsole(consoleApp.consoleDisplay);
						}
						if(functions.returnMax(stealsTable.j) == Integer.valueOf(String.valueOf(stealsTable.j.getValueAt(0, 5)))) {
							stealsTable.j.addRowSelectionInterval(0, 0);
						}
						if(functions.returnMax(stealsTable.j) == Integer.valueOf(String.valueOf(stealsTable.j.getValueAt(1, 5)))) {
							pointsTable.j.addRowSelectionInterval(1, 1);
						}
						if(functions.returnMax(pointsTable.j) == Integer.valueOf(String.valueOf(stealsTable.j.getValueAt(2, 5)))) {
							stealsTable.j.addRowSelectionInterval(2, 2);
						}
						if(functions.returnMax(stealsTable.j) == Integer.valueOf(String.valueOf(stealsTable.j.getValueAt(3, 5)))) {
							stealsTable.j.addRowSelectionInterval(3, 3);
						}
						if(functions.returnMax(stealsTable.j) == Integer.valueOf(String.valueOf(stealsTable.j.getValueAt(4, 5)))) {
							stealsTable.j.addRowSelectionInterval(4, 4);
						}
					}
					if(rebounds.isSelected() == true) {
						if(tPos.getSelectedText().equals("PG") || tPos.getSelectedText() == "pg") {
							main.Player.changeName(reboundsTable.j, 0, tname.getSelectedText());
							main.Player.changeGame1(reboundsTable.j, 0, tGame1.getSelectedText());
							main.Player.changeGame2(reboundsTable.j, 0, tGame2.getSelectedText());
							main.Player.changeGame3(reboundsTable.j, 0, tGame3.getSelectedText());
							int Game1 = Integer.parseInt(tGame1.getSelectedText());
							int Game2 = Integer.parseInt(tGame2.getSelectedText());
							int Game3 = Integer.parseInt(tGame3.getSelectedText());
							main.Player.changePointsTotal(reboundsTable.j, 0, Game1, Game2, Game3);
							main.functions.changeAllPoints(reboundsTable.j);
							main.functions.changeGame1Points(reboundsTable.j);
							main.functions.changeGame2Points(reboundsTable.j);
							main.functions.changeGame3Points(reboundsTable.j);
							main.functions.changeAVG(reboundsTable.j);
							console.writeLine("Changed PG - Rebounds");
							console.updateConsole(consoleApp.consoleDisplay);
						}
						if(tPos.getSelectedText().equals("SG") || tPos.getSelectedText() == "sg") {
							main.Player.changeName(reboundsTable.j, 1, tname.getSelectedText());
							main.Player.changeGame1(reboundsTable.j, 1, tGame1.getSelectedText());
							main.Player.changeGame2(reboundsTable.j, 1, tGame2.getSelectedText());
							main.Player.changeGame3(reboundsTable.j, 1, tGame3.getSelectedText());
							int Game1 = Integer.parseInt(tGame1.getSelectedText());
							int Game2 = Integer.parseInt(tGame2.getSelectedText());
							int Game3 = Integer.parseInt(tGame3.getSelectedText());
							main.Player.changePointsTotal(reboundsTable.j, 1, Game1, Game2, Game3);
							main.functions.changeAllPoints(reboundsTable.j);
							main.functions.changeGame1Points(reboundsTable.j);
							main.functions.changeGame2Points(reboundsTable.j);
							main.functions.changeGame3Points(reboundsTable.j);
							main.functions.changeAVG(reboundsTable.j);
							console.writeLine("Changed SG - Rebounds");
							console.updateConsole(consoleApp.consoleDisplay);
						}
						if(tPos.getSelectedText().equals("C") || tPos.getSelectedText() == "c") {
							main.Player.changeName(reboundsTable.j, 2, tname.getSelectedText());
							main.Player.changeGame1(reboundsTable.j, 2, tGame1.getSelectedText());
							main.Player.changeGame2(reboundsTable.j, 2, tGame2.getSelectedText());
							main.Player.changeGame3(reboundsTable.j, 2, tGame3.getSelectedText());
							int Game1 = Integer.parseInt(tGame1.getSelectedText());
							int Game2 = Integer.parseInt(tGame2.getSelectedText());
							int Game3 = Integer.parseInt(tGame3.getSelectedText());
							main.Player.changePointsTotal(reboundsTable.j, 2, Game1, Game2, Game3);
							main.functions.changeAllPoints(reboundsTable.j);
							main.functions.changeGame1Points(reboundsTable.j);
							main.functions.changeGame2Points(reboundsTable.j);
							main.functions.changeGame3Points(reboundsTable.j);
							main.functions.changeAVG(reboundsTable.j);
							console.writeLine("Changed C - Rebounds");
							console.updateConsole(consoleApp.consoleDisplay);
						}
						if(tPos.getSelectedText().equals("PF") || tPos.getSelectedText() == "pf") {
							main.Player.changeName(reboundsTable.j, 3, tname.getSelectedText());
							main.Player.changeGame1(reboundsTable.j, 3, tGame1.getSelectedText());
							main.Player.changeGame2(reboundsTable.j, 3, tGame2.getSelectedText());
							main.Player.changeGame3(reboundsTable.j, 3, tGame3.getSelectedText());
							int Game1 = Integer.parseInt(tGame1.getSelectedText());
							int Game2 = Integer.parseInt(tGame2.getSelectedText());
							int Game3 = Integer.parseInt(tGame3.getSelectedText());
							main.Player.changePointsTotal(reboundsTable.j, 3, Game1, Game2, Game3);
							main.functions.changeAllPoints(reboundsTable.j);
							main.functions.changeGame1Points(reboundsTable.j);
							main.functions.changeGame2Points(reboundsTable.j);
							main.functions.changeGame3Points(reboundsTable.j);
							main.functions.changeAVG(reboundsTable.j);
							console.writeLine("Changed PF - Rebounds");
							console.updateConsole(consoleApp.consoleDisplay);
						}
						if(tPos.getSelectedText().equals("SF") || tPos.getSelectedText() == "sf") {
							main.Player.changeName(reboundsTable.j, 4, tname.getSelectedText());
							main.Player.changeGame1(reboundsTable.j, 4, tGame1.getSelectedText());
							main.Player.changeGame2(reboundsTable.j, 4, tGame2.getSelectedText());
							main.Player.changeGame3(reboundsTable.j, 4, tGame3.getSelectedText());
							int Game1 = Integer.parseInt(tGame1.getSelectedText());
							int Game2 = Integer.parseInt(tGame2.getSelectedText());
							int Game3 = Integer.parseInt(tGame3.getSelectedText());
							main.Player.changePointsTotal(reboundsTable.j, 4, Game1, Game2, Game3);
							main.functions.changeAllPoints(reboundsTable.j);
							main.functions.changeGame1Points(reboundsTable.j);
							main.functions.changeGame2Points(reboundsTable.j);
							main.functions.changeGame3Points(reboundsTable.j);
							main.functions.changeAVG(reboundsTable.j);
							console.writeLine("Changed SF - Rebounds");
							console.updateConsole(consoleApp.consoleDisplay);
						}
						if(functions.returnMax(reboundsTable.j) == Integer.valueOf(String.valueOf(reboundsTable.j.getValueAt(0, 5)))) {
							stealsTable.j.addRowSelectionInterval(0, 0);
						}
						if(functions.returnMax(reboundsTable.j) == Integer.valueOf(String.valueOf(reboundsTable.j.getValueAt(1, 5)))) {
							reboundsTable.j.addRowSelectionInterval(1, 1);
						}
						if(functions.returnMax(reboundsTable.j) == Integer.valueOf(String.valueOf(reboundsTable.j.getValueAt(2, 5)))) {
							reboundsTable.j.addRowSelectionInterval(2, 2);
						}
						if(functions.returnMax(reboundsTable.j) == Integer.valueOf(String.valueOf(reboundsTable.j.getValueAt(3, 5)))) {
							reboundsTable.j.addRowSelectionInterval(3, 3);
						}
						if(functions.returnMax(reboundsTable.j) == Integer.valueOf(String.valueOf(reboundsTable.j.getValueAt(4, 5)))) {
							reboundsTable.j.addRowSelectionInterval(4, 4);
						}
					}
					if(fouls.isSelected() == true) {
						if(tPos.getSelectedText().equals("PG") || tPos.getSelectedText() == "pg") {
							main.Player.changeName(foulsTable.j, 0, tname.getSelectedText());
							main.Player.changeGame1(foulsTable.j, 0, tGame1.getSelectedText());
							main.Player.changeGame2(foulsTable.j, 0, tGame2.getSelectedText());
							main.Player.changeGame3(foulsTable.j, 0, tGame3.getSelectedText());
							int Game1 = Integer.parseInt(tGame1.getSelectedText());
							int Game2 = Integer.parseInt(tGame2.getSelectedText());
							int Game3 = Integer.parseInt(tGame3.getSelectedText());
							main.Player.changePointsTotal(foulsTable.j, 0, Game1, Game2, Game3);
							main.functions.changeAllPoints(foulsTable.j);
							main.functions.changeGame1Points(foulsTable.j);
							main.functions.changeGame2Points(foulsTable.j);
							main.functions.changeGame3Points(foulsTable.j);
							main.functions.changeAVG(foulsTable.j);
							console.writeLine("Changed PG - Fouls");
							console.updateConsole(consoleApp.consoleDisplay);
						}
						if(tPos.getSelectedText().equals("SG") || tPos.getSelectedText() == "sg") {
							main.Player.changeName(foulsTable.j, 1, tname.getSelectedText());
							main.Player.changeGame1(foulsTable.j, 1, tGame1.getSelectedText());
							main.Player.changeGame2(foulsTable.j, 1, tGame2.getSelectedText());
							main.Player.changeGame3(foulsTable.j, 1, tGame3.getSelectedText());
							int Game1 = Integer.parseInt(tGame1.getSelectedText());
							int Game2 = Integer.parseInt(tGame2.getSelectedText());
							int Game3 = Integer.parseInt(tGame3.getSelectedText());
							main.Player.changePointsTotal(foulsTable.j, 1, Game1, Game2, Game3);
							main.functions.changeAllPoints(foulsTable.j);
							main.functions.changeGame1Points(foulsTable.j);
							main.functions.changeGame2Points(foulsTable.j);
							main.functions.changeGame3Points(foulsTable.j);
							main.functions.changeAVG(foulsTable.j);
							console.writeLine("Changed SG - Fouls");
							console.updateConsole(consoleApp.consoleDisplay);
						}
						if(tPos.getSelectedText().equals("C") || tPos.getSelectedText() == "c") {
							main.Player.changeName(foulsTable.j, 2, tname.getSelectedText());
							main.Player.changeGame1(foulsTable.j, 2, tGame1.getSelectedText());
							main.Player.changeGame2(foulsTable.j, 2, tGame2.getSelectedText());
							main.Player.changeGame3(foulsTable.j, 2, tGame3.getSelectedText());
							int Game1 = Integer.parseInt(tGame1.getSelectedText());
							int Game2 = Integer.parseInt(tGame2.getSelectedText());
							int Game3 = Integer.parseInt(tGame3.getSelectedText());
							main.Player.changePointsTotal(foulsTable.j, 2, Game1, Game2, Game3);
							main.functions.changeAllPoints(foulsTable.j);
							main.functions.changeGame1Points(foulsTable.j);
							main.functions.changeGame2Points(foulsTable.j);
							main.functions.changeGame3Points(foulsTable.j);
							main.functions.changeAVG(foulsTable.j);
							console.writeLine("Changed C - Fouls");
							console.updateConsole(consoleApp.consoleDisplay);
						}
						if(tPos.getSelectedText().equals("PF") || tPos.getSelectedText() == "pf") {
							main.Player.changeName(foulsTable.j, 3, tname.getSelectedText());
							main.Player.changeGame1(foulsTable.j, 3, tGame1.getSelectedText());
							main.Player.changeGame2(foulsTable.j, 3, tGame2.getSelectedText());
							main.Player.changeGame3(foulsTable.j, 3, tGame3.getSelectedText());
							int Game1 = Integer.parseInt(tGame1.getSelectedText());
							int Game2 = Integer.parseInt(tGame2.getSelectedText());
							int Game3 = Integer.parseInt(tGame3.getSelectedText());
							main.Player.changePointsTotal(foulsTable.j, 3, Game1, Game2, Game3);
							main.functions.changeAllPoints(foulsTable.j);
							main.functions.changeGame1Points(foulsTable.j);
							main.functions.changeGame2Points(foulsTable.j);
							main.functions.changeGame3Points(foulsTable.j);
							main.functions.changeAVG(foulsTable.j);
							console.writeLine("Changed PF - Fouls");
							console.updateConsole(consoleApp.consoleDisplay);
						}
						if(tPos.getSelectedText().equals("SF") || tPos.getSelectedText() == "sf") {
							main.Player.changeName(foulsTable.j, 4, tname.getSelectedText());
							main.Player.changeGame1(foulsTable.j, 4, tGame1.getSelectedText());
							main.Player.changeGame2(foulsTable.j, 4, tGame2.getSelectedText());
							main.Player.changeGame3(foulsTable.j, 4, tGame3.getSelectedText());
							int Game1 = Integer.parseInt(tGame1.getSelectedText());
							int Game2 = Integer.parseInt(tGame2.getSelectedText());
							int Game3 = Integer.parseInt(tGame3.getSelectedText());
							main.Player.changePointsTotal(foulsTable.j, 4, Game1, Game2, Game3);
							main.functions.changeAllPoints(foulsTable.j);
							main.functions.changeGame1Points(foulsTable.j);
							main.functions.changeGame2Points(foulsTable.j);
							main.functions.changeGame3Points(foulsTable.j);
							main.functions.changeAVG(foulsTable.j);
							console.writeLine("Changed SF - Fouls");
							console.updateConsole(consoleApp.consoleDisplay);
						}
						if(functions.returnMax(foulsTable.j) == Integer.valueOf(String.valueOf(foulsTable.j.getValueAt(0, 5)))) {
							stealsTable.j.addRowSelectionInterval(0, 0);
						}
						if(functions.returnMax(foulsTable.j) == Integer.valueOf(String.valueOf(foulsTable.j.getValueAt(1, 5)))) {
							foulsTable.j.addRowSelectionInterval(1, 1);
						}
						if(functions.returnMax(foulsTable.j) == Integer.valueOf(String.valueOf(foulsTable.j.getValueAt(2, 5)))) {
							foulsTable.j.addRowSelectionInterval(2, 2);
						}
						if(functions.returnMax(foulsTable.j) == Integer.valueOf(String.valueOf(foulsTable.j.getValueAt(3, 5)))) {
							foulsTable.j.addRowSelectionInterval(3, 3);
						}
						if(functions.returnMax(foulsTable.j) == Integer.valueOf(String.valueOf(foulsTable.j.getValueAt(4, 5)))) {
							foulsTable.j.addRowSelectionInterval(4, 4);
						}
					}
				}
		    });
		    p1.add(new JLabel());
		    p1.add(new JLabel());
		    p1.add(new JLabel());
		    p1.add(new Components.Button(100, "Reset", true, getForeground(), Colors.colors.Black, new MouseAdapter() {
		    	@Override
			  	public void mouseClicked(MouseEvent e) {
		    		tname.setText("");
		    		tPos.setText("");
		    		tGame1.setText("");
		    		tGame2.setText("");
		    		tGame3.setText("");
		    	}
		    }));
		    
		    p2.add(buttonSave);
		  
		    add(p1, "North");
		  
		    add(p2, "South");
		  
		    setVisible(true);
		  
		    this.setSize(400, 180);
		}
	}
	public static class runtime{
		private static int i = 0;
		public static int seconds = 0;
		public static int minutes = 0;
		public static int hours = 0;
	    public static void run()
	    {
	        ++seconds;
	        if(seconds == 60) {
	        	seconds = 0;
	        	minutes = minutes + 1;
	        }
	        if(minutes == 60) {
	        	minutes = 0;
	        	hours = hours + 1;
	        }
	    }
	    public static void display(JLabel label) {
	    	String second = String.valueOf(seconds);
	    	String minute = String.valueOf(minutes);
	    	String hour = String.valueOf(hours);
	    	if(seconds <=9) {
	    		second = String.format("%02d", seconds);
	    	}
	    	if(minutes <=9) {
	    		minute = String.format("%02d", minutes);
	    	}
	    	if(hours <=9) {
	    		hour = String.format("%02d", hours);
	    	}
	    	String display = hour + ":" + minute + ":" + second;
	    	label.setText(display);
	    }
	}
	public static class runtimeClock extends JPanel{
		public runtimeClock() {
			JLabel timeLable = new Components.Label("Time: ", Colors.colors.darkpurple);
			JLabel time = new Components.Label("", Colors.colors.purple);
			super.add(timeLable);
			super.add(time);
			Timer myTimer = new Timer(1000, new ActionListener(){
			    @Override
			    public void actionPerformed(ActionEvent e) {
			    	runtime.run();
			    	runtime.display(time);
			    }
			});
			myTimer.start();
		}
        
	}
	public static class gameTime extends JPanel{
		public gameTime() {
			Language.Sys.runtime runtime2 = new Language.Sys.runtime();
			JLabel timeLable = new Components.Label("Time: ", Colors.colors.darkpurple);
			JLabel time = new Components.Label("", Colors.colors.purple);
			super.add(timeLable);
			super.add(time);
			Timer myTimer = new Timer(1000, new ActionListener(){
			    @Override
			    public void actionPerformed(ActionEvent e) {
			    	runtime2.run();
			    	runtime2.display(time);
			    }
			});
			super.add(new Components.Button(28, "Start", true, getForeground(), Colors.colors.Black, new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					myTimer.start();
					console.writeLine("Started game time");
					console.updateConsole(consoleApp.consoleDisplay);
				}
			}));
			super.add(new Components.Button(28, "Stop", true, getForeground(), Colors.colors.Black, new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					myTimer.stop();
					console.writeLine("Stopped game time");
					console.updateConsole(consoleApp.consoleDisplay);
				}
			}));
			super.add(new Components.Button(24, "Restart", true, getForeground(), Colors.colors.Black, new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					runtime2.seconds = -1;
					runtime2.minutes = 0;
					runtime2.hours = 0;
					console.writeLine("Game time has been rest");
					console.updateConsole(consoleApp.consoleDisplay);
				}
			}));
		}
	}
	public static class console{
		public static ArrayList<String> consoleArray = new ArrayList<String>();
		public static void writeLine(String text) {
			consoleArray.add(text);
			System.out.print(consoleArray);
		}
		public static void updateConsole(JTextArea Console) {
			String CurrentText = Console.getText();
			Console.setText("");
			for (String i:  consoleArray) {
				consoleApp.consoleDisplay.append("\n" + i);
			}
		}
		public static void clearConsole() {
			consoleArray.clear();
			writeLine("Cleared console");
			updateConsole(consoleApp.consoleDisplay);
		}
	}
	public static class consoleApp extends JFrame{
		public static Components.Textarea consoleDisplay = new Components.Textarea(40, 20, Colors.colors.Black, Colors.colors.gold);
		public consoleApp() {
			super.setTitle("Console");
			super.setBounds(50, 50, 700, 400);
			JPanel consoleArea = new JPanel();
			consoleDisplay.disable();
			consoleArea.add(consoleDisplay);
			super.getContentPane().add(consoleArea, BorderLayout.CENTER);
			super.show();
		}
	}
	public static class playbook extends JFrame{
		static int numberOfPlays = 2;
		public static ArrayList<String> playNames = new ArrayList<String>();
		static DefaultTableModel model = new DefaultTableModel();
		public static JTable j;
		static class methods{
			static Object[] createPlay(String name, String type) {
				Object[] play = {name,type};
				playNames.add(name);
				return play;
			}
			static void addData() {
				model.addRow(createPlay("Fresno","Offense"));
				model.addRow(createPlay("23","Defense"));
			}
			public static void addData(Object[] data) {
				model.addRow(data);
			}
			static void clearData(int row) {
				model.removeRow(row);
			}
		}
		public playbook() {
			super.setTitle("Playbook");
			super.setBounds(50, 50, 700, 400);
			String[] Columns = {"Play Name","Type"};
			j = new JTable(model) {
		        public boolean editCellAt(int row, int column, java.util.EventObject e) {
		        return false;
		     }
		    };
		    for (int i = 0; i < Columns.length; i++) {
		    	if(model.getColumnCount() <= 1) {
		    		model.addColumn(Columns[i]);
		    	}
		    	else {
		    		
		    	}
		    }
		    if(model.getRowCount() != numberOfPlays) {
		    	for(int i = 0; i < model.getRowCount(); i++) {
		    		methods.clearData(i);
		    	}
		    	methods.addData();
		    }
		    console.writeLine("Added playbook data");
			console.updateConsole(consoleApp.consoleDisplay);
		    JScrollPane sp = new JScrollPane(j);
			sp.getVerticalScrollBar().setBackground(Colors.colors.lightblue);
			super.getContentPane().add(sp, BorderLayout.CENTER);
			super.show();
		}
	}
	public static class playDisplay extends JFrame{
		public playDisplay() {
			playbook.methods.addData();
			JPanel display = new JPanel();
			Components.Label text = new Components.Label("",Colors.colors.Black);
			text.setFont(text.getFont().deriveFont(108.0f));
			display.add(text);
			JPanel buttons = new JPanel();
			for(int i = 0; i < playbook.playNames.size(); i++) {
				String TextDisplay = playbook.playNames.get(i);
				int size = 0;
				if(TextDisplay.length() == 2) {
					size = 30;
				}
				else if(TextDisplay.length() == 3) {
					size = 29;
				}
				else if(TextDisplay.length() == 4) {
					size = 28;
				}
				else if(TextDisplay.length() == 5) {
					size = 26;
				}
				else if(TextDisplay.length() == 6) {
					size = 24;
				}
				else if(TextDisplay.length() == 7) {
					size = 23;
				}
				else if(TextDisplay.length() == 8) {
					size = 20;
				}
				buttons.add(new Components.Button(size, TextDisplay, true, Colors.colors.Black, Colors.colors.Black, new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						text.setText(TextDisplay);
					}
				}));
			}
			JFrame displayWin = new Components.Window(50, 100, 1000, 700, "Display", new JPanel(), new JPanel(), buttons, new JPanel(), display);
		}
	}
	public static class scoring extends JFrame{
		static int homePoints = 0;
		static int awayPoints = 0;
		static String homeName = "";
		static String awayName = "";
		static JLabel homeTeamNameLabel = new JLabel();
		static JLabel awayTeamNameLabel = new JLabel();
		public static TreeMap<String,Integer> currentPlayerPoints = new TreeMap<String,Integer>();
		static class functions{
			static String returnHomeName(String name) {
				return name;
			}
			static String returnAwayName(String name) {
				return name;
			}
			static void addHomePoints(int points) {
				homePoints = homePoints + points;
				homeTeamNameLabel.setText(homeName + ": " + Integer.toString(homePoints));
			}
			static void addAwayPoints(int points) {
				awayPoints = awayPoints + points;
				awayTeamNameLabel.setText(awayName + ": " + Integer.toString(awayPoints));
			}
			static void resetData() {
				homePoints = 0;
				awayPoints = 0;
				homeTeamNameLabel.setText(homeName + ": " + Integer.toString(homePoints));
				awayTeamNameLabel.setText(awayName + ": " + Integer.toString(awayPoints));
			}
			static void addPointsToPlayer(int points) {
				JPanel center = new JPanel();
				Components.Window stats = new Components.Window(10, 10, 300, 300, "Edit Player", new JPanel(), new JPanel(), new JPanel(), new JPanel(), center);
				Set<String> keys = benchEdit.players.keySet();	
		        //iterate using forEach
		        keys.forEach( key -> {        
		        	String TextDisplay = key;
		        	int size = 0;
		        	if(TextDisplay.length() == 2) {
						size = 30;
					}
					else if(TextDisplay.length() == 3) {
						size = 29;
					}
					else if(TextDisplay.length() == 4) {
						size = 28;
					}
					else if(TextDisplay.length() == 5) {
						size = 26;
					}
					else if(TextDisplay.length() == 6) {
						size = 24;
					}
					else if(TextDisplay.length() == 7) {
						size = 23;
					}
					else if(TextDisplay.length() == 8) {
						size = 20;
					}
		            center.add(new Components.Button(size, key, true, Colors.colors.Black, Colors.colors.Black, new MouseAdapter() {
		            	 public void mouseClicked(MouseEvent me) {
		            		 if(currentPlayerPoints.containsKey(key)) {
		            			 int returnPoints = currentPlayerPoints.get(key) + points;
		            			 currentPlayerPoints.replace(key, returnPoints);
		            		 }
		            		 else {
		            			 currentPlayerPoints.put(key, points);
		            		 }
		            		 stats.dispose();
		            		 currentPoints.functions.updateTable();
		            	 }
		            }));
		        });
			}
		}
		public scoring() {
			/* Enter Teams Names */
			JDialog enterTeamsDialog = new JDialog();
			enterTeamsDialog.setBounds(50, 50, 400, 200);
			enterTeamsDialog.setTitle("Enter Team Names");
			Components.Label setHomeLabel = new Components.Label("Home:", Colors.colors.Black);
			Components.Label setawayLabel = new Components.Label("Away:", Colors.colors.Black);
			Components.Textfield setHome = new Components.Textfield(10, Colors.colors.Black, Colors.colors.Black);
			Components.Textfield setAway = new Components.Textfield(10, Colors.colors.Black, Colors.colors.Black);
			Components.Button setNames = new Components.Button(28, "Set", true, Colors.colors.Black, Colors.colors.Black, new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					homeName = functions.returnHomeName(setHome.getText());
					awayName = functions.returnHomeName(setAway.getText());
					homeTeamNameLabel.setText(homeName);
					awayTeamNameLabel.setText(awayName);
					enterTeamsDialog.dispose();
				}
			});
			JPanel set = new JPanel();
			set.add(setHomeLabel);
			set.add(setHome);
			set.add(setawayLabel);
			set.add(setAway);
			set.add(setNames);
			enterTeamsDialog.getContentPane().add(set,BorderLayout.CENTER);
			enterTeamsDialog.show();
			/* Program */
			JPanel panel = new JPanel();
			JPanel panel2 = new JPanel();
			super.setBounds(50, 50, 500, 500);
			super.setTitle("Scoring");
			super.show();
			//panel.setLayout(new GridLayout(1,2));
			// row 1
			panel.add(homeTeamNameLabel);
			panel.add(new JLabel());
			panel.add(awayTeamNameLabel);
			
			panel2.add(new Components.Button(25, "Points", true, Colors.colors.Black, Colors.colors.Black, new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JFrame points = new JFrame();
					points.setBounds(50, 50, 600, 125);
					points.show();
					JPanel northButtonPanel = new JPanel();
					JPanel southButtonPanel = new JPanel();
					JPanel centerButtonPanel = new JPanel();
					northButtonPanel.add(new JLabel("Add Points:"));
					northButtonPanel.add(new Components.Button(24, "Home 1", true, Colors.colors.Black, Colors.colors.Black, new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							functions.addHomePoints(1);
							functions.addPointsToPlayer(1);
						}
					}));
					northButtonPanel.add(new Components.Button(24, "Home 2", true, Colors.colors.Black, Colors.colors.Black, new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							functions.addHomePoints(2);
							functions.addPointsToPlayer(2);
						}
					}));
					northButtonPanel.add(new Components.Button(23, "Home 3", true, Colors.colors.Black, Colors.colors.Black, new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							functions.addHomePoints(3);
							functions.addPointsToPlayer(3);
						}
					}));
					northButtonPanel.add(new Components.Button(24, "Away 1", true, Colors.colors.Black, Colors.colors.Black, new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							functions.addAwayPoints(1);
						}
					}));
					northButtonPanel.add(new Components.Button(24, "Away 2", true, Colors.colors.Black, Colors.colors.Black, new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							functions.addAwayPoints(2);
						}
					}));
					northButtonPanel.add(new Components.Button(23, "Away 3", true, Colors.colors.Black, Colors.colors.Black, new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							functions.addAwayPoints(3);
						}
					}));
					
					southButtonPanel.add(new JLabel("Subtract Points:"));
					southButtonPanel.add(new Components.Button(24, "Home 1", true, Colors.colors.Black, Colors.colors.Black, new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							functions.addHomePoints(-1);
							functions.addPointsToPlayer(-1);
						}
					}));
					southButtonPanel.add(new Components.Button(24, "Home 2", true, Colors.colors.Black, Colors.colors.Black, new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							functions.addHomePoints(-2);
							functions.addPointsToPlayer(-2);
						}
					}));
					southButtonPanel.add(new Components.Button(23, "Home 3", true, Colors.colors.Black, Colors.colors.Black, new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							functions.addHomePoints(-3);
							functions.addPointsToPlayer(-3);
						}
					}));
					southButtonPanel.add(new Components.Button(24, "Away 1", true, Colors.colors.Black, Colors.colors.Black, new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							functions.addAwayPoints(-1);
						}
					}));
					southButtonPanel.add(new Components.Button(24, "Away 2", true, Colors.colors.Black, Colors.colors.Black, new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							functions.addAwayPoints(-2);
						}
					}));
					southButtonPanel.add(new Components.Button(23, "Away 3", true, Colors.colors.Black, Colors.colors.Black, new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							functions.addAwayPoints(-3);
						}
					}));
					centerButtonPanel.add(new Components.Button(26, "Reset", true, Colors.colors.Black, Colors.colors.Black, new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							functions.resetData();
						}
					}));
					points.getContentPane().add(northButtonPanel,BorderLayout.NORTH);
					points.getContentPane().add(southButtonPanel,BorderLayout.SOUTH);
					points.getContentPane().add(centerButtonPanel,BorderLayout.CENTER);
					
				}
			}));
			
			super.getContentPane().add(panel,BorderLayout.CENTER);
			super.getContentPane().add(panel2,BorderLayout.SOUTH);
			
		}
	}
	public static class benchEdit extends JFrame{
		public static TreeMap<String, Player> players = new TreeMap<String,Player>();
		public benchEdit(String Name, String Pos) {
			Components.Label game1Label = new Components.Label("Game 1:", Colors.colors.Black);
			Components.Textfield game1 = new Components.Textfield(10, Colors.colors.Black, Colors.colors.Black);
			Components.Label game2Label = new Components.Label("Game 2:", Colors.colors.Black);
			Components.Textfield game2 = new Components.Textfield(10, Colors.colors.Black, Colors.colors.Black);
			Components.Label game3Label = new Components.Label("Game 3:", Colors.colors.Black);
			Components.Textfield game3 = new Components.Textfield(10, Colors.colors.Black, Colors.colors.Black);
			JPanel center = new JPanel();
			center.add(game1Label);
			center.add(game1);
			center.add(game2Label);
			center.add(game2);
			center.add(game3Label);
			center.add(game3);
			center.add(new Components.Button(28, "Add", true, Colors.colors.Black, Colors.colors.Black, new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int points1 = Integer.parseInt(game1.getText()); 
					int points2 = Integer.parseInt(game2.getText());
					int points3 = Integer.parseInt(game3.getText()); 
					players.put(Name,new Player(Name,Pos,points1,points2,points3));
					managementTable.bench.dispose();
					String totalPoints = managementTable.methods.getTotalPoints(managementTable.j.getValueAt(managementTable.row_getSelected, 1).toString(), 
							managementTable.j.getValueAt(managementTable.row_getSelected, 0).toString());
					String lastgame = managementTable.methods.getLastGamePoints(managementTable.j.getValueAt(managementTable.row_getSelected, 1).toString(), 
							managementTable.j.getValueAt(managementTable.row_getSelected, 0).toString());
					String gameInfo = "Last Game: " + lastgame + " - Last 3: " + totalPoints; 
					managementTable.pointsLabel.setText(gameInfo);
				}
			}));
			super.getContentPane().add(center);
		}
	}
	public static class managementTable extends JPanel {
		public static JTable j = new JTable();
		public static JFrame bench;
		public static Components.Window main;
		static DefaultTableModel model = new DefaultTableModel();
		public static int row_getSelected;
		public static JLabel pointsLabel;
		static class methods{
			static void newPlayer(String name,String pos,int number,String lineup) {
				Player player = new Player(name,pos,number,lineup);
				Object[] data = {player.returnName(),player.returnPos(),player.returnNumber(),player.returnLineup()};
				model.addRow(data);
			}
			static String getTotalPoints(String Pos, String Name) {
				bench = new benchEdit(Name,Pos);
				if(Pos.equals("PG") && Name.equals(pointsTable.PG.returnName())) {
					return Integer.toString(pointsTable.PG.returnPoints());
				}
				else if(Pos.equals("SG") && Name.equals(pointsTable.SG.returnName())) {
					return Integer.toString(pointsTable.SG.returnPoints());
				}
				else if(Pos.equals("C") && Name.equals(pointsTable.C.returnName())) {
					return Integer.toString(pointsTable.C.returnPoints());
				}
				else if(Pos.equals("PF") && Name.equals(pointsTable.PF.returnName())) {
					return Integer.toString(pointsTable.PF.returnPoints());
				}
				else if(Pos.equals("SF") && Name.equals(pointsTable.SF.returnName())) {
					return Integer.toString(pointsTable.SF.returnPoints());
				}
				else {
					
					if(benchEdit.players.size() == 0 || !benchEdit.players.containsKey(Name)) {
						bench.show();
						bench.setBounds(50, 50, 600, 500);
						return "No data available";
					}	
					else {
						return Integer.toString(benchEdit.players.get(Name).returnPoints());
					}
				}
			}
			static String getLastGamePoints(String Pos, String Name) {
				if(Pos.equals("PG") && Name.equals(pointsTable.PG.returnName())) {
					return Integer.toString(pointsTable.PG.returnGame3());
				}
				else if(Pos.equals("SG") && Name.equals(pointsTable.SG.returnName())) {
					return Integer.toString(pointsTable.SG.returnGame3());
				}
				else if(Pos.equals("C") && Name.equals(pointsTable.C.returnName())) {
					return Integer.toString(pointsTable.C.returnGame3());
				}
				else if(Pos.equals("PF") && Name.equals(pointsTable.PF.returnName())) {
					return Integer.toString(pointsTable.PF.returnGame3());
				}
				else if(Pos.equals("SF") && Name.equals(pointsTable.SF.returnName())) {
					return Integer.toString(pointsTable.SF.returnGame3());
				}
				else {
					if(benchEdit.players.size() == 0 || !benchEdit.players.containsKey(Name)) {
						return "No data available";
					}	
					else {
						return Integer.toString(benchEdit.players.get(Name).returnGame3());
					}
				}
			}
		}
		public managementTable() {	
			String[] Columns = {"Name","Pos","Number","Lineup"};
			Object[] blank = {"","","",""};
		    j = new JTable(model) {
		            public boolean editCellAt(int row, int column, java.util.EventObject e) {
		        return false;
		     }
		    };
		    for (int i = 0; i < Columns.length; i++) {
		             model.addColumn(Columns[i]);
		    }
			JScrollPane sp = new JScrollPane(j);
			sp.getVerticalScrollBar().setBackground(Colors.colors.lightblue);
			super.add(sp);
			j.addMouseListener(new MouseAdapter() {
		         public void mouseClicked(MouseEvent me) {
		            if (me.getClickCount() == 2) {
		               JTable target = (JTable)me.getSource();
		               int row = target.getSelectedRow();
		               if(j.getValueAt(row, 3) == "Starter") {
		            	   j.setValueAt("Bench", row, 3);
		            	   new managementDialog(j);
		               }
		               else if (j.getValueAt(row, 3) == "Bench") {
		            	   j.setValueAt("Starter", row, 3);
		            	   new managementDialog(j);
		               }
		            }
		         }
		    });
			j.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == e.VK_SPACE) {
						JTable target = (JTable)e.getSource();
			            int row = target.getSelectedRow();
			            if(j.getValueAt(row, 3) == "Starter") {
			            	j.setValueAt("Bench", row, 3);
			            }
			            else if (j.getValueAt(row, 3) == "Bench") {
			            	j.setValueAt("Starter", row, 3);
			            	new managementDialog(j);
			            }	
					}
				}
			});
			j.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == e.VK_ENTER) {
						JTable target = (JTable)e.getSource();
						int row = target.getSelectedRow();
						row_getSelected = row;
						String playerInfo = j.getValueAt(row, 0) + " - "  + j.getValueAt(row, 1) + " - " + j.getValueAt(row, 2) + " - " + j.getValueAt(row, 3);
						JPanel north = new JPanel();
						JLabel playerLabel = new Components.Label(playerInfo,Colors.colors.Black);
						north.add(playerLabel);
						JPanel center = new JPanel();
						String totalPoints = methods.getTotalPoints(j.getValueAt(row, 1).toString(), j.getValueAt(row, 0).toString());
						String lastgame = methods.getLastGamePoints(j.getValueAt(row, 1).toString(), j.getValueAt(row, 0).toString());
						String gameInfo = "Last Game: " + lastgame + " - Last 3: " + totalPoints; 
						pointsLabel = new Components.Label(gameInfo, Colors.colors.Black);
						center.add(pointsLabel);
						/* Window Configs */
						String title = j.getValueAt(row, 1).toString();
						main = new Components.Window(25, 25, 350, 300, title, north, new JPanel(), new JPanel(), new JPanel(), center);
					}
			    }
			});
		    j.addKeyListener(new KeyAdapter() {
		        public void keyPressed(KeyEvent e) {
		          int row = j.getSelectedRow();
		          if(e.getKeyCode() == e.VK_ESCAPE) {
		        	  j.removeRowSelectionInterval(row, row);
		          }
		        }
		    });
			methods.newPlayer("Skyler", "PG",1,"Starter");
			methods.newPlayer("Zane", "SG",2,"Starter");
			methods.newPlayer("David", "C",3,"Starter");
			methods.newPlayer("Carson", "PF",4,"Starter");
			methods.newPlayer("Ethan", "SF",5,"Starter");
			model.addRow(blank);
			methods.newPlayer("Jackson", "PG",6,"Bench");
			methods.newPlayer("Avery", "SG",7,"Bench");
			methods.newPlayer("Noah", "C",8,"Bench");
			methods.newPlayer("Jack", "PF",9,"Bench");
			methods.newPlayer("Toby", "SF",10,"Bench");
			console.writeLine("Loaded bench players");
			console.updateConsole(consoleApp.consoleDisplay);
		}
	}
	public static class management extends JFrame{
		public management() {
			super.setTitle("Management");
			super.setBounds(100, 100, 500, 500);
			super.show();
			super.getContentPane().add(new managementTable(),BorderLayout.CENTER);
		}
	}
	public static class managementDialog extends JFrame{
		public static class functions{
			public static void changeByKey(String Name) {
				if(benchEdit.players.get(Name).returnPos() == "PG") {
					pointsTable.j.setValueAt(benchEdit.players.get(Name).returnName(), 0, 0);
					pointsTable.j.setValueAt(benchEdit.players.get(Name).returnGame1(), 0, 2);
					pointsTable.j.setValueAt(benchEdit.players.get(Name).returnGame2(), 0, 3);
					pointsTable.j.setValueAt(benchEdit.players.get(Name).returnGame3(), 0, 4);
					pointsTable.j.setValueAt(benchEdit.players.get(Name).returnPoints(), 0, 5);
				}
				else if(benchEdit.players.get(Name).returnPos() == "SG") {
					pointsTable.j.setValueAt(benchEdit.players.get(Name).returnName(), 1, 0);
					pointsTable.j.setValueAt(benchEdit.players.get(Name).returnGame1(), 1, 2);
					pointsTable.j.setValueAt(benchEdit.players.get(Name).returnGame2(), 1, 3);
					pointsTable.j.setValueAt(benchEdit.players.get(Name).returnGame3(), 1, 4);
					pointsTable.j.setValueAt(benchEdit.players.get(Name).returnPoints(), 1, 5);
				}
				else if(benchEdit.players.get(Name).returnPos() == "C") {
					pointsTable.j.setValueAt(benchEdit.players.get(Name).returnName(), 2, 0);
					pointsTable.j.setValueAt(benchEdit.players.get(Name).returnGame1(), 2, 2);
					pointsTable.j.setValueAt(benchEdit.players.get(Name).returnGame2(), 2, 3);
					pointsTable.j.setValueAt(benchEdit.players.get(Name).returnGame3(), 2, 4);
					pointsTable.j.setValueAt(benchEdit.players.get(Name).returnPoints(), 2, 5);
				}
				else if(benchEdit.players.get(Name).returnPos() == "PF") {
					pointsTable.j.setValueAt(benchEdit.players.get(Name).returnName(), 3, 0);
					pointsTable.j.setValueAt(benchEdit.players.get(Name).returnGame1(), 3, 2);
					pointsTable.j.setValueAt(benchEdit.players.get(Name).returnGame2(), 3, 3);
					pointsTable.j.setValueAt(benchEdit.players.get(Name).returnGame3(), 3, 4);
					pointsTable.j.setValueAt(benchEdit.players.get(Name).returnPoints(), 3, 5);
				}
				else if(benchEdit.players.get(Name).returnPos() == "SF") {
					pointsTable.j.setValueAt(benchEdit.players.get(Name).returnName(), 4, 0);
					pointsTable.j.setValueAt(benchEdit.players.get(Name).returnGame1(), 4, 2);
					pointsTable.j.setValueAt(benchEdit.players.get(Name).returnGame2(), 4, 3);
					pointsTable.j.setValueAt(benchEdit.players.get(Name).returnGame3(), 4, 4);
					pointsTable.j.setValueAt(benchEdit.players.get(Name).returnPoints(), 4, 5);
				}
				main.functions.changeAllPoints(pointsTable.j);
				main.functions.changeGame1Points(pointsTable.j);
				main.functions.changeGame2Points(pointsTable.j);
				main.functions.changeGame3Points(pointsTable.j);
				main.functions.changeAVG(pointsTable.j);
			}
			public static void changeByExsisting(String Pos) {
				if(Pos == "PG") {
					pointsTable.j.setValueAt(pointsTable.PG.returnName(), 0, 0);
					pointsTable.j.setValueAt(pointsTable.PG.returnGame1(), 0, 2);
					pointsTable.j.setValueAt(pointsTable.PG.returnGame2(), 0, 3);
					pointsTable.j.setValueAt(pointsTable.PG.returnGame3(), 0, 4);
					pointsTable.j.setValueAt(pointsTable.PG.returnPoints(), 0, 5);
				}
				else if(Pos == "SG") {
					pointsTable.j.setValueAt(pointsTable.SG.returnName(), 1, 0);
					pointsTable.j.setValueAt(pointsTable.SG.returnGame1(), 1, 2);
					pointsTable.j.setValueAt(pointsTable.SG.returnGame2(), 1, 3);
					pointsTable.j.setValueAt(pointsTable.SG.returnGame3(), 1, 4);
					pointsTable.j.setValueAt(pointsTable.SG.returnPoints(), 1, 5);
				}
				else if(Pos == "C") {
					pointsTable.j.setValueAt(pointsTable.C.returnName(), 2, 0);
					pointsTable.j.setValueAt(pointsTable.C.returnGame1(), 2, 2);
					pointsTable.j.setValueAt(pointsTable.C.returnGame2(), 2, 3);
					pointsTable.j.setValueAt(pointsTable.C.returnGame3(), 2, 4);
					pointsTable.j.setValueAt(pointsTable.C.returnPoints(), 2, 5);
				}
				else if(Pos == "PF") {
					pointsTable.j.setValueAt(pointsTable.PF.returnName(), 3, 0);
					pointsTable.j.setValueAt(pointsTable.PF.returnGame1(), 3, 2);
					pointsTable.j.setValueAt(pointsTable.PF.returnGame2(), 3, 3);
					pointsTable.j.setValueAt(pointsTable.PF.returnGame3(), 3, 4);
					pointsTable.j.setValueAt(pointsTable.PF.returnPoints(), 3, 5);
				}
				else if(Pos == "SF") {
					pointsTable.j.setValueAt(pointsTable.SF.returnName(), 4, 0);
					pointsTable.j.setValueAt(pointsTable.SF.returnGame1(), 4, 2);
					pointsTable.j.setValueAt(pointsTable.SF.returnGame2(), 4, 3);
					pointsTable.j.setValueAt(pointsTable.SF.returnGame3(), 4, 4);
					pointsTable.j.setValueAt(pointsTable.SF.returnPoints(), 4, 5);
				}
				main.functions.changeAllPoints(pointsTable.j);
				main.functions.changeGame1Points(pointsTable.j);
				main.functions.changeGame2Points(pointsTable.j);
				main.functions.changeGame3Points(pointsTable.j);
				main.functions.changeAVG(pointsTable.j);
			}
		}
		public managementDialog(JTable table) {
			JFrame main = this;
			super.setBounds(50, 50, 600, 300);
			JPanel panel = new JPanel();
			Components.Button button = new Components.Button(23, "Change", true, Colors.colors.Black, Colors.colors.Black, new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent me) {
					int row = table.getSelectedRow();
					if(benchEdit.players.size() == 0 || !benchEdit.players.containsKey(table.getValueAt(row, 0).toString())) {
						JFrame frame = new JFrame();
						frame.show();
						frame.setBounds(50, 50, 600, 300);
						Components.Label game1Label = new Components.Label("Game 1:", Colors.colors.Black);
						Components.Textfield game1 = new Components.Textfield(10, Colors.colors.Black, Colors.colors.Black);
						Components.Label game2Label = new Components.Label("Game 2:", Colors.colors.Black);
						Components.Textfield game2 = new Components.Textfield(10, Colors.colors.Black, Colors.colors.Black);
						Components.Label game3Label = new Components.Label("Game 3:", Colors.colors.Black);
						Components.Textfield game3 = new Components.Textfield(10, Colors.colors.Black, Colors.colors.Black);
						JPanel center = new JPanel();
						center.add(game1Label);
						center.add(game1);
						center.add(game2Label);
						center.add(game2);
						center.add(game3Label);
						center.add(game3);
						center.add(new Components.Button(28, "Add", true, Colors.colors.Black, Colors.colors.Black, new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								int points1 = Integer.parseInt(game1.getText()); 
								int points2 = Integer.parseInt(game2.getText());
								int points3 = Integer.parseInt(game3.getText()); 
								benchEdit.players.put(table.getValueAt(row, 0).toString(),new Player(table.getValueAt(row, 0).toString(),table.getValueAt(row, 1).toString(),points1,points2,points3));
								if(benchEdit.players.containsKey(table.getValueAt(row, 0))) {
					            	functions.changeByKey(table.getValueAt(row, 0).toString());
					            }
					            else {
					            	functions.changeByExsisting(table.getValueAt(row, 1).toString());
					            }
								frame.dispose();
								
							}
						}));
						frame.getContentPane().add(center,BorderLayout.CENTER);
					}
					else {
						if(benchEdit.players.containsKey(table.getValueAt(row, 0))) {
			            	functions.changeByKey(table.getValueAt(row, 0).toString());
			            }
			            else {
			            	functions.changeByExsisting(table.getValueAt(row, 1).toString());
			            }
					}
					main.dispose();
		        }
			});
			panel.add(button);
			super.getContentPane().add(panel, BorderLayout.CENTER);
			if(button.isSelected() == true) {
				super.dispose();
			}
			super.show();
		}
	}
	public static class winPercentageChart extends JPanel{
	    BufferedImage image;
	    final int PAD = 30;
	    Font font;
	    NumberFormat numberFormat;
		public winPercentageChart()
	    {
	        font = new Font("Book Antiqua", Font.BOLD, 20);
	        numberFormat = NumberFormat.getPercentInstance();
	        addComponentListener(new ComponentAdapter(){});
	    }
		protected void paintComponent(Graphics graphics)
	    {
	        super.paintComponent(graphics);
	        Graphics2D graphics2d = (Graphics2D)graphics;
	        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	                            RenderingHints.VALUE_ANTIALIAS_ON);
	        createChartImage();
	        graphics2d.drawImage(image, 0, 0, this);
	    }
	    private void createChartImage()
	    {
	        double[] marks = {predictionModel.homePrediction,predictionModel.awayPrediction};
	        int width = getWidth();
	        int height = getHeight();
	        int cp = width/2;
	        int cq = height/2;
	        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	        Graphics2D g2 = image.createGraphics();
	        g2.setPaint(Colors.colors.white);
	        g2.fillRect(0, 0, width, height);
	        g2.setPaint(Color.black);
	        int pie = java.lang.StrictMath.min(width,height) - 2*PAD;
	        g2.draw(new Ellipse2D.Double(cp - pie/2, cq - pie/2, pie, pie));
	        double total = 0;
	        for(int j = 0; j < marks.length; j++)
	            total += marks[j];
	        double theta = 0, phi = 0;
	        double p, q;
	        for(int j = 0; j < marks.length; j++)
	        {
	            p = cp + (pie/2) * java.lang.StrictMath.cos(theta);
	            q = cq + (pie/2) * java.lang.StrictMath.sin(theta);
	            g2.draw(new Line2D.Double(cp, cq, p, q));
	            phi = (marks[j]/total) * 2 * java.lang.StrictMath.PI;
	            p = cp + (9*pie/24) * java.lang.StrictMath.cos(theta + phi/2);
	            q = cq + (9*pie/24) * java.lang.StrictMath.sin(theta + phi/2);
	            g2.setFont(font);
	            String st = String.valueOf(String.format("%.3f",marks[j]));
	            FontRenderContext frc = g2.getFontRenderContext();
	            float textWidth = (float)font.getStringBounds(st, frc).getWidth();
	            LineMetrics lm = font.getLineMetrics(st, frc);
	            float sp = (float)(p - textWidth/2);
	            float sq = (float)(q + lm.getAscent()/2);
	            g2.drawString(st, sp, sq);
	            p = cp + (pie/2 + 4*PAD/5) * java.lang.StrictMath.cos(theta + phi/2);
	            q = cq + (pie/2 + 4*PAD/5) * java.lang.StrictMath.sin(theta+ phi/2);
	            st = numberFormat.format(marks[j]/total);
	            textWidth = (float)font.getStringBounds(st, frc).getWidth();
	            lm = font.getLineMetrics(st, frc);
	            sp = (float)(p - textWidth/2);
	            sq = (float)(q + lm.getAscent()/2);
	            g2.drawString(st, sp, sq);
	            theta += phi;
	        }
	        g2.dispose();
	    }
	}
	public static class winPercentage extends JFrame{
		public winPercentage() {
			super.getContentPane().add(new winPercentageChart());
		    super.setSize(400, 450);
		    super.setVisible(true);
		}
	}
	public static class currentPoints extends JFrame{
		static DefaultTableModel model = new DefaultTableModel();
		static JTable j;
		static class functions{
			static void updateTable() {
				for(int i = model.getRowCount() - 1; i >= 0; i--) {
					model.removeRow(i);
				}
				for(Map.Entry m:scoring.currentPlayerPoints.entrySet()){    
					Object[] row = {m.getKey(),m.getValue()};
					if(m.getValue().equals(0)) {
						
					}
					else {
						model.addRow(row);   
					}
			    }
				TableRowSorter<TableModel> sorter = new TableRowSorter<>(j.getModel());
				j.setRowSorter(sorter);
				List<RowSorter.SortKey> sortKeys = new ArrayList<>();
				 
				int columnIndexToSort = 1;
				sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));
				 
				sorter.setSortKeys(sortKeys);
				sorter.sort();
			}
		}
		public currentPoints() {
			super.setBounds(10, 10, 500, 550);
			super.setTitle("Player Points");
			super.show();
			JPanel center = new JPanel();
			JPanel south = new JPanel();
			Components.Label home = new Components.Label("", Colors.colors.Black);
			Components.Label away = new Components.Label("", Colors.colors.Black);
			String[] Columns = {"Name","Points"};
		    j = new JTable(model) {
		            public boolean editCellAt(int row, int column, java.util.EventObject e) {
		            	return false;
		            }
		    };
		    for(int i = 0; i < Columns.length; i++) {
		    	if(model.getColumnName(i) == Columns[i]) {
		    		
		    	}
		    	else {
		    		model.addColumn(Columns[i]);
		    	}
		    }
	    	for(Map.Entry m:scoring.currentPlayerPoints.entrySet()){
		    	Object[] row = {m.getKey(),m.getValue()};
		    	model.addRow(row);   
		    }
			JScrollPane sp = new JScrollPane(j);
			sp.getVerticalScrollBar().setBackground(Colors.colors.lightblue);
			center.add(sp);
			super.getContentPane().add(center,BorderLayout.CENTER);
			south.add(home);
			south.add(away);
			super.getContentPane().add(south,BorderLayout.SOUTH);
			Components.Menu.menuItem[] predictionItem = {new menuItem("Score", new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Components.Textfield homeScored = new Components.Textfield(10, Colors.colors.Black, Colors.colors.Black);
					Components.Textfield homeAllowed = new Components.Textfield(10, Colors.colors.Black, Colors.colors.Black);
					Components.Textfield awayScored = new Components.Textfield(10, Colors.colors.Black, Colors.colors.Black);
					Components.Textfield awayAllowed = new Components.Textfield(10, Colors.colors.Black, Colors.colors.Black);
					JPanel North = new JPanel();
					North.add(new Components.Label("Home - Points Scored :",Colors.colors.Black));
					North.add(homeScored);
					North.add(new Components.Label("Home - Points Allowed :",Colors.colors.Black));
					North.add(homeAllowed);
					JPanel Center = new JPanel();
					Center.add(new Components.Label("Away - Points Scored :",Colors.colors.Black));
					Center.add(awayScored);
					Center.add(new Components.Label("Away - Points Allowed :",Colors.colors.Black));
					Center.add(awayAllowed);
					JPanel South = new JPanel();
					Components.Window win = new Components.Window(10, 10, 550, 125, "Set Predictions", North, new JPanel(), South, new JPanel(), Center);
					South.add(new Components.Button(26, "Set", true, Colors.colors.Black, Colors.colors.Black, new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int homeScoredNumber = Integer.parseInt(homeScored.getText());
							int homeAllowedNumber = Integer.parseInt(homeAllowed.getText());
							int awayScoredNumber = Integer.parseInt(awayScored.getText());
							int awayAllowedNumber = Integer.parseInt(awayAllowed.getText());
							home.setText(predictionModel.formatedHomePrediction(homeScoredNumber, homeAllowedNumber));
							away.setText(predictionModel.formatedAwayPrediction(awayScoredNumber, awayAllowedNumber));
							new winPercentage();
							win.dispose();
						}
					}));
				}
			})};
			Components.Menu.menu[] items = {new Components.Menu.menu("Prediction", predictionItem)};
			super.setJMenuBar(new Components.Menu.menuBar(items));
		}
	}
	public static void main(String args[]) {
		String[] TabsString = {"Points","Steals","Rebounds","Fouls","Edit","Game Time","Time","Runtime"};
		JPanel[] Tabs = {new pointsTable(),new stealsTable(),new reboundsTable(),new foulsTable(),new editTab(),new gameTime(),new Bundle.TimeInfo(),new runtimeClock()};
		Color[] Foreground = {Colors.colors.Black,Colors.colors.Black,Colors.colors.Black,Colors.colors.Black,Colors.colors.Black,Colors.colors.Black,Colors.colors.Black,Colors.colors.Black};
		Components.Tabs Tab = new Components.Tabs(TabsString, Tabs, Foreground, 500, 500);
		JFrame win = new Components.Window(0, 0, 1000, 600, "Basketball Stats", new JPanel(), new JPanel(), new JPanel(), new JPanel(),Tab,new WindowAdapter() {
	         
	    });
		/* JMenu */
		Components.Menu.menuItem[] features = {new menuItem("Playbook", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				console.writeLine("Loaded playbook");
				console.updateConsole(consoleApp.consoleDisplay);
				new playbook();
			}
		}),new menuItem("Console", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				console.writeLine("Loaded playbook");
				console.updateConsole(consoleApp.consoleDisplay);
				new consoleApp();
			}
		}),new menuItem("Management",new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				console.writeLine("Loaded Management");
				console.updateConsole(consoleApp.consoleDisplay);
				new management();
			}
		})};
		Components.Menu.menuItem[] consoleOptions = {new menuItem("Clear", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				console.clearConsole();
			}
		})};
		Components.Menu.menuItem[] playbookOptions = {new menuItem("Add", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<String> filter = new ArrayList<String>();
				JPanel addDataPanel = new JPanel();
				Components.Label name = new Components.Label("Name:", Colors.colors.Black);
				Components.Label type = new Components.Label("Type:", Colors.colors.Black);
				Components.Textfield nameField = new Components.Textfield(10, Colors.colors.Black, Colors.colors.Black);
				Components.Textfield typeField = new Components.Textfield(10, Colors.colors.Black, Colors.colors.Black);
				addDataPanel.add(name);
				addDataPanel.add(nameField);
				addDataPanel.add(type);
				addDataPanel.add(typeField);
				JPanel filterPanel = new JPanel();
				Components.Label filterText = new Components.Label("", Colors.colors.Black);
				filterPanel.add(filterText);
				addDataPanel.add(new Components.Button(28, "Add", true, Colors.colors.Black, Colors.colors.Black, new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(filter.contains(nameField.getText()) == true) {
							filterText.setText("Play already in table");
							filterText.setForeground(Colors.colors.brightred);
						}
						else {
							Object[] data = {nameField.getText(),typeField.getText()};
							filter.add(nameField.getText());
							playbook.methods.addData(data);
							filterText.setText("Play added to table");
							filterText.setForeground(Colors.colors.green);
							console.writeLine("Added play to playbook");
							console.updateConsole(consoleApp.consoleDisplay);
						}
					}
				}));
				JFrame data = new Components.Window(50, 100, 500, 200, "Add Data", new JPanel(), new JPanel(), filterPanel, new JPanel(), addDataPanel);
			}
		}),new menuItem("Display", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new playDisplay();
				console.writeLine("Opened playbook display");
				console.updateConsole(consoleApp.consoleDisplay);
			}
		})};
		Components.Menu.menuItem[] scoringOptions = {new menuItem("Score", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				new scoring();
				console.writeLine("Loaded scoring");
				console.updateConsole(consoleApp.consoleDisplay);
			}
		}),new menuItem("Points", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				new currentPoints();
				console.writeLine("Loaded player points");
				console.updateConsole(consoleApp.consoleDisplay);
			}
		})};
		Components.Menu.menu[] items = {new Components.Menu.menu("Features", features),new Components.Menu.menu("Console", consoleOptions), new Components.Menu.menu("Playbook", playbookOptions),
				new Components.Menu.menu("Scoring",scoringOptions)};
		win.setJMenuBar(new Components.Menu.menuBar(items));
		new consoleApp();
		console.writeLine("Loaded program and console");
		console.writeLine("Loaded players");
		console.updateConsole(consoleApp.consoleDisplay);
	}
}