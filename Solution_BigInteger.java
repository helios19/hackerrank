package hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution_BigInteger {

	public static final void main(String[] args) {
		Scanner cin = new Scanner(System.in);

		BigInteger b1 = cin.nextBigInteger();
		BigInteger b2 = cin.nextBigInteger();

		System.out.println(b1.add(b2));
		System.out.println(b1.multiply(b2));
	}
}
