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
public class AmbienteDAO {

    private Ambiente[] ambs = new Ambiente[100];
    private int qtdAmb = 0;
    private int id = 0;
    Scanner in = new Scanner(System.in);

    public int geraId() {
        this.id++;
        return id;
    }

    public void insereAmbiente() {
        String dado;
        int id;
        Ambiente a = new Ambiente();

        System.out.println("\nInsira a descricao do ambiente:");
        dado = in.nextLine();
        a.setDescricao(dado);

        System.out.println("\nInsira o id do Campus vinculado ao ambiente:");
        id = Integer.parseInt(in.nextLine());
        a.setCodCamp(id);

        a.setDatacriacao(LocalDate.now());
        a.setDatamodificacao(LocalDate.now());

        a.setId(geraId());

        this.setAmbiente(a);

        System.out.println(a.toString() + "\nincluído com Sucesso!\n");
    }

    public void editaAmbiente() {
        String dado;
        int id;

        System.out.println("\nDigite o ID do Ambiente: ");
        id = Integer.parseInt(in.nextLine());

        if (getAmbiente(id) == null) {
            System.out.println("\nAmbiente Não Encontrado\n");
        } else {

            Ambiente a = getAmbiente(id);

            System.out.println(a.toString() + "\nEncontrado");

            System.out.println("\nInsira nova descricao do ambiente:");
            dado = in.nextLine();
            a.setDescricao(dado);

            System.out.println("\nInsira o id do novo Campus vinculado ao ambiente:");
            id = Integer.parseInt(in.nextLine());
            a.setCodCamp(id);

            a.setDatamodificacao(LocalDate.now());

            this.setAmbiente(a);

            System.out.println(a.toString() + "\nEditado com Sucesso!\n");
        }
    }

    public void excluiAmbiente() {
        System.out.println("\nDigite o ID do Ambiente: ");
        int id = Integer.parseInt(in.nextLine());

        if (getAmbiente(id) == null) {
            System.out.println("\nAmbiente Não Encontrado");

        } else {
            System.out.println("\nAmbiente " + getAmbiente(id).getId() + getAmbiente(id).getDescricao() + " Encontrado"
                    + "\nDeseja Deletar?\n1 - Sim\n2 - Não");
            int es = Integer.parseInt(in.nextLine());
            if (es == 1) {

                Ambiente del = getAmbiente(id);
                del.setDescricao("Ambiente Apagado");
                del.setCodCamp(-1);
                del.setDatacriacao(null);
                del.setDatamodificacao(null);
                System.out.println("\nAmbiente Deletado\n");

            } else {
                System.out.println("\nAmbiente Mantido\n");
            }
        }
    }

    public int achaAmbienteId(int id) {
        for (int x = 0; x < this.qtdAmb; x++) {
            if (id == ambs[x].getId() && ambs[x] != null) {
                return x;
            } else {

            }
        }
        return -1;
    }

    public void mostraAmbientesPorServ(Servidor s) {
        for (int x = 0; x < this.qtdAmb; x++) {
            if (ambs[x] != null) {
                if (s.getCampus() == ambs[x].getCodCamp()) {
                    System.out.println(this.ambs[x].toString());
                }
            } else {

            }
        }
    }

    public void mostraAmbientesPorCampus(Campus c) {
        for (int x = 0; x < this.qtdAmb; x++) {
            if (ambs[x] != null) {
                if (ambs[x].getCodCamp() == c.getId()) {
                    System.out.println(this.ambs[x].toString());
                }
            } else {

            }
        }
    }

    public Ambiente getAmbientesPorCampus(Campus c) {
        for (int x = 0; x < this.qtdAmb; x++) {
            if (ambs[x].getCodCamp() == c.getId() && ambs[x] != null) {
                return ambs[x];
            } else {
            }
        }
        return null;
    }

    public Ambiente getAmbiente(int id) {
        int x = achaAmbienteId(id);
        if (x == -1) {
            return null;
        } else {
            return ambs[x];
        }
    }

    public int vagaAmbiente() {
        for (int x = 0; x < qtdAmb; x++) {
            if (ambs[x] == null) {
                return x;
            } else {

            }
        }
        return -1;
    }

    public boolean setAmbiente(Ambiente amb) {
        int pos = vagaAmbiente();
        if (pos == -1) {
            System.out.println("\nLista de Campus Cheia\n");
            return false;
        } else {
            ambs[pos] = amb;
            this.qtdAmb++;
            return true;
        }
    }

    public void valorPorAmbiente(ItemDAO iDAO, int idServ, CampusDAO cDAO) {
        for (int x = 0; x < this.qtdAmb; x++) {
            double totalAmb = iDAO.valorPorAmbiente(ambs[x].getId(), idServ);

            if (totalAmb != 0) {
                System.out.println("\t" + ambs[x].getDescricao() + " - " + cDAO.getCampus(ambs[x].getCodCamp()).getNome() + " R$" + totalAmb);
            }
        }
    }
}
