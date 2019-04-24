package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;

import dao.ProdutoDAO;

public class TelaProduto extends JFrame implements ActionListener {

	public TelaProduto() {

		setSize(500, 650);
		setTitle("Produtos");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		Inicializar();
		setVisible(true);
	}

	JTextField barraPesquisa;
	JButton botaoSair, botaoCadastrar, botaoEditar, botaoRemover;
	JList<Produto> listaProdutos;

	private void Inicializar() {

		barraPesquisa = new JTextField();
		barraPesquisa.setBounds(25, 25, getWidth() - 55, 45);
		add(barraPesquisa);

		listaProdutos = new JList<Produto>();
		listaProdutos.setBounds(barraPesquisa.getX(), barraPesquisa.getY() + barraPesquisa.getHeight() + 20,
				barraPesquisa.getWidth(), 400);

		add(listaProdutos);

		botaoSair = new JButton();
		botaoSair.setText("SAIR");
		botaoSair.setBounds(listaProdutos.getX(), listaProdutos.getY() + listaProdutos.getHeight() + 40,
				listaProdutos.getWidth() / 4 - 7, barraPesquisa.getHeight());

		add(botaoSair);

		botaoEditar = new JButton();
		botaoEditar.setText("EDITAR");
		botaoEditar.setBounds(botaoSair.getX() + botaoSair.getWidth() + 10, botaoSair.getY(), botaoSair.getWidth(),
				botaoSair.getHeight());

		add(botaoEditar);

		botaoRemover = new JButton();
		botaoRemover.setText("EXCLUIR");
		botaoRemover.setBounds(botaoEditar.getX() + botaoEditar.getWidth() + 10, botaoEditar.getY(),
				botaoEditar.getWidth(), botaoEditar.getHeight());

		add(botaoRemover);

		botaoCadastrar = new JButton();
		botaoCadastrar.setText("CADASTRAR");
		botaoCadastrar.setBounds(botaoRemover.getX() + botaoRemover.getWidth() + 10, botaoRemover.getY(),
				botaoRemover.getWidth(), botaoRemover.getHeight());

		add(botaoCadastrar);

		botaoCadastrar.addActionListener(this);
		botaoSair.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent arg) {
		if (arg.getSource().equals(botaoSair)) {
			dispose();
		} else if (arg.getSource().equals(botaoCadastrar)) {
			new TelaCadastroProduto(this);
			atualizarListaProdutos();
		}

	}

	private void atualizarListaProdutos() {
		ArrayList<Produto> produtos = new ProdutoDAO().listar();
		DefaultListModel<Produto> modelo = new DefaultListModel<Produto>();
		for (Produto p : produtos) {
			modelo.addElement(p);
		}

		listaProdutos.setModel(modelo);
	}
	
	
	

}
