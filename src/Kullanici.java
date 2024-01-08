import java.util.ArrayList;
import java.util.Map;

public class Kullanici extends Admin{

    private String  isim;
    private String sifre;

    public Kullanici() {
      this.sifre="1926";
    }
    public void kullaniciCalistir(){
        String taninan =linkedHashMapTanima();
         System.out.println("Hoş geldiniz "+ getIsim()+" Usta "+taninan);
    }
       public String linkedHashMapTanima(){
        for(Map.Entry<String, String> entry:SehirlerdenSubeleri.entrySet()){
            if(SubelerdenUstalari.containsKey(entry.getValue())){

                      return entry.getKey() +"\t"+ entry.getValue();

            }
        }
               return  null;

        }



    @Override
    public String getIsim() {
        return isim;
    }

    @Override
    public void setIsim(String isim) {
        this.isim = isim;
    }

    @Override
    public String getSifre() {
        return sifre;
    }

    @Override
    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
}
