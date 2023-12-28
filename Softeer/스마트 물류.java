import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		  
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //길이
		int K = Integer.parseInt(st.nextToken()); //거리
		  
		String str = br.readLine();
		char c[] = new char[N];
		for (int i = 0; i < N; i++) {
			c[i] = str.charAt(i);
		}
		
	    boolean visited[] = new boolean[N]; //집은 부품 체크
	    int result = 0;
	    
	    for (int i = 0; i < N; i++) {
			if(c[i]=='P') {
				for (int j = i-K; j <= i+K; j++) {
					if(j<0 || j>=N) {
						continue;
					}
					else if(c[j]=='H' && !visited[j]) {
						result++;
						visited[j] = true;
						break;
					}
				}
			}
		}
	    
	    System.out.println(result);
    }
}
