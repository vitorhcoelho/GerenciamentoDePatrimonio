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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author gusta
 */
public class ItensRevisaoDAO {

    public void adiciona(ItensRevisao novo) {
        String sql = "insert into itensrevisao "
                + "(idrevisao, iditem, encontrado, pago)"
                + " values (?,?,?,?)";

        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt;
            stmt = con.prepareStatement(sql);

            stmt.setInt(1, novo.getIdRevisao());
            stmt.setInt(2, novo.getItem());
            stmt.setInt(3, novo.isEncontrado());
            stmt.setInt(4, novo.isPago());



            stmt.execute();
            stmt.close();

            System.out.println("ok");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Em ItensRevisao", "", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }

    public void altera(ItensRevisao alterado, int id) {
        String sql = "UPDATE itensrevisao SET idrevisao = ?,"
                + " iditem = ? , encontrado = ? , pago = ? WHERE (iditensrevisao = ?)";

        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, alterado.getIdRevisao());
            stmt.setInt(2, alterado.getItem());
            stmt.setInt(3, alterado.isEncontrado());
            stmt.setInt(4, alterado.isPago());

            stmt.setInt(5, id);

            stmt.execute();
            stmt.close();

            System.out.println("ok");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void exclui(ItensRevisao itensRev) {
        String sql = "delete from itensrevisao where iditensrevisao = ?";

        try (Connection con = new ConnectionFactory().Conn()) {

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, itensRev.getId());

            stmt.execute();
            stmt.close();

            System.out.println("ok");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<ItensRevisao> lista() {
        List<ItensRevisao> listRev = new ArrayList<>();
        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt;
            stmt = con.prepareStatement("select * from itensrevisao");
            ResultSet rs;
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("iditensrevisao");
                int idrevisao = rs.getInt("idrevisao");
                int iditem = rs.getInt("iditem");
                int encontrado = rs.getInt("encontrado");
                int pago = rs.getInt("pago");
                

                ItensRevisao c = new ItensRevisao();
                c.setId(id);
                c.setIdRevisao(idrevisao);
                c.setItem(iditem);
                c.setEncontrado(encontrado);
                c.setPago(pago);
                
                listRev.add(c);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listRev;
    }
    
    public void imprime(List<ItensRevisao> itensRev) {
        for (ItensRevisao c : itensRev) {
            System.out.println(c);
        }
    }
    
//    private ItensRevisao[] itRev = new ItensRevisao[300];
//    private int qtdIRev = 0;
//    private int id = 0;
//    Scanner in = new Scanner(System.in);
//
//    public int geraId() {
//        this.id++;
//        return this.id;
//    }
//
//    public void insereItensRev(int idRev, Item item) {
//        ItensRevisao iR = new ItensRevisao();
//        iR.setIdRevisao(idRev);
//        iR.setItem(item);
//        iR.setId(geraId());
//        iR.setEncontrado(false);
//        iR.setPago(false);
//        setItemRevisao(iR);
//    }
//
//    public void revisionar(int idRev, ItemDAO iDAO, MovimentoAmbienteDAO mADAO, MovimentoDonoDAO mDDAO) {
//        int opc = 5;
//
//        for (int x = 0; x < this.qtdIRev; x++) {
//
//            if (itRev[x].getIdRevisao() == idRev && itRev[x].isEncontrado() == false && itRev[x].isPago() == false && itRev[x] != null) {
//
//                System.out.println(itRev[x].getItem().getEspecificacao() + "\nCódigo de Patrimônio: " + itRev[x].getItem().getCodigo()
//                        + "\nEncontrado?\n1 - Sim\n2 - Não\n0 - Sair");
//
//                opc = Integer.parseInt(in.nextLine());
//
//                if (opc == 0) {
//                    break;
//                }
//
//                switch (opc) {
//
//                    case 1:
//                        System.out.println("\nEncontrado!\nEncaminhando Próximo Item...");
//                        itRev[x].setEncontrado(true);
//                        break;
//
//                    case 2:
//                        itRev[x].setEncontrado(false);
//                        System.out.println("\nNão Encontrado!\nItem deve ser pago!\nFoi pago?\n1 - Sim\n2 - Não");
//                        int esc = Integer.parseInt(in.nextLine());
//                        if (esc == 1) {
//                            System.out.println("\nItem Pago\n");
//                            itRev[x].setPago(true);
//                            iDAO.excluiAuto(itRev[x].getItem().getId(), mADAO, mDDAO);
//                        } else {
//                            itRev[x].setPago(false);
//                            System.out.println("\nItem Não Pago!\nEncaminhando Próximo Item...");
//                        }
//                        break;
//
//                    default:
//                        break;
//                }
//
//            } else {
//
//            }
//
//        }
//    }
//
//    public void estadoRevisao(int idRev, Revisao r) {
//        for (int x = 0; x < qtdIRev; x++) {
//            if (itRev[x].getIdRevisao() == idRev) {
//                if (itRev[x].isEncontrado()) {
//                    r.setEstado(3);
//                } else {
//                    if (itRev[x].isPago()) {
//                        r.setEstado(3);
//                    } else {
//                        r.setEstado(2);
//                        break;
//                    }
//                }
//            } else {
//
//            }
//        }
//    }
//
//    public void exclui(int idRev) {
//        for (int x = 0; x < qtdIRev; x++) {
//            if (itRev[x].getIdRevisao() == idRev) {
//                itRev[x].setEncontrado(false);
//                itRev[x].setPago(false);
//                itRev[x].setIdRevisao(-1);
//                itRev[x].setItem(null);
//            } else {
//
//            }
//        }
//    }
//
//    public void mostraItens(int idR) {
//        for (int x = 0; x < this.qtdIRev; x++) {
//            if (itRev[x].getIdRevisao() == idR) {
//                System.out.println(itRev[x].toString());
//            }
//        }
//    }
//
//    public int vagaItemRevisao() {
//        for (int x = 0; x < itRev.length; x++) {
//            if (itRev[x] == null) {
//                return x;
//            } else {
//
//            }
//        }
//        return -1;
//    }
//
//    public boolean setItemRevisao(ItensRevisao rev) {
//        int pos = vagaItemRevisao();
//        if (pos == -1) {
//            System.out.println("\nLista de Itens de Revisões Cheia\n");
//            return false;
//        } else {
//            this.qtdIRev++;
//            itRev[pos] = rev;
//            return true;
//        }
//    }
//
//    public int achaIRevIdRev(int idRev) {
//        for (int x = 0; x < this.itRev.length; x++) {
//            if (idRev == itRev[x].getIdRevisao() && itRev[x] != null) {
//                return x;
//            } else {
//
//            }
//        }
//        return -1;
//    }
//
//    public ItensRevisao getIRevisaoIdRev(int id) {
//        int x = achaIRevIdRev(id);
//        if (x == -1) {
//            return null;
//        } else {
//            return itRev[x];
//        }
//    }

}
