import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //로프 개수
		Integer[] arr = new Integer[N]; //로프 배열
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//내림차순 정렬
		Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return b-a;
			}
		});
		
		int max = arr[0]; //최대 중량
		for(int i=1; i<N; i++) {
			//고른 로프 중 최소 중량으로 분산했을 때 max보다 큰 경우
			if(max < arr[i]*(i+1)) {
				max = arr[i]*(i+1); //max 갱신
			}
		}
		
		System.out.println(max);
	}

}
