
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class GamePanel extends JPanel {
    Slothe slothe;
    Image bg;

    public GamePanel(Slothe slothe) throws IOException {
        this.slothe=slothe;
      //  bg = ImageIO.read( new File( "C:\\Users\\Ксюша\\IdeaProjects\\slothe\\src\\raw\\bg.png" ) );
    }

 @Override
    public void paintComponent(Graphics g) {
     g.setColor(Color.WHITE);
     g.fillRect(0,0,slothe.width,slothe.height);
        slothe.draw(g);
        slothe.physics();
      g.fillRect(0,slothe.height/2 +200, slothe.width,slothe.height);
    }

}