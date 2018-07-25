
package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Categoria;
import model.Produto;
import model.Produto;

import model.Produto;




public class ProdutoDAO {
    
 public static boolean inserir(Produto produto) {
        String sql = "INSERT INTO produtos "
                + " ( nome, preco, quantidade, codCategoria, perecivel  ) "
                + " VALUES ( "
                + " '" + produto.getNome() + "' , "
                + "  " + produto.getPreco() + " , "
                + "  " + produto.getQuantidade()+ "  , "
                + "  " + produto.getCategoria().getCodigo() + " , "
                + "  " + produto.isPerecivel() + "    "
                + " );";
        return Conexao.executar(sql);
    }

    public static boolean editar(Produto produto) {
        String sql = "UPDATE produto SET "
                 + " ( codigo, nome, preco, quantidade, codProduto, perecivel ) "
                + " VALUES ( "
                + " nome =  ' " + produto.getNome()+ "' , "
                + " preco =  " + produto.getPreco()+ " ,  "
                + " quantidade =  " + produto.getQuantidade() + " , "
                + " codCategoria =  '" + produto.getCategoria()+ "' , "
                + " perecivel = '" + produto.isPerecivel() + "' , "
                + " WHERE codigo = " + produto.getCodigo() ;
                
        return Conexao.executar(sql);
    }

    public static boolean excluir(Produto produto) {
        String sql = "DELETE FROM produtos "
                + " WHERE codigo = " + produto.getCodigo();
        return Conexao.executar(sql);
    }

    public static List<Produto> getProdutos() {
        List<Produto> lista = new ArrayList<>();
        String sql;
     sql = "SELECT p.nome, p.preco, p.quantidade, p.codCategoria, p.perecivel ,"
             + " p.codigo, c.nome "
             + " FROM produtos p "
             + " INNER JOIN Categorias c ON c.codCategoria = d.codigo"
             + " WHERE c.tipo = '' "
             + " ORDER BY c.nome";
        ResultSet rs = Conexao.consultar(sql);
        if (rs != null) {
            try {
                while(rs.next()){
                    Produto prod = new Produto();
                    
                    prod.setNome(rs.getString(1));
                    prod.setPreco(rs.getDouble(2));
                    prod.setQuantidade(rs.getDouble(3));
                    prod.setPerecivel(rs.getBoolean(5));
                    prod.setCodigo( rs.getInt(6));
                    
                    Categoria cat = new Categoria();
                   cat.setNome(rs.getString(7));
                   cat.setCodigo(rs.getInt(4));
                   
                   prod.setCategoria(cat);
                    

                    
                      lista.add(prod);
                }
                 
                

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.toString());
            }
            
        }
        return lista;
    }

}

    

    

   
    
    
    

