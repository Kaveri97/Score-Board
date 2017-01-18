
public class Team {
	
	Player[] player = new Player[11];
	String name;
	int runs = 0;
	int wickets = 0;
	

	Team(String n,String[] a)
	{			this.name=n;
				for(int i=0;i<11;i++){
					if( i%4==0){
						player[i] = new Player(a[i],'Y');
						
					}
					else 
						player[i] = new Player(a[i],'N');
						
				}
	}
	

	class Player {
		String name;
		Batsman b1;
		Bowler b2;
		Player(String n, char c)
		{
			if(c=='Y'){
			this.name=n;
			b1 = new Batsman();
			b2 = new Bowler();
			}
			else{
				this.name=n;
				b1 = new Batsman();
			}
	   }
	}
	
	
}