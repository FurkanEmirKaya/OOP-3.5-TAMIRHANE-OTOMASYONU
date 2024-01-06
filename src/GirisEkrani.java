import java.util.Scanner;

public class GirisEkrani implements KontrolMetodlari{
    Scanner scan = new Scanner(System.in);
    protected  void girisEkrani(){
        System.out.println("Sisteme hoşgeldiniz!");
        do{
            System.out.println("1-Kullanıcı 2-Admin");
            System.out.println("Giriş şeklini seçiniz: ");
            girdiKontrol(scan.nextLine()); // Kullanıcıdan gelen girdiyi kontrol eden metod
        }while (true);
    }


    @Override
    public void girdiKontrol(String girdi) {
        if(girdi.equals("1") || girdi.equalsIgnoreCase("Kullanıcı")){
            // Kullanıcı metotları gelecek
        }
        else if(girdi.equals("2") || girdi.equalsIgnoreCase("Admin")){
            // Admin metotları gelecek
        }
    }

    @Override
    public boolean booleanKontrol() {
        return false;
    }
}
