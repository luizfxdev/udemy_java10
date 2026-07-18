import java.util.Scanner;

public class DuracaoJogo {
    
    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {
            int horaInicial = sc.nextInt();
            int horaFinal = sc.nextInt();
            
            int duracao;
            
            if (horaFinal == horaInicial) {
                duracao = 24;
            }
            else if (horaFinal > horaInicial) {
                duracao = horaFinal - horaInicial;
            }
            else {
                duracao = 24 - horaInicial + horaFinal;
            }
            
            System.out.println("O jogo durou " + duracao + " hora(s)");
        }
    }
}
