package codewarriors;

public class ReverseString {

	public static String solution(String str) {
		return new StringBuilder().append(str).reverse().toString();
	}
	
	public static String formatWords(String[] words) {
	    if (words == null || words.length ==0) {
	      return "";
	    }
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < words.length; i++) {
	      if (words[i].isEmpty()) {
	        continue;
	      }
	      if (sb.toString().isEmpty()) {
	        sb.append(words[i]);
	      } else
	      {
	        sb.append(", ").append(words[i]);
	      }
	    }
	    String value = sb.toString();
	    int lastPosition = value.lastIndexOf(", ");
	    if (lastPosition > 0) {
	      value = value.substring(0, lastPosition)+" and "+value.substring(lastPosition+2);
	    }
	    return value;
	  }


}
