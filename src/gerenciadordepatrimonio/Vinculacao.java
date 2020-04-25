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

    private int codAmb;
    private int codItem;

    public int getCodAmb() {
        return codAmb;
    }

    public void setCodAmb(int codAmb) {
        this.codAmb = codAmb;
    }

    public int getCodItem() {
        return codItem;
    }

    public void setCodItem(int codItem) {
        this.codItem = codItem;
    }

    @Override
    public String toString() {
        return "\nVinculacao: " + "Ambiente ID: " + codAmb + ", Item ID: " + codItem;
    }

}
