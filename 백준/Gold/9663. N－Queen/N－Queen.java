import java.io.*;
import java.util.*;

//N-Queen
public class Main {
	public static int arr[]; //인덱스 : 행, 값 : 열
	public static int N; //배열 크기
	public static int result = 0; //방법의 수
	
	public static void algorithm(int x) {
		if(x == N) { //행을 끝까지 다 돌았으면 결과 반환
			result++;
			return;
		}
		int j;
		for(int i=0; i<N; i++) {
			arr[x] = i; //x행 i열에 퀸 놓기
			for (j = 0; j < x; j++) { //현재 행 전까지 같은 열에 놓여있거나 대각선인 퀸 찾아보기
				if((arr[x]==arr[j]) || (Math.abs(x-j) == Math.abs(arr[x]-arr[j]))) {
					break; //있으면 해당 칸에 퀸 못놓으므로 다음 열로 넘어가기 위해 break
				}
			}
			if(j==x) { //현재 행 전까지 모든 검사 통과한 경우
				algorithm(x+1); //다음 행으로 넘어가기
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		algorithm(0);
		System.out.println(result);

	}

}
