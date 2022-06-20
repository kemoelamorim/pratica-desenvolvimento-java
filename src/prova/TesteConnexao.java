package prova;

import java.util.ArrayList;

public class TesteConnexao {
	
	public static ArrayList<Produto> produtos;
	
	public static void main(String[] args) {
		
		produtos = new RepositoryProdutos().getProdutos();
		for(Produto produto : produtos){
			System.out.println("##############");
            System.out.println("codigo: " + produto.codigo);
            System.out.println("nome: " + produto.nome);
            System.out.println("preço: " + produto.preco);
            System.out.println("estoque: " + produto.estoque);
        }
		new GUISwing(produtos);

	}

}
