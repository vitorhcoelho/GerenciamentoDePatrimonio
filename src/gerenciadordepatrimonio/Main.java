/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordepatrimonio;

import static java.awt.SystemColor.menu;


/**
 *
 * @author Vitor Hugo
 */
public class Main {
    
    public void start() {
        AdministradorDAO admDAO = new AdministradorDAO();
        ServidorDAO servDAO = new ServidorDAO();
        FazTudo fazTudo = new FazTudo();
        fazTudo.login(servDAO, admDAO);
    }
    public static void main(String[] args) {
        Main boost = new Main();
        boost.start();
    }
    
}
