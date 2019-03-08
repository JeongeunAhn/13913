
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static boolean [] visit;
	static int n;
	static int k;
	static int distance[];
	static int parent[];
	static Stack<Integer> stack;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
//		n=sc.nextInt();
//		k=sc.nextInt();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		StringTokenizer st = new StringTokenizer(temp);
		n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		System.out.println(bfs(n));
		route(k);
		while(!stack.isEmpty()) System.out.print(stack.pop()+" ");
	}
	public static int bfs(int i) {
		distance = new int[100001];
		visit = new boolean[100001];
		parent=new int[100001];
		int temp=0;
		distance[i]=0;
		Queue <Integer> q = new LinkedList<>();
		q.offer(i);
		visit[i] = true;
		while(!q.isEmpty()) {
			temp =q.poll();
			visit[temp] = true;
			if(temp-1>=0) {
				if(!visit[temp-1]) {
					visit[temp-1] = true;
					q.offer(temp-1);
					distance[temp-1]=distance[temp]+1;
					parent[temp-1]=temp;
				}
			}
			if(temp+1<=100000) {
				if(!visit[temp+1]) {
					visit[temp+1] = true;
					q.offer(temp+1);
					distance[temp+1]=distance[temp]+1;
					parent[temp+1]=temp;
				}  
			}
			if(temp*2<=100000){
				if(!visit[temp*2]) {
					visit[temp*2] = true;
					q.offer(temp*2);
					distance[temp*2]=distance[temp]+1;
					parent[temp*2]=temp;
				}
			}
			if(temp==k) break;
		}
		return distance[temp];
	}

	public static void route(int k) {
		stack = new Stack<Integer>();

        while(n != k) {
            stack.push(k);
            k = parent[k];
        }

        stack.push(n);

	}
}
