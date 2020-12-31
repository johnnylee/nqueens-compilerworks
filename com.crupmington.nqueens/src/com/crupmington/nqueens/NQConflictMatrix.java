package com.crupmington.nqueens;

// This class exists in order to be able to test the intermediate working of 
// the conflict matrix. Perhaps there's a better way to achieve this. 
class NQConflictMatrix {
	protected int N;
	protected int curRow;
	protected int[] colPositions;
	protected int[][] conflicts;

	protected NQConflictMatrix(int N) {
		this.N = N;
		colPositions = new int[N];
		conflicts = new int[N][N];
	}

	// Place a queen at `col` in the next empty row.
	protected void place(int col) {
		update(col, 1);
		curRow++;
	}

	// Remove the previously placed queen.
	protected void remove() {
		curRow--;
		update(colPositions[curRow], -1);
	}

	private void update(int curCol, int inc) {
		if (inc > 0) {
			colPositions[curRow] = curCol;
		}

		for (int row = curRow + 1; row < N; row++) {
			// Add column conflict on each row.
			conflicts[row][curCol] += inc;

			int dRow = row - curRow;

			// Add conflict on left diagonal.
			int col = curCol - dRow;
			if (col >= 0) {
				conflicts[row][col] += inc;
			}

			// Add conflict on right diagonal.
			col = curCol + dRow;
			if (col < N) {
				conflicts[row][col] += inc;
			}
		}

		// Add conflict from diagonals made with each previous queen.
		for (int row = 0; row < curRow; row++) {
			int dRow = curRow - row;
			int dCol = curCol - colPositions[row];

			int nextRow = curRow + dRow;
			int nextCol = curCol + dCol;

			while (nextRow < N && nextCol >= 0 && nextCol < N) {
				conflicts[nextRow][nextCol] += inc;
				nextRow += dRow;
				nextCol += dCol;
			}
		}
	}
}
