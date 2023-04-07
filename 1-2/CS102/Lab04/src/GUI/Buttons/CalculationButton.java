package GUI.Buttons;

import GUI.Panel.Interfaces.CountInformer;
import Operations.Operation;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @(#)CalculationButton.java
 * Class that represents calculation button
 * And provides functionality
 *
 * @author Berke Gokmen
 * @date 2021/11/13
 */
public class CalculationButton extends JButton implements ActionListener {

  protected Operation operation;
  protected JTextField number1Field;
  protected JTextField number2Field;
  protected JLabel resultLabel;
  protected CountInformer informer;

  /**
   * Initializes a {@link CalculationButton} object
   *
   * @param operation {@link Operation} object for button
   * @param number1Field {@link JTextField} object that holds number 1
   * @param number2Field {@link JTextField} object that holds number 2
   * @param resultLabel {@link JLabel} object that shows result
   * @param informer {@link CountInformer} object that will be informed when the button is clicked
   */
  public CalculationButton(
    Operation operation,
    JTextField number1Field,
    JTextField number2Field,
    JLabel resultLabel,
    CountInformer informer
  ) {
    this.operation = operation;
    this.number1Field = number1Field;
    this.number2Field = number2Field;
    this.resultLabel = resultLabel;
    this.informer = informer;

    this.setText(operation.getNameOfTheMethod() + "\n(0)");
    this.addActionListener(this);

    this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 100)));
    this.setOpaque(true);
    this.setBackground(new Color(200, 200, 200));
  }

  /**
   * Getter method for method name
   *
   * @return {@link String} name of the mehtod
   */
  public String getMethodName() {
    return this.operation.getNameOfTheMethod();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String num1Text = number1Field.getText();
    String num2Text = number2Field.getText();

    boolean isOperationOk = true;

    // Empty the result label first
    this.resultLabel.setText("?");

    // Following code (specifically regular expression) is taken from StackOverflow by CraigTP
    // https://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
    if (!num1Text.matches("-?\\d+(\\.\\d+)?")) {
      this.number1Field.setBorder(BorderFactory.createLineBorder(Color.RED, 1));

      isOperationOk = false;
    } else {
      this.number1Field.setBorder(BorderFactory.createEmptyBorder());
    }

    if (!num2Text.matches("-?\\d+(\\.\\d+)?")) {
      this.number2Field.setBorder(BorderFactory.createLineBorder(Color.RED, 1));

      isOperationOk = false;
    } else {
      this.number2Field.setBorder(BorderFactory.createEmptyBorder());
    }

    if (isOperationOk) {
      final double num1 = Double.valueOf(num1Text);
      final double num2 = Double.valueOf(num2Text);

      final double result = this.operation.calculateResult(num1, num2);

      this.resultLabel.setText("" + result);
      this.informer.countUpdated();
    } else {
      JOptionPane.showMessageDialog(
        this,
        "Please enter valid numbers",
        "Error",
        JOptionPane.WARNING_MESSAGE
      );
    }
  }
}
