import java.util.Arrays;

/**
 * @Author: WSS
 * @Date:
 * @Description: 移除元素
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2:
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 注意这五个元素可为任意顺序。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {
    static class Solution1 {
        public int removeElement(int[] nums, int val) {
            if (nums.length == 0){
                return 0;
            }
            int i = 0;
            int count = nums.length;
            while (i<count){
                if(nums[i] == val){
                    for (int j = i;j<count-1;j++){
                        nums[j] = nums[j+1];
                    }
                    count--;
                    continue;
                }else {
                    i++;
                }
            }
            return count;
        }
    }

    //优化
    static class Solution2{
        public int removeElement(int[] nums, int val){
            int i = 0;
            for (int j = 0;j < nums.length; j++){
                if(nums[j] != val){
                    nums[i] = nums[j];
                    i++;
                }
            }
            return i;
        }
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{3,2,2,3};
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.removeElement(test1,3));// 2
        System.out.println(Arrays.toString(test1));// [2, 2, 3, 3]

        int[] test2 = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(solution1.removeElement(test2,2));// 5
        System.out.println(Arrays.toString(test2));// [0, 1, 3, 0, 4, 2, 2, 2]

        test1 = new int[]{3,2,2,3};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.removeElement(test1,3));// 2
        System.out.println(Arrays.toString(test1));// [2, 2, 2, 3]
    }
}

