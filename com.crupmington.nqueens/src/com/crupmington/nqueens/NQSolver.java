package com.crupmington.nqueens;

public final class NQSolver extends NQConflictMatrix {
	private NQSolver(int N) {
		super(N);
	}
	
	// Solve the n-queens problem with extra constraint that no three queens lie on
	// any diagonal. If successful, return the queens' column index for each row.
	public static int[] Solve(int N) throws NoSolutionException {
		NQSolver s = new NQSolver(N);
		if (!s.solve(0)) {
			throw new NoSolutionException();
		}
		return s.colPositions;
	}

	private boolean solve(int curRow) {
		if (curRow == N) {
			return true;
		}

		for (int col = 0; col < N; col++) {
			if (conflicts[curRow][col] != 0) {
				continue;
			}
			place(col);
			if (solve(curRow + 1)) {
				return true;
			}
			remove();
		}

		// Didn't find a solution.
		return false;
	}
}