package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//스택 수열
public class _1874 {
	//stringBuilder 사용하기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); //수열 크기
		int arr[] = new int[n]; //수열 배열
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> stack = new Stack<>();
		int start = 0;
		
		for(int i=0; i<n; i++) {
			if(arr[i] > start) { //수열 숫자가 현재 삽입할 숫자보다 클 경우
				//push
				for(int j=1+start; j<=arr[i]; j++) { //수열 숫자와 같아질 때까지 '오름차순' push
					start++; //오름차순
					stack.push(start);
					System.out.println("+");
				}
			}
			if(stack.peek() != arr[i]) { //stack 상단 값이 원하는 수열 숫자가 아닌 경우
				System.out.println("NO");
				break;
			}
			
			stack.pop();
			System.out.println("-");
		}
	}

}
