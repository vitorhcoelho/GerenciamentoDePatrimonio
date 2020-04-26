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
public class MovimentoDonoDAO {

    private MovimentoDono[] movDono = new MovimentoDono[221];
    private int qtdMovDono;
    private int id = 0;
    Scanner in = new Scanner(System.in);

    public int geraId() {
        this.id++;
        return id;
    }

    public void insereAuto(int item, int donoOrigem, int donoDestino, int mot) {
        MovimentoDono m = new MovimentoDono();

        m.setId(geraId());
        m.setIdItem(item);
        m.setDonoOrigem(donoOrigem);
        m.setDonoDestino(donoDestino);
        m.setDataCriacao(LocalDate.now());
        m.setDataModificacao(LocalDate.now());

        if (mot == 0) {
            m.setMotivo("Deletado");
        } else {
            m.setMotivo("Novo ou Editado em Itens");
        }

        setMovDono(m);

    }

    public void insereMov(ItemDAO iDAO) {
        String dado;
        double valor;
        int ids;
        int idItem;
        MovimentoDono m = new MovimentoDono();

        System.out.println("\nDigite o ID do item movido: ");
        idItem = Integer.parseInt(in.nextLine());
        m.setIdItem(idItem);

        if (iDAO.getItem(idItem) == null) {
            System.out.println("\nID de Item Inválido!\n");
        } else {

            m.setDonoOrigem(iDAO.getItem(idItem).getIdDono());

            System.out.println("\nDigite o ID do Dono de destino: ");
            ids = Integer.parseInt(in.nextLine());
            m.setDonoDestino(ids);

            iDAO.getItem(idItem).setIdDono(ids);

            System.out.println("\nDescreva o motivo da movimentação de item: ");
            dado = in.nextLine();
            m.setMotivo(dado);

            m.setDataCriacao(LocalDate.now());
            m.setDataModificacao(LocalDate.now());

            m.setId(geraId());

            if (m != null) {
                setMovDono(m);
                System.out.println(m.toString() + "\nMovimentação Inserida\n");
            } else {
                System.out.println("\nErro Null\n");
            }
        }
    }

    public void editaMovDono(ItemDAO iDAO) {
        String dado;
        int ids;

        System.out.println("\nDigite o ID da Movimentação que deseja editar: ");
        int aux = Integer.parseInt(in.nextLine());

        if (getMovimentoDono(aux) == null) {
            System.out.println("\nMovimentação Não Encontrada!\n");
        } else {

            MovimentoDono m = getMovimentoDono(aux);

            System.out.println(getMovimentoDono(aux).toString() + "\nEncontrado!\n");
            
            int idItem = getMovimentoDono(aux).getIdItem();

            if (iDAO.getItem(idItem) == null) {
                System.out.println("\nItem De Movimentação Não Existe Mais\n");
            } else {

                System.out.println("\nDigite o ID do Dono de destino: ");
                ids = Integer.parseInt(in.nextLine());
                m.setDonoDestino(ids);

                System.out.println("\nDescreva o motivo da movimentação de item: ");
                dado = in.nextLine();
                m.setMotivo(dado);

                m.setDataModificacao(LocalDate.now());

                if (m != null) {
                    System.out.println(m.toString() + "\nMovimentação Editada\n");
                } else {
                    System.out.println("\nErro Null\n");
                }

            }
        }
    }

    public void excluiMovimentoDono() {
        System.out.println("\nDigite o ID da Movimentação que deseja editar: ");
        int aux = Integer.parseInt(in.nextLine());

        if (getMovimentoDono(aux) == null) {
            System.out.println("\nMovimentação Não Encontrada!\n");
        } else {
            System.out.println(getMovimentoDono(aux).toString() + "\nEncontrado!\n");
            System.out.println("\nDeseja Deletar?\n1 - Sim\n2 - Não");
            int es = Integer.parseInt(in.nextLine());
            if (es == 1) {

                MovimentoDono del = getMovimentoDono(aux);
                del.setMotivo("Motivo Apagado");
                del.setDonoOrigem(-1);
                del.setDonoDestino(-1);
                del.setDataCriacao(null);
                del.setDataModificacao(null);
                del.setIdItem(-1);
                System.out.println("\nMovimentação Deletada\n");

            } else {
                System.out.println("\nMovimentação Mantida\n");
            }
        }
    }

    public int vagaMovDono() {
        for (int x = 0; x < movDono.length; x++) {
            if (movDono[x] == null) {
                return x;
            } else {

            }
        }
        return -1;
    }

    public boolean setMovDono(MovimentoDono movimentacoes) {
        int pos = vagaMovDono();
        if (pos == -1) {
            System.out.println("\nLista de Movimentações Cheia\n");
            return false;
        } else {
            movDono[pos] = movimentacoes;
            this.qtdMovDono++;
            return true;
        }
    }

    public int achaMovimentoDono(int id) {
        for (int x = 0; x < movDono.length; x++) {
            if (id == movDono[x].getId() && movDono[x] != null) {
                return x;
            } else {

            }
        }
        return -1;
    }

    public MovimentoDono getMovimentoDono(int id) {
        int x = achaMovimentoDono(id);
        if (x == -1) {
            return null;
        } else {
            return movDono[x];
        }
    }
    
    public void mostraMovDonos() {
        for (int x = 0; x < this.qtdMovDono; x++) {
            if (movDono[x] != null) {
                System.out.println(this.movDono[x].toString());
            } else {}
        }
    }
    
    public void getMovDonosPorID(int id){
        for (int i = 0; i < this.qtdMovDono; i++) {
            if(movDono[i].getIdItem() == id){
                movDono[i].toString();
            }
        }
    }
    
}
