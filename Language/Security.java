package Language;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JDialog;

public class Security {
	public static class Initialize{
		public static int newCode(int Bounds) {
			int code = new Random().nextInt(Bounds);
			return code;
		}
		public static int newCode() {
			int code = new Random().nextInt(1000);
			return code;
		}
	}
	public static boolean Verify(int initializeCode,String input) {
		int codeInput = Integer.valueOf(input);
		if(initializeCode == codeInput) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean Verify(String username, String password) {
		String user = "root";
		String pass = "root";
		if(username.equals(user) && password.equals(pass)) {
			return true;
		}
		else {
			return false;
		}
	}
}