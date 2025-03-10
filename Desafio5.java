import java.util.Scanner;

public class Desafio5 {
    public static String invertString(String s) {
        String invertedString = "";
        for (int i = s.length() - 1; i >= 0; i--) { 
            invertedString += s.charAt(i); 
        }
        return invertedString;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma string: ");
        String x = scanner.nextLine();
        scanner.close();
        
        String resultado = invertString(x);
        System.out.println("String invertida: " + resultado);
    }
}
