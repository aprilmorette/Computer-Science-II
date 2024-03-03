import java.util.*;

public class Permutations<E> {
    Permutations<E> P;
    List<E> L, copy;
    E c;
    int i;
    static boolean hasNext;

    public Permutations(List<E> list) {
        if (list == null || list.isEmpty()) {
            hasNext = false;
            i = 0;
        } else {
            hasNext = true;
            L = new ArrayList<>(list);
            c = L.remove(0); 
            if (L.size() > 1) {
                P = new Permutations<>(L);  
                if (P.hasNext()) {
                    L = P.next();
                }
            }
            i = 0;
        }
    }
    public boolean hasNext() {
        return hasNext;
    }
    public List<E> next() {
        if (i > L.size()) {
            if (P != null && P.hasNext()) {
                L = P.next();
                i = 0;
            } else {
                hasNext = false;
            }
        }
        if (hasNext) {
            copy = new ArrayList<>(L);
            copy.add(i, c);
            i++;
            return copy;
        } else {
            return null;
        }
    }
    public static void main(String[] args) {
        List<Integer> test = new ArrayList<Integer>();
        test.add(0); test.add(1); test.add(2);
        Permutations<Integer> t = new Permutations<>(test);
        while(t.hasNext()) {
            List<Integer> perm = t.next();
            if (perm != null) {
                System.out.println(perm);
            }
        }
    }
}