
import java.util.Scanner;

public class Dado {
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	int opcao = 0;
		
	System.out.println("Bem vindo ao dado de Journey Emotion!");
	
	do {
		System.out.println(" 1. Girar dado.\n 0. Sair.");
		switch (opcao = scanner.nextInt()) {
		case 1:
			int randomNumber = (int) (Math.random() * 12) + 1;
			 System.out.println(randomNumber);
			break;
		case 0:
			System.out.println("Obrigado por usar os nossos serviços!");
			break;
		default:
			System.out.println("Opção Invalida!");
			break;
		}
		
	} while (opcao != 0);
	
	
	scanner.close();
	}
}
