/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class data_buku {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String id_buku;
    public String judul_buku;
    public String penerbit;
    public String harga;
    
    public void simpan()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "INSERT INTO buku(id_buku,judul_buku,penerbit,harga)VALUE(?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1,id_buku);
        pst.setString(2,judul_buku);
        pst.setString(3,penerbit);
        pst.setString(4,harga);
        pst.execute();
        pst.close();
    }
    
    public void edit()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "UPDATE buku set judul_buku=?, penerbit=?, harga=? where id_buku=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,judul_buku);
        pst.setString(2,penerbit);
        pst.setString(3,harga);
        pst.setString(4,id_buku);
        pst.execute();
        pst.close();
    }
    
    public void hapus() throws SQLException{
        conn=Koneksi.getKoneksi();
        String sql="DELETE from buku where id_buku=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, id_buku);
            pst.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet UpdatebukuTBL()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "select id_buku,judul_buku,penerbit,harga from buku";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
    
}
