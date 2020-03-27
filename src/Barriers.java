import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Barriers extends Rectangle {
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screensize = kit.getScreenSize();
    public int width = screensize.width;
    public int height = screensize.height;
    public int xpr;
    public int ypr = Slothe.ky;
    Slothe slothe;
    static public double vx ;
    public int speed = 10;
    Image pr1;
    Rectangle b,b1;

    int m = 1;

    public Barriers() throws IOException {
        xpr = width;
        b = new Rectangle(xpr,ypr,400,400);


    }

    public void draw(Graphics g){
        pr1 = new ImageIcon("src/pr.png").getImage();
        g.drawImage(pr1, xpr,height/2 + 100,null);

    }

    public void update(){
//        if (slothe.cx > width)
//            xpr = 0;
//        if (slothe.cx >= 1000)
//            xpr = 0;
        //System.out.println("Yes");
    }
    public int N  = m * 10;



    public void physics() throws NullPointerException{
        xpr-=vx;
        b.x-=vx;

    }
    public void jump(){
        if ( (b.x > Slothe.kx - 200)&&(b.x < Slothe.kx + 200)) {
         //   System.out.println("yes");
//            Window.slothe.cy+=30;
//            Window.slothe.cx+=5;
            Window.slothe.cy =- 265;
          //  Window.t.stop();


        }
       // System.out.println(b.getBounds());
    }

}
