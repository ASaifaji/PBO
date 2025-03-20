// 3. Kelas Pemesanan
public class Pemesanan {
    private String idPemesanan;
    private double totalHarga;
    private String status;
    private Pelanggan pelanggan;
    private KeretaApi kereta;
    private Pembayaran pembayaran;
    private Tiket tiket;
    
    public Pemesanan(String idPemesanan, Pelanggan pelanggan, KeretaApi kereta) {
        this.idPemesanan = idPemesanan;
        this.pelanggan = pelanggan;
        this.kereta = kereta;
        this.totalHarga = kereta.getHargaTiket();
        this.status = "MENUNGGU";
    }
    
    // Getter dan Setter
    public String getIdPemesanan() {
        return idPemesanan;
    }
    
    public void setIdPemesanan(String idPemesanan) {
        this.idPemesanan = idPemesanan;
    }
    
    public double getTotalHarga() {
        return totalHarga;
    }
    
    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public Pelanggan getPelanggan() {
        return pelanggan;
    }
    
    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }
    
    public KeretaApi getKereta() {
        return kereta;
    }
    
    public void setKereta(KeretaApi kereta) {
        this.kereta = kereta;
    }
    
    public Pembayaran getPembayaran() {
        return pembayaran;
    }
    
    public void setPembayaran(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
    }
    
    public Tiket getTiket() {
        return tiket;
    }
    
    public void setTiket(Tiket tiket) {
        this.tiket = tiket;
    }
    
    // Method sesuai class diagram
    public void buatPemesanan() throws KursiPenuhException {
        System.out.println("Membuat pemesanan baru dengan ID: " + idPemesanan);
        
        // Cek ketersediaan kursi
        if (!kereta.cekKetersediaanKursi()) {
            throw new KursiPenuhException("Kursi pada kereta " + kereta.getNamaKereta() + " sudah penuh!");
        }
        
        // Kurangi jumlah kursi tersedia
        kereta.kurangiKursi();
        
        // Update status pemesanan
        this.status = "DIPESAN";
        System.out.println("Pemesanan berhasil dibuat. Status: " + status);
    }
    
    public void batalkanPemesanan() {
        System.out.println("Membatalkan pemesanan dengan ID: " + idPemesanan);
        
        // Kembalikan kursi yang dibatalkan
        if (status.equals("DIPESAN") || status.equals("TERKONFIRMASI")) {
            kereta.tambahKursi(); // Menambah kembali kursi yang telah dikurangi
        }
        
        // Update status pemesanan
        this.status = "DIBATALKAN";
        System.out.println("Pemesanan berhasil dibatalkan. Status: " + status);
    }
    
    @Override
    public String toString() {
        return "Pemesanan " + idPemesanan + " - Status: " + status + " - Total: Rp. " + 
               String.format("%,.2f", totalHarga);
    }
}

// Exception untuk kursi penuh
class KursiPenuhException extends Exception {
    public KursiPenuhException(String pesan) {
        super(pesan);
    }
}