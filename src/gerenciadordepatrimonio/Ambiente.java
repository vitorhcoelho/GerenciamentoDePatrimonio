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
    private int codCamp;
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

    public int getCodCamp() {
        return codCamp;
    }

    public void setCodCamp(int codCamp) {
        this.codCamp = codCamp;
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
        return "\nID Ambiente: " + this.id + "\tID Campus: " + this.codCamp + "\tDescrição: " + this.descricao
                + "\nData de Criação: " + this.datacriacao
                + "\nData de Modificação: " + this.datamodificacao;
    }

}
