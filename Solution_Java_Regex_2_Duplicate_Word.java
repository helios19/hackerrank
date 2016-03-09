package hackerrank;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution_Java_Regex_2_Duplicate_Word {

	public static void main(String[] args){

        String pattern = "(?i)\\b([a-z]+)\\b(?:\\s+\\1\\b)+";
        
        Pattern r = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String input = in.nextLine();
            Matcher m = r.matcher(input);
            boolean findMatch = true;
            while(m.find( )){
//            	System.out.println("input : " + input);
//            	System.out.println("m.group() : " + m.group());
//            	System.out.println("m.group(1) : " + m.group(1));
//            	System.out.println("m.groupCount : " + m.groupCount());
//            	System.out.println("----------------------------");
                input = input.replaceAll(m.group(), m.group(1)/* == "" ? m.group(1) : m.group(2)*/);
                findMatch = false;
            }
            System.out.println(input);
            testCases--;
        }
    }

}
