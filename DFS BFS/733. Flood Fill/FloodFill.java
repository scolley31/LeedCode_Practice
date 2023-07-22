package org.example;

/*
 * Time Complexity O(N*M)
 * Space Complexity O(N*M)
 * Where N is row & M is column
 * */

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int[][] finalImage = image;
        int originColor = image[sr][sc];
        if(image[sr][sc] == color) return image;
        floodFillColor(finalImage, sr, sc, color, originColor);

        return finalImage;
    }

    void floodFillColor(int[][] image, int sr, int sc, int color, int originColor) {
        if (sr >= image.length || sr < 0) return;
        if (sc >= image[0].length || sc < 0) return;

        if (image[sr][sc] != originColor) return;

        image[sr][sc] = color;
        floodFillColor(image, sr - 1, sc, color, originColor);
        floodFillColor(image, sr + 1, sc, color, originColor);
        floodFillColor(image, sr, sc - 1, color, originColor);
        floodFillColor(image, sr, sc + 1, color, originColor);
    }
}
