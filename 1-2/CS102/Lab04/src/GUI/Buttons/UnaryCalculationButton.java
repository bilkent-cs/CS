package GUI.Buttons;

import GUI.Panel.Interfaces.CountInformer;
import Operations.Operation;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @(#)UnaryCalculationButton.java
 * Class that represents specifically unary calculation button
 * And provides its functionality
 *
 * @author Berke Gokmen
 * @date 2021/11/13
 */
public class UnaryCalculationButton extends CalculationButton {

  /**
   * Initializes a {@link UnaryCalculationButton} object
   *
   * @param operation {@link Operation} object for button
   * @param number1Field {@link JTextField} object that holds number 1
   * @param number2Field {@link JTextField} object that holds number 2
   * @param resultLabel {@link JLabel} object that shows result
   * @param informer {@link CountInformer} object that will be informed when the button is clicked
   */
  public UnaryCalculationButton(
    Operation operation,
    JTextField number1Field,
    JTextField number2Field,
    JLabel resultLabel,
    CountInformer informer
  ) {
    super(operation, number1Field, number2Field, resultLabel, informer);
    this.setBackground(new Color(255, 130, 130));
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String num1Text = number1Field.getText();

    this.number2Field.setText("");
    this.number2Field.setBorder(BorderFactory.createEmptyBorder());
    this.resultLabel.setText("?");

    // Following code is taken from StackOverflow by CraigTP
    // https://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
    if (!num1Text.matches("-?\\d+(\\.\\d+)?")) {
      this.number1Field.setBorder(BorderFactory.createLineBorder(Color.RED, 1));

      JOptionPane.showMessageDialog(
        this,
        "Please enter a valid number",
        "Error",
        JOptionPane.WARNING_MESSAGE
      );
    } else {
      final double num1 = Double.valueOf(num1Text);

      final double result = this.operation.calculateResult(num1, 1);

      if (this.operation.getNameOfTheMethod().equals("Factorial")) {
        this.number1Field.setText("" + (int) num1);
      }

      this.number1Field.setBorder(BorderFactory.createEmptyBorder());

      this.resultLabel.setText("" + result);
      this.informer.countUpdated();
    }
  }
}
