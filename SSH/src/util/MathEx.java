package util;

public class MathEx {
	public static int randomInt(int minInt, int maxInt) {
		if (maxInt <= minInt)
			maxInt = minInt;
		int num = (int) (Math.round(Math.random() * (maxInt - minInt) + minInt));
		return num;
	}
}
