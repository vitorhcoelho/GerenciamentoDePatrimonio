/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordepatrimonio;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author gusta
 */
public class MovimentoAmbiente {

    private int id;
    private int idItem;
    private int ambienteOrigem;
    private int ambienteDestino;
    private String motivo;
    private Date dataCriacao;
    private Date dataModificacao;

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

    public int getAmbienteOrigem() {
        return ambienteOrigem;
    }

    public void setAmbienteOrigem(int ambienteOrigem) {
        this.ambienteOrigem = ambienteOrigem;
    }

    public int getAmbienteDestino() {
        return ambienteDestino;
    }

    public void setAmbienteDestino(int ambienteDestino) {
        this.ambienteDestino = ambienteDestino;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @Override
    public String toString() {
        return "\nMovimentação de Item Entre Ambientes\tID: " + getId() + "\nID Item: " + getIdItem() + "\nID Ambiente Origem: "
                + getAmbienteOrigem() + "\tID Ambiente Destino: " + getAmbienteDestino()
                + "\nData Criação: " + getDataCriacao() + "\tÚltima Modificação: " + getDataModificacao()
                + "\nMotivo: " + getMotivo();
    }

}
