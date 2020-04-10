import javazoom.jl.decoder.JavaLayerException;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Menu_panel extends JPanel {
    static Image bg = new ImageIcon("src/Menu.png").getImage();
    JButton settings;
    Icon pl = new ImageIcon("src/play.png");
    Icon s = new ImageIcon("src/Settings.png");
    Settings set = new Settings();

    public Menu_panel() throws FileNotFoundException, JavaLayerException {

    }

    @Override
    public void paintComponent(Graphics g) throws NullPointerException {
        g.setColor(Color.WHITE);
        g.drawImage(bg,0,0,null);
    }
    public void playb(Frame menu, JButton play){
        play = new JButton();
        play.setIcon(pl);
        play.setSize(50,50);
        play.setAlignmentY(200);
        play.setAlignmentX(200);
        play.setFocusPainted(false);
        play.setContentAreaFilled(false);
        play.setBorderPainted(false);
        play.setFocusable(false);
        play.addActionListener(actionEvent -> {
            menu.show(false);
//            try {
//               // new Window().go();
//            } catch (IOException | JavaLayerException e) {
//                e.printStackTrace();
//            }
        });
    }
    public void setSettings(JPanel panel){
        settings = new JButton();
        settings.setSize(200,100);
        settings.setIcon(s);
        settings.setLocation(300,600);
        settings.setFocusPainted(false);
        settings.setContentAreaFilled(false);
        settings.setBorderPainted(false);
        settings.setFocusable(false);
        settings.addActionListener(actionEvent -> {
            set.Settings();
        });
        panel.add(settings);
    }
}
