package com.Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
public class main_1309_동물원 {
   static class Point {
      int x;
      int y;

      public Point(int x, int y) {
         this.x = x;
         this.y = y;
      }
   }
   public static char[][] mat;
   public static Queue<Point> wall;
   public static int[] dx = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
   public static int[] dy = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      mat = new char[8][8];
      wall = new LinkedList<>();
      String s;
      for (int i = 0; i < 8; i++) {
         s = br.readLine();
         for (int j = 0; j < 8; j++) {
            mat[i][j] = s.charAt(j);
            if (mat[i][j] == '#')
               wall.offer(new Point(i, j));
         }
      }
      System.out.println(move());
   }
   public static int move() {
      Queue<Point> q = new LinkedList<>();
      q.offer(new Point(7, 0));
      Point p;
      int leng;
      int wleng;
      Point wa;
      while (!q.isEmpty()) {
         leng = q.size();
         
         if(wall.isEmpty()) return 1;
         for (int i = 0; i < leng; i++) {
            p = q.poll();
            if (mat[p.x][p.y] == '#')
               continue;
            if (p.x == 0 && p.y == 7) {
               return 1;
            }
            for (int d = 0; d < 9; d++) {
               if (p.x + dx[d] >= 0 && p.x + dx[d] <= 7 && p.y + dy[d] >= 0 && p.y + dy[d] <= 7
                     && mat[p.x + dx[d]][p.y + dy[d]] == '.') {
                  q.offer(new Point(p.x + dx[d], p.y + dy[d]));
               }
            }
         }
         
         
         wleng = wall.size();
         for (int w = 0; w < wleng; w++) {
            wa = wall.poll();
            mat[wa.x][wa.y] = '.';
            System.out.printf("wa.x :: %d, wa.y :: %d\n", wa.x, wa.y);
            if (wa.x < 7) {
               wall.offer(new Point(wa.x + 1, wa.y));
               System.out.printf("new_x :: %d, new_.y :: %d\n", wa.x + 1, wa.y);
               mat[wa.x + 1][wa.y] = '#';
            }
         }
         
         
         for(int ia =0; ia < 8; ia++) {
        	 for(int ib = 0; ib < 8; ib++) {
        		 System.out.print(mat[ia][ib]);
        	 }System.out.println();
         }System.out.println();
         
      }
      return 0;
   }
}