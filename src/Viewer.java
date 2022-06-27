import javax.swing.JFrame;
public class Viewer {
    private Canvas canvas;
    private JFrame frame;
    public Viewer() {
        Controller controller = new Controller(this);
        Model model = controller.getModel();
        canvas = new Canvas(model);
        JFrame frame = new JFrame("Sokoban Game");
        frame.setSize(1150, 900);
        frame.add(canvas);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addKeyListener(controller);
    }
    public void update() {

        canvas.repaint();

    }
    public void showWonDialog(){
        javax.swing.JOptionPane.showMessageDialog(frame,"YOU ARE WON");
    }
    public void showErrorDialog(){
        javax.swing.JOptionPane.showMessageDialog(frame,"YOU ARE GAY");
    }
}
