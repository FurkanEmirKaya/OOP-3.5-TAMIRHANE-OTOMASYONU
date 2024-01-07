import java.util.ArrayList;

public interface DosyaIslemleri {
    void dosyaOkuVeTxtEkranaYazdir(String dosyaAdi); // TXT dosyasındaki verileri okuyup TXT'yi olduğu gibi ekrana yazdıran metot
    void dosyaOkuVeArrayListeEkle(); // TXT dosyasındaki verileri okuyup TXT'deki verileri ArrayList'e ekleyen metot
    void arrayListEkranaYazdir(); // Sadece ArrayList'i ekrana yazdıran metot
    void txtDosyasinaEkle(String dosyaAdi, String eklenecekVeri); // TXT dosyasına veriyi ekleyen metot
    String dosyaOkuVeReturnle(String dosyaAdi); // TXT dosyasındaki verileri satır satır okur ve değeri return eder metot.
    void LinkedHashMapeEkle(String key, ArrayList<String> values); // LinkedHashMape gelen parametreyle LinkedHashMap oluşturan metot.
}
