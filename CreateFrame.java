package WindowFrames;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CreateFrame {

	public static void main(String[] args) {
		// create a window form 
		JFrame frame=new JFrame("My windows form");
		frame.setSize(400, 400);
		frame.setLayout(new FlowLayout());
		
		frame .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//visible the frame
		frame.setVisible(true);
		
		//create buttons
		JButton buttom1=new JButton("Click Me");
		//create a second button
		JButton button2=new JButton("second Button");
		
		
		//use ActionListner to set Action on Button
		//using anonymous class
		buttom1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//using anonymous class
				System.out.println("Button Click");
				//for pop up
				JOptionPane.showMessageDialog(null,"Hey,i am an Anonymous class");
			}
		});
		
		
		//use ActionListner using Lambda Expression
		//on button2 we use ActionListner Method to set Action
		//here we use Lambda Expression because ActionListner Interface is a Functional Interface
		//and lambda expression is used on Functional Interface 
		button2.addActionListener((e)->{
			//lambda expression
			//using pop up message box set message on pop up
			JOptionPane.showMessageDialog(null,"hey,i am lambda");
		});
		
				//add button on frame
				frame.add(buttom1);
				frame .add(button2);
				
	}

}
