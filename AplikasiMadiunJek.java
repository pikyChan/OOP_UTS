abstract class LayananTransportasi {
    protected String namaDriver; 
    protected double jarak; 
    protected double saldoUser; 

    public LayananTransportasi(String namaDriver, double jarak, double saldoUser) {
        this.namaDriver = namaDriver;
          if (jarak <= 0) {
            this.jarak = 1.0;
        } else {
            this.jarak = jarak;
        }
        this.saldoUser = saldoUser;
    }

    public abstract double hitungTarif();
    public abstract void prosesTransaksi(); 
}
class MadiunMotor extends LayananTransportasi {
    public MadiunMotor(String namaDriver, double jarak, double saldoUser) {
        super(namaDriver, jarak, saldoUser);
    }

    @Override
    public double hitungTarif() {
        return this.jarak * 2500; 
    }

    @Override
    public void prosesTransaksi() {

        System.out.println("=== Transaksi oleh Indah Ayu Astuti - 254311002 ===");
        double totalTarif = hitungTarif();
        if (this.saldoUser >= totalTarif) {
            System.out.println("Detail Transaksi (Motor):");
            System.out.println("Driver      : " + this.namaDriver);
            System.out.println("Jarak       : " + this.jarak + " km");
            System.out.println("Total Bayar : Rp " + totalTarif);
            System.out.println("Sisa Saldo  : Rp " + (this.saldoUser - totalTarif));
        } else {
            System.out.println("Gagal: Saldo tidak mencukupi untuk perjalanan ini!"); 
        }
        System.out.println("----------------------------------------------");
    }
}

class MadiunMobil extends LayananTransportasi {
    public MadiunMobil(String namaDriver, double jarak, double saldoUser) {
        super(namaDriver, jarak, saldoUser);
    }

    @Override
    public double hitungTarif() {
        double biayaAdmin = 3000 + (2 * 100); 
        return (this.jarak * 5000) + biayaAdmin; 
    }

    @Override
    public void prosesTransaksi() {
        System.out.println("=== Transaksi oleh Indah Ayu Astuti - 254311002 ===");
        double totalTarif = hitungTarif();
        if (this.saldoUser >= totalTarif) {
            System.out.println("Detail Transaksi (Mobil):");
            System.out.println("Driver      : " + this.namaDriver);
            System.out.println("Jarak       : " + this.jarak + " km");
            System.out.println("Total Bayar : Rp " + totalTarif);
            System.out.println("Sisa Saldo  : Rp " + (this.saldoUser - totalTarif));
        } else {
            System.out.println("Gagal: Saldo tidak mencukupi untuk perjalanan ini!");
        }
        System.out.println("----------------------------------------------");
    }
}

public class AplikasiMadiunJek {
    public static void main(String[] args) {
        LayananTransportasi[] daftarLayanan = new LayananTransportasi[2];

        daftarLayanan[0] = new MadiunMotor("Alpi", 10, 50000);
        daftarLayanan[1] = new MadiunMobil("Isma", 15, 100000);

        for (LayananTransportasi layanan : daftarLayanan) {
            layanan.prosesTransaksi(); 
        }
    }
}
