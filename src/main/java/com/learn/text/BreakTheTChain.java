package com.learn.text;



/**
 * Created by xuejianjun on 2017/7/11.
 */
public class BreakTheTChain {

    public static int breakchain(int a[], int n){

        int p = 0;
        int q = 0;
        int size = a.length;
        Integer min = Integer.MAX_VALUE;
        for (int i=1;i<=size;i++){
            p =i;
            for(int j =0;j<=size;j++){
                q=i+j;
                if (q-p>1 && q<size-1){

                    //System.out.println(p+","+q);
                    if (a[p]+a[q]< min)
                    min = a[p]+a[q];
                    //System.out.println(min);
                }

            }

        }

        return min;
    }

    public static void main(String[] args) {

        int[] data = new int[] { 5, 2,4,6,3,7 };

        int mix = breakchain(data,6);
        System.out.println(mix);
    }
}



