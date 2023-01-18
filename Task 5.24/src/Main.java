import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int w = readInt("Введите w: ");
        int h = readInt("Введите h: ");

        if (h < 4 && h % 2 != 0 || w < 3) {
            System.out.println("Введите верные значения");
            System.exit(0);
        }

        printFigure(h, w);
    }

    //Печать фигуры
    public static void printFigure(int h, int w) {
        boolean isFirstSpace = false;
        for (int i = 1; i <= h; i++) {
            if (i == 1 || i == h) {
                printStraightLines(w);

            } else if (i <= h / 2) { //Вертикальные + Левые слеши
                printSlantedLines(w, isFirstSpace, true);
                isFirstSpace = !isFirstSpace;

            } else { //Правые слеши + Вертикальные
                isFirstSpace = !isFirstSpace;
                printSlantedLines(w, isFirstSpace, false);
            }
        }
    }

    public static int readInt(String text) {
        Scanner scan = new Scanner(System.in);
        System.out.print(text);
        return scan.nextInt();
    }

    //Прямые линии + звёзды
    public static void printStraightLines(int w) {
        StringBuilder line = new StringBuilder("*");

        int repeats;
        if (w % 2 == 0) {
            repeats = w - 1;
        } else {
            repeats = w -2;
        }

        line.append("-".repeat(Math.max(0, repeats)));

        System.out.println(line.append("*"));
    }

    //Слеши + вертикальные
    public static void printSlantedLines(int w, boolean isFirstSpace, boolean isTiltedLeft) {
        StringBuilder line = new StringBuilder();

        String slantedLines;
        if (isTiltedLeft) {
            slantedLines = "\\ ";
        } else {
            slantedLines = "/ ";
        }

        if (isFirstSpace) { //Пробел или не пробел
            line.append("| ");
            line.append(slantedLines.repeat(w / 2 - 1));
            line.append("|");

        } else {
            line.append("|");
            line.append(slantedLines.repeat(w / 2 - 1));
            line.append(slantedLines.charAt(0)).append("|");
        }

        System.out.println(line);
    }
}