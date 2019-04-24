package dao;
import principal.Produto;
import java.util.ArrayList;

public class Nossobanco {
	
	private static Nossobanco repositorio =null;
	ArrayList<Produto> produtos;
	
	private Nossobanco(){
		produtos = new ArrayList<Produto>();
	}
	
	public static Nossobanco getInstance(){
		if(repositorio== null){
			repositorio = new Nossobanco();
		}
		return repositorio;
	}
	
	
}
