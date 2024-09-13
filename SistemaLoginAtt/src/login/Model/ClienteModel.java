package login.Model;

import java.util.Date;

public class ClienteModel {
    private int codigo;
    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private Date dtNascimento;
    
    // Construtor com todos os parâmetros
    public ClienteModel(int codigo, String nome, String cpf, String email, String endereco, Date dtNascimento) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.dtNascimento = dtNascimento;
    }

    // Construtor sem o código (para uso geral)
    public ClienteModel(String nome, String cpf, String email, String endereco, Date dtNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.dtNascimento = dtNascimento;
    }
    
    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
}
