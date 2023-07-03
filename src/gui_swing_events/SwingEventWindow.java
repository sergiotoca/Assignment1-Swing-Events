// the package statement
package gui_swing_events;



//import GridLayout
import java.awt.GridLayout;


// import the required swing classes: 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
// Import the two required interfaces:
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
/* 
* Both interfaces have one required method (Event-Handler) to be implemented:
* Each event-handler needs its event class to be imported also:
* Import the two required event classes for each interface event-handler
*/
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;





public class SwingEventWindow extends JFrame implements ActionListener, ItemListener{
    // Declare the checked radio button variable flag:
    // this global and private variable is set to an initial value of 1
    // which refer to the first radio button to be selected by default
    // You can name "rdoChecked"
    private int rdoChecked = 1;

    // Create JPanel main container object:
    private JPanel mainPanel = new JPanel();

    // You create JPanel sub containers objects for each section of the GUI:
    private JPanel painel1 = new JPanel();
    private JPanel painel2 = new JPanel();
    private JPanel painel3 = new JPanel();
    private JPanel painel4 = new JPanel();
    private JPanel painel5 = new JPanel();
    private JPanel painel6 = new JPanel();

    // Create JComponents Items based on the assignment requirements:
    private JLabel lblMain = new JLabel("Excel Functions");
    private JLabel lblRequest = new JLabel("Enter your numbers separeted by spaces");

    private JTextField txtNum = new JTextField(10);

    private JButton btnCalculate = new JButton("Calculate");

    private JLabel lblResult = new JLabel("Result:");
    private JTextField txtResult = new JTextField(10);

    // Create/Declare the 4 radio buttons objects:
    private JRadioButton sumRdo = new JRadioButton("AutoSum", true);
    private JRadioButton avgRdo = new JRadioButton("Average");
    private JRadioButton maxRdo = new JRadioButton("Maximum");
    private JRadioButton minRdo = new JRadioButton("Minimum");

    // Using ButtonGroup class for grouping the 4 related radio buttons
    // Create/Declare the ButtonGroup object
    // for grouping the radio button inside the constructor method
    private ButtonGroup opBtnGrp = new ButtonGroup();
    //Declaring the gridlayout
    GridLayout layout = new GridLayout(6,1);
    // Class Constructor:
    public SwingEventWindow() {
        // Setting Windows Title by targeting the method from the super class:
        super.setTitle("Excell Formulas Window");
        // Setting Window (JFrame) Size:
        super.setSize(600, 400);
        // Set the Window (JFrame) visibility to true to make it visible
        super.setVisible(true);
        // Setting the default operation for the close button to Exit the JFrame
        // (Stopping the application)
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // No need to assign/set any value to the JComponents
        // It's already done when they are all declared above
        // Just group the four related JRadioButton components:
        // by adding them to the ButtonGroup object that you declared earlier
        opBtnGrp.add(sumRdo);
        opBtnGrp.add(avgRdo);
        opBtnGrp.add(maxRdo);
        opBtnGrp.add(minRdo);

        // Adding the components to their panels:
        /*
        * IMPORTANT Note:
        * For quick demo, I used different and multiple JPanels objects
        * to layout the GUI components.
        * It's better to use the "GridLayout" based on the instructions
        */
        mainPanel.setLayout(layout);
        // Panel#1 for lblMain - Panel#2 for lblRequest - Panel#3 for txtNum
        painel1.add(lblMain);
        painel2.add(lblRequest);
        painel3.add(txtNum);
        // Panel#4 for the 4 radio buttons
        painel4.add(sumRdo);
        painel4.add(avgRdo);
        painel4.add(maxRdo);
        painel4.add(minRdo);
        // Panel#5 for the calculate button
        painel5.add(btnCalculate);
        // Panel#6 for the result label and the result output textfield
        painel6.add(lblResult);
        painel6.add(txtResult);
        // Adding all the 6 sub panels to the main panel (the main container):
        mainPanel.add(painel1);
        mainPanel.add(painel2);
        mainPanel.add(painel3);
        mainPanel.add(painel4);
        mainPanel.add(painel5);
        mainPanel.add(painel6);
        // Adding the main panel "mainPanel" (JPanel object) to the JFrame:
        super.getContentPane().add(mainPanel);
        // Adding/attaching the required Events to some components:
        /*
        * We need to add the required events to each radio button
        * and to the submit "Calculate" button only
        */
        sumRdo.addItemListener(this);
        avgRdo.addItemListener(this);
        maxRdo.addItemListener(this);
        minRdo.addItemListener(this);
        btnCalculate.addActionListener(this);


    } // end constructor
    // Implementing the two required methods (event-handler)
    // for each interface:

    @Override
    public void itemStateChanged(ItemEvent e) {
        if ((e.getItemSelectable() == sumRdo) && (e.getStateChange() == ItemEvent.SELECTED)) {
            // set the value of the flag variable "rdoChecked" to 1
            rdoChecked = 1;
        }
        
        else if ((e.getItemSelectable() == avgRdo) && (e.getStateChange() == ItemEvent.SELECTED)) {
            // set the value of the flag variable "rdoChecked" to 2
            rdoChecked = 2;
        }
        
        else if ((e.getItemSelectable() == maxRdo) && (e.getStateChange() == ItemEvent.SELECTED)) {
            // set the value of the flag variable "rdoChecked" to 3
            rdoChecked = 3;
        }
        
        else {
            // set the value of the flag variable "rdoChecked" to 4
            rdoChecked = 4;
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Getting the user's input string from the first textfield:
        // Save it into a variable of String data type:
        String input = txtNum.getText();
        // Initialize our "Excel" class object:
        /*
        * Passing the String value of the user's input to the constructor
        * Java will pick the second constructor from the Excel class
        * based on the passing data type of the argument which is "String"
        */
        Excel excel = new Excel(input);

        // Run the if condition for checking the value of the flag variable "rdoChecked"
        if (rdoChecked == 1) {
            // call the findTotal() method
            double total = excel.findTotal();
            // output/Print the result (value) in the result's textfield
            txtResult.setText(String.valueOf(total));
        }
        
        else if (rdoChecked == 2) {
            // call the findAvg() method
            double average = excel.findAvg();
            // output/Print the result (value) in the result's textfield
            txtResult.setText(String.valueOf(average));
        }
        
        else if (rdoChecked == 3) {
            // call the findMax() method
            double max = excel.findMax();
            // output/Print the result (value) in the result's textfield
            txtResult.setText(String.valueOf(max));
        }
        
        else if (rdoChecked == 4) {
            // call the findMin() method
            double min = excel.findMin();
            // output/Print the result (value) in the result's textfield
            txtResult.setText(String.valueOf(min));
        }
        
    } // end Event-Handler method for the calculate button
} // end class file