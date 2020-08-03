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
 *
 * @author Vitor Hugo
 */
public class Item {

    private int id;
    private String especificacao;
    private String codigo;
    private int estado;
    private String datacompra;
    private String valorcompra;
    private int idDono;
    private int ambienteId;
    private Date datacriacao;
    private Date datamodificacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getIdDono() {
        return idDono;
    }

    public void setIdDono(int idDono) {
        this.idDono = idDono;
    }

    public int getAmbienteId() {
        return ambienteId;
    }

    public void setAmbienteId(int ambiente) {
        this.ambienteId = ambiente;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getDatacompra() {
        return datacompra;
    }

    public void setDatacompra(String datacompra) {
        this.datacompra = datacompra;
    }

    public String getValorcompra() {
        return valorcompra;
    }

    public void setValorcompra(String valorcompra) {
        this.valorcompra = valorcompra;
    }

    public Date getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(Date datacriacao) {
        this.datacriacao = datacriacao;
    }

    public Date getDatamodificacao() {
        return datamodificacao;
    }

    public void setDatamodificacao(Date datamodificacao) {
        this.datamodificacao = datamodificacao;
    }

    @Override
    public String toString() {
        return "\nId Item: " + this.id + "\tEspecificação: " + this.especificacao + "\nCódigo de Patrimonio: "
                + this.codigo + "\tEstado: " + this.estado + "\nData da Compra: " + this.datacompra
                + "\tValor da Compra: " + this.valorcompra + "\nId de Ambiente: " + this.ambienteId
                + "\tData Criação: " + this.datacriacao + "\nId de Dono: " + getIdDono();
    }
}
