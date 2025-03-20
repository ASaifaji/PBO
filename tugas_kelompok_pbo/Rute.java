// 6. Kelas Rute
public class Rute {
    private String stasiunAsal;
    private String stasiunTujuan;
    private String durasi;
    
    public Rute(String stasiunAsal, String stasiunTujuan, String durasi) {
        this.stasiunAsal = stasiunAsal;
        this.stasiunTujuan = stasiunTujuan;
        this.durasi = durasi;
    }
    
    // Getter dan Setter
    public String getStasiunAsal() {
        return stasiunAsal;
    }
    
    public void setStasiunAsal(String stasiunAsal) {
        this.stasiunAsal = stasiunAsal;
    }
    
    public String getStasiunTujuan() {
        return stasiunTujuan;
    }
    
    public void setStasiunTujuan(String stasiunTujuan) {
        this.stasiunTujuan = stasiunTujuan;
    }
    
    public String getDurasi() {
        return durasi;
    }
    
    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }
    
    // Method sesuai class diagram
    public String hitungDurasi() {
        return durasi;
    }
    
    @Override
    public String toString() {
        return stasiunAsal + " → " + stasiunTujuan + " (" + durasi + ")";
    }
}