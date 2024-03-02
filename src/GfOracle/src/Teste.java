import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Teste {
    
    static int opcao = 0;
    static Scanner scanner = new Scanner(System.in);
    static BufferedWriter writer;
    static File arquivo;

    public static void cadastroAtor() {
        System.out.println("Informe o nome do ator: ");
        String nome = scanner.nextLine();

        System.out.println("Informe a data de nascimento do ator: ");
        String dataNascimento = scanner.nextLine();
        
        try {
            writer.write(" Nome do ator: " + nome + ("\n Data de nascimento do ator: " + dataNascimento + "\n"));
            System.out.println("Ator cadastrado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo.");
        }
    }

    public static void pesquisarAtorNoArquivo() throws FileNotFoundException {
        if (arquivo == null) {
            System.out.println("Nenhum arquivo foi selecionado.");
            return;
        }

        System.out.println("Digite o nome do ator que deseja pesquisar: ");
        String atorPesquisado = scanner.nextLine();
        
        try {
            Scanner sc = new Scanner(arquivo);
            boolean encontrado = false;
            
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha.contains(atorPesquisado)) {
                    System.out.println("Ator encontrado: " + linha);
                    encontrado = true;
                }
            }
            
            if (!encontrado) {
                System.out.println("Ator não encontrado.");
            }
            
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        }
    }
    
    public static void mostrarMenu() throws IOException {

        System.out.println("Bem vindo ao FalconFlix!");

        do {
            System.out.println(" 1. Cadastrar Ator.\n 2. Pesquisar ator no arquivo.\n 0. Sair.");
            opcao = scanner.nextInt();
            
            scanner.nextLine();        
            
            switch (opcao) {
                case 1:
                    cadastroAtor();
                    break;
                case 2:
                    pesquisarAtorNoArquivo();
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
