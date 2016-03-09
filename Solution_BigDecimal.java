package hackerrank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_BigDecimal {

	public static void main(String[] args) {

		Scanner cin = new Scanner(System.in);
		int testcases = cin.nextInt();
		List<Tuple<BigDecimal, String>> tupleList = new ArrayList<>();

		for (int i = 0; i < testcases; i++) {
			String s = cin.next();
			tupleList.add(new Tuple<BigDecimal, String>(new BigDecimal(s), s));
		}

		tupleList.stream().sorted((x, y) -> y.getKey().compareTo(x.getKey()))
				.forEach(x -> System.out.println(x.getValue()));
	}

	public static class Tuple<U, V> {
		public final U key;
		public final V value;

		public Tuple(U key, V value) {
			super();
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return String.format("(%s, %s)", key, value);
		}

		public U getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}
	}

	
	
//    public static void main(String[] args) {
//        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//        
//        //Input
//        Scanner userInput = new Scanner(System.in);
//        int arraySize = Integer.parseInt(userInput.nextLine());
//        String [] array = new String[arraySize];
//        for (int i = 0; i < arraySize; i++) {
//            array[i] = userInput.nextLine();
//        }
//        
//        //Sorting (Selection)
//        for (int i = 0; i < (array.length - 1); i++) {
//            for (int k = (i + 1); k < array.length; k++) {
//                if (new BigDecimal(array[i]).compareTo(new BigDecimal(array[k])) < 0) {
//                    String tempValue = array[i];
//                    array[i] = array[k];
//                    array[k] = tempValue;
//                }
//            }
//        }
//        
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }
//    }	
	
}
