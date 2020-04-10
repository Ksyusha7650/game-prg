
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class GamePanel extends JPanel {
    Slothe slothe;
    Image  pipeLength;
    public int width = 1700;
    static Image bg1 = new ImageIcon(Level.bg_path).getImage();
    static Image bg2 = new ImageIcon(Level.bg_path).getImage();
   public int xmove, xmove1= width;
  static public  double speed ;
    Image change[] = {bg1,bg2};
    Barriers barriers [];
    int i;
    public int xpr;

    public GamePanel(Slothe slothe, Level level) throws IOException {
        this.slothe=slothe;
        barriers = new Barriers[Level.am];

    //    pipeLength = ImageIO.read(new File("C:\\Users\\Ксюша\\Desktop\\untitled\\src\\78px-Pipe.png"));
    }
    public void painting_b(Graphics g) {
        for (Barriers b: barriers) {
            if (Window.k % 30 >= 15) {
                b = new Barriers();
                b.draw(g);
                b.physics();
            }
        }
    }




    @Override
    public void paintComponent(Graphics g) throws NullPointerException{
     g.setColor(Color.WHITE);
     bg(g);
     slothe.draw(g);
     slothe.physics();
     painting_b(g);

//     if (Window.k > Level.k1) {
//         b.draw(g);
//         b.physics();
//         b.hills(g);
//         try {
//             b.jump();
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
//        if (Window.k > Level.k2) {
//            b1.draw(g);
//            b1.physics();
//            try {
//                b1.jump();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        if (Window.k > Level.k3){
//            b2.draw(g);
//            b2.physics();
//            b2.jump2();
//        }
//        if (Window.k > Level.k4){
//            b3.draw(g);
//            b3.physics();
//            b3.jump2();
//        }
//        if (Window.k > Level.k5){
//            b4.draw(g);
//            b4.physics();
//            b4.jump2();
//        }
        //System.out.println(b1.x);
      //  System.out.println(b.xpr +" " + Slothe.kx);


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