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
 * @author gusta em andamento
 */
public class CampusDAO {

//    private Campus[] campus = new Campus[100];
//    private int qtdCampus;
//    private int id = 0;
//
//    Scanner in = new Scanner(System.in);
//
//    public int geraId() {
//        this.id++;
//        return id;
//    }
    public void adiciona(Campus novo) {
        String sql = "insert into campus "
                + "(nome,abreviacao,dataCriacao,cidade,bairro,endereco,cep)"
                + " values (?,?,?,?,?,?,?)";

        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt;
            stmt = con.prepareStatement(sql);

            stmt.setString(1, novo.getNome());
            stmt.setString(2, novo.getAbreviacao());
            stmt.setDate(3, novo.getDataCriacao());
            stmt.setString(4, novo.getCidade());
            stmt.setString(5, novo.getBairro());
            stmt.setString(6, novo.getEndereco());
            stmt.setString(7, novo.getCep());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Campus adicionado", "", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Adicionar", "", JOptionPane.ERROR_MESSAGE);

            throw new RuntimeException(e);
        }
    }

    public void altera(Campus alterado, int id) {
        String sql = "UPDATE campus SET nome = ?,"
                + " abreviacao = ? , dataCriacao = ? , cidade = ? , bairro = ? ,"
                + " endereco = ? , cep = ? WHERE (idcampus = ?)";

        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, alterado.getNome());
            stmt.setString(2, alterado.getAbreviacao());
            stmt.setDate(3, alterado.getDataCriacao());
            stmt.setString(4, alterado.getCidade());
            stmt.setString(5, alterado.getBairro());
            stmt.setString(6, alterado.getEndereco());
            stmt.setString(7, alterado.getCep());
            stmt.setInt(8, id);

            stmt.execute();
            stmt.close();

            System.out.println("ok");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void exclui(Campus campus) {
        String sql = "delete from campus where idcampus = ?";

        try (Connection con = new ConnectionFactory().Conn()) {

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, campus.getId());

            stmt.execute();
            stmt.close();

            System.out.println("ok");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Campus> lista() {
        List<Campus> listCampus = new ArrayList<>();
        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt;
            stmt = con.prepareStatement("select * from campus");
            ResultSet rs;
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idcampus");
                String nome = rs.getString("nome");
                String abrev = rs.getString("abreviacao");
                Date dataCriacao = rs.getDate("dataCriacao");
                String cidade = rs.getString("cidade");
                String bairro = rs.getString("bairro");
                String endereco = rs.getString("endereco");
                String cep = rs.getString("cep");

                Campus c = new Campus();
                c.setId(id);
                c.setNome(nome);
                c.setAbreviacao(abrev);
                c.setCidade(cidade);
                c.setBairro(bairro);
                c.setDataCriacao(dataCriacao);
                c.setEndereco(endereco);
                c.setCep(cep);
                listCampus.add(c);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listCampus;
    }

    public void imprime(List<Campus> cmp) {
        for (Campus c : cmp) {
            System.out.println(c);
        }
    }

    public Campus busca(String nomeCampus) {
        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt;
            stmt = con.prepareStatement("select * from campus where nome = ?");
            stmt.setString(1, nomeCampus);
            ResultSet rs;
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idcampus");
                String nome = rs.getString("nome");
                String abrev = rs.getString("abreviacao");
                Date dataCriacao = rs.getDate("dataCriacao");
                String cidade = rs.getString("cidade");
                String bairro = rs.getString("bairro");
                String endereco = rs.getString("endereco");
                String cep = rs.getString("cep");

                Campus c = new Campus();
                c.setId(id);
                c.setNome(nome);
                c.setAbreviacao(abrev);
                c.setCidade(cidade);
                c.setBairro(bairro);
                c.setDataCriacao(dataCriacao);
                c.setEndereco(endereco);
                c.setCep(cep);
                return c;
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

//    public int vagaCampus() {
//        for (int x = 0; x < campus.length; x++) {
//            if (campus[x] == null) {
//                return x;
//            } else {
//
//            }
//        }
//        return -1;
//    }
//
//    public boolean setCampus(Campus camp) {
//        int pos = vagaCampus();
//        if (pos == -1) {
//            System.out.println("\nLista de Campus Cheia\n");
//            return false;
//        } else {
//            campus[pos] = camp;
//            this.qtdCampus++;
//            return true;
//        }
//    }
//
//    public void insereCampus() {
//        String dado;
//        Campus c = new Campus();
//
//        System.out.println("\nInsira o Nome do Campus:");
//        dado = in.nextLine();
//        c.setNome(dado);
//
//        System.out.println("\nInsira a Abreviação:");
//        dado = in.nextLine();
//        c.setAbreviacao(dado);
//
//        System.out.println("\nInsira a Cidade que se Localiza:");
//        dado = in.nextLine();
//        c.setCidade(dado);
//
//        System.out.println("\nInsira o Bairro:");
//        dado = in.nextLine();
//        c.setBairro(dado);
//
//        System.out.println("\nInsira o Endereço:");
//        dado = in.nextLine();
//        c.setEndereco(dado);
//
//        int verify = 0;
//        while (verify != 1) {
//            System.out.println("\nInsira o CEP:");
//            dado = in.nextLine();
//
//            if (dado.length() == 8) {
//                c.setCep(dado);
//                verify = 1;
//            } else {
//                System.out.println("\nCEP Inválido!");
//                verify = 0;
//            }
//        }
//
//        c.setDataCriacao(LocalDate.now());
//
//        c.setId(geraId());
//
//        this.setCampus(c);
//
//        System.out.println(c.toString() + "\nIncluído com Sucesso!\n");
//    }
//
//    public int achaCampusId(int id) {
//        for (int x = 0; x < this.qtdCampus; x++) {
//            if (id == campus[x].getId() && campus[x] != null) {
//                return x;
//            } else {
//
//            }
//        }
//        return -1;
//    }
//
//    public Campus getCampus(int id) {
//        int x = achaCampusId(id);
//        if (x == -1) {
//            return null;
//        } else {
//            return campus[x];
//        }
//    }
//    public void mostraCampus() {
//        for (int x = 0; x < this.qtdCampus; x++) {
//            if (campus[x] != null) {
//                System.out.println(this.campus[x].toString());
//            } else {
//
//            }
//        }
//    }
//
//    public void editaCampus() {
//        int id;
//        System.out.println("\nDigite o ID do Campus: ");
//        id = Integer.parseInt(in.nextLine());
//
//        if (getCampus(id) == null) {
//            System.out.println("\nCampus Não Encontrado\n");
//        } else {
//            Campus edit = getCampus(id);
//            System.out.println("\nCampus:  " + edit.getNome() + " Encontrado");
//
//            int esc;
//
//            System.out.println("\nDeseja mudar o nome:\n1 - Sim\n2 - Não");
//            esc = Integer.parseInt(in.nextLine());
//
//            if (esc == 1) {
//                System.out.println("\nNovo Nome: ");
//                edit.setNome(in.nextLine());
//            } else {
//                System.out.println("\nNome Mantido\n");
//            }
//
//            System.out.println("\nDeseja mudar a abreviação:\n1 - Sim\n2 - Não");
//            esc = Integer.parseInt(in.nextLine());
//
//            if (esc == 1) {
//                System.out.println("\nNova Abreviação: ");
//                edit.setAbreviacao(in.nextLine());
//            } else {
//                System.out.println("\nAbreviação Mantida\n");
//            }
//
//            System.out.println("\nDeseja mudar a cidade:\n1 - Sim\n2 - Não");
//            esc = Integer.parseInt(in.nextLine());
//
//            if (esc == 1) {
//                System.out.println("\nNova cidade: ");
//                edit.setCidade(in.nextLine());
//            } else {
//                System.out.println("\nCidade Mantida\n");
//            }
//
//            System.out.println("\nDeseja mudar o bairro:\n1 - Sim\n2 - Não");
//            esc = Integer.parseInt(in.nextLine());
//
//            if (esc == 1) {
//                System.out.println("\nNovo bairro: ");
//                edit.setBairro(in.nextLine());
//            } else {
//                System.out.println("\nBairro Mantido\n");
//            }
//
//            System.out.println("\nDeseja mudar o endereço:\n1 - Sim\n2 - Não");
//            esc = Integer.parseInt(in.nextLine());
//
//            if (esc == 1) {
//                System.out.println("\nNovo Endereço: ");
//                edit.setEndereco(in.nextLine());
//            } else {
//                System.out.println("\nEndereço Mantido\n");
//            }
//
//            System.out.println("\nDeseja mudar o CEP:\n1 - Sim\n2 - Não");
//            esc = Integer.parseInt(in.nextLine());
//
//            if (esc == 1) {
//                System.out.println("\nNovo CEP: ");
//                edit.setCep(in.nextLine());
//            } else {
//                System.out.println("\nCEP Mantido\n");
//            }
//
//            System.out.println(edit.toString() + "\nCampus Alterado\n");
//        }
//    }
//
//    public void excluiCampus() {
//        System.out.println("\nDigite o ID do Campus: ");
//        int id = Integer.parseInt(in.nextLine());
//
//        if (getCampus(id) == null) {
//            System.out.println("\nCampus Não Encontrado");
//
//        } else {
//            System.out.println("\nCampus " + getCampus(id).getNome() + " Encontrado"
//                    + "\nDeseja Deletar?\n1 - Sim\n2 - Não");
//            int es = Integer.parseInt(in.nextLine());
//            if (es == 1) {
//
//                Campus del = getCampus(id);
//                del.setNome("Campus Apagado");
//                del.setAbreviacao(null);
//                del.setBairro(null);
//                del.setCep(null);
//                del.setCidade(null);
//                del.setDataCriacao(null);
//                del.setEndereco(null);
//                System.out.println("\nCampus Deletado\n");
//
//            } else {
//                System.out.println("\nCampus Mantido\n");
//            }
//        }
//    }
}
