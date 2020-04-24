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
public class Main {

    public void start() {
        ServidorDAO servDAO = new ServidorDAO();
        CampusDAO campDAO = new CampusDAO();
        AmbienteDAO ambDAO = new AmbienteDAO();
        ItemDAO itemDAO = new ItemDAO();
        MovimentoAmbienteDAO mAmbDAO = new MovimentoAmbienteDAO();
        MovimentoDonoDAO mdonoDAO = new MovimentoDonoDAO();

        FazTudo inicia = new FazTudo();
        inicia.login(servDAO, campDAO, ambDAO, itemDAO, mAmbDAO, mdonoDAO);
    }

    public static void main(String[] args) {
        Main boost = new Main();
        boost.start();
    }

}
