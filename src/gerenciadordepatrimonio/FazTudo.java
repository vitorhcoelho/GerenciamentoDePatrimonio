/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordepatrimonio;

import java.util.Scanner;

/**
 *
 * @author Vitor Hugo
 */
public class FazTudo {
    
    int opcao=10;
    Scanner in = new Scanner(System.in);
    
    public void login(ServidorDAO servDAO){
        
        while (this.opcao != 0) {
            System.out.println("----------IFTM GERENCIAMENTO----------\n");
            System.out.println("Para acessar como:\n\n"
                    + "[1] -> SERVIDOR\n"
                    + "[2] -> ADMINISTRADOR\n"
                    + "[0] -> SAIR\n");
            this.opcao = Integer.parseInt(in.nextLine());

            switch (this.opcao) {
                case 1:
                    System.out.println("Login: ");
                    String login = in.nextLine();
                    System.out.println("Senha: ");
                    String senha = in.nextLine();

                    if (servDAO.getJogadoresLogin(login) != null) {

                        if (servDAO.getJogadoresLogin(login).getSenha().equals(senha)) {
                            servDAO.setLoginJog(servDAO.getJogadoresLogin(login));
                            servDAO.getLogadoJog().setLogado(true);

                            while (jogDAO.getLogadoJog().isLogado() != false && jogDAO.getLogadoJog() != null) {
                                menuJogP(jogDAO, adDAO, tDAO, qdDAO, hrSTDAO, hrCTDAO);
                            }

                        } else {
                            System.out.println("\nLogin ou Senha Incorretos!\n");
                        }
                    } else {
                        System.out.println("\nLogin ou Senha Incorretos!\n");
                    }
                    break;

                case 2:
                    System.out.println("Login: ");
                    login = in.nextLine();
                    System.out.println("Senha: ");
                    senha = in.nextLine();

                    if (adDAO.validaLoginAdm(login, senha)) {
                        adDAO.getAdm().setLogado(true);

                        while (adDAO.getAdm().isLogado() != false) {
                            this.menuAdmP(adDAO, qdDAO, jogDAO);
                        }

                    } else {
                        System.out.println("Login ou Senha Incorretos!\n");
                    }
                    break;

                default:
                    break;
            }

        }
    }
}
