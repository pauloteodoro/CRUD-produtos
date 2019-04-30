package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.ProdutoDAO;
import principal.TelaProduto;

@SuppressWarnings("serial")
public class TelaEditarProduto extends JDialog implements ActionListener, KeyListener {

	JLabel labelNome, labelValor;
	JTextField entradaNome, entradaValor;
	JButton botaoCancelar, botaoEditar;
	TelaProduto telaProdutoEditar;
	JList<Produto> listaProdutosEditar;
	int indice;

	public TelaEditarProduto(JFrame frame, int x) {

		super(frame, true);
		indice = x;
		
		telaProdutoEditar = (TelaProduto) frame;
		setSize(frame.getWidth(), frame.getHeight() + 150);
		setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Editar produto");
		Init(frame, x);
		setVisible(true);

	}

	private void Init(JFrame frame, int x) {

		labelNome = new JLabel();
		labelNome.setBounds(20, 10, getWidth() - 40, 15);
		labelNome.setText("Produto : ");
		add(labelNome);

		entradaNome = new JTextField();
		entradaNome.setBounds(labelNome.getX(), labelNome.getY() + labelNome.getHeight() + 10, labelNome.getWidth(),
				labelNome.getHeight());
		add(entradaNome);

		listaProdutosEditar = new JList<Produto>();
		listaProdutosEditar.setBounds(labelNome.getX(), labelNome.getY() + 50 + labelNome.getHeight() + 20,
				labelNome.getWidth(), 400);

		add(listaProdutosEditar);

		labelValor = new JLabel();
		labelValor.setBounds(entradaNome.getX(), entradaNome.getY() + entradaNome.getHeight() + 10,
				entradaNome.getWidth(), entradaNome.getHeight());
		labelValor.setText("Valor R$ : ");
		// add(labelValor);

		entradaValor = new JTextField();
		entradaValor.setBounds(labelValor.getX(), labelValor.getY() + labelValor.getHeight(), labelValor.getWidth(),
				labelValor.getHeight());
		// add(entradaValor);

		botaoCancelar = new JButton();
		botaoCancelar.setText("CANCELAR");
		botaoCancelar.setBounds(entradaValor.getX() + 60, entradaValor.getY() + 20 + entradaValor.getHeight() + 320,
				entradaValor.getWidth() / 4, entradaValor.getHeight() - 50);
		add(botaoCancelar);

		botaoEditar = new JButton();
		botaoEditar.setText("APLICAR");
		botaoEditar.setBounds(botaoCancelar.getX() + botaoCancelar.getWidth() + 50, botaoCancelar.getY(),
				botaoCancelar.getWidth(), botaoCancelar.getHeight());
		add(botaoEditar);

		botaoEditar.addActionListener(this);
		botaoCancelar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent arg) {

		if (arg.getSource().equals(botaoEditar)) {

			
			int remover = JOptionPane.showConfirmDialog(null, "Deletar Item ?");		
			System.out.println(remover);
			
			
			
			
			Produto proCadastrar = new Produto();

			proCadastrar.setNomeProduto(entradaNome.getText());
			proCadastrar.setPrecoProduto(Double.parseDouble(entradaValor.getText().replace(",", ".")));
			Random random = new Random();
			proCadastrar.setCodigoProduto(random.nextInt(1000));
			ProdutoDAO produtoDAO = new ProdutoDAO();
			System.out.println(indice);
			produtoDAO.cadastrar(proCadastrar,indice);

			if (produtoDAO.cadastrar(proCadastrar)) {
				JOptionPane.showMessageDialog(null, "Editado com sucesso");

			} else {
				JOptionPane.showMessageDialog(null, "Erro ao editar");
			}
			
			dispose();
		}

		else if (arg.getSource().equals(botaoCancelar)) {
			dispose();
		}

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		TelaProduto pesquisaPeloNome = new TelaProduto();
		pesquisaPeloNome.pesquisaPeloNome();

	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
