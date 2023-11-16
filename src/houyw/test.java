package houyw;

import houyw.common.ListNode;
import houyw.common.TreeNode;
import houyw.common.utils.TreeUtils;
import houyw.java.normal.arr.ArrSolution;
import houyw.java.normal.tree.treeSolution;
import houyw.java.single.array.ArraySolution;
import houyw.java.single.guilv.Solution;
import houyw.java.single.str.StringSolution;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: DELL
 * @Date: 2023/6/15 14:22
 * @Description:
 */
public class test {

    public static void main(String[] args) throws Exception{
        Solution solution = new Solution();
        StringSolution stringSolution = new StringSolution();
        ArraySolution arraySolution = new ArraySolution();
        ArrSolution arrs = new ArrSolution();
        treeSolution tree = new treeSolution();
        int n = 100;
        add(n);
        System.out.println(n);

    }

    public static void add(int n){
        n++;
    }

    public static int sumOfMultiples(int n) {
        int sum = 0;
        for(int i = 1;i<=n;i++){
            if(i%3==0){
                sum+=i;
            }else
            if(i%5==0){
                sum+=i;
            }else
            if(i%7==0){
                sum+=i;
            }
        }
        return sum;
    }
    public static Timestamp  getTimeFromHaveLineYYYYMMDDHHMMSS(String yyyymmddhhmmss)throws Exception{
        if(yyyymmddhhmmss==null||"".equals(yyyymmddhhmmss)){
            return null;
        }
        Timestamp time=null;
        Calendar c = Calendar.getInstance();
        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            c.setTime(format.parse(yyyymmddhhmmss));
            time=new Timestamp(c.getTimeInMillis());
        } catch (Exception e) {
            try {
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                c.setTime(format.parse(yyyymmddhhmmss));
                time=new Timestamp(c.getTimeInMillis());
            } catch (Exception e2) {
                try {
                    DateFormat format = new SimpleDateFormat("yyyy-MM");
                    c.setTime(format.parse(yyyymmddhhmmss));
                    time=new Timestamp(c.getTimeInMillis());
                } catch (Exception e3) {
                    throw e3;
                }
            }
        }
        return time;
    }

    public static Date addOrMinusDays(long ti, int i) {
        Date rtn = null;
        GregorianCalendar cal = new GregorianCalendar();
        Date date = new Date(ti);
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, i);
        rtn = cal.getTime();
        return rtn;
    }
    public static String getYYYYMMDD(Date date) {
        if (date == null) {
            return null;
        }
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        return dateformat.format(date);
    }

    public static void change(Map map){
        map.put("key", "123");
    }
    public static void add(List<String> list){
        list.add("123");
    }
    public static void change1(String ss){
        ss = "123";
    }

}
