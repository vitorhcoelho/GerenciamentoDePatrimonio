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
    private int codItem;
    private int codAmbOrigem;
    private int codAmbDestino;
    private String motivo;
    private LocalDate dataCriacao;
    private LocalDate dataMod;
    private boolean entrada; //true -> entrada -- false -> saida

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodItem() {
        return codItem;
    }

    public void setCodItem(int codItem) {
        this.codItem = codItem;
    }

    public int getCodAmbOrigem() {
        return codAmbOrigem;
    }

    public void setCodAmbOrigem(int codAmbOrigem) {
        this.codAmbOrigem = codAmbOrigem;
    }

    public int getCodAmbDestino() {
        return codAmbDestino;
    }

    public void setCodAmbDestino(int codAmbDestino) {
        this.codAmbDestino = codAmbDestino;
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

    public boolean isEntrada() {
        return entrada;
    }

    public void setEntrada(boolean entrada) {
        this.entrada = entrada;
    }

}
