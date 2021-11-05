package Language;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Application {
	public static void changeText(JLabel Component, String Text) {
		Component.setText(Text);
	}
	public static void changeText(JTextField Component, String Text) {
		Component.setText(Text);
	}
	public static void updateTable(DefaultTableModel Model,TreeMap<String,String> Data) {
		//  Deletes All Rows And Refreshes The Content
        int rowCount = Model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
           Model.removeRow(i);
        }
        for (String i : Data.keySet()) {
	         Object[] set = {i,Data.get(i)};
	         Model.addRow(set);
	    }
	}
	public static void clearText(JTextField Field) {
		Field.setText("");
	}
	public static void deleteRow(JTable J ,DefaultTableModel Model) {
		if(J.getSelectedRow() != -1) {
            // remove selected row from the model
            Model.removeRow(J.getSelectedRow());
         }
	}
	public static void writeFile(String Filename,String text) {
		try {
	         String file = Filename;
	         FileWriter myWriter = new FileWriter(file);
	         myWriter.write(text);
	         myWriter.close();
	      } catch (IOException e) {
	         Language.Console.Log("An error occurred.");
	         e.printStackTrace();
	      }
	}
	public static void writeFile(String Filename, String[] text) {
		try {
	         String file = Filename;
	         FileWriter myWriter = new FileWriter(file);
	         for (int i = 0; i < text.length; i++) {
        	 	myWriter.write(text[i] + "\r\n");
	         }
	         myWriter.close();
	      } catch (IOException e) {
	         System.out.println("An error occurred.");
	         e.printStackTrace();
	      }
	}
	public static void writeFile(String Filename, Object[] text) {
		try {
	         String file = Filename;
	         FileWriter myWriter = new FileWriter(file);
	         for (int i = 0; i < text.length; i++) {
        	 	myWriter.write(text[i] + "\r\n");
	         }
	         myWriter.close();
	      } catch (IOException e) {
	         System.out.println("An error occurred.");
	         e.printStackTrace();
	      }
	}
	public static String readSingleLine(String Filename) {
		try
		{
			BufferedReader Reader = new BufferedReader(new FileReader(Filename));
	        String Line1 = Reader.readLine();
	        return Line1;
		}
		catch(IOException f) {
			return "Error: " + f.getMessage();
		}
		
	}
	public static Object[] readFile(String Filename) {
		ArrayList<String> obj = new ArrayList<String>();
		try
		{
	        Scanner myReader = new Scanner(new File(Filename));
	        while (myReader.hasNextLine()) {
	          String data = myReader.nextLine();
	          obj.add(data);
	        }
	        return obj.toArray();
		}
		catch(IOException f) {
			obj.add(f.getMessage());
			return obj.toArray();
		}
	}
	public static void updateTime(JLabel label) {
		DateTimeFormatter Cdtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");  
		LocalDateTime current = LocalDateTime.now(); 
		label.setText(Cdtf.format(current));
	}
	public static void exitApplication() {
		System.exit(0);
	}
}