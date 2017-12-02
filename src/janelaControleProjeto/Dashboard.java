package janelaControleProjeto;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class Dashboard {

    public static void main(String[] args) {

        DashboardMain janela = new DashboardMain();
        janela.setSize(950, 400);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }

}
