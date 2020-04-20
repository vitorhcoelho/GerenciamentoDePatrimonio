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
public class ItemDAO {

    private Item[] itens = new Item[221];
    private int qtdItem;
    private int id = 0;
    Scanner in = new Scanner(System.in);

    public int geraId() {
        this.id++;
        return id;
    }

    public void insereItem() {
        String dado;
        int estado;
        double valor;
        int idAmbiente;
        Item i = new Item();

        System.out.println("\nEspecificação: ");
        dado = in.nextLine();
        i.setEspecificacao(dado);

        while (dado.length() < 6) {
            System.out.println("\nCódigo de patrimônio (6 digitos): ");

            dado = in.nextLine();

        }
        i.setCodigo(dado);

        System.out.println("\nEstado de conservação do item: ");
        do {
            estado = Integer.parseInt(in.nextLine());
            i.setEstado(estado);
        } while (estado > 0 || estado > 8);

        System.out.println("\nData de compra do item (use o padrão dd/MM/yyyy): ");
        dado = in.nextLine();
        i.setDatacompra(dado);

        System.out.println("\nValor de compra do item: ");
        valor = Double.parseDouble(in.nextLine());
        i.setValorcompra(valor);

        System.out.println("\nAmbiente do item: ");
        idAmbiente = Integer.parseInt(in.nextLine());
        i.setAmbiente(idAmbiente);

        LocalDate hoje = LocalDate.now();
        i.setDatacriacao(hoje);

        i.setId(geraId());
        this.setItem(i);

        System.out.println(i.toString() + "\nIncluído com Sucesso!\n");
    }

//    public void editaItem() {
//        
//    }
    public int vagaItem() {
        for (int x = 0; x < itens.length; x++) {
            if (itens[x] == null) {
                return x;
            } else {

            }
        }
        return -1;
    }

    public boolean setItem(Item item) {
        int pos = vagaItem();
        if (pos == -1) {
            System.out.println("\nLista de Campus Cheia\n");
            return false;
        } else {
            itens[pos] = item;
            this.qtdItem++;
            return true;
        }
    }

}
