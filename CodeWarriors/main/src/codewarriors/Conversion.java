package codewarriors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Conversion {
	
	static List<String> thousands = new ArrayList<String>();
	static List<String> hundreds = new ArrayList<String>();
	static List<String> tens= new ArrayList<String>();
	static List<String> units = new ArrayList<String>();
	
	static {
		thousands.add("M");
		thousands.add("MM");
		thousands.add("MMM");
		hundreds.add("C");
		hundreds.add("CC");
		hundreds.add("CCC");
		hundreds.add("CD");
		hundreds.add("D");
		hundreds.add("DC");
		hundreds.add("DCC");
		hundreds.add("DCCC");
		hundreds.add("CM");
		tens.add("X");
		tens.add("XX");
		tens.add("XXX");
		tens.add("XL");
		tens.add("L");
		tens.add("LX");
		tens.add("LXX");
		tens.add("LXXX");
		tens.add("XC");
		units.add("I");
		units.add("II");
		units.add("III");
		units.add("IV");
		units.add("V");
		units.add("VI");
		units.add("VII");
		units.add("VIII");
		units.add("IX");
	}
	
	  public static int squareSum(int[] n)
	  { 
	   return Arrays.stream(n).map(i -> i*i).sum();
	  }
	

    public String solution(int n) {
        String value = "";
        int thousandDivision = n / 1000;
        if (thousandDivision > 0) {
        	value += thousands.get(thousandDivision-1);
        }
        int hundredDivision = n / 100 - thousandDivision*10;
        if (hundredDivision > 0) {
        	value+= hundreds.get(hundredDivision-1);
        }
        int tenDivision = n / 10 - thousandDivision*100 - hundredDivision*10;
        if (tenDivision > 0) {
        	value+= tens.get(tenDivision-1);
        }
        int unitDivision = n - thousandDivision*1000 - hundredDivision*100 -tenDivision*10;
        if (unitDivision > 0) {
        	value+= units.get(unitDivision-1);
        }
    	return value;
    }

	public static void main(String[] args) {
		System.out.println(new Conversion().solution(2020));
		System.out.println(squareSum(new int[] {1,2,2}));
	}
}