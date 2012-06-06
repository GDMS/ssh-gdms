package util;

public class MathEx {
	public static int randomInt(int minInt, int maxInt) {
		if (maxInt <= minInt)
			maxInt = minInt;
		int num = (int) (Math.round(Math.random() * (maxInt - minInt) + minInt));
		return num;
	}

	public static float round1(float num) {
		float result = (float) (Math.round(num * 10)) / 10;
		return result;
	}

	public static float round(float num, int bit) {
		int n = (int) Math.pow(10, bit);
		float result = (float) (Math.round(num * n)) / n;
		return result;
	}
}
