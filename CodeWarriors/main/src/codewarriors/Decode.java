package codewarriors;

class Decode { 
	public static String decode(String r) {
		String text = r.split("\\d+")[1];
		int num = Integer.parseInt(r.split("\\D+")[0]);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			try {
				int currentValue = getX(num, getNumberForChar(text.charAt(i)));
				sb.append(getCharForNumber(currentValue));

			} catch (UnsupportedOperationException e) {
				return "Impossible to decode"; 
			}
		}
		return sb.toString();
	}

	private static int getNumberForChar(char c) {
		return Character.getNumericValue(c)- 10;
	}

	private static int getX(int key, int remainder) {
		int value = -1;
		boolean foundOnce = false;
		for (int i = 0; i < 26; i++) {
			if ((i*key)%26==remainder) {
				if (!foundOnce) {
					value = i;
					foundOnce = true;
				} else {
					throw new UnsupportedOperationException();
				}
			}
		}
		return value;
	}

	private static String getCharForNumber(int x) {
		return x>= 0 && x < 26 ? String.valueOf((char)(x + 97)) : null;
	}

	public static void main(String[] args) {
		System.out.println(getNumberForChar('a'));
		System.out.println(getCharForNumber(0));
		System.out.println(decode("5057aan"));
	}
}