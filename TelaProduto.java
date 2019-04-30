package principal;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.ProdutoDAO;

@SuppressWarnings({ "serial", "unused" })
public class TelaProduto extends JFrame implements ActionListener, KeyListener, MouseListener {

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
	int indice =-1;

	private void Inicializar() {
		barraPesquisa = new JTextField();
		barraPesquisa.setBounds(25, 25, getWidth() - 55, 45);
		barraPesquisa.setFont(new Font("monospaced", Font.PLAIN, 20));
		add(barraPesquisa);
		int remover;

		listaProdutos = new JList<Produto>();
		listaProdutos.setBounds(barraPesquisa.getX(), barraPesquisa.getY() + barraPesquisa.getHeight() + 20,
				barraPesquisa.getWidth(), 400);
		listaProdutos.setFont(new Font("monospaced", Font.PLAIN, 20));

		add(listaProdutos);

		botaoSair = new JButton();
		botaoSair.setText("SAIR");
		botaoSair.setBounds(listaProdutos.getX(), listaProdutos.getY() + listaProdutos.getHeight() + 40,
				listaProdutos.getWidth() / 4 - 7, barraPesquisa.getHeight() - 20);

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
		botaoEditar.addActionListener(this);
		barraPesquisa.addKeyListener(this);
		listaProdutos.addMouseListener(this);
		botaoRemover.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg) {
		if (arg.getSource().equals(botaoSair)) {
			dispose();
		} else if (arg.getSource().equals(botaoCadastrar)) {
			new TelaCadastroProduto(this);
			atualizarListaProdutos();
		} else if (arg.getSource().equals(botaoEditar)) {

			if (indice == -1) {
				JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado");
			} else {
				
				@SuppressWarnings("unused")
				EditarClickMouse editar = new EditarClickMouse(this, indice);
			}
			atualizarListaProdutos();

		} else if (arg.getSource().equals(botaoRemover)) {

			if (indice == -1) {
				JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado");
			} else {

				int remover = JOptionPane.showConfirmDialog(null, "Deletar Item ?");

				if (remover == JOptionPane.YES_NO_OPTION) {
					@SuppressWarnings("unused")
					Produto proCadastrar = new Produto();
					ProdutoDAO produtoDAO = new ProdutoDAO();
					produtoDAO.cadastrar(indice);
					JOptionPane.showMessageDialog(null, " Excluido com sucesso !");
				}
				

			}
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

	private void atualizarListaProdutos(String nome) {
		ArrayList<Produto> produtos = new ProdutoDAO().listarByNome(nome);
		DefaultListModel<Produto> modelo = new DefaultListModel<Produto>();
		for (Produto p : produtos) {
			modelo.addElement(p);
		}

		listaProdutos.setModel(modelo);
	}

	public void pesquisaPeloNome() {
		String texto = barraPesquisa.getText().trim();
		if (texto.length() == 0) {
			atualizarListaProdutos();
		} else {
			atualizarListaProdutos(texto);
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		pesquisaPeloNome();

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		pesquisaPeloNome();

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent arg0) {

		indice = listaProdutos.getSelectedIndex();

	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
