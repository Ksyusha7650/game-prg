

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.ArrayList;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Window  implements KeyListener, ActionListener {
    JPanel panel;
    JFrame frame = new JFrame("The slothe.");
    JFrame fr= new JFrame("Finish");
    static Slothe slothe;
   public int time;
    public int n;
    public static int k;
    static Timer t;
    static boolean paused;
    JButton pause;
    public int score=time;
    ArrayList <Rectangle> rects;
    Toolkit kit = Toolkit.getDefaultToolkit();
    Image slotheel1,slotheel2, slothee, slotheel3;
    FileReader fileReader;
  public  File level_number;
  Level level;
  Menu menu1;
 Barriers b;


    public String picture;
    public void go () throws IOException, FileNotFoundException {

        fr.setSize(200,300);
        fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
        slothe = new Slothe();
        rects = new ArrayList<Rectangle>();
        slothe.addF(0, -2);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);//при закрытии окошка-программа автоматически завершается
        panel = new GamePanel(slothe,rects, level);//добавляем в панель объекты
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
        level = new Level();
        b = new Barriers();
        menu1 = new Menu();

        menu1.close(panel, frame);
        level_number = new File("src/level1.txt");
        fileReader = new FileReader(level_number);
        n = (fileReader.read())*30;


    }

    public static void main(String[] args) throws IOException {
        new Window().go();
    }
    @Override
    public void actionPerformed (ActionEvent actionEvent){
        panel.repaint();

        if(t.isRunning()) {
            //   System.out.println(finish);
            // System.out.println("YES");
            level.end(n, k);
            // System.out.println(finish);
            if (level.finish) {
                panel.removeAll();
                frame.removeAll();
                //   fr.setJMenuBar(menu1.menuBar);
                //menu.close(fr);

                fr.show();

            }
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
            Barriers.vx += 0.1;
            k= (k + slothe.cx/100);

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
            Barriers.vx = 0;
    }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            slothe.vx=0;
            slothe.slothee = slothee;
        }
    }
}


