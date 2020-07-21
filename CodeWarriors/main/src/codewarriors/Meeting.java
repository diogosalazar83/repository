package codewarriors;

import java.util.Arrays;
import java.util.stream.Collectors;

class Meeting {
	public static String meeting(String s) {
		return Arrays
				.stream(s.toUpperCase().split(";"))
				.map(str -> str.replaceAll("^(\\w+):(\\w+)$", "($2, $1)"))
				.sorted()
				.collect(Collectors.joining());
	}

	public static void main(String[] args) {
		String s = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
		System.out.println(Meeting.meeting(s));
	}
}
