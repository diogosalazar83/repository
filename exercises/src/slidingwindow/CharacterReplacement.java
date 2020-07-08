package slidingwindow;

class CharacterReplacement {
	public static int findLength(String str, int k) {
		int maxSize = 0;
		for (int i = 0; i < str.length(); i++) {
			int currentSize = 1;
			int numberOfChanges = 0;
			char currentChar = str.charAt(i);
			int j = i+1;
			while (j < str.length() && numberOfChanges <=k) {
				if (str.charAt(j) != currentChar) {
					numberOfChanges++;
					if (numberOfChanges > k) {
						break;
					}
					currentSize++;
				}
				if (str.charAt(j) == currentChar) {
					currentSize++;
				}
				if (maxSize < currentSize) {
					maxSize = currentSize;
				}
				j++;
			}//end of while
			if (maxSize >= str.length() - i) {
				break;
			}
		}//end of for
		return maxSize;
	}
	
	public static void main(String[] args) {
		System.out.println(CharacterReplacement.findLength("aabccbb", 2));
		System.out.println(CharacterReplacement.findLength("abbcb", 1));
		System.out.println(CharacterReplacement.findLength("abccde", 1));
	}
}
