package SnakePackage;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class DirectonKeyEvent implements EventHandler<KeyEvent> {
    private Directon directon;

    public Directon getDirecton() {
        return directon;
    }
    private Directon opposite(){
        if(directon==Directon.UP)
            return Directon.DOWN;
        if(directon==Directon.DOWN)
            return Directon.UP;
        if(directon==Directon.RIGHT)
            return Directon.LEFT;
        else
            return Directon.RIGHT;
    }
        DirectonKeyEvent(Directon directon){
            this.directon=directon;
        }
        @Override
        public void handle(KeyEvent keyEvent) {
            Directon opposite = opposite();
            switch (keyEvent.getCode()){
                case UP:  if(Directon.UP != opposite)directon= Directon.UP; break;
                case DOWN:  if(Directon.DOWN != opposite)directon= Directon.DOWN;break;
                case LEFT:  if(Directon.LEFT != opposite)directon= Directon.LEFT; break;
                case RIGHT:  if(Directon.RIGHT != opposite)directon= Directon.RIGHT; break;

            }

        }
    }
