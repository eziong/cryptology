import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner l = new Scanner(System.in);
		System.out.print("N = ");
		long n = l.nextLong();
		System.out.print("E = ");
		long e = l.nextLong();
		System.out.print("C = ");
		long c = l.nextLong();
		long m = Decrypt(n,e,c);
		System.out.println("D = " +m);
		System.out.println("C = " + Ciphertext(n,e,m));
		
	}
	public static long RSA(long n,long e) { //find D
		long[] PN = new long[2];
		for(long i=2;i<=Math.sqrt(n);i++) {
			if(n%i==0) {PN[0]=i;break;}
		}
		PN[1]=n/PN[0];
		long pq = (PN[0]-1)*(PN[1]-1);
		for(long d=2;d<n;d++) {
			long ret= (e*d)%pq;
			if(ret==1) return d;
		}
		return -1; // unusual case
	}
	public static long Decrypt(long n,long e,long c) { //find M
		long M =1;
		long d= RSA(n,e);
		for(long i=0;i<d;i++) {
			M=(M*c)%n;
		}
		return M;
	}
	public static long Ciphertext(long n,long e,long m) { //find C
		long C =1;
		for(long i=0;i<e;i++) {
			C=(C*m)%n;
		}
		return C;
	}
	/*public static long GCD(long x, long y) {
		long big, small;
		if(x>y) {big=x;small=y;}
		else {big=y;small=x;}
		while(x!=0 && y!=0) {
			long r= big - small;
			if(big%r==0 && small%r==0) return r;
			if(r>small) {big=r;}
			else {big=small; small=r;}
		}
		return -1;// unusual case
	}*/

}
