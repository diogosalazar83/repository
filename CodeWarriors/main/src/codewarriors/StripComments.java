package codewarriors;

public class StripComments {

	public static String stripComments(String text, String[] commentSymbols) {
		String[] split = text.split("\n");
		String value = "";
		for (int i = 0; i < split.length; i++) {
			int pos = -1;
			for (int j = 0; j < commentSymbols.length; j++) {
				int currentPos = split[i].indexOf(commentSymbols[j]);
				if (currentPos > -1) {
					if (pos == -1 || (currentPos < pos && currentPos != -1)) {
						pos = currentPos;
					}
				}
			}//end of for j
			if (pos != -1) {
				value += split[i].substring(0, pos).replaceAll("\\s+$","")+"\n";
			} else {
				value += split[i].replaceAll("\\s+$","")+"\n";
			}
		}//end of for i
		value = value.substring(0, value.length()-1);
		return value;
	}
}
