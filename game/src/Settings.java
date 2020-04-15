import javazoom.jl.decoder.JavaLayerException;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Settings {
    JFrame set;
    JPanel spanel;
    JButton m;
    int c;
    public void Settings() {
        set = new JFrame("Settings");
        set.setSize(600,200);
        spanel = new JPanel();
        set.add(spanel);
        set.show();
        onClick(spanel);
        set.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
        public void onClick(JPanel spanel){
            m = new JButton();
            m.setSize(200,100);
            m.setText("Без музыки");
            m.setLocation(300,600);
            m.setFocusPainted(false);
            m.setContentAreaFilled(false);
            m.setBorderPainted(true);
            m.setFocusable(false);
            spanel.add(m);
            m.addActionListener(actionEvent -> {
            if (m.getText().equals("Без музыки")) {
                try {
                    m.setText("С музыкой");
                    stop();
                    Thread.sleep(20);
                } catch (JavaLayerException | InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
            else  {
                try {
                        m.setText("Без музыки");
                        cont();
                        Thread.sleep(20);
                        c++;

                } catch (JavaLayerException | InterruptedException | IOException e) {
                    e.printStackTrace();
                }
                    }
            });
        while (m.getText().equals("С музыкой")) c++;
    }

    public void stop() throws IOException, JavaLayerException, InterruptedException {
        Window.music.stop();
    }
    public void cont() throws IOException, JavaLayerException, InterruptedException {
        Window.music.contt();

    }
}
