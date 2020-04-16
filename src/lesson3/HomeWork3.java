package lesson3;

import java.util.Random;
import java.util.Scanner;

public class HomeWork3 {

    private static int fieldSizeY;
    private static int fieldSizeX;
    private static int winSequence;
    private static char[][] field;

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    private static final char HUMAN_DOT = 'X';
    private static final char AI_DOT = 'O';
    private static final char EMPTY_DOT = '.';

    // init field
    private static void initMap() {
        fieldSizeY = 10;
        fieldSizeX = 15;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = EMPTY_DOT;
            }
        }
    }

    // print field
    private static void printMap() {
        System.out.println("-----------");
        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print("|");
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }
    }

    // human turn
    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.printf("Введите координаты хода X и Y (от 1 до %d) через пробел: ", fieldSizeX);
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!(isValidCell(y, x) && isEmptyCell(y, x)));
        field[y][x] = HUMAN_DOT;
    }

    // is cell empty
    private static boolean isEmptyCell(int y, int x) {
        return field[y][x] == EMPTY_DOT;
    }

    // is cell valid
    private static boolean isValidCell(int y, int x) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    // ai turn
    private static void aiTurn() {

        int y;
        int x;

        mainLoop:
        do{
            // Checking for win for AI
            for(int i = 0; i < fieldSizeY; i++) {
                for(int j = 0; j < fieldSizeX; j++) {
                    if(isEmptyCell(i, j)) {
                        field[i][j] = AI_DOT;
                        if (checkLines(AI_DOT)) {
                            y = i;
                            x = j;
                            break mainLoop;
                        }
                        else field[i][j] = EMPTY_DOT;
                    }
                }
            }

            // Checking for loss for AI
            for(int i = 0; i < fieldSizeY; i++) {
                for(int j = 0; j < fieldSizeX; j++) {
                    if(isEmptyCell(i, j)) {
                        field[i][j] = HUMAN_DOT;
                        if(checkLines(HUMAN_DOT)) {
                            y = i;
                            x = j;
                            break mainLoop;
                        } else field[i][j] = EMPTY_DOT;
                    }
                }
            }


            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(y, x));
        field[y][x] = AI_DOT;

    }

    // check win
    private static boolean checkWin(char c) {
        if(checkLines(c)) return true;
        return false;
    }

    private static boolean checkLines(char c) {
        winSequence = 5;

        // Check for win by rows
        for(int i = 0; i < fieldSizeY; i++) {
            for(int j = 0; j <= fieldSizeX - winSequence; j++) {
                boolean winByRows = field[i][j] == c;
                for (int k = 1; k < winSequence && winByRows; k++) {
                    winByRows = field[i][j + k] == c;
                }
                if(winByRows) return true;
            }
        }

        // Check for win by columns
        for(int i = 0; i < fieldSizeX; i++) {
            for(int j = 0; j <= fieldSizeY - winSequence; j++) {
                boolean winByColumns = field[j][i] == c;
                for(int k = 1; k < winSequence && winByColumns; k++) {
                    winByColumns = field[j + k][i] == c;
                }
                if(winByColumns) return true;
            }
        }

        // Check for win by main diagonal
        for(int i = 0; i <= fieldSizeY - winSequence; i++) {
            for(int j = 0; j <= fieldSizeX - winSequence; j++) {
                boolean winByMainDiagonal = field[i][j] == c;
                for(int k = 1; k < winSequence && winByMainDiagonal; k++) {
                    winByMainDiagonal = field[i + k][j + k] == c;
                }
                if(winByMainDiagonal) return true;
            }
        }

        // Check for win by side diagonal
        for(int i = 0; i <= fieldSizeY - winSequence; i++) {
            for(int j = winSequence - 1; j < fieldSizeX; j++) {
                boolean winBySideDiagonal = field[i][j] == c;
                for(int k = 1; k < winSequence && winBySideDiagonal; k++) {
                    winBySideDiagonal = field[i + k][j - k] == c;
                }
                if(winBySideDiagonal) return true;
            }
        }

        return false;
    }

    // check draw
    private static boolean isMapFull() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isEmptyCell(y, x)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        while (true) {
            initMap();
            printMap();
            while (true) {
                humanTurn();
                printMap();
                if (gameChecks(HUMAN_DOT, "Human win!")) break;
                aiTurn();
                printMap();
                if (gameChecks(AI_DOT, "AI win!")) break;
            }
            System.out.println("Play again?");
            if (!SCANNER.next().equals("y"))
                break;
        }
        SCANNER.close();

    }

    private static boolean gameChecks(char aiDot, String s) {
        if (checkWin(aiDot)) {
            System.out.println(s);
            return true;
        }
        if (isMapFull()) {
            System.out.println("draw!");
            return true;
        }
        return false;
    }
}
