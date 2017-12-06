package finalproject;

//importing modules
import javax.swing.*;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.Enumeration;
import java.util.HashMap;

public class menu extends JFrame implements ActionListener {

	JRadioButton quiz1;
	JRadioButton quiz2;
	JLabel lblfirstmess;
	JButton start;
	JPanel menupanel;
	ButtonGroup bg;

//the menu interface	
	public menu(){
		setBounds(0,0,583,439);
		setTitle("Menu");
		setSize(400,100);
		setLocation(300,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container menucont = getContentPane();
		bg = new ButtonGroup();
		quiz1 = new JRadioButton("Part 1",true);
		quiz2 = new JRadioButton("Part 2",false);
		bg.add(quiz1);
		bg.add(quiz2);
		lblfirstmess = new JLabel("Choose quiz part");
		start= new JButton("Start");
		start.addActionListener(new start());
		menupanel = new JPanel();
		menupanel.setLocation(10,10 );
		menupanel.setSize(400,300);
		menupanel.add(lblfirstmess);
		menupanel.add(quiz1);
		menupanel.add(quiz2);
		menupanel.add(start);
		menucont.add(menupanel);
		setVisible(true);
		
	
		

	
	}
	

	public static void main(String[] args) {
		menu eow = new menu();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
	//this step decides whether to open part 1 or part 2 of the quiz
	public class start implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(quiz1.isSelected()) {
				part1 open = new part1();
				open.first();
			}
			else if (quiz2.isSelected()) {
				part2 open = new part2(menupanel);
				open.second(menupanel);
			}
		}

	}



}
