package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.CategoriaModel;

public class CategoriaDAO {
	
	public String cadastrarCategoria(CategoriaModel novaCategoria) {
        String functionReturn = "Não foi possível cadastrar a categoria!";
        String sql = "INSERT INTO categoria (nome, descricao, ativo) VALUES (?, ?, ?)";

        try {
        	
            ConexaoDAO conexaoDao = new ConexaoDAO();
            Connection databaseConnection = conexaoDao.conectarDB();

            if (databaseConnection != null) {
            	
                PreparedStatement query = databaseConnection.prepareStatement(sql);
                query.setString(1, novaCategoria.getNome());
                query.setString(2, novaCategoria.getDescricao());
                query.setBoolean(3, novaCategoria.getAtivo());

                int resultadoQuery = query.executeUpdate();
                if (resultadoQuery > 0) {
                    functionReturn = "Categoria cadastrada com sucesso!";
                }
                
            } else {
            	
                functionReturn = "Houve um erro ao se conectar com o banco de dados";
                
            }

            conexaoDao.desconectarDB();
        } catch (SQLException exception) {
        	
            System.out.println(" > Houve um erro ao cadastrar a categoria: " + exception.getMessage());
            
        }
        
        return functionReturn;
        
    }
	
    public ArrayList<CategoriaModel> buscarCategorias() {
    	
        String sql = "SELECT * FROM categoria";
        ArrayList<CategoriaModel> categorias = new ArrayList<>();
        
        try {
        	
            ConexaoDAO conexaoDAO = new ConexaoDAO();
            Connection databaseConnection = conexaoDAO.conectarDB();

            if (databaseConnection != null) {
            	
                PreparedStatement query = databaseConnection.prepareStatement(sql);
                
                ResultSet resultadoQuery = query.executeQuery();
                
                while (resultadoQuery.next()) {
                	
                    CategoriaModel categoria = new CategoriaModel();
                    categoria.setId(resultadoQuery.getInt("id"));
                    categoria.setNome(resultadoQuery.getString("nome"));
                    categoria.setDescricao(resultadoQuery.getString("descricao"));
                    categoria.setAtivo(resultadoQuery.getBoolean("ativo"));

                    categorias.add(categoria);
                    
                }
                
            }

            conexaoDAO.desconectarDB();
        } catch (SQLException exception) {
        	
            System.out.println(" > Houve um erro ao procurar a categoria: " + exception.getMessage());
            
        }
        
        return categorias;
        
    }
    
    public CategoriaModel procurarCategoriaId(int categoriaId) {
    	
    	String sql = "SELECT * FROM categoria WHERE id = ?";
    	CategoriaModel categoria = null;
        
        try {
        	
            ConexaoDAO conexaoDao = new ConexaoDAO();
            Connection databaseConnection = conexaoDao.conectarDB();

            if (databaseConnection != null) {
            	
                PreparedStatement query = databaseConnection.prepareStatement(sql);
                query.setInt(1, categoriaId);
                
                ResultSet resultadoQuery = query.executeQuery();
				
                if (resultadoQuery.next()) {
					
					categoria = new CategoriaModel();
					categoria.setId(resultadoQuery.getInt("id"));
					categoria.setNome(resultadoQuery.getString("nome"));
					categoria.setDescricao(resultadoQuery.getString("descricao"));
					categoria.setAtivo(resultadoQuery.getBoolean("ativo"));
					
                }
                
            }

            conexaoDao.desconectarDB();
            
        } catch (SQLException exception) {
        	
            System.out.println(" > Houve um erro ao procurar a categoria: " + exception.getMessage());
            
        }
        
        return categoria;
        
    }
    
    public CategoriaModel procurarCategoriaNome(String categoriaNome) {
    	
    	String sql = "SELECT * FROM categoria WHERE nome LIKE ?";
    	CategoriaModel categoria = null;
        
        try {
        	
            ConexaoDAO conexaoDao = new ConexaoDAO();
            Connection databaseConnection = conexaoDao.conectarDB();

            if (databaseConnection != null) {
            	
                PreparedStatement query = databaseConnection.prepareStatement(sql);
                query.setString(1, "%" + categoriaNome + "%");
                
                ResultSet resultadoQuery = query.executeQuery();
				if (resultadoQuery.next()) {
					
					categoria = new CategoriaModel();
					categoria.setId(resultadoQuery.getInt("id"));
					categoria.setNome(resultadoQuery.getString("nome"));
					categoria.setDescricao(resultadoQuery.getString("descricao"));
					categoria.setAtivo(resultadoQuery.getBoolean("ativo"));
	            
				}
            }
            

            conexaoDao.desconectarDB();
            
        } catch (SQLException exception) {
        	
            System.out.println(" > Houve um erro ao procurar a categoria: " + exception.getMessage());
            
        }
        
        return categoria;
        
    }
	
	public String atualizarCategoria(CategoriaModel categoria) {
		
        String resultado = "Erro ao atualizar categoria!";
        String sql = "UPDATE categoria SET nome = ?, descricao = ?, ativo = ? WHERE id = ?";
        
        try {
        	
            ConexaoDAO conexaoDao = new ConexaoDAO();
            Connection databaseConnection = conexaoDao.conectarDB();
            
            if (databaseConnection != null) {
            	
                PreparedStatement query = databaseConnection.prepareStatement(sql);
                query.setString(1, categoria.getNome());
                query.setString(2, categoria.getDescricao());
                query.setBoolean(3, categoria.getAtivo());
                query.setInt(4, categoria.getId());
                
                int rowsAffected = query.executeUpdate();
                if (rowsAffected > 0) {
                    resultado = "Categoria atualizada com sucesso!";
                    
                }
                
            }
            
        } catch (SQLException e) {
        	
            System.err.println(" > Houve um erro ao atualizar a categoria: " + e.getMessage());
       
        }

        return resultado;
        
    }
	
	public String removerCategoria(int idCategoria) {
		
        String resultado = "Erro ao remover categoria!";
        String sql = "DELETE FROM categoria WHERE id = ?";
        
        try {
        	
            ConexaoDAO conexaoDao = new ConexaoDAO();
            Connection databaseConnection = conexaoDao.conectarDB();
            
            if (databaseConnection != null) {
            	
                PreparedStatement query = databaseConnection.prepareStatement(sql);
                query.setInt(1, idCategoria);
                
                int rowsAffected = query.executeUpdate();
                
                if (rowsAffected > 0) {
                	
                    resultado = "Categoria removida com sucesso!";
                    
                }
            }
            
        } catch (SQLException e) {
        	
            System.err.println(" > Houve um erro ao remover a categoria: " + e.getMessage());
            
        }

        return resultado;
        
    }
	
}

