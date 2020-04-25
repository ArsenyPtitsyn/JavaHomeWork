package lesson7;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    public static final int MODE_HVH = 0;
    public static final int MODE_HVA = 1;

    Map() {
        setBackground(Color.CYAN);
    }

    void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        System.out.printf("mode: %d, size: %d, len: %d\n", gameMode, fieldSizeX, winLength);
    }
}
