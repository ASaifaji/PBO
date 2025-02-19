
// Nama File   : Titik.java
// Deskripsi   : 
// Pembuat     : Abyasa Saifaji / aby110605@gmail.com
// Tanggal     : 17/02/2025

public class Titik {
    
    // Attribut
    double absis;
    double ordinat;
    static int counterTitik = 0;

    // Method
    // Konstruktor pembuat titik
    Titik(){
        this(0,0);
    }

    // Konstruktor dengan nilai
    Titik(double x, double y){
        this.absis = x;
        this.ordinat = y;
        counterTitik++;
    }

    // mengembalikan nilai counterTitik
    static int getCounterTitik(){
        return counterTitik;
    }

    // mengembalikan nilai absis
    double getAbsis(){
        return absis;
    }

    // mengembalikan nilai ordinat
    double getOrdinat(){
        return ordinat;
    }

    // mengeset absis titik dengan nilai baru x
    void setAbsis(double x){
        absis = x;
    }

    // mengeset ordinat titik dengan nilai baru y
    void setOrdinat(double y){
        ordinat = y;
    }

    // menggeser nilai absis dan ordinat titik masing-masing sejauh x dan y
    void geser(double x, double y){
        absis = absis + x;
        ordinat = ordinat + x;
    }

    // mencetak koordinat titik
    void printTitik(){
        System.out.println("Titik (" + absis + "," + ordinat + ")");
    }

    void printCounterTitik(){
        System.out.println(this.counterTitik);
    }

    int getKuadran(){
        if (this.absis > 0 && this.ordinat > 0) {
            return 1;
        } else if (this.absis < 0 && this.ordinat > 0) {
            return 2;
        } else if (this.absis < 0 && this.ordinat < 0) {
            return 3;
        } else if (this.absis > 0 && this.ordinat < 0) {
            return 4;
        } else {
            return 0;
        }
    }

    double getJarakPusat(){
        return Math.sqrt((this.absis * this.absis)+(this.ordinat * this.ordinat));
    }

    double getJarak(Titik T){
        return Math.sqrt(((this.absis - T.absis)*(this.absis - T.absis)) + ((this.ordinat - T.ordinat)*(this.ordinat - T.ordinat)));
    }

    void refleksiX(){
        ordinat = -(ordinat);
    }

    void refleksiY(){
        absis = -(absis);
    }

    Titik getRefleksiX(){
        Titik T = new Titik(this.absis, -(this.ordinat));
        return T;
    }

    Titik getRefleksiY(){
        Titik T = new Titik(-(this.absis), this.ordinat);
        return T;
    }

}   // end class Titik