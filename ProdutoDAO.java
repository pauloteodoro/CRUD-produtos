package dao;

import principal.Produto;
import java.util.ArrayList;

public class ProdutoDAO {

	public boolean cadastrar(Produto proCadastrar) {
		if (proCadastrar == null) {
			return false;
		} else {
			Nossobanco.getInstance().produtos.add(proCadastrar);
			return true;
		}
	}
	
	public boolean cadastrar(Produto proCadastrar,int x) {
		if (proCadastrar == null) {
			return false;
		} else {
			Nossobanco.getInstance().produtos.set(x, proCadastrar);;
			return true;
		}
	}
	public boolean cadastrar(int delete) {
		
			Nossobanco.getInstance().produtos.remove(delete);;
			return true;
		
	}

	public ArrayList<Produto> listarByNome(String nome) {
		ArrayList<Produto> prod = new ArrayList<Produto>();
		for (Produto proCadastrar : listar()) {
			if (proCadastrar.getNomeProduto().toLowerCase().contains(nome.toLowerCase())) {
				prod.add(proCadastrar);
			}
		}
		return prod;
	}

	public ArrayList<Produto> listar() {
		return Nossobanco.getInstance().produtos;
	}
}
