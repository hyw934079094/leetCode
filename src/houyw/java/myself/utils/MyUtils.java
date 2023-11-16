package houyw.java.myself.utils;

import org.omg.PortableInterceptor.INACTIVE;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: DELL
 * @Date: 2022/6/21 20:57
 * @Description:
 */
@SuppressWarnings("all")
public class MyUtils {
    //字符串转二进制数

    public static int stringToNum2(String str) throws  Exception{
        if(str.length()>32){
            throw new MyException("超出32位了！！！");
        }
        while (str.length() < 32) {
            str = "0" + str;
        }
        String fuhao = str.substring(0, 1);
        str = str.substring(1,str.length() );
        int wei = 0;
        int sum = 0;
        for (int i = str.length() ; i > 0; i--) {
            try{
                int num = Integer.valueOf(str.substring(i - 1, i));
                if(num ==1){
                    sum+= Math.pow(2, wei);
                }
                wei++;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(fuhao.equals("1")){
            if(sum == 0){
                sum = Integer.MIN_VALUE;
            }else{
                sum = -sum;
            }
        }
        return sum;
    }


    public static String num10ToString(int num) throws  Exception{
        String ss = "";
        String fuhao = "0";
        if(num<0){
            if(num ==Integer.MIN_VALUE){
                return "10000000000000000000000000000000";
            }else{
                num = -num;
                fuhao ="1";
            }
        }
        while(num!=0){
            if(num%2==1){
                ss="1"+ss;
            }else{
                ss="0"+ss;
            }
            num = num>>1;
        }
        while(ss.length()<31){
            ss ="0"+ss;
        }

        return fuhao+ss;
    }
    public static  class MyException extends Exception{
        public MyException(){};
        public MyException(String msg){
            super(msg);
        };
    }

    public static Timestamp getDateOfNextMonthFirstDay(Date date) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.set(Calendar.DAY_OF_MONTH, 1);
        rightNow.set(Calendar.HOUR_OF_DAY, 0);
        rightNow.set(Calendar.MILLISECOND, 0);
        rightNow.set(Calendar.SECOND, 0);
        rightNow.set(Calendar.MINUTE, 0);
        rightNow.set(Calendar.MONTH, rightNow.get(Calendar.MONTH) + 1);
        return new Timestamp(rightNow.getTimeInMillis());
    }
}

