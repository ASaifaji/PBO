// 2. Kelas Tiket
public class Tiket {
    private String noTiket;
    private KeretaApi kereta;
    private String penumpang;
    private double harga;
    
    public Tiket(String noTiket, KeretaApi kereta, String penumpang, double harga) {
        this.noTiket = noTiket;
        this.kereta = kereta;
        this.penumpang = penumpang;
        this.harga = harga;
    }
    
    // Getter dan Setter
    public String getNoTiket() {
        return noTiket;
    }
    
    public void setNoTiket(String noTiket) {
        this.noTiket = noTiket;
    }
    
    public KeretaApi getKereta() {
        return kereta;
    }
    
    public void setKereta(KeretaApi kereta) {
        this.kereta = kereta;
    }
    
    public String getPenumpang() {
        return penumpang;
    }
    
    public void setPenumpang(String penumpang) {
        this.penumpang = penumpang;
    }
    
    public double getHarga() {
        return harga;
    }
    
    public void setHarga(double harga) {
        this.harga = harga;
    }
    
    // Method sesuai class diagram
    public void tampilkanDetail() {
        System.out.println("=== DETAIL TIKET ===");
        System.out.println("No. Tiket: " + noTiket);
        System.out.println("Kereta: " + kereta.getNamaKereta());
        System.out.println("Penumpang: " + penumpang);
        System.out.println("Harga: Rp. " + String.format("%,.2f", harga));
        System.out.println("Rute: " + kereta.getStasiunAsal() + " → " + kereta.getStasiunTujuan());
        System.out.println("Jadwal: " + kereta.getJamBerangkat() + " - " + kereta.getJamTiba());
    }
    
    public void cetakTiket() {
        System.out.println("\n------ TIKET KERETA API ------");
        System.out.println("No. Tiket   : " + noTiket);
        System.out.println("Kereta      : " + kereta.getNamaKereta());
        System.out.println("Penumpang   : " + penumpang);
        System.out.println("Asal        : " + kereta.getStasiunAsal());
        System.out.println("Tujuan      : " + kereta.getStasiunTujuan());
        System.out.println("Berangkat   : " + kereta.getJamBerangkat());
        System.out.println("Tiba        : " + kereta.getJamTiba());
        System.out.println("Harga       : Rp. " + String.format("%,.2f", harga));
        System.out.println("----------------------------");
        System.out.println("Selamat menikmati perjalanan!");
        System.out.println("----------------------------");
    }
    
    @Override
    public String toString() {
        return "Tiket " + noTiket + " - " + kereta.getNamaKereta() + " (" + penumpang + ")";
    }
}