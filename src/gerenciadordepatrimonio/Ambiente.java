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
public class Ambiente {

    private int id;
    private String descricao;
    private Campus camp;
    private LocalDate datacriacao;
    private LocalDate datamodificacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricaoambiente) {
        this.descricao = descricaoambiente;
    }

    public Campus getCampus() {
        return camp;
    }

    public void setCampus(Campus camp) {
        this.camp = camp;
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
        return "Ambiente{" + "id=" + id + ", descricaoambiente=" + descricao + ", camp=" + camp + ", datacriacao=" + datacriacao + ", datamodificacao=" + datamodificacao + '}';
    }

}
