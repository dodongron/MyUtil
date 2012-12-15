/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package synutil.test;

/**
 *
 * @author i1
 */
public class S1_test {

    public static class to_assembly {

        public final int id;
        public final int prod_num;
        public final String description;
        public final double price;
        public final double product_qty;
        public final String ref_num;
        public final int status;

        public to_assembly(int id, int prod_num, String description, double price, double product_qty, String ref_num, int status) {
            this.id = id;
            this.prod_num = prod_num;
            this.description = description;
            this.price = price;
            this.product_qty = product_qty;
            this.ref_num = ref_num;
            this.status = status;
        }
    }
    
  
}
