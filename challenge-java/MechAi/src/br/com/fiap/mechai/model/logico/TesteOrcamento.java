package br.com.fiap.mechai.model.logico;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.mechai.model.clientes.Carro;
import br.com.fiap.mechai.model.clientes.Cliente;

import br.com.fiap.mechai.model.clientes.Endereco;
import br.com.fiap.mechai.model.personas.Mecanico;

public class TesteOrcamento {

    public static void main(String[] args) {
        List<Orcamento> orcamentos = new ArrayList<>();

        Carro c1 = new Carro("Fiat", "Uno", "ABC-1234",  "Vermelho", 2010, "teste", "123456789");
        Carro c2 = new Carro("Fiat", "Uno", "ABC-1234",  "Vermelho", 2010, "teste", "123456789");


        Endereco e1 = new Endereco("Rua aracuai", "123", "São Paulo", "SP", "12345678", "teste");
        Endereco e2 = new Endereco("Rua aracuai", "123", "São Paulo", "SP", "12345678", "teste");
        // Criação de clientes e mecânicos para associar aos orçamentos
        Cliente cliente1 = new Cliente("João Silva", "11111111", "11122222", "falta1",e1,c1 );
        Cliente cliente2 = new Cliente("Maria Silva", "22222222", "22233333", "falta2",e1,c1);

        Mecanico mecanico1 = new Mecanico("mecanico1", "123456", "Jose Arnaldo", "04/09/1996", "atualmente", 3000, "Assistente");
        Mecanico mecanico2 = new Mecanico("mecanico2", "123456", "Jose Arnaldo", "04/09/1996", "atuante", 5000, "Senior");

        // Instanciação de orçamentos
        Orcamento orcamento1 = new Orcamento(
                1,
                "Troca de óleo",
                200.0,
                "2024-05-20",
                "Pendente",
                cliente1,
                new ArrayList<>(),
                new ArrayList<>(),
                200.0
        );
        orcamento1.addMecanico(mecanico1);

        Orcamento orcamento2 = new Orcamento(
                2,
                "Reparo no freio",
                500.0,
                "2024-05-21",
                "Pendente",
                cliente2,
                new ArrayList<>(),
                new ArrayList<>(),
                500.0
        );
        orcamento2.addMecanico(mecanico2);

        Orcamento orcamento3 = new Orcamento(
                3,
                "Alinhamento e balanceamento",
                300.0,
                "2024-05-22",
                "Pendente",
                cliente1,
                new ArrayList<>(),
                new ArrayList<>(),
                300.0
        );
        orcamento3.addMecanico(mecanico1);
        orcamento3.addMecanico(mecanico2);

        // Adicionando os orçamentos à lista
        orcamentos.add(orcamento1);
        orcamentos.add(orcamento2);
        orcamentos.add(orcamento3);

        // Exibindo os orçamentos para teste
        for (Orcamento orcamento : orcamentos) {
            System.out.println("ID: " + orcamento.getId());
            System.out.println("Descrição: " + orcamento.getDescricao());
            System.out.println("Valor: " + orcamento.getValor());
            System.out.println("Data: " + orcamento.getData());
            System.out.println("Status: " + orcamento.getStatus());
            System.out.println("Cliente: " + orcamento.getCliente().getNome());
            System.out.println("Mecânicos: ");
            for (Mecanico mecanico : orcamento.getMecanicos()) {
                System.out.println(" - " + mecanico.getLogin());
            }
            System.out.println("Valor Total: " + orcamento.getValorTotal());
            System.out.println("--------------------------");
        }
    }
}
