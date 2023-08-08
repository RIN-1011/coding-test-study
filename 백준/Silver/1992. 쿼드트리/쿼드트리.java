import java.io.*;
import java.util.*;

//쿼드트리
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	
	//0인지 1인지 확인하는 함수 (시작 행, 시작 열, 사이즈)
	public static int checked(int x, int y, int size) {
		int zeroCnt = 0; //0 체크
		int oneCnt = 0; //1 체크
		for (int i = x; i < x+size; i++) {
			for (int j = y; j < y+size; j++) {
				if(arr[i][j] == 0) {
					zeroCnt++;
				}
				else {
					oneCnt++;
				}
			}
		}
		//모두 0일 경우 0으로 압축
		if(zeroCnt == size*size) {
			return 0;
		}
		//모두 1일 경우 1로 압축
		else if(oneCnt == size*size) {
			return 1;
		}
		return -1; //둘 다 아닐 경우 (압축 불가능)
	}
	
	//(시작 행, 시작 열, 사이즈)
	public static void algorithm(int x, int y, int size) {
		//압축 여부 체크
		int all = checked(x, y, size);
		if(all == 1) {sb.append("1"); return;}
		else if(all == 0) {sb.append("0"); return;}
		
		//압축 불가능할 경우 사이즈 쪼개서 다시 확인
		size = size/2;
		
		sb.append("(");	//해당 단계에서 괄호
		//왼쪽 위
		algorithm(x, y, size);
		//오른쪽 위
		algorithm(x, y+size, size);
		//왼쪽 아래
		algorithm(x+size, y, size);
		//오른쪽 아래
		algorithm(x+size, y+size, size);
		sb.append(")");	//해당 단계에서 괄호
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0'; //int형으로 변환
			}
		}
		
		algorithm(0, 0, N);
		System.out.println(sb);
	}

}
