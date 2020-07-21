package codewarriors;

public class RangeExtraction {

	public static String rangeExtraction(int[] arr) {
		String value ="";
		if (arr.length == 1) {
			return ""+arr[0];
		}
		if (arr.length == 0) {
			return "";
		}
		int minRange = Integer.MIN_VALUE, maxRange = Integer.MAX_VALUE;
		int iterations = 0;
		for (int i = 0; i < arr.length; i++) {
			if (minRange == Integer.MIN_VALUE) {
				minRange = arr[i];
			}
			if (i+1 == arr.length) {
				if (maxRange > minRange) {
					if (minRange+1 == maxRange) {
						value+=minRange+","+maxRange;
					}
					else {
						value+=minRange+"-"+maxRange;
					}
				} else {
					value+=minRange;
				}
				break;
			}
			if (minRange+1+iterations == arr[i+1]) {
				iterations++;
				maxRange = arr[i+1];
				continue;
			}else {
				if(minRange+iterations == maxRange && iterations == 1) {
					value+=minRange+","+maxRange+",";
					minRange = Integer.MIN_VALUE;
					iterations = 0;
					continue;
				} else if (minRange+iterations == maxRange && iterations != 1){
					value+=minRange+"-"+maxRange+",";
					minRange = Integer.MIN_VALUE;
					iterations = 0;
					continue;
				}
				value+=arr[i]+",";
				minRange = Integer.MIN_VALUE;
			}

		}//end of for
		return value;
	}

	public static void main(String[] args) {
		System.out.println(RangeExtraction.rangeExtraction(new int[] {0,2,5,8,11,14,15,16,17,18,20}));
	}

}
