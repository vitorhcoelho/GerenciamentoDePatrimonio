/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordepatrimonio;

import static java.time.Clock.system;
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
                            servDAO.setLoginServ(servDAO.getServidoresLogin(login));
                            servDAO.getLogadoServ().setLogado(true);

                            while (servDAO.getLogadoServ().isLogado() != false && servDAO.getLogadoServ()!= null) {
                                menuServ(servDAO);
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
                            this.menuAdm(admDAO);
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
    
    public void menuAdm(AdministradorDAO admDAO) {
        int opc = 0;

        System.out.println("Bem - Vindo Administrador: " + admDAO.getAdm().getNome() + "\t"
                + admDAO.getAdm().toStringLogado()
                + "\n\n" + menuAdm);
        opc = Integer.parseInt(in.nextLine());

        switch (opc) {
            case 1:
                int opc1 = 0;
                while (opc1 != 5) {
                    System.out.println("Bem - Vindo\nAdministrador: " + admDAO.getAdm().getNome() + "\t"
                            + admDAO.getAdm().toStringLogado()
                            + "\n\n" + menuAdm);
                    opc1 = Integer.parseInt(in.nextLine());

                    switch (opc1) {
                        case 1:
                            break;

                        case 2:
                            break;

                        case 3:
                            break;

                        case 4:
                            break;

                        default:
                            break;
                    }
                }
                break;

            case 2:
           
                break;

            case 3:
                break;

            case 4:
                admDAO.alteraSenha(adm);
                break;

            case 5:
                admDAO.getAdm().setLogado(false);
                break;
        }

    }
    public void menuServ(ServidorDAO servDAO) {
        int opc = 0;
        String id;
        System.out.println("Bem - Vindo\n" + servDAO.getLogadoServ().toString() + ": " + servDAO.getLogadoServ().getNome() + "\t"
                + servDAO.getLogadoServ().toStringLogado()
                + "\n\n" + menuJog1);//????
        opc = Integer.parseInt(in.nextLine());

        switch (opc) {
            case 1:
                int opc1 = 0;
                while (opc1 != 5 && servDAO.getLogadoServ().isLogado() != false) {
                    System.out.println("Bem - Vindo\n" + servDAO.getLogadoServ().toString() + ": " + servDAO.getLogadoServ().getNome() + "\t"
                            + servDAO.getLogadoServ().toStringLogado()
                            + "\n\n" + menuServ);
                    opc1 = Integer.parseInt(in.nextLine());
                    switch (opc1) {
                        case 1:
                            
                            break;

                        case 2:
                            
                            break;

                        case 3:
                            
                            break;

                        case 4:
                            
                            break;

                        default:
                            break;

                    }

                }
                break;

            case 2:
                int opc2 = 0;
                while (opc2 != 6) {
                    System.out.println("Bem - Vindo\n" + servDAO.getLogadoServ().toString() + ": " + servDAO.getLogadoServ().getNome() + "\t"
                            + servDAO.getLogadoServ().toStringLogado()
                            + "\n\n" + menuJog2);//?????
                    opc2 = Integer.parseInt(in.nextLine());
                    switch (opc2) {
                        case 1:
                            
                            break;

                        case 2:
                            
                            break;

                        case 3:
                            
                            break;

                        case 4:
                            
                            break;

                        case 5:
                            
                            break;

                        default:
                            break;
                    }

                }
                break;

            case 3:
                int opc3 = 0;
                while (opc3 != 9) {
                    System.out.println("Bem - Vindo\n" + servDAO.getLogadoServ().toString() + ": " + servDAO.getLogadoServ().getNome() + "\t"
                            + servDAO.getLogadoServ().toStringLogado()
                            + "\n\n" + menuJog3);//???????
                    opc3 = Integer.parseInt(in.nextLine());
                    switch (opc3) {
                        case 1:
                            
                            break;

                        case 2:
                            
                            break;
                        case 3:
                            
                            break;

                        case 4:
                            
                            break;

                        case 5:
                            
                            break;

                        case 6:
                            break;

                        case 7:
                            
                            break;

                        case 8:
                            
                            break;

                        default:
                            break;
                    }
                }
                break;

            case 5:
                servDAO.getLogadoServ().setLogado(false);
                break;
        }

    }
}
