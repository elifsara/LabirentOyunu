
package com.mycompany.labirent;

import javax.swing.*;

public class Labirent {

    /* 0- Geçilebilir yol
       1- Duvar
       2- Başlangıç Noktası
       3- Hedef
    */
        public static void main(String[] args) {
            // Labirenti temsil eden örnek matris
            int[][] labirent = {
                {2, 0, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 1, 1, 0, 1, 0},
                {0, 0, 1, 0, 1, 0},
                {1, 0, 1, 0, 0, 3},
            };
                    // Pencereyi oluştur
        JFrame pencere = new JFrame("Labirent Oyunu");
        pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // LabirentPanel'i pencereye ekle
        LabirentOyunu labirentPanel = new LabirentOyunu(labirent);
        pencere.add(labirentPanel);
        
        // Pencereyi uygun boyuta getir ve görünür yap
        pencere.pack();
        pencere.setLocationRelativeTo(null); // Ortaya yerleştir
        pencere.setVisible(true);
        
        labirentPanel.Solution();

    }
      
}
