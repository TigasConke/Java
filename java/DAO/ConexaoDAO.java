package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoDAO {
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/aula";
    private static final String DATABASE_USER = "postgres";
    private static final String DATABASE_PASSWORD = "admin";
    
    Connection databaseConnection = null;

    public Connection conectarDB() { 
    	
        try {
        	
            Class.forName("org.postgresql.Driver");
            databaseConnection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            
        } catch (Exception exception) {
        	
            System.out.println(" > Houve um erro ao conectar ao banco de dados: " + exception.getMessage());
            
        }
        
        return databaseConnection;
        
    }
    
    public void desconectarDB() {
    	
        if (databaseConnection != null) {
           
        	try {
            	
                databaseConnection.close();
            } catch (Exception exception) {
            	
                System.out.println(" > Houver um erro ao fechar a conexão: " + exception.getMessage());
                
            }
        } else {
        	
            System.out.println(" > Não existe conexão com o banco de dados para ser fechada");
            
        }
    }
}
