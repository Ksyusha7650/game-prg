import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Slothe {
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screensize = kit.getScreenSize();
    public int width = screensize.width;
    public int height = screensize.height;
    Image slothee;
    int cx = width / 2 - 250, cy=-height/2+1000;
    double vx = 0, vy;
    int ax, ay;
    int m = 1;
    public void addF(int fx, int fy) {
        ax += fx / m;
        ay += fy / m;
    }

    public Slothe() throws IOException {

        slothee = ImageIO.read(new File("E:\\untitled\\src\\slothe.png"));
    }



    public void physics() {
        vx += ax;
        vy += ay;
        cx += vx;
        cy += vy;
        if (cy < -height/2 + 200)
            cy = -height/2+ 200;
        if (cy <= -height/2+ 200)
            vy = 0;
        if (cx > width/2+200)
            cx = width/2+200;
        if (cx < 0)
            cx = 0;
    }
    public void draw(Graphics g){
        g.setColor(Color.BLACK);

//        g.drawOval(cx,-cy + 500,20,20);
         g.drawImage(slothee,cx,-cy,null);

    }

    public void jump(int jumpPower) throws InterruptedException {
        vy += jumpPower;
    }

}