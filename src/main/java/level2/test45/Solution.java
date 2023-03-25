package level2.test45;
import java.util.*;

/* 
ROR 게임은 두 팀으로 나누어서 진행하며, 상대 팀 진영을 먼저 파괴하면 이기는 게임입니다. 따라서, 각 팀은 상대 팀 진영에 최대한 빨리 도착하는 것이 유리합니다.

지금부터 당신은 한 팀의 팀원이 되어 게임을 진행하려고 합니다. 다음은 5 x 5 크기의 맵에, 당신의 캐릭터가 (행: 1, 열: 1) 위치에 있고, 상대 팀 진영은 (행: 5, 열: 5) 위치에 있는 경우의 예시입니다.
 */


class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] visit;
    static int m , n;
        
    public int solution(int[][] maps) {
        m = maps.length; 
        n = maps[0].length;
        
        visit = new int[m][n];
        visit[0][0] = 1;
        
        bfs(maps);
 
        return visit[m-1][n-1] == 0 ? -1 : visit[m-1][n-1];
    }
    
    public void bfs (int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || ny < 0 || nx > m - 1 || ny > n - 1){
                    continue;
                }
                
                if(visit[nx][ny] == 0 && maps[nx][ny] == 1){
                    visit[nx][ny] = visit[x][y] + 1;
                    queue.add(new int[]{nx,ny});
                }
            }
        }
    }
}