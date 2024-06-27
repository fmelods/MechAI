package br.com.fiap.mechai.model.personas;



public class Mecanico {



   
   
    private String login;
    private String senha; 
    private String nome;
    private String dataAdmissao;
    private String dataDemissao;
    private double salario;
    private String funcao;
    
    public Mecanico() {
    }

    public Mecanico(String login, String senha,String nome, String dataAdmissao, String dataDemissao, double salario, String funcao) {
        
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.dataAdmissao = dataAdmissao;
        this.dataDemissao = dataDemissao;
        this.salario = salario;
        this.funcao = funcao;
    }

   public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(String dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }



}
