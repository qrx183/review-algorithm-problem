package codetop_byte.q0519;

public class HaveConflict {
    public boolean haveConflict(String[] event1, String[] event2) {
       int s1 = getTime(event1[0]);
       int e1 = getTime(event1[1]);
       int s2 = getTime(event2[0]);
       int e2 = getTime(event2[1]);
       if(s2 >= s1 && s2 <= e1) {
           return true;
       }else if(e2 >= s1 && e2 <= e1) {
           return true;
       }else if(s1 >= s2 && s1 <= e2) {
           return true;
       }else if(e1 >= s2 && e1 <= e2) {
           return true;
       }else{
           return false;
       }

    }

    private int getTime(String event) {
        String[] events = event.split(":");
        return Integer.parseInt(events[0])*60+Integer.parseInt(events[1]);
    }


}
