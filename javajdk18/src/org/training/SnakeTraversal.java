package org.training;

import java.util.Arrays;

public class SnakeTraversal {
	static int[][] grid = {
		    { 1,  2,  3,  4 },
		    { 5,  6,  7,  8 },
		    { 9,  10, 11, 12 },
		    { 13, 14, 15, 16 },
		};
	
	public static void main(String[] args) {	
		normalTraversal(grid);		
		Arrays.stream(snakeTraversal(grid)).forEach(i -> System.out.print(i + " "));
		System.out.println();
	}

	private static int[] snakeTraversal(int[][] grid) {
		// 1 2 5 9 6 3 4 7 10 13 14 11 8 12 15 16
		System.out.print("Snake Traversal  : ");
		int[] traversalResult = null;

		if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
			return traversalResult;
		}

		int rows = grid.length;
		int cols = grid[0].length;
		traversalResult = new int[rows * cols];

		if (grid.length == 1) {
			return grid[0];
		}

		//i - row, j - col
		int i = 0, j = 0;
		int traversalInd = 0;

		traversalResult[traversalInd] = grid[i][j];
		traversalInd++;

		while (traversalInd < traversalResult.length) {
			//Right 1 step, or down
			if (j + 1 < cols || i + 1 < rows) {
				if (j + 1 < cols) j++;
				else if (i + 1 < rows) i++;
				traversalResult[traversalInd++] = grid[i][j];
			}

			//Move to left bottom
			while (j - 1 >= 0 && i + 1 < rows) {
				traversalResult[traversalInd++] = grid[++i][--j];
			}

			//Move down, or right
			if (j + 1 < cols || i + 1 < rows) {
				if (i + 1 < rows) i++;
				else if (j + 1 < cols) j++;
				traversalResult[traversalInd++] = grid[i][j];
			} 

			//Move right up
			while (j + 1 < cols && i - 1 >= 0) {
				traversalResult[traversalInd++] = grid[--i][++j];
			}
		}//end while

		return traversalResult;
	}
	
	private static void normalTraversal(int[][] grid) {
		//1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
		System.out.print("Normal Traversal : ");
		for (int i=0; i < grid.length; i++) {
			int[] row = grid[i];
			for (int j=0; j < row.length; j++) {
				System.out.print(grid[i][j] + " ");
			}
		}
		System.out.println();
	}
}
