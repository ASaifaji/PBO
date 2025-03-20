// 7. Kelas Admin
public class Admin extends Pengguna{
    private String idAdmin;
    private String username;
    
    public Admin(String idAdmin, String username, String nama, String email) {
        super(nama, email);
        this.idAdmin = idAdmin;
        this.username = username;
    }
    
    // Getter dan Setter
    public String getIdAdmin() {
        return idAdmin;
    }
    
    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    // Method sesuai class diagram
    public void verifikasiPembayaran(Pembayaran pembayaran) {
        System.out.println("Admin " + username + " sedang memverifikasi pembayaran ID: " + 
                          pembayaran.getIdPembayaran());
        
        if (pembayaran.getStatus().equals("BERHASIL")) {
            System.out.println("Pembayaran telah diverifikasi dan valid.");
        } else {
            System.out.println("Pembayaran belum berhasil, silakan coba lagi.");
        }
    }
    
    public void kelolaKeretaApi(KeretaApi kereta) {
        System.out.println("Admin " + username + " sedang mengelola kereta: " + kereta.getNamaKereta());
        System.out.println("Informasi kereta:");
        kereta.tampilkanJadwal();
    }
    
    @Override
    public void tampilkanInfo() {
        System.out.println("Admin: " + nama + " (ID: " + idAdmin + ")");
    }
}