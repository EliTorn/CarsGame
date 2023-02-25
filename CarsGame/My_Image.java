 package Game_1;

import javax.swing.*;
import java.awt.*;

public class My_Image extends Component {

    private ImageIcon imageCar;
    private int x;
    private int y;
    public Frame frame;

    public My_Image(ImageIcon imageCar, int x, int y, Frame frame){
        this.imageCar = imageCar;
        this.x = x;
        this.y = y;
        this.frame = frame;
     }

    public void paint(Graphics g){
        this.frame.paint(g);
        this.imageCar.paintIcon(this, g, this.x, this.y);
    }

    public void moveRight(){
        this.x += 12;
    }
    public void moveLeft(){
        this.x -= 12;
    }

    public void moveCarsUp(){
        this.y -= 3;
    }
    public void moveCarsUp2(){
        this.y -= 6;
    }
    public void moveCarsUp3(){
        this.y -= 9;
    }

    public void moveCarsDown(){
        this.y += 1;
    }
    public void moveCarsDown2() {
        this.y += 2;
    }
    public void moveCarsDown3() {
        this.y += 3;
    }

    public int getX() {
        return this.x;
    }
    public int getY(){
        return this.y;
    }
}
