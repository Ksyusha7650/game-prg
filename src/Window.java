

import javazoom.jl.decoder.JavaLayerException;

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
import java.util.Scanner;

import static java.awt.Font.TYPE1_FONT;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Window  implements KeyListener, ActionListener {
    JPanel panel;
    JFrame frame = new JFrame("The slothe.");
    JFrame fr= new JFrame("Finish");
    static Slothe slothe;
   public int time;
    public static int k;
    static Timer t;
    static boolean paused;
    public int score=time;
    static  Toolkit  kit = Toolkit.getDefaultToolkit();
    static Dimension  screensize = kit.getScreenSize();
    public static int width = screensize.width;
    public static int height = screensize.height;
    Image slothee;
  static Level level;
  static Menu menu1;
  static Music music;
    public JLabel m;
    Font font = new Font("Verdana",Font.PLAIN,35);

 Barriers b;
    public void go (int num) throws IOException, FileNotFoundException, JavaLayerException {
        fr.setSize(width/2,height/2);
        fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel l = new JLabel("Level completed!!!");
        fr.add(l);
        slothe = new Slothe();
        slothe.addF(0, -2);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);//при закрытии окошка-программа автоматически завершается
        panel = new GamePanel(slothe, level);//добавляем в панель объекты
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
        menu1 = new Menu();
        menu1.close(panel);
        m = new JLabel();
        m.setLocation(10,50);
        m.setSize(100,100);
        m.setBackground(Color.DARK_GRAY);
        m.setFont(font);
        panel.add(m);



    }

    public static void main(String[] args) throws IOException, JavaLayerException, NullPointerException {
        new Menu().setMenu();
        level =new Level();
        music = new Music("src/1.mp3");
        music.play();
    }
    @Override
    public void actionPerformed (ActionEvent actionEvent){
        panel.repaint();
        m.setText(String.valueOf(k));
//        if (Menu.ch ==300) {
//            try {
//                new Music().play(Level.song);
//            } catch (JavaLayerException | IOException e) {
//                e.printStackTrace();
//            }
//        }
        if(t.isRunning()) {
            level.end(k);
           // Menu.ch ++;
            // System.out.println(finish);
            if (level.finish) {
                panel.removeAll();
                frame.removeAll();
                //   fr.setJMenuBar(menu1.menuBar);
                //menu.close(fr);

                fr.show();
                //System.out.println(n + " " + kl);
            }
        }
        }



    @Override
    public void keyTyped (KeyEvent e){

    }

    @Override
    public void keyPressed (KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
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


