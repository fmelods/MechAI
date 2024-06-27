package br.com.fiap.mechai.model.logico;

import java.util.ArrayList;
import java.util.List;
import br.com.fiap.mechai.model.clientes.Cliente;
import br.com.fiap.mechai.model.personas.Mecanico;

public class Orcamento {

    private long id;
    private String descricao;
    private double valor;
    private String data;
    private String status;
    private Cliente cliente;
    private List<Mecanico> mecanicos;
    private List<Servico> servicos;
    private double valorTotal;

    public Orcamento() {
    }

    public Orcamento(long id, String descricao, double valor, String data, String status, Cliente cliente, List<Mecanico> mecanicos, List<Servico> servicos, double valorTotal) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.status = status;
        this.cliente = cliente;
        this.mecanicos = mecanicos;
        this.servicos = servicos;
        this.valorTotal = valorTotal;
    }

    // Getters e Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Mecanico> getMecanicos() {
        return mecanicos;
    }

    public void setMecanicos(List<Mecanico> mecanicos) {
        this.mecanicos = mecanicos;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void addMecanico(Mecanico mecanico) {
        if (this.mecanicos == null) {
            this.mecanicos = new ArrayList<>();
        }
        this.mecanicos.add(mecanico);
    }

    public void addServico(Servico servico) {
        if (this.servicos == null) {
            this.servicos = new ArrayList<>();
        }
        this.servicos.add(servico);
    }
}
