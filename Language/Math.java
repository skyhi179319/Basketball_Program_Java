package Language;

public class Math {
	public static int Sum(int Number1,int Number2) {
		return Number1 + Number2;
	}
	public static int Sum(int[] Numbers) {
		int math = 0;
		for (int i = 0; i < Numbers.length; i++) {
			math = math + Numbers[i];
		}
		return math;
	}
	public static int Sum(int[] add,int[] sub) {
		int mathadd = 0;
		int mathsub = 0;
		for (int i = 0; i < add.length; i++) {
			mathadd = mathadd + add[i];
		}
		for (int i = 0; i < sub.length; i++) {
			mathsub = mathsub - sub[i];
		}
		return mathadd + mathsub;
	}
	public static int Sum(int[] add,int[] sub,int div1, int div2) {
		int mathadd = 0;
		int mathsub = 0;
		int mathdiv = div1 / div2;
		for (int i = 0; i < add.length; i++) {
			mathadd = mathadd + add[i];
		}
		for (int i = 0; i < sub.length; i++) {
			mathsub = mathsub - sub[i];
		}
		return mathadd + mathsub + mathdiv;
	}
	public static int Sum(int[] add,int[] sub,int div1, int div2,int[] mult) {
		int mathadd = 0;
		int mathsub = 0;
		int mathdiv = div1 / div2;
		int mathmult = 0;
		for (int i = 0; i < add.length; i++) {
			mathadd = mathadd + add[i];
		}
		for (int i = 0; i < sub.length; i++) {
			mathsub = mathsub - sub[i];
		}
		for (int i = 0; i < mult.length; i++) {
			mathsub = mathmult * mult[i];
		}
		return mathadd + mathsub + mathmult + mathdiv;
	}
	public static int Avg(int[] Numbers) {
		int math = 0;
		for (int i = 0; i < Numbers.length; i++) {
			math = math + Numbers[i];
		}
		return math / Numbers.length;
	}
	public static int Count(int[] Numbers) {
		return Numbers.length;
	}
	public static int Min(int Number1, int Number2) {
		return java.lang.Math.min(Number1, Number2);
	}
	public static int Max(int Number1, int Number2) {
		return java.lang.Math.max(Number1, Number2);
	}
}