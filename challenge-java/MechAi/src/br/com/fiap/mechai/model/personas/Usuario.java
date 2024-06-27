package br.com.fiap.mechai.model.personas;

import br.com.fiap.mechai.model.clientes.Cliente;
import br.com.fiap.mechai.model.logico.Orcamento;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private long id;
    private Cliente cliente;
    private String usuario;
    private String senha;
    private String tipo;
    private List<Orcamento> historicoOrcamento;

    public Usuario() {
    }

    public Usuario(String nome, String cpf, String telefone, String email, String usuario, String senha, String tipo) {
        this.cliente = new Cliente(nome, cpf, telefone, email);
        this.usuario = usuario;
        this.senha = senha;
        this.tipo = tipo;
        this.historicoOrcamento = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Orcamento> getHistoricoOrcamento() {
        return historicoOrcamento;
    }

    public void setHistoricoOrcamento(List<Orcamento> historicoOrcamento) {
        this.historicoOrcamento = historicoOrcamento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void addOrcamento(Orcamento orcamento) {
        if (this.historicoOrcamento == null) {
            this.historicoOrcamento = new ArrayList<>();
        }
        this.historicoOrcamento.add(orcamento);
    }
}
