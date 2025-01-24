import java.util.*;
import java.io.*;

public class Main {
	static int N, min;
	static int[][] arr;
	static boolean[] isSelected;
	
	static void diff() {
		int startSum = 0;
		int linkSum = 0;
		
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(isSelected[i]&&isSelected[j]) { //스타트 팀
					//능력치 계산
					startSum += arr[i][j];
					startSum += arr[j][i];
				}
				else if(!isSelected[i]&&!isSelected[j]) { //링크 팀
					//능력치 계산
					linkSum += arr[i][j];
					linkSum += arr[j][i];
				}
			}
		}
		
		min = Math.min(min, Math.abs(startSum-linkSum)); //최솟값 구하기
	}
	
	static void comb(int cnt, int start) { //조합
		if(cnt==N/2) { //팀 구성 완료
			diff(); //점수 차이 계산
			return;
		}
		else {
			for(int i=start; i<N; i++) {
				if(isSelected[i]) continue;
				isSelected[i] = true;
				comb(cnt+1, i+1);
				isSelected[i] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); //사람 수
		//초기화
		min = Integer.MAX_VALUE;
		arr = new int[N][N];
		isSelected = new boolean[N];
		//입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0, 0);
		
		System.out.println(min);
	}

}
