package group7.Graphics;

import java.awt.image.BufferedImage;
import java.awt.*;

import static group7.Graphics.GraphicsPanel.panelHeight;
import static group7.Graphics.GraphicsPanel.panelWidth;


public class GraphicsGrid {
    private GraphicsPanel graphicsPanel;

    public static int scaleX;
    public static int scaleY;
    public static int gridWidth;
    public static int gridHeight;

    // Getters
    public static int getScaleY() {
        return scaleY;
    }

    public static int getScaleX() {
        return scaleX;
    }

    public static int getGridWidth() {
        return gridWidth;
    }

    public static int getGridHeight() {
        return gridHeight;
    }

    /**
     * Constructor, creates a new GraphicsGrid
     * @param graphicsPanel
     * the graphics panel to draw on
     * @param unitsWide
     * the width of the grid
     * @param unitsHigh
     * the height of the grid
     */
    public GraphicsGrid(GraphicsPanel graphicsPanel, int unitsWide, int unitsHigh) {
        this.graphicsPanel = graphicsPanel;
        gridWidth = unitsWide;
        gridHeight = unitsHigh;
        calculateScale();
    }

    /**
     * sets the grid size
     * @param unitsWide
     * the width of the grid
     * @param unitsHigh
     * the height of the grid
     */
    public static void setGridSize(int unitsWide, int unitsHigh) {
        gridWidth = unitsWide;
        gridHeight = unitsHigh;
        calculateScale();
        System.out.println("GridHeigh :" + gridHeight);
        System.out.println("GridWidth : " + gridWidth);
    }

    /**
     * calculates the scale of the grid 
     * using the size of the screen and the size of the grid
     */
    private static void calculateScale() {
        // TODO: call graphicsPanel to get the width and height
        scaleX = panelWidth / gridWidth;
        scaleY = panelHeight / gridHeight;
        System.out.println("ScaleX : " + scaleX);
        System.out.println("ScaleY: " + scaleY);
    }

    /**
     * translates the given x and y coordinates to the correct position on the screen 
     * by multiplying them by the given grid sizes
     * @param g
     * the gridics object to draw on
     * @param image
     * the image to draw
     * @param posX
     * x coordinate
     * @param posY
     * y coordinate
     * @param width
     * width of the image
     * @param height
     * height of the image
     */
    public static void render(Graphics g, BufferedImage image, double posX, double posY, double width, double height) {
        g.drawImage(
            image, 
            (int) (posX * scaleX), 
            (int) (posY * scaleY), 
            (int) (width * scaleX),
            (int) (height * scaleY),
            null
        );
    }

    /**
     * creates a rectangle on the screen for debugging purposes
     * @param g
     * @param posX
     * @param posY
     * @param width
     * @param height
     */
    public static void drawRect(Graphics g, double posX, double posY, double width, double height) {
        g.drawRect(
            (int) (posX * scaleX), 
            (int) (posY * scaleY), 
            (int) (width * scaleX),
            (int) (height * scaleY)
        );
    }
}
