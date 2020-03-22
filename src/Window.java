

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Window  implements KeyListener, ActionListener {
    JPanel panel;
    Slothe slothe;
    int time;
    Timer t;
    boolean paused;
    public int score=time;
    ArrayList <Rectangle> rects;
    Toolkit kit = Toolkit.getDefaultToolkit();
    Image slotheel1,slotheel2, slothee, slotheel3;
    FileReader fileReader;
  public  File level;
    public String picture;
    public void go () throws IOException {

        JFrame frame = new JFrame("The slothe.");
        slothe = new Slothe();
        rects = new ArrayList<Rectangle>();
        slothe.addF(0, -2);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);//при закрытии окошка-программа автоматически завершается
        panel = new GamePanel(slothe,rects);//добавляем в панель объекты
        frame.add(panel);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);//делаем окошко видимым
        frame.addKeyListener(this);
      //  frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
        ImageIcon icon = new ImageIcon("src/icon2.png");
        frame.setIconImage(icon.getImage());
        paused = true;
        t = new Timer(10 , this);
        t.start();
        slothee = ImageIO.read(new File("src/slothe.png"));
        level = new File("");
//        try(FileReader reader = new FileReader("notes3.txt"))
//        {
//            int c;
//            while((c=reader.read())!=-1){
//
//                System.out.print((char)c);
//            }
//        }
//        catch(IOException ex){
//
//            System.out.println(ex.getMessage());
//        }
        fileReader = new FileReader(level);

    }

    public static void main(String[] args) throws IOException {
        new Window().go();

    }
    @Override
    public void actionPerformed (ActionEvent actionEvent){
        panel.repaint();
        if (!paused){
            slothe.physics();

//            if(slothe.cx>100){
////                System.out.println("yes");
//                Rectangle r2 = new Rectangle(slothe.width,slothe.height/2 +200, 50,70);
//                rects.add(r2);
//            }
//
//            ArrayList<Rectangle> toRemove = new ArrayList<Rectangle>();
//            for(Rectangle r : rects) {
//
//                r.x = slothe.width-50;
//
//
//                if (r.x + r.width <= 0) {
//                    toRemove.add(r);
//
//                }
//            }
        }

    }

    @Override
    public void keyTyped (KeyEvent e){

    }

    @Override
    public void keyPressed (KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            paused = false;
            try {
          slothe.jump(25);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            slothe.vx+=0.1;
            while (GamePanel.speed<5)
            GamePanel.speed+=1;
            slothe.rundraw();

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            slothe.vx-=0.1;
            slothe.rundrawl();
        }
    }

    @Override
    public void keyReleased (KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            slothe.vx=0;
            GamePanel.speed=0;
            slothe.slothee = slothee;
    }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            slothe.vx=0;
            slothe.slothee = slothee;
        }
    }
}


