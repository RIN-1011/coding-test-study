import java.util.*;
import java.io.*;

//케빈 베이컨의 6단계 법칙
public class Main {

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int N = Integer.parseInt(st.nextToken()); //유저의 수
	    int M = Integer.parseInt(st.nextToken()); //친구 관계의 수
	    
	    int arr[][] = new int[N+1][N+1];
	    
	    for(int i=0; i<M; i++) {
	        st = new StringTokenizer(br.readLine());
	        int A = Integer.parseInt(st.nextToken());
	        int B = Integer.parseInt(st.nextToken());
	        
	        arr[A][B] = 1; //친구 A -> B 연결
	        arr[B][A] = 1; //친구 B -> A 연결
	    }
	    
	    for(int k=1; k<=N; k++) {
	        for(int i=1; i<=N; i++) {
	            for(int j=1; j<=N; j++) {
	            	if(i == j) { //자기 자신일 경우
	            		continue; //넘어가기
	            	}
	            	//i->k->j로 거쳐서 가는 경로가 있을 경우
	            	if(arr[i][k] > 0 && arr[k][j] > 0) {
	            		//i->j로 가는 경로가 없으면
	            		if(arr[i][j] == 0) {
	            			//갱신
	            			arr[i][j] = arr[i][k] + arr[k][j];
	            		}
	            		//i->j보다 i->k->j가 더 최단거리일 경우
	            		else if(arr[i][j] > arr[i][k] + arr[k][j]) {
	            			//갱신
	            			arr[i][j] = arr[i][k] + arr[k][j];
	            		}
	            	}
	            }
	        }
	    }
	    //케빈 베이컨 수 가장 작은 사람 구하기
	    int min = Integer.MAX_VALUE;
	    int minIndex = 0;
	    int temp;
	    for (int i = 1; i <= N; i++) {
	        temp = 0;
	        for (int j = 1; j <= N; j++) {
	            temp += arr[i][j];
	        }
	        if(min>temp) {
	            min = temp;
	            minIndex = i;
	        }
	    }
	    System.out.println(minIndex);
	}
}
