package com.crupmington.nqueens;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NQConflictMatrixTest {

	@Test
	void test3x3() {
		NQConflictMatrix m = new NQConflictMatrix(3);
		
		m.place(0);
		assertArrayEquals(m.conflicts, new int[][] {
			{0,0,0},
			{1,1,0},
			{1,0,1},
		});
		
		m.place(2);
		assertArrayEquals(m.conflicts, new int[][] {
			{0,0,0},
			{1,1,0},
			{1,1,2},
		});
		
		m.remove();
		assertArrayEquals(m.conflicts, new int[][] {
			{0,0,0},
			{1,1,0},
			{1,0,1},
		});
		
		m.remove();
		assertArrayEquals(m.conflicts, new int[][] {
			{0,0,0},
			{0,0,0},
			{0,0,0},
		});
	}
	
	@Test
	void test4x4() {
		NQConflictMatrix m = new NQConflictMatrix(4);
		
		m.place(0);
		assertArrayEquals(m.conflicts, new int[][] {
			{0,0,0,0},
			{1,1,0,0},
			{1,0,1,0},
			{1,0,0,1},
		});
		
		m.place(2);
		assertArrayEquals(m.conflicts, new int[][] {
			{0,0,0,0},
			{1,1,0,0},
			{1,1,2,1},
			{2,0,1,1},
		});
		
		m.remove();
		assertArrayEquals(m.conflicts, new int[][] {
			{0,0,0,0},
			{1,1,0,0},
			{1,0,1,0},
			{1,0,0,1},
		});
		
		m.remove();
		assertArrayEquals(m.conflicts, new int[][] {
			{0,0,0,0},
			{0,0,0,0},
			{0,0,0,0},
			{0,0,0,0},
		});
	}
	
	@Test
	void test5x5() {
		NQConflictMatrix m = new NQConflictMatrix(5);
		
		m.place(0);
		assertArrayEquals(m.conflicts, new int[][] {
			{0,0,0,0,0},
			{1,1,0,0,0},
			{1,0,1,0,0},
			{1,0,0,1,0},
			{1,0,0,0,1},
		});
		
		m.place(2);
		assertArrayEquals(m.conflicts, new int[][] {
			{0,0,0,0,0},
			{1,1,0,0,0},
			{1,1,2,1,1},
			{2,0,1,1,1},
			{1,0,1,0,1},
		});
		
		m.remove();
		assertArrayEquals(m.conflicts, new int[][] {
			{0,0,0,0,0},
			{1,1,0,0,0},
			{1,0,1,0,0},
			{1,0,0,1,0},
			{1,0,0,0,1},
		});
		
		m.place(3);
		assertArrayEquals(m.conflicts, new int[][] {
			{0,0,0,0,0},
			{1,1,0,0,0},
			{1,0,2,1,1},
			{1,1,0,2,0},
			{2,0,0,1,1},
		});
		
		m.remove();
		assertArrayEquals(m.conflicts, new int[][] {
			{0,0,0,0,0},
			{1,1,0,0,0},
			{1,0,1,0,0},
			{1,0,0,1,0},
			{1,0,0,0,1},
		});
		
		m.remove();
		assertArrayEquals(m.conflicts, new int[][] {
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
		});
	}
	
	@Test
	void test7x7() {
		NQConflictMatrix m = new NQConflictMatrix(7);
		
		m.place(6);
		assertArrayEquals(m.conflicts, new int[][] {
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,1,1},
			{0,0,0,0,1,0,1},
			{0,0,0,1,0,0,1},
			{0,0,1,0,0,0,1},
			{0,1,0,0,0,0,1},
			{1,0,0,0,0,0,1},
		});
		
		m.place(4);
		assertArrayEquals(m.conflicts, new int[][] {
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,1,1},
			{0,0,1,1,2,1,1},
			{1,0,1,1,1,0,2},
			{0,1,1,0,1,0,1},
			{1,1,0,0,1,0,1},
			{1,0,0,0,1,0,1},
		});
		
		m.place(1);
		assertArrayEquals(m.conflicts, new int[][] {
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,1,1},
			{0,0,1,1,2,1,1},
			{2,1,2,1,1,0,2},
			{0,2,1,1,1,0,1},
			{1,2,0,0,2,0,1},
			{1,1,0,0,1,1,1},
		});
		
		m.place(5);
		assertArrayEquals(m.conflicts, new int[][] {
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,1,1},
			{0,0,1,1,2,1,1},
			{2,1,2,1,1,0,2},
			{0,2,1,1,2,1,2},
			{1,2,0,1,2,1,2},
			{1,1,1,0,2,2,1},
		});
		
		m.remove();
		assertArrayEquals(m.conflicts, new int[][] {
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,1,1},
			{0,0,1,1,2,1,1},
			{2,1,2,1,1,0,2},
			{0,2,1,1,1,0,1},
			{1,2,0,0,2,0,1},
			{1,1,0,0,1,1,1},
		});
		
		m.remove();
		assertArrayEquals(m.conflicts, new int[][] {
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,1,1},
			{0,0,1,1,2,1,1},
			{1,0,1,1,1,0,2},
			{0,1,1,0,1,0,1},
			{1,1,0,0,1,0,1},
			{1,0,0,0,1,0,1},
		});
		
		m.remove();
		assertArrayEquals(m.conflicts, new int[][] {
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,1,1},
			{0,0,0,0,1,0,1},
			{0,0,0,1,0,0,1},
			{0,0,1,0,0,0,1},
			{0,1,0,0,0,0,1},
			{1,0,0,0,0,0,1},
		});
		
		m.remove();
		assertArrayEquals(m.conflicts, new int[][] {
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
		});
	}
}
