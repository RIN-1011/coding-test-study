package queue;

import java.util.*;
import java.io.*;

//프린터 큐
public class _1966 {

public static void main(String[] args) throws IOException{
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int T = Integer.parseInt(br.readLine());
    
    for(int t=0; t<T; t++) {
        int N, M;
        int count = 0; //n번째
        LinkedList<int[]> q = new LinkedList<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        
        for(int i=0; i<N; i++) {
            q.add(new int[] { i, Integer.parseInt(st2.nextToken()) }); //초기 위치, 중요도
        }
        
        while(true) {
            int max = Integer.MIN_VALUE;
            
            //가장 큰 중요도 구하기
            for(int i=0; i<q.size(); i++) {
                if(max<q.get(i)[1]) {
                    max = q.get(i)[1];
                }
            }
            
            //맨 앞 요소가 가장 큰 중요도 아니면 뒤로 넘기기
            if(q.peek()[1] != max) { //맨 앞 요소 중요도가 가장 크지 않을 경우
            	int[] temp = new int[2];
            	temp = q.poll(); //맨 앞 요소 빼서
            	q.add(temp); //뒤로 넘기기
            }
            
            //맨 앞 요소가 가장 큰 중요도면 요소 빼고 카운트 증가
            else if(q.peek()[1] == max) {
            	if(q.peek()[0] == M) { //뺀 요소가 궁금했던 문서와 초기위치가 일치하면
            		q.pop();
                	count++; //요소 빼고 카운트 증가
            		break;
            	}
            	q.pop();
            	count++;
            }
        }
        System.out.println(count);
    
    }
}
}