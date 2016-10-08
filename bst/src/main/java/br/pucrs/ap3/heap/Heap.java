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

    public static void heapfy(int v[]) {
        if (v == null)
            throw new IllegalArgumentException();
        for (int i = v.length / 2; i >= 1 ; i--) {
            downheap(i, v);

        }
    }

    private static void downheap(int i, int[] v) {
        int pe = 2 * i;
        int pd = pe + 1;
        while (pe < v.length) {
            int menor = pe; // posição do menor filho
            if (pd < v.length)
                if (v[pd] < v[pe])
                    menor = pd;
            if (v[menor] >= v[i])
                return;
            swap(v, menor, i);
            i = menor;
            pe = 2 * i;
            pd = pe + 1;
        }
    }

    private static void swap(int[] v, int a, int b) {
        int tmp = v[a];
        v[a] = v[b];
        v[b] = tmp;
    }


}
