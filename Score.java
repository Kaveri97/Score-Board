import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
/**
 *
 */
public class Score extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Match m = new Match();
	Team batting;
	Team bowling;
	int l = 0, //batsman index
		i = 0, //bowler index
		j = 0, //over number
		k = 0; // ball number
	ActionListener update=new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			update(); //function to update score after each ball
		}	};
	Timer timer = new Timer(400,update);
	JButton button;
	Container cont;
	JPanel textPanel, buttonpanel;
	JLabel title,game,over,wickets,runs,batsman,bowler,status;
	JLabel[] jLabel = new JLabel[11];
	
	Score(){
		cont = getContentPane();
		cont.setLayout(new BorderLayout());
		JPanel textpanel = new JPanel();
		buttonpanel = new JPanel();
		buttonpanel.setLayout(new GridLayout(7, 4, 2, 2));
		title = new JLabel();
		title.setText("Score Card");
		buttonpanel.add(title);
		game = new JLabel();
		game.setText(m.t1.name+ "          vs          " + m.t2.name);
		buttonpanel.add(game);
		button = new JButton("Toss");
		button.addActionListener(this);
		buttonpanel.add(button); 
		for(int i=0; i<11; i++){
			jLabel[i] = new JLabel("Player"+(i+1));
			buttonpanel.add(jLabel[i]);
		}
		status = new JLabel();
		status.setText("Match Status   :   Match yet to begin");
		buttonpanel.add(status);
		over = new JLabel();
		over.setText("Over");
		buttonpanel.add(over);
		runs = new JLabel();
		runs.setText("Runs");
		buttonpanel.add(runs);
		wickets = new JLabel();
		wickets.setText("Wickets");
		buttonpanel.add(wickets);
		batsman = new JLabel();
		batsman.setText("Current Batsman   :     -");
		buttonpanel.add(batsman);
		bowler = new JLabel();
		bowler.setText("Current Bowler    :     -");
		buttonpanel.add(bowler);		
		
		cont.add("Center", buttonpanel);
		cont.add("North", textpanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
    
                                              

   public void update(){	   
	   
	   				if(batting.wickets==10 || j==5){
	   					i = 0;
	   		 		    l = 0;
	   		 		    j=0;
	   		 		    k=0;
	   		 		    timer.stop();
	   				}
				    else {
						bowling.player[i].b2.over[j].ball[k].runs = (int)(Math.random() * 8);
						batting.player[l].b1.runsTaken = batting.player[l].b1.runsTaken + bowling.player[i].b2.over[j].ball[k].runs;
	   					bowler.setText("Current Bowler  :"+"     "+bowling.name+ "   "+bowling.player[i].name);
	 				    batsman.setText("Current Batsman   :"+"     "+batting.name+ "   "+batting.player[l].name);
		 				   jLabel[l].setText(batting.player[l].name+"   :     "+ batting.player[l].b1.runsTaken);
						   if(bowling.player[i].b2.over[j].ball[k].runs == 7){
							   l++;
							   batting.wickets++;
							   wickets.setText("Wickets   :     "+batting.wickets);
						   }
						   batting.runs = batting.runs + bowling.player[i].b2.over[j].ball[k].runs;
						   runs.setText("Runs   :     "+batting.runs);
						   if(k==5){
							   over.setText("Over   :     "+(j+1)+"."+0);
						   }
						   else
						   over.setText("Over   :     "+j+"."+(k+1));
					   }
	   				k++;
	   				if(k==6){
	   					j++;
	   					k=0;
	   					if(j%2==1)
	 	 				   i=i+4;
	   				}
	   				
	   			
	   			
	 		   if(m.innings==1 && (batting.wickets==10 || j==5)){
				   button.setText("2nd Innings");
				   button.setVisible(true);
				   
			   }
			   else if(m.innings==2 && (batting.wickets==10 || j==5)){
				   if(batting.runs>bowling.runs){
					   status.setText("Match Status   :   "+ batting.name+ " won the match by "+ (batting.runs - bowling.runs)+ " runs");
					   timer.stop();
				   }
				   else if(batting.runs==bowling.runs){
					   status.setText("Match Status   :   Draw");
					   timer.stop();
				   }
				   else{
					   status.setText("Match Status   :   "+bowling.name+ " won the match by "+ (bowling.runs - batting.runs)+ " runs");
				   timer.stop();
				   }
				   
			   }
	   
		 
	  }
	   	
   

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    	try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
		}
		Score f = new Score();
		f.setTitle("SCORE BOARD");
		f.pack();
		f.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = e.getActionCommand();
		if (s.equals("Toss")) {
			int toss=m.Toss();
	    	if(toss==1)
	    	{
	    		status.setText("Match Status   :   Team A won the toss and chose to bat first !! ");
	    		batting=m.t1;
	    		bowling=m.t2;
	    	}
	    	else
	    	{
	    		status.setText("Match Status   :   Team B won the toss and chose to bat first !! ");
	    		batting=m.t2;
	    		bowling=m.t1;
	    	}
	    	for(int i=0; i<11;i++){
	    		jLabel[i].setText(batting.player[i].name+"   :     -");
	    	}
	    	runs.setText("Runs   :  0");
	    	over.setText("Overs   :  0.0");
	    	wickets.setText("Wickets   :  0");
	    	button.setText("1st Innings");
		}
		else if (s.equals("1st Innings")){
			status.setText("Match Status   :   Innings I");
			runs.setText("Runs   :  0");
		   	over.setText("Over   :  0.0");
		   	wickets.setText("Wickets   :  0");
		   	button.setVisible(false);
			timer.setRepeats(true);
	    	timer.start();
		}
		else if (s.equals("2nd Innings")){
			m.innings++;
			Team temp=batting;
	    	   batting=bowling;
	    	   bowling=temp;
			for(int i=0; i<11;i++){
	    		jLabel[i].setText(batting.player[i].name+"   :     -");
	    	}
			status.setText("Match Status   :   Innings II");
			runs.setText("Runs   :  0");
		   	over.setText("Over   :  0.0");
		   	wickets.setText("Wickets   :  0");
		   	button.setVisible(false);
			timer.setRepeats(true);
	    	timer.start();
		}
	}
}
 