package SnakePackage;

import javafx.scene.paint.Color;

import java.util.Random;

import  java.lang.Math;

public class Food {
    private  int x;
    private int y;
    private int cubeWidth;
    private int cubeCount;
    private Color color;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCubeWidth() {
        return cubeWidth;
    }

    public int getCubeCount() {
        return cubeCount;
    }

    public Color getColor() {
        return color;
    }

    Food (int cubeWidth, int cubeCount){
        this.cubeWidth=cubeWidth;
        this.cubeCount= cubeCount;
    }
    void newPlace(int maxY, int maxX){
        int R = (int)(Math.random()*256);
        int G = (int)(Math.random()*256);
        int B= (int)(Math.random()*256);
        color = Color.rgb(R, G, B);

        Random rand = new Random();
        x=rand.nextInt(cubeCount)*cubeWidth;
        y=rand.nextInt(cubeCount)*cubeWidth;

    }
    boolean isEaten(int snakeX, int snakeY) {
        return snakeX==x && snakeY==y;
    }
}
