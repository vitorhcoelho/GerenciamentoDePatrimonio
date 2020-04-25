/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordepatrimonio;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * pnc
 *
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
            + "5 - Visualizar Movimentação de itens entre Ambientes\n"
            + "6 - Visualizar Movimentação de itens entre Donos\n"
            + "7 - Visualizar Revisões\n"
            + "0 - Voltar\n";

    private String menuVisuAmb = "1 - Filtrar por Servidor\n"
            + "2 - Filtrar por Campus\n"
            + "0 - Voltar\n";

    private String menuVisuItens = "1 - Filtrar por Campus\n"
            + "2 - Filtrar por Servidor Dono\n"
            + "3 - Buscar por ID\n"
            + "0 - Voltar\n";

    private String menuVisuMov = "1 - Mostrar todos\n"
            + "2 - Digite o ID item que deseja ver a movimentacao\n"
            + "0 - Voltar";

    private String menuGerenciar = "1 - Campus\n"
            + "2 - Servidores\n"
            + "3 - Ambientes\n"
            + "4 - Itens\n"
            + "5 - Movimentações de Itens\n"
            + "6 - Movimentações de Donos\n"
            + "7 - Revisões\n"
            + "0 - Voltar\n";

    private String menuGerenciar2 = "1 - Adicionar\n"
            + "2 - Editar\n"
            + "3 - Excluir\n"
            + "0 - Voltar\n";

    private String menuRevisoes = "1 - Criar Revisão\n"
            + "2 - Iniciar ou Continuar Revisão\n"
            + "3 - Excluir Revisão\n"
            + "0 - Voltar\n";

    Servidor s1 = new Servidor();
    Servidor s2 = new Servidor();
    Campus c1 = new Campus();
    Campus c2 = new Campus();
    Ambiente a1 = new Ambiente();
    Ambiente a2 = new Ambiente();
    Ambiente a3 = new Ambiente();
    Ambiente a4 = new Ambiente();
    Item i1 = new Item();
    Item i2 = new Item();
    Item i3 = new Item();
    Item i4 = new Item();

    public void database(ServidorDAO sDAO, CampusDAO cDAO, AmbienteDAO aDAO, ItemDAO iDAO) {
        s1.setCampus(1);
        s1.setCargo("professor");
        s1.setEmail("s1@gmail.com");
        s1.setId(sDAO.geraId());
        s1.setLoginSenha("s1", "123");
        s1.setNome("Jose");
        s1.setPapel("lecionar");
        s1.setSystem(false);
        sDAO.setServidores(s1);

        s2.setCampus(1);
        s2.setCargo("coordenador");
        s2.setEmail("s2@gmail.com");
        s2.setId(sDAO.geraId());
        s2.setLoginSenha("s2", "123");
        s2.setNome("Joao");
        s2.setPapel("coordenar");
        s2.setSystem(false);

        c1.setAbreviacao("camp1");
        c1.setBairro("Univerde");
        c1.setCep("38066244");
        c1.setCidade("Uberaba");
        c1.setDataCriacao(LocalDate.now());
        c1.setEndereco("Rua do Grau, 10");
        c1.setId(cDAO.geraId());
        c1.setNome("Campus Tecnologico");

        c2.setAbreviacao("camp2");
        c2.setBairro("Distrito");
        c2.setCep("38066333");
        c2.setCidade("Uberaba");
        c2.setDataCriacao(LocalDate.now());
        c2.setEndereco("Rua dos Govinos, 99");
        c2.setId(cDAO.geraId());
        c2.setNome("Campus Agroeconomico");

        a1.setCodCamp(1);
        a1.setDatacriacao(LocalDate.now());
        a1.setDescricao("Deposito");
        a1.setId(aDAO.geraId());

        a2.setCodCamp(1);
        a2.setDatacriacao(LocalDate.now());
        a2.setDescricao("Despensa");
        a2.setId(aDAO.geraId());

        a3.setCodCamp(2);
        a3.setDatacriacao(LocalDate.now());
        a3.setDescricao("Dispensa");
        a3.setId(aDAO.geraId());

        a4.setCodCamp(2);
        a4.setDatacriacao(LocalDate.now());
        a4.setDescricao("Diposito");
        a4.setId(aDAO.geraId());

        i1.setAmbienteId(1);
        i1.setCodigo("321654");
        i1.setDatacompra("12/08/2000");
        i1.setDatacriacao(LocalDate.now());
        i1.setEspecificacao("mesa");
        i1.setEstado(5);
        i1.setId(iDAO.geraId());
        i1.setIdDono(1);
        i1.setValorcompra(1000);

        i2.setAmbienteId(2);
        i2.setCodigo("987654");
        i2.setDatacompra("08/12/2007");
        i2.setDatacriacao(LocalDate.now());
        i2.setEspecificacao("cadeira");
        i2.setEstado(4);
        i2.setId(iDAO.geraId());
        i2.setIdDono(1);
        i2.setValorcompra(200);

        i3.setAmbienteId(3);
        i3.setCodigo("123456");
        i3.setDatacompra("24/10/2011");
        i3.setDatacriacao(LocalDate.now());
        i3.setEspecificacao("quadro");
        i3.setEstado(2);
        i3.setId(iDAO.geraId());
        i3.setIdDono(2);
        i3.setValorcompra(3500);

        i4.setAmbienteId(4);
        i4.setCodigo("123654");
        i4.setDatacompra("21/12/2013");
        i4.setDatacriacao(LocalDate.now());
        i4.setEspecificacao("projetor");
        i4.setEstado(1);
        i4.setId(iDAO.geraId());
        i4.setIdDono(2);
        i4.setValorcompra(1499);
    }

    public void login(ServidorDAO servDAO, CampusDAO campDAO, AmbienteDAO ambDAO, ItemDAO itemDAO, MovimentoAmbienteDAO mAmbDAO, MovimentoDonoDAO mdonoDAO, RevisaoDAO revDAO, ItensRevisaoDAO iRDAO) {

        serv.setNome("zika");
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
                                mainServidor(servDAO, campDAO, ambDAO, itemDAO, mAmbDAO, mdonoDAO);
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
                                    mainAdm(servDAO, campDAO, ambDAO, itemDAO, mAmbDAO, mdonoDAO, revDAO, iRDAO);
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

    public void visualizar(ServidorDAO servDAO, CampusDAO campDAO, AmbienteDAO ambDAO, ItemDAO itemDAO, MovimentoAmbienteDAO mAmbDAO, MovimentoDonoDAO mdonoDAO) {
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
                    while (opc != 0) {
                        System.out.println(menuVisuMov);
                        opc = Integer.parseInt(in.nextLine());

                        switch (opc) {
                            case 1:
                                mAmbDAO.mostraMovAmbientes();
                                break;

                            case 2:
                                System.out.println("Informe o ID do item que procura:");
                                dado = Integer.parseInt(in.nextLine());
                                mAmbDAO.getMovAmbientesPorID(dado);
                                break;

                            default:
                                break;
                        }
                    }
                    break;

                case 6:
                    while (opc != 0) {
                        System.out.println(menuVisuMov);
                        opc = Integer.parseInt(in.nextLine());

                        switch (opc) {
                            case 1:
                                mdonoDAO.mostraMovDonos();
                                break;

                            case 2:
                                System.out.println("Informe o ID do item que procura:");
                                dado = Integer.parseInt(in.nextLine());
                                mdonoDAO.getMovDonosPorID(dado);
                                break;

                            default:
                                break;
                        }
                    }
                    break;

                case 7:

                    break;

                default:
                    break;

            }
        }
    }

    public void gerenciamento(ServidorDAO servDAO, CampusDAO campDAO, AmbienteDAO ambDAO, ItemDAO iDAO, MovimentoAmbienteDAO mAmbDAO, MovimentoDonoDAO mDonoDAO, RevisaoDAO revDAO, ItensRevisaoDAO iRDAO) {
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

                    }
                    break;

                case 4:
                    while (opc != 0) {
                        System.out.println("\nItens:\n");
                        System.out.println(menuGerenciar2);
                        opc = Integer.parseInt(in.nextLine());
                        switch (opc) {
                            case 1:
                                iDAO.insereItem(mAmbDAO, mDonoDAO);
                                break;

                            case 2:
                                iDAO.editaItem(mAmbDAO, mDonoDAO);
                                break;

                            case 3:
                                iDAO.excluiItem(mAmbDAO, mDonoDAO);
                                break;

                            default:
                                break;
                        }
                    }
                    break;
                case 5:
                    while (opc != 0) {
                        System.out.println("\nMovimentações de Itens Entre Ambientes:\n");
                        System.out.println(menuGerenciar2);
                        opc = Integer.parseInt(in.nextLine());

                        switch (opc) {
                            case 1:
                                mAmbDAO.insereMovAmb(iDAO);
                                break;

                            case 2:
                                mAmbDAO.editaMovAmb(iDAO);
                                break;

                            case 3:
                                mAmbDAO.excluiMovimentoAmb();
                                break;

                            default:
                                break;
                        }
                    }
                    break;
                case 6:
                    while (opc != 0) {
                        System.out.println("\nMovimentações de Itens Entre Donos:\n");
                        System.out.println(menuGerenciar2);
                        opc = Integer.parseInt(in.nextLine());
                        switch (opc) {
                            case 1:
                                mDonoDAO.insereMov(iDAO);
                                break;

                            case 2:
                                mDonoDAO.editaMovDono(iDAO);
                                break;

                            case 3:
                                mDonoDAO.excluiMovimentoDono();
                                break;

                            default:
                                break;
                        }
                    }
                    break;

                case 7:
                    int serv;
                    while (opc != 0) {
                        System.out.println("\nRevisões: \n");
                        System.out.println(menuRevisoes);
                        opc = Integer.parseInt(in.nextLine());
                        switch (opc) {
                            case 1:
                                int valid = 0;
                                int amb;
                                serv = servDAO.getServLogado().getId();
                                while (valid != 1) {
                                    System.out.println("\nDigite o ID do Ambiente a ser Revisado: ");
                                    amb = Integer.parseInt(in.nextLine());
                                    if (ambDAO.getAmbiente(amb) != null) {
                                        revDAO.criaRevisao(serv, amb, iDAO, iRDAO);
                                        valid = 1;
                                    } else {
                                        System.out.println("\nID de Ambiente Não Existente!\n");
                                        valid = 0;
                                    }
                                }
                                break;

                            case 2:
                                serv = servDAO.getServLogado().getId();
                                amb = revDAO.getRevisaoServ(serv).getIdAmb();
                                if (revDAO.getRevisaoServ(serv) != null) {
                                    System.out.println("\nSua Revisão:\nAmbiente de ID: " + amb + "\tDescrição: "
                                            + ambDAO.getAmbiente(amb).getDescricao());
                                    System.out.println("\nDeseja continuar?\n1 - Sim\n2 - Não");
                                    int esc = Integer.parseInt(in.nextLine());

                                    if (esc == 1) {
                                        revDAO.andamentoRevisao(serv, iRDAO);
                                    } else {
                                        System.out.println("\nAbortando...\n");
                                    }
                                } else {
                                    System.out.println("\nVocê Não Possui Revisão Para Iniciar/Continuar\n");
                                }
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

    public void mainServidor(ServidorDAO servDAO, CampusDAO campDAO, AmbienteDAO ambDAO, ItemDAO itemDAO, MovimentoAmbienteDAO mAmbDAO, MovimentoDonoDAO mdonoDAO) {
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
                    visualizar(servDAO, campDAO, ambDAO, itemDAO, mAmbDAO, mdonoDAO);
                    break;

                default:
                    break;
            }
        }
        servDAO.getServLogado().setLogado(false);

    }

    public void mainAdm(ServidorDAO servDAO, CampusDAO campDAO, AmbienteDAO ambDAO, ItemDAO itemDAO, MovimentoAmbienteDAO mAmbDAO, MovimentoDonoDAO mdonoDAO, RevisaoDAO revDAO, ItensRevisaoDAO iRDAO) {
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
                    visualizar(servDAO, campDAO, ambDAO, itemDAO, mAmbDAO, mdonoDAO);
                    break;

                case 3:
                    gerenciamento(servDAO, campDAO, ambDAO, itemDAO, mAmbDAO, mdonoDAO, revDAO, iRDAO);
                    break;

                default:
                    break;
            }
        }
        servDAO.getServLogado().setLogado(false);
    }
}
