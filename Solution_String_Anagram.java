package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_String_Anagram {

//	public static void main(String []args){
//		Scanner sc = new Scanner(System.in);
//		int t=sc.nextInt();
//
//		for(int i=0;i<t;i++){
//			try{
//				long x=sc.nextLong();
//				System.out.println(x+" can be fitted in:");
//				if(x>=-128 && x<=127)System.out.println("* byte");
//				if(x>=-32768 && x<=32767)System.out.println("* short");
//				if(x>=-2147483648 && x<=2147483647)System.out.println("* int");
//				System.out.println("* long");
//			}catch(Exception e){
//				System.out.println(sc.next()+" can't be fitted anywhere.");
//			}
//		}
//	}
	
	public static boolean isAnagram(String A, String B) {
		
		try {
			char[] charA = A.trim().toLowerCase().toCharArray();
			char[] charB = B.trim().toLowerCase().toCharArray();
			
			Arrays.sort(charA);
			Arrays.sort(charB);
			
			String strA = new String(charA);
			String strB = new String(charB);
			
			return strA.equals(strB);
		} catch (Exception ex) {
			return false;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		boolean ret = isAnagram(A, B);
		if (ret)
			System.out.println("Anagrams");
		else
			System.out.println("Not Anagrams");

	}
	
}
