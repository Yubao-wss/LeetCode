import java.util.HashSet;

/**
 * @Author: WSS
 * @Date: 2019/3/22 22:36
 * @Description: 快乐数
 *
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例:
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 */
//HashSet+求和函数
class Solution1 {
    public boolean isHappy(int n) {
        int key = n;
        HashSet<Integer> hashSet = new HashSet<Integer>();
        while (key != 1){
            key = getSum(key);
            if (hashSet.contains(key)){
                System.out.println(key+" ");
                return false;
            }else {
                hashSet.add(key);
                System.out.print(key+" ");
            }
        }
        return true;
    }
    //求每位数的平方和
    private int getSum(int n){
        int sum = 0;
        while(n >= 1){
            sum += (n%10)*(n%10);
            n = n/10;
        }
        return sum;
    }
}
public class IsHappy {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.isHappy(123456789));// 结果：108 65 61 37 58 89 145 42 20 4 16 37 false
        System.out.println(solution1.isHappy(333));// 结果：27 53 34 25 29 85 89 145 42 20 4 16 37 58 89 false
        System.out.println(solution1.isHappy(19));// 结果：82 68 100 1 true
        /*
            不要被吓到，仔细思考就可以想到：非快乐数在不断的递归计算中的返回值必然会与之前的某个返回值相等，然后陷入死循环
            耐心研究就可以发现：所有不快乐数的数位平方和计算，最後都会进入 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4 的循环中
        */
    }
}
