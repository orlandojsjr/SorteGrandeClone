/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sorteGrande;

import conexao.Conexao;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pg3651
 */
public class Resultado {
    private int id;
    private String resultado;
    private String tipo;
    private Date data;
    private Conexao con =  new Conexao();

    public Resultado() {
    }

      
    public Resultado(int id, String resultado, String tipo, Date data) {
        this.id = id;
        this.resultado = resultado;
        this.tipo = tipo;
        this.data = data;
    }
    
           
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getData() {
        return data;
    }
    
    private void salvarResultado(String resultado, String tipo) {
        try {
            con.iniciarConexao();
            Statement stm = con.getConnection().createStatement();
            stm.execute("INSERT INTO resultado (RESULTADO, TIPO) values (" + resultado + ", " + tipo + ")");
            con.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(SorteGrande.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Resultado> getListaResultado(String tipo) {
        List<Resultado> retorno = new ArrayList<Resultado>();
        try {
            con.iniciarConexao();
            Statement stm = con.getConnection().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM resultado WHERE TIPO = '" + tipo + "' order by DATA LIMIT 5");
            while(rs.next()){
                retorno.add(new Resultado(rs.getInt("ID_RESULTADO"),rs.getString("RESULTADO"), rs.getString("TIPO"), rs.getDate("DATA")));
                System.out.println("teste");
            }
            con.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(SorteGrande.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
}
