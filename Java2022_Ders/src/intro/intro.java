package intro;

public class intro {
    public static void main(String[] args) {


        System.out.println("Hello World");
        String metin="İlginizi çekebilir";

        System.out.println(metin);


        int vade=12;

        double dolarBugun=18.19;
        double dolarDun=18.23;

        boolean dolarDustuMu = false;

        String okYonu = "down.spg";

        if (dolarBugun<dolarDun) {
            okYonu="down.svg";
            System.out.println(okYonu);
        } else if (dolarBugun>dolarDun) {
            okYonu="up.svg";
            System.out.println(okYonu);
        }
        else{
            okYonu="equal.svg";
            System.out.println(okYonu);
        }


        String[] krediler= {"Hizli Kredi","Maasini Halkbank","Mutlu Emekli","hiphizli kredi"};
        System.out.println(krediler[0]);
        System.out.println(krediler[1]);
        System.out.println(krediler[2]);
        System.out.println(krediler[3]);

        System.out.println("--------------");

        for (int i = 0; i < krediler.length; i++) {
            System.out.println(krediler[i]);
        }
    }
}
