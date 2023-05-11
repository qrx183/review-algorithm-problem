package codetop_byte.q0511;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class AccountsMerge {
    // 并查集:什么需要合并什么就是并查集的元素
    int[] fa;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
      int n = accounts.size();
      Map<String,Integer> emailToIndex = new HashMap<>();
      Map<String,String> emailToName = new HashMap<>();
      int emailCnt = 0;
      for(List<String> account : accounts) {
          String name = account.get(0);
          for(int i = 1; i < account.size(); i++) {
              if(!emailToIndex.containsKey(account.get(i))) {
                  emailToIndex.put(account.get(i),emailCnt++);
              }
              emailToName.put(account.get(i),name);
          }
      }
      fa = new int[emailCnt];
      for(int i = 0; i < emailCnt; i++) {
          fa[i] = i;
      }
      for(List<String> account : accounts) {
          int first = emailToIndex.get(account.get(1));
          for(int i = 2; i < account.size(); i++) {
              int second = emailToIndex.get(account.get(i));
              union(first,second);
          }
      }

      Map<Integer,List<String>> indexToEmails = new HashMap<>();

      for(String email : emailToIndex.keySet()) {
          int index = find(emailToIndex.get(email));
          List<String> l = indexToEmails.getOrDefault(index,new ArrayList<>());
          l.add(email);
          indexToEmails.put(index,l);
      }

      List<List<String>> res = new ArrayList<>();

      for(List<String> l : indexToEmails.values()) {
          Collections.sort(l);
          List<String> ll = new ArrayList<>();
          ll.add(emailToName.get(l.get(0)));
          ll.addAll(l);
          res.add(ll);
      }
        return res;

    }

    private int find(int x) {
        if(x != fa[x]) {
            fa[x] = find(fa[x]);
        }
        return fa[x];
    }
    private void union(int x,int y){
        fa[find(x)] = find(y);
    }
    @Test
    public void show() {


        List<List<String>> l = new ArrayList<>();
        String[] s = new String[]{"Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"};
        l.add(Arrays.asList(s));
        s = new String[]{"Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"};
        l.add(Arrays.asList(s));
        s = new String[]{"Kevin","Kevin2@m.co","Kevin2@m.co","Kevin4@m.co"};
        l.add(Arrays.asList(s));
        System.out.println(
                accountsMerge(l)
        );
    }
}
