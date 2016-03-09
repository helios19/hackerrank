package hackerrank;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.annotation.Resource;

public class SampleTest {

	@Resource
	private Object resource;

	public static void main(String[] args) {

		Field[] fields = SampleTest.class.getDeclaredFields();
		Method[] methods = SampleTest.class.getDeclaredMethods();

		for(Method method : methods) {
			method.getName();
		}
		
		for (Field field : fields) {

			System.out.println("field.getName() : " + field.getName());

			for (Annotation ann : field.getAnnotations()) {
				System.out.println("ann.annotationType() : " + ann.annotationType().getSimpleName());
			}
		}
	}
}
