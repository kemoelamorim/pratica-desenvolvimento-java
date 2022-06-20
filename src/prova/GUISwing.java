package prova;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUISwing implements ActionListener{
	JLabel l;
	JTextField tf;
	JTextField tf2;
	int num;
	
	RepositoryProdutos rp;
	
	public GUISwing(ArrayList<Produto> produtos) {
		JFrame frame = new JFrame("Estoque de Vendas");
		JButton buttonVenda = new JButton("Vender");
		JPanel p = new JPanel();
		tf = new JTextField(10);
		tf2 = new JTextField(10);
		for(Produto produto : produtos){
			l = new JLabel();
			
			l.setText("|"+ produto.codigo +"|"+ produto.nome + "|"+ produto.preco + "|"+ produto.estoque+"\n");

			p.add(l);
		}
		p.add(buttonVenda);
		tf.addActionListener(this);
		tf2.addActionListener(this);
		p.add(tf);
		p.add(tf2);
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buttonVenda.addActionListener(this);
		frame.add(p);
		frame.setVisible(true);
		frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("Vender")) {
			rp = new RepositoryProdutos();
			Produto produto = rp.updateQtdProduto(Integer.parseInt(tf.getText()), Integer.parseInt(tf2.getText()));
			
			System.out.println("Transferencia de vedas"+ produto.codigo);
			
		}else {
			
			
		}
	}
}
