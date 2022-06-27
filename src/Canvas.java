import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Canvas extends JPanel {
    private Model model;
    private Image gamerImage;
    private Image gamerImageRight;
    private Image gamerImageUp;
    private Image gamerImageLeft;
    private Image wallImage;
    private Image boxImage;
    private Image goalImage;

    public Canvas(Model model) {
        this.model = model;
        setBackground(Color.BLACK);
        setOpaque(true);
        File fileGamer = new File("images/gamer.png");
        File fileGamerLeft = new File("images/gamerLeft.png");
        File fileGamerRight = new File("images/gamerRight.png");
        File fileGamerUp = new File("images/gamerUp.png");
        File fileWall = new File("images/wall.png");
        File fileBox = new File("images/box.png");
        File fileGoal = new File("images/goal.png");
        try {
            gamerImage = ImageIO.read(fileGamer);
            gamerImageLeft = ImageIO.read(fileGamerLeft);
            gamerImageRight = ImageIO.read(fileGamerRight);
            gamerImageUp = ImageIO.read(fileGamerUp);
            wallImage = ImageIO.read(fileWall);
            boxImage = ImageIO.read(fileBox);
            goalImage = ImageIO.read(fileGoal);
        } catch (IOException ioe) {
            System.out.println(ioe);
            System.exit(-1);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (model.getStateGame()) {
            drawDesktop(g);
        } else {
            drawErrorMessage(g);
        }
    }

    private void drawErrorMessage(Graphics g) {
        g.setFont(new Font("SHOWCARD GOTHIC", Font.PLAIN, 50));
        g.setColor(Color.ORANGE);
        g.drawString("Initialization Error!", 100, 100);
    }

    private void drawDesktop(Graphics g) {
        int x = 50;
        int y = 50;
        int width = 50;
        int height = 50;
        int[][] desktop = model.getDesctop();
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
                if (desktop[i][j] == 1) {
                    drawGamer(g, x, y);
                } else if (desktop[i][j] == 2) {
                    g.drawImage(wallImage, x, y, null);
                } else if (desktop[i][j] == 3) {
                    g.drawImage(boxImage, x, y, null);
                } else if (desktop[i][j] == 4) {
                    g.drawImage(goalImage, x, y, null);
                } else {
                }
                x = x + width;
            }
            x = 50;
            y = y + height;
        }
    }

    private void drawGamer(Graphics g, int x, int y) {
        switch (model.getDirection()) {
            case "Up":
                g.drawImage(gamerImageUp, x, y, null);
                break;
            case "Down":
                g.drawImage(gamerImage, x, y, null);
                break;
            case "Left":
                g.drawImage(gamerImageLeft, x, y, null);
                break;
            case "Right":
                g.drawImage(gamerImageRight, x, y, null);
                break;
        }
    }
}

