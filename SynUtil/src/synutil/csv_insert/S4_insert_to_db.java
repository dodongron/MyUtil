/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package synutil.csv_insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.PoolConnection;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author i1
 */
public class S4_insert_to_db {

    public static class to_parishioners_1 {

        public final int id;
        public final int ref_id;
        public final String fname;
        public final String mi;
        public final String lname;
        public final String date_of_baptism;
        public final String date_of_birth;
        public final String place_of_birth;
        public final String address1;
        public final String address2;
        public final String city;
        public final String states;
        public final String zip_code;
        public final String father;
        public final String mother;
        public final int is_baptized;
        public final int is_comm;
        public final int is_confirm;
        public final int is_married;
        public final int is_2nd_married;
        public final int is_prof_faith;
        public final int is_acceptance;
        public final int is_death;
        public final String date_added;
        public final int gender;
        public final String bapt_place;
        public final String b_date;
        public final String b_book_no;
        public final int b_page_no;
        public final int b_index_no;
        public final String c_date;
        public final String c_book_no;
        public final int c_page_no;
        public final int c_index_no;
        public final String m_date;
        public final String m_book_no;
        public final int m_page_no;
        public final int m_index_no;
        public final String f_date;
        public final String f_book_no;
        public final int f_page_no;
        public final int f_index_no;

        public to_parishioners_1(int id, int ref_id, String fname, String mi, String lname, String date_of_baptism, String date_of_birth, String place_of_birth, String address1, String address2, String city, String states, String zip_code, String father, String mother, int is_baptized, int is_comm, int is_confirm, int is_married, int is_2nd_married, int is_prof_faith, int is_acceptance, int is_death, String date_added, int gender, String bapt_place, String b_date, String b_book_no, int b_page_no, int b_index_no, String c_date, String c_book_no, int c_page_no, int c_index_no, String m_date, String m_book_no, int m_page_no, int m_index_no, String f_date, String f_book_no, int f_page_no, int f_index_no) {
            this.id = id;
            this.ref_id = ref_id;
            this.fname = fname;
            this.mi = mi;
            this.lname = lname;
            this.date_of_baptism = date_of_baptism;
            this.date_of_birth = date_of_birth;
            this.place_of_birth = place_of_birth;
            this.address1 = address1;
            this.address2 = address2;
            this.city = city;
            this.states = states;
            this.zip_code = zip_code;
            this.father = father;
            this.mother = mother;
            this.is_baptized = is_baptized;
            this.is_comm = is_comm;
            this.is_confirm = is_confirm;
            this.is_married = is_married;
            this.is_2nd_married = is_2nd_married;
            this.is_prof_faith = is_prof_faith;
            this.is_acceptance = is_acceptance;
            this.is_death = is_death;
            this.date_added = date_added;
            this.gender = gender;
            this.bapt_place = bapt_place;
            this.b_date = b_date;
            this.b_book_no = b_book_no;
            this.b_page_no = b_page_no;
            this.b_index_no = b_index_no;
            this.c_date = c_date;
            this.c_book_no = c_book_no;
            this.c_page_no = c_page_no;
            this.c_index_no = c_index_no;
            this.m_date = m_date;
            this.m_book_no = m_book_no;
            this.m_page_no = m_page_no;
            this.m_index_no = m_index_no;
            this.f_date = f_date;
            this.f_book_no = f_book_no;
            this.f_page_no = f_page_no;
            this.f_index_no = f_index_no;
        }
    }

    public static class to_baptism2 {

        public final int id;
        public final int ref_no;
        public final String fname;
        public final String mi;
        public final String lname;
        public final String date_of_birth;
        public final String place_of_birth;
        public final String father;
        public final String mother;
        public final String godfather;
        public final String p_godfather;
        public final String godmother;
        public final String p_godmother;
        public final String presider;
        public final String bapt_date;
        public final String bapt_time;
        public final String bapt_church;
        public final String priest;
        public final String book_no;
        public final int page_no;
        public final String f_comm_date;
        public final String f_comm_church;
        public final String f_conf_date;
        public final String f_conf_church;
        public final int is_diaconate;
        public final String diconate_date;
        public final int is_religious_prof;
        public final String religious_prof_date;
        public final String remarks;
        public final int status;
        public final String years;
        public final int num;

        public to_baptism2(int id, int ref_no, String fname, String mi, String lname, String date_of_birth, String place_of_birth, String father, String mother, String godfather, String p_godfather, String godmother, String p_godmother, String presider, String bapt_date, String bapt_time, String bapt_church, String priest, String book_no, int page_no, String f_comm_date, String f_comm_church, String f_conf_date, String f_conf_church, int is_diaconate, String diconate_date, int is_religious_prof, String religious_prof_date, String remarks, int status, String years, int num) {
            this.id = id;
            this.ref_no = ref_no;
            this.fname = fname;
            this.mi = mi;
            this.lname = lname;
            this.date_of_birth = date_of_birth;
            this.place_of_birth = place_of_birth;
            this.father = father;
            this.mother = mother;
            this.godfather = godfather;
            this.p_godfather = p_godfather;
            this.godmother = godmother;
            this.p_godmother = p_godmother;
            this.presider = presider;
            this.bapt_date = bapt_date;
            this.bapt_time = bapt_time;
            this.bapt_church = bapt_church;
            this.priest = priest;
            this.book_no = book_no;
            this.page_no = page_no;
            this.f_comm_date = f_comm_date;
            this.f_comm_church = f_comm_church;
            this.f_conf_date = f_conf_date;
            this.f_conf_church = f_conf_church;
            this.is_diaconate = is_diaconate;
            this.diconate_date = diconate_date;
            this.is_religious_prof = is_religious_prof;
            this.religious_prof_date = religious_prof_date;
            this.remarks = remarks;
            this.status = status;
            this.years = years;
            this.num = num;
        }
    }

    public static class to_baptism2_sponsors {

        public final int id;
        public final int ref_no;
        public final String sponsor;

        public to_baptism2_sponsors(int id, int ref_no, String sponsor) {
            this.id = id;
            this.ref_no = ref_no;
            this.sponsor = sponsor;
        }
    }

    public static void add_data(List<to_parishioners_1> to_parishioners_11, List<to_baptism2> to_baptism21, List<to_baptism2_sponsors> to_baptism2_sponsors1) {
        try {
            Connection conn = PoolConnection.connect();

            // <editor-fold defaultstate="collapsed" desc="Add Parishioner">
            int i = 1;
            for (to_parishioners_1 to_parishioners_1 : to_parishioners_11) {
                String s0 = "insert into db_bulletin.parishioners_1("
                            + "id"
                            + ",ref_id"
                            + ",fname"
                            + ",mi"
                            + ",lname"
                            + ",date_of_baptism"
                            + ",date_of_birth"
                            + ",place_of_birth"
                            + ",address1"
                            + ",address2"
                            + ",city"
                            + ",states"
                            + ",zip_code"
                            + ",father"
                            + ",mother"
                            + ",is_baptized"
                            + ",is_comm"
                            + ",is_confirm"
                            + ",is_married"
                            + ",is_2nd_married"
                            + ",is_prof_faith"
                            + ",is_acceptance"
                            + ",is_death"
                            + ",date_added"
                            + ",gender"
                            + ",bapt_place"
                            + ",b_date"
                            + ",b_book_no"
                            + ",b_page_no"
                            + ",b_index_no"
                            + ",c_date"
                            + ",c_book_no"
                            + ",c_page_no"
                            + ",c_index_no"
                            + ",m_date"
                            + ",m_book_no"
                            + ",m_page_no"
                            + ",m_index_no"
                            + ",f_date"
                            + ",f_book_no"
                            + ",f_page_no"
                            + ",f_index_no"
                            + ")values("
                            + ":id"
                            + ",:ref_id"
                            + ",:fname"
                            + ",:mi"
                            + ",:lname"
                            + ",:date_of_baptism"
                            + ",:date_of_birth"
                            + ",:place_of_birth"
                            + ",:address1"
                            + ",:address2"
                            + ",:city"
                            + ",:states"
                            + ",:zip_code"
                            + ",:father"
                            + ",:mother"
                            + ",:is_baptized"
                            + ",:is_comm"
                            + ",:is_confirm"
                            + ",:is_married"
                            + ",:is_2nd_married"
                            + ",:is_prof_faith"
                            + ",:is_acceptance"
                            + ",:is_death"
                            + ",:date_added"
                            + ",:gender"
                            + ",:bapt_place"
                            + ",:b_date"
                            + ",:b_book_no"
                            + ",:b_page_no"
                            + ",:b_index_no"
                            + ",:c_date"
                            + ",:c_book_no"
                            + ",:c_page_no"
                            + ",:c_index_no"
                            + ",:m_date"
                            + ",:m_book_no"
                            + ",:m_page_no"
                            + ",:m_index_no"
                            + ",:f_date"
                            + ",:f_book_no"
                            + ",:f_page_no"
                            + ",:f_index_no"
                            + ")";

                s0 = SqlStringUtil.parse(s0).setNumber("id", to_parishioners_1.id).setNumber("ref_id", to_parishioners_1.ref_id).setString("fname", to_parishioners_1.fname).setString("mi", to_parishioners_1.mi).setString("lname", to_parishioners_1.lname).setString("date_of_baptism", to_parishioners_1.date_of_baptism).setString("date_of_birth", to_parishioners_1.date_of_birth).setString("place_of_birth", to_parishioners_1.place_of_birth).setString("address1", to_parishioners_1.address1).setString("address2", to_parishioners_1.address2).setString("city", to_parishioners_1.city).setString("states", to_parishioners_1.states).setString("zip_code", to_parishioners_1.zip_code).setString("father", to_parishioners_1.father).setString("mother", to_parishioners_1.mother).setNumber("is_baptized", to_parishioners_1.is_baptized).setNumber("is_comm", to_parishioners_1.is_comm).setNumber("is_confirm", to_parishioners_1.is_confirm).setNumber("is_married", to_parishioners_1.is_married).setNumber("is_2nd_married", to_parishioners_1.is_2nd_married).setNumber("is_prof_faith", to_parishioners_1.is_prof_faith).setNumber("is_acceptance", to_parishioners_1.is_acceptance).setNumber("is_death", to_parishioners_1.is_death).setString("date_added", to_parishioners_1.date_added).setNumber("gender", to_parishioners_1.gender).setString("bapt_place", to_parishioners_1.bapt_place).setString("b_date", to_parishioners_1.b_date).setString("b_book_no", to_parishioners_1.b_book_no).setNumber("b_page_no", to_parishioners_1.b_page_no).setNumber("b_index_no", to_parishioners_1.b_index_no).setString("c_date", to_parishioners_1.c_date).setString("c_book_no", to_parishioners_1.c_book_no).setNumber("c_page_no", to_parishioners_1.c_page_no).setNumber("c_index_no", to_parishioners_1.c_index_no).setString("m_date", to_parishioners_1.m_date).setString("m_book_no", to_parishioners_1.m_book_no).setNumber("m_page_no", to_parishioners_1.m_page_no).setNumber("m_index_no", to_parishioners_1.m_index_no).setString("f_date", to_parishioners_1.f_date).setString("f_book_no", to_parishioners_1.f_book_no).setNumber("f_page_no", to_parishioners_1.f_page_no).setNumber("f_index_no", to_parishioners_1.f_index_no).ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();

                Lg.s(S4_insert_to_db.class, "Successfully Added Parishioner " + to_parishioners_1.id + " -  " + i);
                i++;
            }
            // </editor-fold>

            // <editor-fold defaultstate="collapsed" desc="Add Baptism">


            int ii = 1;
            for (to_baptism2 to_baptism2 : to_baptism21) {
                String s0 = "insert into db_bulletin.baptism2("
                            + "id"
                            + ",ref_no"
                            + ",fname"
                            + ",mi"
                            + ",lname"
                            + ",date_of_birth"
                            + ",place_of_birth"
                            + ",father"
                            + ",mother"
                            + ",godfather"
                            + ",p_godfather"
                            + ",godmother"
                            + ",p_godmother"
                            + ",presider"
                            + ",bapt_date"
                            + ",bapt_time"
                            + ",bapt_church"
                            + ",priest"
                            + ",book_no"
                            + ",page_no"
                            + ",f_comm_date"
                            + ",f_comm_church"
                            + ",f_conf_date"
                            + ",f_conf_church"
                            + ",is_diaconate"
                            + ",diconate_date"
                            + ",is_religious_prof"
                            + ",religious_prof_date"
                            + ",remarks"
                            + ",status"
                            + ",years"
                            + ",num"
                            + ")values("
                            + ":id"
                            + ",:ref_no"
                            + ",:fname"
                            + ",:mi"
                            + ",:lname"
                            + ",:date_of_birth"
                            + ",:place_of_birth"
                            + ",:father"
                            + ",:mother"
                            + ",:godfather"
                            + ",:p_godfather"
                            + ",:godmother"
                            + ",:p_godmother"
                            + ",:presider"
                            + ",:bapt_date"
                            + ",:bapt_time"
                            + ",:bapt_church"
                            + ",:priest"
                            + ",:book_no"
                            + ",:page_no"
                            + ",:f_comm_date"
                            + ",:f_comm_church"
                            + ",:f_conf_date"
                            + ",:f_conf_church"
                            + ",:is_diaconate"
                            + ",:diconate_date"
                            + ",:is_religious_prof"
                            + ",:religious_prof_date"
                            + ",:remarks"
                            + ",:status"
                            + ",:years"
                            + ",:num"
                            + ")";

                s0 = SqlStringUtil.parse(s0).setNumber("id", to_baptism2.id).setNumber("ref_no", to_baptism2.ref_no).setString("fname", to_baptism2.fname).setString("mi", to_baptism2.mi).setString("lname", to_baptism2.lname).setString("date_of_birth", to_baptism2.date_of_birth).setString("place_of_birth", to_baptism2.place_of_birth).setString("father", to_baptism2.father).setString("mother", to_baptism2.mother).setString("godfather", to_baptism2.godfather).setString("p_godfather", to_baptism2.p_godfather).setString("godmother", to_baptism2.godmother).setString("p_godmother", to_baptism2.p_godmother).setString("presider", to_baptism2.presider).setString("bapt_date", to_baptism2.bapt_date).setString("bapt_time", to_baptism2.bapt_time).setString("bapt_church", to_baptism2.bapt_church).setString("priest", to_baptism2.priest).setString("book_no", to_baptism2.book_no).setNumber("page_no", to_baptism2.page_no).setString("f_comm_date", to_baptism2.f_comm_date).setString("f_comm_church", to_baptism2.f_comm_church).setString("f_conf_date", to_baptism2.f_conf_date).setString("f_conf_church", to_baptism2.f_conf_church).setNumber("is_diaconate", to_baptism2.is_diaconate).setString("diconate_date", to_baptism2.diconate_date).setNumber("is_religious_prof", to_baptism2.is_religious_prof).setString("religious_prof_date", to_baptism2.religious_prof_date).setString("remarks", to_baptism2.remarks).setNumber("status", to_baptism2.status).setString("years", to_baptism2.years).setNumber("num", to_baptism2.num).ok();
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S4_insert_to_db.class, "Successfully Added baptism2 " + to_baptism2.id + " -  " + ii);
                ii++;

            }
            // </editor-fold>

            // <editor-fold defaultstate="collapsed" desc="Add Sponsors">
            int iii = 1;
            for (to_baptism2_sponsors to_baptism2_sponsors : to_baptism2_sponsors1) {
                String s0 = "insert into db_bulletin.baptism2_sponsors("
                            + "id"
                            + ",ref_no"
                            + ",sponsor"
                            + ")values("
                            + ":id"
                            + ",:ref_no"
                            + ",:sponsor"
                            + ")";

                s0 = SqlStringUtil.parse(s0).setNumber("id", to_baptism2_sponsors.id).setNumber("ref_no", to_baptism2_sponsors.ref_no).setString("sponsor", to_baptism2_sponsors.sponsor).ok();
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S4_insert_to_db.class, "Successfully db_baptism_sponsors " + to_baptism2_sponsors.id + " -  " + iii);
                iii++;
            }

            // </editor-fold>


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            PoolConnection.close();
        }
    }

    public static String increment_id_parishioners() {
        String id = "0";
        try {
            Connection conn = PoolConnection.connect();
            String s0 = "select max(id) from db_bulletin.parishioners_1";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
            }
            id = ReceiptIncrementor.increment(id);
            return id;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            PoolConnection.close();
        }
    }

    public static String increment_id_baptism2() {
        String id = "0";
        try {
            Connection conn = PoolConnection.connect();
            String s0 = "select max(id) from db_bulletin.baptism2";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
            }
            id = ReceiptIncrementor.increment(id);
            return id;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            PoolConnection.close();
        }
    }

    public static String increment_id_sponsors() {
        String id = "0";
        try {
            Connection conn = PoolConnection.connect();
            String s0 = "select max(id) from db_bulletin.baptism2_sponsors";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
            }
            id = ReceiptIncrementor.increment(id);
            return id;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            PoolConnection.close();
        }
    }
}
