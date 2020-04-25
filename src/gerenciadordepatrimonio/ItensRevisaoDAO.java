/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordepatrimonio;

import java.util.Scanner;

/**
 *
 * @author gusta
 */
public class ItensRevisaoDAO {

    private ItensRevisao[] itRev = new ItensRevisao[300];
    private int qtdIRev = 0;
    private int id = 0;
    Scanner in = new Scanner(System.in);

    public int geraId() {
        this.id++;
        return this.id;
    }

    public void insereItensRev(int idRev, Item item) {
        ItensRevisao iR = new ItensRevisao();
        iR.setIdRevisao(idRev);
        iR.setItem(item);
        iR.setId(geraId());
        iR.setEncontrado(false);
        iR.setPago(false);
        setItemRevisao(iR);
    }

    public void revisionar(int idRev) {
        int opc = 5;
        while (opc != 0) {
            for (int x = 0; x < qtdIRev; x++) {
                if (itRev[x].getIdRevisao() == idRev && itRev[x].isEncontrado() == false && itRev[x].isPago() == false) {
                    System.out.println(itRev[x].getItem().getEspecificacao() + "\nCódigo de Patrimônio: " + itRev[x].getItem().getCodigo()
                            + "\nEncontrado?\n1 - Sim\n2 - Não\n0 - Sair");
                    opc = Integer.parseInt(in.nextLine());
                    if(opc == 2){
                        System.out.println("\nNão Encontrado!\nItem deve ser pago!\nFoi pago?\n1 - Sim\n2 - Não");
                        int esc = Integer.parseInt(in.nextLine());
                        if(esc == 1){
                            System.out.println("\nItem Pago\n");
                            itRev[x].setPago(true);
                        }else{
                            System.out.println("\nItem Não Pago!\nEncaminhando Próximo Item...");
                        }
                    }
                    
                }
            }
        }
    }

    public int vagaItemRevisao() {
        for (int x = 0; x < itRev.length; x++) {
            if (itRev[x] == null) {
                return x;
            } else {

            }
        }
        return -1;
    }

    public boolean setItemRevisao(ItensRevisao rev) {
        int pos = vagaItemRevisao();
        if (pos == -1) {
            System.out.println("\nLista de Itens de Revisões Cheia\n");
            return false;
        } else {
            this.qtdIRev++;
            itRev[pos] = rev;
            return true;
        }
    }

    public int achaIRevIdRev(int idRev) {
        for (int x = 0; x < this.itRev.length; x++) {
            if (idRev == itRev[x].getIdRevisao() && itRev[x] != null) {
                return x;
            } else {

            }
        }
        return -1;
    }

    public ItensRevisao getIRevisaoIdRev(int id) {
        int x = achaIRevIdRev(id);
        if (x == -1) {
            return null;
        } else {
            return itRev[x];
        }
    }

}
