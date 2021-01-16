import java.util.*;
public class RearrangeTheDigits {

    public static int getSmallest(String num) {
        char[] chArr = num.toCharArray();
        Arrays.sort(chArr);
        int zeroCount = 0;
        for(int i = 0; i < chArr.length; i++) {
            if(chArr[i] > '0') {
                break;
            }
            if(chArr[i] == '0') {
                zeroCount++;
            }
        }
        String ans = "", temp = "";
        for(int i = 0; i < chArr.length; i++) {
            if(chArr[i] != '0') {
                temp += "" + chArr[i];
            }
        }
        ans += temp.charAt(0);
        while(zeroCount-- > 0) {
            ans += "" + '0';
        }
        for(int i = 1; i < temp.length(); i++) {
            ans += "" + temp.charAt(i);
        }
        return Integer.parseInt(ans);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String num = "" + N;

        System.out.println(getSmallest(num));
    }
}