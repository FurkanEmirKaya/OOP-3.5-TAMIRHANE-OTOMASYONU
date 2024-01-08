import java.util.ArrayList;

public interface DosyaIslemleri {
    void dosyaOkuVeTxtEkranaYazdir(String dosyaAdi); // TXT dosyasındaki verileri okuyup TXT'yi olduğu gibi ekrana yazdıran metot
    void txtDosyasinaEkle(String dosyaAdi, String eklenecekVeri); // TXT dosyasına veriyi ekleyen metot
    void linkedHashMapEkle(String mapeEklenecekSehir, String mapeEklenecekSube, String mapeEklenecekUsta); // LinkedHashMape gelen parametreyle LinkedHashMap oluşturan metot.
}
