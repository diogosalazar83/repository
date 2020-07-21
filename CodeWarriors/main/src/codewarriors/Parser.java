package codewarriors;

import java.util.HashMap;
import java.util.Map;

public class Parser {

  static Map<String, Integer> TENS = new HashMap<String, Integer>();
  static Map<String, Integer> DECADES = new HashMap<String, Integer>(); 
  static {
    TENS.put("one", 1);
    TENS.put("two", 2);
    TENS.put("three", 3);
    TENS.put("four", 4);
    TENS.put("five", 5);
    TENS.put("six", 6);
    TENS.put("seven", 7);
    TENS.put("eight", 8);
    TENS.put("nine", 9);
    TENS.put("ten", 10);
    TENS.put("eleven", 11);
    TENS.put("twelve", 12);
    TENS.put("thirteen", 13);
    TENS.put("fourteen", 14);
    TENS.put("fifteen", 15);
    TENS.put("sixteen", 16);
    TENS.put("seventeen", 17);
    TENS.put("eighteen", 18);
    TENS.put("nineteen", 19);

    DECADES.put("twenty", 20);
    DECADES.put("thirty", 30);
    DECADES.put("forty", 40);
    DECADES.put("fifty", 50);
    DECADES.put("sixty", 60);
    DECADES.put("seventy", 70);
    DECADES.put("eighty", 80);
    DECADES.put("ninety", 90);
  }

  public static int parseInt(String numStr) {
    numStr = numStr.replaceAll(" and ", " ");
    if (numStr.equalsIgnoreCase("one million")) {
      return 1000000;
    } 
    if (numStr.equalsIgnoreCase("zero")) {
      return 0;
    }
    String[] split = numStr.split(" thousand");
    int indexOfHundred = -1;
    int lastIndexOfHundred = -1;
    int indexOfThousand = numStr.indexOf(" thousand");
    if (split.length == 1) {
      split[0] = split[0].trim();
      indexOfHundred = split[0].trim().indexOf(" hundred");
    }
    if (split.length == 2) {
      split[0] = split[0].trim();
      split[1] = split[1].trim();
      indexOfHundred = split[0].indexOf(" hundred");
      lastIndexOfHundred = split[1].indexOf(" hundred");
    }
    int value = 0;

    if (indexOfThousand > -1) {
      if (indexOfHundred > -1) {
        value+=TENS.get(split[0].substring(0, indexOfHundred).trim())*100000;
        String substring = split[0].substring(indexOfHundred+8).trim();
        if (TENS.containsKey(substring)) {
          value+=TENS.get(substring)*1000;
        }
        else if (DECADES.containsKey(substring)) {
          value+=DECADES.get(substring)*1000;
        } else if (substring.contains("-")) {
          int dashPosition = substring.indexOf("-");
          value+= DECADES.get(substring.substring(0, dashPosition))*1000;
          value+= TENS.get(substring.substring(dashPosition+1))*1000;
        }
      } else {
        if (TENS.containsKey(split[0])) {
          value+=TENS.get(split[0])*1000;
        }
        else if (DECADES.containsKey(split[0])) {
          value+=DECADES.get(split[0])*1000;
        } else if (split[0].contains("-")) {
          int dashPosition = split[0].indexOf("-");
          value+= DECADES.get(split[0].substring(0, dashPosition))*1000;
          value+= TENS.get(split[0].substring(dashPosition+1))*1000;
        }
      }
      if (split.length == 2) {
        if (lastIndexOfHundred > -1) {
          value+=TENS.get(split[1].substring(0, lastIndexOfHundred).trim())*100;
          String substring = split[1].substring(lastIndexOfHundred+8).trim();
          if (TENS.containsKey(substring)) {
            value+=TENS.get(substring);
          }
          else if (DECADES.containsKey(substring)) {
            value+=DECADES.get(substring);
          } else if (substring.contains("-")) {
            int dashPosition = substring.indexOf("-");
            value+= DECADES.get(substring.substring(0, dashPosition).trim());
            value+= TENS.get(substring.substring(dashPosition+1).trim());
          }
        } else {
          if (TENS.containsKey(split[1])) {
            value+=TENS.get(split[1]);
          }
          else if (DECADES.containsKey(split[1])) {
            value+=DECADES.get(split[1]);
          } else if (split[0].contains("-")) {
            int dashPosition = split[1].indexOf("-");
            value+= DECADES.get(split[1].substring(0, dashPosition).trim());
            value+= TENS.get(split[1].substring(dashPosition+1).trim());
          }
        }
      }
    }
    else if (split.length ==1 && indexOfThousand == -1) {
      if (indexOfHundred > -1) {
        value+=TENS.get(split[0].substring(0, indexOfHundred).trim())*100;
        String substring = split[0].substring(indexOfHundred+8).trim();
        if (TENS.containsKey(substring)) {
          value+=TENS.get(substring);
        }
        else if (DECADES.containsKey(substring)) {
          value+=DECADES.get(substring);
        } else if (substring.contains("-")) {
          int dashPosition = substring.indexOf("-");
          value+= DECADES.get(substring.substring(0, dashPosition).trim());
          value+= TENS.get(substring.substring(dashPosition+1).trim());
        }
      } else {
        if (TENS.containsKey(split[0])) {
          value+=TENS.get(split[0]);
        }
        else if (DECADES.containsKey(split[0])) {
          value+=DECADES.get(split[0]);
        } else if (split[0].contains("-")) {
          int dashPosition = split[0].indexOf("-");
          value+= DECADES.get(split[0].substring(0, dashPosition).trim());
          value+= TENS.get(split[0].substring(dashPosition+1).trim());
        }
      }
    }
    return value;
  }
}