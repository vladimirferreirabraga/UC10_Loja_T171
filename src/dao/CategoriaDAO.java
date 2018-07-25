
package dao;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Categoria;


public class CategoriaDAO {
    
    public static boolean inserir(Categoria categoria){
        String sql = "INSERT INTO categorias "
            + " ( nome ) VALUES "
            + " ( '" + categoria.getNome() + "' );";
        return Conexao.executar(sql);
    }
      
    public static boolean editar(Categoria cat){
        String sql = "UPDATE categorias SET "
            + " nome =  '" + cat.getNome() + "' "
            + " WHERE codigo = " + cat.getCodigo();
        return Conexao.executar(sql);
    }
    
    public static boolean excluir(Categoria cat){
        String sql = "DELETE FROM categorias "
            + " WHERE codigo = " + cat.getCodigo();
        return Conexao.executar(sql);
    }
    
    public static List<Categoria> getCategorias(){
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categorias ORDER BY nome";
        ResultSet rs = Conexao.consultar( sql );
        
        if( rs != null ){
            try{
                while ( rs.next() ) {  
                    Categoria cat = new Categoria();
                    cat.setCodigo( rs.getInt(1) );
                    cat.setNome( rs.getString(2) );
                    lista.add(cat);
                } 
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
        
        return lista;
    }

   
    
}



