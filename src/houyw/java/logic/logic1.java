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
     * 9.���Ƿֱ�����ʲô
     * С����С�ᡢС��������һ��ȥ�̳���������
     * ���Ƕ����˸�����Ҫ�Ķ�������ñ�ӣ����У�ȹ�ӣ����׵ȣ�����ÿ������Ķ�������ͬ��
     * ��һ��������������������ʲô��
     * С��˵:"��С����Ĳ������ף�С����Ĳ��Ƿ��С���
     * С��˵:��С����Ĳ��Ƿ��У�С����Ĳ���ȹ�ӡ���
     * С��˵: ��С����Ĳ���ñ�ӣ�С�������ȹ�ӡ���
     * ���������ˣ�ÿ����˵�Ļ�������һ������ģ�һ���Ǽٵġ�
     * ��ô�����Ƿֱ�����ʲô����?
     *
     *
     * ñ�ӣ����ף�ȹ��
     */



    /**
     * 1����һ����Ȼ�����ӵ��������ֿ�ʼ��ÿ�����ֶ�ǡ������ǰ����������֮�ͣ�ֱ��������дΪֹ��257��1459�ȵȣ����������ж��ٸ�?
     */
    public static int countNum(){
        //ǰ����֮�Ͳ��ܳ���10
        //��һλ������1~9,��ô�ڶ�λ������0~��9-��һλ��
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
