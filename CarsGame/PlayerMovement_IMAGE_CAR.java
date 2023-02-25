 package Game_1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerMovement_IMAGE_CAR extends GameScene implements KeyListener {

    private Rectangles Board;
    private My_Image imageCar;
    private Frame frame;

    private My_Image[] obstacles;
    private Frame[] frames;

    public PlayerMovement_IMAGE_CAR(Rectangles board, My_Image imageCar, Frame frame, My_Image[] obstacles, Frame[] frames){
        super();
        this.Board = board;
        this.imageCar = imageCar;
        this.frame = frame;
        this.obstacles = obstacles;
        this.frames = frames;
     }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(this.imageCar.getX() >= this.Board.getWidth()-105 && this.frame.getX() >= this.Board.getWidth()-105){
            this.imageCar.moveLeft();
            this.frame.moveLeft();
        }
        if(this.imageCar.getX() <= 5 && this.frame.getX() <= 5){
            this.imageCar.moveRight();
            this.frame.moveRight();
        }
        switch (key){
            case KeyEvent.VK_RIGHT:
                this.imageCar.moveRight();
                this.frame.moveRight();
                for(int i = 0; i < this.obstacles.length; i++){
                    this.obstacles[i].moveCarsDown();
                    this.frames[i].moveDown();
                }
                 break;
            case KeyEvent.VK_LEFT:
                this.imageCar.moveLeft();
                this.frame.moveLeft();
                for(int i = 0; i < this.obstacles.length; i++){
                    this.obstacles[i].moveCarsDown();
                    this.frames[i].moveDown();
                }
                break;
            case KeyEvent.VK_UP:
                 for(int i = 0; i < this.obstacles.length; i++){
                    this.obstacles[i].moveCarsDown();
                    this.frames[i].moveDown();
                 }
                 break;
            case KeyEvent.VK_DOWN:
                for(int i = 0; i < this.obstacles.length; i++){
                    if (points < 3000) {
                        this.obstacles[i].moveCarsUp();
                        this.frames[i].moveUp();
                    } else if (points > 3000 && points < 10000) {
                        this.obstacles[i].moveCarsUp2();
                        this.frames[i].moveUp2();
                    } else {
                        this.obstacles[i].moveCarsUp3();
                        this.frames[i].moveUp3();
                    }
                }
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
    }
}
