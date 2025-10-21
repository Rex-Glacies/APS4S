package Views.telasaps;

import  Views.TelasAppsJpanel.telas.PainelMain;

public class TelasAps {
    public static void main(String[] args) {
        // Garante que a interface Swing será criada de forma segura
        javax.swing.SwingUtilities.invokeLater(() -> {
            new PainelMain(); // Abre a tela PainelMain
        });
    }
}
