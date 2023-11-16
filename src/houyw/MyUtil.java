package houyw;

/**
 * @Author: DELL
 * @Date: 2023/11/2 10:47
 * @Description:
 */
public class MyUtil {

    public static void transferLowerToUp(String str){
        String newStr = "";
        int length = str.length();
        for(int i = 0;i<length;i++){
           String s = String.valueOf(str.charAt(i));
           String ss = s.toUpperCase();
           newStr +=ss;
        }
        System.out.println(newStr);
    }

    public static void main(String[] args) {
        transferLowerToUp("OI_QueryShelfOffers");
        transferLowerToUp("OI_GetOfferRelatOffer");
        transferLowerToUp("OI_SubmitRailwayServiceAccessOrder");
        transferLowerToUp("OI_SubmitGroupRailwayServiceAccessOrder");
    }
}
