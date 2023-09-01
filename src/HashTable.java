
public class HashTable {

    void hashInsert(Handle k, Elem e) {
        int home; // Home position for e
        int pos = home = h(k); // Init probe sequence
        for (int i = 1; EMPTYKEY != (HT[pos]).key(); i++) {
            if (k == HT[pos].key()) {
                println("Duplicates not allowed");
                return;
            }
            pos = (home + p(k, i)) % M; // probe
        }
        HT[pos] = e;
    }


    boolean hashSearch(Handle K, Elem e) {
        int home; // Home position for K
        int pos = home = h(K); // Initial position is the home slot
        for (int i = 1; (K != (HT[pos]).key()) && (EMPTYKEY != (HT[pos])
            .key()); i++) {
            pos = (home + p(K, i)) % M; // Next on probe sequence
        }
        if (K == (HT[pos]).key()) { // Found it
            e = HT[pos];
            return true;
        }
        else {
            return false;
        } // K not in hash table
    }


}
