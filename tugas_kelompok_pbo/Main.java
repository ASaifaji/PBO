// 8. Kelas Main untuk demonstrasi
public class Main {
    public static void main(String[] args) {
        System.out.println("===== SISTEM PEMESANAN TIKET KERETA API =====\n");
        
        try {
            // Buat objek KeretaApi
            KeretaApi argowilis = new KeretaApi(
                "Argo Wilis", 
                "Jakarta", 
                "Bandung", 
                "08:00", 
                "11:30", 
                50, 
                150000.0
            );
            
            // Tampilkan jadwal kereta
            System.out.println("Informasi Jadwal Kereta:");
            argowilis.tampilkanJadwal();
            
            // Buat pelanggan
            Pelanggan budi = new Pelanggan("Budi Santoso", "budi@example.com", "081234567890");
            System.out.println("\nInformasi Pelanggan:");
            System.out.println(budi);
            
            // Pelanggan mencari jadwal
            budi.cariJadwal();
            
            // Buat pemesanan
            System.out.println("\nProses Pemesanan:");
            Pemesanan pemesanan1 = new Pemesanan("P001", budi, argowilis);
            pemesanan1.buatPemesanan();
            
            // Buat pembayaran
            System.out.println("\nProses Pembayaran:");
            Pembayaran pembayaran1 = new Pembayaran("B001", "Transfer Bank", pemesanan1.getTotalHarga(), pemesanan1);
            pemesanan1.setPembayaran(pembayaran1);
            
            // Proses pembayaran
            pembayaran1.prosesPembayaran();
            
            // Buat tiket jika pembayaran berhasil
            if (pembayaran1.getStatus().equals("BERHASIL")) {
                System.out.println("\nPembuatan Tiket:");
                Tiket tiket1 = new Tiket("T001", argowilis, budi.getNama(), argowilis.getHargaTiket());
                pemesanan1.setTiket(tiket1);
                
                // Tampilkan detail tiket
                tiket1.tampilkanDetail();
                
                // Cetak tiket
                System.out.println("\nCetak Tiket:");
                tiket1.cetakTiket();
            }

            // Buat Admin
            Admin admin = new Admin("A001", "adminSistem", "Jordi", "jojo92@gmail.com");
            
            // Admin memverifikasi pembayaran
            System.out.println("\nVerifikasi Admin:");
            admin.verifikasiPembayaran(pembayaran1);
            
            // Cek status pemesanan
            System.out.println("\nStatus Akhir Pemesanan:");
            System.out.println(pemesanan1);
            
            // Contoh Kursi Penuh Exception
            System.out.println("\nContoh Exception Handling - Kursi Penuh:");
            KeretaApi keretaPenuh = new KeretaApi("Kereta Penuh", "Jakarta", "Surabaya", "10:00", "18:00", 0, 200000.0);
            Pemesanan pemesanan2 = new Pemesanan("P002", budi, keretaPenuh);
            pemesanan2.buatPemesanan(); // Akan memunculkan exception
            
        } catch (KursiPenuhException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Silakan pilih kereta lain atau jadwal berbeda.");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}