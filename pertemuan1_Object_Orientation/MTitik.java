// Nama File    : MTitik.java
// Deskripsi    : 
// Pembuat      : Abyasa Saifaji / aby110605@gmail.com
// Tanggal      : 17/02/2025

public class MTitik {
    
    public static void main(String[] args) {
        Titik T1 = new Titik();     // membuat objek titik T1 (0,0)
        T1.setAbsis(3);     // mengubah absis T1 dengan nilai 3
        T1.setOrdinat(4);   // mengubah ordinat T1 dengan nilai 4
        T1.printTitik();    // mencetak koordinat T1 ke layar
        T1.geser(3, 4);     // menggeser T1 sejauh (3,4)
        T1.printTitik();    // mencetak koordinat T1 setelah digeser

        Titik T2 = T1;
        T2.printTitik();
        T1.setAbsis(10);
        T1.setOrdinat(10);
        T2.printTitik();

        Titik T3 = new Titik();     // membuat objek titik (0,0)
        Titik T4 = new Titik(-3,5);  // membuat objek titik (3,5)

        System.out.println("Jumlah Objek Titik = " + Titik.getCounterTitik());
        System.out.println("Jumlah Objek Titik = " + T4.getCounterTitik());

        T2.printCounterTitik();

        System.out.println("Kuadran ke " + T4.getKuadran());
    }   
}
