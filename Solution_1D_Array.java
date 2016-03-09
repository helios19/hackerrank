package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_1D_Array {

	public static final void main(String[] args) {

		Scanner cin = new Scanner(System.in);

		int testcases = cin.nextInt();

		while (testcases-- > 0) {
			int n = cin.nextInt();
			int m = cin.nextInt();

			List<Integer> matrix = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				matrix.add(cin.nextInt());
			}

			// find the biggest consecutive suite of 1
			int indFirstOne = matrix.indexOf(1);
			if (indFirstOne < 0) {
				System.out.println("YES");
				continue;
			}

			int maxNumOne = 1, tmp = 1;

			for (int i = indFirstOne + 1; i < n && maxNumOne < m; i++) {
				if (matrix.get(i) == 1) {
					tmp++;
				} else {
					if (tmp > maxNumOne) {
						maxNumOne = tmp;				
					}
					//reset tmp
					tmp = 0;
				}
			}

			if(m > maxNumOne) {
				System.out.println("YES");
			} else {
				 System.out.println("NO");
			}
		}
	}	
}
