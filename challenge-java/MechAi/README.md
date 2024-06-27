# Sistema de Gerenciamento de Oficina Mecânica

## Descrição

Este projeto é um sistema de gerenciamento para uma oficina mecânica, desenvolvido em Java. O objetivo do sistema é facilitar o controle de orçamentos, clientes, mecânicos e serviços realizados na oficina.

## Funcionalidades

### Funcionalidades Operacionais

Atualmente, as funcionalidades totalmente operacionais no sistema são:

1. **Criação de Usuário**: Permite a criação de novos usuários no sistema.
2. **Login do Sistema**: Permite que usuários registrados façam login no sistema.

### Funcionalidades em Desenvolvimento

As demais partes do sistema ainda estão sendo implementadas conforme avançamos nas sprints do projeto. Isso inclui:

- Gerenciamento completo de orçamentos.
- Cadastro e manutenção de clientes e mecânicos.
- Registro e controle de serviços realizados.

## Teste de Orçamentos

A classe `TesteOrcamento` foi criada para testar a criação e a exibição de objetos do tipo `Orcamento`. Esta classe demonstra como instanciar objetos de orçamento, associar clientes e mecânicos a eles e imprimir seus detalhes no console.

### Exemplo de Uso

#### Passos para Criar um Usuário

1. **Execute o sistema.**
2. **Selecione a opção 2 no menu principal para criar um usuário.**
3. **Insira as informações solicitadas:**
    - Nome: `João`
    - CPF: `12345678900`
    - Telefone: `11999999999`
    - Email: `joao@example.com`
    - Usuário: `joao123`
    - Senha: `senha123`
    - Tipo: `Usuario`

O sistema criará um novo usuário e exibirá uma mensagem confirmando a criação.

```java
public static void criarUsuario(Scanner scanner) {
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
