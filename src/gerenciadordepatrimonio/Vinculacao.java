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
public class Vinculacao {
    private Ambiente amb;

    public Ambiente getAmb() {
        return amb;
    }

    public void setAmb(Ambiente amb) {
        this.amb = amb;
    }

    @Override
    public String toString() {
        return "Vinculacao{" + "amb=" + amb + '}';
    }
}
