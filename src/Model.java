public class Model {
    private Viewer viewer;
    private int[][] desctop;
    private int[][] indexesGoal;
    private int indexX;
    private int indexY;
    private String direction;
    private Levels levels;
    private boolean isOk;
    private Sound playSoundBox;
    private Sound playSoundWon;
    private Sound playSoundError;
    public Model(Viewer viewer) {
        this.viewer = viewer;
        levels = new Levels();
        direction = "Down";
        playSoundBox = new Sound("sound/point.wav");
        playSoundWon = new Sound("sound/won.wav");
        playSoundError = new Sound("sound/Error.wav");
        initialization();
    }
    public void nextLevels(){
        initialization();
        viewer.update();
    }
    public void prevLevels(){
        levels.setLevel(levels.getLevel() - 2);
        initialization();
        viewer.update();
    }

    public boolean getStateGame() {
        return isOk;
    }
    public void initialization() {
        isOk = true;
        desctop = levels.nextLevel();
        int countGamer = 0;
        int countBox = 0;
        int countGoal = 0;
        for(int a = 0; a < desctop.length; a++) {
            for(int b = 0; b < desctop[a].length; b++) {
                int element = desctop[a][b];
                if(element == 1) {
                    countGamer = countGamer + 1;
                    indexX = a;
                    indexY = b;
                } else if(element == 3) {
                    countBox = countBox + 1;
                } else if(element == 4) {
                    countGoal = countGoal + 1;
                }
            }
        }
        if(countGamer != 1 || (countBox == 0) || (countGoal == 0) || (countBox != countGoal)) {
            isOk = false;
        }

        indexesGoal = new int[2][countGoal];
        int count = 0;
        for(int a = 0; a < desctop.length; a++) {
            for (int b = 0; b < desctop[a].length; b++) {
                if (desctop[a][b] == 4) {
                    indexesGoal[0][count] = a;
                    indexesGoal[1][count] = b;
                    count++;
                }
            }
        }
    }

    public void move(String direction) {
        this.direction = "Down";
        if(direction.equals("Up")) {
            moveUp();
            this.direction = "Up";
        } else if(direction.equals("Right")) {
            moveRight();
            this.direction = "Right";
        } else if(direction.equals("Down")) {
            moveDown();
            this.direction = "Down";
        } else if(direction.equals("Left")) {
            moveLeft();
            this.direction = "Left";
        } else {
            return;
        }
        checkGoal();
        viewer.update();
        won();
    }

    private void playSound() {
        playSoundBox.play(true);
    }

    private void checkGoal() {
        for(int y = 0; y < indexesGoal[0].length; y++) {
            int q = indexesGoal[0][y];
            int w = indexesGoal[1][y];
            if(desctop[q][w] == 0){
                desctop[q][w] = 4;
                break;
            }
        }
    }

    private void won() {
        boolean won = true;
        for(int j = 0; j < indexesGoal[0].length; j++) {
            int q = indexesGoal[0][j];
            int w = indexesGoal[1][j];
            if(desctop[q][w] != 3){
                won = false;
                break;
            }
        }
        if(won){
            playSoundBox.stop();
            playSoundWon.play();
            viewer.showWonDialog();
            initialization();
            viewer.update();
        }

    }



    private void moveRight() {
        if(desctop[indexX][indexY + 1] == 3) {
            if(desctop[indexX][indexY + 2] == 0 || desctop[indexX][indexY + 2] == 4) {
                if(desctop[indexX][indexY + 2] == 4) {
                    playSound();
                }
                desctop[indexX][indexY + 1] = 0;
                desctop[indexX][indexY + 2] = 3;
            }
        }
        if(desctop[indexX][indexY + 1] == 0 || desctop[indexX][indexY + 1] == 4) {
            desctop[indexX][indexY] = 0;
            indexY = indexY + 1;
            desctop[indexX][indexY] = 1;
        }
    }
    private void moveLeft() {
        if(desctop[indexX][indexY - 1] == 3) {
            if(desctop[indexX][indexY - 2] == 0 || desctop[indexX][indexY - 2] == 4) {
                if(desctop[indexX][indexY - 2] == 4) {
                    playSound();
                }
                desctop[indexX][indexY - 1] = 0;
                desctop[indexX][indexY - 2] = 3;
            }
        }
        if(desctop[indexX][indexY - 1] == 0 || desctop[indexX][indexY - 1] == 4) {
            desctop[indexX][indexY] = 0;
            indexY = indexY - 1;
            desctop[indexX][indexY] = 1;
        }
    }
    private void moveUp() {
        if(desctop[indexX - 1][indexY] == 3) {
            if(desctop[indexX - 2][indexY] == 0 || desctop[indexX - 2][indexY] == 4) {
                if(desctop[indexX -2][indexY] == 4) {
                    playSound();
                }
                desctop[indexX - 1][indexY] = 0;
                desctop[indexX - 2][indexY] = 3;
            }
        }
        if(desctop[indexX - 1][indexY] == 0 || desctop[indexX - 1][indexY] == 4) {
            desctop[indexX][indexY] = 0;
            indexX = indexX - 1;
            desctop[indexX][indexY] = 1;
        }
    }
    private void moveDown() {
        if(desctop[indexX + 1][indexY] == 3) {
            if(desctop[indexX + 2][indexY] == 0 || desctop[indexX + 2][indexY] == 4) {
                if(desctop[indexX + 2][indexY] == 4) {
                    playSound();
                }
                desctop[indexX + 1][indexY] = 0;
                desctop[indexX + 2][indexY] = 3;
            }
        }
        if(desctop[indexX + 1][indexY] == 0 || desctop[indexX + 1][indexY] == 4) {
            desctop[indexX][indexY] = 0;
            indexX = indexX + 1;
            desctop[indexX][indexY] = 1;
        }
    }
    public int[][] getDesctop() {
        return desctop;
    }

    public String getDirection() {
        return direction;
    }

    public boolean checkError(){
        if(levels.getLevel() - 1 == 1){
            return false;
        }else{
            return true;
        }
    }
    public void error(){
        playSoundError.play();
        viewer.showErrorDialog();
    }
}
