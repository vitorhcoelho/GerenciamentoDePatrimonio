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
public class ItemDAO {
    
    public void adiciona(Item novo) {
        String sql = "insert into item "
                + "(especificacao, codigo, estado, datacompra, valor, iddono, ambienteid, datacriacao, datamodificacao)"
                + " values (?,?,?,?,?,?,?,?,?)";

        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt;
            stmt = con.prepareStatement(sql);

            stmt.setString(1, novo.getEspecificacao());
            stmt.setString(2, novo.getCodigo());
            stmt.setInt(3, novo.getEstado());
            stmt.setString(4, novo.getDatacompra());
            stmt.setString(5, novo.getValorcompra());
            stmt.setInt(6, novo.getIdDono());
            stmt.setInt(7, novo.getAmbienteId());
            stmt.setDate(8, novo.getDatacriacao());
            stmt.setDate(9, novo.getDatamodificacao());

            stmt.execute();
            stmt.close();

            System.out.println("ok");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(Item alterado, int id) {
        String sql = "UPDATE item SET especificacao = ?, codigo = ?, "
                + "estado = ?, datacompra = ?, valor = ?, iddono = ?, ambienteid = ?, datacriacao = ?, datamodificacao = ?"
                + " WHERE (iditem = ?)";

        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, alterado.getEspecificacao());
            stmt.setString(2, alterado.getCodigo());
            stmt.setInt(3, alterado.getEstado());
            stmt.setString(4, alterado.getDatacompra());
            stmt.setString(5, alterado.getValorcompra());
            stmt.setInt(6, alterado.getIdDono());
            stmt.setInt(7, alterado.getAmbienteId());
            stmt.setDate(8, alterado.getDatacriacao());
            stmt.setDate(9, alterado.getDatamodificacao());
            stmt.setInt(10, id);

            stmt.execute();
            stmt.close();

            System.out.println("ok");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void exclui(Item item) {
        String sql = "delete from item where iditem = ?";

        try (Connection con = new ConnectionFactory().Conn()) {

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, item.getId());

            stmt.execute();
            stmt.close();

            System.out.println("ok");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Item> lista() {
        List<Item> listItem = new ArrayList<>();
        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt;
            stmt = con.prepareStatement("select * from item");
            ResultSet rs;
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("iditem");
                String espec = rs.getString("especificacao");
                String codigo = rs.getString("codigo");
                int estado = rs.getInt("estado");
                String datacompra = rs.getString("datacompra");
                String valor = rs.getString("valor");
                int iddono = rs.getInt("iddono");
                int idamb = rs.getInt("ambienteid");
                Date datacriacao = rs.getDate("datacriacao");
                Date datamod = rs.getDate("datamodificacao");


                Item a = new Item();
                a.setId(id);
                a.setAmbienteId(idamb);
                a.setCodigo(codigo);
                a.setDatacompra(datacompra);
                a.setDatacriacao(datacriacao);
                a.setDatamodificacao(datamod);
                a.setEspecificacao(espec);
                a.setEstado(estado);
                a.setIdDono(iddono);
                a.setValorcompra(valor);

                listItem.add(a);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listItem;
    }

    public void imprime(List<Item> item) {
        for (Item a : item) {
            System.out.println(a);
        }
    }
    
    
    

//    private Item[] itens = new Item[221];
//    private int qtdItem;
//    private int id = 0;
//    Scanner in = new Scanner(System.in);
//
//    public int geraId() {
//        this.id++;
//        return id;
//    }
//
//    public void insereItem(MovimentoAmbienteDAO mAmDAO, MovimentoDonoDAO mDoDAO) {
//        String dado;
//        int estado;
//        double valor;
//        int idAmbiente;
//        Item i = new Item();
//
//        System.out.println("\nEspecificação: ");
//        dado = in.nextLine();
//        i.setEspecificacao(dado);
//
//        do {
//            System.out.println("\nCódigo de patrimônio (6 digitos): ");
//
//            dado = in.nextLine();
//
//        } while (dado.length() < 6);
//        i.setCodigo(dado);
//
//        System.out.println("\nEstado de conservação do item: ");
//        do {
//            estado = Integer.parseInt(in.nextLine());
//
//        } while (estado < 0 || estado > 8);
//        i.setEstado(estado);
//
//        System.out.println("\nData de compra do item (use o padrão dd/MM/yyyy): ");
//        dado = in.nextLine();
//        i.setDatacompra(dado);
//
//        System.out.println("\nValor de compra do item: ");
//        valor = Double.parseDouble(in.nextLine());
//        i.setValorcompra(valor);
//
//        System.out.println("\nAmbiente do item: ");
//        idAmbiente = Integer.parseInt(in.nextLine());
//        i.setAmbienteId(idAmbiente);
//
//        System.out.println("\nId de Servidor Dono: ");
//        int dono = Integer.parseInt(in.nextLine());
//        i.setIdDono(dono);
//
//        LocalDate hoje = LocalDate.now();
//        i.setDatacriacao(hoje);
//
//        i.setId(geraId());
//        this.setItem(i);
//
//        mAmDAO.insereAuto(i.getId(), 0, idAmbiente, 1);
//        mDoDAO.insereAuto(i.getId(), 0, dono, 1);
//
//        System.out.println(i.toString() + "\nIncluído com Sucesso!\n");
//    }
//
//    public void editaItem(MovimentoAmbienteDAO mAmDAO, MovimentoDonoDAO mDoDAO) {
//        String dado;
//        int estado;
//        double valor;
//        int idAmbiente;
//        int ambAnterior;
//        int donoAnterior;
//
//        System.out.println("\nDigite o ID do Item: ");
//        int id = Integer.parseInt(in.nextLine());
//
//        if (getItem(id) == null) {
//            System.out.println("\nAmbiente Não Encontrado\n");
//        } else {
//
//            Item i = getItem(id);
//            System.out.println("\nItem:  " + i.getEspecificacao() + " Encontrado");
//
//            System.out.println("\nEspecificação: ");
//            dado = in.nextLine();
//            i.setEspecificacao(dado);
//
//            do {
//                System.out.println("\nCódigo de patrimônio (6 digitos): ");
//
//                dado = in.nextLine();
//
//            } while (dado.length() < 6);
//            i.setCodigo(dado);
//
//            System.out.println("\nEstado de conservação do item: ");
//            do {
//                estado = Integer.parseInt(in.nextLine());
//
//            } while (estado < 0 || estado > 8);
//            i.setEstado(estado);
//
//            System.out.println("\nData de compra do item (use o padrão dd/MM/yyyy): ");
//            dado = in.nextLine();
//            i.setDatacompra(dado);
//
//            System.out.println("\nValor de compra do item: ");
//            valor = Double.parseDouble(in.nextLine());
//            i.setValorcompra(valor);
//
//            ambAnterior = i.getAmbienteId();
//
//            System.out.println("\nAmbiente do item: ");
//            idAmbiente = Integer.parseInt(in.nextLine());
//            i.setAmbienteId(idAmbiente);
//
//            donoAnterior = i.getIdDono();
//
//            System.out.println("\nId de Servidor Dono: ");
//            int dono = Integer.parseInt(in.nextLine());
//            i.setIdDono(dono);
//
//            i.setDatamodificacao(LocalDate.now());
//
//            if (ambAnterior != idAmbiente) {
//                mAmDAO.insereAuto(i.getId(), 0, idAmbiente, 1);
//            }
//
//            if (donoAnterior != dono) {
//                mDoDAO.insereAuto(i.getId(), 0, dono, 1);
//            }
//
//            System.out.println(i.toString() + "\nEditado com Sucesso!\n");
//
//        }
//
//    }
//
//    public void excluiItem(MovimentoAmbienteDAO mAmDAO, MovimentoDonoDAO mDoDAO) {
//        System.out.println("\nDigite o ID do Item: ");
//        int id = Integer.parseInt(in.nextLine());
//
//        if (getItem(id) == null) {
//            System.out.println("\nItem Não Encontrado!\n");
//        } else {
//            System.out.println("\nItem " + getItem(id).getId() + getItem(id).getEspecificacao() + " Encontrado"
//                    + "\nDeseja Deletar?\n1 - Sim\n2 - Não");
//            int es = Integer.parseInt(in.nextLine());
//            if (es == 1) {
//
//                Item del = getItem(id);
//                del.setEspecificacao("Item Apagado");
//                del.setEstado(-1);
//                del.setCodigo(null);
//                del.setDatacompra(null);
//                del.setValorcompra(0);
//                del.setAmbienteId(0);
//                del.setIdDono(-1);
//                del.setDatacriacao(null);
//                del.setDatamodificacao(null);
//                System.out.println("\nAmbiente Deletado\n");
//
//                mAmDAO.insereAuto(del.getId(), 0, 0, 0);
//                mDoDAO.insereAuto(del.getId(), 0, 0, 0);
//
//            } else {
//                System.out.println("\nAmbiente Mantido\n");
//            }
//        }
//    }
//
//    public void excluiAuto(int idI, MovimentoAmbienteDAO mAmDAO, MovimentoDonoDAO mDoDAO) {
//        Item del = getItem(idI);
//        del.setEspecificacao("Item Apagado");
//        del.setEstado(-1);
//        del.setCodigo(null);
//        del.setDatacompra(null);
//        del.setValorcompra(0);
//        del.setAmbienteId(0);
//        del.setIdDono(-1);
//        del.setDatacriacao(null);
//        del.setDatamodificacao(null);
//        mAmDAO.insereAuto(del.getId(), 0, 0, 0);
//        mDoDAO.insereAuto(del.getId(), 0, 0, 0);
//    }
//
//    public int achaItemId(int id) {
//        for (int x = 0; x < this.qtdItem; x++) {
//            if (id == itens[x].getId() && itens[x] != null) {
//                return x;
//            } else {
//
//            }
//        }
//        return -1;
//    }
//
//    public Item getItem(int id) {
//        int x = achaItemId(id);
//        if (x == -1) {
//            return null;
//        } else {
//            return itens[x];
//        }
//    }
//
//    public int vagaItem() {
//        for (int x = 0; x < itens.length; x++) {
//            if (itens[x] == null) {
//                return x;
//            } else {
//
//            }
//        }
//        return -1;
//    }
//
//    public boolean setItem(Item item) {
//        int pos = vagaItem();
//        if (pos == -1) {
//            System.out.println("\nLista de Itens Cheia\n");
//            return false;
//        } else {
//            itens[pos] = item;
//            this.qtdItem++;
//            return true;
//        }
//    }
//
//    public void mostraItemPorServ(Servidor s) {
//        for (int x = 0; x < this.qtdItem; x++) {
//            if (itens[x] != null) {
//                if (itens[x].getIdDono() == s.getId()) {
//                    System.out.println(this.itens[x].toString());
//                }
//            } else {
//            }
//        }
//    }
//
//    public void mostraItemPorID(int dado) {
//        for (int x = 0; x < this.qtdItem; x++) {
//            if (itens[x] != null) {
//                if (itens[x].getId() == dado) {
//                    System.out.println(this.itens[x].toString());
//                }
//            } else {
//
//            }
//        }
//    }
//
//    public void itemRevisao(int idRev, int amb, ItensRevisaoDAO r) {
//
//        for (int x = 0; x < this.qtdItem; x++) {
//            if (itens[x].getAmbienteId() == amb && itens[x] != null) {
//                r.insereItensRev(idRev, itens[x]);
//            } else {
//
//            }
//        }
//    }
//
//    public int getQtdItem() {
//        return qtdItem;
//    }
//
//    public void setQtdItem(int qtdItem) {
//        this.qtdItem = qtdItem;
//    }
//
//    public double valorTotalPorServ(int idServ) {
//        double total = 0;
//        for (int x = 0; x < this.qtdItem; x++) {
//            if (itens[x].getIdDono() == idServ && itens[x] != null) {
//                total = total + itens[x].getValorcompra();
//            }
//        }
//        return total;
//    }
//
//    public double valorPorAmbiente(int idAmb, int idServ) {
//        double total = 0;
//        for (int x = 0; x < this.qtdItem; x++) {
//            if (itens[x].getIdDono() == idServ && itens[x].getAmbienteId() == idAmb && itens[x] != null) {
//                total = total + itens[x].getValorcompra();
//            } else {
//
//            }
//        }
//        return total;
//    }

}
