package dp;

//https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
public class RodCutting {
	public static void main(String args[]) {
		RodCutting obj = new RodCutting();
//		int lenArr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
//		int priceArr[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
		int lenArr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int priceArr[] = { 3, 5, 8, 9, 10, 17, 17, 20 };
		System.out.println(obj.maxPrice(lenArr.length, 0, lenArr, priceArr));
	}

	public int maxPrice(int remLength, int index, int lenArr[], int priceArr[]) {
		if (remLength == 0 || index >= lenArr.length || lenArr[index] > remLength)
			return 0;

		int quantity = (int) Math.floor(remLength / lenArr[index]);
		int curLen = lenArr[index];
		int curPrice = priceArr[index];

		if (index == lenArr.length - 1) {
			if (remLength % curLen == 0)
				return curPrice * quantity;
			else
				return 0;
		}
		int len;
		int cost = Integer.MIN_VALUE;
		for (int i = 0; i <= quantity; i++) {
			len = remLength - (i * curLen);
			int result = maxPrice(len, index + 1, lenArr, priceArr);
			cost = Math.max(cost, result + (i * curPrice));
		}
		return cost;
	}
}
