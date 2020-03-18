

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
    ArrayList <Rectangle> rect;
    public void go () throws IOException {

        JFrame frame = new JFrame("The slothe.");
        slothe = new Slothe();
        slothe.addF(0, -2);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);//при закрытии окошка-программа автоматически завершается
        panel = new GamePanel(slothe);//добавляем в панель объекты
        frame.add(panel);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);//делаем окошко видимым
        frame.addKeyListener(this);
        ImageIcon icon = new ImageIcon("C:\\Users\\ксюша\\Desktop\\GamePanel\\src\\raw\\icon23.png");
        frame.setIconImage(icon.getImage());
        paused = true;
        t = new Timer(10 , this);
        t.start();


    }

    public static void main(String[] args) throws IOException {
        new Window().go();

    }
    @Override
    public void actionPerformed (ActionEvent actionEvent){
        panel.repaint();
        if (!paused){
            slothe.physics();
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
            slothe.vx+=0.4;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            slothe.vx-=0.4;
        }
    }

    @Override
    public void keyReleased (KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            slothe.vx=0;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            slothe.vx=0;
        }
    }
}


