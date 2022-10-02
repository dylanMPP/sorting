import java.util.*;

public class Main {

    public static void main(String[] args){

        Scanner reader = new Scanner(System.in);
        ArrayList<String> sortedStrings = new ArrayList<>();

        String guest = reader.next();
        String host = reader.next();
        String complete = reader.next();

        String[] completeArray = complete.split("");
        String[] guestArray = guest.split("");
        String[] hostArray = host.split("");

        sort_sub(completeArray, complete.length());

        int contG = 0;
        int contH = 0;

        for (int i = 0; i < guestArray.length; i++) {
            for (int j = 0; j < completeArray.length; j++) {

                if(completeArray[j]!=null && guestArray[i].equalsIgnoreCase(completeArray[j])){
                    contG++;
                    completeArray[j]=null;
                    break;
                }
            }
        }

        for (int i = 0; i < hostArray.length; i++) {
            for (int j = 0; j < completeArray.length; j++) {

                if(completeArray[j]!=null && hostArray[i].equalsIgnoreCase(completeArray[j])){
                    contH++;
                    completeArray[j]=null;
                    break;
                }
            }
        }

        if(contG+contH==completeArray.length && contG==guestArray.length && contH==hostArray.length ){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static String[] sort_sub(String array[], int f){
        String temp="";
        for(int i=0;i<f;i++){
            for(int j=i+1;j<f;j++){
                if(array[i].compareToIgnoreCase(array[j])>0){
                    temp = array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
        return array;
    }
}

