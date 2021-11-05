package Components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import Language.Application;

public class Bundle {
	public static class Search extends JPanel{
		public static ArrayList<JTextField> TextfieldComponents = new ArrayList<JTextField>();
		public Search(MouseListener event) {
			JTextField Search = new Components.Textfield(10, getForeground(), getBackground());
			super.add(Search);
			super.add(new Components.Button(24, "Search", true, getForeground(), Colors.colors.silver,event));
			super.updateUI();
			TextfieldComponents.add(Search);
		}
	}
	public static class Add extends JPanel{
		public static ArrayList<JTextField> TextfieldComponents = new ArrayList<JTextField>();
		public Add(MouseListener event) {
			JTextField Add = new Components.Textfield(10, getForeground(), getBackground());
			super.add(Add);
			super.add(new Components.Button(28, "Add", true, getForeground(), Colors.colors.silver,event));
			super.updateUI();
			TextfieldComponents.add(Add);
		}
	}
	public static class InfoForm extends JPanel{
		public static ArrayList<JLabel> LableComponents = new ArrayList<JLabel>();
		public static ArrayList<JTextField> TextfieldComponents = new ArrayList<JTextField>();
		public ArrayList<JButton> ButtonComponents = new ArrayList<JButton>();
		public InfoForm(MouseListener event) {
			JLabel FirstnameL = new Components.Label("Firstname :", getForeground());
			super.add(FirstnameL);
			JTextField Firstname =  new Components.Textfield(10, getForeground(), getBackground());
			super.add(Firstname);
			JLabel LastnameL = new Components.Label("Lastname :", getForeground());
			super.add(LastnameL);
			JTextField Lastname =  new Components.Textfield(10, getForeground(), getBackground());
			super.add(Lastname);
			JButton Button = new Components.Button(28, "Add", true, getForeground(), Colors.colors.silver,event);
			super.add(Button);
			LableComponents.add(FirstnameL);
			LableComponents.add(LastnameL);
			TextfieldComponents.add(Firstname);
			TextfieldComponents.add(Lastname);
			ButtonComponents.add(Button);
		}
		public InfoForm(JComponent[] comp,MouseListener event) {
			JLabel FirstnameL = new Components.Label("Firstname :", getForeground());
			super.add(FirstnameL);
			JTextField Firstname =  new Components.Textfield(10, getForeground(), getBackground());
			super.add(Firstname);
			JLabel LastnameL = new Components.Label("Lastname :", getForeground());
			super.add(LastnameL);
			JTextField Lastname =  new Components.Textfield(10, getForeground(), getBackground());
			super.add(Lastname);
			JButton Button = new Components.Button(28, "Add", true, getForeground(), Colors.colors.silver,event);
			JComponent age0 = comp[0];
			super.add(age0);
			JComponent age1 = comp[1];
			super.add(age1);
			super.add(Button);
			LableComponents.add(FirstnameL);
			LableComponents.add(LastnameL);
			TextfieldComponents.add(Firstname);
			TextfieldComponents.add(Lastname);
			ButtonComponents.add(Button);
		}
	}
	public static class TimeInfo extends JPanel {
		public TimeInfo() {
			JLabel timeLable = new Components.Label("Time: ", Settings.Initalize.Bundle.TimeInfo.labelForeground);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now(); 
			JLabel time = new Components.Label(dtf.format(now), Settings.Initalize.Bundle.TimeInfo.timeForeground);
			super.add(timeLable);
			super.add(time);
			Timer myTimer = new Timer(1000, new ActionListener(){
			    @Override
			    public void actionPerformed(ActionEvent e) {
			    	Application.updateTime(time);
			    }
			});
			myTimer.start();
		}
		
	}
}