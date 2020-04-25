/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordepatrimonio;

import com.sun.org.apache.xpath.internal.operations.Gt;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author gusta
 */
public class RevisaoDAO {

    private Revisao[] revs = new Revisao[30];
    private int id = 0;
    Scanner in = new Scanner(System.in);

    public int geraId() {
        this.id++;
        return id;
    }

    public void criaRevisao(int serv, int amb, ItemDAO iDAO, ItensRevisaoDAO iRDAO) {
        Revisao rev = new Revisao();

        System.out.println("\nDigite o Ano Referente a Revisão: ");
        int aux = Integer.parseInt(in.nextLine());
        rev.setAno(aux);

        rev.setAno(aux);
        rev.setEstado(1);
        rev.setIdAmb(amb);
        rev.setIdServ(serv);
        rev.setDataCriacao(LocalDate.now());
        rev.setDataModificacao(LocalDate.now());
        rev.setId(geraId());

        setRevisao(rev);

        iDAO.itemRevisao(rev.getId(), amb, iRDAO);

        System.out.println("\nRevisão Criada: \n" + rev.toString());

    }

    public void andamentoRevisao(int amb, ItensRevisaoDAO iRDAO, ItemDAO iDAO, MovimentoAmbienteDAO mADAO, MovimentoDonoDAO mDDAO) {
        Revisao r = getRevisaoAmb(amb);
        int idRev = r.getId();
        r.setEstado(2);

        iRDAO.revisionar(idRev, iDAO, mADAO, mDDAO);
        r.setDataModificacao(LocalDate.now());

        iRDAO.estadoRevisao(idRev, r);

    }

    public void excluiRevisao(int amb, ItensRevisaoDAO iRDAO) {

        if (getRevisaoAmb(amb) != null) {
            Revisao r = getRevisaoAmb(amb);
            int idRev = r.getId();

            iRDAO.exclui(idRev);
            r.setAno(-1);
            r.setDataCriacao(null);
            r.setDataModificacao(null);
            r.setEstado(-1);
            r.setIdAmb(-1);
            r.setIdServ(-1);
            System.out.println("\nRevisão Deletada!\n");
        }else{
            
        }
    }

    public int vagaRevisao() {
        for (int x = 0; x < revs.length; x++) {
            if (revs[x] == null) {
                return x;
            } else {

            }
        }
        return -1;
    }

    public boolean setRevisao(Revisao rev) {
        int pos = vagaRevisao();
        if (pos == -1) {
            System.out.println("\nLista de Revisões Cheia\n");
            return false;
        } else {
            revs[pos] = rev;
            return true;
        }
    }

    public int achaRevisaoId(int id) {
        for (int x = 0; x < this.revs.length; x++) {
            if (id == revs[x].getId() && revs[x] != null) {
                return x;
            } else {

            }
        }
        return -1;
    }

    public Revisao getRevisaoId(int id) {
        int x = achaRevisaoId(id);
        if (x == -1) {
            return null;
        } else {
            return revs[x];
        }
    }

    public int achaRevisaoServ(int serv) {
        for (int x = 0; x < this.revs.length; x++) {
            if (serv == revs[x].getIdServ() && revs[x] != null) {
                return x;
            } else {

            }
        }
        return -1;
    }

    public Revisao getRevisaoServ(int id) {
        int x = achaRevisaoServ(id);
        if (x == -1) {
            return null;
        } else {
            return revs[x];
        }
    }
    
    public int achaRevisaoAmb(int amb) {
        for (int x = 0; x < this.revs.length; x++) {
            if (amb == revs[x].getIdAmb() && revs[x] != null) {
                return x;
            } else {

            }
        }
        return -1;
    }

    public Revisao getRevisaoAmb(int id) {
        int x = achaRevisaoAmb(id);
        if (x == -1) {
            return null;
        } else {
            return revs[x];
        }
    }
}
