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
    int id;
    int idAmb;
    int idDonoOrigem;
    int idDonoDestino;
    String motivo;
    LocalDate dataCriacao;
    LocalDate dataMod;
}
