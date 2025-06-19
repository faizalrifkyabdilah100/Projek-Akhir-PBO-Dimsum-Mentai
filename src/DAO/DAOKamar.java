/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOKamar;
import Koneksi.Koneksi;
import Model.Kamar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HUAWEI D15
 */
public class DAOKamar implements IDAOKamar{
    Connection connection;
    
    final String insert = "INSERT INTO room (id, nomorKamar, tipeKamar, harga, status) VALUES (?, ?, ?, ?,?);";
    final String update = "UPDATE room set nomorKamar=?, tipeKamar=?, harga=?, status=? where id=? ;";
    final String delete = "DELETE FROM room where id=? ;";
    final String select = "SELECT * FROM room";
    final String carikamar = "SELECT * FROM room where nomorKamar like ?";
    
    public DAOKamar (){
        connection = Koneksi.connection();
    }
    
    @Override
    public List<Kamar> getAll() {
        List<Kamar> lk = null;
        try {
            lk = new ArrayList<Kamar>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Kamar b = new Kamar();
                b.setId(rs.getInt("Id"));
                b.setNomorKamar(rs.getString("NomorKamar"));
                b.setTipeKamar(rs.getString("TipeKamar"));
                b.setHarga(rs.getString("Harga"));
                b.setStatus(rs.getString("Status"));
                lk.add(b);
        }
    } catch (SQLException ex) {
        Logger.getLogger(DAOTamu.class.getName()).log(Level.SEVERE, null, ex);
        
    }
        return lk;
    }

    @Override
    public void insert(Kamar b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setInt(1, b.getId());
            statement.setString(2, b.getNomorKamar());
            statement.setString(3, b.getTipeKamar());
            statement.setString(4, b.getHarga());
            statement.setString(5, b.getStatus());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                b.setId(rs.getInt(1));
            }
            
            
        } catch (SQLException ex) {
            System.out.println("Berhasil Input");
        } finally {
            try {
                statement.close();
        } catch (SQLException ex) {
            System.out.println("Gaagal Input");
        }
        }
    }

    @Override
    public void update(Kamar b) {
        PreparedStatement statement = null;
        try {
        statement = connection.prepareStatement(update);
        statement.setString(1, b.getNomorKamar());
        statement.setString(2, b.getTipeKamar());
        statement.setString(3, b.getHarga());
        statement.setString(4, b.getStatus());
        statement.setInt(5, b.getId());
        statement.executeUpdate();
    } catch (SQLException ex) {
        System.out.println("Berhasil update");
    } finally {
        try{
            statement.close();
        } catch (SQLException ex){
            System.out.println("Gagal input");
        }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("berhasil delete");
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("gagal Update");
            }
        }
    }

    @Override
    public List<Kamar> getCariNama(String nama) {
        List<Kamar> lk = null;
        try {
            lk = new ArrayList<Kamar>();
            PreparedStatement st = connection.prepareStatement(carikamar);
            st.setString(1, "%" + nama + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Kamar b = new Kamar();
                b.setId(rs.getInt("Id"));
                b.setNomorKamar(rs.getString("NomorKamar"));
                b.setTipeKamar(rs.getString("TipeKamar"));
                b.setHarga(rs.getString("Harga"));
                b.setStatus(rs.getString("Status"));
                lk.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOKamar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lk;
    }
    
    
    
}
