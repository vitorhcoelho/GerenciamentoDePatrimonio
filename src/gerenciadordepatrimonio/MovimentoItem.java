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
public class MovimentoItem {

    private int id;
    private Item item;
    private Ambiente ambienteOrigem;
    private Ambiente ambienteDestino;
    private String motivo;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Ambiente getAmbienteOrigem() {
        return ambienteOrigem;
    }

    public void setAmbienteOrigem(Ambiente ambienteOrigem) {
        this.ambienteOrigem = ambienteOrigem;
    }

    public Ambiente getAmbienteDestino() {
        return ambienteDestino;
    }

    public void setAmbienteDestino(Ambiente ambienteDestino) {
        this.ambienteDestino = ambienteDestino;
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

}
