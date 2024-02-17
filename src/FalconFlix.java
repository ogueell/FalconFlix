import java.util.Scanner;

public class FalconFlix {

	static Scanner scanner = new Scanner(System.in);

	public static void cadastroUsuario(){

		Usuario u = new Usuario();

		System.out.println("Informe o nome de usúario: ");
		u.nome = scanner.nextLine();

		System.out.println("Informe o email: ");
		u.email = scanner.nextLine();

		System.out.println("Informe a sua data de nascimento: ");
		u.dataNascimento = scanner.nextLine();
	}

	public static void cadastroFilme( ) {
		Filme f = new Filme();

		System.out.println("Informe o nome do filme: ");
		f.nome = scanner.nextLine();

		System.out.println("Informe a duração do filme (Em minutos) :");
		f.duracao = scanner.nextShort();
		
		scanner.nextLine();
		
		System.out.println("Informe o gênero do filme: ");
		f.genero = scanner.nextLine();
	}

	public static void cadastroAtor() {

		Ator a = new Ator();

		System.out.println("Informe o nome do ator: ");
		a.nome = scanner.nextLine();

		System.out.println("Informe a data de nascimento do ator: ");
		a.dataNascimento = scanner.nextLine();
	}

	public static void mostrarMenu() {
		int opcao = 0;

		System.out.println("Bem vindo ao FalconFlix!");

		do {
			System.out.println(" 1. Cadastrar Usúario.\n 2. Cadastrar Filme.\n 3. Cadastrar Ator.\n 0. Sair.");
			opcao = scanner.nextInt();
			
			scanner.nextLine();		
			
			switch (opcao) {
			case 1:
				cadastroUsuario();
				break;
			case 2:
				cadastroFilme();
				break;
			case 3:
				cadastroAtor();
				break;
			case 0:
				System.out.println("Obrigado por usar os nossos serviços!");
				break;
			default:
				System.out.println("Opção Invalida.");
				break;
			}

		} while (opcao != 0);
	}

	public static void main(String[] args) {

		mostrarMenu();

		scanner.close();
	}
}
