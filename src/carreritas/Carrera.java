/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreritas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author poter
 */
public class Carrera extends Thread {

    private JLabel eti;
    private frmauto p;

    public Carrera(JLabel eti, frmauto p) {
        this.eti = eti;
        this.p = p;
    }

    public void run() {
        int c1 = 0, c2 = 0;

        while (true) {
            try {
                sleep((int) (Math.random() * 100));
                c1 = p.getlbl1().getLocation().x;
                c2 = p.getlbl2().getLocation().x;
                if (c1 < p.getlbl_barrera().getLocation().x - 10 && c2 < p.getlbl_barrera().getLocation().x - 10) {
                    eti.setLocation(eti.getLocation().x + 10, eti.getLocation().y);
                    p.repaint();
                } else {
                    break;
                }
            } catch (InterruptedException e) {
            }

            if (eti.getLocation().x >= p.getlbl_barrera().getLocation().x - 10) {
                if (c1 > c2) {
                    JOptionPane.showMessageDialog(null, "Ha ganado el competidor numero 1");
                } else if (c2 > c1) {
                    JOptionPane.showMessageDialog(null, "Ha ganado el competidor numero 2");
                } else {
                    JOptionPane.showMessageDialog(null, "Ha sido un empate ");
                }
            }

        }
    }

}
