
public class Bowler {

	String type;
	String[] bType = {"Spin","Fast","Swing"};
	Over[] over = new Over[6];
	int wickets = 0;
	int runsGiven = 0;
	public Bowler(){
		for(int i=0;i<6;i++)
			over[i] = new Over();
		}
	
	public class Over {
		
		Ball[] ball = new Ball[6];
		public Over(){
			for(int i=0;i<6;i++)
				ball[i] = new Ball();
			}
	}

}
