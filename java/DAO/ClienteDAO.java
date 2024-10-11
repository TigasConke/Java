package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.ClienteModel;

public class ClienteDAO {
	public String cadastrarCliente(ClienteModel novoCliente) {
		
		String functionReturn = "Não foi possível cadastrar o cliente!";
		String sql = "INSERT INTO cliente (nome, cpf, email, endereco, dtNascimento, id_categoria) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			
			ConexaoDAO conexaoDao = new ConexaoDAO();
			Connection databaseConnection = conexaoDao.conectarDB();

			if (databaseConnection != null) {
				
				PreparedStatement query = databaseConnection.prepareStatement(sql);
				query.setString(1, novoCliente.getNome());
				query.setString(2, novoCliente.getCpf());
				query.setString(3, novoCliente.getEmail());
				query.setString(4, novoCliente.getEndereco());
				query.setDate(5, novoCliente.getDtNascimento());
				query.setInt(6, novoCliente.getCategoria());

				int resultadoQuery = query.executeUpdate();
				
				if (resultadoQuery > 0) {
					
					functionReturn = "Cliente cadastrado com sucesso!";
					
				}
			} else {
				
				functionReturn = "Houve um erro ao se conectar com o banco de dados";
				
			}

			conexaoDao.desconectarDB();
			
		} catch (SQLException exception) {
			
			System.out.println(" > Houve um erro ao cadastrar o cliente: " + exception.getMessage());
			
		}
		
		return functionReturn;
	}
	
	public ArrayList<ClienteModel> procurarCliente(String nome) {
		
		String sql = "SELECT * FROM cliente WHERE nome LIKE ?";
		ArrayList<ClienteModel> clientes = new ArrayList<>();
		
		try {
			
			ConexaoDAO conexaoDao = new ConexaoDAO();
			Connection databaseConnection = conexaoDao.conectarDB();

			if (databaseConnection != null) {
				
				PreparedStatement query = databaseConnection.prepareStatement(sql);
				query.setString(1, "%" + nome + "%");

				ResultSet resultadoQuery = query.executeQuery();
				
				while (resultadoQuery.next()) {
					
	                ClienteModel cliente = new ClienteModel();
	                cliente.setCodigo(resultadoQuery.getInt("codigo"));
	                cliente.setNome(resultadoQuery.getString("nome"));
	                cliente.setCpf(resultadoQuery.getString("cpf"));
	                cliente.setEmail(resultadoQuery.getString("email"));
	                cliente.setEndereco(resultadoQuery.getString("endereco"));
	                cliente.setDtNascimento(resultadoQuery.getDate("dtNascimento"));
	                cliente.setCategoria(resultadoQuery.getInt("id_categoria"));
	                
	                clientes.add(cliente);
	                
	            }
				
			}

			conexaoDao.desconectarDB();
		} catch (SQLException exception) {
			
			System.out.println(" > Houve um erro ao procurar o cliente: " + exception.getMessage());
			
		}		
		
		return clientes;
	}
	
	public ArrayList<ClienteModel> buscarClientes() {
		
		String sql = "SELECT * FROM cliente";
		ArrayList<ClienteModel> clientes = new ArrayList<>();
		
		try {
			
			ConexaoDAO conexaoDao = new ConexaoDAO();
			Connection databaseConnection = conexaoDao.conectarDB();

			if (databaseConnection != null) {
				
				PreparedStatement query = databaseConnection.prepareStatement(sql);

				ResultSet resultadoQuery = query.executeQuery();
				
				while (resultadoQuery.next()) {
					
	                ClienteModel cliente = new ClienteModel();
	                cliente.setCodigo(resultadoQuery.getInt("codigo"));
	                cliente.setNome(resultadoQuery.getString("nome"));
	                cliente.setCpf(resultadoQuery.getString("cpf"));
	                cliente.setEmail(resultadoQuery.getString("email"));
	                cliente.setEndereco(resultadoQuery.getString("endereco"));
	                cliente.setDtNascimento(resultadoQuery.getDate("dtNascimento"));
	                cliente.setCategoria(resultadoQuery.getInt("id_categoria"));
	                
	                clientes.add(cliente);
	                
	            }
				
			}

			conexaoDao.desconectarDB();
		} catch (SQLException exception) {
			
			System.out.println(" > Houve um erro ao procurar o cliente: " + exception.getMessage());
			
		}
		
		return clientes;
	}
	
    public String atualizarCliente(ClienteModel cliente) {
    	   	
    	String resultado = "Erro ao atualizar cliente!";
        String sql = "UPDATE cliente SET nome = ?, cpf = ?, email = ?, endereco = ?, dtNascimento = ?, id_categoria = ? WHERE codigo = ?";
        
        try {
        	
			ConexaoDAO conexaoDao = new ConexaoDAO();
			Connection databaseConnection = conexaoDao.conectarDB();
			
			if (databaseConnection != null) {
				
				PreparedStatement query = databaseConnection.prepareStatement(sql);
				query.setString(1, cliente.getNome());
				query.setString(2, cliente.getCpf());
				query.setString(3, cliente.getEmail());
				query.setString(4, cliente.getEndereco());
				query.setDate(5, new Date(cliente.getDtNascimento().getTime()));
				query.setInt(6, cliente.getCategoria());
				query.setInt(7, cliente.getCodigo());
				
	            int rowsAffected = query.executeUpdate();
	            
	            if (rowsAffected > 0) {
	            	
	                resultado = "Cliente atualizado com sucesso!";
	                
	            }
	            
			}
			
        } catch (SQLException e) {
        	
            System.err.println(" > Houve um erro ao atualizar o cliente: " + e.getMessage());
            
        }

        return resultado;
        
    }
    
    public ArrayList<ClienteModel> procurarClienteCategoria(int categoria_id) {
    	
        String sql = "SELECT * FROM cliente WHERE id_categoria = ?";
        ArrayList<ClienteModel> clientes = new ArrayList<ClienteModel>();
        
        try {
        	
			ConexaoDAO conexaoDao = new ConexaoDAO();
			Connection databaseConnection = conexaoDao.conectarDB();
			
			if (databaseConnection != null) {
				
				PreparedStatement query = databaseConnection.prepareStatement(sql);
				query.setInt(1, categoria_id);
				
				ResultSet resultadoQuery = query.executeQuery();
				
				while (resultadoQuery.next()) {
					
	                ClienteModel cliente = new ClienteModel();
	                cliente.setCodigo(resultadoQuery.getInt("codigo"));
	                cliente.setNome(resultadoQuery.getString("nome"));
	                cliente.setCpf(resultadoQuery.getString("cpf"));
	                cliente.setEmail(resultadoQuery.getString("email"));
	                cliente.setEndereco(resultadoQuery.getString("endereco"));
	                cliente.setDtNascimento(resultadoQuery.getDate("dtNascimento"));
	                cliente.setCategoria(resultadoQuery.getInt("id_categoria"));
	                	                
	                clientes.add(cliente);
	                
	            }
				
			}
			
        } catch (SQLException e) {
        	
            System.err.println(" > Houve um erro ao procurar os clientes: " + e.getMessage());
            
        }

        return clientes;
        
    }
    
    public ClienteModel procurarClienteCodigo(int codigo) {
    	
		String sql = "SELECT * FROM cliente WHERE codigo = ?";
		ClienteModel cliente = null;
		
		try {
			
			ConexaoDAO conexaoDao = new ConexaoDAO();
			Connection databaseConnection = conexaoDao.conectarDB();

			if (databaseConnection != null) {
				
				PreparedStatement query = databaseConnection.prepareStatement(sql);
				query.setInt(1, codigo);

				ResultSet resultadoQuery = query.executeQuery();
				if (resultadoQuery.next()) {
					
					cliente = new ClienteModel();
	                cliente.setCodigo(resultadoQuery.getInt("codigo"));
                	cliente.setNome(resultadoQuery.getString("nome"));
                	cliente.setCpf(resultadoQuery.getString("cpf"));
                	cliente.setEmail(resultadoQuery.getString("email"));
                	cliente.setEndereco(resultadoQuery.getString("endereco"));
                	cliente.setDtNascimento(resultadoQuery.getDate("dtnascimento"));
                	cliente.setCategoria(resultadoQuery.getInt("id_categoria"));
                	
	            }
			}
			

			conexaoDao.desconectarDB();
			
		} catch (SQLException exception) {
			
			System.out.println(" > Houve um erro ao procurar o cliente: " + exception.getMessage());
			
		}
		
		return cliente;
		
	}
    
    public String removerCliente(int codigoCliente) {
    	
    	String resultado = "Erro ao remover cliente!";
        String sql = "DELETE FROM cliente WHERE codigo = ?";
        
        try {
        	
			ConexaoDAO conexaoDao = new ConexaoDAO();
			Connection databaseConnection = conexaoDao.conectarDB();
			
			if (databaseConnection != null) {
				
				PreparedStatement query = databaseConnection.prepareStatement(sql);
				query.setInt(1, codigoCliente);
				
	            int rowsAffected = query.executeUpdate();
	            
	            if (rowsAffected > 0) {
	            	
	                resultado = "Cliente removido com sucesso!";
	                
	            }
			}
			
        } catch (SQLException e) {
        	
              	System.err.println(" > Houve um erro ao remover o cliente: " + e.getMessage());
        
        }
        

        return resultado;
    }
}
