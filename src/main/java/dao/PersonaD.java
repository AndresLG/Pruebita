package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.PersonaM;

public class PersonaD extends conexion {

    public void agregar(PersonaM persona) throws Exception {
        try {
            this.conexion();
            String sql = "INSERT INTO PERSONA (NOMPER,APEPER,DNIPER,CELPER,EMAPER) VALUES(?,?,?,?,?)";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, persona.getNOMPER());
            st.setString(2, persona.getAPEPER());
            st.setString(3, persona.getDNIPER());
            st.setString(4, persona.getCELPER());
            st.setString(5, persona.getEMAPER());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
    public List<PersonaM> listar() throws Exception {
        List<PersonaM> lista;
        ResultSet rs;
        try {
            this.conexion();
            String sql = "SELECT CODPER,NOMPER,APEPER,DNIPER,CELPER,EMAPER FROM PERSONA ORDER BY CODPER";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                PersonaM persona = new PersonaM();
                persona.setCODPER(rs.getString("CODPER"));
                persona.setNOMPER(rs.getString("NOMPER"));
                persona.setAPEPER(rs.getString("APEPER"));
                persona.setDNIPER(rs.getString("DNIPER"));
                persona.setCELPER(rs.getString("CELPER"));
                persona.setEMAPER(rs.getString("EMAPER"));
                lista.add(persona);
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

}
