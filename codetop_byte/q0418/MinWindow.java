package codetop_byte.q0418;

import org.junit.jupiter.api.Test;

public class MinWindow {
    public String minWindow (String S, String T) {
        // write code here
        int m = S.length();
        int n = T.length();
        if(m < n) {
            return "";
        }
        int[] count = new int[200];
        for(int i = 0; i < n; i++) {
            count[(int)T.charAt(i)]++;
        }
        int l = 0,r = 0;
        String res = "";
        int size = Integer.MAX_VALUE;
        count[(int)S.charAt(l)]--;
        while(r < m) {
            while(r+1<m && !isValid(count,T)) {
                count[(int)S.charAt(r+1)]--;
                r++;
            }
            if(r-l+1<=size && isValid(count,T)) {
                size = r-l+1;
                res = S.substring(l,r+1);
            }
            count[(int)S.charAt(l)]++;
            l++;
            if(l > r) {
                break;
            }
        }

        return res;
    }

    private boolean isValid(int[] count,String T) {
        for(int i = 0; i < T.length(); i++) {
            if(count[(int)T.charAt(i)] > 0) {
                return false;
            }
        }
        return true;
    }
    @Test
    public void show() {
        String s ="wyqaalfdtavrmkvrgbrmauenibfxrzjpzzqzlveexayjkvdsyueboloymtvfugvtgnutkyzhaztlvwdvqkwgvmejhbpdimwqbslnrkutkpehnkefwblrprcxvtaffzxitivmssgehklvwqastojihmhcfkhnlexemtrhnxlujxrgpuyiikspycufodubisfwnydaxrwhqqpfkppuzjlzlfhbjbcttkriixkiohpexgjjvafxjqyvyfyjhbccltlvsvdgeumdavoyxtvhmtekzctidxkqsxmlvrrzmefobtmznhizdmlcoemudwkvuyirscqegvsjrfkgoshrgsvvyhrbgdycehtwjlcrjucabpgsjnjqhhnfqeiwhgalptjyflpoiuqjjwdslpiswvxobfljnnwdhgdortezpulysoqddbxbwuqabdjqqhtzpxpjsvkjrvhjmzoralvzhlzkqkbgrwijvzspvcymafymfmfhaaghnfsdrvmlruuntmcqqbdqideprkxrmfbanvfeqrphnlwjxbzqcegmhnczxbslitnvotaemroadkjclksppzeyoiznlsytnopchritiyvlleqypiqgjugxeikpclipzxtgoebxcxkpdaoulecuajueretvpbkqbgwrkaooxbeaduvoaxlaifgblzwdcjtfpsxbsnrrovturokrovtycbcqcytfjomygj";
        String t = "baxtr";
        System.out.println(minWindow(s,t));

    }
}
