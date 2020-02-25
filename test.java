import java.util.*;

public class test {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        /*System.out.println(*/nonRepeating("bdcadb"); // should return 'c'
        /*System.out.println(*///nonRepeating("abab"); // should return null
        /*System.out.println(*///nonRepeating("aabbbc"); // should return 'c'
        /*System.out.println(*///nonRepeating("aabbdbc"); // should return 'd'
    }

    // Implement your solution below.
    public static Character nonRepeating(String s) {
        HashSet<Character> set = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++)
        {
            if(set.contains(s.charAt(i)))
                set.remove(s.charAt(i));
            else
                set.add(s.charAt(i));
        }
        if(set.isEmpty()) return null;
        else{
           //for(Character ele : set) System.out.println(ele);
           Iterator<Character> itr = set.iterator();
           while(itr.hasNext()) System.out.println(itr.next());
        }
        return null;
    }
}
