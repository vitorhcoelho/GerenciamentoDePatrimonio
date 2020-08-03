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
public class MovimentoAmbienteDAO {

    public void adiciona(MovimentoAmbiente novo) {
        String sql = "insert into movimentoambiente "
                + "(iditem, idamborigem, idambdestino, motivo, datacriacao, datamodificacao)"
                + " values (?,?,?,?,?,?)";

        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt;
            stmt = con.prepareStatement(sql);

            stmt.setInt(1, novo.getIdItem());
            stmt.setInt(2, novo.getAmbienteOrigem());
            stmt.setInt(3, novo.getAmbienteDestino());
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

    public void altera(MovimentoAmbiente alterado, int id) {
        String sql = "UPDATE movimentoambiente SET iditem = ?,"
                + " idamborigem = ? , idambdestino = ? , motivo = ? , datacriacao = ? ,"
                + " datamodificacao = ? WHERE (idmovamb = ?)";

        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, alterado.getIdItem());
            stmt.setInt(2, alterado.getAmbienteOrigem());
            stmt.setInt(3, alterado.getAmbienteDestino());
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

    public void exclui(MovimentoAmbiente movamb) {
        String sql = "delete from movimentoambiente where idmovamb = ?";

        try (Connection con = new ConnectionFactory().Conn()) {

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, movamb.getId());

            stmt.execute();
            stmt.close();

            System.out.println("ok");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<MovimentoAmbiente> lista() {
        List<MovimentoAmbiente> listMovAmb = new ArrayList<>();
        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt;
            stmt = con.prepareStatement("select * from movimentoambiente");
            ResultSet rs;
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idmovamb");
                int iditem = rs.getInt("iditem");
                int idamborigem = rs.getInt("idamborigem");
                int idambdestino = rs.getInt("idambdestino");
                String motivo = rs.getString("motivo");
                Date datacriacao = rs.getDate("datacriacao");
                Date datamod = rs.getDate("datamodificacao");

                MovimentoAmbiente c = new MovimentoAmbiente();
                c.setId(id);
                c.setIdItem(iditem);
                c.setAmbienteOrigem(idamborigem);
                c.setAmbienteDestino(idambdestino);
                c.setMotivo(motivo);
                c.setDataCriacao(datacriacao);
                c.setDataModificacao(datamod);
                listMovAmb.add(c);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listMovAmb;
    }
    
    public List<MovimentoAmbiente> listaPorItem(int idit) {
        List<MovimentoAmbiente> listMovAmb = new ArrayList<>();
        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt;
            stmt = con.prepareStatement("select * from movimentoambiente where iditem = ?");
            stmt.setInt(1, idit);
            ResultSet rs;
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idmovamb");
                int iditem = rs.getInt("iditem");
                int idamborigem = rs.getInt("idamborigem");
                int idambdestino = rs.getInt("idambdestino");
                String motivo = rs.getString("motivo");
                Date datacriacao = rs.getDate("datacriacao");
                Date datamod = rs.getDate("datamodificacao");

                MovimentoAmbiente c = new MovimentoAmbiente();
                c.setId(id);
                c.setIdItem(iditem);
                c.setAmbienteOrigem(idamborigem);
                c.setAmbienteDestino(idambdestino);
                c.setMotivo(motivo);
                c.setDataCriacao(datacriacao);
                c.setDataModificacao(datamod);
                listMovAmb.add(c);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listMovAmb;
    }

    public void imprime(List<MovimentoAmbiente> movAmb) {
        for (MovimentoAmbiente c : movAmb) {
            System.out.println(c);
        }
    }

//    private MovimentoAmbiente[] movAmb = new MovimentoAmbiente[100];
//    private int qtdMovAmb = 1;
//    private int id = 0;
//    Scanner in = new Scanner(System.in);
//
//    public int geraId() {
//        this.id++;
//        return id;
//    }
//
//    public int vagaMovAmb() {
//        for (int x = 0; x < this.qtdMovAmb; x++) {
//            if (movAmb[x] == null) {
//                return x;
//            } else {
//
//            }
//        }
//        return -1;
//    }
//
//    public boolean setMovAmb(MovimentoAmbiente mov) {
//        int pos = vagaMovAmb();
//        if (pos == -1) {
//            System.out.println("\nLista de Movimentações de Ambiente cheia\n");
//            return false;
//        } else {
//            movAmb[pos] = mov;
//            this.qtdMovAmb++;
//            return true;
//        }
//    }
//
//    public int achaMovimentoAmb(int id) {
//        for (int x = 0; x < this.qtdMovAmb; x++) {
//            if (id == movAmb[x].getId() && movAmb[x] != null) {
//                return x;
//            } else {
//
//            }
//        }
//        return -1;
//    }
//
//    public MovimentoAmbiente getMovimentoAmb(int id) {
//        int x = achaMovimentoAmb(id);
//        if (x == -1) {
//            return null;
//        } else {
//            return movAmb[x];
//        }
//    }
//
//    public void insereAuto(int item, int ambOrigem, int ambDestino, int mot) {
//        MovimentoAmbiente m = new MovimentoAmbiente();
//
//        m.setId(geraId());
//        m.setIdItem(item);
//        m.setAmbienteOrigem(ambOrigem);
//        m.setAmbienteDestino(ambDestino);
//        m.setDataCriacao(LocalDate.now());
//        m.setDataModificacao(LocalDate.now());
//
//        if (mot == 0) {
//            m.setMotivo("Deletado");
//        } else {
//            m.setMotivo("Novo ou Editado em Itens");
//        }
//        setMovAmb(m);
//    }
//
//    public void insereMovAmb(ItemDAO iDAO) {
//        String dado;
//        int idItem;
//        int idAmb;
//        MovimentoAmbiente mAmb = new MovimentoAmbiente();
//
//        System.out.println("\nDigite o ID do item movido: ");
//        idItem = Integer.parseInt(in.nextLine());
//        mAmb.setIdItem(idItem);
//
//        if (iDAO.getItem(idItem) == null) {
//            System.out.println("\nID de Item Inválido!\n");
//        } else {
//            mAmb.setAmbienteOrigem(iDAO.getItem(idItem).getAmbienteId());
//            System.out.println("\nO ITEM " + idItem + " ESTÁ NO AMBIENTE " + iDAO.getItem(idItem).getAmbienteId());
//
//            System.out.println("\nDigite o ID do ambiente de destino: ");
//            idAmb = Integer.parseInt(in.nextLine());
//            mAmb.setAmbienteDestino(idAmb);
//
//            iDAO.getItem(idItem).setAmbienteId(idAmb);
//
//            System.out.println("\nDescreva o motivo da movimentação de item: ");
//            dado = in.nextLine();
//            mAmb.setMotivo(dado);
//
//            mAmb.setDataCriacao(LocalDate.now());
//            mAmb.setDataModificacao(LocalDate.now());
//            mAmb.setId(geraId());
//            
//            this.setMovAmb(mAmb);
//
//            System.out.println(mAmb.toString() + "\nMovimentação Inserida\n");
//        }
//
//    }
//
//    public void editaMovAmb(ItemDAO iDAO) {
//        String dado;
//        int ids;
//        int idItem;
//
//        System.out.println("\nDigite o ID da Movimentação que deseja editar: ");
//        int aux = Integer.parseInt(in.nextLine());
//
//        if (getMovimentoAmb(aux) == null) {
//            System.out.println("\nMovimentação Não Encontrada!\n");
//        } else {
//
//            MovimentoAmbiente mAmb = getMovimentoAmb(aux);
//
//            System.out.println(getMovimentoAmb(aux).toString() + "\nEncontrado!\n");
//
//            idItem = getMovimentoAmb(aux).getIdItem();
//
//            if (iDAO.getItem(idItem) == null) {
//                System.out.println("\nItem De Movimentação Não Existe Mais\n");
//            } else {
//
//                System.out.println("\nDigite o ID do ambiente de destino: ");
//                ids = Integer.parseInt(in.nextLine());
//                mAmb.setAmbienteDestino(ids);
//
//                iDAO.getItem(idItem).setAmbienteId(ids);
//
//                System.out.println("\nDescreva o motivo da movimentação de item: ");
//                dado = in.nextLine();
//                mAmb.setMotivo(dado);
//
//                mAmb.setDataModificacao(LocalDate.now());
//
//                if (mAmb != null) {
//                    System.out.println(mAmb.toString() + "\nMovimentação Editada\n");
//                } else {
//                    System.out.println("\nErro Null\n");
//                }
//
//            }
//        }
//    }
//
//    public void excluiMovimentoAmb() {
//        System.out.println("\nDigite o ID da Movimentação que deseja editar: ");
//        int aux = Integer.parseInt(in.nextLine());
//
//        if (getMovimentoAmb(aux) == null) {
//            System.out.println("\nMovimentação Não Encontrada!\n");
//        } else {
//            System.out.println(getMovimentoAmb(aux).toString() + "\nEncontrado!\n");
//            System.out.println("\nDeseja Deletar?\n1 - Sim\n2 - Não");
//            int es = Integer.parseInt(in.nextLine());
//            if (es == 1) {
//
//                MovimentoAmbiente del = getMovimentoAmb(aux);
//                del.setMotivo("Campus Apagado");
//                del.setAmbienteDestino(-1);
//                del.setAmbienteOrigem(-1);
//                del.setDataCriacao(null);
//                del.setDataModificacao(null);
//                del.setIdItem(-1);
//                System.out.println("\nMovimentação Deletada\n");
//                this.qtdMovAmb--;
//            } else {
//                System.out.println("\nMovimentação Mantida\n");
//            }
//        }
//    }
//
//    public void mostraMovAmbientes() {
//        for (int x = 0; x < this.qtdMovAmb; x++) {
//            if (movAmb[x] != null) {
//                System.out.println(this.movAmb[x].toString());
//            } else {
//            }
//        }
//    }
//
//    public void mostraMovAmbientesPorID(int id) {
//        for (int i = 0; i < this.qtdMovAmb; i++) {
//            if (movAmb[i].getIdItem() == id) {
//                System.out.println(movAmb[i].toString());
//            }
//        }
//    }
}
