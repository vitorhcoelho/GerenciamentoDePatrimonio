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
    private int campus;
    private String cargo;
    private String papel;
    private String login;
    private String senha;
    private boolean logado;
    private boolean adm;
    private boolean system;

    public Servidor() {
        this.id = 0;
    }

    public boolean isSystem() {
        return system;
    }

    public void setSystem(boolean system) {
        this.system = system;
    }

    public String descreveAdm() {
        if (isAdm()) {
            return "Sim";
        } else {
            return "Não";
        }
    }

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

    public int getCampus() {
        return campus;
    }

    public void setCampus(int campus) {
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
        return "Servidor " + getNome() + "\tAdministrador: " + descreveAdm() + "\tID: " + getId()
                + "\nE-mail: " + getEmail() + "\nCargo: " + getCargo() + "\tPapel: "
                + getPapel() + "\nId de Campus: " + getCampus();
    }

}
