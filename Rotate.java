import java.util.Arrays;

/**
 * @Author: WSS
 * @Date: 2019/3/16 18:23
 * @Description:
 *
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 */
public class Rotate {
    
    //矩阵的本质是：二维数组
    //旋转的本质是：让数组内的元素进行有规律的交换
    
    //先标记“矩阵”四个角的元素，进行3次交换，使它们位于“旋转”后的位置
    //里层for循环控制四个标记移动，逐次完成最外圈的交换
    //每完成一圈交换后，由外层for循环控制“矩阵”缩进，继而进行里面一圈的元素交换
    //最终完成矩阵的“旋转”
    
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int col = matrix[0].length-1;
        int row = matrix.length-1;

        int colF = col;
        int rowF = row;

        for (int r = 0; r < rowF ; r++) {
            for (int c = r; c < colF; c++) {
                int x1 = r;
                int y1 = c;

                int x2 = c;
                int y2 = col - r;

                int x3 = row - r;
                int y3 = col - c;

                int x4 = row - c;
                int y4 = r;

                swap(matrix, x1, y1, x2, y2);
                swap(matrix, x1, y1, x3, y3);
                swap(matrix, x1, y1, x4, y4);
            }
            rowF--;
            colF--;
        }
    }

    private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }


    //打印数组方法
    static void print(int[][] matrix){
        int j = matrix.length;
        int i = 0;
        while(i<j){
            System.out.println(Arrays.toString(matrix[i]));
            i++;
        }
    }
    public static void main(String[] args) {
        int[][] test = {{1,2,3},{4,5,6},{7,8,9}};
        print(test);
        System.out.println("旋转后的图形：");
        Rotate ro = new Rotate();
        ro.rotate(test);
        print(test);
        //输出结果：
        //[1, 2, 3]
        //[4, 5, 6]
        //[7, 8, 9]
        //旋转后的图形：
        //[7, 4, 1]
        //[8, 5, 2]
        //[9, 6, 3]
    }
}

