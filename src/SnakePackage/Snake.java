package SnakePackage;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Snake {
    private double speed;
    private int length;
    private int cubeWidth;
    private ArrayList<CubeInSnake> arrayList;

    public double getSpeed() {
        return speed;
    }

    public int getLength() {
        return length;
    }

    public ArrayList<CubeInSnake> getArrayList() {
        return arrayList;
    }

    Snake(int CubeWidth, int midX, int midY){
        this.cubeWidth=CubeWidth;
        arrayList  = new ArrayList<>();
        arrayList.add(new CubeInSnake(midX,midY, CubeWidth, Color.BLANCHEDALMOND));
        length=1;
        speed=1;
    }
    private  void moveTail(){
        for(int i=length-1;i>0;i--){
            arrayList.get(i).setX(arrayList.get(i-1).getX());
            arrayList.get(i).setY(arrayList.get(i-1).getY());
        }
    }
    void moveForward(){
        moveTail();
        arrayList.get(0).move(0,-1);

    }
    void moveDownward(){
        moveTail();
        arrayList.get(0).move(0,+1);

    }
    void moveLeftward(){
        moveTail();
        arrayList.get(0).move(-1,0);

    }
    void moveRightward(){
        moveTail();
        arrayList.get(0).move(+1,0);

    }
    void grow(Color color){
        arrayList.add(new CubeInSnake(-99,-99,cubeWidth, color));
        length++;
        speed=speed+0.1;
    }

}
