package slidingwindow;
import java.util.*;

class MaxFruitCountOf2Types {
	public static int findLength(char[] arr) {
		int maxValue = -1;
		for (int i = 0; i < arr.length; i++) {
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			map.put(arr[i], 1);
			for (int j = i+1; j < arr.length; j++) {
				int currentValue = 0;
				//second basket hasn't been filled yet
				if (map.keySet().size() < 2) {
					if (map.containsKey(arr[j])) {
						map.put(arr[j], map.get(arr[j])+1);
					} else {
						map.put(arr[j], 1);
					}
				}
				//if the two baskes are filled and the current fruit belongs to one of them
				else if (map.keySet().size() == 2 && map.containsKey(arr[j])) {
					map.put(arr[j], map.get(arr[j])+1);
				}
				//if the two baskets are filled and the current fruit does not belong
				else if (map.keySet().size() == 2 && !map.containsKey(arr[j])) {
					maxValue = getMaxValue(maxValue, map, currentValue);
					break;
				}
				if (j == arr.length-1) {
					maxValue = getMaxValue(maxValue, map, currentValue);
				}

			}//end of second for
		}//end of first for
		return maxValue;
	}

	private static int getMaxValue(int maxValue, HashMap<Character, Integer> map, int currentValue) {
		Iterator<Integer> iterator = map.values().iterator();
		while (iterator.hasNext()) {
			currentValue += iterator.next();
		}
		if (currentValue > maxValue) {
			maxValue = currentValue;
		}
		return maxValue;
	}

	public static void main(String[] args) {
		char[] arr = new char[] {'A', 'B', 'C', 'B', 'B', 'C'};
		System.out.println(new MaxFruitCountOf2Types().findLength(arr ));
	}
}