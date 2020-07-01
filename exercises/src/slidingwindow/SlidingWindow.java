package slidingwindow;

import java.util.HashSet;

class SlidingWindow {
	public static int findMaxSumSubArray(int k, int[] arr) {
		int result = -1;
		int temp = 0;
		int startWindow = 0;
		for (int i = 0; i < arr.length; i++) {
			temp += arr[i];
			if (i >= k-1) {
				result = Math.max(temp, result);
				temp = temp - arr[startWindow];
				startWindow++;
			}
		}
		return result;
	}

	public static int findMinSubArray(int S, int[] arr) {
		int result = 0;
		int currentSize = arr.length+1; 
		int sum = 0;
		int startWindow = 0;
		int endWindow = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum >= S) {
				endWindow = i;
				result = Math.min(currentSize, endWindow+1-startWindow);
				currentSize = result;
				sum = sum - arr[startWindow];
				startWindow++;
				while (sum >= S) {
					result = Math.min(currentSize, endWindow+1-startWindow);
					currentSize = result;
					sum = sum - arr[startWindow];
					startWindow++;
				}
				
			}
		}//end of for
		return result;
	}
	
	  public static int findLength(String str, int k) {
		  int result = -1;
		  int currentSize = 0;
		  int startWindow = 0;
		  int endWindow;
		  HashSet<Character> set = new HashSet<Character>();
		  for (int i = 0; i < str.length(); i++) {

			  if (set.size() <= k) {
				  set.add(str.charAt(i));
				  endWindow = i;
				  currentSize = Math.max(currentSize, endWindow-startWindow);
				  result = currentSize;
				  if (set.size() == k+1) {
					  set.remove(str.charAt(startWindow));
					  startWindow++;
				  }
			  }
			  
		  }//end of for
		  return result;
		  }

	public static void main(String[] args) {
		int[] arr = new int[] {2, 1, 5, 1, 3, 2};
		System.out.println(SlidingWindow.findMaxSumSubArray(3, arr));
		
		int[] arr2 = new int[] {2, 1, 5, 2, 3, 2};
		System.out.println(SlidingWindow.findMinSubArray(7, arr2));
		
		System.out.println(SlidingWindow.findLength("araaci", 2));
	}
}