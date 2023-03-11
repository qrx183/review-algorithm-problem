package codetop_byte.q0311;

import java.util.Objects;

public class CompareVersion {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2=  version2.split("\\.");

        int m = v1.length, n = v2.length;
        for(int i = 0; i < m; i++) {
            String str = v1[i];
            int j = 0;
            while(j < str.length() && str.charAt(j) == '0') {
                j++;
            }
            v1[i] = str.substring(j);
        }
        for (int i = 0; i < n; i++) {
            String str = v2[i];
            int j = 0;
            while(j < str.length() && str.charAt(j) == '0') {
                j++;
            }
            v2[i] = str.substring(j);
        }
        int i = 0,j = 0;
        while(i < m && j < n) {
            if (Objects.equals(v1[i], "")) {
                v1[i] = "0";
            }
            if (Objects.equals(v2[j], "")) {
                v2[j] = "0";
            }
            int num1 = Integer.parseInt(v1[i]);
            int num2 = Integer.parseInt(v2[j]);
            if (num1 < num2) {
                return -1;
            }else if (num1 > num2) {
                return 1;
            }
            i++;
            j++;
        }
        while(i < m) {
            if ((Objects.equals(v1[i], "") || Objects.equals(v1[i], "0"))){
                i++;
            }else {
                return 1;
            }
        }
        while(j < n) {
            if ((Objects.equals(v2[j], "") || Objects.equals(v2[j], "0"))){
                j++;
            }else {
                return -1;
            }
        }
        return 0;
    }
}
