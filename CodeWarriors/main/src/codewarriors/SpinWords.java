package codewarriors;

public class SpinWords {

	  public String spinWords(String sentence) {
		  String[] split = sentence.split("\\s");
		  StringBuilder response = new StringBuilder();
		  for (String currentWord : split) {
			  if (currentWord.length() < 5) {
				  response.append(currentWord);
				  response.append(" ");
			  } else {
				  StringBuilder reverse = new StringBuilder();
				  for (int i = currentWord.length()-1; i >= 0; i--) {
					  reverse.append(currentWord.charAt(i));
				  }//end of for
				  response.append(reverse);
				  response.append(" ");
			  }
		  }
		  return response.toString().trim();
	  }
	}
