import java.util.Scanner;

public class mukemmelSayi {
    public static void main(String[] args) {

        int number = 5,total =0;

        for(int i=1;i<number;i++)
        {
            if (number % i==0)
            {
                total =total+i;
            }
        }

        if (total==number)
            System.out.println("Mukemmel sayi. ");
        else
            System.out.println("Mukemmel sayi degildir. ");

/*
        Scanner scan = new Scanner(System.in);
        int toplam = 0;

        System.out.print("Bir sayi giriniz: ");
        int sayi = scan.nextInt();

        for(int i = 1; i < sayi; i++)
        {
            if(sayi % i == 0) {
                toplam += i;
            }
        }
        if(sayi == toplam) {
            System.out.println(sayi + " Mukemmel  sayidir");
        }
        else {
            System.out.println(sayi + " Mukemmel sayi degildir.");
        }*/
    }
}
