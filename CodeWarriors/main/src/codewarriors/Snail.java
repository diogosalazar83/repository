package codewarriors;

import java.util.HashSet;
import java.util.Set;

public class Snail {

	static int lastPosition;

	public static int[] snail(int[][] array) {
		// enjoy
		lastPosition = 0;
		int[] nextCoordinate = new int[] {0, 0};
		if (array[0].length== 0) {
			return new int[] {};
		}
		int[] answer = new int[array.length*array.length];
		String lastAction = "";
		Set<Integer> set = new HashSet<Integer>();
		while (set.size() < answer.length) {
			if (lastAction.isEmpty() || lastAction.equalsIgnoreCase("goUp")) {
				lastAction = goFoward(answer, array, set, nextCoordinate);
			}
			if (lastAction.equalsIgnoreCase("goFoward")) {
				lastAction = goDown(answer, array, set, nextCoordinate);
			}
			if (lastAction.equalsIgnoreCase("goDown")) {
				lastAction = goBackward(answer, array, set, nextCoordinate);
			}
			if (lastAction.equalsIgnoreCase("goBackward")) {
				lastAction = goUp(answer, array, set, nextCoordinate);
			}
		}
		return answer;
	} 

	private static String goUp(int[] answer, int[][] array, Set<Integer> set, int[] nextCoordinate) {
		int i = nextCoordinate[0];
		int nextStep = (i*array.length)+nextCoordinate[1]+1;
		while (!set.contains(nextStep) && i > -1) {
			set.add(nextStep);
			answer[lastPosition] = array[nextCoordinate[0]][nextCoordinate[1]];
			lastPosition++;
			i--;
			nextStep = (i*array.length)+nextCoordinate[1]+1;
			nextCoordinate[0]=i;
		}//end of while
		nextCoordinate[0]= nextCoordinate[0]+1;
		nextCoordinate[1] = nextCoordinate[1]+1;
		return "goUp";
	}

	private static String goBackward(int[] answer, int[][] array, Set<Integer> set, int[] nextCoordinate) {
		int j = nextCoordinate[1];
		int nextStep = (nextCoordinate[0]*array.length)+j+1;
		while (!set.contains(nextStep) && j > -1) {
			set.add(nextStep);
			answer[lastPosition] = array[nextCoordinate[0]][nextCoordinate[1]];
			lastPosition++;
			j--;
			nextStep = (nextCoordinate[0]*array.length)+j+1;
			nextCoordinate[1]=j;
		}//end of while
		nextCoordinate[0]= nextCoordinate[0]-1;
		nextCoordinate[1] = nextCoordinate[1]+1;
		return "goBackward";
	}

	private static String goDown(int[] answer, int[][] array, Set<Integer> set, int[] nextCoordinate) {
		int i = nextCoordinate[0];
		int nextStep = (i*array.length)+nextCoordinate[1]+1;
		while (!set.contains(nextStep) && i < array.length) {
			set.add(nextStep);
			answer[lastPosition] = array[nextCoordinate[0]][nextCoordinate[1]];
			lastPosition++;
			i++;
			nextStep = (i*array.length)+nextCoordinate[1]+1;
			nextCoordinate[0]=i;
		}//end of while
		nextCoordinate[0]= nextCoordinate[0]-1;
		nextCoordinate[1] = nextCoordinate[1]-1;
		return "goDown";
	}

	private static String goFoward(int[] answer, int[][] array, Set<Integer> set, int[] nextCoordinate) {
		int j = nextCoordinate[1];
		int nextStep = (nextCoordinate[0]*array.length)+j+1;
		while (!set.contains(nextStep) && j < array.length) {
			set.add(nextStep);
			answer[lastPosition] = array[nextCoordinate[0]][nextCoordinate[1]];
			lastPosition++;
			j++;
			nextStep = (nextCoordinate[0]*array.length)+j+1;
			nextCoordinate[1]=j;
		}//end of while
		nextCoordinate[0]= nextCoordinate[0]+1;
		nextCoordinate[1] = nextCoordinate[1]-1;
		return "goFoward";
	}

	public static void main(String[] args) {
		int[][] array1 = new int[][] {
			{}
		};
		int[] snail1 = snail(array1);

		System.out.println(0);
	}
}
