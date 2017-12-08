package JanelaPessoas;

import controlBD.PessoaDAO;
import controlBD.PessoaDAOJDBC;
import controlBD.ProjetoDAO;
import controlBD.ProjetoDAOJDBC;
import controlBD.TaskDAO;
import controlBD.TaskDAOJDBC;
import controlBD.TaskPessoaDAO;
import controlBD.TaskPessoaDAOJDBC;
import controlDashBoard.Pessoa;
import controlDashBoard.PessoasListModel;
import controlDashBoard.Project;
import controlDashBoard.Task;
import controleFuncionamento.SampleDataFuncionamento;
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

    private SampleDataFuncionamento sp;
    private List<Pessoa> pessoas;
    private JTextField nome;
    private JTextField email;
    private final JComboBox<String> opcoes = new JComboBox<>(new String[]{"Adicionar Pessoa", "Alterar Pessoa", "Remover Pessoa"});
    private final JPanel painel = new JPanel();

    public JanelaPessoas(List<Pessoa> pessoas, SampleDataFuncionamento sp) throws HeadlessException {
        super("Detalhes");
        this.sp = sp;
        addPessoa();
        this.pessoas = pessoas;
        add(opcoes, BorderLayout.NORTH);
        add(new JScrollPane(painel), BorderLayout.CENTER);
        opcoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                switch (opcoes.getSelectedIndex()) {
                    case 0: {
                        painel.removeAll();
                        painel.updateUI();
                        addPessoa();
                        break;
                    }
                    case 1: {
                        painel.removeAll();
                        painel.updateUI();
                        {
                            try {
                                alterarPessoa();
                            } catch (Exception ex) {
                                Logger.getLogger(JanelaPessoas.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                    }
                    case 2: {
                        painel.removeAll();
                        painel.updateUI();
                        try {
                            removerPessoa();
                        } catch (Exception ex) {
                            Logger.getLogger(JanelaPessoas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
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
        vertical.add(btnConfirmar, BorderLayout.CENTER);
        painel.add(vertical);

        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Pessoa pessoa;
                try {
                    if ("".equals(email.getText()) || "".equals(nome.getText())) {
                        JOptionPane.showMessageDialog(null, "Preencher todos os campos.", "Por favor preencha todos os campos.", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        pessoa = new Pessoa(sp.getDaoPessoa().varrerPessoa() + 1, nome.getText(), email.getText());
                        sp.getDaoPessoa().criar(pessoa);
                        pessoas.add(pessoa);
                        JOptionPane.showMessageDialog(null, "Foi adicionado uma pessoa.", "Pessoa criada com sucesso.", JOptionPane.INFORMATION_MESSAGE);
                        nome.setText("");
                        email.setText("");
                        nome.requestFocus();
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void alterarPessoa() throws Exception {
        JList<Pessoa> listaPessoas = new JList<>(new DefaultListModel<>());
        Box vertical = Box.createVerticalBox();
        Box horizontal1 = Box.createHorizontalBox();
        Box horizontal2 = Box.createHorizontalBox();
        JButton btnAlterar = new JButton("Alterar");
        nome = new JTextField(30);
        email = new JTextField(30);
        horizontal1.add(new JLabel("Nome: "));
        horizontal1.add(nome);
        horizontal2.add(new JLabel("E-mail: "));
        horizontal2.add(email);
        vertical.add(new JScrollPane(listaPessoas));
        vertical.add(horizontal1);
        vertical.add(horizontal2);
        vertical.add(btnAlterar);
        List<Pessoa> p = sp.getDaoPessoa().listarTodos();
        listaPessoas.setModel(new PessoasListModel(p));
        listaPessoas.setMinimumSize(new Dimension(100, 400));
        listaPessoas.setPreferredSize(new Dimension(100, 400));
        listaPessoas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        painel.add(vertical);
        btnAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Pessoa pe = listaPessoas.getSelectedValue();
                if (pe != null) {
                    try {
                        if ("".equals(email.getText()) || "".equals(nome.getText())) {
                            JOptionPane.showMessageDialog(null, "Preencher todos os campos.", "Por favor preencha todos os campos.", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            Pessoa p = listaPessoas.getSelectedValue();
                            p.setPesNome(nome.getText());
                            p.setPesEmail(email.getText());
                            sp.getDaoPessoa().alterar(p);
                            listaPessoas.updateUI();
                            JOptionPane.showMessageDialog(null, "Uma pessoa foi alterada.", "Pessoa alterada com sucesso.", JOptionPane.INFORMATION_MESSAGE);
                            nome.setText("");
                            email.setText("");
                            nome.requestFocus();
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Você deve selecionar a pessoa que deseja alterar.", "Selecione uma pessoa.", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    private void removerPessoa() throws Exception {
        JList<Pessoa> listaPessoas = new JList<>(new DefaultListModel<>());
        Box vertical = Box.createVerticalBox();
        JButton btnRemover = new JButton("Remover");
        TaskDAO daoTask = new TaskDAOJDBC();
        TaskPessoaDAO daoTaskPessoa = new TaskPessoaDAOJDBC();
        ProjetoDAO daoProjeto = new ProjetoDAOJDBC();
        listaPessoas.setModel(new PessoasListModel(pessoas));
        listaPessoas.setMinimumSize(new Dimension(350, 300));
        listaPessoas.setPreferredSize(new Dimension(350, 300));
        listaPessoas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        vertical.add(new JScrollPane(listaPessoas));
        vertical.add(btnRemover, BorderLayout.CENTER);
        painel.add(vertical);

        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Pessoa pe = listaPessoas.getSelectedValue();
                if (pe != null)
                {
                    try
                    {
                        Boolean presenca;
                        presenca = sp.getDaoTaskPessoa().presenca(pe);
                        if (presenca)
                        {
                            JOptionPane.showMessageDialog(null, "Essa pessoa não pode ser removida pois já está associada a uma tarefa.", "Impossível remover.", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                        {
                            sp.getDaoPessoa().excluir(pe);
                            sp.getPessoa().remove(pe);
                            listaPessoas.updateUI();
                            JOptionPane.showMessageDialog(null, "Uma pessoa foi removida.", "Pessoa removida com sucesso", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    catch (Exception ex)
                    {
                        Logger.getLogger(JanelaPessoas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Você deve selecionar a pessoa que deseja remover.", "Selecione uma pessoa.", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}
