import java.io.BufferedReader;
import java.io.InputStreamReader;

class PhantaIsland {
	public static void main(String[] args) {
		BufferedReader cnsl = null;
		long ans = 0;
		try {
			cnsl = new BufferedReader(new InputStreamReader(System.in));
			int chefs = Integer.parseInt(cnsl.readLine());
			String ticketsStr = cnsl.readLine();
			String tickets[] = ticketsStr.split(" ");
			long sum = 0;
			for (int loop2 = 0; loop2 < chefs; loop2++) {
				sum += Integer.parseInt(tickets[loop2]);
			}
			if ((sum / 2) * 2 != sum) {
				ans = sum / 2 + 1;
			} else {
				ans = sum / 2;
			}
			if(ans<chefs)
				ans=chefs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(ans);
	}

}
