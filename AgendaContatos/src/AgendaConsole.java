import AgendaContato.Contato;
import agendacontatos.ContatoManager;
import java.util.List;
import java.util.Scanner;

public class AgendaConsole {
    private static ContatoManager manager = new ContatoManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();  
            switch (opcao) {
                case 1: adicionarContato(); break;
                case 2: listarContatos(); break;
                case 3: editarContato(); break;
                case 4: removerContato(); break;
                case 5: System.out.println("Saindo..."); break;
                default: System.out.println("Opção inválida!"); break;
            }
        } while (opcao != 5);
    }

    private static void exibirMenu() {
        System.out.println("=== Agenda de Contatos ===");
        System.out.println("1 - Adicionar Contato");
        System.out.println("2 - Listar Contatos");
        System.out.println("3 - Editar Contato");
        System.out.println("4 - Remover Contato");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarContato() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Contato contato = new Contato(nome, telefone, email);
        manager.adicionarContato(contato);
        System.out.println("Contato adicionado!");
    }

    private static void listarContatos() {
        List<Contato> contatos = manager.listarContatos();
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
        } else {
            contatos.forEach((c) -> {
                System.out.println(c);
            });
        }
    }

    private static void editarContato() {
        System.out.print("Informe o nome do contato a ser editado: ");
        String nome = scanner.nextLine();
        Contato contato = manager.buscarContato(nome);
        if (contato != null) {
            System.out.print("Novo Telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Novo Email: ");
            String email = scanner.nextLine();
            manager.editarContato(nome, telefone, email);
            System.out.println("Contato editado!");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    private static void removerContato() {
        System.out.print("Informe o nome do contato a ser removido: ");
        String nome = scanner.nextLine();
        manager.removerContato(nome);
        System.out.println("Contato removido.");
    }
}
