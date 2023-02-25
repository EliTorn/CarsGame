package Game_1;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameScene extends JPanel {
    
    protected int points;       // I did it protected because I wanted to approach it from PlayerMovement_I_C class.
    // here I declare on the road and his frames
    private Rectangles BOARD;
    private Rectangles ROAD_1;
    private Rectangles ROAD_2;
    private Rectangles ROAD_3;
    private Rectangles FRAME_RIGHT;
    private Rectangles FRAME_LEFT;

    //here I declare on the obstacles and their frames
    private Frame[] frames;
    private Rectangles[] rectangles;
    private My_Image[] obstacles;
    private ImageIcon cars;

    //here I declare on the user car and his frame
    private Frame frame;
    private Rectangles rectangle;
    private My_Image imageCar;
    private ImageIcon image;


    public GameScene(int x, int y, int width, int height) {

        this.setBounds(x, y, width, height);
        this.setLayout(null);

        // It builds the road of the game
        this.BOARD = new Rectangles(0, 0, width, height, Color.darkGray);
        ROAD_1 = new Rectangles((width / 4), 0, 6, height, Color.white);
        ROAD_2 = new Rectangles((width / 2), 0, 6, height, Color.white);
        ROAD_3 = new Rectangles((width/4)*3, 0, 6, height, Color.white);
        FRAME_RIGHT = new Rectangles(width-19, 0, 5, height, Color.green);
        FRAME_LEFT = new Rectangles(0, 0, 5, height, Color.green);

        //It builds the user car and his frame
        this.rectangle = new Rectangles(300, height-200, 80, 160, Color.darkGray);
        this.frame = new Frame(this.rectangle);
        this.image = new ImageIcon("C:\\Users\\ELI\\Desktop\\coding and cyber\\java\\CarsGame\\MyCar_.png");
        this.imageCar = new My_Image(image, 250, height-220, frame);

        //It builds the obstacles and their frames
        this.obstacles = new My_Image[530];
        this.frames = new Frame[530];
        this.rectangles = new Rectangles[530];
        Random random = new Random();
        //this is where the first car start(on -250)
        int min = -250;
        int max = min + 80;
        for(int i = 0; i < this.obstacles.length; i++){
            int x1 = random.nextInt(4);
            int X;
            int Y = random.nextInt( max - min) + min;
//this is the formula that determines where each car will be:
//random.nextInt(max - min) + min
// max = 30; min = -10;
//Will yield a random int between -10 and 30 (exclusive).
            switch (x1){
                case 0:
                    X = 45;
                    break;
                case 1:
                    X = 180+45;
                    break;
                case 2:
                    X = 180*2+45;
                    break;
                case 3:
                    X = 180*3+45;
                    break;
                default:
                    X = 0;
            }
            min -= 250;
            max = min + 80;
            ImageIcon randomCars;
            int x2 = random.nextInt(3);
            switch (x2){
                case 0:
                    randomCars = new ImageIcon("C:\\Users\\ELI\\Desktop\\coding and cyber\\java\\CarsGame\\cars.png");
                    break;
                case 1:
                    randomCars = new ImageIcon("C:\\Users\\ELI\\Desktop\\coding and cyber\\java\\CarsGame\\cars2.png");
                    break;
                default:
                    randomCars = new ImageIcon("C:\\Users\\ELI\\Desktop\\coding and cyber\\java\\CarsGame\\car3.png");
                    break;
            }
            rectangles[i] = new Rectangles(X-3, Y, 90, 160, Color.darkGray);
            obstacles[i] = new My_Image(
                    this.cars = randomCars,
                    X-10,
                    Y,
                    this.frames[i] = new Frame(this.rectangles[i])
            );
        }
         this.mainGameLoop();
        }

    public GameScene() {
    }

    //this is the paint function
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.BOARD.paint(g);
        this.ROAD_1.paint(g);
        this.ROAD_2.paint(g);
        this.ROAD_3.paint(g);
        this.FRAME_LEFT.paint(g);
        this.FRAME_RIGHT.paint(g);

        this.imageCar.paint(g);
        this.frame.paint(g);

        for(int i = 0; i < this.obstacles.length; i++){
            this.obstacles[i].paint(g);
            this.frames[i].paint(g);
        }
        g.setFont(new Font("Thoma", Font.PLAIN, 40));
        g.setColor(Color.RED);
        g.drawString(String.valueOf(points), 20, 50);
    }

    //This thread is responsible for car movements on the board and draw the draw method all the time.
    public void mainGameLoop(){
        new Thread(()->{
            PlayerMovement_IMAGE_CAR board = new PlayerMovement_IMAGE_CAR(this.BOARD, this.imageCar, this.frame, this.obstacles, this.frames);
            this.setFocusable(true);
            this.requestFocus();
            this.addKeyListener(board);
            first:
            while(true){
                try {
                    for(int i = 0; i < this.obstacles.length; i++){
                        if(this.frame.checkCollision(frames[i])){
                            this.rectangle =  new Rectangles(this.frame.getX(), this.frame.getY(), 145,70 , Color.gray);
                            this.frame = new Frame(this.rectangle);
                            this.image = new ImageIcon("C:\\Users\\ELI\\Desktop\\coding and cyber\\java\\CarsGame\\MyCarBroked_.png");
                            this.imageCar = new My_Image(image, this.frame.getX()-15 , this.frame.getY()-18, frame);
                            repaint();

                            GameOver gameOver = new GameOver(points);
                            break first;
                        }
                        if(this.points >= 50000){
                            WinnerWindow window = new WinnerWindow();
                            break first;
                        }
                    }
                     for(int i = 0; i < this.obstacles.length; i++){
                         if (points < 3000) {
                             this.obstacles[i].moveCarsDown();
                             this.frames[i].moveDown();
                         } else if (points > 3000 && points < 15000) {
                             this.obstacles[i].moveCarsDown2();
                             this.frames[i].moveDown2();
                         } else {
                             this.obstacles[i].moveCarsDown3();
                             this.frames[i].moveDown3();
                         }
                     }
                    Thread.sleep(6);
                    points++;
                    repaint();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }

}