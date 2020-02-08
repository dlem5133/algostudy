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
        queue.add(start); // �����ϴ� ������ȣ�� �湮 ������ ǥ�� ��.
        
        while(!queue.isEmpty()) { // �湮�� ������ ���������� ��� ����.(���δ� �� �Ȱ����� �������� ����.)
            int now = queue.poll(); // ������ ����.
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