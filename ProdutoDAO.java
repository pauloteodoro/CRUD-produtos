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
	
	public ArrayList<Produto> listar(){
		return Nossobanco.getInstance().produtos;
	}
}

