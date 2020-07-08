package codewarriors;

public class LongestVowelChain {

	public static int solve(String s){
		int response = 0;
		int currentValue = 0;
		for (int i = 0; i < s.length(); i++) {			
			if (isVowel(s.charAt(i))) {
				currentValue++;
				if (currentValue > response) {
					response = currentValue;
				}
			} else {
				currentValue = 0;
			}
		}//end of for
		return response;
	}

	private static boolean isVowel(char charAt) {
		return charAt == 'a' || charAt == 'e' || charAt == 'i' || charAt == 'o' || charAt == 'u';
	}
}
