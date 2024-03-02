import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FalconFlix {
	
	static Usuario u;
	static Filme f;
	static Ator a;
	
	static int opcao = 0;

	static Scanner scanner = new Scanner(System.in);
	
	static BufferedWriter writer;
	
	static File arquivo;

	public static void cadastroUsuario(){

		u = new Usuario();

		System.out.println("Informe o nome de usúario: ");
		u.nome = scanner.nextLine();

		System.out.println("Informe o email: ");
		u.email = scanner.nextLine();

		System.out.println("Informe a sua data de nascimento: ");
		u.dataNascimento = scanner.nextLine();
		
		System.out.println("Usúario cadastrado com sucesso!");
	}

	public static void cadastroFilme( ) {
		f = new Filme();

		System.out.println("Informe o nome do filme: ");
		f.nome = scanner.nextLine();

		System.out.println("Informe a duração do filme (Em minutos) :");
		f.duracao = scanner.nextShort();
		
		scanner.nextLine();
		
		System.out.println("Informe o gênero do filme: ");
		f.genero = scanner.nextLine();
		
		System.out.println("Filme cadastrado com sucesso!");
	}

	public static void cadastroAtor() {

		a = new Ator();

		System.out.println("Informe o nome do ator: ");
		a.nome = scanner.nextLine();

		System.out.println("Informe a data de nascimento do ator: ");
		a.dataNascimento = scanner.nextLine();
		
		System.out.println("Ator cadastrado com sucesso!");
	}

	public static void visualizarArquivo() throws FileNotFoundException {

			System.out.println(arquivo);
	}
	
	public static void mostrarMenu() throws IOException {

		System.out.println("Bem vindo ao FalconFlix!");

		do {
			System.out.println(" 1. Cadastrar Usúario.\n 2. Cadastrar Filme.\n 3. Cadastrar Ator.\n 4. Visualizar Arquivo\n 0. Sair.");
			opcao = scanner.nextInt();
			
			scanner.nextLine();		
			
			switch (opcao) {
			case 1:
				cadastroUsuario();
				writer.write(" Nome de usúario: " + u.nome + "\n Email do usúario: " + u.email + "\n Data de nascimento do usúario: " + u.dataNascimento + "\n");
				break;
			case 2:
				cadastroFilme();
				writer.write(" Nome do filme: " + f.nome + "\n Duração do filme: " + f.duracao + ("\n Gênero do filme: " + f.genero + "\n"));
				break;
			case 3:
				cadastroAtor();
				writer.write(" Nome do ator: " + a.nome + ("\n Data de nascimento do ator: " + a.dataNascimento + "\n"));
				break;
			case 4:
				visualizarArquivo();
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
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Digite o nome do arquivo com a extensão '.txt'.");
		
		arquivo = new File(scanner.nextLine()); 
		writer = new BufferedWriter(new FileWriter(arquivo, true));
		
		do {
			mostrarMenu();
			
			writer.flush();
			
			writer.newLine();
		} while (opcao != 0);
		
		writer.close();
		scanner.close();
	}
}
