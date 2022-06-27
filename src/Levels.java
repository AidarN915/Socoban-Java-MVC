import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Levels {
    private int level;
    private Model model;

    public Levels() {
        level = 1;
    }
    public int[][] nextLevel() {

        int[][] desktop = null;

        switch(level) {
            case 1:
                desktop = getFirstLevel();
            break;
            case 2:
                desktop = getSecondLevel();
            break;
            case 3:
                desktop = getThirdLevel();
            break;
            case 4:
                desktop = getLevelFromFile("levels/levels4.sok");
                break;
            case 5:
                desktop = getLevelFromFile("levels/levels5.sok");
                break;
            default:
                level = 1;
                desktop = getFirstLevel();
        }

        level = level + 1;
        return desktop;

    }

    private int[][] getFirstLevel() {
        int[][] array = new int[][] {
                {0, 0, 0, 0, 2, 2, 2, 2, 2, 0},
                {0, 0, 0, 0, 2, 0, 0, 0, 2, 0},
                {0, 0, 0, 0, 2, 3, 0, 0, 2, 0},
                {0, 0, 2, 2, 2, 0, 0, 3, 2, 2},
                {0, 0, 2, 0, 0, 3, 0, 3, 0, 2},
                {2, 2, 2, 0, 2, 0, 2, 2, 1, 2, 0, 0, 0, 2, 2, 2, 2, 2, 2},
                {2, 0, 0, 0, 2, 0, 2, 2, 0, 2, 2, 2, 2, 2, 0, 0, 4, 4, 2},
                {2, 0, 3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 2},
                {2, 2, 2, 2, 2, 0, 2, 2, 2, 0, 2, 0, 2, 2, 0, 0, 4, 4, 2},
                {0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2}
        };
        return array;
    }

    private int[][] getSecondLevel() {
        int[][] array = new int[][] {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 2, 2, 2, 2, 0, 2, 0, 0, 2, 0, 0, 0, 0},
            {0, 0, 0, 2, 2, 2, 0, 1, 2, 2, 2, 3, 0, 2, 0, 0, 0, 0},
            {0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 3, 0, 0, 2, 0, 0, 0, 0},
            {0, 2, 2, 0, 0, 3, 0, 3, 3, 2, 2, 0, 2, 2, 0, 0, 0, 0},
            {0, 2, 0, 0, 2, 3, 2, 2, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0},
            {0, 2, 0, 2, 0, 3, 0, 3, 3, 0, 2, 0, 2, 2, 2, 0, 0, 0},
            {0, 2, 0, 0, 0, 3, 0, 2, 0, 0, 2, 0, 3, 0, 2, 2, 2, 2, 2},
            {0, 2, 2, 2, 0, 0, 0, 0, 2, 0, 0, 3, 3, 0, 2, 0, 0, 0, 2},
            {2, 2, 2, 2, 0, 2, 2, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 4, 0, 0, 0, 0, 2, 2, 2, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 4, 4, 0, 4, 4, 2, 0, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0},
            {2, 4, 4, 4, 2, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 4, 4, 4, 4, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        return array;
    }

    private int[][] getThirdLevel() {
        int[][] array = new int[][] {
            {0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 0},
            {0, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 2, 2},
            {2, 2, 0, 2, 0, 1, 2, 2, 0, 3, 3, 0, 2},
            {2, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 3, 0, 0, 2, 2, 2, 0, 0, 0, 2},
            {2, 2, 2, 0, 2, 2, 2, 2, 2, 3, 2, 2, 2},
            {2, 0, 3, 0, 0, 2, 2, 2, 0, 4, 4, 2, 2},
            {2, 0, 3, 0, 3, 0, 3, 0, 4, 4, 4, 2, 0},
            {2, 0, 0, 0, 0, 2, 2, 2, 4, 4, 4, 2, 0},
            {2, 0, 3, 3, 0, 2, 0, 2, 4, 4, 4, 2, 0},
            {2, 0, 0, 2, 2, 2, 0, 2, 2, 2, 2, 2, 0},
            {2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        return array;
    }
    private int[][] getLevelFromFile(String fileName) {
        String contentFile = readLevelFromFile(fileName);
        int[][] desktop = parseContent(contentFile);
        return desktop;
    }

    private int[][] parseContent(String contentFile) {
        int row = 0;
        for(int a = 0; a < contentFile.length(); a++) {
            char symbol = contentFile.charAt(a);
            if(symbol == '\n') {
                row = row + 1;
            }
        }
        int[][] array = new int[row][];
        int column = 0;
        int step = 0;
        for(int a = 0; a < contentFile.length(); a++) {
            char symbol = contentFile.charAt(a);
            if(symbol == '\n') {
                array[step] = new int[column];
                column = 0;
                step = step + 1;
            } else {
                column = column + 1;
            }
        }

        int x = 0;
        int y = 0;
        for(int a = 0; a < contentFile.length(); a++) {
            char symbol = contentFile.charAt(a);
            if(symbol == '\n') {
                x = x + 1;
                y = 0;
            } else {
                array[x][y] = Integer.parseInt("" + symbol);
                y = y + 1;
            }
        }
        return array;
    }


    private String readLevelFromFile(String fileName) {
        try {
            File file = new File(fileName);
            FileInputStream in = new FileInputStream(file);
            int size = (int)file.length();
            char[] array = new char[size + 1];
            int index = 0;
            int unicode;
            while((unicode = in.read()) != -1) {
                char symbol = (char) unicode;
                if(('0' <= symbol && symbol <= '4') || symbol == '\n') {
                        array[index] = symbol;
                        index = index + 1;
                }
            }
            if(array[array.length - 2] != '\n'){
                array[array.length - 2] = '\n';
            }
            String textFromFile = new String(array, 0, index);
            array = null;
            in.close();
            return textFromFile;
        } catch(IOException fne) {
            System.out.println(fne);
            return null;
        }
    }
    public int getLevel(){
        return level;
    }
    public void setLevel(int b){
        this.level = b;
    }
}