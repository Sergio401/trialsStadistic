package test;

import model.Date;
import model.Trial;

public class Main {
    public static void main(String[] args) {
        Date date1 = new Date(12, 4, 21);
        Date date2 = new Date(4, 9, 22);
        Trial trial = new Trial("010", "judicial", date1, date2,"Cualquier cosa");
        System.out.println(trial);
    }
}