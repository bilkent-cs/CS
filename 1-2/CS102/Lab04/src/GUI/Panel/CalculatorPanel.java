package GUI.Panel;

import GUI.Buttons.CalculationButton;
import GUI.Buttons.UnaryCalculationButton;
import GUI.Panel.Interfaces.CountInformer;
import Operations.Binary.*;
import Operations.Operation;
import Operations.Unary.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * @(#)CalculatorPanel.java
 * Class that holds all calculator components
 *
 * @author Berke Gokmen
 * @date 2021/11/13
 */
public class CalculatorPanel extends JPanel implements CountInformer {

  public static final Dimension DIMENSION = new Dimension(600, 500);

  private Operation[] operations;
  private CalculationButton[] calculationButtons;
  private UnaryCalculationButton[] unaryCalculationButtons;

  private CalculationButton additionButton;
  private CalculationButton divisionButton;
  private CalculationButton multiplicationButton;
  private CalculationButton subtractionButton;

  private UnaryCalculationButton factorialButton;
  private UnaryCalculationButton naturalLogButton;
  private UnaryCalculationButton squareButton;
  private UnaryCalculationButton squareRootButton;

  private JTextField number1Field;
  private JTextField number2Field;
  private JLabel number1Label;
  private JLabel number2Label;
  private JLabel resultLabel;

  private JPanel buttonsPanel;
  private JPanel numberFieldsPanel;
  private JPanel resultFieldsPanel;

  /**
   * Initializes a {@link CalculatorPanel} object
   */
  public CalculatorPanel() {
    super();
    this.setLayout(new BorderLayout());
    this.setBorder(new EmptyBorder(5, 10, 5, 10));
    this.setSize(DIMENSION);

    this.initComponents();
    this.initButtons();
  }

  /**
   * Method to initialize buttons. Specifically:
   * <ul>
   *  <li>Buttons Panel to hold the buttons</li>
   *  <li>Operations array</li>
   *  <li>Calculation buttons with appropriate {@link Operation}</li>
   * </ul>
   */
  private void initButtons() {
    final GridLayout gridLayout = new GridLayout(4, 2);
    gridLayout.setHgap(5);
    gridLayout.setVgap(5);

    this.buttonsPanel = new JPanel(gridLayout);

    this.operations =
      new Operation[] {
        new Addition(), // 0
        new Division(), // 1
        new Multiplication(), // 2
        new Subtraction(), // 3
        new Factorial(), // 4
        new NaturalLogarithm(), // 5
        new Square(), // 6
        new SquareRoot(), // 7
      };

    this.calculationButtons =
      new CalculationButton[] {
        additionButton,
        divisionButton,
        multiplicationButton,
        subtractionButton,
      };

    this.unaryCalculationButtons =
      new UnaryCalculationButton[] {
        factorialButton,
        naturalLogButton,
        squareButton,
        squareRootButton,
      };

    for (int i = 0; i <= 3; i += 1) {
      this.calculationButtons[i] =
        new CalculationButton(
          operations[i],
          number1Field,
          number2Field,
          resultLabel,
          this
        );
      this.buttonsPanel.add(this.calculationButtons[i]);
    }

    for (int i = 0; i <= 3; i += 1) {
      this.unaryCalculationButtons[i] =
        new UnaryCalculationButton(
          operations[i + 4],
          number1Field,
          number2Field,
          resultLabel,
          this
        );
      this.buttonsPanel.add(this.unaryCalculationButtons[i]);
    }

    this.add(buttonsPanel, BorderLayout.CENTER);
  }

  /**
   * Method to initialize other components. Specifically:
   * <ul>
   *  <li>Number text fields and their labels</li>
   *  <li>Result label</<li>
   *  <li>Number field and result field panels</li>
   * </ul>
   */
  private void initComponents() {
    this.number1Field = new JTextField("", 15);
    this.number2Field = new JTextField("", 15);
    this.number1Label = new JLabel("Number 1:", SwingConstants.LEFT);
    this.number2Label = new JLabel("Number 2:", SwingConstants.RIGHT);

    this.resultLabel = new JLabel(":)");

    this.numberFieldsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    this.resultFieldsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

    this.numberFieldsPanel.add(number1Label);
    this.numberFieldsPanel.add(number1Field);
    this.numberFieldsPanel.add(number2Label);
    this.numberFieldsPanel.add(number2Field);

    this.resultFieldsPanel.add(new JLabel("Result: "));
    this.resultFieldsPanel.add(resultLabel);

    this.add(numberFieldsPanel, BorderLayout.NORTH);
    this.add(resultFieldsPanel, BorderLayout.SOUTH);
  }

  /**
   * Method to update the times called property of buttons on GUI
   */
  private void calculateAndUpdateCountMessage() {
    for (int i = 0; i < operations.length; i += 1) {
      Operation o = operations[i];
      int timesCalled = o.getTimesCalled();

      if (i <= 3) {
        CalculationButton calcButton = calculationButtons[i];
        calcButton.setText(
          calcButton.getMethodName() + "\n(" + timesCalled + ")"
        );
      } else {
        UnaryCalculationButton unCalcButton = unaryCalculationButtons[i - 4];
        unCalcButton.setText(
          unCalcButton.getMethodName() + "\n(" + timesCalled + ")"
        );
      }
    }
  }

  @Override
  public void countUpdated() {
    this.calculateAndUpdateCountMessage();
  }
}
