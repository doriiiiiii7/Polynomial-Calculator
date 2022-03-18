package view;

import javax.swing.*;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.event.ActionListener;

public class DashboardView extends JFrame {

    private final JPanel contentPane;
    private final JTextField firstInput;
    private final JTextField secondInput;
    private final JTextField result;
    private final JPanel firstPanel;
    private final JPanel pOnePanel;
    private final JButton addButton;
    private final JButton subtractButton;
    private final JButton divideButton;
    private final JButton multiplyButton;
    private final JButton differentiateButton;
    private final JButton integrateButton;
    private final JButton clearButton;
    private final JButton swapButton;
    private final JButton helpButton;


    public DashboardView() {
        setTitle("Calculator de polinoame");
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 200);
        contentPane = new JPanel();
        contentPane.setBorder(null);
        setContentPane(contentPane);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

        firstPanel = new JPanel();
        contentPane.add(firstPanel);
        firstPanel.setLayout(new BoxLayout(firstPanel, BoxLayout.Y_AXIS));

        pOnePanel = new JPanel();
        pOnePanel.setBackground(new Color(204, 255, 255));
        firstPanel.add(pOnePanel);

        JLabel text1 = new JLabel("Primul polinom:");
        pOnePanel.add(text1);

        firstInput = new JTextField();
        firstInput.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        firstInput.setBackground(Color.WHITE);
        firstInput.setColumns(25);
        pOnePanel.add(firstInput);

        JPanel pTwoPanel = new JPanel();
        pTwoPanel.setBackground(new Color(204, 255, 255));
        firstPanel.add(pTwoPanel);

        JLabel text2 = new JLabel("Al doilea polinom:");
        pTwoPanel.add(text2);

        secondInput = new JTextField();
        secondInput.setBorder(new LineBorder(Color.BLACK, 3, true));
        pTwoPanel.add(secondInput);
        secondInput.setColumns(25);

        JPanel resultPanel = new JPanel();
        resultPanel.setBackground(new Color(204, 255, 255));
        firstPanel.add(resultPanel);

        JLabel text3 = new JLabel("Rezultat:");
        resultPanel.add(text3);

        result = new JTextField();
        result.setEditable(false);
        result.setBorder(new LineBorder(Color.BLACK, 3));
        resultPanel.add(result);
        result.setColumns(30);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(204, 255, 255));
        contentPane.add(panel_1);
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Calculator de polinoame");
        title.setBackground(new Color(153, 255, 255));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Consolas", Font.BOLD, 20));
        panel_1.add(title);

        JPanel panel_4 = new JPanel();
        panel_1.add(panel_4);
        panel_4.setLayout(new GridLayout(0, 3, 0, 0));

        addButton = new JButton("+");
        addButton.setToolTipText("");
        addButton.setBorder(new LineBorder(new Color(255, 153, 153), 1, true));
        addButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addButton.setBackground(new Color(255, 204, 204));
        addButton.setSize(new Dimension(10, 10));
        addButton.setMinimumSize(new Dimension(70, 20));
        addButton.setMaximumSize(new Dimension(70, 20));
        addButton.setPreferredSize(new Dimension(70, 20));
        panel_4.add(addButton);

        subtractButton = new JButton("-");
        subtractButton.setBorder(new LineBorder(new Color(255, 153, 153), 1, true));
        subtractButton.setBackground(new Color(255, 204, 204));
        subtractButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        subtractButton.setSize(new Dimension(10, 10));
        subtractButton.setPreferredSize(new Dimension(70, 20));
        subtractButton.setMinimumSize(new Dimension(70, 20));
        subtractButton.setMaximumSize(new Dimension(70, 20));
        panel_4.add(subtractButton);

        divideButton = new JButton("/");
        divideButton.setBorder(new LineBorder(new Color(255, 153, 153), 1, true));
        divideButton.setBackground(new Color(255, 204, 204));
        divideButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        divideButton.setSize(new Dimension(10, 10));
        divideButton.setPreferredSize(new Dimension(70, 20));
        divideButton.setMinimumSize(new Dimension(70, 20));
        divideButton.setMaximumSize(new Dimension(70, 20));
        panel_4.add(divideButton);

        multiplyButton = new JButton("*");
        multiplyButton.setBorder(new LineBorder(new Color(255, 153, 153), 1, true));
        multiplyButton.setBackground(new Color(255, 204, 204));
        multiplyButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        multiplyButton.setSize(new Dimension(10, 10));
        multiplyButton.setPreferredSize(new Dimension(70, 20));
        multiplyButton.setMinimumSize(new Dimension(70, 20));
        multiplyButton.setMaximumSize(new Dimension(70, 20));
        panel_4.add(multiplyButton);

        differentiateButton = new JButton("\u2202 ");
        differentiateButton.setBorder(new LineBorder(new Color(255, 153, 153), 1, true));
        differentiateButton.setBackground(new Color(255, 204, 204));
        differentiateButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        differentiateButton.setSize(new Dimension(10, 10));
        differentiateButton.setPreferredSize(new Dimension(70, 20));
        differentiateButton.setMinimumSize(new Dimension(70, 20));
        differentiateButton.setMaximumSize(new Dimension(70, 20));
        panel_4.add(differentiateButton);

        integrateButton = new JButton("\u222B");
        integrateButton.setBorder(new LineBorder(new Color(255, 153, 153), 1, true));
        integrateButton.setBackground(new Color(255, 204, 204));
        integrateButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        integrateButton.setSize(new Dimension(10, 10));
        integrateButton.setPreferredSize(new Dimension(70, 20));
        integrateButton.setMinimumSize(new Dimension(70, 20));
        integrateButton.setMaximumSize(new Dimension(70, 20));
        panel_4.add(integrateButton);

        clearButton = new JButton("Clear");
        clearButton.setBorder(new LineBorder(new Color(255, 153, 153), 1, true));
        clearButton.setBackground(new Color(255, 204, 204));
        clearButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        clearButton.setSize(new Dimension(10, 10));
        clearButton.setPreferredSize(new Dimension(70, 20));
        clearButton.setMinimumSize(new Dimension(70, 20));
        clearButton.setMaximumSize(new Dimension(70, 20));
        panel_4.add(clearButton);

        swapButton = new JButton("Swap");
        swapButton.setBorder(new LineBorder(new Color(255, 153, 153), 1, true));
        swapButton.setBackground(new Color(255, 204, 204));
        swapButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        swapButton.setSize(new Dimension(10, 10));
        swapButton.setPreferredSize(new Dimension(70, 20));
        swapButton.setMinimumSize(new Dimension(70, 20));
        swapButton.setMaximumSize(new Dimension(70, 20));
        panel_4.add(swapButton);

        helpButton = new JButton("Help");
        helpButton.setBorder(new LineBorder(new Color(255, 153, 153), 1, true));
        helpButton.setBackground(new Color(255, 204, 204));
        helpButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        helpButton.setSize(new Dimension(10, 10));
        helpButton.setPreferredSize(new Dimension(70, 20));
        helpButton.setMinimumSize(new Dimension(70, 20));
        helpButton.setMaximumSize(new Dimension(70, 20));
        panel_4.add(helpButton);
    }

    public String getFirstInput(){
        return firstInput.getText();
    }

    public String getSecondInput(){ return secondInput.getText();}

    public void setFirstInput(String s){ firstInput.setText(s);}

    public void setSecondInput(String s){ secondInput.setText(s);}

    public void setResult(String s){ result.setText(s);}

    public void addListener(ActionListener actionListener) {
        this.addButton.addActionListener(actionListener);
    }

    public void subtractListener(ActionListener actionListener) {
        this.subtractButton.addActionListener(actionListener);
    }

    public void multiplyListener(ActionListener actionListener){
        this.multiplyButton.addActionListener(actionListener);
    }

    public void divideListener(ActionListener actionListener){
        this.divideButton.addActionListener(actionListener);
    }

    public void clearListener(ActionListener actionListener){
        this.clearButton.addActionListener(actionListener);
    }

    public void swapListener(ActionListener actionListener){
        this.swapButton.addActionListener(actionListener);
    }

    public void helpListener(ActionListener actionListener){
        this.helpButton.addActionListener(actionListener);
    }

    public void integrateListener(ActionListener actionListener){
        this.integrateButton.addActionListener(actionListener);
    }
    
    public void differentiateListener(ActionListener actionListener){
        this.differentiateButton.addActionListener(actionListener);
    }

    public void showError(String errorMessage) {
        UIManager.put("OptionPane.background",new ColorUIResource(255, 153, 153));
        UIManager.put("Panel.background",new ColorUIResource(255, 153, 153));
        JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void showMessage(String message){
        UIManager.put("OptionPane.background",new ColorUIResource(153, 255, 255));
        UIManager.put("Panel.background",new ColorUIResource(153, 255, 255));
        JOptionPane.showMessageDialog(this, message, "Help", JOptionPane.INFORMATION_MESSAGE);
    }
}
