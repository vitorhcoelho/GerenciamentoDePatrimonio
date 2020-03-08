/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordepatrimonio;

/**
 *
 * @author Vitor Hugo
 */
public class Servidor {

    private int id;
    private String nome;
    private String email;
    private Campus campus;
    private String cargo;
    private String papel;
    private String login;
    private String senha;
    private boolean logado;
    private boolean adm;

    public boolean isAdm() {
        return adm;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
    }
    
    public boolean isLogado() {
        return logado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean checkId(int id) {
        if (id < 0) {
            return false;
        } else {
            return true;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus camp) {
        this.campus = campus;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setLoginSenha(String login, String senha) {
        this.login = login;
        this.senha = senha;
        this.logado = false;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    @Override
    public String toString() {
        return "Servidor{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", camp=" + campus + ", cargo=" + cargo + ", papel=" + papel + ", login=" + login + ", senha=" + senha + '}';
    }

    public String toStringLogado() {
        if (this.logado) {
            return "Online";
        } else {
            return "Offline";
        }
    }

}
