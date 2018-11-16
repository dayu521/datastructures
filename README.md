# 代码依据`数据结构与算法分析c++描述`写的，使用java，如有错误，希望大家不吝指正
 * ## [二叉查找树](ss/Binarytree.java)
 ```text
基本采用递归。
插入，删除，中序遍历，查找，最小值，后继操作。
```
 * ## [堆排序](ss/heap_sort.java)
 ```text
 没什么好说的，建最大堆。采用下滤。
 需要注意的是，是从0开始下标，并且最大堆的建立是从倒数第二层，从右向左，循环再从第三层一直到第一层（根节点）
 正确性是因为假设倒数第二层开始后会有n个堆，则每一次遍历就会缩减到n/2（向上取整）个堆，最终就变成一个最大堆，
 建堆的代价为O(2n).
 ```
 * ## [插入排序](ss/insert_sort.java)
 ```text
 O(n2)算法中比较有特点的一种：对数据有序识别很好。
 ```
 * ## [希尔排序](ss/shell_sort.java)
   插入排序的改进，插入排序的特点是如果数据基本有序，其运行时间更快。希尔排序采用一个增量序列h1=1,h2,h3...hk。
   依次进行hk，h(k-1),h(k-2),..h1排序，共计k趟排序，每次排序数据更倾向于有序，因此最后一趟插入排序运行时间很短。
   具体每一趟排序过程是：对于hk,hk-1,hk-2...N-1(默认下标为0到N-1)中每一个值i，放到i-hk,i-2hk,i-3hk,...中正确
   的位置上。其编码很简单，理解稍微复杂点，不过分析倒是很难。对于数据量稍微大点，性能与复杂度很适合。
   ```text
    堆排序与希尔排序对于循环的编写很有代表性，循环的编写应该把每次迭代的不变量放到循环体中，都要以这个基准来写条件测试表达式
   ```
  * ## [快速排序](ss/quick_sort.java)
  ```text
  由于之前疏忽，采用三数取中值来获取随机的值的过程，不仅减少了最坏情况发生频率，实际更隐含了对边界的检查。
  在代码中我直接取第一个值，二没有检查边界，导致产生越界错误。
  ```
  * ## [归并排需](ss/merge_sort.java)
  ```text
   分治。通常假设有两个排序好的部分，合并到一起，就排好了。对这两个部分分别继续用同样的方式排序。
   ```
  * ## [计数排序](ss/count_sort.java)
  ```text
   如果对数据的范围作假设，比方说对于0<n<N的整数，并且内存不那么稀有的情况下。计数排序也不是原址排序，以O(n)时间复杂度排序。
  ```
  * ## [基数排序](ss/radix.java)
```text
    用二进制表示数据，然后对每一位进行排序。从小位到大的位，并且利用 计数排序 的稳定性和O(n)时间复杂度进行每一位的排序
    最终也是一个O(mn)时间复杂度的算法.
```