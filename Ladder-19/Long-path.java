/*
In this problem you had to simulate route of character in graph.
Note that if you are in vertice i, then edges in all vertices with numbers less than i are turned to pi. It gives us opportunity to see a recurrence formula: let dpi be number of steps, needed to get from vertice 1 to vertice i, if all edges are rotated back, into pi. Then dpi + 1 = 2dpi + 2 - dppi. Answer will be dpn + 1.

BONUS: Can you solve this task without statement pi ≤ i? I don't know the solution, it seems difficult.
*/

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
    InputStream is;
    PrintWriter out;
    String INPUT = "";
    //class  Declaration
 
static class pair implements Comparable < pair > {
long x;
long y;
pair(long i, long j) {
    x = i;
    y = j;
}
public int compareTo(pair p) {
    if (this.x != p.x) {
        return Long.compare(this.x,p.x);
    } else {
        return Long.compare(this.y,p.y);
    }
}
public int hashCode() {
    return (x + " " + y).hashCode();
}
public String toString() {
    return x + " " + y;
}
public boolean equals(Object o) {
    pair x = (pair) o;
    return (x.x == this.x && x.y == this.y);
}
}

 
// int[] dx = {0,0,1,-1};
// int[] dy = {1,-1,0,0};
// int[] ddx = {0,0,1,-1,1,-1,1,-1}; 
// int[] ddy = {1,-1,0,0,1,-1,-1,1};
 
final int inf = (int) 1e9 + 9;
final long biginf  = (long)1e18 + 7 ;
final long mod =  (long)1e9+7;  


void solve() throws Exception {
    // int t=ni();
    // while(t-->0)
    // {
       
    // }
    int n=ni();
    // System.out.println(n);
    // int arr[]=na(n);
    int arr[]=new int[n+5];
    for(int i=1;i<=n;i++){
        arr[i]=ni();
    }
    long dp[]=new long[n+5];
    // dp[1]=1;
    // boolean vis[]=new boolean[n];
    // Arrays.fill(dp,-1);
//    for (int i = 2; i <=n; i++) {
        
//         dp[i]=1;
//         for(int j=arr[i];j<i;j++){
//             dp[i]+=(dp[j]+1)%mod;
//         }
//    }

    // long ans=0;
    // for(int i=0;i<n;i++){
    //     ans=(ans+dp[i])%mod;
    // }

    // pn(ans);

    dp[1]=0;
    dp[2]=2;
    for(int i=3;i<=n+1;i++){
        dp[i]=(2*dp[i-1]+2-dp[arr[i-1]])%mod;
        if(dp[i]<0){
            dp[i]+=mod;

        }
    }
    pn(dp[n+1]);
    // pn(f(0,arr,dp,n,vis)%mod);
    
}






long pow(long a, long b) {
    long result = 1;
    while (b > 0) {
        if (b % 2 == 1) result = (result * a) % mod;
        b /= 2;
        a = (a * a) % mod;
    }
    return result;
}
long gcd(long a, long b) {
    if (b == 0)
        return a;
    return gcd(b, a % b);
}
void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);
 
        long s = System.currentTimeMillis();
        solve();
        out.flush();
        // System.err.println(System.currentTimeMillis() - s + "ms");
}
public static void main(String[] args) throws Exception {
    boolean memory = false ;
    if(memory) new Thread(null, new Runnable() {public void run(){try{new Main().run();}catch(Exception e){e.printStackTrace();System.exit(1);}}}, "1", 1 << 28).start();
    else new Main().run();
    
}
 
//output methods
private void dbg(Object... o){ System.err.println(Arrays.deepToString(o));}
void p(Object... o){for(Object oo:o)out.print(oo);}
void pn(Object... o){for(int i = 0; i< o.length; i++)out.print(o[i]+(i+1 < o.length?" ":"\n"));}
void pni(Object... o){for(Object oo:o)out.print(oo+" ");out.println();out.flush();}
 
//input methods

private int[][] ng(int n, int e, int[] from, int[] to, boolean f){
    int[][] g = new int[n+1][];int[]cnt = new int[n+1];
    for(int i = 0; i< e; i++){
        cnt[from[i]]++;
        if(f)cnt[to[i]]++;
    }
    for(int i = 0; i<= n; i++)g[i] = new int[cnt[i]];
    for(int i = 0; i< e; i++){
        g[from[i]][--cnt[from[i]]] = to[i];
        if(f)g[to[i]][--cnt[to[i]]] = from[i];
    }
    return g;
}
private int[][][] nwg(int n, int e, int[] from, int[] to, boolean f){
    int[][][] g = new int[n+1][][];int[]cnt = new int[n+1];
    for(int i = 0; i< e; i++){
        cnt[from[i]]++;
        if(f)cnt[to[i]]++;
    }
    for(int i = 0; i<= n; i++)g[i] = new int[cnt[i]][];
    for(int i = 0; i< e; i++){
        g[from[i]][--cnt[from[i]]] = new int[]{to[i], i, 0};
        if(f) g[to[i]][--cnt[to[i]]] = new int[]{from[i], i, 1};
    }
    return g;
}


private byte[] inbuf = new byte[1024];
public int lenbuf = 0, ptrbuf = 0;
 
 
private int readByte() {
    if (lenbuf == -1) throw new InputMismatchException();
    if (ptrbuf >= lenbuf) {
        ptrbuf = 0;
        try {
            lenbuf = is.read(inbuf);
        } catch (IOException e) {
            throw new InputMismatchException();
        }
        if (lenbuf <= 0) return -1;
    }
    return inbuf[ptrbuf++];
}
private boolean isSpaceChar(int c) {
    return !(c >= 33 && c <= 126);
}
private int skip() {
    int b;
    while ((b = readByte()) != -1 && isSpaceChar(b));
    return b;
}
 
private double nd() {
    return Double.parseDouble(ns());
}
private char nc() {
    return (char) skip();
}
 
private String ns() {
    int b = skip();
    StringBuilder sb = new StringBuilder();
    while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
        sb.appendCodePoint(b);
        b = readByte();
    }
    return sb.toString();
}
 
private char[] ns(int n) {
    char[] buf = new char[n];
    int b = skip(), p = 0;
    while (p < n && !(isSpaceChar(b))) {
        buf[p++] = (char) b;
        b = readByte();
    }
    return n == p ? buf : Arrays.copyOf(buf, p);
}
 
private char[][] nm(int n, int m) {
    char[][] map = new char[n][];
    for (int i = 0; i < n; i++) map[i] = ns(m);
    return map;
}
 
private int[] na(int n) {
    int[] a = new int[n];
    for (int i = 0; i < n; i++) a[i] = ni();
    return a;
}
 
private int ni() {
    int num = 0, b;
    boolean minus = false;
    while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
    if (b == '-') {
        minus = true;
        b = readByte();
    }
 
    while (true) {
        if (b >= '0' && b <= '9') {
            num = num * 10 + (b - '0');
        } else {
            return minus ? -num : num;
        }
        b = readByte();
    }
}
 
private long nl() {
    long num = 0;
    int b;
    boolean minus = false;
    while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
    if (b == '-') {
        minus = true;
        b = readByte();
    }
 
    while (true) {
        if (b >= '0' && b <= '9') {
            num = num * 10 + (b - '0');
        } else {
            return minus ? -num : num;
        }
        b = readByte();
    }
}



}


class supplement{
    private static int countDigits(long l) {
        if (l >= 1000000000000000000L) return 19;
        if (l >= 100000000000000000L) return 18;
        if (l >= 10000000000000000L) return 17;
        if (l >= 1000000000000000L) return 16;
        if (l >= 100000000000000L) return 15;
        if (l >= 10000000000000L) return 14;
        if (l >= 1000000000000L) return 13;
        if (l >= 100000000000L) return 12;
        if (l >= 10000000000L) return 11;
        if (l >= 1000000000L) return 10;
        if (l >= 100000000L) return 9;
        if (l >= 10000000L) return 8;
        if (l >= 1000000L) return 7;
        if (l >= 100000L) return 6;
        if (l >= 10000L) return 5;
        if (l >= 1000L) return 4;
        if (l >= 100L) return 3;
        if (l >= 10L) return 2;
        return 1;
    }

}
