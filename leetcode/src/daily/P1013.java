package daily;

//1013. 将数组分成和相等的三个部分
/*
* 首先我们需要找出索引 i。
* 具体地，我们从第一个元素开始遍历数组 A 并对数组中的数进行累加。
* 当累加的和等于 sum(A) / 3 时，我们就将当前的位置置为索引 i。
* 由于数组中的数有正有负，可能得到若干个索引 i0, i1, i2, ...，
* 从 A[0] 到这些索引的数之和均为 sum(A) / 3。
* 那么我们应该选取那个索引呢？直觉告诉我们，应该贪心地选择最小的那个索引 i0，这也是可以证明的
* */
public class P1013 {
    public boolean canThreePartsEqualSum(int[] A) {
        if(A.length < 3)return false;
        int sum = 0;
        for(int i:A){
            sum += i;
        }
        if(sum % 3 != 0)return false;
        int avg = sum/3;
        int cnt = 0;
        for(int i = 0; i < A.length-2; i++){
            cnt += A[i];
            if(cnt == avg){
                return canTwoPartsEqualSum(A,i+1,avg);
            }
        }
        return false;
    }
    public boolean canTwoPartsEqualSum(int[] A, int index, int avg){
        int cnt = 0;
        for(int i = index; i < A.length-1; i++){
            cnt += A[i];
            if(cnt == avg)return true;
        }
        return false;
    }
}
