## 把数字转为字符串打印出来
   通常，计算机只是把一个数字对应的字符串的表示打印出来，任意的数只能用字符串表示出来，就和我们亲手写下数字一样，
   它只是一种符号，并且，对于这个问题来说完全没有意义。我们直接输入一个数字，它在底层自动会被计算机转换成字符串显示出来。这里，我想要说明的
   是一个有问题的递归方式，这是重点。
   对于这问题，刚开始是无从下手。然而基本的想法很平常，对于n=12345的数来说，我们可以先打印出1234,然后把5对应的字符打印出来;
   随后，打印1234时，先打印123,再把4对应的字符串打印出来。依次进行，如果剩下一个字符，我们可以直接把这个树对应的字符串输出，
   就完成了打印12345的任务了。想法很简单，结论却让人大开眼界，下面给出java代码。
   ```java
        char[] N= {'0','1','2','3','4','5','6','7','8','9'};
        final int UNIT=10;
        void NumberToString(int n) {
            if(n>0) {
                NumberToString(n/UNIT);
                System.out.print(N[n%UNIT]);
            }
        }
   
   ```


## 打印汉诺塔问题步骤

  ```java
    int i=0;
	void HanNuoTa(char a,char b,char c,int n) {
		if(n>0) {
			HanNuoTa(a, c, b, n-1);
			System.out.println("第"+i+++"次 "+a+"-->"+b);
			HanNuoTa(c, b, a, n-1);
		}
	}
  
  ```

## 打印出给定序列的所有排列
  
  ```java
        private <T> void swap(T[] sq, int i, int j) {
            T k = sq[i];
            sq[i] = sq[j];
            sq[j] = k;
        }

        Character[] PN = { '1', '2', '3', '4' };

        public void PaiLie(Character[] sq, int left, int right) {
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
  ```

## 爬楼梯
  ```java
        public int PaLouTi(int n) {
            if(n==1)
                return 1;
            else if(n==2)
                return 1;
            else
                return PaLouTi(n-1)+PaLouTi(n-2);
        }
  ```

## 切割刚条


## 最长公共子字符串
 ```java
        final char[] s1 = { '6', '2', '3', '4' };
        final char[] s2 = { '1', '2', '3', '4' };

        public String LCS(char[] s1, int ls1, char[] s2, int ls2) {
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
 ```

