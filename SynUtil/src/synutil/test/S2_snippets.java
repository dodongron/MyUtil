/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package synutil.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.PoolConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;
import synutil.output.S1_to;

/**
 *
 * @author Dummy
 */
public class S2_snippets {

    public static class to_codes {

        public final int id;
        public final String name;
        public final String code;

        public to_codes(int id, String name, String code) {
            this.id = id;
            this.name = name;
            this.code = code;
        }
    }

    public static void add_data(to_codes to_codes) {
        try {
            Connection conn = PoolConnection.connect();
            String s0 = "insert into snippets.codes("
                    + "id"
                    + ",name"
                    + ",code"
                    + ")values("
                    + ":id"
                    + ",:name"
                    + ",:code"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setNumber("id", to_codes.id).
                    setString("name", to_codes.name).
                    setString("code", to_codes.code).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_to.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            PoolConnection.close();
        }
    }

    public static void edit_data(to_codes to_codes) {
        try {
            Connection conn = PoolConnection.connect();
            String s0 = "update snippets.codes set "
                    + "name= '" + to_codes.name + "'"
                    + ",code= '" + to_codes.code + "'"
                    + "where "
                    + " id ='" + to_codes.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_to.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            PoolConnection.close();
        }
    }

    public static void delete_data(to_codes to_codes) {
        try {
            Connection conn = PoolConnection.connect();
            String s0 = "delete from snippets.codes where "
                    + " id ='" + to_codes.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_to.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            PoolConnection.close();
        }
    }

    public static List<to_codes> ret_data(String search) {
        List<to_codes> datas = new ArrayList();

        try {
            Connection conn = PoolConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",name"
                    + ",code"
                    + " from snippets.codes "
                    + "where "
                    + "name like '%" + search + "%' ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String code = rs.getString(3);

                to_codes to = new to_codes(id, name, code);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            PoolConnection.close();
        }
    }
}
