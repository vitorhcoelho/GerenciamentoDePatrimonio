/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordepatrimonio;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author gusta
 */
public class CampusDAO {

    private Campus[] campus = new Campus[100];
    private int qtdCampus;
    private int id = 0;

    Scanner in = new Scanner(System.in);

    public int geraId() {
        this.id++;
        return id;
    }
    
    public int vagaCampus(){
        for (int x = 0; x < campus.length; x++) {
            if (campus[x] == null) {
                return x;
            } else {

            }
        }
        return -1;
    }
    
    public boolean setCampus(Campus camp){
        int pos = vagaCampus();
        if (pos == -1) {
            System.out.println("\nLista de Campus Cheia\n");
            return false;
        } else {
            campus[pos] = camp;
            this.qtdCampus++;
            return true;
        }
    }

    public void insereCampus() {
        String dado;
        Campus c = new Campus();

        System.out.println("\nInsira o Nome do Campus:");
        dado = in.nextLine();
        c.setNome(dado);

        System.out.println("\nInsira a Abreviação:");
        dado = in.nextLine();
        c.setAbreviacao(dado);
       
        System.out.println("\nInsira a Cidade que se Localiza:");
        dado = in.nextLine();
        c.setCidade(dado);

        System.out.println("\nInsira o Bairro:");
        dado = in.nextLine();
        c.setBairro(dado);

        System.out.println("\nInsira o Endereço:");
        dado = in.nextLine();
        c.setEndereco(dado);

        int verify = 0;
        while (verify != 1) {
            System.out.println("\nInsira o CEP:");
            dado = in.nextLine();

            if (dado.length() == 8) {
                c.setCep(dado);
                verify = 1;
            } else {
                System.out.println("\nCEP Inválido!");
                verify = 0;
            }
        }
        
        c.setDataCriacao(LocalDate.now());
        c.setId(geraId());
        this.setCampus(c);
        
        System.out.println(c.toString() + "\nIncluído com Sucesso!\n");
    }
    
    public void editaCampus(){
        int id;
        System.out.println("\nDigite o ID do Campus: ");
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

            System.out.println("\nJogador Alterado\n");
        }
    }
}
