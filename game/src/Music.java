import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Music {
    FileInputStream fis, fis2;
    Player player, player2;
    int ch;
    Settings s = new Settings();

    public Music(String song) throws FileNotFoundException, javazoom.jl.decoder.JavaLayerException {
        fis = new FileInputStream(song);
        player = new Player(fis);
    }

    public void play() throws javazoom.jl.decoder.JavaLayerException, FileNotFoundException {
        player.play();
        ch++;
    }
    public void stop() throws  InterruptedException {
        player.close();
    }
    public void contt() throws IOException, InterruptedException, JavaLayerException {
          player.play();

    }

}
