import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String [] args){

        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner reader = new Scanner(System.in);

        String input = reader.next();
        String[] array = input.split("\\+");

        for (int i = 0; i < array.length; i++) {
            numbers.add((Integer.parseInt(array[i])));
        }

        sortIntegerArrayInsertion(numbers);
        String msg = "";

        for (int i = 0; i < numbers.size() ; i++) {

            if(i==numbers.size()-1){
                msg+=numbers.get(i);
            } else {
                msg += numbers.get(i)+"+";
            }
        }

        System.out.println(msg);
    }


    private static void sortIntegerArrayInsertion(ArrayList<Integer> arrayList){

        // El puntero rojo me va a ir hasta el final del array
        // La posición del verde va a ser el anterior al rojo, vamos a verificarlo de derecha a izquierda.
        for (int rojo = 1; rojo < arrayList.size(); rojo++) {
            int valorRojo = arrayList.get(rojo);
            int verde = rojo-1;

            // El while se va a hacer mientras el valor del rojo sea menor al valor del verde
            // el verde disminuye cada vez -1, entonces cuando el rojo sea mayor al verde, es decir,
            // que allí debe ser reemplazado, para. Todo esto meintras el verde sea mayor a -1
            while ( verde > -1 && valorRojo <= arrayList.get(verde)) {
                int valorVerde = arrayList.get(verde);
                arrayList.set(verde+1,valorVerde);
                verde-=1;
            }
            arrayList.set(verde+1,valorRojo);
        }
    }
}