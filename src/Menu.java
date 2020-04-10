import javazoom.jl.decoder.JavaLayerException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import static java.awt.Frame.MAXIMIZED_BOTH;

public class Menu {
   JButton pause, play, settings;
   public static int ch;
    Icon p1 = new ImageIcon("src/pause1.png");
    Icon p2 = new ImageIcon("src/play1.png");
    Icon pl = new ImageIcon("src/playb.png");

    static  Toolkit  kit = Toolkit.getDefaultToolkit();
    static Dimension  screensize = kit.getScreenSize();
    public static int width = screensize.width;
    public static int height = screensize.height;
    JFrame menu = new JFrame();

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
    public Menu() throws FileNotFoundException, JavaLayerException {

    }
    public void setMenu() throws NullPointerException, FileNotFoundException, JavaLayerException {
        menu.setExtendedState(MAXIMIZED_BOTH);
        Menu_panel panel = new Menu_panel();
        menu.add(panel);
        menu.show();
        play = new JButton();
//        play.setSize(350,350);
//        play.setIcon(pl);
        play.setSize(width/2+800,height/2);
        play.setIcon(pl);
        play.setHorizontalAlignment(SwingConstants.CENTER);
        play.setVerticalAlignment(SwingConstants.BOTTOM);
        // play.setAlignmentY(200);
      //  play.setAlignmentX(200);
        play.setFocusPainted(false);
        play.setContentAreaFilled(false);
        play.setBorderPainted(false);
        play.setFocusable(false);
        play.addActionListener(actionEvent -> {
            ch = 1;
          //  menu.show(false);
//            try {
//                new Window().go();
//
//            } catch (IOException | JavaLayerException e) {
//                e.printStackTrace();
//            }
            try {
                new Level().menu_level();
            } catch (FileNotFoundException | JavaLayerException e) {
                e.printStackTrace();
            }
        });
        panel.add(play);
        panel.setSettings(panel);


    }
    public void close(JPanel panel) {
        pause = new JButton();
        pause.setSize(50,50);
        pause.setIcon(p1);
        pause.setAlignmentX(200);
        pause.setAlignmentY(200);
        pause.setBorderPainted(false);
        pause.setFocusPainted(false);
        pause.setContentAreaFilled(false);
        pause.setFocusable(false);
        pause.addActionListener(actionEvent -> {
            if (pause.getIcon() == p1) {

                pause.setIcon(p2);
               Window.t.stop();
            }
            else {
                pause.setIcon(p1);
                Window.t.start();
            }
        });
        panel.add(pause);
    }

}
