import java.io.BufferedReader;
import java.io.InputStreamReader;


class EasyNumbers {

	public static int findRem(int base,int index,int divisor){
		//base^index%divisor
		if(index==0) return 1;
		if(index==1)return base%divisor;
		int ans=findRem(base, index/2,divisor);
		if(index%2==0){
			ans=(ans*ans)%divisor;
		}
		else{
			ans=(((ans*ans)%divisor)*base)%divisor;
		}
		return ans;
	}
	public static int findRemainder(int num,int base,int index,int divisor)
	{
		if(num==0) return 0;
		return (num*findRem(base, index,divisor))%divisor;
	}
	public static boolean isDivisible(int arr[],int b,int k){
		int remainder=0;
		for(int loop1=0;loop1<k;loop1++){
			remainder=(remainder+findRemainder(arr[loop1], b, k-loop1-1, k))%k;
		}
		if(remainder==0)return true;
		return false;
	}
	public static long findAns(int b,int d,int k,int arr[]){
		//num(arr[0],arr[1],...,arr[K-1]%k==0
		//Maximum Digits=d,base=b
		long ans=0;
		int loopst=0;
		if(k==1)loopst=1;//Bcoz Arrays dont start with 0
		if(k==d){
			for(int loop1=loopst;loop1<b;loop1++){
				arr[k-1]=loop1;
				if(isDivisible(arr, b, k)){
					ans=(ans+1)%1000000007;
				}
			}
			return ans;
		}
		for(int loop1=loopst;loop1<b;loop1++){
			arr[k-1]=loop1;
			if(isDivisible(arr, b, k)){
				ans=(ans+(findAns(b, d, k+1, arr)%1000000007))%1000000007;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		BufferedReader cnsl = null;
		long ans = 0;
		try {
			String ansStr=null;
			cnsl = new BufferedReader(new InputStreamReader(System.in));
			int testCases=Integer.parseInt(cnsl.readLine());
			for(int loop1=0;loop1<testCases;loop1++){
				int b,d;
				String bdStr = cnsl.readLine();
				String bd[] = bdStr.split(" ");
				b=Integer.parseInt(bd[0]);
				d=Integer.parseInt(bd[1]);
				int arr[]=new int[d];
				ans=findAns(b, d, 1, arr);
				if(ansStr==null)ansStr=""+ans;
				else ansStr=ansStr+"\n"+ans;
			}
			System.out.println(ansStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
