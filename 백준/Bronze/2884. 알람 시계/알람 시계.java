import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken()); //시
		int M = Integer.parseInt(st.nextToken()); //분
		
		int h = 0;
		int m = 0;
		
		if(H==0) { //0시일 경우
			//분으로 환산 후 45분 차감 -> 다시 시,분으로 환산
			h = (24*60+M-45)/60;
			m = (24*60+M-45)%60;
			
			if(h==24) {
				System.out.print(0+" "+m);
			}
			else {
				System.out.print(h+" "+m);
			}
		}
		else { //그 외
			h = (H*60+M-45)/60;
			m = (H*60+M-45)%60;
			
			if(h==24) {
				System.out.print(0+" "+m);
			}
			else {
				System.out.print(h+" "+m);
			}
		}
	}

}
