/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordepatrimonio;

/**
 *
 * @author Aluno
 */
public class Administrador {
    
    private String nome;
    private String login;
    private String senha;
    private boolean system = true;
    private boolean logado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void setLoginSenha(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public boolean isSystem() {
        return system;
    }

    public void setSystem(boolean system) {
        this.system = system;
    }

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }
    
    public String toStringLogado(){
        if(this.logado){
            return "Online";
        }else{
            return "Offline";
        }
    }

    @Override
    public String toString() {
        return "Administrador: " + this.nome
                + "\nLogin: " + this.login;
    }
    
}
