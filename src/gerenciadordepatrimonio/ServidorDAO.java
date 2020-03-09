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
public class ServidorDAO {

    private Servidor[] servidores = new Servidor[221];
    private int qtdServidor;

    Scanner in = new Scanner(System.in);
    private Servidor servLogado;

    public Servidor getServLogado() {
        return servLogado;
    }

    public void setLoginServ(Servidor logado) {
        this.servLogado = logado;
    }

    public boolean validaLoginServ(String login, String senha) {
        for (int x = 0; x < servidores.length; x++) {
            if (this.servidores[x].getLogin().equals(login) && servidores[x] != null) {
                if (this.servidores[x].getSenha().equals(senha)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public int posicaoServ() {
        for (int x = 0; x < servidores.length; x++) {
            if (servidores[x] == null) {
                return x;
            } else {

            }
        }
        return -1;
    }

    public int achaServidorLogin(String login) {
        for (int x = 0; x < this.qtdServidor; x++) {
            if (login.equals(servidores[x].getLogin())) {
                return x;
            } else {

            }
        }
        return -1;
    }

    public Servidor getServidoresLogin(String login) {
        int loc = this.achaServidorLogin(login);
        if (loc == -1) {
            return null;
        } else {
            return servidores[loc];
        }
    }

    public boolean setServidores(Servidor serv) {
        int pos = posicaoServ();
        if (pos == -1) {
            System.out.println("\nLista de Servidores Cheia\n");
            return false;
        } else {
            servidores[pos] = serv;
            this.qtdServidor++;
            return true;
        }
    }

    public int achaServidorId(int id) {
        for (int x = 0; x < this.qtdServidor; x++) {
            if (id == servidores[x].getId() && servidores[x] != null) {
                return x;
            } else {

            }
        }
        return -1;
    }

    public Servidor getServidoresId(int id) {
        int loc = this.achaServidorId(id);
        if (loc == -1) {
            return null;
        } else {
            return servidores[loc];
        }

    }

    public int achaServidorNome(String nome) {
        for (int x = 0; x < this.qtdServidor; x++) {
            if (servidores[x].getNome().equals(nome) && servidores[x] != null) {
                return x;
            } else {

            }
        }
        return -1;
    }

    public Servidor getServidoresNome(String nome) {
        int loc = this.achaServidorNome(nome);
        if (loc == -1) {
            return null;
        } else {
            return servidores[loc];
        }
    }

    public boolean deleteServidor(int id) {
        for (int x = 0; x < this.qtdServidor; x++) {
            if (id == servidores[x].getId() && servidores[x] != null) {
                this.servidores[x] = null;
                this.qtdServidor--;
                return true;
            } else {

            }
        }
        return false;
    }

    public void mostraServidores() {
        for (int x = 0; x < this.qtdServidor; x++) {
            if (servidores[x] != null) {
                System.out.println(this.servidores[x].toString());
            } else {

            }

        }
    }

    public int getQtdServ() {
        return this.qtdServidor;
    }

    public void insereServ() {
        String dado;
        int id = 0;
        Servidor i = new Servidor();

        System.out.println("\nNome: ");
        dado = in.nextLine();
        i.setNome(dado);

        while (dado != null) {
            System.out.println("\nId: ");
            dado = in.nextLine();
            if (i.checkId(id)) {
                i.setId(id);
                break;
            } else {
                System.out.println("\nId Inválido\n");
            }
        }

        System.out.println("\nE-mail: ");
        dado = in.nextLine();
        i.setEmail(dado);

        System.out.println("\nLogin: ");
        dado = in.nextLine();

        String senha;
        String confirme;

        while (dado != null) {
            System.out.println("\nSenha: ");
            senha = in.nextLine();
            System.out.println("\nConfirme sua Senha: ");
            confirme = in.nextLine();
            if (senha.equals(confirme)) {
                i.setLoginSenha(dado, senha);
                break;
            } else {
                System.out.println("\nSenhas Diferentes\n");
            }
        }

        setServidores(i);

        if (setServidores(i)) {
            System.out.println("\nServidor Adicionado\n");
        }
    }

    public void editaServ() {
        int id;
        System.out.println("\nDigite o ID do Servidor: ");
        id = Integer.parseInt(in.nextLine());

        if (getServidoresId(id) == null) {
            System.out.println("\nServidor Não Encontrado\n");
        } else {
            Servidor edit = getServidoresId(id);
            System.out.println("\nServidor " + edit.getNome() + " Encontrado");

            int esc;

            System.out.println("\nDeseja mudar o nome:\n1 - Sim\n2 - Não");
            esc = Integer.parseInt(in.nextLine());

            if (esc == 1) {
                System.out.println("\nNovo Nome: ");
                edit.setNome(in.nextLine());
            } else {
                System.out.println("\nNome Mantido\n");
            }

            System.out.println("\nDeseja mudar o CPF:\n1 - Sim\n2 - Não");
            esc = Integer.parseInt(in.nextLine());

            if (esc == 1) {
                while (esc == 1) {
                    System.out.println("\nNovo CPF: ");
                    String novoCpf = in.nextLine();
                    if (edit.checkId(id)) { //ID
                        edit.setId(id);
                        break;
                    } else {
                        System.out.println("\nCPF Inválido\n");
                    }
                }
            } else {
                System.out.println("\nCPF Mantido\n");
            }

            System.out.println("\nDeseja mudar o E-mail:\n1 - Sim\n2 - Não");
            esc = Integer.parseInt(in.nextLine());

            if (esc == 1) {
                System.out.println("\nNovo E-mail: ");
                edit.setEmail(in.nextLine());
            } else {
                System.out.println("\nE-mail Mantido\n");
            }

            System.out.println("\nDeseja mudar o Login e Senha:\n1 - Sim\n2 - Não");
            esc = Integer.parseInt(in.nextLine());

            if (esc == 1) {
                while (esc == 1) {
                    System.out.println("\nNovo Login: ");
                    String login = in.nextLine();
                    System.out.println("\nSenha Atual: ");
                    String atual = in.nextLine();
                    System.out.println("\nNova Senha: ");
                    String novaPass = in.nextLine();
                    System.out.println("\nConfirme sua Nova Senha: ");
                    String conf = in.nextLine();

                    if (getServLogado().getSenha().equals(atual)) {
                        if (novaPass.equals(conf)) {
                            edit.setLoginSenha(login, novaPass);
                            break;
                        } else {
                            System.out.println("\nSenhas Diferentes\n");
                        }
                    } else {
                        System.out.println("\nSenha Atual Errada\n");
                    }
                }
            } else {
                System.out.println("\nLogin e Senha Mantidos\n");
            }

            System.out.println("\nServidor Alterado\n");
        }
    }

    public void excluiJog() {
        int id;
        System.out.println("\nDigite o CPF do servidor: ");
        id = Integer.parseInt(in.nextLine());

        if (getServidoresId(id) == null) {
            System.out.println("\nServidor Não Encontrado");
        } else if (getServidoresId(id).isSystem()) {
            System.out.println("\nVocê não pode deletar esse usuário!\n:user_system:\n");
        } else {
            System.out.println("\nServidor " + getServidoresId(id).getNome() + " Encontrado"
                    + "\nDeseja Deletar?\n1 - Sim\n2 - Não");
            int es = Integer.parseInt(in.nextLine());
            if (es == 1) {
                if (getServidoresId(id).getId() == id) {
                    getServidoresId(id).setLogado(false);
                    deleteServidor(id);
                    System.out.println("\nServidor Deletado\n");
                } else {
                    deleteServidor(id);
                    System.out.println("\nServidor Deletado\n");
                }
            } else {
                System.out.println("\nServidor Mantido\n");
            }
        }
    }

    public void buscaJog() {
        System.out.println("\nBuscar por:\n1 - Nome\n2 - ID\n3 - Voltar");
        int escB = Integer.parseInt(in.nextLine());

        switch (escB) {

            case 1:
                System.out.println("\nDigite o Nome: ");
                String buscaNome = in.nextLine();

                if (getServidoresNome(buscaNome) == null) {
                    System.out.println("\nJogador Não Encontrado\n");
                } else {
                    System.out.println(getServidoresNome(buscaNome).toString());
                }
                break;
            case 2:
                System.out.println("\nDigite o CPF: ");
                int buscaId = Integer.parseInt(in.nextLine());

                if (getServidoresId(buscaId) == null) {
                    System.out.println("\nJogador Não Encontrado\n");
                } else {
                    System.out.println(getServidoresId(buscaId).toString());
                }

            default:
                break;

        }
    }

}
