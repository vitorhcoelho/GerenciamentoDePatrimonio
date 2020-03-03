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
public class Movimentacao {
    private boolean entrada;
    private int id;
    private Item it;
    private Ambiente origem;
    private Ambiente destino;
    private String motivo;
    private String datacriacao;
    private String datamodificacao;

    public boolean isEntrada() {
        return entrada;
    }

    public void setEntrada(boolean entrada) {
        this.entrada = entrada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getIt() {
        return it;
    }

    public void setIt(Item it) {
        this.it = it;
    }

    public Ambiente getOrigem() {
        return origem;
    }

    public void setOrigem(Ambiente origem) {
        this.origem = origem;
    }

    public Ambiente getDestino() {
        return destino;
    }

    public void setDestino(Ambiente destino) {
        this.destino = destino;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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

    @Override
    public String toString() {
        return "Movimentacao{" + "entrada=" + entrada + ", id=" + id + ", it=" + it + ", origem=" + origem + ", destino=" + destino + ", motivo=" + motivo + ", datacriacao=" + datacriacao + ", datamodificacao=" + datamodificacao + '}';
    }
}
