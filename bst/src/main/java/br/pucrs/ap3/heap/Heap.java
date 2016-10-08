package br.pucrs.ap3.heap;

/**
 * Created by 10067320 on 10/7/16.
 */
public class Heap {
    /**
     * Determina se um vetor é um MinHeap.
     *
     */
    public static boolean isMinHeap(int v[]) {
        if (v == null)
            throw new IllegalArgumentException();
        for (int i = 1; i < v.length / 2; i++) {
            int pe = 2 * i;
            int pd = pe + 1;
            //if (pe < v.length)
            if (v[pe] < v[i])
                return false;
            if (pd < v.length)
                if (v[pd] < v[i])
                    return false;
        }
        return true;
    }
}
