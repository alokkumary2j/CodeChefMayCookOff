import java.io.BufferedReader;
import java.io.InputStreamReader;


class Euro {

	public static boolean f(int denom[],int L,int money,int currentIndex){
		if(L<0) return false;
		if(money==L)return true;
		if(money<L)return false;
		if(currentIndex==0)return true;
		int moneyToReturn=0;
		boolean ans=true;
		while(moneyToReturn<=money){
			ans=f(denom,L-moneyToReturn,money-moneyToReturn,currentIndex-1);
			moneyToReturn+=denom[currentIndex];
			if(ans==false) return false;
		}
		return true;
	}
	public static int ans(int denom[],int C,int L)
	{
		int lastIndex=denom.length;
		int index=lastIndex;
		while(denom[index]>L){
			lastIndex=index;
			index--;
		}
		for(int loop1=C;loop1>L;loop1++){
			if(f(denom,L,C,lastIndex)) return loop1;
		}
		return L;
	}
		
	
	public static void main(String[] args) {
		
		BufferedReader cnsl =null;
		String ansStr=null;
		try {
			cnsl= new BufferedReader(new InputStreamReader(System.in));
			//cnsl = System.console();
			int testCases = Integer.parseInt(cnsl.readLine());
			int denom[]={1, 2, 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000, 20000, 50000};
			for (int loop1 = 0; loop1 < testCases; loop1++) {
				String activitiesStr = cnsl.readLine();
				String acts[] = activitiesStr.split(" ");
				int C = Integer.parseInt(acts[0]);
				int L=Integer.parseInt(acts[1]);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
