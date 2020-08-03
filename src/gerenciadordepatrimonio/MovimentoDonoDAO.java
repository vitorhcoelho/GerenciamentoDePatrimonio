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
import javax.swing.JOptionPane;

/**
 *
 * @author gusta
 */
public class MovimentoDonoDAO {
    
    
     public void adiciona(MovimentoDono novo) {
        String sql = "insert into movimentodono "
                + "(iditem, donoorigem, donodestino, motivo, datacriacao, datamodificacao)"
                + " values (?,?,?,?,?,?)";

        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt;
            stmt = con.prepareStatement(sql);

            stmt.setInt(1, novo.getIdItem());
            stmt.setInt(2, novo.getDonoOrigem());
            stmt.setInt(3, novo.getDonoDestino());
            stmt.setString(4, novo.getMotivo());
            stmt.setDate(5, novo.getDataCriacao());
            stmt.setDate(6, novo.getDataModificacao());


            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Movimentação Adicionada", "", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Erro ao Adicionar", "", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }

    public void altera(MovimentoDono alterado, int id) {
        String sql = "UPDATE movimentodono SET iditem = ?,"
                + " donoorigem = ? , donodestino = ? , motivo = ? , datacriacao = ? ,"
                + " datamodificacao = ? WHERE (idmovimentodono = ?)";

        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, alterado.getIdItem());
            stmt.setInt(2, alterado.getDonoOrigem());
            stmt.setInt(3, alterado.getDonoDestino());
            stmt.setString(4, alterado.getMotivo());
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

    public void exclui(MovimentoDono movdono) {
        String sql = "delete from movimentodono where idmovimentodono = ?";

        try (Connection con = new ConnectionFactory().Conn()) {

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, movdono.getId());

            stmt.execute();
            stmt.close();

            System.out.println("ok");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<MovimentoDono> lista() {
        List<MovimentoDono> listMovDono = new ArrayList<>();
        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt;
            stmt = con.prepareStatement("select * from movimentodono");
            ResultSet rs;
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idmovimentodono");
                int iditem = rs.getInt("iditem");
                int iddonoorigem = rs.getInt("donoorigem");
                int iddonodestino = rs.getInt("donodestino");
                String motivo = rs.getString("motivo");
                Date datacriacao = rs.getDate("datacriacao");
                Date datamod = rs.getDate("datamodificacao");

                MovimentoDono c = new MovimentoDono();
                c.setId(id);
                c.setIdItem(iditem);
                c.setDonoOrigem(iddonoorigem);
                c.setDonoDestino(iddonodestino);
                c.setMotivo(motivo);
                c.setDataCriacao(datacriacao);
                c.setDataModificacao(datamod);
                listMovDono.add(c);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listMovDono;
    }
    
    public List<MovimentoDono> listaPorItem(int idit) {
        List<MovimentoDono> listMovDono = new ArrayList<>();
        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt;
            stmt = con.prepareStatement("select * from movimentodono where iditem = ?");
            stmt.setInt(1, idit);
            ResultSet rs;
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idmovimentodono");
                int iditem = rs.getInt("iditem");
                int iddonoorigem = rs.getInt("donoorigem");
                int iddonodestino = rs.getInt("donodestino");
                String motivo = rs.getString("motivo");
                Date datacriacao = rs.getDate("datacriacao");
                Date datamod = rs.getDate("datamodificacao");

                MovimentoDono c = new MovimentoDono();
                c.setId(id);
                c.setIdItem(iditem);
                c.setDonoOrigem(iddonoorigem);
                c.setDonoDestino(iddonodestino);
                c.setMotivo(motivo);
                c.setDataCriacao(datacriacao);
                c.setDataModificacao(datamod);
                listMovDono.add(c);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listMovDono;
    }

    public void imprime(List<MovimentoDono> movDono) {
        for (MovimentoDono c : movDono) {
            System.out.println(c);
        }
    }

//    private MovimentoDono[] movDono = new MovimentoDono[221];
//    private int qtdMovDono;
//    private int id = 0;
//    Scanner in = new Scanner(System.in);
//
//    public int geraId() {
//        this.id++;
//        return id;
//    }
//
//    public void insereAuto(int item, int donoOrigem, int donoDestino, int mot) {
//        MovimentoDono m = new MovimentoDono();
//
//        m.setId(geraId());
//        m.setIdItem(item);
//        m.setDonoOrigem(donoOrigem);
//        m.setDonoDestino(donoDestino);
//        m.setDataCriacao(LocalDate.now());
//        m.setDataModificacao(LocalDate.now());
//
//        if (mot == 0) {
//            m.setMotivo("Deletado");
//        } else {
//            m.setMotivo("Novo ou Editado em Itens");
//        }
//
//        setMovDono(m);
//
//    }
//
//    public void insereMov(ItemDAO iDAO) {
//        String dado;
//        double valor;
//        int ids;
//        int idItem;
//        MovimentoDono m = new MovimentoDono();
//
//        System.out.println("\nDigite o ID do item movido: ");
//        idItem = Integer.parseInt(in.nextLine());
//        m.setIdItem(idItem);
//
//        if (iDAO.getItem(idItem) == null) {
//            System.out.println("\nID de Item Inválido!\n");
//        } else {
//
//            m.setDonoOrigem(iDAO.getItem(idItem).getIdDono());
//
//            System.out.println("\nDigite o ID do Dono de destino: ");
//            ids = Integer.parseInt(in.nextLine());
//            m.setDonoDestino(ids);
//
//            iDAO.getItem(idItem).setIdDono(ids);
//
//            System.out.println("\nDescreva o motivo da movimentação de item: ");
//            dado = in.nextLine();
//            m.setMotivo(dado);
//
//            m.setDataCriacao(LocalDate.now());
//            m.setDataModificacao(LocalDate.now());
//
//            m.setId(geraId());
//
//            if (m != null) {
//                setMovDono(m);
//                System.out.println(m.toString() + "\nMovimentação Inserida\n");
//            } else {
//                System.out.println("\nErro Null\n");
//            }
//        }
//    }
//
//    public void editaMovDono(ItemDAO iDAO) {
//        String dado;
//        int ids;
//
//        System.out.println("\nDigite o ID da Movimentação que deseja editar: ");
//        int aux = Integer.parseInt(in.nextLine());
//
//        if (getMovimentoDono(aux) == null) {
//            System.out.println("\nMovimentação Não Encontrada!\n");
//        } else {
//
//            MovimentoDono m = getMovimentoDono(aux);
//
//            System.out.println(getMovimentoDono(aux).toString() + "\nEncontrado!\n");
//
//            int idItem = getMovimentoDono(aux).getIdItem();
//
//            if (iDAO.getItem(idItem) == null) {
//                System.out.println("\nItem De Movimentação Não Existe Mais\n");
//            } else {
//
//                System.out.println("\nDigite o ID do Dono de destino: ");
//                ids = Integer.parseInt(in.nextLine());
//                m.setDonoDestino(ids);
//
//                System.out.println("\nDescreva o motivo da movimentação de item: ");
//                dado = in.nextLine();
//                m.setMotivo(dado);
//
//                m.setDataModificacao(LocalDate.now());
//
//                if (m != null) {
//                    System.out.println(m.toString() + "\nMovimentação Editada\n");
//                } else {
//                    System.out.println("\nErro Null\n");
//                }
//
//            }
//        }
//    }
//
//    public void excluiMovimentoDono() {
//        System.out.println("\nDigite o ID da Movimentação que deseja editar: ");
//        int aux = Integer.parseInt(in.nextLine());
//
//        if (getMovimentoDono(aux) == null) {
//            System.out.println("\nMovimentação Não Encontrada!\n");
//        } else {
//            System.out.println(getMovimentoDono(aux).toString() + "\nEncontrado!\n");
//            System.out.println("\nDeseja Deletar?\n1 - Sim\n2 - Não");
//            int es = Integer.parseInt(in.nextLine());
//            if (es == 1) {
//
//                MovimentoDono del = getMovimentoDono(aux);
//                del.setMotivo("Motivo Apagado");
//                del.setDonoOrigem(-1);
//                del.setDonoDestino(-1);
//                del.setDataCriacao(null);
//                del.setDataModificacao(null);
//                del.setIdItem(-1);
//                System.out.println("\nMovimentação Deletada\n");
//
//            } else {
//                System.out.println("\nMovimentação Mantida\n");
//            }
//        }
//    }
//
//    public int vagaMovDono() {
//        for (int x = 0; x < movDono.length; x++) {
//            if (movDono[x] == null) {
//                return x;
//            } else {
//
//            }
//        }
//        return -1;
//    }
//
//    public boolean setMovDono(MovimentoDono movimentacoes) {
//        int pos = vagaMovDono();
//        if (pos == -1) {
//            System.out.println("\nLista de Movimentações de Donos cheia\n");
//            return false;
//        } else {
//            movDono[pos] = movimentacoes;
//            this.qtdMovDono++;
//            return true;
//        }
//    }
//
//    public int achaMovimentoDono(int id) {
//        for (int x = 0; x < movDono.length; x++) {
//            if (id == movDono[x].getId() && movDono[x] != null) {
//                return x;
//            } else {
//
//            }
//        }
//        return -1;
//    }
//
//    public MovimentoDono getMovimentoDono(int id) {
//        int x = achaMovimentoDono(id);
//        if (x == -1) {
//            return null;
//        } else {
//            return movDono[x];
//        }
//    }
//
//    public void mostraMovDonos() {
//        for (int x = 0; x < this.qtdMovDono; x++) {
//            if (movDono[x] != null) {
//                System.out.println(this.movDono[x].toString());
//            } else {
//            }
//        }
//    }
//
//    public void mostraMovDonosPorID(int id) {
//        for (int i = 0; i < this.qtdMovDono; i++) {
//            if (movDono[i].getIdItem() == id) {
//                System.out.println(movDono[i].toString());
//            }
//        }
//    }

}
