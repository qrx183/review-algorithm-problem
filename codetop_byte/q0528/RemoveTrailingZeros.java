package codetop_byte.q0528;

public class RemoveTrailingZeros {
    public String removeTrailingZeros(String num) {
        int n = num.length();
        int r = n-1;
        while(r > 0 && num.charAt(r) == '0') {
            r--;
        }
        if (r < 0) {
            return "";
        }
        return num.substring(0,r+1);
    }
}
