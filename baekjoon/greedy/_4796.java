package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//캠핑
public class _4796 {

	public static void main(String[] args) throws IOException {
	    int i=0, sum;
	    
	    //while문 안에 넣으면 런타임 에러남
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    while(true) {
	        sum = 0;
	        i++;
	        
	        //입력 받기
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        //캠핑장 연속하는 P일 중, L일동안만 사용 가능, V일짜리 휴가
	        int L = Integer.parseInt(st.nextToken());
	        int P = Integer.parseInt(st.nextToken());
	        int V = Integer.parseInt(st.nextToken());
	        
	        //마지막 줄 0 3개
	        if(L == 0 && P == 0 && V == 0) {
	            break;
	        }
	        
	        sum += V/P * L; //휴가/연속일 * L일 동안 사용
	        
	        if(V%P <= L) { //연속 사용 가능 일수가 남은 휴가보다 더 크거나 같을 경우
	            sum += V%P; //남은 휴가 일수만큼 더하기
	        }
	        else { //연속 사용 가능 일수가 남은 휴가보다 더 작을 경우
	            sum += L; //연속 사용 일수 모두 더하기
	        }
	        
	        System.out.println("Case " + i + ": " + sum);
	    }
	}
}
