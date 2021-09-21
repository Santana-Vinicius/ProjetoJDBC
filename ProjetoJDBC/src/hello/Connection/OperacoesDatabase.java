package hello.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hello.Produto.Produto;

public class OperacoesDatabase {
	private Connection conexao = ConnectionFactory.shared.getConexao();

	public void insert(Produto produto) {
		try {
			// Inserir o produto na tabela do banco: tb_produto
			/*
			 * INSERT INTRO tb_produto (id, nome, descricao, quantidade, preco) values (, ,
			 * , , ,);
			 */

			String insert = "INSERT INTO tb_produto (id_produto, nome, descricao, quantidade, preco) VALUES (?,?,?,?,?)";

			// Criar um Statement
			PreparedStatement ps = conexao.prepareStatement(insert);

			// Passa o que cada ? representa
			ps.setInt(1, produto.getId()); // Id
			ps.setString(2, produto.getNome()); // Nome
			ps.setString(3, produto.getDescricao()); // Descricao
			ps.setInt(4, produto.getQuantidade()); // Quantidade
			ps.setDouble(5, produto.getPreco()); // Preco

			// Executar a query no banco
			ps.execute();
			System.out.println("Product inserted!");

		} catch (SQLException e) {
			System.out.println("Error to insert a new product");
			System.out.println(e.getLocalizedMessage());
		}
	}

	public List<Produto> select() {

		List<Produto> produtos = new ArrayList<Produto>(); // Tudo que vem do nosso banco, é guardado aqui
		String select = "SELECT * FROM tb_produto";

		try {
			// Preparar um statement com o nosso sql
			PreparedStatement ps = conexao.prepareStatement(select);

			// ResultSet ["id": 1, "nome": "HD"]
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Produto produto = new Produto();
					produto.setId(rs.getInt("id_produto"));
					produto.setNome(rs.getString("nome"));
					produto.setDescricao(rs.getString("descricao"));
					produto.setQuantidade(rs.getInt("quantidade"));
					produto.setPreco(rs.getDouble("preco"));

					produtos.add(produto);
				}

			}

		} catch (SQLException e) {
			System.out.println("Error to select all the items in product table");
			System.out.println(e.getLocalizedMessage());
		}

		return produtos;

	}

	// Delete
	public void delete(Integer id) {
		// Criamos nossa Query
		String delete = "DELETE FROM tb_produto WHERE id_produto = ?";
		
		try {
			// Criamos um Statement
			PreparedStatement ps = conexao.prepareStatement(delete);
			ps.setInt(1, id); // dizemos pra nossa query qual será o valor do id 
			
			ps.execute(); // Executamos a nossa query
			
			System.out.println("Product deleted"); // Printamos que o produto foi deletado
			
		} catch (SQLException e) {
			System.out.println("Erro to delete a product");
			System.out.println(e.getLocalizedMessage());
		}
	}

	// Update

	public void updateDescricao(Integer idProduto, String novaDescricao) {
		// Criamos nossa query para atualizar a descrição do produto
		
		/*
		 * 	UPDATE tb_produto
		 *	SET descricao = ?
		 *	WHERE condition;  
		 *
		 * */
		
		String update = "UPDATE tb_produto SET descricao = ? WHERE id_produto = ?";
		try {
			PreparedStatement ps = conexao.prepareStatement(update);
			ps.setString(1, novaDescricao);
			ps.setInt(2, idProduto);
			
			ps.execute();
			
			System.out.println("Product description updated" + idProduto);
		} catch (SQLException e) {
			System.out.println("Error to update a product!");
			System.out.println(e.getLocalizedMessage());
		}
		
		
		
	}

	public Connection getConexao() {
		return conexao;
	}
}
