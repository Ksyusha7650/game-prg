import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Slothe {
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screensize = kit.getScreenSize();
    public int width = screensize.width;
    public int height = screensize.height;
    Image slothee;
    public String picture;
    int cx = width / 2 - 250, cy=-height/2+1000;
    double vx = 0, vy;
    int ax, ay;
    int m = 1;
    public int runn = 0;
     ArrayList<String> list = new ArrayList<>();
    ArrayList<String> listl = new ArrayList<>();
    public void addF(int fx, int fy) {
        ax += fx / m;
        ay += fy / m;
    }

    public Slothe() throws IOException {
        slothee = ImageIO.read(new File("src/slothe.png"));
        list.add("src/slothe_l1.png");
        list.add("src/slothe_l1.png");
        list.add("src/slothe_l1.png");
        list.add("src/slothe_l1.png");
        list.add("src/slothe_l1.png");
        list.add("src/slothe_l1.png");


        list.add("src/slothe_l2.png");
        list.add("src/slothe_l2.png");
        list.add("src/slothe_l2.png");
        list.add("src/slothe_l2.png");
        list.add("src/slothe_l2.png");
        list.add("src/slothe_l2.png");

        listl.add("src/slothe_r1.png");
        listl.add("src/slothe_r1.png");
        listl.add("src/slothe_r1.png");
        listl.add("src/slothe_r1.png");
        listl.add("src/slothe_r1.png");
        listl.add("src/slothe_r1.png");

        listl.add("src/slothe_r2.png");
        listl.add("src/slothe_r2.png");
        listl.add("src/slothe_r2.png");
        listl.add("src/slothe_r2.png");
        listl.add("src/slothe_r2.png");
        listl.add("src/slothe_r2.png");
    }



    public void physics() {
//        System.out.println(width);
//        System.out.println(height);
        vx += ax;
        vy += ay;
        cx += vx;
        cy += vy;
        if (cy < -height/2 + 100)
            cy = -height/2 + 100;
        if (cy <= -height/2+ 100)
            vy = 0;
//        if (cx > width-5 ) {
//            ;
//        }
//        if (cx < 0)
//            cx = 0;






    }
    public void draw(Graphics g){
        g.setColor(Color.BLACK);

//        g.drawOval(cx,-cy + 500,20,20);
         g.drawImage(slothee,cx,-cy,null);
       // g.drawRect(0,height/2 +200, 50,70);

    }

    public void jump(int jumpPower) throws InterruptedException {
        vy += jumpPower;
    }



    public void rundraw() {
        runn++;
        if (runn < list.size()) {
        } else {
            runn = 0;
        }
        picture = list.get(runn);
        slothee = new ImageIcon(picture).getImage();
    }
    public void rundrawl() {
        runn++;
        if (runn < listl.size()) {
        } else {
            runn = 0;
        }
        picture = listl.get(runn);
        slothee = new ImageIcon(picture).getImage();
    }


}