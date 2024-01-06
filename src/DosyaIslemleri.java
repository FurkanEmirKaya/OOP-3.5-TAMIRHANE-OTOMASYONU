public interface DosyaIslemleri {
    void dosyaOkuVeTxtEkranaYazdir(String dosyaAdi); // TXT dosyasındaki verileri okuyup TXT'yi olduğu gibi ekrana yazdıran metot
    void dosyaOkuVeArrayListeEkle(); // TXT dosyasındaki verileri okuyup TXT'deki verileri ArrayList'e ekleyen metot
    void arrayListEkranaYazdir(); // Sadece ArrayList'i ekrana yazdıran metot
    void txtDosyasinaEkle(); // TXT dosyasına veriyi ekleyen metot
}
