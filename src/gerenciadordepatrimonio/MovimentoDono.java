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
public class MovimentoDono {

    private int id;
    private int idItem;
    private int donoOrigem;
    private int donoDestino;
    private String motivo;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getDonoOrigem() {
        return donoOrigem;
    }

    public void setDonoOrigem(int donoOrigem) {
        this.donoOrigem = donoOrigem;
    }

    public int getDonoDestino() {
        return donoDestino;
    }

    public void setDonoDestino(int donoDestino) {
        this.donoDestino = donoDestino;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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

    @Override
    public String toString() {
        return "\nMovimentação de Item Entre Donos\tID: " + getId() + "\nID Item: " + getIdItem() + "\nID Dono Origem: "
                + getDonoOrigem() + "\tID Dono Destino: " + getDonoDestino()
                + "\nData Criação: " + getDataCriacao() + "\tÚltima Modificação: " + getDataModificacao()
                + "\nMotivo: " + getMotivo();
    }

}
