//Re-arrange the formula to get a_i-i=a_j-j. Then you know the drill!!

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
    if (this.y > p.y) {
        return -1;
    } else if(this.y==p.y){
        return 0;

    }
    else{
        return 1;
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
int[] primes = new int[1000001];
long M = 1000000007;
void sieve() {
    Arrays.fill(primes, 1);
    for (int i = 2; i < 1000001; i++) {
        if (primes[i] == 1) {
            primes[i] = 0;
        }
        for (int j = 2 * i; j < 1000001; j += i) {
            primes[j] = 0;
        }
    }
}
long[] fact = new long[1000001];
static long[] factorialNumInverse = new long[1000001];
    static long[] naturalNumInverse = new long[1000001];
void factorial() {
    fact[0] = 1;
    for (int i = 1; i < 1000001; i++) {
        fact[i] = (fact[i - 1]%M * i%M)%M;
    }

}
long ncr(int n, int r) {
    if(r>n)
    return 0L;
    long deno=((fact[r]%M) *(fact[n-r]%M)%M)%M;
    // return (fact[n]%M)*modInverse(deno, M) ;
    return (fact[n]*((modInverse(fact[r], M)%M)*(modInverse(fact[n-r], M)%M))%M)%M;
}

 
// Returns factorial of n




void swap(int arr[],int i,int j){
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
}
void solve() throws Exception {
    // Scanner sc=new Scanner(System.in);
    int t=ni();
    factorial();
    // pn("2c2 = "+ncr(2, 2));
    ab:while(t-->0){
        int n=ni();
        int arr[]=na(n);
        for(int i=0;i<n;i++){
            arr[i]=arr[i]-i;
        }
        long sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int val=map.getOrDefault(arr[i], 0);
            sum+=val;
            map.put(arr[i],val+1);

        }
        
        //Traverse Hashmap
        // for(Map.Entry<Integer,Integer> entry:map.entrySet()){
        //     if(entry.getValue()>1){
        //         // pn("Value = "+entry.getValue());
        //         int val=entry.getValue();
        //         sum+=ncr(val, 2);
        //     }
            
        // }
        // pn(Arrays.toString(arr));
        pn(sum);
    }
    
}
int lower_bound(int array[], int key)
    {
        // Initialize starting index and
        // ending index
        int low = 0, high = array.length;
        int mid;
 
        // Till high does not crosses low
        while (low < high) {
 
            // Find the index of the middle element
            mid = low + (high - low) / 2;
 
            // If key is less than or equal
            // to array[mid], then find in
            // left subarray
            if (key <= array[mid]) {
                high = mid;
            }
 
            // If key is greater than array[mid],
            // then find in right subarray
            else {
 
                low = mid + 1;
            }
        }
 
        // If key is greater than last element which is
        // array[n-1] then lower bound
        // does not exists in the array
        if (low < array.length && array[low] < key) {
            low++;
        }
 
        // Returning the lower_bound index
        return low;
    }
  
    long power(long x, long y, long p) {
        long res = 1;
        x = x % p;

        while (y > 0) {
            if (y % 2 == 1) {
                res = (res * x) % p;
            }

            y = y >> 1;
            x = (x * x) % p;
        }

        return res;
    }
 long modInverse(long n, long p) {
        return power(n, p - 2, p);
    }


class Pair{
    int first,second;
    Pair(int a,int b){
        first=a;
        second=b;
    }
}

long pow(long a, long b) {
    long result = 1;
    while (b > 0) {
        if (b % 2 == 1) result = (result * a) % M;
        b /= 2;
        a = (a * a) % M;
    }
    return result;
}
long gcd(long a, long b) {
    if (b == 0)
        return a;
    return gcd(b, a % b);
}
int countDigits(long l) {
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
 
