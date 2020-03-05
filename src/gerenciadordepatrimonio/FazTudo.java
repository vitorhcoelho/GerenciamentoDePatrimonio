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
    
    Servidor serv = new Servidor();
    Administrador adm = new Administrador();
    Scanner in = new Scanner(System.in);
    int opcao=10;
    
    private String menuServ = "1 - Gerar relatório\n"
            + "0 - Sair\n";
    
    private String menuAdm = "1 - Lista de servidores\n"
            + "2 - Campus\n"
            + "3 - Itens\n"
            + "4 - Ambientes\n"
            + "5 - Vinculações\n"
            + "6 - Movimentações\n"
            + "0 - Sair\n";
    
    public void login(ServidorDAO servDAO, AdministradorDAO admDAO){
        
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

                    if (servDAO.getServidoresLogin(login) != null) {

                        if (servDAO.getServidoresLogin(login).getSenha().equals(senha)) {
                            servDAO.setServidorLogado(servDAO.getServidoresLogin(login));
                            servDAO.getServidorLogado().setLogado(true);

                            while (servDAO.getServidorLogado().isLogado() != false && servDAO.getServidorLogado()!= null) {
                                //menuServ();
                                System.out.println("ok serv");
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

                    if (admDAO.validaLoginAdm(login, senha)) {
                        admDAO.getAdm().setLogado(true);

                        while (admDAO.getAdm().isLogado() != false) {
                            System.out.println("ok adm");
                            this.menuAdm(admDAO, servDAO);
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
    
    public void menuAdm(AdministradorDAO bkp, ServidorDAO jogDAO) {
//        int opc = 0;
//
//        System.out.println("Bem - Vindo\nAdministrador: " + bkp.getAdm().getNome() + "\t"
//                + bkp.getAdm().toStringLogado()
//                + "\n\n" + menuAdmP);
//        opc = Integer.parseInt(in.nextLine());
//
//        switch (opc) {
//            case 1:
//                int opc1 = 0;
//                while (opc1 != 5) {
//                    System.out.println("Bem - Vindo\nAdministrador: " + bkp.getAdm().getNome() + "\t"
//                            + bkp.getAdm().toStringLogado()
//                            + "\n\n" + menuAdm1);
//                    opc1 = Integer.parseInt(in.nextLine());
//
//                    switch (opc1) {
//                        case 1:
//                            qdDAO.criaQuadra();
//                            break;
//
//                        case 2:
//                            qdDAO.editaQuadra();
//                            break;
//
//                        case 3:
//                            qdDAO.excluiQuadra();
//                            break;
//
//                        case 4:
//                            qdDAO.mostraQuadras();
//                            break;
//
//                        default:
//                            break;
//                    }
//                }
//                break;
//
//            case 2:
//           
//                break;
//
//            case 3:
//                break;
//
//            case 4:
//                bkp.alteraSenha(system);
//                break;
//
//            case 5:
//                bkp.getAdm().setLogado(false);
//                break;
//        }

    }
    
//    public void menuServ(adminDAO bkp, quadraDAO qdDAO, JogadorDAO jogDAO) {
//        int opc = 0;
//
//        System.out.println("Bem - Vindo\nAdministrador: " + bkp.getAdm().getNome() + "\t"
//                + bkp.getAdm().toStringLogado()
//                + "\n\n" + menuAdmP);
//        opc = Integer.parseInt(in.nextLine());
//
//        switch (opc) {
//            case 1:
//                int opc1 = 0;
//                while (opc1 != 5) {
//                    System.out.println("Bem - Vindo\nAdministrador: " + bkp.getAdm().getNome() + "\t"
//                            + bkp.getAdm().toStringLogado()
//                            + "\n\n" + menuAdm1);
//                    opc1 = Integer.parseInt(in.nextLine());
//
//                    switch (opc1) {
//                        case 1:
//                            qdDAO.criaQuadra();
//                            break;
//
//                        case 2:
//                            qdDAO.editaQuadra();
//                            break;
//
//                        case 3:
//                            qdDAO.excluiQuadra();
//                            break;
//
//                        case 4:
//                            qdDAO.mostraQuadras();
//                            break;
//
//                        default:
//                            break;
//                    }
//                }
//                break;
//
//            case 2:
//           
//                break;
//
//            case 3:
//                break;
//
//            case 4:
//                bkp.alteraSenha(system);
//                break;
//
//            case 5:
//                bkp.getAdm().setLogado(false);
//                break;
//        }
//
//    }
}
