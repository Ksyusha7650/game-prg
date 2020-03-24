
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class GamePanel extends JPanel {
    Slothe slothe;
    Image  pipeLength;
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screensize = kit.getScreenSize();
    public int width = 1700;
    ArrayList<Rectangle> rects;
    static Image bg1 = new ImageIcon("src/back-ground.png").getImage();
    static Image bg2 = new ImageIcon("src/back-ground.png").getImage();
   public int xmove, xmove1= width;
  static public  double speed ;
    Image change[] = {bg1,bg2};
    Barriers b = new Barriers();
    Level level = new Level();

    public GamePanel(Slothe slothe,ArrayList<Rectangle> rects, Level level) throws IOException {
        this.slothe=slothe;
        this.rects = rects;
        this.level = level;
    //    pipeLength = ImageIO.read(new File("C:\\Users\\Ксюша\\Desktop\\untitled\\src\\78px-Pipe.png"));
    }




    @Override
    public void paintComponent(Graphics g) throws NullPointerException{
     g.setColor(Color.WHITE);
     bg(g);
     slothe.draw(g);
     slothe.physics();
     b.draw(g);
     b.update();


 }

 public void bg(Graphics g){
        g.drawImage(change[0],xmove,0,null);
        g.drawImage(change[1],xmove1,0,null);
     xmove -= speed ;
     xmove1 -= speed;

     if(xmove == -width)
         xmove = 0;
     if (xmove1 == 0)
         xmove1 = width;

 }




}