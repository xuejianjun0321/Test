package com.learn.text;

/**
 * Created by xuejianjun on 2017/6/29.
 */
public class Text {

    Text(){

    }

    public Text text = null;

    public Text buildText(){

        if (text==null){
            text = new Text();
        }

        return text;
    }

    int findIndex(int args[] ,int targe,int low ,int high){
        int mid ;
        if(low>high)
            return -1;
        mid = (low+high)/2;
        if (targe==args[mid]){
            return mid;
        }
        if (targe<args[mid]){
            return findIndex(args,targe,low,mid-1);
        }
        else {
            return findIndex(args,targe,mid+1,high);
        }

    }

    int binarySearch(int a[], int x, int low, int high) {
        int mid;
        if (low > high)
            return -1;
        mid = (low + high) / 2;
        if (x == a[mid])
            return mid;
        if (x < a[mid])
            return (binarySearch(a, x, low, mid - 1));
        else
            return (binarySearch(a, x, mid + 1, high));
    }
}



