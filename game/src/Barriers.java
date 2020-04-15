import javafx.scene.transform.Scale;

import javax.imageio.ImageIO;
import javax.imageio.ImageTranscoder;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriteParam;
import javax.imageio.metadata.IIOMetadata;
import javax.swing.*;
import java.awt.*;
import java.awt.font.ImageGraphicAttribute;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.util.Random;


public class Barriers extends Rectangle {
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screensize = kit.getScreenSize();
    public int width = screensize.width;
    public int height = screensize.height;
    public int xpr;
    public int h = height/2 + 100;
    public  int ypr = h;
    Slothe slothe;
    static public double vx ;
    public int speed = 10;
    Image pr1, pr2;
    Rectangle b,b1;
    Paint paint;
    int m = 1;
    BufferedImage im;
    Barriers bar;

    public Barriers() {
        xpr = width;
    }

    public void draw(Graphics g){
        pr1 = new ImageIcon("src/hill1.png").getImage();
        g.drawImage(pr1, xpr,0 ,null);
        b = new Rectangle(xpr,ypr,400,400);

    }
    public void draw2(Graphics g){
        pr2 = new ImageIcon("src/hill2.png").getImage();
        g.drawImage(pr2, x,ypr,null);
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

    }
    public void jump() throws IOException {
        if ((b.x > Slothe.kx - 200) && (b.x < Slothe.kx + 200)) {
            //   System.out.println("yes");
//            Window.slothe.cy+=30;
//            Window.slothe.cx+=5;
//            Window.slothe.cy = -265;
            Window.slothe.cy = -ypr+270;
           // new Slothe().rundraw();
            //  Window.t.stop();

        }
    }
        public void jump2(){
            if ( (b.x > Slothe.kx - 200)&&(b.x < Slothe.kx + 200)) {
            Window.slothe.cy+=30;
            Window.slothe.cx+=5;
            }
    }
    public void hills(Graphics g){
        x = xpr + 200;
        draw2(g);
    }

}
