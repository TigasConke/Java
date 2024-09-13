package login.Model;

public class UsuarioModel {

    private String nomeUsuario;
    private String senhaUsuario;

    public UsuarioModel(String nomeUsuario, String senhaUsuario) {
       
        this.nomeUsuario = nomeUsuario;
        this.senhaUsuario = senhaUsuario;
        
    }

    public String getNomeUsuario() {
        
        return nomeUsuario;
        
    }

    public void setNomeUsuario(String nomeUsuario) {
       
        this.nomeUsuario = nomeUsuario;
        
    }

    public String getSenhaUsuario() {
       
        return senhaUsuario;
        
    }

    public void setSenhaUsuario(String senhaUsuario) {
        
        this.senhaUsuario = senhaUsuario;
        
    }
    
}
