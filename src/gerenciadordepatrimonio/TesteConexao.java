/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordepatrimonio;

import java.sql.Connection;

/**
 *
 * @author Vitor Hugo
 */
public class TesteConexao {
    public static void main(String[] args) {

        try(Connection con = new ConnectionFactory().Conn()){

            System.out.println("Banco ok");

        }catch(Exception e){
            System.err.println("Erro de Conexão: " + e);
        }

    }
}
