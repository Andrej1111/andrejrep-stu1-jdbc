package lt.bit.aje.jdbc.db;

import lt.bit.aje.jdbc.entity.Pazymiai;
import lt.bit.aje.jdbc.entity.Studentas;

import java.sql.*;
import java.util.*;

public class DatabaseManager {
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String URL         = "jdbc:mysql://localhost:3306/dienynas?serverTimezone=Europe/Vilnius";
    private static final String USERNAME    = "root";
    private static final String PASSWORD    = "mysql";
    private static final String SELECT_STUDENTAS = "Select * From dienynas.studentai";
    private static final String SELECT_PAZYMIAI = "Select * From dienynas.pazymiai";
    private static final String SELECT_STUDENTAS_PAZYMIAI = "Select * From pazymiai";
    private static final String SELECT_STUDENTAI_REZULTATAI = "select studentai.id, pavarde, vardas, AVG(pazymiai.pazymys) from dienynas.studentai\n" +
            "LEFT JOIN dienynas.pazymiai\n" +
            "ON studentai.id = pazymiai.studentas_id group by studentai.pavarde order by pavarde, vardas asc limit 10";

    private Connection connection;

    public DatabaseManager() {
        try {
            connection = DriverManager.getConnection( URL, USERNAME, PASSWORD );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Studentas> getStudentas(){
        List<Studentas> results = new ArrayList<>();
        try {
            int ID_COL = 1;
            int VARDAS_COL = 2;
            int PAVARDE_COL = 3;
            int EL_PASTAS_COL = 4;

            PreparedStatement ps = connection.prepareStatement(SELECT_STUDENTAS);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Studentas dpEntity = new Studentas(rs.getString(ID_COL), rs.getString(VARDAS_COL),
                        rs.getString(PAVARDE_COL), rs.getString(EL_PASTAS_COL));
                results.add(dpEntity);
            }
            closeResultSet(rs);
            closePrepaerdStatement(ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public List<Pazymiai> getPazymiai(){
        List<Pazymiai> results2 = new ArrayList<>();
        try {
            int ID_COL = 1;
            int STUDENTAS_ID_COL = 2;
            int DATA_COL = 3;
            int PAZYMYS_COL = 4;

            PreparedStatement psPaz = connection.prepareStatement(SELECT_PAZYMIAI);
            ResultSet rs = psPaz.executeQuery();
            while(rs.next()){
                Pazymiai dpEntity = new Pazymiai(rs.getString(ID_COL), rs.getString(STUDENTAS_ID_COL),
                        rs.getString(DATA_COL), rs.getString(PAZYMYS_COL));
                results2.add(dpEntity);
            }
            closeResultSet(rs);
            closePrepaerdStatement(psPaz);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results2;
    }

    public Map<Studentas, Pazymiai> getStudPazymiai(){
        Map<Studentas, Pazymiai> results3 = new Map<Studentas, Pazymiai>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object o) {
                return false;
            }

            @Override
            public boolean containsValue(Object o) {
                return false;
            }

            @Override
            public Pazymiai get(Object o) {
                return null;
            }

            @Override
            public Pazymiai put(Studentas studentas, Pazymiai pazymiai) {
                return null;
            }

            @Override
            public Pazymiai remove(Object o) {
                return null;
            }

            @Override
            public void putAll(Map<? extends Studentas, ? extends Pazymiai> map) {

            }

            @Override
            public void clear() {
            }

            @Override
            public Set<Studentas> keySet() {
                return null;
            }

            @Override
            public Collection<Pazymiai> values() {
                return null;
            }

            @Override
            public Set<Entry<Studentas, Pazymiai>> entrySet() {
                return null;
            }
        };

        try {
  //         int ID_COL = 1;
  //         int STUDENTAS_ID_COL = 2;
  //         int DATA_COL = 3;
  //         int PAZYMYS_COL = 4;
            PreparedStatement psPaz = connection.prepareStatement(SELECT_STUDENTAS_PAZYMIAI);
            ResultSet rs = psPaz.executeQuery();
    //        while(rs.next()){
    //            Pazymiai dpEntity = new Pazymiai(rs.getString(ID_COL), rs.getString(STUDENTAS_ID_COL),
    //                    rs.getString(DATA_COL), rs.getString(PAZYMYS_COL));
    //            results2.add(dpEntity);
    //        }
            closeResultSet(rs);
            closePrepaerdStatement(psPaz);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results3;
    }

    /**
     *  Formuojame reyultatų sąrašą
     */
   public List<Object> getStudentasRezultatai(){
       List<Object> results = new ArrayList<>();
       try {
           PreparedStatement ps = connection.prepareStatement(SELECT_STUDENTAI_REZULTATAI);
           ResultSet rs = ps.executeQuery();
           while(rs.next()) {
               System.out.println(rs.getLong(1) + "  " +
                       rs.getString(2) + " " +
                       rs.getString(3) + " " +
                       rs.getLong(4));
           }
           closeResultSet(rs);
           closePrepaerdStatement(ps);
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return results;
   }

    private void closePrepaerdStatement( PreparedStatement stmt ) throws SQLException
    {
        if ( stmt != null )
        {
            stmt.close();
        }
    }

    private static void closeResultSet( ResultSet rs ) throws SQLException
    {
        if ( rs != null )
        {
            rs.close();
        }
    }

    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}