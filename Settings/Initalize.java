package Settings;

import java.awt.Color;

import Colors.colors.Palettes;

public class Initalize {
	public static class Tabs{
		//public static Color select = new Color(Palettes.Gradients.Yellow.primary.getRGB());
		//public static Color deselect = new Color(Palettes.Gradients.Yellow.secondary.getRGB());
		public static Color select = new Color(Palettes.Yellow.Gold.getRGB());
		public static Color deselect = new Color(Palettes.Yellow.Yellow.getRGB());
	}
	public static class Bundle{
		public static class TimeInfo{
			public static Color labelForeground = Colors.colors.blue;
			public static Color timeForeground = Colors.colors.purple;
		}
	}
	public static class Menu{
		public static Color menuItemBackground = Colors.colors.whitesmoke;
	}
}