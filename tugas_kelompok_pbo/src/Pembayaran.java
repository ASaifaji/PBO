// 4. Kelas Pembayaran
public class Pembayaran {
    private String idPembayaran;
    private String metode;
    private String status;
    private double jumlah;
    private Pemesanan pemesanan;
    
    public Pembayaran(String idPembayaran, String metode, double jumlah, Pemesanan pemesanan) {
        this.idPembayaran = idPembayaran;
        this.metode = metode;
        this.jumlah = jumlah;
        this.pemesanan = pemesanan;
        this.status = "MENUNGGU";
    }
    
    // Getter dan Setter
    public String getIdPembayaran() {
        return idPembayaran;
    }
    
    public void setIdPembayaran(String idPembayaran) {
        this.idPembayaran = idPembayaran;
    }
    
    public String getMetode() {
        return metode;
    }
    
    public void setMetode(String metode) {
        this.metode = metode;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public double getJumlah() {
        return jumlah;
    }
    
    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }
    
    public Pemesanan getPemesanan() {
        return pemesanan;
    }
    
    public void setPemesanan(Pemesanan pemesanan) {
        this.pemesanan = pemesanan;
    }
    
    // Method sesuai class diagram
    public boolean prosesPembayaran() {
        System.out.println("Memproses pembayaran dengan ID: " + idPembayaran);
        System.out.println("Metode pembayaran: " + metode);
        System.out.println("Jumlah: Rp. " + String.format("%,.2f", jumlah));
        
        // Simulasi proses pembayaran (berhasil 90% dari waktu)
        boolean berhasil = Math.random() < 0.9;
        
        if (berhasil) {
            this.status = "BERHASIL";
            System.out.println("Pembayaran berhasil diproses!");
            
            // Update status pemesanan
            if (pemesanan != null) {
                pemesanan.setStatus("TERKONFIRMASI");
                System.out.println("Status pemesanan berubah menjadi: TERKONFIRMASI");
            }
        } else {
            this.status = "GAGAL";
            System.out.println("Pembayaran gagal diproses!");
        }
        
        return berhasil;
    }
    
    public void cekStatusPembayaran() {
        System.out.println("Status pembayaran " + idPembayaran + ": " + status);
        System.out.println("Metode: " + metode);
        System.out.println("Jumlah: Rp. " + String.format("%,.2f", jumlah));
    }
    
    @Override
    public String toString() {
        return "Pembayaran " + idPembayaran + " - Metode: " + metode + " - Status: " + status;
    }
}