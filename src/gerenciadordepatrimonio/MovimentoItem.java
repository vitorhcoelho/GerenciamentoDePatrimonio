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
    private int idAmb;
    private int idDonoOrigem;
    private int idDonoDestino;
    private String motivo;
    private LocalDate dataCriacao;
    private LocalDate dataMod;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAmb() {
        return idAmb;
    }

    public void setIdAmb(int idAmb) {
        this.idAmb = idAmb;
    }

    public int getIdDonoOrigem() {
        return idDonoOrigem;
    }

    public void setIdDonoOrigem(int idDonoOrigem) {
        this.idDonoOrigem = idDonoOrigem;
    }

    public int getIdDonoDestino() {
        return idDonoDestino;
    }

    public void setIdDonoDestino(int idDonoDestino) {
        this.idDonoDestino = idDonoDestino;
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

    public LocalDate getDataMod() {
        return dataMod;
    }

    public void setDataMod(LocalDate dataMod) {
        this.dataMod = dataMod;
    }

}
