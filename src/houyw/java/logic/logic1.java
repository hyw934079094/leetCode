package houyw.java.logic;

/**
 * @Author: DELL
 * @Date: 2023/6/16 15:53
 * @Description:
 */
public class logic1 {
    public static void main(String[] args) {
        System.out.println(countNum());
    }


    /**
     * 9.她们分别买了什么
     * 小丽、小玲、小娟三个人一起去商场里买东西。
     * 她们都买了各自需要的东西，有帽子，发夹，裙子，手套等，而且每个人买的东西还不同。
     * 有一个人问她们三个都买了什么，
     * 小丽说:"“小玲买的不是手套，小娟买的不是发夹。”
     * 小玲说:“小丽买的不是发夹，小娟买的不是裙子。”
     * 小娟说: “小丽买的不是帽子，小娟买的是裙子。”
     * 她们三个人，每个人说的话都是有一半是真的，一半是假的。
     * 那么，她们分别买了什么东西?
     *
     *
     * 帽子，手套，裙子
     */



    /**
     * 1、有一类自然数，从第三个数字开始，每个数字都恰好是他前面两个数字之和，直到不能再写为止如257，1459等等，这类数共有多少个?
     */
    public static int countNum(){
        //前两数之和不能超过10
        //第一位可以是1~9,那么第二位可以是0~（9-第一位）
        int[] arr = new int[9];
        int count = 0;
        for(int i =1;i<=9;i++){
            for(int j = 0;j<=9-i;j++){
                boolean flag = false;
                int a = i;
                int b = j;
                while(a+b<10){
                    a = a^b;
                    b = a^b;
                    a = a^b;
                    b = a+b;
                    flag = true;
                }
                if(flag){
                    count++;
                    arr[i-1]++;
                }
            }
        }
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        return count;
    }
}
