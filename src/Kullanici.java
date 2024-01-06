public class Kullanici extends Admin{

    public Kullanici(String isim, String sifreler) {
        super(isim, sifreler);
        isim = "sadfa";
        System.out.println(isim);
        System.out.println(sifreler);
    }
}
