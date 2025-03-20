// Kelas abstrak Pengguna (Superclass untuk Admin & Pelanggan)
abstract class Pengguna {
    protected String nama;
    protected String email;
    
    public Pengguna(String nama, String email) {
        this.nama = nama;
        this.email = email;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public abstract void tampilkanInfo();
}