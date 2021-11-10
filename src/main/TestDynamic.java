package main;

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
        // Is going down valid
        // Is going right valid
        int m = grid.length;
        int n = grid[0].length;
        boolean iValid = i >= 0 && i < m;
        boolean jValid = j >=0 && j < n;
        return iValid && jValid;
    }
	//////////////////////////////////////////////////////////////////////////////////////////////////
	

	public static void main(String[] args) {
		int test = gridTraveler(10,10);
		System.out.println(test);

	}

}
