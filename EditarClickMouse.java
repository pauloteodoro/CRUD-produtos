package principal;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import dao.ProdutoDAO;

@SuppressWarnings({ "serial", "unused" })
public class EditarClickMouse extends JDialog implements MouseListener, ActionListener {

	JLabel labelNome, labelValor, labelItem;
	JTextField entradaNome, entradaValor;
	JButton botaoCancelar, botaoEditar;
	TelaProduto telaProdutoEditar;
	int indice;

	public EditarClickMouse(JFrame frame, int x) {
		super(frame, true);
		indice = x;
		telaProdutoEditar = (TelaProduto) frame;
		setSize(frame.getWidth(), frame.getHeight() - 400);
		setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Editar produto");
		Init(frame, x);
		setVisible(true);
	}

	private void Init(JFrame frame, int x) {

		labelItem = new JLabel();
		labelItem.setBounds(20, 10, frame.getWidth() - 40, 45);

		labelItem.setText("Produto : ");
		add(labelItem);

		labelNome = new JLabel();
		labelNome.setBounds(labelItem.getX(), labelItem.getY() + 50, 100, 30);
		labelNome.setText("Item : ");
		add(labelNome);

		entradaNome = new JTextField();
		entradaNome.setBounds(labelNome.getX() + 50, labelNome.getY(), 200, 30);
		entradaNome.setFont(new Font("monospaced", Font.PLAIN, 15));
		add(entradaNome);

		labelValor = new JLabel();
		labelValor.setBounds(entradaNome.getWidth() + entradaNome.getX() + 30, entradaNome.getY(), 100, 30);
		labelValor.setText("Valor : ");
		add(labelValor);

		entradaValor = new JTextField();
		entradaValor.setBounds(labelValor.getWidth() + labelValor.getX() - 40, labelValor.getY(), 100, 30);
		entradaValor.setFont(new Font("monospaced", Font.PLAIN, 15));
		add(entradaValor);

		botaoCancelar = new JButton();
		botaoCancelar.setText("CANCELAR");
		botaoCancelar.setBounds(labelItem.getX() + 100, labelItem.getY() + 120, 100, 50);
		add(botaoCancelar);

		botaoEditar = new JButton();
		botaoEditar.setText("APLICAR");
		botaoEditar.setBounds(botaoCancelar.getX() + botaoCancelar.getWidth() + 35, botaoCancelar.getY(), 100, 50);
		add(botaoEditar);

		botaoCancelar.addActionListener(this);
		botaoEditar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent arg) {
		if (arg.getSource().equals(botaoCancelar)) {

			dispose();
		} else if (arg.getSource().equals(botaoEditar)) {

			int remover = JOptionPane.showConfirmDialog(null, "Editar Item confirma ?");

			if (remover == JOptionPane.YES_OPTION) {
				Produto proCadastrar = new Produto();
				proCadastrar.setNomeProduto(entradaNome.getText());
				proCadastrar.setPrecoProduto(Double.parseDouble(entradaValor.getText().replace(",", ".")));
				Random random = new Random();
				proCadastrar.setCodigoProduto(random.nextInt(1000));
				ProdutoDAO produtoDAO = new ProdutoDAO();
				produtoDAO.cadastrar(proCadastrar, indice);
				JOptionPane.showMessageDialog(null, " Editado com sucesso !");
			}
		}
		dispose();

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
