package codetop_byte.q0515;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        boolean[] isV = new boolean[26];
        int[] cnts = new int[26];
        int n = s.length();
        for(int i = 0; i < n; i++) {
            cnts[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(!isV[ch-'a']){
                while(sb.length() > 0 && sb.charAt(sb.length()-1) > ch) {
                    if(cnts[sb.charAt(sb.length()-1)-'a'] > 0) {
                        isV[sb.charAt(sb.length()-1)-'a'] = false;
                        sb.deleteCharAt(sb.length()-1);
                    }else{
                        break;
                    }

                }
                sb.append(ch);
                isV[ch-'a'] = true;
            }
            cnts[ch-'a']-=1;
        }
        return sb.toString();
    }
}
