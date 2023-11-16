package houyw.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @Author: DELL
 * @Date: 2022/4/25 15:13
 * @Description:
 */
public class TransferUtils {
    public final static int STRING_TYPE = 1;
    public final static int HANDZI_TYPE = 2;

    public  static String getStringFromTXT(String fileName){
        FileInputStream fi = null;
        InputStreamReader reader  = null;
        String s = "";
        try{
            File file = new File(fileName);
            fi = new FileInputStream(file);
            reader = new InputStreamReader(fi,"utf-8");
            char[] bts = new char[Long.valueOf(file.length()).intValue()];
            reader.read(bts, 0,bts.length);
            s = new String(bts);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                fi.close();
                reader.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return s;
    }
    public  static <T>T fileToArray(int type) {
        String fileName = "C:\\Users\\DELL\\Desktop\\lcArrays.txt";
        String s = getStringFromTXT(fileName);
        T split = null;
        if(type == 1){
            s = s.substring(1, s.lastIndexOf("]"));
            split = (T)s.replaceAll("\"", "").split(",");
        }else if (type ==2){
            String ss = s.replaceAll("\"", "");
            String s1 = ss.substring(1, ss.indexOf("]"));
            String s2 = ss.substring(ss.lastIndexOf("[")+1, ss.lastIndexOf("]"));
            String[] split1 = s1.split(",");
            String[] split2 = s2.split(",");
            String[][] strings = new String[][]{split1,split2};
            return (T)strings;
        }
        return split;
    }
}
