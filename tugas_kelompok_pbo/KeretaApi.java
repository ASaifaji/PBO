// 5. Kelas KeretaApi
public class KeretaApi {
    private String namaKereta;
    private String stasiunAsal;
    private String stasiunTujuan;
    private String jamBerangkat;
    private String jamTiba;
    private int jumlahKursi;
    private double hargaTiket;
    private Rute rute;
    
    public KeretaApi(String namaKereta, String stasiunAsal, String stasiunTujuan, 
                    String jamBerangkat, String jamTiba, int jumlahKursi, double hargaTiket) {
        this.namaKereta = namaKereta;
        this.stasiunAsal = stasiunAsal;
        this.stasiunTujuan = stasiunTujuan;
        this.jamBerangkat = jamBerangkat;
        this.jamTiba = jamTiba;
        this.jumlahKursi = jumlahKursi;
        this.hargaTiket = hargaTiket;
        
        // Buat objek Rute
        this.rute = new Rute(stasiunAsal, stasiunTujuan, hitungDurasi(jamBerangkat, jamTiba));
    }
    
    // Getter dan Setter
    public String getNamaKereta() {
        return namaKereta;
    }
    
    public void setNamaKereta(String namaKereta) {
        this.namaKereta = namaKereta;
    }
    
    public String getStasiunAsal() {
        return stasiunAsal;
    }
    
    public void setStasiunAsal(String stasiunAsal) {
        this.stasiunAsal = stasiunAsal;
        if (this.rute != null) {
            this.rute.setStasiunAsal(stasiunAsal);
        }
    }
    
    public String getStasiunTujuan() {
        return stasiunTujuan;
    }
    
    public void setStasiunTujuan(String stasiunTujuan) {
        this.stasiunTujuan = stasiunTujuan;
        if (this.rute != null) {
            this.rute.setStasiunTujuan(stasiunTujuan);
        }
    }
    
    public String getJamBerangkat() {
        return jamBerangkat;
    }
    
    public void setJamBerangkat(String jamBerangkat) {
        this.jamBerangkat = jamBerangkat;
        if (this.rute != null) {
            this.rute.setDurasi(hitungDurasi(jamBerangkat, this.jamTiba));
        }
    }
    
    public String getJamTiba() {
        return jamTiba;
    }
    
    public void setJamTiba(String jamTiba) {
        this.jamTiba = jamTiba;
        if (this.rute != null) {
            this.rute.setDurasi(hitungDurasi(this.jamBerangkat, jamTiba));
        }
    }
    
    public int getJumlahKursi() {
        return jumlahKursi;
    }
    
    public void setJumlahKursi(int jumlahKursi) {
        this.jumlahKursi = jumlahKursi;
    }
    
    public double getHargaTiket() {
        return hargaTiket;
    }
    
    public void setHargaTiket(double hargaTiket) {
        this.hargaTiket = hargaTiket;
    }
    
    public Rute getRute() {
        return rute;
    }
    
    // Method sesuai class diagram
    public void tampilkanJadwal() {
        System.out.println("Jadwal Kereta " + namaKereta);
        System.out.println("Stasiun Asal: " + stasiunAsal + " (" + jamBerangkat + ")");
        System.out.println("Stasiun Tujuan: " + stasiunTujuan + " (" + jamTiba + ")");
        System.out.println("Durasi Perjalanan: " + rute.getDurasi());
        System.out.println("Harga Tiket: Rp. " + String.format("%,.2f", hargaTiket));
        System.out.println("Jumlah Kursi Tersedia: " + jumlahKursi);
    }
    
    public boolean cekKetersediaanKursi() {
        return jumlahKursi > 0;
    }
    
    public void kurangiKursi() {
        if (jumlahKursi > 0) {
            jumlahKursi--;
            System.out.println("Kursi berhasil dipesan. Kursi tersisa: " + jumlahKursi);
        }
    }
    
    public void tambahKursi() {
        jumlahKursi++;
        System.out.println("Kursi berhasil dikembalikan. Kursi tersisa: " + jumlahKursi);
    }
    
    // Method helper untuk menghitung durasi perjalanan
    private String hitungDurasi(String jamBerangkat, String jamTiba) {
        // Parsing waktu
        String[] berangkat = jamBerangkat.split(":");
        String[] tiba = jamTiba.split(":");
        
        int jamAwal = Integer.parseInt(berangkat[0]);
        int menitAwal = Integer.parseInt(berangkat[1]);
        int jamAkhir = Integer.parseInt(tiba[0]);
        int menitAkhir = Integer.parseInt(tiba[1]);
        
        // Hitung selisih
        int totalMenitAwal = jamAwal * 60 + menitAwal;
        int totalMenitAkhir = jamAkhir * 60 + menitAkhir;
        
        // Jika kereta tiba di hari berikutnya
        if (totalMenitAkhir < totalMenitAwal) {
            totalMenitAkhir += 24 * 60; // Tambah 24 jam
        }
        
        int selisihMenit = totalMenitAkhir - totalMenitAwal;
        int jam = selisihMenit / 60;
        int menit = selisihMenit % 60;
        
        return jam + " jam " + menit + " menit";
    }
    
    @Override
    public String toString() {
        return namaKereta + " (" + stasiunAsal + " → " + stasiunTujuan + ")";
    }
}