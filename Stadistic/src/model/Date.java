package model;

public class Date {
    private final int day, month, year;

    public Date(int day, int month, int year){

        if(month > 0 && month < 13) {
            this.month = month;
        } else {
            throw new IllegalArgumentException("El valor de mes debe corresponder de 0-12");
        }

        if (month == 1 || month == 3
            || month == 5 || month == 7
            || month == 8 || month == 10 || month == 12) {
            if (day <= 31) {
                this.day = day;
            } else {
                throw new IllegalArgumentException("Este mes tiene 31 dias");
            }
        } else if (month == 4 || month == 6
                || month == 9 || month == 11) {
            if (day <= 30) {
                this.day = day;
            } else {
                throw new IllegalArgumentException("Este mes tiene 30 dias");
            }
        } else {
            if (day <= 29) {
                this.day = day;
            } else {
                throw new IllegalArgumentException("Este mes tiene 28 dias");
            }
        }

        if(year > 1900 && year < 2100) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("El valor de mes debe corresponder de 1900-2100");
        }
    }

    public static boolean isCloseDateBiggerStartDate(String arrivalDateString, String closeDateString){
        String[] startDate = arrivalDateString.split("/");
        String[] closeDate = closeDateString.split("/");
        boolean isBigger;

        if(Integer.parseInt(startDate[2]) <= Integer.parseInt(closeDate[2])){
            if(Integer.parseInt(startDate[1]) <= Integer.parseInt(closeDate[1])){
                isBigger = Integer.parseInt(startDate[0]) <= Integer.parseInt(closeDate[0]);
            } else {isBigger =false;}
        } else {isBigger = false;}

        return isBigger;
    }

    public String toString() {
        return day + "/" + month + "/" + year ;
    }
}
