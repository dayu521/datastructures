 
package ss;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;


class tongpeifu {
	
	public static char[] N= {'0','1','2','3','4','5','6','7','8','9'};
	public static final int UNIT=10;
	public static void NumberToString(int n) {
		if(n>0) {
			NumberToString(n/UNIT);
			System.out.print(N[n%UNIT]);
		}
	}
	public static int i=0;
	
	public static void HanNuoTa(char a,char b,char c,int n) {
		if(n>0) {
			HanNuoTa(a, c, b, n-1);
			System.out.println("第"+i+++"次 "+a+"-->"+b);
			HanNuoTa(c, b, a, n-1);
		}
	}
	
	private static <T> void swap(T[] sq, int i, int j) {
		T k = sq[i];
		sq[i] = sq[j];
		sq[j] = k;
	}

	public static Character[] PN = { '1', '2', '3', '4' };

	public static void PaiLie(Character[] sq, int left, int right) {
		if (left == right)
			System.out.println(Arrays.toString(sq));
		else {
			for (int i = left; i <= right; i++) {
				swap(sq, left, i);
				PaiLie(sq, left + 1, right);
				swap(sq, left, i);
			}
		}
	}
	
	public static int PaLouTi(int n) {
		if(n==1)
			return 1;
		else if(n==2)
			return 1;
		else
			return PaLouTi(n-1)+PaLouTi(n-2);
	}
	
	public static final char[] s1 = { '6', '2', '3', '4' };
	public static final char[] s2 = { '1', '2', '3', '4' };

	public static String LCS(char[] s1, int ls1, char[] s2, int ls2) {
		if (ls1 < 0 || ls2 < 0)
			return "";
		if (s1[ls1] == s2[ls2])
			return LCS(s1, ls1 - 1, s2, ls2 - 1) + s1[ls1];
		else {
			String a1 = LCS(s1, ls1, s2, ls2 - 1);
			String a2 = LCS(s1, ls1 - 1, s2, ls2);
			return a1.length() > a2.length() ? a1 : a2;
		}
	}

	public void static main(String[] s) {
		NumberToString(2544);
		System.out.println("===============");
		HanNuoTa('a', 'b', 'c', 3);
		System.out.println("===============");
		PaiLie(PN, 0, PN.length-1);
		System.out.println("===============");
		System.out.println(PaLouTi(6));
		System.out.println("===============");
		System.out.println(LCS(s1,s1.length-1,s2,s2.length-1));
	}

}
