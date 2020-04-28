package SnakePackage;


import javafx.scene.paint.Color;

public class CubeInSnake {
    private int x;
    private int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    private Color color;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    int cubeWidth;
    CubeInSnake(int x, int y, int cubeWidth, Color color){
        this.x=x;
        this.cubeWidth=cubeWidth;
        this.y=y;
        this.color=color;
    }
    public void move(int DX,int DY){
        y=y+DY*cubeWidth;
        x=x+DX*cubeWidth;

    }

}
