package codewarriors;

import java.util.ArrayList;
import java.util.List;

public class Prime {
	
	static List<Integer> LIST = new ArrayList<Integer>();
//	static int LARGEST_PRIME =2;
	static {
		LIST.add(2);
	}
	
	public static boolean isPrime(int num) {
		if ( num < 2) {
			return false;
		}
		if (primeFactors(num)== 1) {
			return true;
		}
		return false;
		
	}
	
	private static int primeFactors(int n) {
        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) factors.add(n);
        return factors.size();
    }
	
	public static void main(String[] args) {
		System.out.println(Prime.isPrime(3));
	}
}
