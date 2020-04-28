package SnakePackage;

import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class GameLoop {
    boolean gameOver;
    Food food;
    Snake snake;
    int width;
    GraphicsContext gc;
    int cubeWidth;
    int midX,midY;

    public GameLoop(Food food, Snake snake, int width, GraphicsContext gc, int cubeWidth, int midx, int midy) {
        gameOver = false;
        this.food = food;
        this.snake = snake;
        this.width = width;
        this.gc = gc;
        this.cubeWidth = cubeWidth;
        this.midX=midx;
        this.midY=midy;
    }


    public void loop(Directon directon) {

        if (!gameOver) {
            gc.clearRect(0, 0, width, width);
            if (food.isEaten(snake.getArrayList().get(0).getX(), snake.getArrayList().get(0).getY())) {
                snake.grow(food.getColor());
                food.newPlace(width, width);
            }
            switch (directon) {
                case UP:

                    snake.moveForward();
                    break;
                case DOWN:
                    snake.moveDownward();
                    break;
                case LEFT:
                    snake.moveLeftward();
                    break;
                case RIGHT:
                    snake.moveRightward();
                    break;

            }
            for (int i = 0; i < snake.getLength(); i++) {
                int x = snake.getArrayList().get(i).getX();
                gc.setFill(snake.getArrayList().get(i).getColor());
                gc.fillRect(snake.getArrayList().get(i).getX(), snake.getArrayList().get(i).getY(), cubeWidth, cubeWidth);
            }
            gc.setFill(food.getColor());
            gc.fillRect(food.getX(), food.getY(), cubeWidth, cubeWidth);

            int x = snake.getArrayList().get(0).getX();
            int y = snake.getArrayList().get(0).getY();

            if (x > width || x < 0 || y > width || y < 0)
                gameOver = true;

            for (int i = 1; i < snake.getLength(); i++) {
                if (x == snake.getArrayList().get(i).getX() && y == snake.getArrayList().get(i).getY())
                    gameOver = true;
            }
        } else {
            gc.setFill(Color.WHITE);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.setTextBaseline(VPos.CENTER);
            int fontSize=midX/3;
            gc.setFont(Font.font(fontSize));
            gc.fillText("Game over", midX, midY-(2*fontSize));
            gc.fillText("Score = " +(snake.getLength()-1), midX, midY+fontSize);

        }
    }
}


