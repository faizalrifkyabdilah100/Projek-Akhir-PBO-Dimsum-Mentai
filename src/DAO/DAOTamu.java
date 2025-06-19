/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOTamu;
import Koneksi.Koneksi;
import Model.Tamu;
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
public class DAOTamu implements IDAOTamu{
    
    Connection connection;
    final String insert = "INSERT INTO guest (id, nama, email,telepon, alamat) VALUES (?, ?, ?, ?,?);";
    final String update = "UPDATE guest set nama=?, email=?, telepon=?, alamat=? where id=? ;";
    final String delete = "DELETE FROM guest where id=? ;";
    final String select = "SELECT * FROM guest";
    final String carinama = "SELECT * FROM guest where nama like ?";
    
    public DAOTamu(){
        connection = Koneksi.connection();
    }

    @Override
    public List<Tamu> getAll() {
        List<Tamu> lt = null;
        try {
            lt = new ArrayList<Tamu>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Tamu b = new Tamu();
                b.setId(rs.getInt("Id"));
                b.setNama(rs.getString("Nama"));
                b.setEmail(rs.getString("Email"));
                b.setNoTelepon(rs.getString("Telepon"));
                b.setAlamat(rs.getString("Alamat"));
                lt.add(b);
        }
    } catch (SQLException ex) {
        Logger.getLogger(DAOTamu.class.getName()).log(Level.SEVERE, null, ex);
        
    }
        return lt;
    }

    @Override
    public void insert(Tamu b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setInt(1, b.getId());
            statement.setString(2, b.getNama());
            statement.setString(3, b.getEmail());
            statement.setString(4, b.getNoTelepon());
            statement.setString(5, b.getAlamat());
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
    public void update(Tamu b) {
        PreparedStatement statement = null;
        try {
        statement = connection.prepareStatement(update);
        statement.setString(1, b.getNama());
        statement.setString(2, b.getEmail());
        statement.setString(3, b.getNoTelepon());
        statement.setString(4, b.getAlamat());
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
    public List<Tamu> getCariNama(String nama) {
        List<Tamu> lt = null;
        try {
            lt = new ArrayList<Tamu>();
            PreparedStatement st = connection.prepareStatement(carinama);
            st.setString(1, "%" + nama + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Tamu b = new Tamu();
                b.setId(rs.getInt("Id"));
                b.setNama(rs.getString("Nama"));
                b.setEmail(rs.getString("Email"));
                b.setNoTelepon(rs.getString("Telepon"));
                b.setAlamat(rs.getString("Alamat"));
                lt.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTamu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lt;
    }
}
