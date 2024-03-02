import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class Calculadora {

	static int opcao = 0;
	static long n1 = 0;
	static long n2 = 0;
	static long resultado = 0;
	static String obs = "";
	static String entrada = "";

	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter writer;

	public static long soma() {
		System.out.println("Indique o primeiro número:");
		n1 = scanner.nextLong();

		System.out.println("Indique o segundo número:");
		n2 = scanner.nextLong();

		resultado = n1 + n2;

		System.out.println("O resultado é: " + resultado);
		return resultado;
	}

	public static long subt() {
		System.out.println("Indique o primeiro número:");
		n1 = scanner.nextLong();

		System.out.println("Indique o segundo número:");
		n2 = scanner.nextLong();

		resultado = n1 - n2;

		System.out.println("O resultado é: " + resultado);

		return resultado;
	}

	public static long mult() {
		System.out.println("Indique o primeiro número:");
		n1 = scanner.nextLong();

		System.out.println("Indique o segundo número:");
		n2 = scanner.nextLong();

		resultado = n1 * n2;

		System.out.println("O resultado é: " + resultado);

		return resultado;
	}

	public static long divi() {
	    System.out.println("Indique o primeiro número:");
	    n1 = scanner.nextLong();

	    System.out.println("Indique o segundo número:");
	    n2 = scanner.nextLong();

	    try {
	        resultado = n1 / n2;
	        System.out.println("O resultado é: " + resultado);
	    } catch (ArithmeticException e) {
	        System.out.println("Erro: Divisão por zero não é permitida.");
	        resultado = 0;
	    }

	    return resultado;
	}

	public static void observacao() {
		int countOk = 0;
		boolean sair = false; 

		System.out.println("Escreva o quanto quiser. Quando quiser voltar ao menu, apenas escreva OK duas vezes!");

		while (!sair) {
			entrada = scanner.nextLine();
			if (entrada.equalsIgnoreCase("OK")) {
				countOk++;
				if (countOk == 2) { 
					sair = true;
				}
			} else {
				countOk = 0;
				obs += entrada + "\n";
			}
		}
	}

	public static void menu(BufferedWriter writer) throws IOException {
		System.out.println("Escolha uma operação matemática:\n 1. Soma.\n 2. Subtração.\n 3. Multiplicação.\n 4. Divisão.\n 5. Observações.\n 6. Limpar arquivo.\n 0. Sair.");
		opcao = scanner.nextInt();

		switch (opcao) {
		case 1:
			soma();
			writer.write("O Resultado da soma de " + n1 + " e " + n2 + " é: " + String.valueOf(resultado));
			break;
		case 2:
			subt();
			writer.write("O Resultado da subtração de " + n1 + " e " + n2 + " é: " + String.valueOf(resultado));
			break;
		case 3:
			mult();
			writer.write("O Resultado da multiplicação de " + n1 + " e " + n2 + " é: " + String.valueOf(resultado));
			break;
		case 4:
			divi();
			if(resultado != 0) {
				writer.write("O Resultado da divisão de " + n1 + " e " + n2 + " é: " + String.valueOf(resultado));
			} else {
				writer.write("Erro: Divisão por 0 não é permitida.");
			}
			break;
		case 5:
			observacao();
			writer.write(obs); 
			break;
		case 6:
			limparArquivo();
			break;
		case 0:
			System.out.println("Obrigado por usar a Calculadora 2.0.8!");
			break;
		default:
			System.out.println("Opção Invalida.");
			break;
		}
		System.out.println("\n");
	}

	public static void limparArquivo() throws IOException {
		scanner.nextLine();
		System.out.println("Digite o nome do arquivo que deseja limpar (com a extensão .txt):");
		String nomeArquivo = scanner.nextLine();

		File arquivo = new File(nomeArquivo);
		if (!arquivo.exists()) {
			System.out.println("O arquivo especificado não existe.");
			return;
		}

		try {
			BufferedWriter limpar = new BufferedWriter(new FileWriter(arquivo));
			limpar.close();
			System.out.println("Conteúdo do arquivo \"" + nomeArquivo + "\" limpo com sucesso.");
		} catch (IOException e) {
			System.out.println("Erro ao limpar o arquivo: " + e.getMessage());
		}
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Bem-vindo(a) à Calculadora 2.0.8!");

		System.out.println("Escreva o nome do arquivo para criar um novo arquivo (Use a extensão .txt junto ao final do nome).");
		System.out.println("Caso já exista um arquivo, apenas escreva novamente o nome junto à extensão.");

		File arquivo = new File(scanner.nextLine());
		writer = new BufferedWriter(new FileWriter(arquivo, true));

		do {
			menu(writer);
			writer.newLine();
		} while (opcao != 0);

		writer.close();
		scanner.close();
	}
}
