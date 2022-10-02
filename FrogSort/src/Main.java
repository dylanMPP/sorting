import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        int tests = reader.nextInt();

        for (int i = 0; i < tests; i++) {

            int n = reader.nextInt();
            Integer[] weightsList = new Integer[n];
            Integer[] jumpsList = new Integer[n];

            reader.nextLine();
            String[] weights = reader.nextLine().split(" ");
            String[] jumps = reader.nextLine().split(" ");


            for (int j = 0; j < n; j++) {
                weightsList[j] = (Integer.parseInt(weights[j]));
                jumpsList[j] = (Integer.parseInt(jumps[j]));
            }

            int ans1 = solve(n,weightsList,jumpsList);
            System.out.println(ans1);

        }
    }

        public static int solve(int n, Integer[] weightList, Integer[] jumpsList)
        {
            int ans1 = 0;
            int prev = -1;
            int[] tempW = new int[n];
            boolean[] verify = new boolean[n];

            for(int i=0; i<n; i++) {
                // lleno mi temp weight de todos los weight
                tempW[i] = weightList[i];
            }

            // ordeno mi temp weight
            sort(tempW, 0, tempW.length-1);

            for(int i=0; i<n; i++) {
                // Si el menor weight del temp es igual al valor en posición i de weight, el verify en esa posición
                // cambia a true y el prev a la posición

                // Si o si lo va a encontrar en el weight list, solo que necesito su posición para colocarlo como prev y
                // verificarlo
                if(tempW[0]==weightList[i])
                {
                    verify[i] = true;
                    prev = i;
                    break;
                }
            }

            for(int i=1; i<n; i++) {
                int k = 0;

                while(k<n) {
                    // k es la posición del primer verificado que está ordenado


                    // Si esa posición no ha sido verificada y justo esa posición de weight list está donde debe estar
                    // es decir, está ordenada, entonces la verifico y rompo el while para seguir (esto se repite tantas veces
                    // hayan frogs) hasta n
                    if(!verify[k] && weightList[k]==tempW[i]) {
                        verify[k] = true;
                        break;
                    }
                    k+=1;
                }

                // Si k es menor o igual al prev (prev es la posición donde se encuentra el weight menor en la lista de weights
                // desordenados)
                if(k<=prev) {
                    int jumps = k;
                    while (jumps <= prev) {
                        jumps += jumpsList[k];
                        ans1 += 1;
                    }
                    prev = jumps;


                } else {
                    prev = k;
                }
            }

            return ans1;
        }


    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public static void sort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}
