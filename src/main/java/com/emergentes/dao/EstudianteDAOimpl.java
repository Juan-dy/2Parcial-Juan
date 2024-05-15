
package com.emergentes.dao;

import com.emergentes.modelo.Estudiante;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EstudianteDAOimpl extends ConexionBD implements EstudianteDAO {

    @Override
    public void insertar(Estudiante estudiante) throws Exception {
        
        String sql = "insert into estudiantes (nombres, apellidos, seminario, confirmado, fecha_ins) values (?,?,?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, estudiante.getNombres());
        ps.setString(2, estudiante.getApellidos());
        ps.setString(3, estudiante.getSeminario());
        ps.setInt(4, estudiante.getConfirmado());
        ps.setString(5, estudiante.getFecha_ins());
        
        ps.executeUpdate();
        this.desconectar();
        
    }

    @Override
    public void update(Estudiante estudiante) throws Exception {
        String sql = "update estudiantes set nombres = ?, apellidos = ?, seminario = ?, confirmado = ?, fecha_ins = ? where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, estudiante.getNombres());
        ps.setString(2, estudiante.getApellidos());
        ps.setString(3, estudiante.getSeminario());
        ps.setInt(4, estudiante.getConfirmado());
        ps.setString(5, estudiante.getFecha_ins());
        ps.setInt(6, estudiante.getId());
        
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        
        String sql = "delete from estudiantes where id = ?";
        this.conectar();    
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public List<Estudiante> getAll() throws Exception {
        
        List<Estudiante> lista = null;
        String sql = "select * from estudiantes";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        
        lista = new ArrayList<Estudiante>();
        while(rs.next()){
            Estudiante et = new Estudiante();
            
            et.setId(rs.getInt("id"));
            et.setNombres(rs.getString("nombres"));
            et.setApellidos(rs.getString("apellidos"));
            et.setSeminario(rs.getString("seminario"));
            et.setConfirmado(rs.getInt("confirmado"));
            et.setFecha_ins(rs.getString("fecha_ins"));

            lista.add(et);
        }
        this.desconectar();
        return lista;
    }

    @Override
    public Estudiante getById(int id) throws Exception {
        
        Estudiante et = new Estudiante();
        String sql = "select * from estudiantes where id =?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            
            et.setId(rs.getInt("id"));
            et.setNombres(rs.getString("nombres"));
            et.setApellidos(rs.getString("apellidos"));
            et.setSeminario(rs.getString("seminario"));
            et.setConfirmado(rs.getInt("confirmado"));
            et.setFecha_ins(rs.getString("fecha_ins"));
            
        }
        this.desconectar();
        return et;
    }
    
}
