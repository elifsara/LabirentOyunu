package com.mycompany.labirent;
import javax.swing.*;
import java.awt.*;

public class LabirentOyunu extends JPanel{
        /* 0- Geçilebilir yol
       1- Duvar
       2- Başlangıç Noktası
       3- Hedef
       4- ziyaret edildi  
    */
    private int[][] labirent;
    //Stack s=new Stack(labirent.length);
    private final int hucreBoyutu = 30;  // Her hücrenin boyutu (örneğin 30x30 piksel)
    Stack s;
    public LabirentOyunu(int[][] labirent) {
        this.labirent = labirent;
        this.s = new Stack(labirent.length * labirent[0].length);
        // Panelin boyutunu labirent boyutuna göre ayarlayın
        setPreferredSize(new Dimension(labirent[0].length * hucreBoyutu, labirent.length * hucreBoyutu));
    }
    

    //right, left, up, down
    void right(int i , int j){
        if(labirent[i][j+1]!=3)
           labirent[i][j+1]=4;
     
    }
    void down(int i, int j){
        if(labirent[i + 1][j] != 3)
            labirent[i+1][j]=4;
    }
    void left(int i, int j){
        if(labirent[i][j - 1] != 3)
            labirent[i][j-1]=4;
    }
    void up(int i, int j){
        if(labirent[i - 1][j] != 3)
         labirent[i-1][j]=4;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Labirenti çizmek için iki döngü kullanarak tüm hücreleri dolaşın
        for (int i = 0; i < labirent.length; i++) {
            for (int j = 0; j < labirent[i].length; j++) {
                // Her hücreyi renklendirin
                if (labirent[i][j] == 0) {          // Yol
                    g.setColor(Color.WHITE);
                } else if (labirent[i][j] == 1) {   // Duvar
                    g.setColor(Color.BLACK);
                } else if (labirent[i][j] == 2) {   // Başlangıç
                    g.setColor(Color.GREEN);
                } else if (labirent[i][j] == 3) {   // Hedef
                    g.setColor(Color.RED);
                }else if(labirent[i][j]==4) {
                    g.setColor(Color.yellow);  //ziyaret edilenler
                }
                
                // Hücreyi çiz
                g.fillRect(j * hucreBoyutu, i * hucreBoyutu, hucreBoyutu, hucreBoyutu);
                
                // Hücrelerin arasına çizgi çekerek ızgarayı belirgin hale getirin
                g.setColor(Color.GRAY);
                g.drawRect(j * hucreBoyutu, i * hucreBoyutu, hucreBoyutu, hucreBoyutu);
            }
        }

  }
    public void Solution(){
    
    // Başlangıç noktasını bul ve labirenti çöz
    int i = 0, j = 0;
    s.push(new int[]{i,j});
    Boolean yolunSonu =false;
    while (labirent[i][j] != 3) {
        if (j + 1 < labirent[i].length && (labirent[i][j + 1] == 0 || labirent[i][j + 1] == 3)) {
            right(i, j);
            j++;
            s.push(new int[]{i, j});
        } else if (i + 1 < labirent.length && (labirent[i + 1][j] == 0||labirent[i + 1][j] == 3)) {
            down(i, j);
            i++;
            s.push(new int[]{i, j});
        } else if (j - 1 >= 0 && (labirent[i][j - 1] == 0 ||labirent[i][j - 1] == 3)) {
            left(i, j);
            j--;
            s.push(new int[]{i, j});
        } else if (i - 1 >= 0 && (labirent[i - 1][j] == 0 || labirent[i - 1][j] == 3)) {
            up(i, j);
            i--;
            s.push(new int[]{i, j});
        } else {
            
            yolunSonu=true;
        }
        if(yolunSonu){
            if(!s.bosmu()){
                s.pop();
            int[]tmp =s.peek();
            i=tmp[0];
            j=tmp[1];
            yolunSonu=false;
        }
    }
    repaint();
    try {
        Thread.sleep(100); // 100 milisaniye gecikme
    } catch (InterruptedException e) {
        e.printStackTrace();
        }
        
    }
}

}
