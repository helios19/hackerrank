package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;
import static java.lang.System.in;

public class Solution_Prime_Checker {

	private static class Prime {
		public void checkPrime(int...ints) {
			
			List<Integer> primes = new ArrayList<>();

			primeLoop:for (int n : ints) {

				double tmp = n;
				boolean isPrime = true;
				
				while (--tmp > 1) {
//					double rem = n / tmp;
//					int remInt = (int) rem;
//					if(rem - remInt == 0) {
//						isPrime = false;
//						continue primeLoop;
//					}
					if (n % tmp == 0) {
						isPrime = false;
						continue primeLoop;
					}
				}
				if(isPrime && n > 1) {
					primes.add(n);
				}
			}

			for(int prime : primes) {
				System.out.print(prime + " ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		try{
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		int n1=Integer.parseInt(br.readLine());
		int n2=Integer.parseInt(br.readLine());
		int n3=Integer.parseInt(br.readLine());
		int n4=Integer.parseInt(br.readLine());
		int n5=Integer.parseInt(br.readLine());
		Prime ob=new Prime();
		ob.checkPrime(n1);
		ob.checkPrime(n1,n2);
		ob.checkPrime(n1,n2,n3);
		ob.checkPrime(n1,n2,n3,n4,n5);	
		Method[] methods=Prime.class.getDeclaredMethods();
		Set<String> set=new HashSet<>();
		boolean overload=false;
		for(int i=0;i<methods.length;i++)
		{
			if(set.contains(methods[i].getName()))
			{
				overload=true;
				break;
			}
			set.add(methods[i].getName());
			
		}
		if(overload)
		{
			throw new Exception("Overloading not allowed");
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
}
