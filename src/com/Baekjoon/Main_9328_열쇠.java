package com.Baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Vector;

class PERSON{
	int x, y;
	
	
	PERSON(){}
	PERSON(int x1, int y1){
		x = x1; y = y1;
	}
}

public class Main_9328_열쇠 {
	
	static int n, m, Ans;
	static char map[][];
	final static int dx[] = {-1, 1, 0, 0};
	final static int dy[] = {0, 0, -1, 1};
	static boolean visited[][];
	static boolean key[];
	static Queue<PERSON> q = new LinkedList<PERSON>();	
	static boolean find_key_sw = false;

	static void init_visited() {
		for(int i=0; i<n; i++) for(int j=0; j < m; j++) visited[i][j] = false;
	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			PERSON cur = q.poll();
			for(int dir = 0; dir < 4; dir++) {
				int new_x = cur.x + dx[dir], new_y = cur.y + dy[dir];
				if(new_x < 0 || new_x >= n || new_y < 0 || new_y >= m) continue;
				if(map[new_x][new_y] == '*' || visited[new_x][new_y]) continue;

				if(map[new_x][new_y] >= 'A' && map[new_x][new_y] <= 'Z') {
					if(key[map[new_x][new_y] - 'A'] == false) continue;
					visited[new_x][new_y] = true;
					q.add(new PERSON(new_x, new_y));
				}else if(map[new_x][new_y] == '.') {
					visited[new_x][new_y] = true;
					q.add(new PERSON(new_x, new_y));
				}else if(map[new_x][new_y] == '$') {
					visited[new_x][new_y] = true;
					Ans++; map[new_x][new_y] = '.';
					q.add(new PERSON(new_x, new_y));
				}else {
					//System.out.println("Ű�� ������ ���� ���");
					find_key_sw = true;
					key[map[new_x][new_y] - 'a'] = true;
					visited[new_x][new_y] = true;
					map[new_x][new_y] = '.';
					q.add(new PERSON(new_x, new_y));
				}
			}
		}
	}
	
	static void update() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] >= 'A' && map[i][j] <= 'Z') {
					if(key[map[i][j] - 'A']) map[i][j] = '.';
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			if(map[i][0] == '.') {
				q.add(new PERSON(i, 0));
				visited[i][0] = true; 
			}if(map[i][m - 1] == '.') {
				q.add(new PERSON(i, m - 1));
				visited[i][m - 1] = true; 
			}
		}
		
		for(int i=0; i<m; i++) {
			if(map[0][i] == '.') {
				q.add(new PERSON(0, i));
				visited[0][i] = true; 
			}if(map[n - 1][i] == '.') {
				q.add(new PERSON(n-1, i));
				visited[n-1][i] = true; 
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tes = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= tes; test_case++) {
			st = new StringTokenizer(br.readLine()); Ans = 0;
			n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
			visited = new boolean[n][m]; map = new char[n][m]; 
			for(int i=0; i<n; i++) {
				map[i] = br.readLine().toCharArray();
			}
			char[] k = br.readLine().toCharArray();
			key = new boolean[26];
			if(k[0] != '0') {
				for(int i = 0; i < k.length; i++) {
					key[k[i] - 'a'] = true;
				}
			}
			
			for(int i=0; i<n; i++) {
				if(map[i][0] >= 'a' && map[i][0] <= 'z') {
					key[map[i][0] - 'a'] = true; map[i][0] = '.';
				}
				if(map[i][m - 1] >= 'a' && map[i][m - 1] <= 'z') {
					key[map[i][m - 1] - 'a'] = true; map[i][m - 1] = '.';
				}
				if(map[i][0] == '$') {
					 map[i][0] = '.'; Ans++;
				}
				if(map[i][m - 1] == '$') {
					 map[i][m - 1] = '.'; Ans++;
				}
			}
			
			for(int i=0; i<m; i++) {
				if(map[0][i] >= 'a' && map[0][i] <= 'z') {
					key[map[0][i] - 'a'] = true; map[0][i] = '.';
				}
				if(map[n - 1][i] >= 'a' && map[n - 1][i] <= 'z') {
					key[map[n - 1][i] - 'a'] = true; map[n - 1][i] = '.';
				}
				if(map[0][i] == '$') {
					 map[0][i] = '.'; Ans++;
				}
				if(map[n-1][i] == '$') {
					 map[n-1][i] = '.'; Ans++;
				}
			}
			
			find_key_sw = true;
			while(find_key_sw) {
				init_visited();
				find_key_sw = false;
				update();
				bfs();
			}
			
			q.clear();
			System.out.println(Ans);
		}
		
	}

}
