package JanelaPessoas;

import controlBD.PessoaDAO;
import controlBD.PessoaDAOJDBC;
import controlDashBoard.Pessoa;
import controlDashBoard.PessoasListModel;
import janelaControleProjeto.Dashboard;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class JanelaPessoas extends JFrame {

    private List<Pessoa> pessoas;
    private final PessoaDAO daoPessoa;

    private final JComboBox<String> opcoes = new JComboBox<>(new String[]{"Adicionar Pessoa", "Alterar Pessoa", "Remover Pessoa"});
    private final JPanel painel = new JPanel();

    public JanelaPessoas(List<Pessoa> pessoas) throws HeadlessException {
        super("Detalhes");
        addPessoa();
        daoPessoa = new PessoaDAOJDBC();
        this.pessoas = pessoas;
        add(opcoes, BorderLayout.NORTH);
        add(new JScrollPane(painel), BorderLayout.CENTER);
        opcoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                switch (opcoes.getSelectedIndex()) {
                    case 0:
                        painel.removeAll();
                        painel.updateUI();
                        addPessoa();
                        break;

                    case 1:
                        painel.removeAll();
                        painel.updateUI();
                        alterarPessoa();
                        break;

                    case 2:
                        painel.removeAll();
                        painel.updateUI();
                        removerPessoa();
                        break;
                }
            }
        });
    }

    private void addPessoa() {
        JButton btnConfirmar = new JButton("Confirmar");
        JTextField nome = new JTextField(30);
        JTextField email = new JTextField(30);

        Box vertical = Box.createVerticalBox();
        Box horizontal1 = Box.createHorizontalBox();
        Box horizontal2 = Box.createHorizontalBox();

        horizontal1.add(new JLabel("Nome: "));
        horizontal1.add(nome);
        horizontal2.add(new JLabel("E-mail: "));
        horizontal2.add(email);
        vertical.add(horizontal1);
        vertical.add(horizontal2);
        vertical.add(btnConfirmar, BorderLayout.WEST);
        painel.add(vertical);

        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Pessoa pessoa;
                try {
                    if ("".equals(email.getText()) || "".equals(nome.getText())) {
                        JOptionPane.showMessageDialog(null, "Preencher todos os campos.", "Por favor preencha todos os campos.", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        List<Pessoa> pessoas = daoPessoa.listarTodos();
                        pessoa = new Pessoa(pessoas.size() + 1, nome.getText(), email.getText());
                        daoPessoa.criar(pessoa);
                        pessoas.add(pessoa);
                        JOptionPane.showMessageDialog(null, "Foi adicionado uma pessoa.", "Pessoa criada com sucesso.", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void alterarPessoa() {
        JList<Pessoa> listaPessoas = new JList<>(new DefaultListModel<>());
        JButton btnAlterar = new JButton("Alterar");
        listaPessoas.setModel(new PessoasListModel(pessoas));
        listaPessoas.setMinimumSize(new Dimension(100,400));
        listaPessoas.setPreferredSize(new Dimension(100,400));
        listaPessoas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        painel.add(new JScrollPane(listaPessoas), BorderLayout.CENTER);
        painel.add(btnAlterar);
        
        btnAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            
            }
        });
    }

    private void removerPessoa() {
        JList<Pessoa> listaPessoas = new JList<>(new DefaultListModel<>());
        JButton btnRemover = new JButton("Remover");
        listaPessoas.setModel(new PessoasListModel(pessoas));
        listaPessoas.setMinimumSize(new Dimension(100,400));
        listaPessoas.setPreferredSize(new Dimension(100,400));
        listaPessoas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        painel.add(new JScrollPane(listaPessoas), BorderLayout.CENTER);
        painel.add(btnRemover);
        
        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) { 
            }
        });
    }
}
