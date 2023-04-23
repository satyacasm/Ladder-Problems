/* package codechef; // don't place package name! */

import java.util.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */

public class Codechef2
{
    public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		FastReader sc=new FastReader();
		// int t=sc.nextInt();
        // ab:while(t-->0){
            
        // }  
        int n=sc.nextInt();
        int l=sc.nextInt();
        int arr[]=new int[n];
        // iarr(arr);
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        double max=Math.max(arr[0],l-arr[n-1]);
        for(int i=0;i<n-1;i++){
            max=Math.max(max,((double)arr[i+1]-arr[i])/2);
        }
        System.out.println(max);
	}
   
    static long gcd(long a, long b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    static long lcm(long a, long b)
    {
        return (a*b)/gcd(a, b);
    }
    static void iarr(int arr[]){
        int n=arr.length;
        FastReader sc=new FastReader();
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
    }
    static int inum(){
        FastReader sc=new FastReader();
        return sc.nextInt();
    }
    static String istr(){
        FastReader sc=new FastReader();
        return sc.nextLine();
    }
    static void yes(){
        System.out.println("YES");
    }
    static void NO(){
        System.out.println("NO");
    }        
    static void aprint(int arr[]){
        int n=arr.length;
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
    
}

class Pair{
    int a,b;
    Pair(int a1,int b1){
        a=a1;b=b1;
    }
}
class FastReader {

        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
}


class supplement{
    
    String decToBinary(int n)
    {
        // Size of an integer is assumed to be 32 bits
        String s="";
        for (int i = 31; i >= 0; i--) {
            int k = n >> i;
            if ((k & 1) > 0)
                s=s+1;
            else
                s=s+0;
        }
        return s;
    }
    int binaryToDecimal(int n)
    {
        int num = n;
        int dec_value = 0;
 
        // Initializing base
        // value to 1, i.e 2^0
        int base = 1;
 
        int temp = num;
        while (temp > 0) {
            int last_digit = temp % 10;
            temp = temp / 10;
 
            dec_value += last_digit * base;
 
            base = base * 2;
        }
 
        return dec_value;
    }
    
    
}


class UnweightedGraph
{
    private int V;   // No. of vertices
    private ArrayList<ArrayList<Integer>> g; //Adjacency Lists
 
    // Constructor
    UnweightedGraph(int v)
    {
        for(int i=0;i<v;i++){
            g.add(new ArrayList<>());
        }
    }
 
    // Function to add an edge into the graph
    void addEdge(int u,int v)
    {
        g.get(u).add(v);
        
    }
 
    // prints BFS traversal from a given source s
    void BFS(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];
 
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);
 
        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            // System.out.print(s+" ");
 
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            
            for(int n:g.get(s))
            {
                
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
    void DFSUtil(int v, boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        // System.out.print(v + " ");
 
        // Recur for all the vertices adjacent to this
        // vertex
       
        for(int n:g.get(v)) {
            
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
 
    // The function to do DFS traversal.
    // It uses recursive
    // DFSUtil()
    void DFS(int v)
    {
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];
 
        // Call the recursive helper
        // function to print DFS
        // traversal
        DFSUtil(v, visited);
    }
 
}
 
