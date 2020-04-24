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
public class MovimentoAmbienteDAO {

    private MovimentoAmbiente[] movAmb = new MovimentoAmbiente[100];
    private int id = 0;
    Scanner in = new Scanner(System.in);

    public int geraId() {
        this.id++;
        return id;
    }

    public int vagaMovAmb() {
        for (int x = 0; x < movAmb.length; x++) {
            if (movAmb[x] == null) {
                return x;
            } else {

            }
        }
        return -1;
    }

    public boolean setMovAmb(MovimentoAmbiente mov) {
        int pos = vagaMovAmb();
        if (pos == -1) {
            System.out.println("\nLista de Campus Cheia\n");
            return false;
        } else {
            movAmb[pos] = mov;
            return true;
        }
    }

    public int achaMovimentoAmb(int id) {
        for (int x = 0; x < movAmb.length; x++) {
            if (id == movAmb[x].getId() && movAmb[x] != null) {
                return x;
            } else {

            }
        }
        return -1;
    }

    public MovimentoAmbiente getMovimentoAmb(int id) {
        int x = achaMovimentoAmb(id);
        if (x == -1) {
            return null;
        } else {
            return movAmb[x];
        }
    }

    public void insereAuto(int item, int ambOrigem, int ambDestino, int mot) {
        MovimentoAmbiente m = new MovimentoAmbiente();

        m.setId(geraId());
        m.setIdItem(item);
        m.setAmbienteOrigem(ambOrigem);
        m.setAmbienteDestino(ambDestino);
        m.setDataCriacao(LocalDate.now());
        m.setDataModificacao(LocalDate.now());

        if (mot == 0) {
            m.setMotivo("Deletado");
        } else {
            m.setMotivo("Novo ou Editado em Itens");
        }
        setMovAmb(m);

    }

    public void insereMovAmb(ItemDAO iDAO) {
        String dado;
        int idItem;
        int idAmb;
        MovimentoAmbiente mAmb = new MovimentoAmbiente();

        System.out.println("\nDigite o ID do item movido: ");
        idItem = Integer.parseInt(in.nextLine());
        mAmb.setIdItem(idItem);

        if (iDAO.getItem(idItem) == null) {
            System.out.println("\nID de Item Inválido!\n");
        } else {
            mAmb.setAmbienteOrigem(iDAO.getItem(idItem).getAmbienteId());

            System.out.println("\nDigite o ID do ambiente de destino: ");
            idAmb = Integer.parseInt(in.nextLine());
            mAmb.setAmbienteDestino(idAmb);

            iDAO.getItem(idItem).setAmbienteId(idAmb);

            System.out.println("\nDescreva o motivo da movimentação de item: ");
            dado = in.nextLine();
            mAmb.setMotivo(dado);

            mAmb.setDataCriacao(LocalDate.now());
            mAmb.setDataModificacao(LocalDate.now());

            mAmb.setId(geraId());

            if (mAmb != null) {
                setMovAmb(mAmb);
                System.out.println(mAmb.toString() + "\nMovimentação Inserida\n");
            } else {
                System.out.println("\nErro Null\n");
            }

        }

    }

    public void editaMovAmb(ItemDAO iDAO) {
        String dado;
        int ids;
        int idItem;

        System.out.println("\nDigite o ID da Movimentação que deseja editar: ");
        int aux = Integer.parseInt(in.nextLine());

        if (getMovimentoAmb(aux) == null) {
            System.out.println("\nMovimentação Não Encontrada!\n");
        } else {

            MovimentoAmbiente mAmb = getMovimentoAmb(aux);

            System.out.println(getMovimentoAmb(aux).toString() + "\nEncontrado!\n");

            System.out.println("\nDigite o ID do item movido: ");
            idItem = Integer.parseInt(in.nextLine());
            mAmb.setIdItem(idItem);

            if (iDAO.getItem(idItem) == null) {
                System.out.println("\nID de Item Inválido!\n");
            } else {

                System.out.println("\nDigite o ID do ambiente de destino: ");
                ids = Integer.parseInt(in.nextLine());
                mAmb.setAmbienteDestino(ids);
                
                iDAO.getItem(idItem).setAmbienteId(ids);

                System.out.println("\nDescreva o motivo da movimentação de item: ");
                dado = in.nextLine();
                mAmb.setMotivo(dado);

                mAmb.setDataModificacao(LocalDate.now());

                if (mAmb != null) {
                    System.out.println(mAmb.toString() + "\nMovimentação Editada\n");
                } else {
                    System.out.println("\nErro Null\n");
                }

            }
        }
    }

    public void excluiMovimentoAmb() {
        System.out.println("\nDigite o ID da Movimentação que deseja editar: ");
        int aux = Integer.parseInt(in.nextLine());

        if (getMovimentoAmb(aux) == null) {
            System.out.println("\nMovimentação Não Encontrada!\n");
        } else {
            System.out.println(getMovimentoAmb(aux).toString() + "\nEncontrado!\n");
            System.out.println("\nDeseja Deletar?\n1 - Sim\n2 - Não");
            int es = Integer.parseInt(in.nextLine());
            if (es == 1) {

                MovimentoAmbiente del = getMovimentoAmb(aux);
                del.setMotivo("Campus Apagado");
                del.setAmbienteDestino(-1);
                del.setAmbienteOrigem(-1);
                del.setDataCriacao(null);
                del.setDataModificacao(null);
                del.setIdItem(-1);
                System.out.println("\nMovimentação Deletada\n");

            } else {
                System.out.println("\nMovimentação Mantida\n");
            }
        }
    }
}
