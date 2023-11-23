import telas.Configuracao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class App {

    private JTextField pastaField;
    private JTextField sucessoField;
    private JTextField erroField;
    private JCheckBox rotaAutomaticaCheckBox;

    public static void main(String[] args) throws IOException {
        String diretorioRaiz = System.getProperty("user.dir");
        String nomeArquivo = "config.txt";
        File arquivo = new File(diretorioRaiz, nomeArquivo);

        if (arquivo.exists()) {
            System.out.println("O arquivo " + nomeArquivo + " já existe no diretório raiz.");
            BufferedReader reader = new BufferedReader(new FileReader(arquivo));
            String line;
            String pastaPrincipal = null;
            String pastaSucesso = null;
            String pastaErro = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Principal")){
                    pastaPrincipal = line.split("=")[1];
                }

                if (line.startsWith("Sucesso")){
                    pastaSucesso = line.split("=")[1];
                }

                if (line.startsWith("Erro")){
                    pastaErro = line.split("=")[1];
                }

                if (line.startsWith("Rota")) {
                    String rota = line.split("=")[1];
                    if (rota.equals("true")){
                        ManipulacaoArquivos.processarArquivosRota(pastaPrincipal, pastaSucesso, pastaErro);
                    }
                }
            }
        } else {
            SwingUtilities.invokeLater(() -> {
                App app = new App();
                app.createAndShowGUI();
            });
        }
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Front-End App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = createMenuBar();
        JPanel panel = createConfigurationsPanel();

        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, panel);

        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opções");

        JMenuItem sairItem = new JMenuItem("Sair");
        JMenuItem visivelItem = new JMenuItem("Visível");
        JMenuItem configuracoesItem = new JMenuItem("Configurações");

        sairItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        visivelItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Opção Visível selecionada");
            }
        });

        configuracoesItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showConfigurationsDialog();
            }
        });

        menu.add(sairItem);
        menu.add(visivelItem);
        menu.add(configuracoesItem);

        menuBar.add(menu);

        return menuBar;
    }

    private void showConfigurationsDialog() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Configurações");

        JPanel panel = createConfigurationsPanel();

        dialog.getContentPane().add(BorderLayout.CENTER, panel);

        dialog.setSize(300, 200);
        dialog.setVisible(true);
    }

    private JPanel createConfigurationsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 6, 15, 15));

        JLabel pastaLabel = new JLabel("Pasta:");
        pastaField = new JTextField();
        JLabel sucessoLabel = new JLabel("Sucesso:");
        sucessoField = new JTextField();
        JLabel erroLabel = new JLabel("Erro:");
        erroField = new JTextField();
        JLabel rotaAutomaticaLabel = new JLabel("Rota Automática:");
        rotaAutomaticaCheckBox = new JCheckBox();

        JButton saveButton = new JButton("Salvar");

        panel.add(pastaLabel);
        panel.add(pastaField);
        panel.add(sucessoLabel);
        panel.add(sucessoField);
        panel.add(erroLabel);
        panel.add(erroField);
        panel.add(rotaAutomaticaLabel);
        panel.add(rotaAutomaticaCheckBox);
        panel.add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String diretorioAtual = System.getProperty("user.dir");
                String pastaPrincipal = diretorioAtual + File.separator + pastaField.getText();
                String pastaSucesso = pastaPrincipal + File.separator + "Configs" + File.separator + sucessoField.getText();
                String pastaErro = pastaPrincipal + File.separator + "Configs" + File.separator + erroField.getText();
                boolean rotaAutomatica = rotaAutomaticaCheckBox.isSelected();

                new Configuracao(pastaPrincipal, pastaSucesso, pastaErro, rotaAutomatica);
                try {
                    ManipulacaoArquivos.criarDiretorios(diretorioAtual, pastaPrincipal, pastaSucesso, pastaErro, rotaAutomatica);
                } catch (Exception er) {
                    er.printStackTrace();
                    System.exit(1);
                }
            }
        });

        return panel;
    }
}
