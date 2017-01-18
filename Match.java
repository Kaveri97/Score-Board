

public class Match {
		Team t1,t2;
		int innings = 1;
		String[] p1 = {"Player 1","Player 2","Player 3","Player 4","Player 5","Player 6","Player 7","Player 8","Player 9","Player 10","Player 11"};
		String[] p2 = {"Player 1","Player 2","Player 3","Player 4","Player 5","Player 6","Player 7","Player 8","Player 9","Player 10","Player 11"};
		Match()
		{
			t1=new Team("Team A",p1);
			t2=new Team("Team B",p2);
			
		}
		public int Toss()
		{	
			int randomNum = (int)(Math.random() * 2);
		return randomNum;
		}
	}

