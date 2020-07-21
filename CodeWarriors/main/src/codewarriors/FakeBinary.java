package codewarriors;

import java.util.Arrays;
import java.util.stream.Stream;

public class FakeBinary {
    public static String fakeBin(String numberString) {
    	Stream<String> stringStream = numberString.codePoints().mapToObj(c ->String.valueOf((char) c));
    	
    	return Arrays.toString(stringStream.map(string -> string.replaceAll("[0-4]", "0").
    			replaceAll("[5-9]", "1")).toArray()).replaceAll("\\[|\\]|,|\\s", "");
    	
    }
	
	public static void main(String[] args) {
		System.out.println(fakeBin("12345"));
	}
}
