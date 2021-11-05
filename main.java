import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



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
            DecimalFormat df = new DecimalFormat("#.###");
			double points = totalPoints / 3;
			return df.format(points);
		}
	}
	public static class pointsTable extends JPanel{
		public pointsTable(){
		    JTable j;
		    DefaultTableModel model = new DefaultTableModel();
		    Player PG = new Player("Skyler","PG",15,20,18);
		    Player SG = new Player("Zane","SG",10,15,12);
		    Player C =  new Player("David","C",15,17,13);
		    Player PF = new Player("Carson","PF",15,13,17);
		    Player SF = new Player("Ethan","SF",17,15,17);
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
		}
		
	}
	public static class stealsTable extends JPanel{
		public stealsTable(){
		    JTable j;
		    DefaultTableModel model = new DefaultTableModel();
		    Player PG = new Player("Skyler","PG",3,2,3);
		    Player SG = new Player("Zane","SG",1,0,2);
		    Player C =  new Player("David","C",0,1,2);
		    Player PF = new Player("Carson","PF",1,1,1);
		    Player SF = new Player("Ethan","SF",1,1,2);
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
		}
		
	}
	public static class reboundsTable extends JPanel{
		public reboundsTable(){
		    JTable j;
		    DefaultTableModel model = new DefaultTableModel();
		    Player PG = new Player("Skyler","PG",6,6,7);
		    Player SG = new Player("Zane","SG",6,7,8);
		    Player C =  new Player("David","C",5,6,7);
		    Player PF = new Player("Carson","PF",8,6,8);
		    Player SF = new Player("Ethan","SF",7,8,7);
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
		}
	}
	public static class foulsTable extends JPanel{
		public foulsTable(){
		    JTable j;
		    DefaultTableModel model = new DefaultTableModel();
		    Player PG = new Player("Skyler","PG",1,2,1);
		    Player SG = new Player("Zane","SG",1,3,2);
		    Player C =  new Player("David","C",1,1,2);
		    Player PF = new Player("Carson","PF",1,0,1);
		    Player SF = new Player("Ethan","SF",1,0,0);
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
		}
	}
	public static void main(String args[]) {
		String[] TabsString = {"Points","Steals","Rebounds","Fouls"};
		JPanel[] Tabs = {new pointsTable(),new stealsTable(),new reboundsTable(),new foulsTable()};
		Color[] Foreground = {Colors.colors.Black,Colors.colors.Black,Colors.colors.Black,Colors.colors.Black};
		Components.Tabs Tab = new Components.Tabs(TabsString, Tabs, Foreground, 500, 500);
		JFrame win = new Components.Window(0, 0, 1000, 600, "Basketball Stats", new JPanel(), new JPanel(), new JPanel(), new JPanel(),Tab,new WindowAdapter() {
	         
	    });
	}
}