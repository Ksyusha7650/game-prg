import javazoom.jl.decoder.JavaLayerException;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Level {
    boolean finish;
    static public int n, am, k1,k2,k3,k4,k5;
    static public String song, bg_path;
    FileReader fileReader;
    public File level_number;
    JFrame m;
    JPanel p;
    JButton l1,l2,l3;
    JButton [] l;
    int ch;
    Menu menu;
    int num;

    public Level() throws FileNotFoundException, JavaLayerException {
        menu = new Menu();
    }

    public void Level(int ch) throws FileNotFoundException, JavaLayerException {
        level_number = new File("src/level" + ch + ".txt");
        fileReader = new FileReader(level_number);
        Scanner in = new Scanner(fileReader);
        bg_path = in.next();

        n = in.nextInt();
        am = in.nextInt();
        k1 = in.nextInt();
        k2 = in.nextInt();
        k3 = in.nextInt();
        k4 = in.nextInt();
        k5 = in.nextInt();
        song = in.next();
    }
    public void end(int k){
        if (k > n)
           finish = true;
        else finish = false;
       //     System.out.println(k + " " + n + " " + finish);

    }
    public void menu_level(){
        m = new JFrame("Меню");
        m.setSize(500,500);
//        m.setLocation(Menu.width/2, Menu.height/2);
        p = new JPanel();
        l = new JButton[5];
        for (JButton a:l) {
            a = new JButton();
            ch++;
            a.setText(String.valueOf(ch));
            a.setSize(50, 50);
            a.setFocusPainted(false);
            a.setFocusable(false);
            p.add(a);
            if (a.getText().equals("1")) {
                a.addActionListener(actionEvent -> {
                    try {
                        Level(1);
                        new Window().go(num);
                        m.show(false);
                        menu.menu.show(false);

                    } catch (IOException | JavaLayerException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
        m.add(p);
        m.show();
    }

}
