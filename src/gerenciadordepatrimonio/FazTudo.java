/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordepatrimonio;

import java.util.Scanner;

/**
 * pnc
 * @author Vitor Hugo
 */
public class FazTudo {
    
    Servidor serv = new Servidor();
    Scanner in = new Scanner(System.in);
    
    private String menuServ = "1 - Gerar Relatório\n"
            + "2 - Visulizar\n"
            + "0 - Sair\n";
    
    private String menuAdm = "1 - Gerar Relatório\n"
            + "2 - Visualizar\n"
            + "3 - Gerenciar\n"
            + "0 - Sair\n";
    
    private String menuRelatorio = "1 - Relatório de Ambientes\n"
            + "2 - Relatório de Servidores\n"
            + "0 - Voltar\n";
    
    private String menuVisualizar = "1 - Visualizar Servidores\n"
            + "2 - Visualizar Campus\n"
            + "3 - Visualizar Ambientes\n"
            + "4 - Visualizar Itens\n"
            + "5 - Visualizar Movimentação de Itens\n"
            + "6 - Visualizar Movimentação de Donos\n"
            + "7 - Visualizar Revisões\n"
            + "0 - Voltar\n";
    
    private String menuVisuAmb = "1 - Filtrar por Servidor\n"
            + "2 - Filtrar por Campus\n"
            + "0 - Voltar\n";
    
    private String menuVisuItens = "1 - Filtrar por Campus\n"
            + "2 - Filtrar por Servidor Dono\n"
            + "3 - Buscar por ID\n"
            + "0 - Voltar\n";
    
    private String menuGerenciar = "1 - Campus\n"
            + "2 - Servidores\n"
            + "3 - Ambientes\n"
            + "4 - Itens\n"
            + "5 - Movimentações de Itens\n"
            + "6 - Movimentações de Donos\n"
            + "0 - Voltar\n";
    
    private String menuGerenciar2 = "1 - Adicionar\n"
            + "2 - Editar\n"
            + "3 - Excluir\n"
            + "0 - Voltar\n";
    
    public void login(ServidorDAO servDAO, CampusDAO campDAO, AmbienteDAO ambDAO, ItemDAO itemDAO) {
        
        serv.setLoginSenha("login", "senha");//user teste
        serv.setAdm(true);
        servDAO.setServidores(serv);
        
        int opcao = 5;
        
        while (opcao != 0) {
            System.out.println("----------IFTM GERENCIAMENTO----------\n");
            System.out.println("Para acessar como:\n\n"
                    + "[1] -> SERVIDOR\n"
                    + "[2] -> ADMINISTRADOR\n"
                    + "[0] -> SAIR\n");
            opcao = Integer.parseInt(in.nextLine());
            
            switch (opcao) {
                case 1:
                    System.out.println("Login: ");
                    String login = in.nextLine();
                    System.out.println("Senha: ");
                    String senha = in.nextLine();
                    
                    if (servDAO.getServidoresLogin(login) != null) {
                        if (servDAO.getServidoresLogin(login).getSenha().equals(senha)) {
                            
                            servDAO.setLoginServ(servDAO.getServidoresLogin(login));
                            servDAO.getServLogado().setLogado(true);
                            
                            while (servDAO.getServLogado().isLogado() != false && servDAO.getServLogado() != null) {
                                mainServidor(servDAO, campDAO, ambDAO, itemDAO);
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
                    
                    if (servDAO.getServidoresLogin(login) != null) {
                        if (servDAO.getServidoresLogin(login).isAdm()) {
                            if (servDAO.getServidoresLogin(login).getSenha().equals(senha)) {
                                
                                servDAO.setLoginServ(servDAO.getServidoresLogin(login));
                                servDAO.getServLogado().setLogado(true);
                                
                                while (servDAO.getServLogado().isLogado() != false && servDAO.getServLogado() != null) {
                                    mainAdm(servDAO, campDAO, ambDAO, itemDAO);
                                }
                                
                            } else {
                                System.out.println("\nLogin ou Senha Incorretos!\n");
                            }
                        } else {
                            System.out.println("\nUsuário sem Permissão Administrativa!\n");
                        }
                    } else {
                        System.out.println("\nLogin ou Senha Incorretos!\n");
                    }
                    break;
                
                default:
                    break;
            }
            
        }
    }
    
    public void relatorios(ServidorDAO servDAO) {
        int aux = 1;
        while (aux != 0) {
            System.out.println("----------IFTM GERENCIAMENTO----------\n");
            System.out.println(menuRelatorio);
            aux = Integer.parseInt(in.nextLine());
            
            switch (aux) {
                case 1:
                    break;
                
                case 2:
                    break;
                
                default:
                    break;
            }
        }
    }
    
    public void visualizar(ServidorDAO servDAO, CampusDAO campDAO, AmbienteDAO ambDAO, ItemDAO itemDAO) {
        int aux = 1;
        int dado;
        while (aux != 0) {
            System.out.println("----------IFTM GERENCIAMENTO----------\n");
            System.out.println(menuVisualizar);
            aux = Integer.parseInt(in.nextLine());
            int opc = 1;
            
            switch (aux) {
                case 1:
                    servDAO.mostraServidores();
                    break;
                case 2:
                    campDAO.mostraCampus();
                    break;
                case 3:
                    while (opc != 0) {
                        System.out.println(menuVisuAmb);
                        opc = Integer.parseInt(in.nextLine());
                        
                        switch (opc) {
                            case 1:
                                System.out.println("Informe o ID do servidor que procura:");
                                dado = Integer.parseInt(in.nextLine());
                                ambDAO.mostraAmbientesPorServ(servDAO.getServidoresId(dado));
                                break;
                            
                            case 2:
                                System.out.println("Informe o ID do campus que procura:");
                                dado = Integer.parseInt(in.nextLine());
                                ambDAO.mostraAmbientesPorCampus(campDAO.getCampus(dado));
                                break;
                            
                            default:
                                break;
                        }
                    }
                    break;
                case 4:
                    while (opc != 0) {
                        System.out.println(menuVisuItens);
                        opc = Integer.parseInt(in.nextLine());
                        
                        switch (opc) {
                            case 1:
                                System.out.println("Informe o ID do campus que procura:");
                                dado = Integer.parseInt(in.nextLine());
                                itemDAO.mostraItemPorCampus(ambDAO.getAmbientesPorCampus(campDAO.getCampus(dado)));
                                break;
                            
                            case 2:
                                System.out.println("Informe o ID do servidor que procura:");
                                dado = Integer.parseInt(in.nextLine());
                                itemDAO.mostraItemPorServ(ambDAO.getAmbientesPorCampus(campDAO.getCampus(servDAO.getServidoresCampus(dado))));
                                break;
                            
                            case 3:
                                System.out.println("Informe o ID do item que procura:");
                                dado = Integer.parseInt(in.nextLine());
                                itemDAO.mostraItemPorID(dado);
                                break;
                            
                            default:
                                break;
                        }
                    }
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                    
                    break;
                default:
                    break;
                
            }
        }
    }
    
    public void gerenciamento(ServidorDAO servDAO, CampusDAO campDAO, AmbienteDAO ambDAO, ItemDAO iDAO) {
        int aux = 1;
        while (aux != 0) {
            System.out.println("----------IFTM GERENCIAMENTO----------\n");
            System.out.println(menuGerenciar);
            aux = Integer.parseInt(in.nextLine());
            int opc = 1;
            
            switch (aux) {
                case 1:
                    while (opc != 0) {
                        System.out.println("\nCampus:\n");
                        System.out.println(menuGerenciar2);
                        opc = Integer.parseInt(in.nextLine());
                        
                        switch (opc) {
                            case 1:
                                campDAO.insereCampus();
                                break;
                            
                            case 2:
                                campDAO.editaCampus();
                                break;
                            
                            case 3:
                                campDAO.excluiCampus();
                                break;
                            
                            default:
                                break;
                        }
                    }
                    
                    break;
                
                case 2:
                    while (opc != 0) {
                        System.out.println("\nServidores:\n");
                        System.out.println(menuGerenciar2);
                        opc = Integer.parseInt(in.nextLine());
                        
                        switch (opc) {
                            case 1:
                                servDAO.insereServ();
                                break;
                            
                            case 2:
                                servDAO.editaServ();
                                break;
                            
                            case 3:
                                servDAO.excluiServ();
                                break;
                            
                            default:
                                break;
                        }
                    }
                    
                    break;
                case 3:
                    while (opc != 0) {
                        System.out.println("\nAmbiente:\n");
                        System.out.println(menuGerenciar2);
                        opc = Integer.parseInt(in.nextLine());
                        
                        switch (opc) {
                            case 1:
                                ambDAO.insereAmbiente();
                                break;
                            
                            case 2:
                                ambDAO.editaAmbiente();
                                break;
                            
                            case 3:
                                ambDAO.excluiAmbiente();
                                break;
                            
                            default:
                                break;
                        }
                        break;
                    }
                    break;
                
                case 4:
                    while (opc != 0) {
                        System.out.println("\nItens:\n");
                        System.out.println(menuGerenciar2);
                        opc = Integer.parseInt(in.nextLine());
                        switch (opc) {
                            case 1:
                                iDAO.insereItem();
                                break;
                            
                            case 2:
                                
                                break;
                            
                            case 3:
                                
                                break;
                            
                            default:
                                break;
                        }
                    }
                    break;
                case 5:
                    while (opc != 0) {
                        System.out.println("\nMovimentações de Itens:\n");
                        System.out.println(menuGerenciar2);
                        opc = Integer.parseInt(in.nextLine());
                        switch (opc) {
                            case 1:
                                
                                break;
                            
                            case 2:
                                
                                break;
                            
                            case 3:
                                
                                break;
                            
                            default:
                                break;
                        }
                    }
                    break;
                case 6:
                    while (opc != 0) {
                        System.out.println("\nMovimentações de Donos:\n");
                        System.out.println(menuGerenciar2);
                        opc = Integer.parseInt(in.nextLine());
                        switch (opc) {
                            case 1:
                                
                                break;
                            
                            case 2:
                                
                                break;
                            
                            case 3:
                                
                                break;
                            
                            default:
                                break;
                        }
                    }
                    break;
                default:
                    break;
                
            }
        }
    }
    
    public void mainServidor(ServidorDAO servDAO, CampusDAO campDAO, AmbienteDAO ambDAO, ItemDAO itemDAO) {
        int opc = 1;
        while (opc != 0) {
            System.out.println("----------IFTM GERENCIAMENTO----------\n");
            System.out.println("Bem Vindo " + servDAO.getServLogado().getNome());
            System.out.println(menuServ);
            opc = Integer.parseInt(in.nextLine());
            
            switch (opc) {
                case 1:
                    relatorios(servDAO);
                    break;
                
                case 2:
                    visualizar(servDAO, campDAO, ambDAO, itemDAO);
                    break;
                
                default:
                    break;
            }
        }
        servDAO.getServLogado().setLogado(false);
        
    }
    
    public void mainAdm(ServidorDAO servDAO, CampusDAO campDAO, AmbienteDAO ambDAO, ItemDAO itemDAO) {
        int opc = 1;
        while (opc != 0) {
            System.out.println("----------IFTM GERENCIAMENTO----------\n");
            System.out.println("Bem Vindo " + servDAO.getServLogado().getNome());
            System.out.println(menuAdm);
            opc = Integer.parseInt(in.nextLine());
            
            switch (opc) {
                case 1:
                    relatorios(servDAO);
                    break;
                
                case 2:
                    visualizar(servDAO, campDAO, ambDAO, itemDAO);
                    break;
                
                case 3:
                    gerenciamento(servDAO, campDAO, ambDAO, itemDAO);
                    break;
                
                default:
                    break;
            }
        }
        servDAO.getServLogado().setLogado(false);
    }
}
