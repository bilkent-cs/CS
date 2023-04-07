import GUI.Panel.CalculatorPanel;
import javax.swing.JFrame;

/**
 * @(#)Calculator.java
 * Class that holds the frame and entry point for the application
 *
 * @author Berke Gokmen
 * @date 2021/11/13
 */
public class Calculator {

  public static void main(String[] args) throws Exception {
    final JFrame frame = new JFrame();
    final CalculatorPanel calculatorPanel = new CalculatorPanel();

    // Frame setup
    frame.getContentPane().add(calculatorPanel);
    frame.setMinimumSize(CalculatorPanel.DIMENSION);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationByPlatform(true);
    frame.setVisible(true);
  }
}
