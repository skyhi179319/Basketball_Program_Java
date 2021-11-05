package Language;

public class Console {
	public static void Log(String String) {
		System.out.println(String);
	}
	public static void Log(int X) {
		System.out.println(X);
	}
	public static void Log(boolean Boolean) {
		System.out.println(Boolean);
	}
	public static void Log(Object Object) {
		System.out.println(Object);
	}
	public static void Log(String[] String) {
		for (int i = 0; i < String.length; i++) {
			System.out.println(String[i]);
		}
	}
	public static void Log(int[] X) {
		for (int i = 0; i < X.length; i++) {
			System.out.println(X[i]);
		}
	}
	public static void Log(boolean[] Boolean) {
		for (int i = 0; i < Boolean.length; i++) {
			System.out.println(Boolean[i]);
		}
	}
	public static void Log(Object[] Object) {
		for (int i = 0; i < Object.length; i++) {
			System.out.println(Object[i]);
		}
	}
}