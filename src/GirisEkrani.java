import java.util.Objects;
import java.util.Scanner;

public class GirisEkrani implements KontrolMetodlari{
    Scanner scan = new Scanner(System.in);
    Admin a = new Admin();
    protected  void girisEkrani(){
        System.out.println("Sisteme hoşgeldiniz!");

        do {
            System.out.println("1-Kullanıcı 2-Admin");
            System.out.println("Giriş şeklini seçiniz: ");
            String girdi = scan.nextLine();
            if (girdi.equals("1") || girdi.equalsIgnoreCase("Kullanıcı")) {

            } else if (girdi.equals("2") || girdi.equalsIgnoreCase("Admin")) {
                boolean c1 = true;
                do {
                    System.out.println("Admin :");
                    String isim = scan.nextLine();
                    System.out.println("Sifre :");
                    String sifre = scan.nextLine();
                    if (isim == a.getIsim() || sifre == a.getSifre()) {
                        System.out.println("Admin olarak sisteme giriş yaptınız!!");
                        c1 = false;
                    } else {
                        System.out.println("Kullanıcı adı veya şifre hatalı!\nTekrar giriş yapınız!");
                        c1 = true;
                    }
                } while (c1);
            }
        }while (true) ;
    }




    @Override
    public void girdiKontrol(String girdi) {


}

    @Override
    public boolean booleanKontrol() {
        return false;
    }
}
