package com.rifat.views;

import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.rifat.domain.Question;
import com.rifat.views.components.QuestionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class quizcontainer extends JFrame {

	private JPanel contentPane;
	private QuestionPane currentQuestion;

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quizcontainer frame = new quizcontainer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws InterruptedException 
	 */
	public quizcontainer()  {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 588, 434);
		
		
	
		//setLayout(null);

		Question q1=new Question("1. What is the capital of Bangladesh ?","Dhaka","Chittagong","Narayangonj","Barisal","Dhaka");
		
		Question q2=new Question("2. What is the capital of Nepal ?","Kathmandu","Tansen","Itahari","Ghorahi","Kathmudnu");
		
		
		
		
		currentQuestion=new QuestionPane(q1);
		currentQuestion.setBounds(0, 0, 572, 223);
		
		

		
		 
	
	

		currentQuestion.setVisible(true);
		setLayout(null);
		
		
		add(currentQuestion);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(445, 341, 89, 23);
		add(btnNext);
		JFrame jf=this;
		
		btnNext.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
			
				
				System.out.println(currentQuestion.selectedRadiobtnText());
				
			/*
				
				
				QuestionPane q2=new QuestionPane(arr2);
				q2.setVisible(true);
				q2.setBounds(0, 0, 572, 223);
				add(q2);
				*/
				currentQuestion.setVisible(false);
				currentQuestion=nextQuestion(q2);
				
				jf.revalidate();
				jf.repaint();
				System.out.println("here I am");
			}});
		
		
		
	}
	
	public QuestionPane nextQuestion(Question q)
	{
		
		QuestionPane q2=new QuestionPane(q);
		q2.setVisible(true);
		q2.setBounds(0, 0, 572, 223);
		add(q2);
		System.out.println("here at the methods section");
		return q2;
		
	}
}
