package codetop_byte.q0513;

public class FloodFill {
    int m,n;
    boolean[][] isV;
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m = image.length;
        n = image[0].length;
        int oldColor = image[sr][sc];
        isV = new boolean[m][n];
        isV[sr][sc] = true;
        image[sr][sc] = color;
        dfs(image,sr,sc,oldColor,color);
        return image;
    }
    private void dfs(int[][] image,int x,int y,int oldColor,int newColor) {

        for(int i = 0; i < 4; i++) {
            int r = x + dir[i][0];
            int c = y + dir[i][1];
            if(r >= m || r < 0 || c >= n || c < 0 || isV[r][c] || image[r][c] != oldColor) {
                continue;
            }
            isV[r][c] = true;
            image[r][c] = newColor;
            dfs(image,r,c,oldColor,newColor);
        }
    }
}
