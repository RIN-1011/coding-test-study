import java.util.*;
import java.io.*;

//경로 찾기
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); //정점의 개수
		int arr[][] = new int[N][N]; //인접 행렬
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int k = 0; k < N; k++) { //k 거쳐서 갈 수 있는지
			//i -> j
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j] != 1) { //i->j 가는 길이 없을 경우
						//i->k->j로 거쳐서 가는 길 찾기
						if(arr[i][k] == 1 && arr[k][j] == 1) { //i->k로 갈 수 있고 k->j로 갈 수 있으면
							arr[i][j] = 1; //값 갱신
						}
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
