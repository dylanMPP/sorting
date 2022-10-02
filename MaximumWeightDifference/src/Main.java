import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        ArrayList<Integer> itemsWeight = new ArrayList<>();

        int testCases = reader.nextInt();
        reader.nextLine();

        for (int i = 0; i < testCases; i++) {
            itemsWeight.removeAll(itemsWeight);
            int cont = 0;
            int fatherSum = 0;
            int sonSum = 0;

            String firstLine = reader.nextLine();
            String secondLine = reader.nextLine();

            String[] firstLineToArray = firstLine.split(" ");
            String[] secondLineToArray = secondLine.split(" ");

            int n = Integer.parseInt(firstLineToArray[0]);
            int k = Integer.parseInt(firstLineToArray[1]);

            int trueK = n-k;
            int sonK = 0;

            if(trueK < k){
                sonK = trueK;
            } else {
                sonK = k;
            }

            for (int j = 0; j < secondLineToArray.length; j++) {
                itemsWeight.add(Integer.parseInt(secondLineToArray[j]));
            }

            sortIntegerArrayInsertion(itemsWeight);
            ArrayList<Integer> sonsItems = new ArrayList<>();
            ArrayList<Integer> fatherItems = new ArrayList<>();


            for (int j = 0; j < itemsWeight.size() ; j++) {

                if(cont>=sonK){
                    fatherItems.add(itemsWeight.get(j));
                } else {
                    sonsItems.add(itemsWeight.get(j));
                    cont++;
                }
            }

            for (int j = 0; j < fatherItems.size(); j++) {
                fatherSum += fatherItems.get(j);
            }

            for (int j = 0; j < sonsItems.size(); j++) {
                sonSum += sonsItems.get(j);
            }

            System.out.println(fatherSum-sonSum);
        }
    }

    private static void sortIntegerArrayInsertion(ArrayList<Integer> arrayList) {

        // El puntero rojo me va a ir hasta el final del array
        // La posición del verde va a ser el anterior al rojo, vamos a verificarlo de derecha a izquierda.
        for (int rojo = 1; rojo < arrayList.size(); rojo++) {
            int valorRojo = arrayList.get(rojo);
            int verde = rojo - 1;

            // El while se va a hacer mientras el valor del rojo sea menor al valor del verde
            // el verde disminuye cada vez -1, entonces cuando el rojo sea mayor al verde, es decir,
            // que allí debe ser reemplazado, para. Todo esto meintras el verde sea mayor a -1
            while (verde > -1 && valorRojo <= arrayList.get(verde)) {
                int valorVerde = arrayList.get(verde);
                arrayList.set(verde + 1, valorVerde);
                verde -= 1;
            }
            arrayList.set(verde + 1, valorRojo);
        }

    }
}
