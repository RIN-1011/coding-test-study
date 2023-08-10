import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int[][] arr2; //복사 배열
    static int N; //행
    static int M; //열
    static int K; //연산 개수
    static int min = Integer.MAX_VALUE;; //배열 최솟값
    
    static int numbers[]; //순열 저장 배열
    static boolean isSelected[]; //숫자 사용 여부
    static int oper[][]; //연산 배열
    
    //순열
    public static void permutation(int cnt) {
        //순열 완성
    	if(cnt == K) {
    		//배열 복사
    		arr2 = new int[N+1][M+1];
        	for (int i = 1; i <= N; i++) {
    			for (int j = 1; j <= M; j++) {
    				arr2[i][j] = arr[i][j];
    			}
    		}
        	
    		//순열 순서대로 연산하면서 배열 돌리기
    		for (int i = 0; i < K; i++) {
    			algorithm(oper[numbers[i]][0], oper[numbers[i]][1], oper[numbers[i]][2]);
			}
    		//연산 K번 끝난 후 배열 최솟값 구하기
            for (int i = 1; i <= N ; i++) {
                int tmp = 0;
                //각 행의 최솟값 구하기
                for (int j = 1; j <= M; j++) {
                    tmp += arr2[i][j];
                }
                //최솟값 갱신 가능하면 갱신하기
                if(tmp < min) {
                    min = tmp;
                }
            }
    	}
        //순열 구하기
    	else {
    		for (int i = 0; i < K; i++) {
				if(isSelected[i]) {
					continue;
				}
				numbers[cnt] = i;
				isSelected[i] = true;
				permutation(cnt+1);
				isSelected[i] = false;
			}
    	}
    }
    //배열 돌리기, 최솟값
    public static void algorithm(int r, int c, int s) {
        //s번 회전 (테두리)
        for(int i=0; i<s; i++) {
            int temp = arr2[r-s+i][c+s-i]; //값 오른쪽으로 당길 때 끝 값 사라지는거 방지
            //상
            for (int j = c+s-i; j > c-s+i; j--) { //값 오른쪽으로 당기기
            	arr2[r-s+i][j] = arr2[r-s+i][j-1];
            }
            //좌
            for (int j = r-s+i; j < r+s-i; j++) { //값 위쪽으로 당기기
            	arr2[j][c-s+i] = arr2[j+1][c-s+i];
            }
            //하
            for (int j = c-s+i; j < c+s-i; j++) { //값 왼쪽으로 당기기
            	arr2[r+s-i][j] = arr2[r+s-i][j+1];
            }
            //우
            for (int j = r+s-i; j > r-s+i; j--) { //값 아래쪽으로 당기기
            	arr2[j][c+s-i] = arr2[j-1][c+s-i];
            }
            arr2[r-s+1+i][c+s-i] = temp; //빈자리에 아까 저장한 좌표 삽입
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //행 크기
        M = Integer.parseInt(st.nextToken()); //열 크기
        K = Integer.parseInt(st.nextToken()); //회전 연산 개수

        arr = new int[N+1][M+1];
        numbers = new int[K]; //순열 저장 배열
        isSelected = new boolean[K]; //숫자 사용 여부
        oper = new int[K][3]; //연산 배열

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        //연산 배열
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            oper[i][0] = Integer.parseInt(st.nextToken()); //r
            oper[i][1] = Integer.parseInt(st.nextToken()); //c
            oper[i][2] = Integer.parseInt(st.nextToken()); //s
        }
        permutation(0); //연산 순열
        
        System.out.println(min);
    }

}