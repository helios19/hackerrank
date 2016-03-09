package hackerrank;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Solution_Reflection {

    public static void main(String[] args){
        Class student = Student.class;
        Method[] methods = student.getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<>();
        for(Method method : methods){
            methodList.add(method.getName());
        }
        
        methodList.stream().sorted().forEach(System.out::println);
        
//        Collections.sort(methodList);
//        for(String name: methodList){
//            System.out.println(name);
//        }
    }

}
