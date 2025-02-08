class Solution {
    static int answer; //결과
    static boolean[] visited; //방문 배열
    
    public static void dfs(int n, int[][] computers, int start) {
        //이미 방문한 컴퓨터일 경우 패스
        if(visited[start]){
            return;
        }
        
        //방문 처리
        visited[start] = true;
        for(int i=0; i<n; i++){
            //연결이 되어있고 아직 방문 안한 컴퓨터일 경우 방문
            if(computers[start][i]==1 && !visited[i]) {
                dfs(n, computers, i);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        //초기화
        answer = 0;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            //아직 방문 안한 컴퓨터 방문
            if(!visited[i]){
                answer++; //카운트 증가
                dfs(n, computers, i);
            }
        }
        
        return answer;
    }
}