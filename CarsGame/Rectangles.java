 package Game_1;

import java.awt.*;

public class Rectangles {

    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public Rectangles(int x, int y, int width, int height, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void paint(Graphics g){
        g.setColor(this.color);
        g.fillRect(this.x, this.y, this.width, this.height);
    }

    public void paint2(Graphics g){
        g.setColor(this.color);
        g.drawRect(this.x, this.y, this.width, this.height);
    }

    public void moveRight(){
        this.x += 12;
    }
    public void moveLeft(){
        this.x -= 12;
    }

    public void moveUp(){
        this.y -= 3;
    }
    public void moveUp2() {
        this.y -= 6;
    }
    public void moveUp3() {
        this.y -= 9;
    }

    public void moveDown(){
        this.y += 1;
    }
    public void moveDown2() {
        this.y += 2;
    }
    public void moveDown3() {
        this.y += 3;
    }

    public Color getColor() {
        return color;
    }
    public int getX(){
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }

}
