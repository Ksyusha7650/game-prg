import java.awt.*;

public class Level {
    boolean finish;
    public Level() {
    }
    public void end(int n, int k){
        if (k > n)
           finish = true;
        else finish = false;
       //     System.out.println(k + " " + n + " " + finish);

    }
}
