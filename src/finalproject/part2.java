package finalproject;

import javax.swing.*;

import finalproject.part1.check;
import finalproject.part1.Report.Draw;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

public class part2 extends JFrame implements ActionListener {

	
	private JLabel message1;
	private JLabel message2;
	JComboBox box;
	JTextField input;
	JPanel panel;
	JLabel messageLabel;
	JLabel messageLabel2;
	JLabel lblmess;
	JTextField textfield;
	JCheckBox choicea;
	JCheckBox choiceb;
	JCheckBox choicec;

	List<JCheckBox> choices = new ArrayList<>();
	JButton btnext;
	int qaid;
	String[][] qpa;
	String[][] qca;
	HashMap<Integer, String> map;
	
	public part2(JPanel panel) {
		this.panel= panel;
	}
	
	//rendering the interface of part2
	public void second(JPanel panel) {
		
		
		
		setTitle("Quiz Program");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(430,350);
        setLocation(300,100);
        setResizable(false);
        Container cont=getContentPane();
        cont.setLayout(null);          
        cont.setBackground(Color.GRAY);
        choicea = new JCheckBox("Germany");
        choiceb = new JCheckBox("Portugal");
        choicec = new JCheckBox("Vietnam");

        
        choices.add(choicea);
        choices.add(choiceb);
        choices.add(choicec);
        
        lblmess=new JLabel("Which countries are participating WC next year?");
        lblmess.setForeground(Color.BLUE);
        lblmess.setFont(new Font("Arial", Font.BOLD, 11));
        btnext=new JButton("Next");
        btnext.setForeground(Color.GREEN);                
        btnext.addActionListener(new check2());
        this.panel=new JPanel();
        this.panel.setBackground(Color.LIGHT_GRAY);
        this.panel.setLocation(10,10);
        this.panel.setSize(400,300);
        this.panel.setLayout(new GridLayout(6,2));
        this.panel.add(lblmess);
        this.panel.add(choicea);
        this.panel.add(choiceb);
        this.panel.add(choicec);

        this.panel.add(btnext);
        cont.add(this.panel);
        setVisible(true);

  
        
	}
	
	//check if the first question is done correctly
	public class check2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			if(choicea.isSelected()&&choiceb.isSelected()&& !choicec.isSelected()) {
				passing mes = new passing();
			
			}
			else {
				failing mess = new failing();
			}
		}


	}

	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	//displaying the annoucing message and one button to move on
	public class passing extends JFrame implements ActionListener{
		
		
		public JPanel panel;

		

		passing(){
		setTitle("Correct");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(430,150);
        setLocation(300,300);
        setResizable(false);
        Container cont=getContentPane();
        cont.setLayout(null);
        message1 = new JLabel("Congratulations! Your answered correctly!");
        btnext=new JButton("Next");
        btnext.addActionListener(new proceed());
        message1.setForeground(Color.BLUE);
        message1.setFont(new Font("Tahoma", Font.BOLD, 14));
        message1.setBounds(0, 41, 434, 44);
        this.panel=new JPanel();
        this.panel.setBackground(Color.LIGHT_GRAY);
        this.panel.setLocation(10,10);
        this.panel.setSize(400,100);
        this.panel.add(message1);
        this.panel.add(btnext);
        cont.add(this.panel);
        setVisible(true);
        
		}



		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	//displaying new window to show message and modify the panel
	public class proceed implements ActionListener{
		

		public void actionPerformed(ActionEvent e) {
			
			JLabel message = new JLabel("Where does Santa Clause live?");
			btnext = new JButton("Let's check");
			btnext.addActionListener(new proceed2());
			box = new JComboBox<String>();
			box.addItem("Finland");
			box.addItem("The US");
			box.addItem("Vietnam");
			panel.removeAll();
			panel.add(message);
			panel.add(box);
			panel.add(btnext);
			panel.revalidate();
			panel.repaint();
			
		}
	}
	//checking the second question and modify the panel again, for the last question
	public class proceed2 implements ActionListener{
		
		

		public void actionPerformed(ActionEvent e) {
			
			if(box.getSelectedItem().equals("Finland")) {
				JOptionPane.showMessageDialog(null,"One more to go");
				
				
				JLabel message = new JLabel("Enter the name of US's president");
				btnext = new JButton("Let's check");
				btnext.addActionListener(new proceed3()); 
				input = new JTextField();
				input.setColumns(30);
				panel.removeAll();
				panel.add(message);
				panel.add(input);
				panel.add(btnext);
				panel.revalidate();
				panel.repaint();
		     
			}
			else {
				failing mess = new failing();
			}
		}

	}
	//checking the last question and display the final message when the answer is correct
	public class proceed3 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			if(input.getText().equals("Donald Trump")){				
					JOptionPane.showMessageDialog(null, "Well done! You have finished the quiz :)");
					dispose();
			
			}
			
			else {
				failing mess = new failing();
			}
			
		}


	}
	//displaying the failing message when user chooses wrong
	public class failing extends JFrame {
		failing(){
			JOptionPane.showMessageDialog(null, "Try again");
		}
	}
	
}
