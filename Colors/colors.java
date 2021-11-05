package Colors;

import java.awt.*;

public class colors {
	// Special
    public static Color info = new Color(242,242,189);
    public static Color info2 = new Color(238,238,168);
    public static Color info3 = new Color(229,229,125);
    // White
    public static Color white = new Color(Color.white.getRGB());
    public static Color whitesmoke = new Color(	245, 245, 245);
    // Red
    public static Color red = new Color(255,0,0);
    public static Color lightred = new Color(255,51,51);
    public static Color brightred = new Color(204,0,0);
    public static Color firebrick = new Color(174,34,34);
    // Green
    public static Color green = new Color(0,153,0);
    public static Color lightgreen = new Color(144, 238, 144);
    public static Color darkgreen = new Color(0,100,0);
    public static Color brightgreen = new Color(102,255,0);
    // Blue
    public static Color blue = new Color(51, 51, 255);
    public static Color lightblue = new Color(118,179,184);
    public static Color darkblue = new Color(0,0,153);
    public static Color brightblue = new Color(30,144,255);
    // Yellow
    public static Color yellow = new Color(255,255,0);
    public static Color lightyellow = new Color(255,255,224);
    public static Color gold = new Color(255, 215, 0);
    public static Color darkgoldenrod = new Color(184,134,11);
    // Purple
    public static Color purple = new Color(225,0,127);
    public static Color lightpurple = new Color(255,51,153);
    public static Color darkpurple = new Color(153,0,76);
    // Gray
    public static Color gray = new Color(128,128,128);
    public static Color darkgray = new Color(169,169,169);
    public static Color dimgray = new Color(105,105,105);
    public static Color silver = new Color(192,192,192);
    public static Color slategray = new Color(112,128,144);
    public static Color lightslategray = new Color(119,136,153);
    // Black
    public static Color Black = Color.black;
    public static class Palettes{
    	private static Color[] BasicPalette = {red,green,blue,yellow,gold,purple,gray,silver,slategray,white};
    	private static Color[] LightPalette = {lightred,lightgreen,lightblue,lightyellow,gold,lightpurple,silver,lightslategray};
    	private static Color[] DarkPalette = {firebrick,darkgreen,darkblue,darkgoldenrod,darkpurple,darkgray,slategray};
    	private static Color[] BrightPalette = {brightred,brightgreen,brightblue};
    	private static Color[] RedPalette = {red,lightred,brightred,firebrick};
    	private static Color[] GreenPalette = {green,lightgreen,darkgreen,brightgreen};
    	private static Color[] BluePalette = {blue,lightblue,darkblue,brightblue};
    	private static Color[] YellowPalette = {yellow,lightyellow,gold,darkgoldenrod};
    	private static Color[] PurplePalette = {purple,lightpurple,darkpurple};
    	private static Color[] GrayPalette = {gray,darkgray,dimgray,silver,slategray,lightslategray};
    	private static Color[] WhitePalette = {white,whitesmoke};
    	private static Color[] DefaultPalette = {lightred,firebrick,lightgreen,darkgreen,lightblue,lightyellow,gold,darkgoldenrod,info};
    	private static Color[] SpecialPalette = {info,info2,info3};
    	public static class Basic{
    		public static Color Red = BasicPalette[0];
    		public static Color Green = BasicPalette[1];
    		public static Color Blue = BasicPalette[2];
    		public static Color Yellow = BasicPalette[3];
    		public static Color Gold = BasicPalette[4];
    		public static Color Purple = BasicPalette[5];
    		public static Color Gray = BasicPalette[6];
    		public static Color Silver = BasicPalette[7];
    		public static Color Slategray = BasicPalette[8];
    		public static Color White = BasicPalette[9];
    	}
    	public static class Light{
    		public static Color Lightred = LightPalette[0];
    		public static Color Lightgreen = LightPalette[1];
    		public static Color Lightblue = LightPalette[2];
    		public static Color Lightyellow = LightPalette[3];
    		public static Color Gold = LightPalette[4];
    		public static Color Lightpurple = LightPalette[5];
    		public static Color Silver = LightPalette[6];
    		public static Color Lightslategray = LightPalette[7];
    	}
    	public static class Dark{
    		public static Color Firebrick = DarkPalette[0];
    		public static Color Darkgreen = DarkPalette[1];
    		public static Color Darkblue = DarkPalette[2];
    		public static Color Darkgoldenrod = DarkPalette[3];
    		public static Color Darkpurple = DarkPalette[4];
    		public static Color Darkgray = DarkPalette[5];
    		public static Color Slategray = DarkPalette[6];
    	}
    	public static class Bright{
    		public static Color Brightred = BrightPalette[0];
    		public static Color Brightgreen = BrightPalette[1];
    		public static Color Brightblue = BrightPalette[2];
    	}
    	public static class Red{
    		public static Color Red = RedPalette[0];
    		public static Color Lightred = RedPalette[1];
    		public static Color Brightred = RedPalette[2];
    		public static Color Firebrick = RedPalette[3];
    	}
    	public static class Green{
    		public static Color Green = GreenPalette[0];
    		public static Color Lightgreen = GreenPalette[1];
    		public static Color Darkgreen = GreenPalette[2];
    		public static Color Brightgreen = GreenPalette[3];
    	}
    	public static class Blue{
    		public static Color Blue = BluePalette[0];
    		public static Color Lightblue = BluePalette[1];
    		public static Color Darkblue = BluePalette[2];
    		public static Color Brightblue = BluePalette[3];
    	}
    	public static class Yellow{
    		public static Color Yellow = YellowPalette[0];
    		public static Color Lightyellow = YellowPalette[1];
    		public static Color Gold = YellowPalette[2];
    		public static Color Darkgoldenrod = YellowPalette[3];
    	}
    	public static class Purple{
    		public static Color Purple = PurplePalette[0];
    		public static Color Lightpurple = PurplePalette[1];
    		public static Color Darkpurple = PurplePalette[2];
    	}
    	public static class Gray{
    		public static Color Gray = GrayPalette[0];
    		public static Color Darkgray = GrayPalette[1];
    		public static Color Dimgray = GrayPalette[2];
    		public static Color Silver = GrayPalette[3];
    		public static Color Slategray = GrayPalette[4];
    		public static Color Lightslategray = GrayPalette[5];
    	}
    	public static class White{
    		public static Color White = WhitePalette[0];
    		public static Color Whitesmoke = WhitePalette[1];
    	}
    	public static class Default{
    		public static Color Lightred = DefaultPalette[0];
    		public static Color Firebrick = DefaultPalette[1];
    		public static Color Lightgreen = DefaultPalette[2];
    		public static Color Darkgreen = DefaultPalette[3];
    		public static Color Lightblue = DefaultPalette[4];
    		public static Color Lightyellow = DefaultPalette[5];
    		public static Color Gold = DefaultPalette[6];
    		public static Color Darkgoldenrod = DefaultPalette[7];
    		public static Color Info = DefaultPalette[8];
    	}
    	public static class Special{
    		public static Color Info = SpecialPalette[0];
    		public static Color Info2 = SpecialPalette[1];
    		public static Color Info3 = SpecialPalette[2];
    	}
    	public static Basic Basic = new Basic();
    	public static Light Light = new Light();
    	public static Dark Dark = new Dark();
    	public static Bright Bright = new Bright();
    	public static Red Red = new Red();
    	public static Green Green = new Green();
    	public static Blue Blue = new Blue();
    	public static Yellow Yellow = new Yellow();
    	public static Purple Purple = new Purple();
    	public static Gray Gray = new Gray();
    	public static White White = new White();
    	public static Default Default = new Default();
    	public static Special Special = new Special();
    	public static class Gradients{
    		public static class YellowGradient{
    			public static Color primary = YellowPalette[2];
    			public static Color secondary = YellowPalette[1];
    			public static Color mixture = SpecialPalette[0];
    		}
    		public static YellowGradient Yellow = new YellowGradient();
    	}
    	public static Gradients Gradient = new Gradients();
    }
}