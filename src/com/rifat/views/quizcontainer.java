package com.rifat.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JLabel label;
	private int que=1;
	private int counter;
	private String ans[];
	

	
	

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
		this.setResizable(false);
		setTitle("Quiz App");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 600, 434);
		label=new JLabel();
		counter=0;
		ans=new String[10];
	    //JFrame jf=this;
		
		QuestionGenerator qg=new QuestionGenerator();
		qBank=qg.generate();
		
		
		
		currentQuestion=new QuestionPane(qBank[0],que);
		currentQuestion.setBounds(0, 0, 572, 223);
		
		questionCounter=0;		
		maxQuestion=10;
		
		 
	
	

		currentQuestion.setVisible(true);
		
		setLayout(null);
		
		
		add(currentQuestion);
		
		final JButton btnNext = new JButton("Next");
		btnNext.setBounds(445, 341, 89, 23);
		add(btnNext);
		
		final JButton btnPrevious = new JButton("Previous");
		btnPrevious.setBounds(20, 341, 89, 23);
		add(btnPrevious);
		final JFrame jf=this;
		
		
		
		
		btnNext.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
			if(currentQuestion.isAnswered())
			{
				   
				
					System.out.println(questionCounter+" for next button");
					ans[questionCounter]=currentQuestion.getSelected();
					System.out.println(ans[questionCounter]);
					questionCounter++;
				
				
				
				
			
				currentQuestion.setVisible(false);
				if(questionCounter<maxQuestion)
				{
					
				currentQuestion=nextQuestion(qBank[questionCounter]);
				
				}
				else
				{
					for(int c=0;c<10;c++)
					{
						if(ans[c].trim().equals(qBank[c].getRightAnswer().trim()))
						{
							totalScore++;
						}
					}
					
					System.out.println("Done with Quiz. Total Score is ::  "+totalScore);
					btnNext.setVisible(false);
					btnPrevious.setVisible(false);
					label.setText("Total Score is : "+totalScore);
					label.setForeground(new Color(244, 169, 65));
					label.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
					label.setBounds(200, 150, 313, 42);
					//label.setBounds(100,100 ,200,200);
					
					add(label);
				}
				
				
				jf.revalidate();
				jf.repaint();
				//System.out.println("here I am");
			}
			else
			{
				JOptionPane.showMessageDialog(jf,"Please attempt the question");
				System.out.println("Did not answered ?");
			}
				
				
			}});
		btnPrevious.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				if(questionCounter>0)
				{
									currentQuestion.setVisible(false);
				remove(currentQuestion);
				
				
				currentQuestion=nextQuestion(qBank[questionCounter-1],ans[questionCounter-1]);
				questionCounter--;
				System.out.println(questionCounter+" previous button");

				jf.revalidate();
				jf.repaint();
				}
				else
				{
					JOptionPane.showMessageDialog(jf,"No previous question");
				}
			}});
		
		
			
	}
	
	public QuestionPane nextQuestion(Question q)
	{
		que++;
		QuestionPane q2=new QuestionPane(q,questionCounter+1);
		q2.setVisible(true);
		q2.setBounds(0, 0, 572, 223);
		add(q2);
		//System.out.println("here at the methods section");
		
		return q2;
		
		
	}
	public QuestionPane nextQuestion(Question q,String ans)
	{
		que++;
		QuestionPane q2=new QuestionPane(q,questionCounter+1,ans);
		q2.setVisible(true);
		q2.setBounds(0, 0, 572, 223);
		add(q2);
		//System.out.println("here at the methods section");
		
		return q2;
		
		
	}
}
