package principal;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class ExcluirProduto extends JDialog{
	
	public ExcluirProduto (JFrame frame) {
		

		super(frame, true);

		TelaProduto telaProdutoEditar = (TelaProduto) frame;
		setSize(frame.getWidth(), frame.getHeight());
		setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Editar produto");
		
		setVisible(true);
		
		
	}
	
	

}
