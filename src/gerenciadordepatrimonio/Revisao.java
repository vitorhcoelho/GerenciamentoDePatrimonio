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
public class Revisao {

    private int id;
    private int ano;
    private int idServ;
    private int idAmb;
    private int estado;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    //Estados: 1 - Não Iniciado, 2 - Andamento, 3 - Terminado
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getIdServ() {
        return idServ;
    }

    public void setIdServ(int idServ) {
        this.idServ = idServ;
    }

    public int getIdAmb() {
        return idAmb;
    }

    public void setIdAmb(int idAmb) {
        this.idAmb = idAmb;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
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
    
    public String traduzEstado(){
        if(this.estado == 1){
            return "Não Iniciada";
        }else if(this.estado == 2 ){
            return "Em Andamento";
        }else{
            return "Terminada";
        }
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @Override
    public String toString() {
        return "\nRevisão ID: " + getId() + "\tAno: " + getAno()
                + "\nServidor: " + getIdServ() + "\tAmbiente: " + getIdAmb()
                + "\nEstado: " + traduzEstado()
                + "\nData de Criação: " + getDataCriacao() + "\tÚltima Modificação: "
                + getDataModificacao();
    }

}
