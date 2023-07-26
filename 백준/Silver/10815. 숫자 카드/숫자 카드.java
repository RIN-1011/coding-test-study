import java.util.*;
import java.io.*;

//숫자 카드
public class Main {
    //객체 생성 안하고 함수 쓰려면  static 붙여줘야 함
    public static boolean binarySearch(int[] have, int low, int target, int high) { //이분 탐색
        int mid; //중간 인덱스

        while(low<=high) {
            mid = (low + high)/2;

            if(have[mid] > target) { //찾는 수보다 mid가 더 클 경우 mid 오른쪽 숫자들은 필요없으므로 
                high = mid-1; //high를 mid-1로 범위 줄여주기
                continue;
            }
            if(have[mid] < target) { //찾는 수보다 mid가 작을 경우 mid 왼쪽 숫자들은 필요없으므로
                low = mid+1; //low를 mid+1로 범위 줄여주기
                continue;
            }
            else { //찾는 수가 존재할 경우 (have[mid]==target)
                return true; //true 반환
            }
        }
        return false; //찾는 수 없으면 false 반환
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //N 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine()); //상근이가 가지고 있는 숫자 카드 입력 받기
        int have[] = new int[N];
        for(int i=0; i<N; i++) {
            have[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine()); //찾아야 할 카드 개수 M 입력 받기
        st = new StringTokenizer(br.readLine()); //찾아야 할 숫자 카드 입력 받기
        int find[] = new int[M];
        for(int i=0; i<M; i++) {
            find[i] = Integer.parseInt(st.nextToken());
        }

        //이분 탐색 위한 정렬
        Arrays.sort(have);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            if(binarySearch(have, 0, find[i], have.length-1) == true) { //존재하면
                sb.append("1" + " ");
            }
            else { //존재하지 않으면
            	sb.append("0" + " ");
            }
            
        }
        System.out.println(sb.toString());

}
}
