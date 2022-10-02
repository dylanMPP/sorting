import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> ids = new ArrayList<>();
        Scanner reader = new Scanner(System.in);

        int times = reader.nextInt();

        for (int i = 0; i < times; i++) {
            int number = Integer.parseInt(reader.next());
            ids.add(number);
        }

        sortIntegerArrayInsertion(ids);
        String msg = "";

        int pairs = 0;
        int auxNumber = 0;
        int cont0 = 0;
        boolean flag = false;

        for (int i = ids.size() - 1; i >= 0; i--) {

            auxNumber = ids.get(i);

            if (ids.get(i) == 0) {
                cont0 += 1;
            }

            if (i >= 1) {
                if (auxNumber == ids.get(i - 1)) {
                    pairs += 1;
                }

                if (auxNumber == 0) {
                    pairs -= 1;
                }
            }

            if (i >= 2) {
                if (auxNumber != 0 && auxNumber == ids.get(i - 2)) {
                    pairs = -1;
                    flag = true;
                }
            }


        }


        if (cont0 == ids.size() || cont0 == ids.size() - 1) {
            System.out.println(0);
        } else if (flag) {
            System.out.println(-1);
        } else {
            System.out.println(pairs);
        }
    }


    private static void sortIntegerArrayInsertion(ArrayList<Integer> arrayList) {

        //Elpunterorojomevaairhastaelfinaldelarray
        //Laposicióndelverdevaaserelanterioralrojo,vamosaverificarlodederechaaizquierda.
        for (int rojo = 1; rojo < arrayList.size(); rojo++) {
            int valorRojo = arrayList.get(rojo);
            int verde = rojo - 1;

//Elwhilesevaahacermientraselvalordelrojoseamenoralvalordelverde
//elverdedisminuyecadavez-1,entoncescuandoelrojoseamayoralverde,esdecir,
//queallídebeserreemplazado,para.Todoestomeintraselverdeseamayora-1
            while (verde > -1 && valorRojo <= arrayList.get(verde)) {
                int valorVerde = arrayList.get(verde);
                arrayList.set(verde + 1, valorVerde);
                verde -= 1;
            }
            arrayList.set(verde + 1, valorRojo);
        }
    }
}

