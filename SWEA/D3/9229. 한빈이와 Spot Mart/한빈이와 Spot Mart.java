import java.util.*;
import java.io.*;

//한빈이와 Spot Mart
public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for(int t=1; t<=TC; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //과자 봉지 개수
			int M = Integer.parseInt(st.nextToken()); //무게 합 제한
			
			int arr[] = new int[N]; //각 과자봉지의 무게
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int min = M; //무게 제한과 현재 든 과자 봉지 무게 차
			int result = -1; //들고 갈 수 있는 최대 무게
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					//들고 있는 과자 봉지 무게 합이 제한된 무게보다 작거나 같아야 함
					int tmp = arr[i]+arr[j]; //들고 있는 과자 무게
					if(M >= tmp) {
						//무게 제한에서 현재 들고 있는 과자 무게 차가 지금 min 값보다 작으면
						if(M - tmp < min) {
							//min 갱신
							min = M - tmp;
							//들고 갈 수 있는 최대 무게 갱신
							result = tmp;
						}
					}
				}
			}
			sb.append("#"+t+" "+result+"\n");
		}
		System.out.println(sb);
	}

}
