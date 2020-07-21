package codewarriors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KPrimes {
	static boolean FOUND_END;
	static Set<Long> set = new HashSet<Long>();
	static long largestFoundPrime = 1L;
	
	public static long[] countKprimes(int k, long start, long end) {
		List<Long> kprimes = new ArrayList<Long>();
        for (long i = start; i <= end; i++)
            if (primeFactors(i) == k)
                kprimes.add(i);
        long[] result = kprimes.stream().mapToLong(l -> l).toArray();
        return result;
	}
	
    private static int primeFactors(Long n) {
        List<Long> factors = new ArrayList<Long>();
        for (long i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) factors.add(n);
        return factors.size();
    }

	public static int puzzle(int s) {
		long[] prime1 = countKprimes(1, 1L, (long)s-1);
		long[] prime3 = countKprimes(3, 1L, (long)s-1);
		long[] prime7 = countKprimes(7, 1L, (long)s-1);
		int i1 = 0;
		int answer = 0;
		while (i1 < prime1.length && prime1[i1]+prime3[0]+prime7[0] <= s) {
			if (prime1[i1] > s) {
				break;
			}
			int i2 = 0;
			while (i2 < prime3.length && prime1[i1]+prime3[i2]+prime7[0] <= s) {
				if (prime3[i2] > s) {
					break;
				}
				int i3 = 0;
				while (i3 < prime7.length && prime1[i1]+prime3[i2]+prime7[i3] <= s ) {
					if (prime7[i3] > s) {
						break;
					}
					if (prime1[i1]+prime3[i2]+prime7[i3] == s) {
						answer++;
					}
					i3++;
				}//end of third while
				i2++;
			}//end of second while
			i1++;
		}//end of first while
		return answer;
	}
}
