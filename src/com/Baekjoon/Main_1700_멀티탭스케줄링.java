package com.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ItemInfo implements Comparable<ItemInfo>{
	int idx, dp;

	@Override
	public int compareTo(ItemInfo o) {
		return Integer.compare(this.dp, o.dp);
	}
}

public class Main_1700_멀티탭스케줄링 {

	static String str_tok[] = {};
	static int arr[] = new int[101], con[] = new int[101];
	static int n, k;
	static ItemInfo ii[] = new ItemInfo[101];
	
	static void qsort(int start, int end) {
		if(start == end) return;
		ItemInfo tmp = ii[start]; ii[start] = ii[(start + end) / 2];
		ii[(start + end) / 2] = tmp;
		
		int pivot = start, left = start, right = end - 1;
		
		while(left <= right) {
			while(left <= right && ii[left].dp >= ii[pivot].dp) left++;
			while(left <= right && ii[right].dp <= ii[pivot].dp) right--;
			if(left <= right) {
				tmp = ii[left]; ii[left] = ii[right]; ii[right] = tmp;
			}
		}
		
		tmp = ii[right]; ii[right] = ii[pivot]; ii[pivot] = tmp;
		qsort(start, right); qsort(right + 1, end);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str_tok = br.readLine().split(" ");
		n = Integer.parseInt(str_tok[0]); k = Integer.parseInt(str_tok[1]);
		str_tok = br.readLine().split(" ");
		for(int i=0; i<k; i++) {
			arr[i] = Integer.parseInt(str_tok[i]);
			ii[i] = new ItemInfo();
		}
		int ans = 0;
		for(int i=0; i<k; i++) {
			boolean is_okay = false;
			// �̹� �ִ��� Ȯ�� �Ǵ� ���ڸ����� Ȯ��
			for(int j = 0; j < n; j++) {
				if(con[j] == arr[i] || con[j] == 0) {
					con[j] = arr[i]; is_okay = true; break;
				}
			}
			if(is_okay) continue;
			
			for(int j=0; j<n; j++) {
				ii[j].dp = 0x7fffffff; ii[j].idx = j;
				for(int ia = i; ia < k; ia++) {
					if(arr[ia] == con[j]) {
						ii[j].dp = ia; break;
					}
				}
			}
			qsort(0, n); ans++;
			con[ii[0].idx] = arr[i];
		}
		System.out.println(ans);
	}

}
