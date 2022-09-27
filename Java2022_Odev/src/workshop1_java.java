public class workshop1_java {
    public static void main(String[] args) {

        int [] sayilar = new int[]{1,2,5,7,9,0};

        int aranacak = 9;
        boolean varMi = sayiBul(sayilar,aranacak); //true

        mesajVer(varMi,aranacak);
    }
    public static void mesajVer(boolean varMi,int aranacak)
    {
        String mesaj = "";
        if (varMi == true)
        {
            mesaj = "Sayi mevcuttur: " + aranacak;
            System.out.println(mesaj);
        }
        else
        {
            mesaj = "Sayi mevcut degildir: " + aranacak;
            System.out.println(mesaj);
        }
    }
    public static boolean sayiBul(int[] sayilar, int aranacak)
    {
        boolean varMi = false;
        for (int sayi : sayilar)
        {
            if (sayi == aranacak)
            {
                varMi = true;
                break;
            }
        }
        return varMi;
    }
}
