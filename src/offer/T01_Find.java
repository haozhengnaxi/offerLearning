package offer;

/**
 * @author TYShang
 * 二维数组中的查找
 */
public class T01_Find {
    public boolean FindLocation(int target,int[][] array) {
        if (array == null || array.length == 0)
            return false;
        int row = array.length; // 行数
        int col = array[0].length;  //列数
        for(int i = 0,j = col -1; i <= row - 1 && j >= 0) {
            if (array[i][j] == target)
                return true;
            else if (array[i][j] > target) {
                j--;
            }
            else i++;
        }
        return false;
    }
}
