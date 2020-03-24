import java.awt.*;

public class Level {
    public Level() {
    }
    public void end(int n, int k, boolean finish){
        if (k > n)
           finish = true;
            System.out.println(k + " " + n + " " + finish);

    }
}
