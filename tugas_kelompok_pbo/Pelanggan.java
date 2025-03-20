// 1. Kelas Pelanggan
public class Pelanggan extends Pengguna{
    private String noTelepon;
    
    public Pelanggan(String nama, String email, String noTelepon) {
        super(nama, email);
        this.noTelepon = noTelepon;
    }
    
    public String getNoTelepon() {
        return noTelepon;
    }
    
    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }
    
    // Method sesuai class diagram
    public void cariJadwal() {
        System.out.println("Pelanggan " + nama + " sedang mencari jadwal kereta...");
    }
    
    public void pesanTiket() {
        System.out.println("Pelanggan " + nama + " sedang memesan tiket...");
    }
    
    public void bayarTiket() {
        System.out.println("Pelanggan " + nama + " sedang melakukan pembayaran tiket...");
    }
    
    @Override
    public void tampilkanInfo() {
        System.out.println("Pelanggan: " + nama + " (" + email + ", " + noTelepon + ")");
    }
}