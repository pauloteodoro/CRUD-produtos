package principal;
import java.util.Random;


public class Produto {
	
	private String nomeProduto;
	private double precoProduto;
	private int codigoProduto;
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public double getPrecoProduto() {
		return precoProduto;
	}
	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}
	public int getCodigoProduto() {
		
		return codigoProduto ;
	}
	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	@Override
	public String toString() {
		return getCodigoProduto() +"                " + getNomeProduto()  +  "           R$" + getPrecoProduto();
	}
	
	
	
	
	
	
	

}
