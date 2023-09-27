package huawei;


import java.util.PriorityQueue;

class T1 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(arr,2));


        //扩展，无序数组找中位数
        int len = arr.length;
        int k = len/2;
        if (len%2 == 0){
            System.out.println( (findKthLargest(arr,k) + findKthLargest(arr,k + 1)) /2  );
        }else {
            System.out.println( (findKthLargest(arr,k + 1) ));
        }
    }

    /*
    **
     * @description:  将数组存入堆，在存入的时候就维护
     * @param: nums
    k
     * @return: int
     * @author chopper
     * @date: 2023/2/13 14:56
     */
    public static double findKthLargest(int[] nums, int k) {
        //java默认最小堆，C++默认最大堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();//升序排列
        //将数组存入堆，在存入的时候就维护
        for(int num:nums){
            queue.add(num);
            if(queue.size() > k){
                queue.remove();
            }
        }
        return queue.remove();
    }



}