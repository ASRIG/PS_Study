package com.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Tree implements Comparable<Tree>{
	int x, y, age;
	
	public Tree(){}
	public Tree(int x1, int y1, int age1){
		x = x1; y = y1; age = age1;
	}
	@Override
	public int compareTo(Tree o) {
		return Integer.compare(this.age, o.age);
	}
}

public class Main_16235_나무재태크 {
	
	static String st[] = {};
	static int n, m, k;
	static int arr[][], map[][];
	static Tree tree[];
	final static int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
	final static int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};
	static Queue<Tree> q = new LinkedList<Tree>();
	static Queue<Tree> nxt_q = new LinkedList<Tree>();
	static Queue<Tree> dead_q = new LinkedList<Tree>();
	static Queue<Tree> final_q = new LinkedList<Tree>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = br.readLine().split(" ");
		n = Integer.parseInt(st[0]); m = Integer.parseInt(st[1]); k = Integer.parseInt(st[2]);
		arr = new int[n][n]; tree = new Tree[m]; map = new int[n][n];
		for(int i=0; i<n; i++) {
			st = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st[j]);
				map[i][j] = 5;
			}
		}
		for(int i=0; i<m; i++) {
			st = br.readLine().split(" "); 
			tree[i] = new Tree(Integer.parseInt(st[0]) - 1, Integer.parseInt(st[1]) - 1, Integer.parseInt(st[2]));
		}
		Arrays.sort(tree);
		for(int i=0; i<m; i++) q.add(tree[i]);
		
		for(int day_ = 0; day_ < k; day_++) {
			// ��
			while(!q.isEmpty()) {
				Tree cur = q.poll();
				if(map[cur.x][cur.y] >= cur.age) {
					map[cur.x][cur.y] -= cur.age; cur.age++;
					nxt_q.add(cur);
				}else {
					dead_q.add(cur);
				}
			}
			
			// ����
			while(!dead_q.isEmpty()) {
				Tree cur = dead_q.poll();
				map[cur.x][cur.y] += (cur.age / 2); 
			}
			
			// ����
			while(!nxt_q.isEmpty()) {
				Tree cur = nxt_q.poll();
				if(cur.age % 5 == 0) {
					for(int dir =0; dir <8; dir++) {
						int new_x = cur.x + dx[dir], new_y = cur.y + dy[dir];
						if(new_x < 0 || new_x >= n || new_y < 0 || new_y >= n) continue;
						q.add(new Tree(new_x, new_y, 1));
					}
					final_q.add(cur);
				}else {
					final_q.add(cur);
				}
			}
			
			// �ܿ�
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map[i][j] += arr[i][j];
				}
			}
			while(!final_q.isEmpty()) q.add(final_q.poll()); 
		}
		System.out.println(q.size());
	}

}
