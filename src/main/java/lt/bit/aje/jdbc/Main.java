package lt.bit.aje.jdbc;

import lt.bit.aje.jdbc.db.DatabaseManager;
import lt.bit.aje.jdbc.entity.Pazymiai;
import lt.bit.aje.jdbc.entity.Studentas;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args){

        DatabaseManager db = new DatabaseManager();

        /**
         *  3 Užduotis
         */
        List<Studentas> data = db.getStudentas();
        for (Studentas dp : data) {
            System.out.println(dp.toString());
        }


        List<Pazymiai> pazymiai = db.getPazymiai();
        for (Pazymiai dpPaz : pazymiai) {
            System.out.println(dpPaz.toString());
        }


    ////    List<Studentas> stPazymiai = db.getStudPazymiai();

        /**
         *  4 Užuotis
         */
        Map<Studentas, Pazymiai> studPazymiai = db.getStudPazymiai();
   //     for (Studentas dp : data) {
   //         for (Pazymiai dpPaz : pazymiai) {
                System.out.println();
   //         }
   //     }

   //     db.getMinSalary();

        /**
         *  5 Užduotis
         */
   //     public static int kursoVidurkis(int metai) {
   //         return resultsAVG;
   //     }

        db.close();
    }
}