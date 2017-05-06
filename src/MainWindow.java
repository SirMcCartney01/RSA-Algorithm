import javax.swing.*;
import java.awt.*;

/**
 * Created by cesar on 24/04/17.
 */
public class MainWindow extends JFrame {


    public MainWindow() {
        super("Proyecto Final");
        initComponents(this);
    }

    private void initComponents(JFrame frame) {
        //frame.setSize(800, 600);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());



        DrawPanel drawPanel = new DrawPanel();
        container.add(drawPanel, BorderLayout.CENTER);

    }
}
