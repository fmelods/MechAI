package br.com.fiap.mechai.model.logico;

import br.com.fiap.mechai.model.personas.Usuario;
import br.com.fiap.mechai.model.logico.Orcamento;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaOficina {

    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Orcamento> orcamentos = new ArrayList<>();

    static {
        Usuario usuario = new Usuario("Marcos", "12345678900", "11999999999", "marco@", "marcos3777", "123", "Usuario");
        usuarios.add(usuario);
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Login");
            System.out.println("2. Criar Usuário");
            System.out.println("3. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    criarUsuario(scanner);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void login(Scanner scanner) {
        System.out.print("Usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Usuario usuarioLogado = autenticarUsuario(usuario, senha);
        if (usuarioLogado != null) {
            menuLogado(scanner, usuarioLogado);
        } else {
            System.out.println("Usuário ou senha inválidos.");
        }
    }

    private static Usuario autenticarUsuario(String usuario, String senha) {
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario) && u.getSenha().equals(senha)) {
                return u;
            }
        }
        return null;
    }

    private static void menuLogado(Scanner scanner, Usuario usuarioLogado) {
        while (true) {
            System.out.println("\nMenu Usuário (" + usuarioLogado.getTipo() + "):");
            if (usuarioLogado.getTipo().equals("Usuario")) {
                System.out.println("1. Solicitar Orçamento");
                System.out.println("2. Ver Histórico de Orçamentos");
            } else if (usuarioLogado.getTipo().equals("Mecânico")) {
                System.out.println("1. Consultar Orçamentos Pendentes");
                System.out.println("2. Atualizar Orçamento");
            }
            System.out.println("3. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    if (usuarioLogado.getTipo().equals("Usuario")) {
                        solicitarOrcamento(scanner, usuarioLogado);
                    } else {
                        consultarOrcamentosPendentes(scanner);
                    }
                    break;
                case 2:
                    if (usuarioLogado.getTipo().equals("Usuario")) {
                        verHistoricoOrcamentos(usuarioLogado);
                    } else {
                        atualizarOrcamento(scanner);
                    }
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void solicitarOrcamento(Scanner scanner, Usuario usuarioLogado) {
        System.out.print("Placa do veículo: ");
        String placa = scanner.nextLine();
    
        System.out.print("Descrição do problema: ");
        String descricao = scanner.nextLine();
    
        System.out.print("Valor estimado: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Consumir quebra de linha
    
        System.out.print("Data (formato AAAA-MM-DD): ");
        String data = scanner.nextLine();
    
        long id = orcamentos.size() + 1; // Gera um ID simples baseado no tamanho da lista
    
        Orcamento orcamento = new Orcamento(id, descricao, valor, data, "Pendente", usuarioLogado.getCliente(), new ArrayList<>(), new ArrayList<>(), valor);
    
        orcamentos.add(orcamento);
        System.out.println("Orçamento solicitado com sucesso! ID do Orçamento: " + orcamento.getId());
    }

    private static void criarUsuario(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("Tipo (Usuario ou Mecânico): ");
        String tipo = scanner.nextLine();

        Usuario novoUsuario = new Usuario(nome, cpf, telefone, email, usuario, senha, tipo);
        usuarios.add(novoUsuario);
        System.out.println("Usuário criado com sucesso!");
    }

    private static void consultarOrcamentosPendentes(Scanner scanner) {
        System.out.println("Orçamentos Pendentes:");
        for (Orcamento o : orcamentos) {
            if (o.getStatus().equals("Pendente")) {
                System.out.println("ID: " + o.getId() + ", Descrição: " + o.getDescricao() + ", Cliente: " + o.getCliente().getNome());
            }
        }
    }

    private static void atualizarOrcamento(Scanner scanner) {
        System.out.print("ID do Orçamento: ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consumir quebra de linha
    
        Orcamento orcamento = null;
        for (Orcamento o : orcamentos) {
            if (o.getId() == id) {
                orcamento = o;
                break;
            }
        }
    
        if (orcamento == null) {
            System.out.println("Orçamento não encontrado!");
            return;
        }
    
        System.out.print("Novo Status: ");
        String status = scanner.nextLine();
        orcamento.setStatus(status);
        System.out.println("Orçamento atualizado com sucesso!");
    }

    private static void verHistoricoOrcamentos(Usuario usuarioLogado) {
        System.out.println("Histórico de Orçamentos:");
        for (Orcamento o : orcamentos) {
            if (o.getCliente().equals(usuarioLogado.getCliente())) {
                System.out.println("ID: " + o.getId() + ", Descrição: " + o.getDescricao() + ", Status: " + o.getStatus());
            }
        }
    }
}
