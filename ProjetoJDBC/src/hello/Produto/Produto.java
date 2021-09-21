package hello.Produto;

public class Produto {
	
	// Atributos
	private Integer id;
	private String nome;
	private String descricao;
	private Integer quantidade;
	private Double preco;
	
	
	// Construtores ou Inicializadores
	public Produto() {}

	public Produto(Integer id, String nome, String descricao, Integer quantidade, Double preco) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	// Getters and Setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Produto [id = " + id + ", nome = " + nome + ", descricao = " + descricao + ", quantidade = "
				+ quantidade + ", preco = " + preco + "]";
	}
	
	
	
	
	
	
}
