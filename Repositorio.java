package dao;

import java.util.ArrayList;

import principal.Produto;

public class Repositorio {

	private static Repositorio repositorio =null;
	ArrayList<Produto> produtos;
	
	private Repositorio(){
		produtos = new ArrayList<Produto>();
		
	}
	
	
	
	
	public static Repositorio getInstance(){
		if(repositorio== null){
			repositorio = new Repositorio();
		}
		
		return repositorio;
	}
	
	
	
}