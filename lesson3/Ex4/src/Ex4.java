import java.util.Random;
import java.util.Scanner;

public class Ex4 {

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
        fieldSizeY = 3;
        fieldSizeX = 3;
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

        int x, y;

        mainLoop:
        do {

            // CHECK FOR WIN
            // Check for win by rows
            for (int i = 0; i < fieldSizeY; i++) {
                boolean winByRows = field[i][0] == EMPTY_DOT;
                for (int j = 1; j < fieldSizeX && winByRows; j++) {
                    winByRows = field[i][j] == AI_DOT;
                }
                if (winByRows) {
                    y = i;
                    x = 0;
                    break mainLoop;
                }
                winByRows = field[i][1] == EMPTY_DOT;
                for (int j = 0; j < fieldSizeX && winByRows; j += 2) {
                    winByRows = field[i][j] == AI_DOT;
                }
                if (winByRows) {
                    y = i;
                    x = 1;
                    break mainLoop;
                }
                winByRows = field[i][2] == EMPTY_DOT;
                for (int j = 0; j < fieldSizeX - 1 && winByRows; j++) {
                    winByRows = field[i][j] == AI_DOT;
                }
                if (winByRows) {
                    y = i;
                    x = 2;
                    break mainLoop;
                }
            }

            //Check for win by columns
            for (int i = 0; i < fieldSizeY; i++) {
                boolean winByColumns = field[0][i] == EMPTY_DOT;
                for (int j = 1; j < fieldSizeX && winByColumns; j++) {
                    winByColumns = field[j][i] == AI_DOT;
                }
                if (winByColumns) {
                    y = 0;
                    x = i;
                    break mainLoop;
                }
                winByColumns = field[1][i] == EMPTY_DOT;
                for (int j = 0; j < fieldSizeX && winByColumns; j += 2) {
                    winByColumns = field[j][i] == AI_DOT;
                }
                if (winByColumns) {
                    y = 1;
                    x = i;
                    break mainLoop;
                }
                winByColumns = field[2][i] == EMPTY_DOT;
                for (int j = 0; j < fieldSizeX - 1 && winByColumns; j++) {
                    winByColumns = field[j][i] == AI_DOT;
                }
                if (winByColumns) {
                    y = 2;
                    x = i;
                    break mainLoop;
                }
            }

            //Check for win by main diagonal
            boolean winByMainDiagonal = field[0][0] == EMPTY_DOT;
            for (int i = 1; i < fieldSizeY && winByMainDiagonal; i++) {
                winByMainDiagonal = field[i][i] == AI_DOT;
            }
            if (winByMainDiagonal) {
                x = 0;
                y = 0;
                break mainLoop;
            }
            winByMainDiagonal = field[1][1] == EMPTY_DOT;
            for (int i = 0; i < fieldSizeY && winByMainDiagonal; i += 2) {
                winByMainDiagonal = field[i][i] == AI_DOT;
            }
            if (winByMainDiagonal) {
                x = 1;
                y = 1;
                break mainLoop;
            }
            winByMainDiagonal = field[2][2] == EMPTY_DOT;
            for (int i = 0; i < fieldSizeY - 1 && winByMainDiagonal; i++) {
                winByMainDiagonal = field[i][i] == AI_DOT;
            }
            if (winByMainDiagonal) {
                x = 2;
                y = 2;
                break mainLoop;
            }

            //Check for win by side diagonal
            boolean winBySideDiagonal = field[0][2] == EMPTY_DOT;
            for (int i = 1; i < fieldSizeX && winBySideDiagonal; i++) {
                winBySideDiagonal = field[i][fieldSizeX - 1 - i] == AI_DOT;
            }
            if (winBySideDiagonal) {
                x = 2;
                y = 0;
                break mainLoop;
            }
            winBySideDiagonal = field[1][1] == EMPTY_DOT;
            for (int i = 0; i < fieldSizeX && winBySideDiagonal; i += 2) {
                winBySideDiagonal = field[i][fieldSizeX - 1 - i] == AI_DOT;
            }
            if (winBySideDiagonal) {
                x = 1;
                y = 1;
                break mainLoop;
            }
            winBySideDiagonal = field[2][0] == EMPTY_DOT;
            for (int i = 0; i < fieldSizeX - 1 && winBySideDiagonal; i++) {
                winBySideDiagonal = field[i][fieldSizeX - 1 - i] == AI_DOT;
            }
            if (winBySideDiagonal) {
                x = 0;
                y = 2;
                break mainLoop;
            }

            // CHECK FOR LOSS
            // Check for loss by rows
            for (int i = 0; i < fieldSizeY; i++) {
                boolean lossByRows = field[i][0] == EMPTY_DOT;
                for (int j = 1; j < fieldSizeX && lossByRows; j++) {
                    lossByRows = field[i][j] == HUMAN_DOT;
                }
                if (lossByRows) {
                    y = i;
                    x = 0;
                    break mainLoop;
                }
                lossByRows = field[i][1] == EMPTY_DOT;
                for (int j = 0; j < fieldSizeX && lossByRows; j += 2) {
                    lossByRows = field[i][j] == HUMAN_DOT;
                }
                if (lossByRows) {
                    y = i;
                    x = 1;
                    break mainLoop;
                }
                lossByRows = field[i][2] == EMPTY_DOT;
                for (int j = 0; j < fieldSizeX - 1 && lossByRows; j++) {
                    lossByRows = field[i][j] == HUMAN_DOT;
                }
                if (lossByRows) {
                    y = i;
                    x = 2;
                    break mainLoop;
                }
            }

            //Check for loss by columns
            for (int i = 0; i < fieldSizeY; i++) {
                boolean lossByColumns = field[0][i] == EMPTY_DOT;
                for (int j = 1; j < fieldSizeX && lossByColumns; j++) {
                    lossByColumns = field[j][i] == HUMAN_DOT;
                }
                if (lossByColumns) {
                    y = 0;
                    x = i;
                    break mainLoop;
                }
                lossByColumns = field[1][i] == EMPTY_DOT;
                for (int j = 0; j < fieldSizeX && lossByColumns; j += 2) {
                    lossByColumns = field[j][i] == HUMAN_DOT;
                }
                if (lossByColumns) {
                    y = 1;
                    x = i;
                    break mainLoop;
                }
                lossByColumns = field[2][i] == EMPTY_DOT;
                for (int j = 0; j < fieldSizeX - 1 && lossByColumns; j++) {
                    lossByColumns = field[j][i] == HUMAN_DOT;
                }
                if (lossByColumns) {
                    y = 2;
                    x = i;
                    break mainLoop;
                }
            }

            //Check for loss by main diagonal
            boolean losByMainDiagonal = field[0][0] == EMPTY_DOT;
            for (int i = 1; i < fieldSizeY && losByMainDiagonal; i++) {
                losByMainDiagonal = field[i][i] == HUMAN_DOT;
            }
            if (losByMainDiagonal) {
                y = 0;
                x = 0;
                break mainLoop;
            }
            losByMainDiagonal = field[1][1] == EMPTY_DOT;
            for (int i = 0; i < fieldSizeY && losByMainDiagonal; i += 2) {
                losByMainDiagonal = field[i][i] == HUMAN_DOT;
            }
            if (losByMainDiagonal) {
                y = 1;
                x = 1;
                break mainLoop;
            }
            losByMainDiagonal = field[2][2] == EMPTY_DOT;
            for (int i = 0; i < fieldSizeY - 1 && losByMainDiagonal; i++) {
                losByMainDiagonal = field[i][i] == HUMAN_DOT;
            }
            if (losByMainDiagonal) {
                y = 2;
                x = 2;
                break mainLoop;
            }

            //Check for loss by side diagonal
            boolean lossBySideDiagonal = field[0][2] == EMPTY_DOT;
            for (int i = 1; i < fieldSizeX && lossBySideDiagonal; i++) {
                lossBySideDiagonal = field[i][fieldSizeX - 1 - i] == HUMAN_DOT;
            }
            if (lossBySideDiagonal) {
                y = 0;
                x = 2;
                break mainLoop;
            }
            lossBySideDiagonal = field[1][1] == EMPTY_DOT;
            for (int i = 0; i < fieldSizeX && lossBySideDiagonal; i += 2) {
                lossBySideDiagonal = field[i][fieldSizeX - 1 - i] == HUMAN_DOT;
            }
            if (lossBySideDiagonal) {
                y = 1;
                x = 1;
                break mainLoop;
            }
            lossBySideDiagonal = field[2][0] == EMPTY_DOT;
            for (int i = 0; i < fieldSizeX - 1 && lossBySideDiagonal; i++) {
                lossBySideDiagonal = field[i][fieldSizeX - 1 - i] == HUMAN_DOT;
            }
            if (lossBySideDiagonal) {
                y = 2;
                x = 0;
                break mainLoop;
            }

            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        }while (!(isValidCell(y, x) && isEmptyCell(y, x)));
        field[y][x] = AI_DOT;

    }

    // check win
    private static boolean checkWin(char c) {
        //   winSequence = 3;

        for(int i = 0; i < fieldSizeY; i++) {
            boolean res = field[i][0] == c;
            for(int j = 1; j < fieldSizeX && res; j++) {
                res = field[i][j] == c;
            }
            if(res) return true;
        }

        for(int i = 0; i < fieldSizeY; i++) {
            boolean res = field[0][i] == c;
            for(int j = 1; j < fieldSizeX && res; j++) {
                res = field[j][i] == c;
            }
            if(res) return true;
        }

        boolean res = field[0][0] == c;
        for(int i = 1; i < 3 && res; i++) {
            res = field[i][i] == c;
        }
        if(res) return true;

        boolean res1 = field[0][2] == c;
        for(int i = 1; i < 3 && res1; i++) {
            res1 = field[i][fieldSizeX - 1 - i] == c;
        }
        if(res1) return true;

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
