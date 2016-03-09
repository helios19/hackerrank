package hackerrank;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution_Java_String_Token {

	// [A-Za-z !,?.\_'@]+

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		// Complete the code
		
		String[] words = s.trim().split("[ !,?.\\_'@]+");

//		Pattern.compile("[ !,?.\\_'@]+").splitAsStream(s.trim()).forEach(System.out::println);		

		
		System.out.println(words.length);
		Arrays.stream(words).forEach(System.out::println);
	}

}
