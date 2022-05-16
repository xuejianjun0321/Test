package com.手撕算法.牛客网;

import java.util.Scanner;
/**
 * 王强决定把年终奖用于购物，他把想买的物品分为两类：主件与附件，附件是从属于某个主件的，下表就是一些主件与附件的例子：
 * 主件	附件
 * 电脑	打印机，扫描仪
 * 书柜	图书
 * 书桌	台灯，文具
 * 工作椅	无
 * 如果要买归类为附件的物品，必须先买该附件所属的主件，且每件物品只能购买一次。
 * 每个主件可以有 0 个、 1 个或 2 个附件。附件不再有从属于自己的附件。
 * 王强查到了每件物品的价格（都是 10 元的整数倍），而他只有 N 元的预算。除此之外，他给每件物品规定了一个重要度，用整数 1 ~ 5 表示。他希望在花费不超过 N 元的前提下，使自己的满意度达到最大。
 * 满意度是指所购买的每件物品的价格与重要度的乘积的总和，假设设第ii件物品的价格为v[i]v[i]，重要度为w[i]w[i]，共选中了kk件物品，编号依次为j_1,j_2,...,j_kj
  v[j1]*w[j_1]+v[j_2]*w[j_2]+ … +v[j_k]*w[j_k]v[j1]∗w[j1]+v[j2]∗w[j 2]+…+v[jk]∗w[jk]
 * 请你帮助王强计算可获得的最大的满意度。
 *
 *
 * 输入描述：
 * 输入的第 1 行，为两个正整数N，m，用一个空格隔开：
 *
 * （其中 N （ N<32000 ）表示总钱数， m （m <60 ）为可购买的物品的个数。）
 *
 *
 * 从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q
 *
 *
 * （其中 v 表示该物品的价格（ v<10000 ）， p 表示该物品的重要度（ 1 ~ 5 ）， q 表示该物品是主件还是附件。如果 q=0 ，表示该物品为主件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号）
 *
 *
 *
 *
 * 输出描述：
 *  输出一个正整数，为张强可以获得的最大的满意度。
 */
public class 购物单 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int n = sc.nextInt();
        if(n<=0||money<=0) System.out.println(0);

        good[] Gs = new good[n+1];
        for (int i = 1; i <= n; i++) {
            int v = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            Gs[i] = new good(v,p,q);

            if(q>0){
                if(Gs[q].a1==0){
                    Gs[q].setA1(i);
                }else {
                    Gs[q].setA2(i);
                }
            }
        }

        int[][] dp = new int[n+1][money+1];
        for (int i = 1; i <= n; i++) {
            int v=0,v1=0,v2=0,v3=0,tempdp=0,tempdp1=0,tempdp2=0,tempdp3=0;

            v = Gs[i].v;

            tempdp = Gs[i].p*v; //只有主件

            if(Gs[i].a1!=0){//主件加附件1
                v1 = Gs[Gs[i].a1].v+v;
                tempdp1 = tempdp + Gs[Gs[i].a1].v*Gs[Gs[i].a1].p;
            }

            if(Gs[i].a2!=0){//主件加附件2
                v2 = Gs[Gs[i].a2].v+v;
                tempdp2 = tempdp + Gs[Gs[i].a2].v*Gs[Gs[i].a2].p;
            }

            if(Gs[i].a1!=0&&Gs[i].a2!=0){//主件加附件1和附件2
                v3 = Gs[Gs[i].a1].v+Gs[Gs[i].a2].v+v;
                tempdp3 = tempdp + Gs[Gs[i].a1].v*Gs[Gs[i].a1].p + Gs[Gs[i].a2].v*Gs[Gs[i].a2].p;
            }

            for(int j=1; j<=money; j++){
                if(Gs[i].q > 0) {   //当物品i是附件时,相当于跳过
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                    if(j>=v&&v!=0) dp[i][j] = Math.max(dp[i][j],dp[i-1][j-v]+tempdp);
                    if(j>=v1&&v1!=0) dp[i][j] = Math.max(dp[i][j],dp[i-1][j-v1]+tempdp1);
                    if(j>=v2&&v2!=0) dp[i][j] = Math.max(dp[i][j],dp[i-1][j-v2]+tempdp2);
                    if(j>=v3&&v3!=0) dp[i][j] = Math.max(dp[i][j],dp[i-1][j-v3]+tempdp3);
                }
            }
        }
        System.out.println(dp[n][money]);


    }


    /**
     * 定义物品类
     */
    private static class good{
        public int v;  //物品的价格
        public int p;  //物品的重要度
        public int q;  //物品的主附件ID

        public int a1=0;   //附件1ID
        public int a2=0;   //附件2ID

        public good(int v, int p, int q) {
            this.v = v;
            this.p = p;
            this.q = q;
        }

        public void setA1(int a1) {
            this.a1 = a1;
        }

        public void setA2(int a2) {
            this.a2 = a2;
        }
    }
}
