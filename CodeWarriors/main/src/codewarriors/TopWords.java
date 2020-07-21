package codewarriors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TopWords {

	public static List<String> top3(String s) {
		List<String> answer = new ArrayList<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();

		String pattern = "[a-z]+'*[a-z]*";

		// Create a Pattern object
		Pattern r = Pattern.compile(pattern);

		// Now create matcher object.
		Matcher m = r.matcher(s.toLowerCase());
		while (m.find()) {
			String group = m.group().trim();
			if (map.containsKey(group)) {
				map.put(group, map.get(group)+1);
			} else {
				map.put(group, 1);
			}
		}
		
		int currentMax = 0, secondMax = 0, thirdMax = 0;
		Iterator<Entry<String, Integer>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, Integer> next = iterator.next();
			if (next.getValue() >= currentMax) {
				thirdMax = secondMax;
				secondMax = currentMax;
				currentMax = next.getValue();
				answer.add(0, next.getKey());
			} else
				if (next.getValue() >= secondMax) {
					thirdMax = secondMax;
					secondMax = next.getValue();
					answer.add(1, next.getKey());
				} else
					if (next.getValue() >= thirdMax) {
						thirdMax = next.getValue();
						answer.add(2, next.getKey());
					}
			if (answer.size() == 4) {
				answer.remove(3);
			}
		}
		return answer;
	}
}
