/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordepatrimonio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author gusta
 */
public class AmbienteDAO {

//    private Ambiente[] ambs = new Ambiente[100];
//    private int qtdAmb = 0;
//    private int id = 0;
//    Scanner in = new Scanner(System.in);
//
//    public int geraId() {
//        this.id++;
//        return id;
//    }
    public void adiciona(Ambiente novo) {
        String sql = "insert into ambiente "
                + "(descricao, codcamp, datacriacao, datamodificacao)"
                + " values (?,?,?,?)";

        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt;
            stmt = con.prepareStatement(sql);

            stmt.setString(1, novo.getDescricao());
            stmt.setInt(2, novo.getCodCamp());
            stmt.setDate(3, novo.getDatacriacao());
            stmt.setDate(4, novo.getDatamodificacao());

            stmt.execute();
            stmt.close();

            System.out.println("ok");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(Ambiente alterado, int id) {
        String sql = "UPDATE ambiente SET descricao = ?,"
                + " codcamp = ? , datacriacao = ? , datamodificacao = ? WHERE (idamb = ?)";

        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, alterado.getDescricao());
            stmt.setInt(2, alterado.getCodCamp());
            stmt.setDate(3, alterado.getDatacriacao());
            stmt.setDate(4, alterado.getDatamodificacao());
            stmt.setInt(5, id);

            stmt.execute();
            stmt.close();

            System.out.println("ok");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void exclui(Ambiente amb) {
        String sql = "delete from ambiente where idamb = ?";

        try (Connection con = new ConnectionFactory().Conn()) {

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, amb.getId());

            stmt.execute();
            stmt.close();

            System.out.println("ok");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Ambiente> lista() {
        List<Ambiente> listAmb = new ArrayList<>();
        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt;
            stmt = con.prepareStatement("select * from ambiente");
            ResultSet rs;
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idamb");
                String descricao = rs.getString("descricao");
                int codcamp = rs.getInt("codcamp");
                Date dataCriacao = rs.getDate("datacriacao");
                Date dataModificacao = rs.getDate("datamodificacao");

                Ambiente a = new Ambiente();
                a.setId(id);
                a.setDescricao(descricao);
                a.setCodCamp(codcamp);
                a.setDatacriacao(dataCriacao);
                a.setDatamodificacao(dataModificacao);

                listAmb.add(a);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listAmb;
    }

    public void imprime(List<Ambiente> amb) {
        for (Ambiente a : amb) {
            System.out.println(a);
        }
    }

    public List<Ambiente> listaAmbPorServ(int idServ) {
        List<Ambiente> listAmb = new ArrayList<>();
        try (Connection con = new ConnectionFactory().Conn()) {
            int codCmpServ = 0;
            PreparedStatement st;
            st = con.prepareStatement("select codcampus from servidor where idservidor = ?");
            st.setInt(1, idServ);
            ResultSet res;
            res = st.executeQuery();

            while (res.next()) {
                codCmpServ = res.getInt("codcampus");
            }

            res.close();
            st.close();

            PreparedStatement stmt;
            stmt = con.prepareStatement("select * from ambiente where codcamp = ?");
            stmt.setInt(1, codCmpServ);
            ResultSet rs;
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idamb = rs.getInt("idamb");
                String descricao = rs.getString("descricao");
                int codcamp = rs.getInt("codcamp");
                Date dataCriacao = rs.getDate("datacriacao");
                Date dataModificacao = rs.getDate("datamodificacao");

                Ambiente a = new Ambiente();
                a.setId(idamb);
                a.setDescricao(descricao);
                a.setCodCamp(codcamp);
                a.setDatacriacao(dataCriacao);
                a.setDatamodificacao(dataModificacao);

                listAmb.add(a);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listAmb;
    }

    public List<Ambiente> listaPorCampus(int idCampus) {
        List<Ambiente> listAmb = new ArrayList<>();
        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt;
            stmt = con.prepareStatement("select * from ambiente where codcamp = ?");
            stmt.setInt(1, idCampus);
            ResultSet rs;
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idamb");
                String descricao = rs.getString("descricao");
                int codcamp = rs.getInt("codcamp");
                Date dataCriacao = rs.getDate("datacriacao");
                Date dataModificacao = rs.getDate("datamodificacao");

                Ambiente a = new Ambiente();
                a.setId(id);
                a.setDescricao(descricao);
                a.setCodCamp(codcamp);
                a.setDatacriacao(dataCriacao);
                a.setDatamodificacao(dataModificacao);

                listAmb.add(a);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listAmb;
    }

    //    public int achaAmbienteId(int id) {
//        for (int x = 0; x < this.qtdAmb; x++) {
//            if (id == ambs[x].getId() && ambs[x] != null) {
//                return x;
//            } else {
//
//            }
//        }
//        return -1;
//    }
//    public void mostraAmbientesPorServ(Servidor s) {
//        List<Ambiente> listAmbServ = new ArrayList<>();
//        
//        for (int x = 0; x < this.qtdAmb; x++) {
//            if (ambs[x] != null) {
//                if (s.getCampus() == ambs[x].getCodCamp()) {
//                    System.out.println(this.ambs[x].toString());
//                }
//            } else {
//
//            }
//        }
//    }
//
//    public void mostraAmbientesPorCampus(Campus c) {
//        for (int x = 0; x < this.qtdAmb; x++) {
//            if (ambs[x] != null) {
//                if (ambs[x].getCodCamp() == c.getId()) {
//                    System.out.println(this.ambs[x].toString());
//                }
//            } else {
//
//            }
//        }
//    }
//
//    public void mostraConteudoAmbientesPorCampus(Campus c, ItemDAO iDAO) {
//        for (int x = 0; x < this.qtdAmb; x++) {
//            if (this.ambs[x].getCodCamp() == c.getId() && this.ambs[x] != null) {
//                for (int i = 1; i < iDAO.getQtdItem(); i++) {
//                    if (iDAO.getItem(i).getAmbienteId() == this.ambs[x].getId()) {
//                        System.out.println(iDAO.getItem(i).toString());
//                    }
//                }
//            }
//        }
//    }
//
//    public Ambiente getAmbiente(int id) {
//        int x = achaAmbienteId(id);
//        if (x == -1) {
//            return null;
//        } else {
//            return ambs[x];
//        }
//    }
//
//    public int vagaAmbiente() {
//        for (int x = 0; x < ambs.length; x++) {
//            if (ambs[x] == null) {
//                return x;
//            } else {
//
//            }
//        }
//        return -1;
//    }
//
//    public boolean setAmbiente(Ambiente amb) {
//        int pos = vagaAmbiente();
//        if (pos == -1) {
//            System.out.println("\nLista de Campus Cheia\n");
//            return false;
//        } else {
//            ambs[pos] = amb;
//            this.qtdAmb++;
//            return true;
//        }
//    }
//
//    public void valorPorAmbiente(ItemDAO iDAO, int idServ, CampusDAO cDAO) {
//        for (int x = 0; x < this.qtdAmb; x++) {
//            double totalAmb = iDAO.valorPorAmbiente(ambs[x].getId(), idServ);
//
//            if (totalAmb != 0) {
//                System.out.println("\t" + ambs[x].getDescricao() + " - " + cDAO.getCampus(ambs[x].getCodCamp()).getNome() + " R$" + totalAmb);
//            }
//        }
//    }
}
