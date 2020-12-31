package com.crupmington.nqueens;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NQSolverTest {

	@Test
	void testUnsolvable() {
		int[] Ns = new int[] { 2, 3, 5, 6, 7 };
		for (int i = 0; i < Ns.length; i++) {
			int N = Ns[i];
			assertThrows(NoSolutionException.class, () -> {
				NQSolver.Solve(N);
			});
		}
	}

	@Test
	// These tests rely on the way in which the solver iterates over the solution
	// space. It's probably better to use the NQConflictMatrix class to create a
	// validation function and use that instead.
	void testKnown() throws NoSolutionException {
		int[] colPositions = NQSolver.Solve(1);
		assertArrayEquals(colPositions, new int[] { 0 });
		
		colPositions = NQSolver.Solve(4);
		assertArrayEquals(colPositions, new int[] { 1, 3, 0, 2 });

		colPositions = NQSolver.Solve(8);
		assertArrayEquals(colPositions, new int[] { 2, 4, 7, 3, 0, 6, 1, 5 });

		colPositions = NQSolver.Solve(9);
		assertArrayEquals(colPositions, new int[] { 0, 6, 3, 5, 8, 1, 4, 2, 7 });

		colPositions = NQSolver.Solve(10);
		assertArrayEquals(colPositions, new int[] { 0, 3, 8, 4, 7, 9, 2, 5, 1, 6 });

		colPositions = NQSolver.Solve(11);
		assertArrayEquals(colPositions, new int[] { 0, 6, 9, 5, 8, 1, 4, 2, 7, 10, 3 });

		colPositions = NQSolver.Solve(12);
		assertArrayEquals(colPositions, new int[] { 0, 2, 5, 11, 9, 1, 10, 4, 7, 3, 8, 6 });

		colPositions = NQSolver.Solve(13);
		assertArrayEquals(colPositions, new int[] { 0, 2, 6, 9, 11, 4, 1, 10, 5, 7, 12, 3, 8 });
	}
}
