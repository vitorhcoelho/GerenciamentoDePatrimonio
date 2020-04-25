/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordepatrimonio;

import java.time.LocalDate;

/**
 *
 * @author gusta
 */
public class Revisao {

    private int id;
    private int ano;
    private int idServ;
    private int idAmb;
    private int estado;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    private Item[] itens = new Item[100];
    private int qtdItem;

    //Estados: 1 - Não Iniciado, 2 - Andamento, 3 - Terminado
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getIdServ() {
        return idServ;
    }

    public void setIdServ(int idServ) {
        this.idServ = idServ;
    }

    public int getIdAmb() {
        return idAmb;
    }

    public void setIdAmb(int idAmb) {
        this.idAmb = idAmb;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public int getQtdItem() {
        return qtdItem;
    }

    public void setQtdItem(int qtdItem) {
        this.qtdItem = qtdItem;
    }

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
            System.out.println("\nLista de Itens Cheia\n");
            return false;
        } else {
            itens[pos] = item;
            this.qtdItem++;
            return true;
        }
    }

    @Override
    public String toString() {
        return "Revisão ID: " + getId() + "\tAno: " + getAno()
                + "\nServidor: " + getIdServ() + "\tAmbiente: " + getIdAmb()
                + "\nEstado: " + getEstado()
                + "\nData de Criação: " + getDataCriacao() + "\tÚltima Modificação: "
                + getDataModificacao();
    }

}
