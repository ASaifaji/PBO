// Nama File   : Garis.java
// Deskripsi   : 
// Pembuat     : Abyasa Saifaji / aby110605@gmail.com
// Tanggal     : 18/02/2025

public class Garis {

    // Attribut
    Titik t_awal;
    Titik t_akhir;
    static int counterGaris = 0;

    // Method
    // Konstruktor
    Garis(){
        Titik t_awal = new Titik();
        Titik t_akhir = new Titik(1,1);
    }

    Garis(Titik T1, Titik T2){
        this.t_awal = T1;
        this.t_akhir = T2;
        counterGaris++;
    }


}
