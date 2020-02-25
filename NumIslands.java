import java.util.HashSet;

class NumIslands { //BFS search of 2d graph
   /*
   '1' - land, '0' -water
   an island is any land connnected to other land horizontally or vertically
   ex:
      Input:
         11110
         11010
         11000
         00000

      Output: 1
   ex:
      Input:
         11000
         11000
         00100
         00011

      Output: 3
   */
    private static void recursiveSearch(char[][] grid, int i, int j, HashSet<Character> seen){
        //check if index is out of boundaries or have been seen before
        if(i<0 || i > grid.length-1 || j<0 || j> grid.length-1 || seen.contains(grid[i][j]) || grid[i][j] == '0') return;
        seen.add(grid[i][j]); //location is in boundary, not been seen, and is land. mark seen
        recursiveSearch(grid, i, j-1, seen);//search left neighbor
        recursiveSearch(grid, i, j+1, seen);//right
        recursiveSearch(grid, i-1, j, seen);//up
        recursiveSearch(grid, i+1, j, seen);//down

    }
    public static int numIslands(char[][] grid) {
        int count = 0;
        //Seen hashset prevents needing to alter given grid,
        //unnecessary if alteration is okay
        HashSet<Character> seen = new HashSet<Character>();

        for(int i = 0; i<grid.length; i++) //for every element in the given grid
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]=='1' && !seen.contains(grid[i][j])){
                   //new island is found
                    count++;
                    //add all parts of the island to seen set recursively
                    recursiveSearch(grid, i, j, seen);
                }
            }
        return count;
    }
}
