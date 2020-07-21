package codewarriors;

public class User {

	public int rank = -8;
	public int progress = 0;

	public void incProgress(int activity) {
		if (activity ==0 ) {
			throw new IllegalArgumentException();
		}
		if (activity <-8 ) {
			throw new IllegalArgumentException();
		}
		if (activity >8 ) {
			throw new IllegalArgumentException();
		}
		if (rank ==8) return;
		int d = 0;
		if (activity > 0 && rank < 0) {
			d = activity - rank-1;
		} else if (activity < 0 && rank > 0)  {
			d = activity + rank-1;
		}
		else {
			d = activity - rank;
		}
		if (d == 0) {
			progress+=3;
		} else if (d == -1) {
			progress+=1;
		} else if (d > 0) {
			progress += 10*d*d;
		}
		if (progress >= 100) {
			updateRank();
		}
	}

	private void updateRank() {
		if (rank ==8) {
			return;
		}
		int ranksIncreased = progress / 100;
		progress = progress % 100;
		if (ranksIncreased+rank >= 8) {
			rank = 8;
			progress = 0;
			return;
		}
		if (ranksIncreased+rank == 0) ranksIncreased++;
		rank = rank+ranksIncreased;
	}
}
