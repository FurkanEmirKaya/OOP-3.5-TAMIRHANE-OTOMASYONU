import java.util.ArrayList;

public interface DosyaIslemleri {
    void dosyaOkuVeTxtEkranaYazdir(String dosyaAdi); // TXT dosyasındaki verileri okuyup TXT'yi olduğu gibi ekrana yazdıran metot
    void dosyaOkuVeArrayListeEkle(String dosyaAdi); // TXT dosyasındaki verileri okuyup TXT'deki verileri ArrayList'e ekleyen metot
    void arrayListEkranaYazdir(); // Sadece ArrayList'i ekrana yazdıran metot
    void txtDosyasinaEkle(String dosyaAdi, String eklenecekVeri); // TXT dosyasına veriyi ekleyen metot
    String dosyaOkuVeReturnle(String dosyaAdi); // TXT dosyasındaki verileri satır satır okur ve değeri return eder metot.
    void linkedHashMapEkle(String mapeEklenecekSehir, String mapeEklenecekSube, String mapeEklenecekUsta); // LinkedHashMape gelen parametreyle LinkedHashMap oluşturan metot.
}
