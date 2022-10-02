import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner reader = new Scanner(System.in);


        int t = reader.nextInt();
        while (t-- > 0) {
            int n = reader.nextInt();
            int k = reader.nextInt();

            ArrayList<Integer> a = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                a.add(reader.nextInt());
            }

            divideArrayElements(a,0,a.size()-1);

            long sum = a.get(a.size()-1);
            for (int i = n - 2; i >= 0 && k > 0; i--) {
                sum += a.get(i);
                k--;
            }
            System.out.println(sum);
        }
    }

    // MERGE
    public static void divideArrayElements(ArrayList<Integer> arrayToSort, int indexStart, int indexEnd) {

        if (indexStart < indexEnd && (indexEnd - indexStart) >= 1) {
            int middleElement = (indexEnd + indexStart) / 2;

            divideArrayElements(arrayToSort, indexStart, middleElement);
            divideArrayElements(arrayToSort, middleElement + 1, indexEnd);

            mergeArrayElements(arrayToSort, indexStart, middleElement, indexEnd);
        }
    }

    public static void mergeArrayElements(ArrayList<Integer> arrayToSort, int indexStart, int indexMiddle, int indexEnd) {

        ArrayList<Integer> tempArray = new ArrayList<>();

        int getLeftIndex = indexStart;
        int getRightIndex = indexMiddle + 1;

        while (getLeftIndex <= indexMiddle && getRightIndex <= indexEnd) {

            if (arrayToSort.get(getLeftIndex) <= arrayToSort.get(getRightIndex)) {

                tempArray.add(arrayToSort.get(getLeftIndex));
                getLeftIndex++;

            } else {

                tempArray.add(arrayToSort.get(getRightIndex));
                getRightIndex++;

            }
        }

        while (getLeftIndex <= indexMiddle) {
            tempArray.add(arrayToSort.get(getLeftIndex));
            getLeftIndex++;
        }

        while (getRightIndex <= indexEnd) {
            tempArray.add(arrayToSort.get(getRightIndex));
            getRightIndex++;
        }


        for (int i = 0; i < tempArray.size(); indexStart++) {
            arrayToSort.set(indexStart, tempArray.get(i++));

        }

    }
    // MERGE
}
