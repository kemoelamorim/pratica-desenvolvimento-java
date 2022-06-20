package prova;

import java.sql.*;
import java.util.ArrayList;

public class RepositoryProdutos  {
	
	private ArrayList<Produto> produtos;
	private PreparedStatement ps;
	private Connection conexao;
	
	public RepositoryProdutos() {
		conexao = new Connect().getConnection();
		produtos = new ArrayList<Produto>();
	}
	
	public ArrayList<Produto> getProdutos(){
		try {			
			ps = conexao.prepareStatement("select * from produto");
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() )
		        {
				 	Produto p = new Produto();
		            p.codigo = Integer.parseInt(rs.getString("id"));
		            p.nome = rs.getString("nome");
		            p.preco = Double.parseDouble(rs.getString("preco"));
		            p.estoque = Integer.parseInt(rs.getString("estoque"));
		            
			        produtos.add(p); 
		          
		        }
			return produtos;
		}catch(SQLException	e){
			throw new RuntimeException(e);
		}
		
	}
	public Produto getProduto(int id) {
		try {			
			ps = conexao.prepareStatement("select * from produto where id="+id);
			ResultSet rs = ps.executeQuery();
			Produto p = new Produto();
			p.codigo = Integer.parseInt(rs.getString("id"));
			
			p.nome = rs.getString("nome");
			p.preco = Double.parseDouble(rs.getString("preco"));
			p.estoque = Integer.parseInt(rs.getString("estoque"));
			
			return p;
		}catch(SQLException	e){
			throw new RuntimeException(e);
		}
	}
	public Produto updateQtdProduto(int id, int qtd) {
		try {			
			ps = conexao.prepareStatement("select * from produto where id="+id);
			ResultSet rs = ps.executeQuery();
			Produto p = new Produto();
			
			p.estoque = Integer.parseInt(rs.getString("estoque"));
			int qtdAtual = p.estoque -= qtd;
			
			
			ps = conexao.prepareStatement("update produto set estoque="+ qtdAtual+ " where id="+id);
			ResultSet rs2 = ps.executeQuery();
			Produto p2 = new Produto();
			
			return p2;
		}catch(SQLException	e){
			throw new RuntimeException(e.getMessage());
		}
	}
}
