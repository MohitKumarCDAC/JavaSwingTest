package WindowFrames;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SwingCalculator {

	public static void main(String[] args) {
		// using swing component we create a calculator
		//First create a frame
		JFrame frame=new JFrame("Calculator");
		//set size of frame and set Layout
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set layout of frame
		frame.setLayout(new GridBagLayout());
		
		 GridBagConstraints gbc = new GridBagConstraints();
	     gbc.insets = new Insets(5, 5, 5, 5); // Add padding around components
		
		//create a textField
		JTextField txf1=new JTextField(10);
		JTextField txf2=new JTextField(10);
		
		//create a button
		JButton add=new JButton("Addition");
		JButton subtract=new JButton("Subtract");
		JButton multi=new JButton("Multiplication");
		JButton divide=new JButton("Divide");
		
		//for show result we use one Label
		JLabel result=new JLabel("Result:");
		result.setPreferredSize(new Dimension(200, 30)); // Set the size of the label
		
		 // Position components on the frame using GridBagConstraints

        // First row: "Number 1" label and text field
        gbc.gridx = 0; // First column
        gbc.gridy = 0; // First row
        frame.add(new JLabel("Number 1:"), gbc);

        gbc.gridx = 1; // Second column
        frame.add(txf1, gbc);

        // Second row: "Number 2" label and text field
        gbc.gridx = 0; 
        gbc.gridy = 1; 
        frame.add(new JLabel("Number 2:"), gbc);

        gbc.gridx = 1; 
        frame.add(txf2, gbc);

        // Third row: Add and Subtract buttons
        gbc.gridx = 0; 
        gbc.gridy = 2; 
        frame.add(add, gbc);

        gbc.gridx = 1; 
        frame.add(subtract, gbc);
        
        gbc.gridx=2;
        frame.add(multi,gbc);
        
        gbc.gridx=0;
        gbc.gridy=3;
        frame.add(divide,gbc);
        		

        // Fourth row: Result label
        gbc.gridx = 0; 
        gbc.gridy = 4; 
        gbc.gridwidth = 2; // Make the result label span two columns
        frame.add(result, gbc);

		
		//Add ActionListner on Button2 Using Lambda Expression(because ActionListner is a Functional Interface
		//that have only one abstract method)
		add.addActionListener((e)->{
			try {
				int num1=Integer.parseInt(txf1.getText());
				int num2=Integer.parseInt(txf2.getText());
				//perform addition
				int sum=num1+num2;
				result.setText("Result:"+sum);
				
			}catch (NumberFormatException ex) {
				result.setText("invalid input");
			}
		});
		
		//Add ActionListner on Button2 Using Lambda Expression(because ActionListner is a Functional Interface
		//that have only one abstract method)
		subtract.addActionListener((e)->{
			try {
				int num1=Integer.parseInt(txf1.getText());
				int num2=Integer.parseInt(txf2.getText());
				//perform addition
				int sub=num1-num2;
				result.setText("Result:"+sub);
				
			}catch (NumberFormatException ex) {
				result.setText("invalid input");
			}
		});
		
		//multiplication button
		multi.addActionListener((e)->{
			try {
				int num1=Integer.parseInt(txf1.getText());
				int num2=Integer.parseInt(txf2.getText());
				//perform addition
				int mul=num1*num2;
				result.setText("Result:"+mul);
				
			}catch (NumberFormatException ex) {
				result.setText("Invalid input..");
			}
		});
		
		//divide
		divide.addActionListener((e)->{
			try {
				int num1=Integer.parseInt(txf1.getText());
				int num2=Integer.parseInt(txf2.getText());
				if(num2!=0)
				{
				//perform addition
				float div=(float)num1/num2;
				result.setText("Result:"+div);
				}else
				{
					result.setText("denominator is Zero correct it..");
				}
				
			}catch (NumberFormatException ex) {
				result.setText("Invalid input..");
			}
		});
		
		
		//frame is visible when we true
		frame.setVisible(true);

	}

}
