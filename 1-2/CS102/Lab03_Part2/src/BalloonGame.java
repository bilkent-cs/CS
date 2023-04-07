import gui.BalloonsGamePanel;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @(#)BalloonGame.java
 * Class that holds frame and game {@link BalloonsGamePanel}
 *
 * @author Berke Gokmen
 * @date 2021/10/28
 */
public class BalloonGame {

  public static void main(String[] args) throws Exception {
    JOptionPane.showMessageDialog(
      null,
      ("Welcome to the Balloon Game" + "\n") +
      ("How to play:" + "\n") +
      ("\tClick on circles" + "\n") +
      (
        (
          "\tYou will get a point whenever you burst" +
          " 2 or more balloons with a single click."
        ) +
        "\n"
      ) +
      ("\tYou will have 1 minute to burst as much balloons as you can") +
      ("\n\nPress 'OK' to start"),
      "Balloon Game - berkegokmen1",
      JOptionPane.INFORMATION_MESSAGE
    );

    final JFrame frame = new JFrame();
    final JPanel panel = new BalloonsGamePanel();

    panel.setBackground(Color.GRAY);
    frame.add(panel);

    // Frame setup
    frame.setUndecorated(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Balloon Game - Berke");
    frame.setSize(BalloonsGamePanel.SCREEN_SIZE);
    frame.setResizable(false);
    frame.setVisible(true);
  }
}
