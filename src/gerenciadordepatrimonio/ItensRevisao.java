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
    private int item;
    private int encontrado;
    private int pago;

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

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int isEncontrado() {
        return encontrado;
    }

    public void setEncontrado(int encontrado) {
        this.encontrado = encontrado;
    }

    public int isPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

    public String traduzEncontrado() {
        if (this.encontrado == 1) {
            return "Sim";
        } else {
            return "Não";
        }
    }

    public String traduzPago() {
        if (this.pago == 1) {
            return "Sim";
        } else {
            return "Não";
        }
    }

//    @Override
//    public String toString() {
//        return "Item: " + item.getEspecificacao() + "\tID: " + item.getId()
//                + "\nEncontrado? > " + traduzEncontrado() + "\tPago? > " + traduzPago()
//                + "\n-----------------------------------------------------------\n";
//    }

}
