/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordepatrimonio;

import com.sun.org.apache.xpath.internal.operations.Gt;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author gusta
 */
public class RevisaoDAO {

    public void adiciona(Revisao novo) {
        String sql = "insert into revisao "
                + "(ano, idservidor, idamb, estado, datacriacao, datamodificacao)"
                + " values (?,?,?,?,?,?)";

        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt;
            stmt = con.prepareStatement(sql);

            stmt.setString(1, novo.getAno());
            stmt.setInt(2, novo.getIdServ());
            stmt.setInt(3, novo.getIdAmb());
            stmt.setInt(4, novo.getEstado());
            stmt.setDate(5, novo.getDataCriacao());
            stmt.setDate(6, novo.getDataModificacao());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Revisão adicionada", "", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Adicionar", "", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }

    public void altera(Revisao alterado, int id) {
        String sql = "UPDATE revisao SET ano = ?,"
                + " idservidor = ? , idamb = ? , estado = ? , datacriacao = ? ,"
                + " datamodificacao = ? WHERE (idrevisao = ?)";

        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, alterado.getAno());
            stmt.setInt(2, alterado.getIdServ());
            stmt.setInt(3, alterado.getIdAmb());
            stmt.setInt(4, alterado.getEstado());
            stmt.setDate(5, alterado.getDataCriacao());
            stmt.setDate(6, alterado.getDataModificacao());
            stmt.setInt(7, id);

            stmt.execute();
            stmt.close();

            System.out.println("ok");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void exclui(Revisao rev) {
        String sql = "delete from revisao where idrevisao = ?";

        try (Connection con = new ConnectionFactory().Conn()) {

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, rev.getId());

            stmt.execute();
            stmt.close();

            System.out.println("ok");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Revisao> lista() {
        List<Revisao> listRev = new ArrayList<>();
        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt;
            stmt = con.prepareStatement("select * from revisao");
            ResultSet rs;
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idrevisao");
                String ano = rs.getString("ano");
                int idserv = rs.getInt("idservidor");
                int idamb = rs.getInt("idamb");
                int estado = rs.getInt("estado");
                Date datacriacao = rs.getDate("datacriacao");
                Date datamod = rs.getDate("datamodificacao");

                Revisao c = new Revisao();
                c.setId(id);
                c.setAno(ano);
                c.setIdServ(idserv);
                c.setIdAmb(idamb);
                c.setEstado(estado);
                c.setDataCriacao(datacriacao);
                c.setDataModificacao(datamod);
                listRev.add(c);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listRev;
    }

    public void imprime(List<Revisao> rev) {
        List<Revisao> listRev = new ArrayList<>();
        for (Revisao c : rev) {
            System.out.println(c);
        }
    }

    public int buscaIdRevisao(String year, int ids, int ida) {
        List<Revisao> listRev = new ArrayList<>();
        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt;
            stmt = con.prepareStatement("select * from revisao where idamb = ?");
            stmt.setInt(1, ida);
            ResultSet rs;
            rs = stmt.executeQuery();

            while (rs.next()) {
                String ano = rs.getString("ano");
                int idserv = rs.getInt("idservidor");
                if (idserv == ids) {
                    if (ano.equals(year)) {
                        int id = rs.getInt("idrevisao");
                        return id;
                    }
                }
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

//    private Revisao[] revs = new Revisao[30];
//    private int id = 0;
//    private int qtdRev = 0;
//    Scanner in = new Scanner(System.in);
//
//    public int geraId() {
//        this.id++;
//        return id;
//    }
//
//    public void criaRevisao(int serv, int amb, ItemDAO iDAO, ItensRevisaoDAO iRDAO) {
//        Revisao rev = new Revisao();
//
//        System.out.println("\nDigite o Ano Referente a Revisão: ");
//        int aux = Integer.parseInt(in.nextLine());
//        rev.setAno(aux);
//
//        rev.setAno(aux);
//        rev.setEstado(1);
//        rev.setIdAmb(amb);
//        rev.setIdServ(serv);
//        rev.setDataCriacao(LocalDate.now());
//        rev.setDataModificacao(LocalDate.now());
//        rev.setId(geraId());
//
//        setRevisao(rev);
//
//        iDAO.itemRevisao(rev.getId(), amb, iRDAO);
//
//        System.out.println("\nRevisão Criada: \n" + getRevisaoAmb(amb));
//
//    }
//
//    public void andamentoRevisao(int amb, ItensRevisaoDAO iRDAO, ItemDAO iDAO, MovimentoAmbienteDAO mADAO, MovimentoDonoDAO mDDAO) {
//        Revisao r = getRevisaoAmb(amb);
//        int idRev = r.getId();
//
//        if (r.getEstado() == 1) {
//            r.setEstado(2);
//
//            System.out.println("\n");
//            iRDAO.revisionar(idRev, iDAO, mADAO, mDDAO);
//            r.setDataModificacao(LocalDate.now());
//
//            iRDAO.estadoRevisao(idRev, r);
//        } else if (r.getEstado() == 2) {
//            System.out.println("\n");
//            iRDAO.revisionar(idRev, iDAO, mADAO, mDDAO);
//            r.setDataModificacao(LocalDate.now());
//
//            iRDAO.estadoRevisao(idRev, r);
//        } else {
//            System.out.println("\nEssa Revisão Foi Terminada\n");
//        }
//
//    }
//
//    public void excluiRevisao(int amb, ItensRevisaoDAO iRDAO) {
//
//        if (getRevisaoAmb(amb) != null) {
//            Revisao r = getRevisaoAmb(amb);
//            int idRev = r.getId();
//
//            iRDAO.exclui(idRev);
//            r.setAno(-1);
//            r.setDataCriacao(null);
//            r.setDataModificacao(null);
//            r.setEstado(-1);
//            r.setIdAmb(-1);
//            r.setIdServ(-1);
//            System.out.println("\nRevisão Deletada!\n");
//        } else {
//
//        }
//    }
//
//    public int vagaRevisao() {
//        for (int x = 0; x < revs.length; x++) {
//            if (revs[x] == null) {
//                return x;
//            } else {
//
//            }
//        }
//        return -1;
//    }
//
//    public boolean setRevisao(Revisao rev) {
//        int pos = vagaRevisao();
//        if (pos == -1) {
//            System.out.println("\nLista de Revisões Cheia\n");
//            return false;
//        } else {
//            this.qtdRev++;
//            revs[pos] = rev;
//            return true;
//        }
//    }
//
//    public int achaRevisaoId(int id) {
//        for (int x = 0; x < this.revs.length; x++) {
//            if (id == revs[x].getId() && revs[x] != null) {
//                return x;
//            } else {
//
//            }
//        }
//        return -1;
//    }
//
//    public Revisao getRevisaoId(int id) {
//        int x = achaRevisaoId(id);
//        if (x == -1) {
//            return null;
//        } else {
//            return revs[x];
//        }
//    }
//
//    public int achaRevisaoServ(int serv) {
//        for (int x = 0; x < this.revs.length; x++) {
//            if (serv == revs[x].getIdServ() && revs[x] != null) {
//                return x;
//            } else {
//
//            }
//        }
//        return -1;
//    }
//
//    public Revisao getRevisaoServ(int id) {
//        int x = achaRevisaoServ(id);
//        if (x == -1) {
//            return null;
//        } else {
//            return revs[x];
//        }
//    }
//
//    public int achaRevisaoAmb(int amb) {
//        for (int x = 0; x < this.qtdRev; x++) {
//            if (amb == revs[x].getIdAmb() && revs[x] != null) {
//                return x;
//            } else {
//
//            }
//        }
//        return -1;
//    }
//
//    public Revisao getRevisaoAmb(int id) {
//        int x = achaRevisaoAmb(id);
//        if (x == -1) {
//            return null;
//        } else {
//            return revs[x];
//        }
//    }
}
