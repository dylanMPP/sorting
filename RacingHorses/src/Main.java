import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        int tests = Integer.parseInt(reader.next());


        for (int i = 0; i < tests; i++) {

            ArrayList<Integer> skills = new ArrayList<Integer>();

            int n = reader.nextInt();
            reader.nextLine();
            String skill = reader.nextLine();

            String[] skillsArray = skill.split(" ");

            for (int j = 0; j < n; j++) {
                skills.add(Integer.parseInt(skillsArray[j]));
            }

            sortIntegerArrayInsertion(skills);

            int min = skills.get(1)-skills.get(0);

            for (int j = 0; j < n-1; j++) {
                int number = skills.get(j+1)-skills.get(j);
                if(number < min){
                    min = number;
                }
            }

            System.out.println(min);
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

