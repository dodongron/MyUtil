/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package synutil.output;

import java.util.List;
import synutil.pnl.Dlg_where2;
import synutil.pnl.S1_set;

/**
 *
 * @author Dummy
 */
public class S1_to {

    public static String set_to(List<S1_set.to_col> to, String database, String table_name) {

        String parameter = "";

        String text = "public static class to_" + table_name + "{\n\n";
        int i = 0;
        for (S1_set.to_col t : to) {
            String type = t.type;
            if (type.equalsIgnoreCase("integer") || type.equalsIgnoreCase("tinyint")) {
                type = "int";
            } else if (type.equalsIgnoreCase("double")) {
                type = "double";
            } else {
                type = "String";
            }

            text = text + "   public final " + type + " " + t.name + ";\n";
            if (i == to.size() - 1) {
                parameter = parameter + " " + type + " " + t.name + "";
            } else {
                parameter = parameter + " " + type + " " + t.name + ",";
            }


//            System.out.println(t.name+ " - "+t.type);\i
            i++;
        }

        text = text + "\n";
        text = text + "public to_" + table_name + "(" + parameter + ")" + "{\n";
        for (S1_set.to_col t : to) {

            String type = t.type;
            if (type.equalsIgnoreCase("integer") || type.equalsIgnoreCase("tinyint")) {
                type = "int";
            } else if (type.equalsIgnoreCase("double")) {
                type = "double";
            } else {
                type = "String";
            }
            if (t.check == true) {
                text = text + "   this." + t.name + " = " + t.name + ";\n";
            }

        }

        text = text + "     }\n";
        text = text + "}\n";

        return text;
    }

    public static String insert(List<S1_set.to_col> to, String database, String table_name) {

        String parameter = "";
        String text = "";
        text = text + "public static void  add_data( to_" + table_name + " to_" + table_name + "){ \n";

        text = text + "try {\n Connection conn = PoolConnection.connect();\n";
        text = text + "String s0=\"insert into \"+MyDB.getNames()+\"." + table_name + "(\"\n";

        String col_names = "";
        String col_sql = "";
        int i = 0;
        for (S1_set.to_col t : to) {

            if (i == 0) {
                col_names = "   +\"" + col_names + "" + t.name + "\"\n";
                col_sql = "   +\"" + col_sql + ":" + t.name + "\"\n";
            }
            if (i > 0) {
//                      col_names = "+\""+col_names + "," + t.name + "\"\n";
                col_names = col_names + "   +\"," + t.name + "\"\n";
                col_sql = col_sql + "   +\",:" + t.name + "\"\n";
            }

//            System.out.println(t.check);
            i++;
        }
        text = text + col_names + "   +\")values(\"\n";
        text = text + col_sql + "   +\")\";\n";

        text = text + "\n";
        text = text + "  s0= SqlStringUtil.parse(s0)" + "\n";
        int o = 0;
        for (S1_set.to_col t : to) {
            String type = t.type;
            if (type.equalsIgnoreCase("integer") || type.equalsIgnoreCase("tinyint") || type.equalsIgnoreCase("double")) {
                type = "Number";
            } else {
                type = "String";
            }
            if (t.check == true) {
                if (o == 0) {
                    text = text + "     .set" + type + "(\"" + t.name + "\",to_" + table_name + "." + t.name + ")\n";
                } else {
                    text = text + "     .set" + type + "(\"," + t.name + "\",to_" + table_name + "." + t.name + ")\n";
                }

            }

        }


        text = text + "     .ok();\n";
        text = text + "\n";

        text = text + "  PreparedStatement stmt = conn.prepareStatement(s0);" + "\n";
        text = text + "  stmt.execute();" + "\n";
        text = text + "   Lg.s(S1_to.class, \"Successfully Added\");" + "\n";
//        text = text + "}\n";
//        text = text + "return datas;\n";
        text = text + "} catch (Exception e) { \n  throw new RuntimeException(e);\n";
        text = text + " } finally { \n  PoolConnection.close();\n  }\n  }\n";
        return text;

//        SqlStringUtil.parse(col_sql)

    }

    public static String edit(List<S1_set.to_col> to, String database, String table_name, List<Dlg_where2.to_where> where) {

        String parameter = "";
        String text = "";
        text = text + "public static void  edit_data( to_" + table_name + " to_" + table_name + "){ \n";

        text = text + "try {\n Connection conn = PoolConnection.connect();\n";
        text = text + "String s0=\"update \"+MyDB.getNames()+\"." + table_name + " set \"\n";

        String col_names = "";
        int i = 0;
        for (S1_set.to_col t : to) {
            if (i == 0) {
                col_names = "   +\"" + col_names + "" + t.name + "= '\"+ to_" + table_name + "." + t.name + "+\"'\"\n";
            }
            if (i > 0) {
                col_names = col_names + "   +\"" + "," + t.name + "= '\"+to_" + table_name + "." + t.name + "+\"'\"\n";
            }
            i++;
//            System.out.println(t.check);

        }
        text = text + col_names + "   +\"where \"\n";
        String wheres = "";
        for (Dlg_where2.to_where str : where) {
            wheres = wheres + str.output + "\n";
        }
        text = text + wheres + "";
        text = text + "   +\" \";\n";
        text = text + "\n";

        text = text + "  PreparedStatement stmt = conn.prepareStatement(s0);" + "\n";
        text = text + "  stmt.execute();" + "\n";
        text = text + "   Lg.s(S1_to.class, \"Successfully Updated\");" + "\n";

        text = text + "} catch (Exception e) { \n  throw new RuntimeException(e);\n";
        text = text + " } finally { \n  PoolConnection.close();\n  }\n  }\n";
        return text;

//        SqlStringUtil.parse(col_sql)

    }

    public static String delete(List<S1_set.to_col> to, String database, String table_name, List<Dlg_where2.to_where> where) {

        String parameter = "";
        String text = "";
        text = text + "public static void  delete_data( to_" + table_name + " to_" + table_name + "){ \n";

        text = text + "try {\n Connection conn = PoolConnection.connect();\n";
        text = text + "String s0=\"delete from \"+MyDB.getNames()+\"." + table_name + " where \"\n";

//        String col_names = "";
//        int i = 0;
//        for (S1_set.to_col t : to) {
//            if (t.check == true) {
//                if (i == 0) {
//                    col_names = "   +\"" + col_names + "" + t.name + "= '\"+ to_" + table_name + "." + t.name + "+\"'  \"\n";
//                }
//                if (i > 0) {
////                      col_names = "+\""+col_names + "," + t.name + "\"\n";
//                    col_names = col_names + "   +\"" + " and " + t.name + "= '\"+to_" + table_name + "." + t.name + "+\"' \"\n";
//
//                }
//            }
////            System.out.println(t.check);
//            i++;
//        }
//        text = text + col_names + "   " + "+\" \";\n";
        String wheres = "";
        for (Dlg_where2.to_where str : where) {
            wheres = wheres + str.output + "\n";
        }
        text = text + wheres + "";

        text = text + "   +\" \";\n";
        text = text + "\n";

        text = text + "  PreparedStatement stmt = conn.prepareStatement(s0);" + "\n";
        text = text + "  stmt.execute();" + "\n";
        text = text + "   Lg.s(S1_to.class, \"Successfully Deleted\");" + "\n";


        text = text + "} catch (Exception e) { \n  throw new RuntimeException(e);\n";
        text = text + " } finally { \n  PoolConnection.close();\n  }\n  }\n";
        return text;

//        SqlStringUtil.parse(col_sql)

    }

    public static String table(List<S1_set.to_col> to, String database, String table_name, List<Dlg_where2.to_where> where) {

        String parameter = "";

        String text = "private ArrayListModel tbl_" + table_name + "_ALM; \n";
        text = text + "private Tbl" + table_name + "Model tbl_" + table_name + "_M;" + " \n\n";

        text = text + "private void init_tbl_" + table_name + "() {\n";
        text = text + "tbl_" + table_name + "_ALM= new ArrayListModel(); \n";
        text = text + "tbl_" + table_name + "_M=  new Tbl" + table_name + "Model(tbl_" + table_name + "_ALM); \n";
        text = text + "tbl_" + table_name + ".getTableHeader().setPreferredSize(new Dimension(100, 40)); \n";
        text = text + "tbl_" + table_name + ".setModel(tbl_" + table_name + "_M); \n";
        text = text + "tbl_" + table_name + ".setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); \n";
        text = text + "tbl_" + table_name + ".setRowHeight(25); \n";

        int size = 0;
        int[] tbl_widths_accounts = new int[to.size()];
        int ii = 0;
        String width = "";
        String columns = "";
        String switchs = "";
        for (S1_set.to_col s : to) {
            if (s.check == true) {
                size = 100;
            } else {
                size = 0;
            }
            tbl_widths_accounts[ii] = size;
            if (ii == to.size() - 1) {
                width = width + size + "";
                columns = columns + "\"" + s.name + "\"";
                switchs = switchs + "default:\n return tt." + s.name + ";";
            } else {
                width = width + size + ",";
                columns = columns + "\"" + s.name + "\",";
                switchs = switchs + "case " + ii + ":\n return tt." + s.name + ";";
            }
            ii++;
        }
        text = text + "int[] tbl_widths_" + table_name + "= {" + width + "}; \n";
        text = text + "for (int i = 0, n = tbl_widths_" + table_name + ".length; i < n; i++) { \n";
        text = text + "if (i == 100) { \ncontinue;\n}";
        text = text + "TableWidthUtilities.setColumnWidth(tbl_" + table_name + ", i, tbl_widths_" + table_name + "[i]);\n}\n";

        text = text + "Dimension d = tbl_" + table_name + ".getTableHeader(). getPreferredSize();\n";
        text = text + "d.height = 30;\n";
        text = text + "tbl_" + table_name + ".getTableHeader().setPreferredSize(d);\n";
        text = text + "tbl_" + table_name + ".getTableHeader().setFont(new java.awt.Font(\"Arial\", Font.BOLD, 12)); \n";
        text = text + "tbl_" + table_name + ".setRowHeight(35); \n ";
        text = text + "tbl_" + table_name + ".setFont(new java.awt.Font(\"Arial\", 1, 12)); \n}\n";

        text = text + "private void loadData_" + table_name + "(List<to_" + table_name + "> acc) { \n";
        text = text + "tbl_" + table_name + "_ALM.clear(); \n";
        text = text + "tbl_" + table_name + "_ALM.addAll(acc); \n}\n\n";

        text = text + "public static class Tbl" + table_name + "Model extends AbstractTableAdapter { \n\n";
        text = text + "public static String[] COLUMNS = {\n" + columns + "\n };\n";

        text = text + "public Tbl" + table_name + "Model(ListModel listmodel) {\n super(listmodel, COLUMNS); \n}\n";
        text = text + "@Override \n public boolean isCellEditable(int row, int column) {\n";
        text = text + "if (column == 1) {\n  return true;\n }\n return false; \n } \n";

        text = text + "@Override \n public Class getColumnClass(int col) {\n ";
        text = text + "if (col == 1000) {\n  return Boolean.class;\n }\n return Object.class;\n } \n";

        text = text + "@Override \n public Object getValueAt(int row, int col) {\n ";
        text = text + "to_" + table_name + " tt = (to_" + table_name + ") getRow(row);\n ";
        text = text + " switch (col) {\n ";
        text = text + "" + switchs + "\n}\n}\n}\n";

        text = text + "private void data_cols() {\n";
        text = text + "loadData_" + table_name + "(new ArrayListModel());\n}\n\n";


        return text;
    }

    public static String select_list(List<S1_set.to_col> to, String database, String table_name, List<Dlg_where2.to_where> where) {

        String text = "";
        text = text + "public static List<to_" + table_name + "> ret_data(String search){ \n";
        text = text + "List<to_" + table_name + "> datas=new ArrayList(); \n\n";
        text = text + "try {\n Connection conn = PoolConnection.connect();\n";


        String col_names = "";
        String col_name2 = "";
        String results = "";
        int i = 0;

        for (S1_set.to_col t : to) {
//            System.out.println(t.type);
            String type = "";
            if (t.check == true) {
                if (i == 0) {
                    col_names = col_names + "   +\"" + t.name + "\"\n";
                } else {
                    col_names = col_names + "   +\"," + t.name + "\"\n";
                }
            }

            if (t.type.equalsIgnoreCase("integer") || t.type.equalsIgnoreCase("tinyint")) {
                type = "int";

                if (t.check == true) {
                    results = results + "int " + t.name + "=" + "rs.getInt(" + (i + 1) + ");\n";
                    if (i == to.size() - 1) {
                        col_name2 = col_name2 + t.name + "";
                    } else {
                        col_name2 = col_name2 + t.name + ", ";
                    }
                } else {
                    results = results + "int " + t.name + "=" + "0;\n";
                    if (i == to.size() - 1) {
                        col_name2 = col_name2 + "0" + "";
                    } else {
                        col_name2 = col_name2 + "0" + ", ";
                    }
                }
            } else if (type.equalsIgnoreCase("DOUBLE")) {
                type = "double";

                if (t.check == true) {
                    results = results + "double " + t.name + "=" + "rs.getDouble(" + (i + 1) + ");\n";
                    if (i == to.size() - 1) {
                        col_name2 = col_name2 + t.name + "";
                    } else {
                        col_name2 = col_name2 + t.name + ", ";
                    }
                } else {
                    results = results + "int " + t.name + "=" + "0;\n";
                    if (i == to.size() - 1) {
                        col_name2 = col_name2 + "0" + "";
                    } else {
                        col_name2 = col_name2 + "0" + ", ";
                    }
                }
            } else {
                type = "String";
//                System.out.println(t.name+" - "+t.type);
                if (t.check == true) {

                    if (t.type.equals("DOUBLE")) {
                        results = results + "double " + t.name + "=" + "rs.getDouble(" + (i + 1) + ");\n";
                    } else {
                        results = results + "String " + t.name + "=" + "rs.getString(" + (i + 1) + ");\n";
                    }

                    if (i == to.size() - 1) {
                        col_name2 = col_name2 + t.name + "";
                    } else {
                        col_name2 = col_name2 + t.name + ", ";
                    }



                } else {
                    if (t.type.equals("DOUBLE")) {
                        results = results + "double " + t.name + "=" + "0;\n";
                    } else {
                        results = results + "String " + t.name + "=" + "\"\";\n";
                    }

                    if (i == to.size() - 1) {
                        col_name2 = col_name2 + "\"\"" + "";
                    } else {
                        col_name2 = col_name2 + "\"\"" + ", ";
                    }
                }
            }
            i++;

        }
        text = text + "String s0=\"select \"\n";

        text = text + col_names + " +\" from \"+MyDB.getNames()+\"." + table_name + " where \"\n";
        String wheres = "";
        for (Dlg_where2.to_where str : where) {
            wheres = wheres + str.output + "\n";
        }
        text = text + wheres + "";
        text = text + "   +\" \";\n";
        text = text + "\n";

        text = text + "Statement stmt = conn.createStatement();\n";
        text = text + "ResultSet rs = stmt.executeQuery(s0);\n";
        text = text + "while (rs.next()) {\n";
//        
//                datas.add(to);
        text = text + results + "\n";
        text = text + "to_" + table_name + " to=new to_" + table_name + "(" + col_name2 + ");\n";
        text = text + "datas.add(to);\n";
        text = text + "}\n";
        text = text + "return datas;\n";
        text = text + "} catch (Exception e) { \n  throw new RuntimeException(e);\n";
        text = text + " } finally { \n  PoolConnection.close();\n  }\n  }\n";

        return text;

    }

    public static String select_to(List<S1_set.to_col> to, String database, String table_name, List<Dlg_where2.to_where> where) {

        String text = "";
        text = text + "public static to_" + table_name + " ret_data(String search){ \n";
        text = text + "to_" + table_name + " to1=null; \n\n";
        text = text + "try {\n Connection conn = PoolConnection.connect();\n";


        String col_names = "";
        String col_name2 = "";
        String results = "";
        int i = 0;

        for (S1_set.to_col t : to) {
//            System.out.println(t.type);
            String type = "";
            if (t.check == true) {
                if (i == 0) {
                    col_names = col_names + "   +\"" + t.name + "\"\n";
                } else {
                    col_names = col_names + "   +\"," + t.name + "\"\n";
                }
            }

            if (t.type.equalsIgnoreCase("integer") || t.type.equalsIgnoreCase("tinyint")) {
                type = "int";

                if (t.check == true) {
                    results = results + "int " + t.name + "=" + "rs.getInt(" + (i + 1) + ");\n";
                    if (i == to.size() - 1) {
                        col_name2 = col_name2 + t.name + "";
                    } else {
                        col_name2 = col_name2 + t.name + ", ";
                    }
                } else {
                    results = results + "int " + t.name + "=" + "0;\n";
                    if (i == to.size() - 1) {
                        col_name2 = col_name2 + "0" + "";
                    } else {
                        col_name2 = col_name2 + "0" + ", ";
                    }
                }
            } else if (type.equalsIgnoreCase("DOUBLE")) {
                type = "double";

                if (t.check == true) {
                    results = results + "double " + t.name + "=" + "rs.getDouble(" + (i + 1) + ");\n";
                    if (i == to.size() - 1) {
                        col_name2 = col_name2 + t.name + "";
                    } else {
                        col_name2 = col_name2 + t.name + ", ";
                    }
                } else {
                    results = results + "int " + t.name + "=" + "0;\n";
                    if (i == to.size() - 1) {
                        col_name2 = col_name2 + "0" + "";
                    } else {
                        col_name2 = col_name2 + "0" + ", ";
                    }
                }
            } else {
                type = "String";
//                System.out.println(t.name+" - "+t.type);
                if (t.check == true) {

                    if (t.type.equals("DOUBLE")) {
                        results = results + "double " + t.name + "=" + "rs.getDouble(" + (i + 1) + ");\n";
                    } else {
                        results = results + "String " + t.name + "=" + "rs.getString(" + (i + 1) + ");\n";
                    }

                    if (i == to.size() - 1) {
                        col_name2 = col_name2 + t.name + "";
                    } else {
                        col_name2 = col_name2 + t.name + ", ";
                    }



                } else {
                    if (t.type.equals("DOUBLE")) {
                        results = results + "double " + t.name + "=" + "0;\n";
                    } else {
                        results = results + "String " + t.name + "=" + "\"\";\n";
                    }

                    if (i == to.size() - 1) {
                        col_name2 = col_name2 + "\"\"" + "";
                    } else {
                        col_name2 = col_name2 + "\"\"" + ", ";
                    }
                }
            }
            i++;

        }
        text = text + "String s0=\"select \"\n";

        text = text + col_names + " +\" from \"+MyDB.getNames()+\"." + table_name + " where \"\n";
        String wheres = "";
        for (Dlg_where2.to_where str : where) {
            wheres = wheres + str.output + "\n";
        }
        text = text + wheres + "";
        text = text + "   +\" \";\n";
        text = text + "\n";

        text = text + "Statement stmt = conn.createStatement();\n";
        text = text + "ResultSet rs = stmt.executeQuery(s0);\n";
        text = text + "while (rs.next()) {\n";
//        
//                datas.add(to);
        text = text + results + "\n";
        text = text + " to1=new to_" + table_name + "(" + col_name2 + ");\n";
//        text = text + "datas.add(to);\n";
        text = text + "}\n";
        text = text + "return to1;\n";
        text = text + "} catch (Exception e) { \n  throw new RuntimeException(e);\n";
        text = text + " } finally { \n  PoolConnection.close();\n  }\n  }\n";

        return text;

    }

    public static String data_table(List<S1_set.to_col> to, String database, String table_name) {

        String text = "";
        text = text + "int row=tbl_" + table_name + ".getSelectedRow(); \n";
        text = text + "if(row<0){\nreturn;\n} \n";

        String col_names = "";
        String col_name2 = "";
        String results = "";
        int i = 0;

        for (S1_set.to_col t : to) {
//            System.out.println(t.type);
            String type = "";
            if (t.check == true) {
                if (i == 0) {
                    col_names = col_names + "   +\"" + t.name + "\"\n";
                } else {
                    col_names = col_names + "   +\"," + t.name + "\"\n";
                }
            }


            if (t.type.equalsIgnoreCase("integer") || t.type.equalsIgnoreCase("tinyint")) {
                type = "int";

                if (t.check == true) {
                    results = results + "int " + t.name + "= FitIn.toInt(tbl_" + table_name + ".getModel().getValueAt(row," + i + ").toString());\n";
                    if (i == to.size() - 1) {
                        col_name2 = col_name2 + t.name + "";
                    } else {
                        col_name2 = col_name2 + t.name + ", ";
                    }
                } else {
                    results = results + "int " + t.name + "=" + "0;\n";
                    if (i == to.size() - 1) {
                        col_name2 = col_name2 + "0" + "";
                    } else {
                        col_name2 = col_name2 + "0" + ", ";
                    }
                }
            } else if (type.equalsIgnoreCase("DOUBLE")) {
                type = "double";

                if (t.check == true) {
                    results = results + "double " + t.name + "= FitIn.toDouble(tbl_" + table_name + ".getModel().getValueAt(row," + i + ").toString());\n";
                    if (i == to.size() - 1) {
                        col_name2 = col_name2 + t.name + "";
                    } else {
                        col_name2 = col_name2 + t.name + ", ";
                    }
                } else {
                    results = results + "int " + t.name + "=" + "0;\n";
                    if (i == to.size() - 1) {
                        col_name2 = col_name2 + "0" + "";
                    } else {
                        col_name2 = col_name2 + "0" + ", ";
                    }
                }
            } else {
                type = "String";
//                System.out.println(t.name+" - "+t.type);
                if (t.check == true) {

                    if (t.type.equals("DOUBLE")) {
                        results = results + "double " + t.name + "= FitIn.toDouble(tbl_" + table_name + ".getModel().getValueAt(row," + i + ").toString());\n";
                    } else {
                        results = results + "String " + t.name + "= (tbl_" + table_name + ".getModel().getValueAt(row," + i + ").toString());\n";
                    }

                    if (i == to.size() - 1) {
                        col_name2 = col_name2 + t.name + "";
                    } else {
                        col_name2 = col_name2 + t.name + ", ";
                    }



                } else {
                    if (t.type.equals("DOUBLE")) {
                        results = results + "double " + t.name + "=" + "0;\n";
                    } else {
                        results = results + "String " + t.name + "=" + "\"\";\n";
                    }




                    if (i == to.size() - 1) {
                        col_name2 = col_name2 + "\"\"" + "";
                    } else {
                        col_name2 = col_name2 + "\"\"" + ", ";
                    }
                }
            }
            i++;

        }

        text = text + results + "\n";
        return text;
    }

    public static String increment_id(String database, String table_name) {

        String text = "";
        text = text + "public static String increment_id(){ \n";
        text = text + "String id=\"0\";\n";
        text = text + "try {\n Connection conn = PoolConnection.connect();\n";
        text = text + "String s0=\"select max(id) from \"+MyDB.getNames()+\"." + table_name + "\" ;\n";
        text = text + "Statement stmt = conn.createStatement();\n";
        text = text + "ResultSet rs = stmt.executeQuery(s0);\n";
        text = text + "if (rs.next()) {\n";
        text = text + "id=rs.getString(1);\n";
        text = text + "}\n";
        text = text + "id=ReceiptIncrementor.increment(id); \n";
        text = text + "return id;\n";
        text = text + "} catch (Exception e) { \n  throw new RuntimeException(e);\n";
        text = text + " } finally { \n  PoolConnection.close();\n  }\n  }\n";
        return text;
    }

    public static String cb_data(String database, String table_name) {

        String text = "";
        text = text + "public static List<String> ret_cb_data(){ \n";
        text = text + "List<String> datas=new ArrayList();\n\n";
        text = text + "try {\n Connection conn = PoolConnection.connect();\n";
        text = text + "String s0=\"select id from \"+MyDB.getNames()+\"." + table_name + "\" ;\n";
        text = text + "Statement stmt = conn.createStatement();\n";
        text = text + "ResultSet rs = stmt.executeQuery(s0);\n";
        text = text + "while(rs.next()) {\n";
        text = text + "String id=rs.getString(1);\n";
        text = text + "datas.add(id);\n";
        text = text + "}\n";
        text = text + "return datas;\n";
        text = text + "} catch (Exception e) { \n  throw new RuntimeException(e);\n";
        text = text + " } finally { \n  PoolConnection.close();\n  }\n  }\n";
        return text;
    }

    public static String addedit(List<S1_set.to_col> to, String database, String table_name) {

        String text = "";

        //add        
        text = text + "private void add_to_" + table_name + "(){ \n";
        text = text + "Window p = (Window) this;\n";
        text = text + "Dlg_add_" + table_name + " nd = Dlg_add_" + table_name + ".create(p, true);\n";
        text = text + "nd.setTitle(\"\");\n";
        text = text + "nd.setCallback(new Dlg_add_" + table_name + ".Callback() { \n";
        text = text + "@Override\n";
        text = text + "public void ok(CloseDialog closeDialog, Dlg_add_" + table_name + ".OutputData data) {\n";
        text = text + "closeDialog.ok();\n";
        text = text + "List<to_" + table_name + "> datas=new ArrayList(); \ndatas.add(data.to1);\n";
        text = text + "loadData(datas);\n } \n });\n";
        text = text + "Center.setCenter(nd); \n";
        text = text + "nd.setVisible(true); \n }\n\n\n";

        //edit
        text = text + "private void edit_to_" + table_name + "(){ \n";
        text = text + "int idx = tbl_" + table_name + ".getSelectedRows();\n";
        text = text + "if (idx < 0) {\n return; \n } \n\n";
        text = text + "final to_" + table_name + " to = (to_" + table_name + ") tbl_" + table_name + "_ALM.get(tbl_" + table_name + ".convertRowIndexToModel(idx));\n\n";

        text = text + "Window p = (Window) this;\n";
        text = text + "Dlg_add_" + table_name + " nd = Dlg_add" + table_name + ".create(p, true);\n";
        text = text + "nd.setTitle(\"\");\n";
        text = text + "nd.do_pass(to);\n";
        text = text + "nd.setCallback(new Dlg_add_" + table_name + ".Callback() { \n";
        text = text + "@Override\n";
        text = text + "public void ok(CloseDialog closeDialog, Dlg_add_" + table_name + ".OutputData data) {\n";
        text = text + "closeDialog.ok();\n";
        text = text + "to.setS(data.to1.);\n";
        text = text + "tbl_" + table_name + "_M.fireTableDataChanged();\n } \n });\n";
        text = text + "Center.setCenter(nd); \n";
        text = text + "nd.setVisible(true); \n }\n\n\n";

        //delete
        text = text + "private void delete_to_" + table_name + "(){ \n";
        text = text + "int[] idx = tbl_" + table_name + ".getSelectedRow();\n";
        text = text + "List rem = new ArrayList();\n";
        text = text + "for (int ix : idx) {\n";
        text = text + "     if (tbl_" + table_name + ".isRowSelected(ix)) {\n";
        text = text + "     int mx = tbl_" + table_name + ".convertRowIndexToModel(ix);\n";
        text = text + "     rem.add(tbl_" + table_name + "_ALM.get(mx));\n }\n } \n";
        text = text + "tbl_" + table_name + "_ALM.removeAll(rem);\n";
        text = text + "tbl_" + table_name + "_M.fireTableDataChanged();\n } \n";
        return text;
    }

    public static class to_tangeble {

        public final String id;
        public final String tancat;
        public final String tandesc;
        public final String tanlife;

        public to_tangeble(String id, String tancat, String tandesc, String tanlife) {
            this.id = id;
            this.tancat = tancat;
            this.tandesc = tandesc;
            this.tanlife = tanlife;
        }
    }

    public static void main(String[] args) {
    }
}
