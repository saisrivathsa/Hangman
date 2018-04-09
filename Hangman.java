import java.awt.*;
import java.applet.Applet;
import java.math.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hangman{
	
	public static void main(String[] args){
		
		String[] word = {"string", "teststring","stringtest" };
		Frame f = new Frame(); 
		int randindex = (int)( Math.random()*(word.length) );
		String s = word[randindex];
		//System.out.println(randindex);	
		int wordlen = s.length();
		int[] indflag = new int[s.length()];
		
		int j = (int) (0.4*wordlen);
		
		Label l[] = new Label[wordlen];
		TextField t[] = new TextField[wordlen-j]; 
					
		for(int i=0; i<j; i++){
			int k =(int)(Math.random()*(wordlen-1));
			if(indflag[k] == 0){
				indflag[k] = 1;
			}
			else
				i--;
		
		}
		
		int p =0,q = 0;
		for(int i = 0; i<s.length(); i++)
		{
			if(indflag[i]==0){
				l[q] = new Label(""+s.charAt(i));
				l[q].setBounds(50+40*i,100, 30,30);
				f.add(l[q]);
				q++;
			}
			else{
				
				t[p] = new TextField("");
				t[p].setBounds(50+40*i,100, 30,30);
				f.add(t[p]);
				p++;
			}
						
		}
		
		Button b = new Button("Submit");
		b.setBounds(150, 175, 70, 30);
		Button k = new Button("3");
		k.setBounds(150, 225, 30, 30);
	    
		b.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){
	        	String check = "";
	    		int o = 0;
	    		int flag = 1;
	    		for(int i=0; i<s.length(); i++){
	    			if(indflag[i]==0)
	    				check = check + s.charAt(i);	    			
	    			else{
	    				
	    				if(t[o].getText().equals("")){
	    					check = check + s.charAt(i);
	    					flag = 0;
	    				}
	    				else
	    					check = check + t[o].getText();
	    				
	    				o++;
	    			}
	    		}
	    			if( !check.equals(s) ){
	    				
	    				if(b.getLabel()=="Submit"){
	    					if((k.getLabel()=="3")){
		    	        		    
		    	        		k.setLabel("2");
		    	        	}
		    				else if(k.getLabel()=="2"){
		    					k.setLabel("1");
		    				}
		    				else{
		    					k.setLabel("0");
		    					b.setBounds(150, 175, 100, 30);
		    					b.setLabel("Game over!");
		    				}
	    			
	    				}
	    			
	    			}
	    			else if(flag==1){
	    				
	    				b.setBounds(150, 175, 100, 30);
    					b.setLabel("You Won!");
	    			}
	    		
	        }  
	        });
	    

		f.add(b); 
		f.add(k);
		f.setSize(1000,1000);
		f.setLayout(null);  
		f.setVisible(true);
	}
}
