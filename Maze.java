import java.io.BufferedReader;
import java.io.InputStreamReader;


class Maze {
	public static void main(String[] args) {
		BufferedReader cnsl =null;
		String ansStr=null;
		try {
			cnsl= new BufferedReader(new InputStreamReader(System.in));
			int testCases = Integer.parseInt(cnsl.readLine());
			for (int loop1 = 0; loop1 < testCases; loop1++) {
				String activitiesStr = cnsl.readLine();
				String acts[] = activitiesStr.split(" ");
				int R = Integer.parseInt(acts[0]);
				int C=Integer.parseInt(acts[1]);
				int W=Integer.parseInt(acts[2]);
				for (int loop2 = 0; loop2 < W; loop2++) {
					String act = cnsl.readLine();
					String actToks[] = act.split(" ");
					int i1=Integer.parseInt(actToks[0]);
					int j1=Integer.parseInt(actToks[1]);
					int i2=Integer.parseInt(actToks[2]);
					int j2=Integer.parseInt(actToks[3]);
				}
			}
			System.out.println(ansStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
