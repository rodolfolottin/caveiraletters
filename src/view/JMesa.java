/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import model.Baralho;
import model.Carta;
import model.Jogador;
import model.Lance;
import model.Mesa;

/**
 *
 * @author rodolfolottin
 */
public class JMesa extends javax.swing.JFrame {

    protected AtorJogador atorJogador;
    protected static final int START = 1;
    protected static final int CONECTADO = 2;
    
    public JMesa() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.atualizarVisibilidadeTela(START);
        atorJogador = new AtorJogador(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMesa = new javax.swing.JPanel();
        jLabelBaralhoCompartilhado = new javax.swing.JLabel();
        jLabelLixoCompartilhado = new javax.swing.JLabel();
        jLabelAdversarioCompartilhado = new javax.swing.JLabel();
        jLabelJogadorCompartilhado = new javax.swing.JLabel();
        jPanelJogadorAdversario = new javax.swing.JPanel();
        jPanelJogadorAtual = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemConectar = new javax.swing.JMenuItem();
        jMenuItemIniciarPartida = new javax.swing.JMenuItem();
        jMenuItemDesconectar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(143, 0, 144));

        jPanelMesa.setBackground(new java.awt.Color(82, 10, 83));
        jPanelMesa.setForeground(new java.awt.Color(251, 239, 253));
        jPanelMesa.setToolTipText("");
        jPanelMesa.setPreferredSize(new java.awt.Dimension(800, 500));

        jLabelBaralhoCompartilhado.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                clicouBaralho(atorJogador.getController().getJogadorAtual());
            }
        });

        jPanelJogadorAdversario.setBackground(new java.awt.Color(82, 10, 83));
        jPanelJogadorAdversario.setLayout(new java.awt.GridLayout(1, 0));

        jPanelJogadorAtual.setBackground(new java.awt.Color(82, 10, 83));
        jPanelJogadorAtual.setLayout(new java.awt.GridLayout(1, 3, 5, 5));

        javax.swing.GroupLayout jPanelMesaLayout = new javax.swing.GroupLayout(jPanelMesa);
        jPanelMesa.setLayout(jPanelMesaLayout);
        jPanelMesaLayout.setHorizontalGroup(
            jPanelMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMesaLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabelBaralhoCompartilhado, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jLabelJogadorCompartilhado, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelAdversarioCompartilhado, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jLabelLixoCompartilhado, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelMesaLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanelMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelJogadorAdversario, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelJogadorAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanelMesaLayout.setVerticalGroup(
            jPanelMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMesaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelJogadorAdversario, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMesaLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabelAdversarioCompartilhado, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelMesaLayout.createSequentialGroup()
                        .addGroup(jPanelMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMesaLayout.createSequentialGroup()
                                .addGroup(jPanelMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelMesaLayout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(jLabelBaralhoCompartilhado, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelMesaLayout.createSequentialGroup()
                                        .addGap(67, 67, 67)
                                        .addComponent(jLabelLixoCompartilhado, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 53, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMesaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelJogadorCompartilhado, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)))
                .addComponent(jPanelJogadorAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu1.setText("Menu");

        jMenuItemConectar.setText("Conectar");
        jMenuItemConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConectarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemConectar);

        jMenuItemIniciarPartida.setText("Iniciar partida");
        jMenuItemIniciarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemIniciarPartidaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemIniciarPartida);

        jMenuItemDesconectar.setText("Desconectar");
        jMenuItemDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDesconectarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemDesconectar);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMesa, javax.swing.GroupLayout.DEFAULT_SIZE, 981, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMesa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConectarActionPerformed
        this.conectar();
    }//GEN-LAST:event_jMenuItemConectarActionPerformed

     public String getNomeJogador() {
        return JOptionPane.showInputDialog(this, "Digite seu nome: ", "jogador");
    }

    public String getNomeServidor() {
        return JOptionPane.showInputDialog(this, "Digite o servidor: ", "localhost");
    }

    public void conectar() {
        String nomeAtual =  this.getNomeJogador();
        String servidor = this.getNomeServidor();

        boolean conectou = atorJogador.conectar(nomeAtual, servidor);
        atorJogador.setJogadorAtual(new Jogador(nomeAtual));

        if (conectou) {
            this.adicionarTitulo(nomeAtual);
            this.atualizarVisibilidadeTela(CONECTADO);
            this.exibeMensagem("Conectado com sucesso!");
        } else {
            this.exibeMensagem("Não foi possível se conectar!");
        }
    }

    private void adicionarTitulo(String nome) {
        this.setTitle(nome);
    }
    
    public void exibeMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }
    
    public void atualizarVisibilidadeTela(int mode) {
        
        if (mode == START) {
            jMenuItemConectar.setEnabled(true);
            jMenuItemDesconectar.setEnabled(false);
            jMenuItemIniciarPartida.setEnabled(false);
        } else if (mode == CONECTADO) {
            jMenuItemDesconectar.setEnabled(true);
            jMenuItemIniciarPartida.setEnabled(true);
            jMenuItemConectar.setEnabled(false);
        }
    }
    
    public void recebeMesa(Mesa mesa) {
        if (mesa.getStatus().equals(Mesa.StatusMesa.INICAR_PARTIDA)) {
            this.iniciarPartida(mesa);
            this.exibeMensagem("Uma nova partida vai iniciar");
        } else if (mesa.getStatus().equals(Mesa.StatusMesa.INICIAR_RODADA)) {
            this.iniciarRodada(mesa);
        } else if (mesa.getStatus().equals(Mesa.StatusMesa.ENCERRAR_PARTIDA)) {
            String nomeVencedor = mesa.getJogadorVencedor().getNome();
            this.exibeMensagem("O jogador vencedor foi: " + nomeVencedor);
            this.limpaTodosCampos();   
            System.exit(0);
        }
    }
    
    private void iniciarPartida(Mesa mesa) {
        this.atualizaCamposInicioPartida(mesa);
    }
    
    private void iniciarRodada(Mesa mesa) {
        mesa.iniciarRodada(mesa.getJogadorDaVez());
    }
    
    private void atualizaCamposInicioPartida(Mesa mesa) {
        limparPanelsCartas();
        
        Jogador jogadorAtual = this.getJogadorAtualNaMesa(mesa);
        
        this.atualizaCartasJogadorAtual(jogadorAtual);
        this.atualizaCartasAdversarios(jogadorAtual);
        this.atualizaBaralho(mesa);
        this.atualizaCartaLixo();
        this.iniciarRodada(mesa);
    }
    
    public void limpaTodosCampos() {
        this.limparPanelsCartas();
    }
    
    //checar porque nao esta removendo os labels ao termino da partida
    private void limparPanelsCartas() {
        jPanelJogadorAtual.removeAll();
        jPanelJogadorAdversario.removeAll();
        jLabelBaralhoCompartilhado.setIcon(null);
        jLabelLixoCompartilhado.setIcon(null);
        jLabelJogadorCompartilhado.setIcon(null);
        jLabelAdversarioCompartilhado.setIcon(null);
        jPanelJogadorAdversario.validate();
        jPanelJogadorAtual.validate();
        this.validate();
    }
    
    private Jogador getJogadorAtualNaMesa(Mesa mesa) {
        Jogador jogador1 = mesa.getJogador1();
        Jogador jogador2 = mesa.getJogador2();
        
        if (this.atorJogador.getJogadorAtual().getNome().equals(jogador1.getNome())){
            return jogador1;
        } else {
            return jogador2;
        }
    }
    
    private void atualizaCartasJogadorAtual(Jogador joga) {
        jPanelJogadorAtual.removeAll();
        for (int i = 0; i < joga.getCartas().size(); i++) {
            JLabel jlabel = new JLabel(joga.getCartas().get(i).getImage());
            jlabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            jlabel.addMouseListener(new ClickCarta(joga.getCartas().get(i)));
            jPanelJogadorAtual.add(jlabel);
            jPanelJogadorAtual.validate();
        }
    }
    
    private void atualizaCartasAdversarios(Jogador jogadorAtual) {
        adicionaCartas(jPanelJogadorAdversario, true);
    }

    private void atualizaBaralho(Mesa mesa) {
        ImageIcon image = new javax.swing.ImageIcon(getClass().getResource("/images/fundo.png"));
        image.setImage(image.getImage().getScaledInstance(110, 160, 150));
        jLabelBaralhoCompartilhado.setIcon(image);
    }
    
    private void clicouBaralho(Jogador jogando){
        if (atorJogador.efetuarCompra(jogando)) {
            this.atualizaCartasJogadorAtual(jogando);
        }
    }
    
    private void atualizaCartaLixo() {
        ImageIcon image = new javax.swing.ImageIcon(getClass().getResource("/images/fundo.png"));
        image.setImage(image.getImage().getScaledInstance(90, 140, 150));
        jLabelLixoCompartilhado.setIcon(image);
    }
    
    private void adicionaCartas(JPanel pn, boolean adversario) {
        ImageIcon image = null;

        if (adversario) {
            image = new javax.swing.ImageIcon(getClass().getResource("/images/fundo.png"));
        } else {
            image = new javax.swing.ImageIcon(getClass().getResource("/images/fundo.png"));
        }
        image.setImage(image.getImage().getScaledInstance(100, 150, 150));
        JLabel label = new JLabel(image);
        pn.add(label);
        pn.validate();
    }
    
    public void recebeLance(Lance lance) {
        Jogador jogadorAtual = atorJogador.getJogadorAtual();
        if (lance.getJogador().getNome().equals(jogadorAtual.getNome())) {
            this.jLabelJogadorCompartilhado.setIcon(lance.getCarta().getImage());
        } else {
            this.jLabelAdversarioCompartilhado.setIcon(lance.getCarta().getImage());
            this.removeLabel(jPanelJogadorAdversario);
        }
    }
    
    private void removeLabel(JPanel panel) {
        try {
            panel.remove(0);
            panel.validate();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public String exibeDialogoAdivinho() {
        return JOptionPane.showInputDialog(this, "Digite seu chute: ", "");
    }
    
    private void jMenuItemIniciarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemIniciarPartidaActionPerformed
        atorJogador.iniciarPartida();
    }//GEN-LAST:event_jMenuItemIniciarPartidaActionPerformed

    private void jMenuItemDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDesconectarActionPerformed
        atorJogador.desconectar();
    }//GEN-LAST:event_jMenuItemDesconectarActionPerformed
    
    public void atualizarPanelJogador(Component comp) {
        jPanelJogadorAtual.remove(comp);
        jPanelJogadorAtual.validate();
    }
    
    public void clicouCarta(Carta carta, Component comp) {
        if (atorJogador.efetuarJogada(carta)) {
            this.atualizarPanelJogador(comp);
        }
    }
    
    public class ClickCarta extends MouseAdapter {

        private Carta carta;

        public ClickCarta(Carta carta) {
            this.carta = carta;
        }

        @Override
        public void mouseClicked(MouseEvent me) {

            clicouCarta(carta, me.getComponent());
        }
    };
    
    /**
     * @param args the command line arguments
     */
   
    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JMesa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelAdversarioCompartilhado;
    private javax.swing.JLabel jLabelBaralhoCompartilhado;
    private javax.swing.JLabel jLabelJogadorCompartilhado;
    private javax.swing.JLabel jLabelLixoCompartilhado;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemConectar;
    private javax.swing.JMenuItem jMenuItemDesconectar;
    private javax.swing.JMenuItem jMenuItemIniciarPartida;
    private javax.swing.JPanel jPanelJogadorAdversario;
    private javax.swing.JPanel jPanelJogadorAtual;
    private javax.swing.JPanel jPanelMesa;
    // End of variables declaration//GEN-END:variables
}
