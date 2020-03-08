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
    int id;
    int codItem;
    int codAmbOrigem;
    int codAmbDestino;
    String motivo;
    LocalDate dataCriacao;
    LocalDate dataMod;
    boolean entrada; //true -> entrada -- false -> saida
}
