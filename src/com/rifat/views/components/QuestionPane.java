package com.rifat.views.components;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle;

import com.rifat.domain.Question;

public class QuestionPane extends JPanel {



    private JLabel jLabel3;
    Question q;

   



    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JRadioButton jRadioButton3;
    private JRadioButton jRadioButton4;
    private ButtonGroup  btnGrp;

    // End of variables declaration                  
	
    public QuestionPane(Question q)
    {
    
    	this.q=q;
         jLabel3 = new javax.swing.JLabel();
  
         jRadioButton1 = new JRadioButton();
         jRadioButton2 = new JRadioButton();
         jRadioButton3 = new JRadioButton();
         jRadioButton4 = new JRadioButton();
         
      

        

         jLabel3.setText(q.getQuestion());


         

         jRadioButton1.setText(q.getOption1());
         jRadioButton1.setActionCommand(q.getOption1());
         

         jRadioButton2.setText(q.getOption2());
         jRadioButton2.setActionCommand(q.getOption2());

         jRadioButton3.setText(q.getOption3());
         jRadioButton3.setActionCommand(q.getOption3());

         jRadioButton4.setText(q.getOption4());
         jRadioButton4.setActionCommand(q.getOption4());
         
         btnGrp=new ButtonGroup();	
         btnGrp.add(jRadioButton1);
         btnGrp.add(jRadioButton2);
         btnGrp.add(jRadioButton3);
         btnGrp.add(jRadioButton4);

         GroupLayout jPanel1Layout = new GroupLayout(this);
         setLayout(jPanel1Layout);
         jPanel1Layout.setHorizontalGroup(
             jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                 .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

                 .addGap(46, 46, 46))
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addGap(28, 28, 28)
                 .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                     .addComponent(jRadioButton4)
                     .addComponent(jRadioButton3)
                     .addComponent(jRadioButton2)
                     .addComponent(jRadioButton1)
                     .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE))
                 .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         );
         jPanel1Layout.setVerticalGroup(
             jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addGap(25, 25, 25)
                 .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                 .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                 .addComponent(jRadioButton1)
                 .addGap(18, 18, 18)
                 .addComponent(jRadioButton2)
                 .addGap(18, 18, 18)
                 .addComponent(jRadioButton3)
                 .addGap(18, 18, 18)
                 .addComponent(jRadioButton4)
                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                 
                 .addGap(20, 20, 20))
         );
         
         
         
    }
    public boolean isAnswerCorrect()
    {
    	String text;
    	boolean flag=false;
    	
    	try
    	{
    	   text=btnGrp.getSelection().getActionCommand().trim();
    	   
    	   String answer=q.getRightAnswer().trim();
    	 
    	
          if(text.equals(answer))
    	  {
    		
    		  
    		  flag=true;
    	  }
    	  else
    		{
    		
    		flag=false;
    		}
    	   return flag;
    	}
    	catch(Exception e)
    	{
    		flag=false;
    	}
    	
    	return flag;
    }
    public String getAnswer()
    {
    	return q.getRightAnswer();
    }
}
