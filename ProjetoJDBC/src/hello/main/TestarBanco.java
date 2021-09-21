package hello.main;

import java.sql.SQLException;

import hello.Connection.OperacoesDatabase;
import hello.Produto.Produto;

public class TestarBanco {

	public static void main(String[] args) {
		OperacoesDatabase conexao = new OperacoesDatabase();
		
//		Produto produto = new Produto(2, "HD", "1TB", 2, 350.00);
//		conexao.insert(produto);
//		System.out.println(produto);
//		conexao.delete(2);
		
		conexao.updateDescricao(1, "32 GB");
		System.out.println("--------------------------------------------------");
		for (Produto produtoLido : conexao.select()) {
			System.out.println(produtoLido);
		}
		System.out.println("--------------------------------------------------");
		
		try {
			conexao.getConexao().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
