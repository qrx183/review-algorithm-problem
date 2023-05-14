package codetop_byte.q0514;

public class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0,r = letters.length-1;
        while(l < r) {
            int mid = l + r >> 1;
            if(letters[mid] > target) {
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return letters[l] > target ? letters[l] : letters[0];
    }
}
