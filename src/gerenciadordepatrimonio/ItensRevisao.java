/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordepatrimonio;

/**
 *
 * @author gusta
 */
public class ItensRevisao {

    private int id;
    private int idRevisao;
    private Item item = new Item();
    private boolean encontrado;
    private boolean pago;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRevisao() {
        return idRevisao;
    }

    public void setIdRevisao(int idRevisao) {
        this.idRevisao = idRevisao;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean isEncontrado() {
        return encontrado;
    }

    public void setEncontrado(boolean encontrado) {
        this.encontrado = encontrado;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public String traduzEncontrado() {
        if (this.encontrado) {
            return "Sim";
        } else {
            return "Não";
        }
    }

    public String traduzPago() {
        if (this.pago) {
            return "Sim";
        } else {
            return "Não";
        }
    }

    @Override
    public String toString() {
        return "Item: " + item.getEspecificacao() + "\tID: " + item.getId()
                + "\nEncontrado? > " + traduzEncontrado() + "\tPago? > " + traduzPago()
                + "\n-----------------------------------------------------------\n";
    }

}
