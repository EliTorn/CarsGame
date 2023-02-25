package Game_1;
import javax.swing.*;
import java.awt.*;

public class MainWindow {

    public static final int WINDOW_WIDTH = 720;
    public static final int WINDOW_HEIGHT = 600;

    //This constructor build a window.
    private static JFrame frame = new JFrame();;
    public void run(){
        frame.setVisible(true);
        frame.setSize(new Dimension (WINDOW_WIDTH , WINDOW_HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);

        //This constructor build a Panel on the window.
        GameScene gameScene = new GameScene(0, 0 , WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.add(gameScene);
    }
    public static void close(){
        frame.dispose();
     }
}