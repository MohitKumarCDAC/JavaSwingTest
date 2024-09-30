package WindowFrames;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StudentForm {

	public static void main(String[] args) {
		// Create a Student form when we save then it add into file
		//create JFrame
		JFrame frame=new JFrame("Student Form");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,400);
		frame.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.insets=new Insets(10,10,10,10);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		
		//create labels and textField for from
		JLabel idLabel=new JLabel("Student ID:");
		JTextField idField=new JTextField(20);//20 is size of text field
		
		JLabel nameLabel=new JLabel("Student name:");
		JTextField nameField=new JTextField(20);
		
		JLabel dobLebel=new JLabel("Date of Birth (DD/MM/YYYY):");
		JTextField dobField=new JTextField(20);
		
		JLabel addressLabel=new JLabel("Address");
		JTextArea addressArea=new JTextArea(4,20);
		addressArea.setLineWrap(true);
		addressArea.setWrapStyleWord(true);
		JScrollPane addressPane=new JScrollPane(addressArea);
		
		//create button
		JButton addStudent=new JButton("Add Student");
		JButton reset=new JButton("Reset");
		JButton exit=new JButton("Exit");
		
		//set all and add to frame
		//id
		gbc.gridx=0;
		gbc.gridy=0;
		frame.add(idLabel,gbc);
		
		gbc.gridx=1;
		frame.add(idField,gbc);
		//name
		gbc.gridx=0;
		gbc.gridy=1;
		frame.add(nameLabel,gbc);
		
		gbc.gridx=1;
		frame.add(nameField,gbc);
		//dob
		gbc.gridx=0;
		gbc.gridy=2;
		frame.add(dobLebel,gbc);
		
		gbc.gridx=1;
		frame.add(dobField,gbc);
		
		//address
		gbc.gridx=0;
		gbc.gridy=3;
		frame.add(addressLabel,gbc);
		
		gbc.gridx=1;
		frame.add(addressPane,gbc);
		
		//button
		gbc.gridx=0;
		gbc.gridy=4;
		frame.add(addStudent,gbc);
		
		gbc.gridx=1;
		frame.add(reset,gbc);
		
		gbc.gridx=2;
		frame.add(exit,gbc);
		
		//add action on button
		addStudent.addActionListener((e)->{
			String studentId=idField.getText();
			String name=nameField.getText();
			String dob=dobField.getText();
			String address=addressArea.getText();
			
			//show error msg when fields are empty
			if(studentId.isEmpty() || name.isEmpty() || dob.isEmpty() || address.isEmpty())
			{
				JOptionPane.showMessageDialog(frame,"Fill all the fields","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			//save data into File
			try(BufferedWriter writter=new BufferedWriter(new FileWriter("Student_Record.txt",true))) {
				writter.write("StudentID:"+studentId);
				writter.newLine();
				
				writter.write("Studet Name:"+name);
				writter.newLine();
				writter.write("Date Of Birth:"+dob);
				writter.newLine();
				writter.write("Address"+address);
				writter.newLine();
				writter.write("----------------------------------------");
				writter.newLine();
				JOptionPane.showMessageDialog(frame,"Data is saved into the file","Success",JOptionPane.INFORMATION_MESSAGE);
				
			}catch (IOException ex) {
				JOptionPane.showMessageDialog(frame,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			}
		});
		
		//action listner for reset Button
		reset.addActionListener((e)->{
			//clear all fields
			idField.setText("");
			nameField.setText("");
			dobField.setText("");
			addressArea.setText("");
		});
		
		//exit button
		exit.addActionListener((e)->{
			int response=JOptionPane.showConfirmDialog(frame,"Are u want to exit:","Exit Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(response==JOptionPane.YES_OPTION)
			{
				System.exit(0);//exit application
			}
		});
		
		
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
