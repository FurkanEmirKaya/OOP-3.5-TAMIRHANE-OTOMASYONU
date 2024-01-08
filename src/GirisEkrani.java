import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.SortedMap;

public class GirisEkrani  {
    private String isim;
    Scanner scan = new Scanner(System.in);
    Admin a = new Admin();
    Kullanici k = new Kullanici();
    boolean adminlik; // Admin olarak giriş yapılıp yapılmadığını kontrol eden değişken

    protected void girisEkrani() { // Program başlangıcı.

        System.out.println("Sisteme hoşgeldiniz!");
        sortedHashMapDoldur();
        boolean programiTekrardanBaslat = true;
        do {

            System.out.println("1-Kullanıcı 2-Admin");
            System.out.println("Giriş şeklini seçiniz: ");
            String girdi = scan.nextLine();

            if (girdi.isEmpty()) { // girdi boş mu diye kontrol eder
                System.out.println("Giriş şekli boş olamaz!"); // hata mesajı yazdırır
                continue; // döngüyü devam ettirir
            }

            if (girdi.equals("1") || girdi.equalsIgnoreCase("Kullanıcı")) {
                boolean kullaniciKontrol1;
                do {
                    System.out.println("Kullanıcı adı: ");
                    k.setIsim(scan.nextLine());
                    System.out.println("Sifre:");
                    String sifre = scan.nextLine();
                    //Sortlayan metot
                    if (kullaniciGirisiSortedHashMapKontrol(Admin.SubelerdenUstalari, k.getIsim()) && Objects.equals(k.getSifre(), sifre)) {
                        System.out.println("Sisteme başarılı bir şekilde giriş yaptınız");
                        //HashMap ten bilgiler yazdırılacak
                        adminlik = false;
                        kullaniciKontrol1 = false;
                    } else {

                        System.out.println("Kullanıcı adı veya şifresini yanlış girdiniz");
                        kullaniciKontrol1 = true;
                    }
                } while (kullaniciKontrol1); //Kullanıcının kullanıcı girişini dogru yapıp yapmadığını kontrol eder

            }

            if (girdi.equals("2") || girdi.equalsIgnoreCase("Admin")) { // Admin girişi seçildi.

                boolean kullaniciKontrol;

                do {

                    System.out.print("Admin adı:"); // Kullanıcıdan Admin adı ve şifrenin alınması
                    String isim = scan.nextLine();
                    System.out.print("Admin şifresi:");
                    String sifre = scan.nextLine();

                    if (Objects.equals(isim, a.getIsim()) && Objects.equals(sifre, a.getSifre())) { // Admin adı ve şifre kontrolü

                        System.out.println("Admin olarak sisteme giriş yaptınız!!");
                        adminlik = true;
                        kullaniciKontrol = false;
                    } else {

                        System.out.println("Kullanıcı adı veya şifre hatalı!\nTekrar giriş yapınız!");

                        kullaniciKontrol = true;
                    }
                } while (kullaniciKontrol); // Kullanıcının admin girişini doğru yapıp yapmamasına göre boolean değer döner.

            }

            if (adminlik) { // Eğer kullanıcı doğru giriş yaptıysa adminlik işlemlerine buradan devam ediyor.

                a.adminCalistir(); // Admin arayüzü çalıştırılıyor.
            } else {
                k.kullaniciCalistir();

            }
            System.out.println("Programı tekrar başlatmak ister misiniz?(E/H)");
            String cevap = scan.nextLine();
            if(Objects.equals(cevap, "H")){
                programiTekrardanBaslat = false;
            }
        } while (programiTekrardanBaslat); // Bütün kodlar buraya yazılacak. Bütün kodu bitirme ya da tekrar başlatma için

    }

    public boolean kullaniciGirisiSortedHashMapKontrol(SortedMap<String, String> map, String value){
        for (String values : map.values()) {
            if (values.contains(value)) {
                return true;
            }
        }
        return false;
    }



    public  void sortedHashMapDoldur() { // Program başladığında default txtlerimizden verileri okur ve hashmapleri oluşturur. // Subeler ve Ustlar Hashmapi de yazılacak

        try {

            BufferedReader sehirReader = new BufferedReader(new FileReader("Sehirler.txt"));
            BufferedReader subeReader = new BufferedReader(new FileReader("Subeler.txt"));

            String sehirline;
            while ((sehirline = sehirReader.readLine()) != null) { // Sekiz satırlık default txt sayacı
                ArrayList<String> subeler = new ArrayList<>();
                for (int i = 0; i < 3; i++) { // Üç satır okuyup subeler ArrayListine her bir satırı ekliyor.
                    String subeLine = subeReader.readLine();
                    if (subeLine != null) {
                        subeler.add(i,subeLine);
                    }
                    a.SehirlerdenSubeleri.put(sehirline, subeler.get(i));
                }

            }
                         /*

                         ÇAĞIRMA FONKSİYONLARI

                         System.out.println(a.SehirlerdenSubeleri.keySet());
                         System.out.println(a.SehirlerdenSubeleri.values());

                         System.out.println();

                         System.out.println(a.SehirlerdenSubeleri.get("İstanbul"));
                         System.out.println(a.SehirlerdenSubeleri.get("Erzurum"));
                         System.out.println(a.SehirlerdenSubeleri.get("Samsun"));


                          */
        } catch (IOException e) {

            throw new RuntimeException(e);

        }

        try {

            BufferedReader subeReader = new BufferedReader(new FileReader("Subeler.txt"));
            BufferedReader ustaReader = new BufferedReader(new FileReader("Ustalar.txt"));

            String subeline;
            while ((subeline = subeReader.readLine()) != null) { // Sekiz satırlık default txt sayacı
                ArrayList<String> ustalar = new ArrayList<>();
                for (int i = 0; i < 2; i++) { // Üç satır okuyup subeler ArrayListine her bir satırı ekliyor.
                    String ustaLine = ustaReader.readLine();
                    if (ustaLine != null) {
                        ustalar.add(i,ustaLine);
                    }
                    a.SubelerdenUstalari.put(subeline, ustalar.get(i));
                }

            }
                            /*
                System.out.println(a.SehirlerdenSubeleri.keySet());
                System.out.println(a.SehirlerdenSubeleri.values());

                System.out.println();

                System.out.println(a.SehirlerdenSubeleri.get("Ardahan"));
                System.out.println(a.SehirlerdenSubeleri.get("Erzurum"));
                System.out.println(a.SehirlerdenSubeleri.get("Samsun"));

                System.out.println(a.SehirlerdenSubeleri.keySet());
                System.out.println(a.SehirlerdenSubeleri.values());

                System.out.println();

                System.out.println(a.SubelerdenUstalari.get("Nilüfer"));
                System.out.println(a.SubelerdenUstalari.get("Buca"));
                System.out.println(a.SubelerdenUstalari.get("Atakum"));
                */
        } catch (IOException e) {

            throw new RuntimeException(e);

        }


    }



    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }







}
