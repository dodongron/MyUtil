/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package synutil.csv_insert;

/**
 *
 * @author i1
 */
public class Digit_increment {

    public static void main(String[] args) {
        int set = 0;
        for (int i = 0; set < 3000; i++) {
            set += 24;
            System.out.print(set+",");
        }
    }
}
