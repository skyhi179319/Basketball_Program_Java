import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.util.Arrays;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import Components.Bundle;

public class main {
	public static class Player{
		private String Name;
		private String Pos;
		private int Game1;
		private int Game2;
		private int Game3;
		public Player(String name, String pos, int game1, int game2, int game3) {
			Name = name;
			Pos = pos;
			Game1 = game1;
			Game2 = game2;
			Game3 = game3;
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
			double points = totalPoints / 3;
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
	public static class pointsTable extends JPanel{
		 public static JTable j;
		 public static Player PG = new Player("Skyler","PG",15,20,18);
		 public static Player SG = new Player("Zane","SG",10,15,12);
		 public static Player C =  new Player("David","C",15,17,13);
		 public static Player PF = new Player("Carson","PF",15,13,17);
		 public static Player SF = new Player("Ethan","SF",17,15,17);
		 public pointsTable(){
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
		public editTab() {
			JPanel p1 = new JPanel();
			p1.setLayout(new GridLayout(7, 2));
			  
		    FlowLayout layout = new FlowLayout();
		  
		    JPanel p2 = new JPanel();
		  
		    // set the layout
		    p2.setLayout(layout);
		  
		    JLabel lName, lPos, lGame1, lGame2, lGame3;
		  
		    JTextField tname, tPos,tGame1, tGame2, tGame3;
		  
		    JButton buttonSave;
		  
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
	    	String display = hours + ":" + minutes + ":" + seconds;
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
		    	String display = hours + ":" + minutes + ":" + seconds;
		    	label.setText(display);
		    }
		}
		public gameTime() {
			JLabel timeLable = new Components.Label("Time: ", Colors.colors.darkpurple);
			JLabel time = new Components.Label("", Colors.colors.purple);
			super.add(timeLable);
			super.add(time);
			Timer myTimer = new Timer(1000, new ActionListener(){
			    @Override
			    public void actionPerformed(ActionEvent e) {
			    	gameTime.runtime.run();
			    	gameTime.runtime.display(time);
			    }
			});
			super.add(new Components.Button(28, "Start", true, getForeground(), Colors.colors.Black, new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					myTimer.start();
				}
			}));
			super.add(new Components.Button(28, "Stop", true, getForeground(), Colors.colors.Black, new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					myTimer.stop();
				}
			}));
		}
	}
	public static void main(String args[]) {
		String[] TabsString = {"Points","Steals","Rebounds","Fouls","Edit","Game Time","Time","Runtime"};
		JPanel[] Tabs = {new pointsTable(),new stealsTable(),new reboundsTable(),new foulsTable(),new editTab(),new gameTime(),new Bundle.TimeInfo(),new runtimeClock()};
		Color[] Foreground = {Colors.colors.Black,Colors.colors.Black,Colors.colors.Black,Colors.colors.Black,Colors.colors.Black,Colors.colors.Black,Colors.colors.Black,Colors.colors.Black};
		Components.Tabs Tab = new Components.Tabs(TabsString, Tabs, Foreground, 500, 500);
		JFrame win = new Components.Window(0, 0, 1000, 600, "Basketball Stats", new JPanel(), new JPanel(), new JPanel(), new JPanel(),Tab,new WindowAdapter() {
	         
	    });
		
	}
}