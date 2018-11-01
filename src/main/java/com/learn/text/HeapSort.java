package com.learn.text;
/**
 * Created by xuejianjun on 2017/7/11.
 */
public class HeapSort {
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] ran = new int[100];
        int[] out = heapSort.getRandomIndexArray(ran, ran.length, 5);
        print(ran);
        print(out);

    }


    public int[] getInitialArray(int numOfIndex){
        int[] indexes = new int[numOfIndex];
        for (int i = 0; i < numOfIndex; i++) {
            indexes[i] = -1;
        }
        return indexes;
    }

    public int[] getRandomIndexArray(int[] random, int mapSize, int numberOfIndex){
        int[] indexes = getInitialArray(numberOfIndex);
        for (int i = 0; i < mapSize; i++) {
            int randomNum = (int) (Math.random()*1000);
            random[i] = randomNum;
            if(i > numberOfIndex){
                insertNumIntoHeap(indexes, randomNum);
            }else if(i == numberOfIndex){
                heapSort(indexes);
            }else{
                indexes[i] = randomNum;
            }

        }

        return indexes;
    }

    public int[] insertNumIntoHeap(int[] numbers, int numToInsert){
        if(numToInsert > numbers[0]){
            numbers[0] = numToInsert;

            compareAndExchange(numbers, 0);
        }
        return numbers;
    }

    private void compareAndExchange(int[] numbers, int index) {
        int leftChildIndex = (index+1) * 2 -1;
        int rightChildIndex = leftChildIndex + 1;
        if(rightChildIndex > numbers.length){
            return;
        }else if(rightChildIndex == numbers.length){
            if(numbers[index] > numbers[leftChildIndex]){
                swap(numbers, index, leftChildIndex);
            }
        }else{
            int changeIndex = index;
            if(numbers[index] > numbers[leftChildIndex]){
                changeIndex = leftChildIndex;
            }
            if(numbers[rightChildIndex] < numbers[changeIndex]){
                changeIndex = rightChildIndex;
            }
            if(changeIndex != index){
                swap(numbers, index, changeIndex);
                compareAndExchange(numbers, changeIndex);
            }

        }

    }

    public static void swap(int[] data, int i, int j) {
        if (i == j) {
            return;
        }
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }

    public static void heapSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            createMaxdHeap(data, data.length - 1 - i);
            swap(data, 0, data.length - 1 - i);
            print(data);
        }
    }

    public static void createMaxdHeap(int[] data, int lastIndex) {
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // 保存当前正在判断的节点
            int k = i;
            // 若当前节点的子节点存在
            while (2 * k + 1 <= lastIndex) {
                // biggerIndex总是记录较大节点的值,先赋值为当前判断节点的左子节点
                int biggerIndex = 2 * k + 1;
                if (biggerIndex < lastIndex) {
                    // 若右子节点存在，否则此时biggerIndex应该等于 lastIndex
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        // 若右子节点值比左子节点值大，则biggerIndex记录的是右子节点的值
                        biggerIndex++;
                    }
                }
                if (data[k] < data[biggerIndex]) {
                    // 若当前节点值比子节点最大值小，则交换2者得值，交换后将biggerIndex值赋值给k
                    swap(data, k, biggerIndex);
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }


}
