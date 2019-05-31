
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;
import java.util.*;


public class Calculator extends JFrame {

    private JButton jbtNum1;
    private JButton jbtNum2;
    private JButton jbtNum3;
    private JButton jbtNum4;
    private JButton jbtNum5;
    private JButton jbtNum6;
    private JButton jbtNum7;
    private JButton jbtNum8;
    private JButton jbtNum9;
    private JButton jbtNum0;
    
    private JButton jbtAdd;
    private JButton jbtSubtract;
    private JButton jbtMultiply;
    private JButton jbtDivide;
    private JButton jbtSolve;
    private JButton jbtClear;
    private JButton jbtClearAll;
    private JButton jbtPlusMins;
    private JButton jbtEmpty;
    private JButton jbtPoint;
    
    private double TEMP;
    private double SolveTEMP;
    
    private JTextField jtfResult;

    Boolean addBool = false;
    Boolean subBool = false;
    Boolean divBool = false;
    Boolean mulBool = false;
    Boolean solBool = false;
    Boolean showBool = false;

    String display = "";
    String str;
    int count =0;
  

    public Calculator() {
    
    	setTitle("Calculator");
    	
        JPanel p1 = new JPanel();
     
        p1.setLayout(new GridLayout(5, 4));
        
        p1.add(jbtClearAll = new JButton("AC"));
        jbtClearAll.setFont(new Font("Arial", Font.PLAIN, 38));
        
        p1.add(jbtClear = new JButton("C"));
        jbtClear.setFont(new Font("Arial", Font.PLAIN, 38));
        
        p1.add(jbtPlusMins = new JButton("+/-"));
        jbtPlusMins.setFont(new Font("Arial", Font.PLAIN, 40));
        
        p1.add(jbtDivide = new JButton("/"));
        jbtDivide.setFont(new Font("Arial", Font.PLAIN, 40));
        
        p1.add(jbtNum7 = new JButton("7"));
        jbtNum7.setFont(new Font("Arial", Font.PLAIN, 38));
        
        p1.add(jbtNum8 = new JButton("8"));
        jbtNum8.setFont(new Font("Arial", Font.PLAIN, 38));
        
        p1.add(jbtNum9 = new JButton("9"));
        jbtNum9.setFont(new Font("Arial", Font.PLAIN, 38));
        
        p1.add(jbtMultiply = new JButton("*"));
        jbtMultiply.setFont(new Font("Arial", Font.PLAIN, 40));
        
        p1.add(jbtNum4 = new JButton("4"));
        jbtNum4.setFont(new Font("Arial", Font.PLAIN, 38));
        
        p1.add(jbtNum5 = new JButton("5"));
        jbtNum5.setFont(new Font("Arial", Font.PLAIN, 38));
        
        p1.add(jbtNum6 = new JButton("6"));
        jbtNum6.setFont(new Font("Arial", Font.PLAIN, 38));
        
        p1.add(jbtSubtract = new JButton("-"));
        jbtSubtract.setFont(new Font("Arial", Font.PLAIN, 38));
        
        p1.add(jbtNum1 = new JButton("1"));
        jbtNum1.setFont(new Font("Arial", Font.PLAIN, 38));
        
        p1.add(jbtNum2 = new JButton("2"));
        jbtNum2.setFont(new Font("Arial", Font.PLAIN, 38));
        
        p1.add(jbtNum3 = new JButton("3"));
        jbtNum3.setFont(new Font("Arial", Font.PLAIN, 38));
        
        p1.add(jbtAdd = new JButton("+"));
        jbtAdd.setFont(new Font("Arial", Font.PLAIN, 38));
        
        p1.add(jbtNum0 = new JButton("0"));
        jbtNum0.setFont(new Font("Arial", Font.PLAIN, 38));
        
        p1.add(jbtEmpty = new JButton(""));
        
        
        p1.add(jbtPoint = new JButton("."));
        jbtPoint.setFont(new Font("Arial", Font.PLAIN, 40));
        
        p1.add(jbtSolve = new JButton("="));
        jbtSolve.setFont(new Font("Arial", Font.PLAIN, 40));
        
        p1.setPreferredSize(new Dimension(600, 600));
       
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(jtfResult = new JTextField());
        
        jtfResult.setPreferredSize(new Dimension(500,80));
        jtfResult.setFont(new Font("Arial", Font.PLAIN, 42));
        jtfResult.setEditable(false);
        p2.setPreferredSize(new Dimension(600, 100));
        
        
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(p2, BorderLayout.NORTH);
        p.add(p1, BorderLayout.SOUTH);
        p.setPreferredSize(new Dimension(700, 700));
        
        
        p1.setBackground(Color.LIGHT_GRAY);
        p2.setBackground(Color.LIGHT_GRAY);
        p.setBackground(Color.LIGHT_GRAY);
        
        add(p);


        jbtNum1.addActionListener(new ListenToOne());
        jbtNum2.addActionListener(new ListenToTwo());
        jbtNum3.addActionListener(new ListenToThree());
        jbtNum4.addActionListener(new ListenToFour());
        jbtNum5.addActionListener(new ListenToFive());
        jbtNum6.addActionListener(new ListenToSix());
        jbtNum7.addActionListener(new ListenToSeven());
        jbtNum8.addActionListener(new ListenToEight());
        jbtNum9.addActionListener(new ListenToNine());
        jbtNum0.addActionListener(new ListenToZero());
        jbtPlusMins.addActionListener(new ListenToPlusMins());
        jbtPoint.addActionListener(new ListenToPoint());

        jbtAdd.addActionListener(new ListenToAdd());
        jbtSubtract.addActionListener(new ListenToSubtract());
        jbtMultiply.addActionListener(new ListenToMultiply());
        jbtDivide.addActionListener(new ListenToDivide());
        jbtSolve.addActionListener(new ListenToSolve());
        jbtClear.addActionListener(new ListenToClear());
        jbtClearAll.addActionListener(new ListenToClearAll());
    } 
    class ListenToClearAll implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            jtfResult.setText("");
            addBool = false;
            subBool = false;
            mulBool = false;
            divBool = false;
            solBool = false;
            showBool = false;
            TEMP = 0;
            SolveTEMP = 0;
        }
    }
    
    class ListenToClear implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	jtfResult.setText("");
        	TEMP = Double.parseDouble(jtfResult.getText());        
        }
    }
    
    class ListenToPlusMins implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	display = jtfResult.getText();

        	if(Double.parseDouble(display) >0 && display.charAt(0) == '+')  {
        			display = jtfResult.getText();	
            jtfResult.setText("-"+display.substring(1));	
           
        	}
        	else if(Double.parseDouble(display) < 0 && display.charAt(0) == '-') {
        		display = jtfResult.getText();	
                jtfResult.setText(""+display.substring(1));
        		
        	}
        	else if(Double.parseDouble(display) > 0) {
        		jtfResult.setText("-"+display);
        	}
        	else if (Double.parseDouble(display) < 0){
        		 jtfResult.setText(""+display);
        	}
        }
    }
    class ListenToPoint implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        	if(solBool || showBool)
        		jtfResult.setText("");
        	if(jtfResult.getText().length()==0)
        		jtfResult.setText("0.");
        	else if(jtfResult.getText().length()>1){
        		if(jtfResult.getText().indexOf(".")==1)  return;
        		double t=Double.parseDouble(jtfResult.getText());
        	 if(t==0) 
                 jtfResult.setText("0");
        	
        	}
        	display = jtfResult.getText();
        	if(display.indexOf(".") == -1)	
               jtfResult.setText(display+".");	  	
        	 solBool = false;
        	 showBool = false;
        }
    }


    class ListenToZero implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	if(solBool || showBool)
        		jtfResult.setText("");
        	
        	
        	if(jtfResult.getText().length()>=1){
        		if(jtfResult.getText().indexOf(".")==1) {
        			display = jtfResult.getText();
        			jtfResult.setText(display+"0");
        			return;
        		}
        		double t=Double.parseDouble(jtfResult.getText());
        	    if(t==0) {
                 jtfResult.setText("0");
        	 display = jtfResult.getText();
        	 return;
        	 }
      
        	}
        	display = jtfResult.getText();
            jtfResult.setText(display+"0");
            solBool = false;
            showBool = false;
        }
    }
    
    class ListenToOne implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	if(solBool || showBool||(jtfResult.getText().length()>0&&Double.parseDouble(jtfResult.getText())==0&&jtfResult.getText().indexOf(".")==-1))
        		jtfResult.setText("");
            display = jtfResult.getText();
            jtfResult.setText(display+"1");
            solBool = false;
            showBool = false;
        }
    }

    class ListenToTwo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	if(solBool || showBool||(jtfResult.getText().length()>0&&Double.parseDouble(jtfResult.getText())==0&&jtfResult.getText().indexOf(".")==-1))
        		jtfResult.setText("");
            display = jtfResult.getText();
            jtfResult.setText(display + "2");
            solBool = false;
            showBool = false;
        }
    }

    class ListenToThree implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	if(solBool || showBool||(jtfResult.getText().length()>0&&Double.parseDouble(jtfResult.getText())==0&&jtfResult.getText().indexOf(".")==-1))
        		jtfResult.setText("");
            display = jtfResult.getText();
            jtfResult.setText(display + "3");
            solBool = false;
            showBool = false;
        }
    }

    class ListenToFour implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	if(solBool || showBool||(jtfResult.getText().length()>0&&Double.parseDouble(jtfResult.getText())==0&&jtfResult.getText().indexOf(".")==-1))
        		jtfResult.setText("");
            display = jtfResult.getText();
            jtfResult.setText(display + "4");
            solBool = false;
            showBool = false;
        }
    }

    class ListenToFive implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	if(solBool || showBool||(jtfResult.getText().length()>0&&Double.parseDouble(jtfResult.getText())==0&&jtfResult.getText().indexOf(".")==-1))
        		jtfResult.setText("");
            display = jtfResult.getText();
            jtfResult.setText(display + "5");
            solBool = false;
            showBool = false;
        }
    }

    class ListenToSix implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	if(solBool || showBool||(jtfResult.getText().length()>0&&Double.parseDouble(jtfResult.getText())==0&&jtfResult.getText().indexOf(".")==-1))
        		jtfResult.setText("");
            display = jtfResult.getText();
            jtfResult.setText(display + "6");
            solBool = false;
            showBool = false;
        }
    }

    class ListenToSeven implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	if(solBool || showBool||(jtfResult.getText().length()>0&&Double.parseDouble(jtfResult.getText())==0&&jtfResult.getText().indexOf(".")==-1))
        		jtfResult.setText("");
            display = jtfResult.getText();
            jtfResult.setText(display + "7");
            solBool = false;
            showBool = false;
        }
    }

    class ListenToEight implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	if(solBool || showBool||(jtfResult.getText().length()>0&&Double.parseDouble(jtfResult.getText())==0&&jtfResult.getText().indexOf(".")==-1))
        		jtfResult.setText("");
            display = jtfResult.getText();
            jtfResult.setText(display + "8");
            solBool = false;
            showBool = false;
        }
    }

    class ListenToNine implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	if(solBool || showBool||(jtfResult.getText().length()>0&&Double.parseDouble(jtfResult.getText())==0&&jtfResult.getText().indexOf(".")==-1))
        		jtfResult.setText("");
            display = jtfResult.getText();
            jtfResult.setText(display + "9");
            solBool = false;
            showBool = false;
          
        }
    }
    
    class ListenToAdd implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	if(addBool||subBool||mulBool||divBool) {
        		SolveTEMP = Double.parseDouble(jtfResult.getText());
        	if (addBool == true)
                SolveTEMP = SolveTEMP + TEMP;
            else if ( subBool == true)
                SolveTEMP = TEMP - SolveTEMP;
            else if ( mulBool == true)
                SolveTEMP = TEMP*SolveTEMP;
            else if ( divBool == true) {
            	if(SolveTEMP == 0) {
            		 jtfResult.setText("err");  
            		 return;
            	}
            	else	
                SolveTEMP = TEMP/SolveTEMP;
            	
            }
        	jtfResult.setText(SolveTEMP+"");
        	}
           TEMP = Double.parseDouble(jtfResult.getText());
           jtfResult.setText(jtfResult.getText());
            addBool = true;
            showBool = true;
            subBool=false;
            mulBool=false;
            divBool=false;
        }
    }

    class ListenToSubtract implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	if(addBool||subBool||mulBool||divBool) {
        		SolveTEMP = Double.parseDouble(jtfResult.getText());
        	if (addBool == true)
                SolveTEMP = SolveTEMP + TEMP;
            else if ( subBool == true)
                SolveTEMP = TEMP - SolveTEMP;
            else if ( mulBool == true)
                SolveTEMP = TEMP*SolveTEMP;
            else if ( divBool == true) {
            	if(SolveTEMP == 0) {
            		 jtfResult.setText("err");  
            		 return;
            	}
            	else	
                SolveTEMP = TEMP/SolveTEMP;
            	
            }
        	jtfResult.setText(SolveTEMP+"");
        	}
            TEMP = Double.parseDouble(jtfResult.getText());
            jtfResult.setText(jtfResult.getText());
            subBool = true;
            showBool = true;
            mulBool=false;
            divBool=false;
            addBool=false;
        }
    }

    class ListenToMultiply implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	if(addBool||subBool||mulBool||divBool) {
        		SolveTEMP = Double.parseDouble(jtfResult.getText());
        	if (addBool == true)
                SolveTEMP = SolveTEMP + TEMP;
            else if ( subBool == true)
                SolveTEMP = TEMP - SolveTEMP;
            else if ( mulBool == true)
                SolveTEMP = TEMP*SolveTEMP;
            else if ( divBool == true) {
            	if(SolveTEMP == 0) {
            		 jtfResult.setText("err");  
            		 return;
            	}
            	else	
                SolveTEMP = TEMP/SolveTEMP;
            	
            }
        	jtfResult.setText(SolveTEMP+"");
        	}
            TEMP = Double.parseDouble(jtfResult.getText());
            jtfResult.setText(jtfResult.getText());
            mulBool = true;
            showBool = true;
            divBool=false;
            subBool=false;
            addBool=false;
        }
    }

    class ListenToDivide implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	if(addBool||subBool||mulBool||divBool) {
        		SolveTEMP = Double.parseDouble(jtfResult.getText());
        	if (addBool == true)
                SolveTEMP = SolveTEMP + TEMP;
            else if ( subBool == true)
                SolveTEMP = TEMP - SolveTEMP;
            else if ( mulBool == true)
                SolveTEMP = TEMP*SolveTEMP;
            else if ( divBool == true) {
            	if(SolveTEMP == 0) {
            		 jtfResult.setText("stupid");  
            		 return;
            	}
            	else	
                SolveTEMP = TEMP/SolveTEMP;
            	
            }
        	jtfResult.setText(SolveTEMP+"");
        	}
            TEMP = Double.parseDouble(jtfResult.getText());
            jtfResult.setText(jtfResult.getText());
            divBool = true;
            showBool = true;
            mulBool=false;
            subBool=false;
            addBool=false;
        }
    }

    class ListenToSolve implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	DecimalFormat decimalFormat = new DecimalFormat("0.#####");
            SolveTEMP = Double.parseDouble(jtfResult.getText());
            if (addBool == true) {
                SolveTEMP = SolveTEMP + TEMP;
                str = decimalFormat.format(Double.valueOf(Double.toString(SolveTEMP)));
            }
            else if ( subBool == true) {
                SolveTEMP = TEMP - SolveTEMP;
                str = decimalFormat.format(Double.valueOf(Double.toString(SolveTEMP)));
            }
            else if ( mulBool == true) {
                SolveTEMP = TEMP*SolveTEMP;
                if(SolveTEMP == -0 )
                	SolveTEMP = 0;
                str = decimalFormat.format(Double.valueOf(Double.toString(SolveTEMP)));
            }
            else if ( divBool == true) {
            	if(SolveTEMP != 0) {
            		SolveTEMP = TEMP/SolveTEMP;
               	 str = decimalFormat.format(Double.valueOf(Double.toString(SolveTEMP)));	
            		
            	}
            	else 
            		 str="stupid";
            	
                
            }
            
           
           
            jtfResult.setText(str);
            addBool = false;
            subBool = false;
            mulBool = false;
            divBool = false;
            showBool = false;
            solBool = true;
        }
    }

    public static void main(String[] args) throws Exception {

    	Calculator calc = new Calculator ();
    
        calc.pack();
        calc.setLocationRelativeTo(null);
                calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calc.setVisible(true);
      
     
    }

} 

