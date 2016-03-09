package hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class Solution_Stack {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);

		// list of parenthesis tuples
		Tuple curly = new Tuple("{", "}"), parenthesis = new Tuple("(", ")"), bracket = new Tuple("[", "]");

		Tuple[] parenthesiz = { curly, parenthesis, bracket };

		List<String> openParenthesis = Arrays.stream(parenthesiz).map(x -> x.getOpenParenthesis())
				.collect(Collectors.toList());

		List<String> closeParenthesis = Arrays.stream(parenthesiz).map(x -> x.getCloseParenthesis())
				.collect(Collectors.toList());

		lineLoop: while (cin.hasNextLine()) {

			Stack<Tuple> stack = new Stack<>();

			char[] line = cin.nextLine().toCharArray();

			characterLoop: for (char c : line) {

				String sc = Character.toString(c);

				if (line[0] == c) {
					if (closeParenthesis.contains(sc)) {
						System.out.println("false");
						continue lineLoop;
					}

					Optional<Tuple> tuple = getTuple(parenthesiz, sc);
					if (!tuple.isPresent()) {
						System.out.println("false");
						continue lineLoop;
					}

					// push to the stack
					stack.push(tuple.get());
					continue characterLoop;
				}

				if (openParenthesis.contains(sc)) {
					Optional<Tuple> tuple = getTuple(parenthesiz, sc);
					if (!tuple.isPresent()) {
						System.out.println("false");
						continue lineLoop;
					}
					stack.push(tuple.get());
				} else if (closeParenthesis.contains(sc)) {
					Tuple tuple = stack.pop();

					if (!tuple.getCloseParenthesis().equals(sc)) {
						System.out.println("false");
						continue lineLoop;
					}
				} else {
					System.out.println("false");
					continue lineLoop;
				}
			}

			if (stack.isEmpty()) {
				System.out.println("true");
			} else {
				System.out.println("false");
			}
		}
	}

	private static Optional<Tuple> getTuple(Tuple[] parenthesiz, String c) {
		return Arrays.stream(parenthesiz).filter(x -> x.getOpenParenthesis().equals(c)).findFirst();
	}

	private static class Tuple {

		private String openParenthesis;
		private String closeParenthesis;

		public Tuple(String openParenthesis, String closeParenthesis) {
			this.openParenthesis = openParenthesis;
			this.closeParenthesis = closeParenthesis;
		}

		public String getOpenParenthesis() {
			return openParenthesis;
		}

		public String getCloseParenthesis() {
			return closeParenthesis;
		}
	}

}

//class Solution{
//	static Map<Character,Character> tbl;
//	static boolean solve(String s){
//		Stack<Character> arr=new Stack<Character>();
//		for(int i=0;i<s.length();i++){
//			if(tbl.containsKey(s.charAt(i)))arr.push(s.charAt(i));
//			else if(arr.empty() || tbl.get(arr.pop())!=s.charAt(i))return false;
//		}
//		return arr.empty();
//	}
//	public static void main(String[]args){
//		tbl=new HashMap<Character,Character>();
//		tbl.put('[',']');
//		tbl.put('{','}');
//		tbl.put('(',')');
//		Scanner cin=new Scanner(System.in);
//		for(;cin.hasNext();){
//			System.out.println(solve(cin.nextLine()));
//		}
//	}
//}
