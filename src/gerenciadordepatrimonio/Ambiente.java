/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordepatrimonio;

/**
 *
 * @author Vitor Hugo
 */
public class Ambiente {
    private int id;
    private String descricaoambiente;
    private Campus camp;
    private String datacriacao;
    private String datamodificacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricaoambiente() {
        return descricaoambiente;
    }

    public void setDescricaoambiente(String descricaoambiente) {
        this.descricaoambiente = descricaoambiente;
    }

    public Campus getCamp() {
        return camp;
    }

    public void setCamp(Campus camp) {
        this.camp = camp;
    }

    public String getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(String datacriacao) {
        this.datacriacao = datacriacao;
    }

    public String getDatamodificacao() {
        return datamodificacao;
    }

    public void setDatamodificacao(String datamodificacao) {
        this.datamodificacao = datamodificacao;
    }
}
