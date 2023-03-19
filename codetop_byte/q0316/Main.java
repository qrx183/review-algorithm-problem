package codetop_byte.q0316;
import java.util.*;
/*
a b c d e f g h i j k l m n o p q r s t u v w x y z
 */
public class Main {
    private static List<Character> y = new ArrayList<>();
    private static Map<Character,Character> preStr = new HashMap<>();
    private static Map<Character,Character> endStr = new HashMap<>();
    static {
        y.add('a');
        y.add('e');
        y.add('i');
        y.add('o');
        y.add('u');
        preStr.put('b','a'); endStr.put('b','c');
        preStr.put('c','a'); endStr.put('c','d');
        preStr.put('d','e'); endStr.put('d','f');
        preStr.put('f','e'); endStr.put('f','g');
        preStr.put('g','e'); endStr.put('g','h');
        preStr.put('h','i'); endStr.put('h','j');
        preStr.put('j','i'); endStr.put('j','k');
        preStr.put('k','i'); endStr.put('k','l');
        preStr.put('l','i'); endStr.put('l','m');
        preStr.put('m','o'); endStr.put('m','n');
        preStr.put('n','o'); endStr.put('n','p');
        preStr.put('p','o'); endStr.put('p','q');
        preStr.put('q','p'); endStr.put('q','r');
        preStr.put('r','o'); endStr.put('r','s');
        preStr.put('s','u'); endStr.put('s','t');
        preStr.put('t','u'); endStr.put('t','v');
        preStr.put('v','u'); endStr.put('v','w');
        preStr.put('w','u'); endStr.put('w','x');
        preStr.put('x','u'); endStr.put('x','y');
        preStr.put('y','u'); endStr.put('y','z');
        preStr.put('z','u'); endStr.put('z','z');

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        String res = "";
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (y.contains(ch)) {
                res += ch;
            }else {
                res += ch;
                res += preStr.get(ch);
                res += endStr.get(ch);
            }
        }
        System.out.println(res);
    }

}