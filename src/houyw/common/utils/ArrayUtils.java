package houyw.common.utils;

import java.util.Arrays;

/**
 * @Author: houyw
 * @Date: 2022/3/28 15:44
 * @Description:
 */
public class ArrayUtils {
    public static void print(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]);
            if(i<arr.length){
                System.out.print(",");
            }
        }
        System.out.println();
    }

    public static void print(double[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.printf("%.4f",arr[i]);
            if(i<arr.length){
                System.out.print(",");
            }
        }
        System.out.println();
    }
}
