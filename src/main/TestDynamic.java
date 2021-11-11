package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TestDynamic {
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	// Grid problem only moving down or right	
	public static int gridTraveler(int m, int n){
        if (m <= 0 || n <= 0){
            return 0;
        }
        int[][] grid = new int[m][n];
        // call helper function move
        return move(grid, 0, 0, 0);
    }

    public static int move(int[][] grid, int i, int j, int ways){
        // Check if final destiation, which grid.length -1 and grid[i].length - 1
        // Otherwise, check if we can make each resursive call (down or right)
        //      Recursive call will add to each other
        // If cannot make a call, return 0
        // Base case, reached destination
        if (!validPoint(grid, i, j)){
            return 0;
        }
        else if (i == grid.length - 1 && j == grid[0].length - 1){
            return 1;
        }
        else if (grid[i][j] != 0){
            return grid[i][j];
        }
        else{
            grid[i][j] = move(grid, i+1, j, ways) + move(grid, i, j+1, ways);
            return grid[i][j];
        }  
    }

    public static boolean validPoint(int[][] grid, int i, int j){
        return (i >= 0 && i < grid.length) && (j >= 0 && j < grid[i].length);
    }
	//////////////////////////////////////////////////////////////////////////////////////////////////
    
    //////////////////////////////////////////////////////////////////////////////////////////////////
    // Diving board: Given k boards and two size options shorter and longer, how many possible lengths for a full board are there?
    public static HashSet<Integer> allLengths(int k, int shorter, int longer){
    	// Use a hashset since we want unique lengths
    	HashSet<Integer> lengths = new HashSet<>();
    	
    	// Remember, only concerned about LENGTHS, not COMBINATIONS between boards, so 2 long = 4 anf 4 short = 4 are the SAME
    	// If it was combinations, then we would use recursive soltuion
    	
    	// This will start by getting the length of all (k) long boards, then go to all (k) short boards.  Remember, 1 short board at the beginning w/ all long baords
    	// is the same as one short board anywhere with all longboards, therefore we can start will all of one board and replace it one by one for all possible lengths
    	for (int nShorter = 0; nShorter <= k; nShorter++) {
    		int nLonger = k - nShorter;
    		int length = nShorter * shorter + nLonger * longer;
    		lengths.add(length);
    	}
    	return lengths;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////
    
    //////////////////////////////////////////////////////////////////////////////////////////////////
    // Rotting oranges: 0 = empty, 1 = fresh, 2 = rotten
    // Every minute, rotten oranges infect adjacent fresh oranges (vertical and horizontal), return -1 if there are oranges that won't rot
    // Return the minimum number of minutes it takes for all oranges to rot
    // Use Breadth first level search with queue starting at each first rotten orange and add neighbors to it
    public static int orangesRotting(int[][] grid) {
    	
    	final int EMPTY = 0;
    	final int FRESH = 1;
    	final int ROTTEN = 2;
    	final int IMPOSSIBLE = -1;
    	
    	
    	Queue<Point> q = new LinkedList<>();
    	
    	// Iterate through, record number of fresh oranges, push rotten into q
    	int numFresh = 0;
    	for (int i = 0; i < grid.length; i++) {
    		for (int j = 0; j < grid[i].length; j++) {
    			if(grid[i][j] == FRESH) {
    				numFresh++;
    			}
    			else if(grid[i][j] == ROTTEN) {
    				q.add(new Point(i,j));
    			}
    		}
    	}
    	// If no fresh oranges, return 0
    	if(numFresh == 0) {
    		return EMPTY;
    	}
    	
    	int minutes = -1;
    	while(!q.isEmpty()) {
    		int qSize = q.size();
    		// Iterate through current level
    		for(int i = 0; i < qSize; i++) {
    			Point temp = q.remove();
    			// Get fresh neighbors
    			List<Point> neighbors = getNeighbors(grid, temp);
    			for(Point neighbor : neighbors) {
    				int x = neighbor.getX();
    				int y = neighbor.getY();
    				// Infect fresh neighbors then add them to q
    				if(grid[x][y] == FRESH) {
    					grid[x][y] = ROTTEN;
    					numFresh--;
    					q.add(neighbor);
    				}
    			}
    		}
    		// Minute has passed
    		minutes++;
    	}
    	
    	return (numFresh > 0) ? IMPOSSIBLE : minutes;
    }
    
    public static List<Point> getNeighbors(int[][] grid, Point p){
    	List<Point> neighbors = new ArrayList<>();
    	
    	int i = p.getX();
    	int j = p.getY();
    	
    	// Check left, right, up, and down
    	if(validPoint(grid, i, j-1)) {
    		neighbors.add(new Point(i, j-1));
    	}
    	if(validPoint(grid, i, j+1)) {
    		neighbors.add(new Point(i, j+1));
    	}
    	if(validPoint(grid, i-1, j)) {
    		neighbors.add(new Point(i-1, j));
    	}
    	if(validPoint(grid, i+1, j)) {
    		neighbors.add(new Point(i+1, j));
    	}
 
    	return neighbors;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) {
		int[][] grid1 = {{2,1,1},{1,1,0},{0,1,1}};
		int[][] grid2 = {{2,1,1},{0,1,1},{1,0,1}};
		int[][] grid3 = {{0,2}};
		System.out.println(orangesRotting(grid3));

	}

}
