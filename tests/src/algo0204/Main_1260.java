package algo0204;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1260 {
    static boolean[][] map;
    static boolean[] visit;
    static int N, M, V;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        
        map = new boolean[N+1][N+1];
        visit = new boolean[N+1];
        
        for(int i=0; i<M;i++) {
        	int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            map[v1][v2] = true;
            map[v2][v1] = true;
        }
        
        dfs(V);
        System.out.println();
        bfs(V);
        System.out.println();        
    }
    static void bfs(int start) {
        visit = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start); // 시작하는 정점번호가 방문 스케줄 표에 들어감.
        
        while(!queue.isEmpty()) { // 방문할 정점이 남아있으면 계속 하자.(때로는 다 안가보고 끝날때도 있음.)
            int now = queue.poll(); // 스케줄 실행.
            System.out.print(now+" ");
            visit[now] = true;
            
            for(int i=1; i<=N; i++) {
                if(map[now][i] && !visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
    }
    
    static void dfs(int now) {
        visit[now] = true;
        System.out.print(now+" ");
        
        for(int i=1; i<=N; i++) {
            if(map[now][i] && !visit[i]) {
                dfs(i);
            }
        }
        
    }
}