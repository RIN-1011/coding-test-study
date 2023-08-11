import java.util.*;
import java.io.*;

//빙고
public class Main {
	static int[][] bingo;
	static boolean isChecked[][];
	
	public static boolean isBingo() { //빙고 여부
		boolean tmp;
		int cnt = 0; //3 빙고 카운트
		
		//행 빙고 검사
		for (int i = 0; i < 5; i++) {
			tmp = true;
			for (int j = 0; j < 5; j++) {
				if(!isChecked[i][j]) {
					tmp = false;
				}
			}
			if(tmp) { //한 줄 빙고면
				cnt++; //빙고 카운팅
			}
		}
		//열 빙고 검사
		for (int j = 0; j < 5; j++) {
			tmp = true;
			for (int i = 0; i < 5; i++) {
				if(!isChecked[i][j]) {
					tmp = false;
				}
			}
			if(tmp) { //한 줄 빙고면
				cnt++; //빙고 카운팅
			}
		}
		//대각선 빙고 검사
		if(isChecked[0][0] && isChecked[1][1] && isChecked[2][2] && isChecked[3][3] && isChecked[4][4]) {
			cnt++; //빙고 카운팅
		}
		if(isChecked[0][4] && isChecked[1][3] && isChecked[2][2] && isChecked[3][1] && isChecked[4][0]) {
			cnt++; //빙고 카운팅
		}
		
		if(cnt>=3) {
			return true;
		}
		
		return false;
	}
	public static int[] findIndex(int call) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(bingo[i][j] == call) {
					return new int[]{i, j};
				}
			}
		}
		return null;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		bingo = new int[5][5]; //철수 빙고판
		isChecked = new boolean[5][5]; //불려진 숫자 여부
		
		//철수 빙고판
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//사회자
		int cnt = 0; //몇 번째 수를 부른 후 빙고인지
		loopOut:
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				++cnt; //부른 수 개수 카운팅
				int call = Integer.parseInt(st.nextToken());
				int index[] = findIndex(call);
				isChecked[index[0]][index[1]] = true; //값 체크
				if(isBingo()) { //빙고 여부
					break loopOut;
				}
			}
		}
		System.out.println(cnt);
	}

}
