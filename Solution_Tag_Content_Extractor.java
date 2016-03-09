package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Solution_Tag_Content_Extractor {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while (testCases > 0) {
			String line = in.nextLine();
			
			// Write your code here

			Stream.of(findContents(line, 0)).forEach(x -> {
				if(x.isEmpty()) {
					System.out.println("None");
				} else {
					x.forEach(System.out::println);
				}
			});			

			testCases--;
		}
	}

	private static List<String> findContents(String line, int startIndex) {
		List<String> contents = new ArrayList<>();
		int start = line.indexOf("<", startIndex);
		int end = line.indexOf(">", start);
		String tag = line.substring(start+1, end);

		int startTag = line.indexOf("<" + tag + ">", startIndex);
		int endTag = line.lastIndexOf("</" + tag + ">");
		String content = line.substring(startTag + tag.length() + 2, endTag >= 0 ? endTag : line.length());

		if (content.indexOf("<") != -1) {
			contents.addAll(findContents(content, content.indexOf("<")));
		} else {
			if (!content.trim().isEmpty()) {
				contents.add(content);
			}
		}
		
		int nextIndex = line.indexOf("<", endTag >= 0 ? endTag : line.length());
		if (nextIndex != -1) {
			contents.addAll(findContents(line.substring(nextIndex), nextIndex));
		}			

		return contents;
	}



//	public static void main(String[] args){
//		Scanner in = new Scanner(System.in);
//		int testCases = Integer.parseInt(in.nextLine());
//		while(testCases>0){
//			String line=in.nextLine();
//			int cur=0;
//			boolean none=true;
//			for(;;){
//				int start=line.indexOf("<",cur);
//				if(start<0)break;
//	         	int end=line.indexOf(">",start);
//				if(end<0)break;
//				String tag=line.substring(start+1,end);
//				if(tag.length()==0 || tag.charAt(0)=='/'){
//					cur=end+1;
//					continue;
//				}
//				int bk=line.indexOf("</"+tag+">");
//				if(bk>=0){
//					String candidate=line.substring(end+1,bk);
//					if(candidate.length()>0 && candidate.indexOf("<")<0){
//						none=false;
//						System.out.println(candidate);
//					}
//				}
//				cur=end+1;
//			}
//			if(none)System.out.println("None");
//			testCases--;
//		}
//	}

}
