package model;

public class UsuarioModel {
    private int id;
    private String login;
    private String senha;

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
       this.id = id;
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
}