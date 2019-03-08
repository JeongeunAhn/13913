
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
		Queue <Integer> q = new <Integer> LinkedList();
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
		int i=0;
		stack = new Stack<Integer>();
		stack.push(k);
		if(k==n) {
			parent[k]=n; //k=n일때 무한루프가 도는 것을 방지
			stack.pop();
		}else {
			while(!(parent[k]==n)) {
				if(parent[k]==i){			
					stack.push(i);
					k=i;
					i=-1;	
				}
				i++;
			}
		}
		stack.push(n);
	}
}

//public static StringBuilder route(int k) {
//int i=0;
////array = new Stack<Integer>();
////array=new ArrayList<Integer>();
////array.push(k);
////array.add(k);
//StringBuilder s = new StringBuilder();
//if(k==n) {
//	parent[k]=n; //k=n일때 무한루프가 도는 것을 방지
//	//array.pop();
//	s.insert(0,n);
//}else {
//s.insert(0,k);
//s.insert(0," ");
//while(!(parent[k]==n)) {
//	if(parent[k]==i){
//		//array.add(i);
//		//array.push(i);
//		s.insert(0,i);
//		s.insert(0," ");
//		k=i;
//		i=-1;	
//	}
//	i++;
//}
////array.add(n);
////array.push(n);
//s.insert(0,n);
//}
////while(!array.isEmpty()) {
////	s.insert(array.pop()+" ");
////}
////System.out.println(s);
//return s;
//}
//
