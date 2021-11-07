package Language;

import javax.swing.JLabel;

public class Sys{
	public static class runtime{
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
		public static String returnString() {
		    if(seconds == 60) {
		    	seconds = 0;
		    	minutes = minutes + 1;
		    }
		    if(minutes == 60) {
		    	minutes = 0;
		    	hours = hours + 1;
		    }
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
			String time = hour + ":" + minute + ":" + second;
			return time;
		}
	}
}