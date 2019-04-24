package principal;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import dao.ProdutoDAO;

public class TelaCadastroProduto extends JDialog implements ActionListener{
	
	JLabel labelNome, labelValor;
	JTextField entradaNome, entradaValor;
	JButton botaoCancelar, botaoCadastrar;
	TelaProduto telaProduto;
	
	public TelaCadastroProduto (JFrame frame) {
		super(frame,true);
		telaProduto =(TelaProduto) frame;
		setSize(frame.getWidth(),frame.getHeight()-300);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setResizable(false);
		setTitle("Cadastro Produtos");
		Init();
		setVisible(true);
		
	}

	private void Init() {
		
		labelNome = new JLabel();
		labelNome.setBounds(25, 25, getWidth()-40, 45);
		labelNome.setText("Produto : ");		
		add(labelNome);
		
		entradaNome = new JTextField();
		entradaNome.setBounds(labelNome.getX(),labelNome.getY()+
				labelNome.getHeight()+10, labelNome.getWidth(),labelNome.getHeight());
		add(entradaNome);
		
		labelValor = new JLabel();
		labelValor.setBounds(entradaNome.getX(), entradaNome.getY() + 
				entradaNome.getHeight()+10, entradaNome.getWidth(),entradaNome.getHeight());
		labelValor.setText("Valor R$ : ");
		add(labelValor);
		
		entradaValor = new JTextField();
		entradaValor.setBounds(labelValor.getX(),labelValor.getY()+
				labelValor.getHeight(), labelValor.getWidth(),labelValor.getHeight());
		add(entradaValor);
		
		botaoCancelar = new JButton();
		botaoCancelar.setText("CANCELAR");
		botaoCancelar.setBounds(entradaValor.getX()+80, entradaValor.getY()+ entradaValor.getHeight()+20
				,entradaValor.getWidth()/4, entradaValor.getHeight());
		add(botaoCancelar);
		
		botaoCadastrar = new JButton();
		botaoCadastrar.setText("CADASTRAR");
		botaoCadastrar.setBounds(botaoCancelar.getX()+botaoCancelar.getWidth()+50,botaoCancelar.getY(),
				botaoCancelar.getWidth(), botaoCancelar.getHeight());
		add(botaoCadastrar);	
		
		botaoCadastrar.addActionListener(this);
		botaoCancelar.addActionListener(this);		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg) {
		if (arg.getSource().equals(botaoCadastrar)) {
			Produto proCadastrar = new Produto();
			
			proCadastrar.setNomeProduto(entradaNome.getText());
			proCadastrar.setPrecoProduto(Double.parseDouble(entradaValor.getText().replace("," , ".")));
			ProdutoDAO produtoDAO = new ProdutoDAO();
			
			if (produtoDAO.cadastrar(proCadastrar)) {
				JOptionPane.showMessageDialog(null,"Cadastrado com sucesso");
				
			}
			else  {
				JOptionPane.showMessageDialog(null,"Erro ao cadastrar");
			}
			dispose();
		}
		
		else if (arg.getSource().equals(botaoCancelar)) {
			dispose();
		}
		
	}

	

}
