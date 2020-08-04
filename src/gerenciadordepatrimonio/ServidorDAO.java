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
 * @author Aluno
 */
public class ServidorDAO {
//
//    private Servidor[] servidores = new Servidor[250];
//    private int qtdServidor;
//    private int idS = 0;
//
//    Scanner in = new Scanner(System.in);
//    private Servidor servLogado;

    public void adiciona(Servidor novo) {
        String sql = "insert into servidor "
                + "(nome, email, codcampus, cargo, papel, login, senha, adm, logado, definitivo)"
                + " values (?,?,?,?,?,?,?,?,?,?)";

        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt;
            stmt = con.prepareStatement(sql);

            stmt.setString(1, novo.getNome());
            stmt.setString(2, novo.getEmail());
            stmt.setInt(3, novo.getCampus());
            stmt.setString(4, novo.getCargo());
            stmt.setString(5, novo.getPapel());
            stmt.setString(6, novo.getLogin());
            stmt.setString(7, novo.getSenha());
            stmt.setInt(8, novo.isAdm());
            stmt.setInt(9, novo.isLogado());
            stmt.setInt(10, novo.isSystem());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Servidor adicionado", "", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Adicionar", "", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }

    public void altera(Servidor alterado) {
        String sql = "UPDATE servidor SET nome = ?, email = ?, "
                + "codcampus = ?, cargo = ?, papel = ?, login = ?, senha = ?, adm = ?, logado = ?, definitivo = ?"
                + " WHERE (idservidor = ?)";

        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, alterado.getNome());
            stmt.setString(2, alterado.getEmail());
            stmt.setInt(3, alterado.getCampus());
            stmt.setString(4, alterado.getCargo());
            stmt.setString(5, alterado.getPapel());
            stmt.setString(6, alterado.getLogin());
            stmt.setString(7, alterado.getSenha());
            stmt.setInt(8, alterado.isAdm());
            stmt.setInt(9, alterado.isLogado());
            stmt.setInt(10, alterado.isSystem());
            stmt.setInt(11, alterado.getId());

            stmt.execute();
            stmt.close();

            System.out.println("ok");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        
        
    }

    public void exclui(Servidor serv) {
        String sql = "delete from servidor where idservidor = ?";

        try (Connection con = new ConnectionFactory().Conn()) {

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, serv.getId());

            stmt.execute();
            stmt.close();

            System.out.println("ok");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Servidor> lista() {
        List<Servidor> listServ = new ArrayList<>();
        try (Connection con = new ConnectionFactory().Conn()) {
            PreparedStatement stmt;
            stmt = con.prepareStatement("select * from servidor");
            ResultSet rs;
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idservidor");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                int codcamp = rs.getInt("codcampus");
                String cargo = rs.getString("cargo");
                String papel = rs.getString("papel");
                String login = rs.getString("login");
                String senha = rs.getString("senha");
                int adm = rs.getInt("adm");
                int logado = rs.getInt("logado");
                int system = rs.getInt("definitivo");

                Servidor a = new Servidor();
                a.setId(id);
                a.setAdm(adm);
                a.setCampus(codcamp);
                a.setCargo(cargo);
                a.setEmail(email);
                a.setLogado(logado);
                a.setLoginSenha(login, senha);
                a.setNome(nome);
                a.setPapel(papel);
                a.setSystem(system);

                listServ.add(a);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listServ;
    }

    public void imprime(List<Servidor> serv) {
        for (Servidor a : serv) {
            System.out.println(a);
        }
    }
    
    public Servidor validaLogin(String log, String pass){
        String sql = "select * from servidor where login = ? and senha = ?";
        
        try(Connection con = new ConnectionFactory().Conn()){
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, log);
            st.setString(2, pass);
            ResultSet rs;
            rs = st.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("idservidor");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                int codcamp = rs.getInt("codcampus");
                String cargo = rs.getString("cargo");
                String papel = rs.getString("papel");
                String login = rs.getString("login");
                String senha = rs.getString("senha");
                int adm = rs.getInt("adm");
                int logado = rs.getInt("logado");
                int system = rs.getInt("definitivo");
                
                Servidor a = new Servidor();
                a.setId(id);
                a.setAdm(adm);
                a.setCampus(codcamp);
                a.setCargo(cargo);
                a.setEmail(email);
                a.setLogado(logado);
                a.setLoginSenha(login, senha);
                a.setNome(nome);
                a.setPapel(papel);
                a.setSystem(system);
                
                return a;
            }
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }
    
    public Servidor listaPorID(int idserv){
        String sql = "select * from servidor where idservidor = ?";
        
        try(Connection con = new ConnectionFactory().Conn()){
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, idserv);
            ResultSet rs;
            rs = st.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("idservidor");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                int codcamp = rs.getInt("codcampus");
                String cargo = rs.getString("cargo");
                String papel = rs.getString("papel");
                String login = rs.getString("login");
                String senha = rs.getString("senha");
                int adm = rs.getInt("adm");
                int logado = rs.getInt("logado");
                int system = rs.getInt("definitivo");
                
                Servidor a = new Servidor();
                a.setId(id);
                a.setAdm(adm);
                a.setCampus(codcamp);
                a.setCargo(cargo);
                a.setEmail(email);
                a.setLogado(logado);
                a.setLoginSenha(login, senha);
                a.setNome(nome);
                a.setPapel(papel);
                a.setSystem(system);
                
                return a;
            }
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }

//    public int geraId() {
//        this.idS++;
//        return idS;
//    }
//
//    public Servidor getServLogado() {
//        return servLogado;
//    }
//
//    public void setLoginServ(Servidor logado) {
//        this.servLogado = logado;
//    }
//
//    public boolean validaLoginServ(String login, String senha) {
//        for (int x = 0; x < this.qtdServidor; x++) {
//            if (this.servidores[x].getLogin().equals(login) && servidores[x] != null) {
//                if (this.servidores[x].getSenha().equals(senha)) {
//                    return true;
//                } else {
//                    return false;
//                }
//            } else {
//                return false;
//            }
//        }
//        return false;
//    }
//
//    public int posicaoServ() {
//        for (int x = 0; x < servidores.length; x++) {
//            if (servidores[x] == null) {
//                return x;
//
//            } else {
//
//            }
//        }
//        return -1;
//    }
//
//    public int achaServidorLogin(String login) {
//        for (int x = 0; x < this.qtdServidor; x++) {
//            if (login.equals(servidores[x].getLogin())) {
//                return x;
//            } else {
//
//            }
//        }
//        return -1;
//    }
//
//    public Servidor getServidoresLogin(String login) {
//        int loc = this.achaServidorLogin(login);
//        if (loc == -1) {
//            return null;
//        } else {
//            return servidores[loc];
//        }
//    }
//
//    public boolean setServidores(Servidor serv) {
//        int pos = posicaoServ();
//        if (pos == -1) {
//            System.out.println("\nLista de Servidores Cheia\n");
//            return false;
//        } else {
//            servidores[pos] = serv;
//            this.qtdServidor++;
//            return true;
//        }
//    }
//
//    public int achaServidorId(int id) {
//        for (int x = 0; x < this.qtdServidor; x++) {
//            if (id == servidores[x].getId() && servidores[x] != null) {
//                return x;
//            } else {
//
//            }
//        }
//        return -1;
//    }
//
//    public Servidor getServidoresId(int id) {
//        int loc = this.achaServidorId(id);
//        if (loc == -1) {
//            return null;
//        } else {
//            return servidores[loc];
//        }
//
//    }
//
//    public int achaServidorNome(String nome) {
//        for (int x = 0; x < this.qtdServidor; x++) {
//            if (servidores[x].getNome().equals(nome) && servidores[x] != null) {
//                return x;
//            } else {
//
//            }
//        }
//        return -1;
//    }
//
//    public Servidor getServidoresNome(String nome) {
//        int loc = this.achaServidorNome(nome);
//        if (loc == -1) {
//            return null;
//        } else {
//            return servidores[loc];
//        }
//    }
//
//    public void mostraServidores() {
//        for (int x = 1; x < this.qtdServidor; x++) {
//            if (servidores[x] != null) {
//                System.out.println(this.servidores[x].toString());
//            } else {
//
//            }
//        }
//    }
//
//    public int achaServidorCampus(int id) {
//        for (int x = 0; x < this.qtdServidor; x++) {
//            if (id == servidores[x].getId() && servidores[x] != null) {
//                return x;
//            } else {
//            }
//        }
//        return -1;
//    }
//
//    public int getServidoresCampus(int id) {
//        int loc = this.achaServidorId(id);
//        if (loc == -1) {
//            return -1;
//        } else {
//            return servidores[loc].getCampus();
//        }
//
//    }
//
//    public int getQtdServ() {
//        return this.qtdServidor;
//    }
//
//    public void insereServ() {
//
//        Servidor add = new Servidor();
//
//        String dado;
//        int aux = 0;
//
//        System.out.println("\nNome: ");
//        dado = in.nextLine();
//        add.setNome(dado);
//
//        System.out.println("\nE-mail: ");
//        dado = in.nextLine();
//        add.setEmail(dado);
//
//        System.out.println("\nId do Campus: ");
//        aux = Integer.parseInt(in.nextLine());
//        add.setCampus(aux);
//
//        System.out.println("\nCargo: ");
//        dado = in.nextLine();
//        add.setCargo(dado);
//
//        System.out.println("\nPapel: ");
//        dado = in.nextLine();
//        add.setPapel(dado);
//
//        int adm = 0;
//
//        while (adm != 2) {
//            System.out.println("\nEsse usuário tem permissão administrativa?\n1 - Sim\t2 - Não\n");
//            adm = Integer.parseInt(in.nextLine());
//
//            if (adm == 1) {
//                add.setAdm(true);
//                break;
//            } else {
//                add.setAdm(false);
//            }
//        }
//
//        System.out.println("\nLogin: ");
//        dado = in.nextLine();
//
//        String senha;
//        String confirme;
//
//        while (dado != null) {
//            System.out.println("\nSenha: ");
//            senha = in.nextLine();
//            System.out.println("\nConfirme sua Senha: ");
//            confirme = in.nextLine();
//            if (senha.equals(confirme)) {
//                add.setLoginSenha(dado, senha);
//                break;
//            } else {
//                System.out.println("\nSenhas Diferentes\n");
//            }
//        }
//
//        add.setId(geraId());
//        setServidores(add);
//
//        System.out.println("\nServidor Adicionado\n");
//        System.out.println(add.toString());
//    }
//
//    public void editaServ() {
//        int id;
//        System.out.println("\nDigite o ID do Servidor: ");
//        id = Integer.parseInt(in.nextLine());
//
//        if (getServidoresId(id) == null) {
//            System.out.println("\nServidor Não Encontrado\n");
//        } else {
//            Servidor edit = getServidoresId(id);
//            System.out.println("\nServidor " + edit.getNome() + " Encontrado");
//
//            int esc;
//
//            System.out.println("\nDeseja mudar o nome:\n1 - Sim\t2 - Não");
//            esc = Integer.parseInt(in.nextLine());
//
//            if (esc == 1) {
//                System.out.println("\nNovo Nome: ");
//                edit.setNome(in.nextLine());
//            } else {
//                System.out.println("\nNome Mantido\n");
//            }
//
//            System.out.println("\nDeseja mudar o E-mail:\n1 - Sim\t2 - Não");
//            esc = Integer.parseInt(in.nextLine());
//
//            if (esc == 1) {
//                System.out.println("\nNovo E-mail: ");
//                edit.setEmail(in.nextLine());
//            } else {
//                System.out.println("\nE-mail Mantido\n");
//            }
//
//            System.out.println("\nDeseja mudar o campus pertencente:\n1 - Sim\t2 - Não");
//            esc = Integer.parseInt(in.nextLine());
//
//            if (esc == 1) {
//                System.out.println("\nNovo Id de Campus: ");
//                edit.setCampus(Integer.parseInt(in.nextLine()));
//            } else {
//                System.out.println("\nCampus Mantido\n");
//            }
//
//            System.out.println("\nDeseja mudar o cargo:\n1 - Sim\t2 - Não");
//            esc = Integer.parseInt(in.nextLine());
//
//            if (esc == 1) {
//                System.out.println("\nNovo Cargo: ");
//                edit.setCargo(in.nextLine());
//            } else {
//                System.out.println("\nCargo Mantido\n");
//            }
//
//            System.out.println("\nDeseja mudar o papel:\n1 - Sim\t2 - Não");
//            esc = Integer.parseInt(in.nextLine());
//
//            if (esc == 1) {
//                System.out.println("\nNovo Papel: ");
//                edit.setPapel(in.nextLine());
//            } else {
//                System.out.println("\nPapel Mantido\n");
//            }
//
//            int aux = 0;
//
//            while (aux != 2) {
//                System.out.println("\nEsse usuário tem permissão administrativa?\n1 - Sim\t2 - Não\n");
//                aux = Integer.parseInt(in.nextLine());
//
//                if (aux == 1) {
//                    edit.setAdm(true);
//                    break;
//                } else {
//                    edit.setAdm(false);
//                }
//            }
//
//            System.out.println("\nDeseja mudar o Login e Senha:\n1 - Sim\n2 - Não");
//            esc = Integer.parseInt(in.nextLine());
//
//            if (esc == 1) {
//                while (esc == 1) {
//                    System.out.println("\nNovo Login: ");
//                    String login = in.nextLine();
//                    System.out.println("\nSenha Atual: ");
//                    String atual = in.nextLine();
//                    System.out.println("\nNova Senha: ");
//                    String novaPass = in.nextLine();
//                    System.out.println("\nConfirme sua Nova Senha: ");
//                    String conf = in.nextLine();
//
//                    if (getServLogado().getSenha().equals(atual)) {
//                        if (novaPass.equals(conf)) {
//                            edit.setLoginSenha(login, novaPass);
//                            break;
//                        } else {
//                            System.out.println("\nSenhas Diferentes\n");
//                        }
//                    } else {
//                        System.out.println("\nSenha Atual Errada\n");
//                    }
//                }
//            } else {
//                System.out.println("\nLogin e Senha Mantidos\n");
//            }
//            System.out.println(edit.toString());
//            System.out.println("\nServidor Alterado\n");
//        }
//    }
//
//    public void excluiServ() {
//        int id;
//        System.out.println("\nDigite o ID do servidor: ");
//        id = Integer.parseInt(in.nextLine());
//
//        if (getServidoresId(id) == null) {
//            System.out.println("\nServidor Não Encontrado");
//        } else if (getServidoresId(id).isSystem()) {
//            System.out.println("\nVocê não pode deletar esse usuário!\n:user_system:\n");
//        } else {
//            System.out.println("\nServidor " + getServidoresId(id).getNome() + " Encontrado"
//                    + "\nDeseja Deletar?\n1 - Sim\t2 - Não");
//            int es = Integer.parseInt(in.nextLine());
//            if (es == 1) {
//                Servidor del = getServidoresId(id);
//                del.setAdm(false);
//                del.setCampus(0);
//                del.setCargo(null);
//                del.setEmail(null);
//                del.setLoginSenha(null, null);
//                del.setNome("Deletado");
//                del.setPapel(null);
//                del.setSystem(false);
//                del.setLogado(false);
//                this.qtdServidor--;
//                System.out.println("\nServidor Deletado\n");
//
//            } else {
//                System.out.println("\nServidor Mantido\n");
//            }
//        }
//    }
//
//    public void relatorioAmb(CampusDAO campDAO, AmbienteDAO ambDAO, ItemDAO iDAO) {
//        int x = 0;
//        while (servidores[x] != null) {
//            if (servidores[x] != null) {
//                System.out.println(servidores[x].getNome() + " - TOTAL: R$" + iDAO.valorTotalPorServ(servidores[x].getId()));
//
//                ambDAO.valorPorAmbiente(iDAO, servidores[x].getId(), campDAO);
//            } else {
//
//            }
//            x++;
//        }
//    }
//
//    public void relatorioTotalFinan(ItemDAO iDAO) {
//        int x = 0;
//        while (servidores[x] != null) {
//            if (servidores[x] != null) {
//                System.out.println(servidores[x].getNome() + " - TOTAL: R$" + iDAO.valorTotalPorServ(servidores[x].getId()));
//            } else {
//
//            }
//            x++;
//        }
//    }
}
