/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordepatrimonio;

import java.time.LocalDate;

/**
 *
 * @author Vitor Hugo
 */
public class Item {
    private int id;
    private String especificacao;
    private String codigo;
    private int estado;
    private LocalDate datacompra;
    private double valorcompra;
    private String ambiente;
    private LocalDate datacriacao;
    private LocalDate datamodificacao;

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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public LocalDate getDatacompra() {
        return datacompra;   
    }

    public void setDatacompra(LocalDate datacompra) {
        this.datacompra = datacompra;
    }

    public double getValorcompra() {
        return valorcompra;
    }

    public void setValorcompra(double valorcompra) {
        this.valorcompra = valorcompra;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public LocalDate getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(LocalDate datacriacao) {
        this.datacriacao = datacriacao;
    }

    public LocalDate getDatamodificacao() {
        return datamodificacao;
    }

    public void setDatamodificacao(LocalDate datamodificacao) {
        this.datamodificacao = datamodificacao;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", especificacao=" + especificacao + ", codigo=" + codigo + ", estado=" + estado + ", datacompra=" + datacompra + ", valorcompra=" + valorcompra + ", ambiente=" + ambiente + ", datacriacao=" + datacriacao + ", datamodificacao=" + datamodificacao + '}';
    }
}
