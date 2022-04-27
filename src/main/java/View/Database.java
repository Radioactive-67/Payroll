/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ashish Anand
 */
public class Database {
    private static Database db = null;
    private Connection c;
    private Statement stmt=null;
    
    private Database() {
        try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/payrolls",
            "postgres", "root");
            System.out.println("Database connected!");
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.out.println("Bruh");
         System.exit(0);
      }
    }
    public static Database getDatabase(){
        if(db==null){
            db = new Database();
        }
        return db;
    }
    public Connection getC() {
        return c;
    }

    public void setC(Connection c) {
        this.c = c;
    }
    
    public Statement getStmt() throws SQLException {
        if(stmt==null){
            stmt = c.createStatement();
        }
        return stmt;
    }

    public void setStmt(Statement stmt, String sql) throws SQLException {
        this.stmt = stmt;
        stmt.executeUpdate(sql);
    }
    
    
}
