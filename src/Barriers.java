import javax.swing.*;
import java.awt.*;

public class Barriers {
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screensize = kit.getScreenSize();
    public int width = screensize.width;
    public int height = screensize.height;
    public int xpr = 600;
    public int speed = 10;
    Image pr1;
    Slothe slothe;

    public void draw(Graphics g){
        pr1 = new ImageIcon("src/pr.png").getImage();
        g.drawImage(pr1,xpr,height - 200,null);
    }

    public void update(){
//        if (slothe.cx > width)
//            xpr = 0;
//        if (slothe.cx >= 1000)
//            xpr = 0;
        //System.out.println("Yes");
    }

}
