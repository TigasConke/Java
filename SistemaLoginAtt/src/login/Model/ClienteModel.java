package login.Model;

import java.util.Date;

public class ClienteModel {
    
    private int codigo;
    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private Date dtNascimento;
    
    public ClienteModel(int codigo, String nome, String cpf, String email, String endereco, Date dtNascimento) {
        
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.dtNascimento = dtNascimento;
        
    }

    public ClienteModel(String nome, String cpf, String email, String endereco, Date dtNascimento) {
        
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.dtNascimento = dtNascimento;
        
    }
    
    public int getCodigo() {
        
        return codigo;
        
    }
    
    }

    public String getCpf() {
        
        return cpf;
        
    }

    public void setCodigo(int codigo) {
        
        this.codigo = codigo;
        
    }

    public String getNome() {
        
        return nome;
        
    }

    public void setNome(String nome) {
        
        this.nome = nome;
        


    public void setCpf(String cpf) {
        
        this.cpf = cpf;
        
    }

    public String getEmail() {
        
        return email;
        
    }
    
    public String getEndereco() {
        
        return endereco;
        
    }
    
    public void setEmail(String email) {
        
        this.email = email;
        
    }



    public void setEndereco(String endereco) {
        
        this.endereco = endereco;
        
    }
    
 public void setDtNascimento(Date dtNascimento) {
        
        this.dtNascimento = dtNascimento;
        
    }
    
    public Date getDtNascimento() {
        
        return dtNascimento;
        
    }

   
    
}
