import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;

public class Menu {
   JButton pause;
   GamePanel panel1;
   Graphics g;
   Timer t;
    Icon p = new ImageIcon("src/pause.png");
    Icon pl = new ImageIcon("src/play.png");
//    public static void main(String[] args) {
//        JFrame fr = new JFrame();
//        JMenuBar menuBar = new JMenuBar();
//        JMenu menu = new JMenu("Меню");
//        JLabel label = new JLabel("Exit");
//        menu.addSeparator();
//        menu.setSize(200,150);
//        JMenuItem menuItem = new JMenuItem("Exit");
////        menuItem.setBackground(Color.GREEN);
////        menuItem.setVisible(true);
////        menuItem.setSize(100, 30);
////        menu.add(menuItem);
//        menu.add(menuItem);
//        menuBar.add(menu);
//     //  fr.add(label);
////        menuBar.setSize(200,200);
////        menuBar.setVisible(true);
////        fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        fr.setSize(200,200);
//        fr.setJMenuBar(menuBar);
//        fr.show();
//    }
    public Menu() {
   //  Window.paused = false;
      //  close(frame);
    }
    public void close(JPanel panel, JFrame frame) {
        pause = new JButton();
        pause.setSize(50,50);
        pause.setIcon(p);
        pause.setAlignmentX(200);
        pause.setAlignmentY(200);
        pause.setBorderPainted(false);
        pause.setFocusable(false);
        pause.addActionListener(actionEvent -> {
            if (pause.getIcon() == p) {

                pause.setIcon(pl);
               Window.t.stop();
            }
            else {
                pause.setIcon(p);
                Window.t.start();
            }
        });
        panel.add(pause);
    }
}
