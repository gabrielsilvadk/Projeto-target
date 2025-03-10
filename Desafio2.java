
import java.util.Scanner;
public class Desafio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Informe um valor para verificação: ");
        int numero = scanner.nextInt();
        
        if (pertenceFibonacci(numero)) {
            System.out.println("O número " + numero + " ,Sim, faz parte da sequência");
        } else {
            System.out.println("O número " + numero + " não pertence à sequência");
        }
        
        scanner.close();
    }
    
    public static boolean pertenceFibonacci(int numero) {
        int a = 0;
        int b = 1;
        
        while (b < numero) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        
        return b == numero;
    }
}
