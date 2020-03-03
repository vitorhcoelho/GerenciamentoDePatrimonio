/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordepatrimonio;

import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class AdministradorDAO {
    private Administrador adm = new Administrador();

    public void setAdm(Administrador system) {
        this.adm = system;
    }

    public Administrador getAdm() {
        return adm;
    }

    public boolean validaLoginAdm(String login, String senha) {
        if (this.adm.getLogin().equals(login)) {
            if (this.adm.getSenha().equals(senha)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void alteraSenha(Administrador system) {
        Scanner in = new Scanner(System.in);
        String senha = null;
        String senha2 = null;
        String login;

        System.out.println("\nConfirme seu login e senha");
        while (true) {
            System.out.println("\nLogin:");
            login = (in.nextLine());
            if (login.equals(adm.getLogin())) {
                System.out.println("\nSenha:");
                senha = (in.nextLine());
                if (senha.equals(adm.getSenha())) {
                    System.out.println("Informe a nova senha:");
                    senha = (in.nextLine());
                    System.out.println("Confirme a nova senha:");
                    senha2 = (in.nextLine());
                    if (senha.equals(senha2)) {
                        adm.setLoginSenha(login, senha);
                        break;
                    }
                }
            }
        }
    }
}
