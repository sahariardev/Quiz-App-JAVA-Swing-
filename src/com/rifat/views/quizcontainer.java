package com.rifat.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.rifat.domain.Question;
import com.rifat.io.QuestionGenerator;
import com.rifat.views.components.QuestionPane;

public class quizcontainer extends JFrame {

	private JPanel contentPane;
	private QuestionPane currentQuestion;
	private Question[] qBank;
	private int totalScore;
	private int questionCounter;
	private int maxQuestion;

	
	

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
		
	
		
		QuestionGenerator qg=new QuestionGenerator();
		qBank=qg.generate();
		
		
		
		currentQuestion=new QuestionPane(qBank[0]);
		currentQuestion.setBounds(0, 0, 572, 223);
		
		questionCounter=1;		
		maxQuestion=10;
		
		 
	
	

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
				
			
				
				
				if(currentQuestion.isAnswerCorrect())
				{
					
					totalScore++;
					System.out.println(totalScore);
				}
				
				
				
			/*
				
				
				QuestionPane q2=new QuestionPane(arr2);
				q2.setVisible(true);
				q2.setBounds(0, 0, 572, 223);
				add(q2);
				*/
				currentQuestion.setVisible(false);
				if(questionCounter<maxQuestion)
				{
				
				currentQuestion=nextQuestion(qBank[questionCounter]);
				questionCounter++;
				}
				else
				{
					System.out.println("Done with Quiz. Total Score is ::  "+totalScore);
					btnNext.setVisible(false);
				}
				
				
				jf.revalidate();
				jf.repaint();
				//System.out.println("here I am");
			}});
		
		
			
	}
	
	public QuestionPane nextQuestion(Question q)
	{
		
		QuestionPane q2=new QuestionPane(q);
		q2.setVisible(true);
		q2.setBounds(0, 0, 572, 223);
		add(q2);
		//System.out.println("here at the methods section");
		return q2;
		
	}
}
