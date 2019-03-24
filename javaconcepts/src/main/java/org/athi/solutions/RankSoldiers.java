package org.athi.solutions;

/**
 * Date:   3/23/2019
 *
 * @author amuthukumarasamy
 */
/*
 *
 * Revision Date    Revised By  Description
 * ---------------------------------------------------
 *
 * ---------------------------------------------------
 */
public class RankSoldiers {
    // Function to print m Maximum elements
    public static void rankify(int A[], int n)
    {
        // Rank Vector
        float R[] = new float[n];

        // Sweep through all elements in A
        // for each element count the number
        // of less than and equal elements
        // separately in r and s
        for (int i = 0; i < n; i++) {
            int r = 1, s = 1;

            for (int j = 0; j < n; j++)
            {
                if (j != i && A[j] < A[i])
                    r += 1;

                if (j != i && A[j] == A[i])
                    s += 1;
            }

            // Use formula to obtain  rank
            R[i] = r + (float)(s - 1) / (float) 2;

        }

        for (int i = 0; i < n; i++)
            System.out.print(R[i] + "  ");

    }

    public static int rankSoldiers(int ranks[]) {
        int totalRanks=0;
        //boolean sameElem = false;
        for (int i = 0; i <= ranks.length; i++) {
            int thisElem = ranks[i];
            boolean sameElem = false;
            System.out.println("Element="+ thisElem);
            for (int j = 0; j < ranks.length; j++) {
                System.out.print (j+ "= "+ranks[j]+", ");
                if(!sameElem) {
                    int nextElem = thisElem+1;
                    if (nextElem == ranks[j])
                        totalRanks++;
                    sameElem = true;
                }
            }
            System.out.println(", ranks =" + totalRanks);
        }
        System.out.println("ranks =" + totalRanks);
        return totalRanks;
    }

    // Driver code
    public static void main(String args[])
    {
        //int A[] = {1, 2, 5, 2, 1, 25, 2};
        int A[] = {3, 4, 3, 0, 2, 2, 3, 0, 0};
        int n = A.length;

        for (int i = 0; i < n; i++)
            System.out.print(A[i] + "    ");
        System.out.println();
        //rankify(A, n);
        System.out.println("Total=" + rankSoldiers(A));
    }
}
