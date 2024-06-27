package br.com.fiap.mechai.model.clientes;

import java.util.ArrayList;
import java.util.List;




public class Cliente {

    private long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private List<Endereco> enderecos;
    private List<Carro> carro;

    public Cliente() {
    }

    public Cliente(String nome, String cpf, String telefone, String email, Endereco endereco, Carro carro) {
       
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.enderecos = new ArrayList<>();
        this.carro = new ArrayList<>();
    }



    public Cliente(String nome2, String cpf2, String telefone2, String email2) {
        //TODO Auto-generated constructor stub
    }

  

    public void addEndereco(Endereco end) {
		if (this.enderecos == null) {
			this.enderecos = new ArrayList<>();
		}
		this.enderecos.add(end);
	}


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }



    public List<Carro> getCarro() {
        return carro;
    }

    public void setCarro(List<Carro> carro) {
        this.carro = carro;
    }

}
