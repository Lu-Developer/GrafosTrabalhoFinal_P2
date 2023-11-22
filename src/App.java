import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {

    private JTextField pastaField;
    private JCheckBox sucessoCheckBox;
    private JCheckBox rotaAutomaticaCheckBox;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            App app = new App();
            app.createAndShowGUI();
        });
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
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel pastaLabel = new JLabel("Pasta:");
        pastaField = new JTextField();
        JLabel sucessoLabel = new JLabel("Sucesso:");
        sucessoCheckBox = new JCheckBox();
        JLabel rotaAutomaticaLabel = new JLabel("Rota Automática:");
        rotaAutomaticaCheckBox = new JCheckBox();

        panel.add(pastaLabel);
        panel.add(pastaField);
        panel.add(sucessoLabel);
        panel.add(sucessoCheckBox);
        panel.add(rotaAutomaticaLabel);
        panel.add(rotaAutomaticaCheckBox);

        return panel;
    }
}
