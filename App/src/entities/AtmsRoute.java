package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AtmsRoute {
    public void getAtmsRoute() throws ParseException {
        String pattern = "HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Date date = new Date();

        Atm atm1 = new Atm();
        date = simpleDateFormat.parse("12:00");
        atm1.setOpeningTime(date);
        date=simpleDateFormat.parse("18:00");
        atm1.setClosingTime(date);

        Atm atm2=new Atm();
        date =simpleDateFormat.parse("10:00");
        atm2.setOpeningTime(date);
        date=simpleDateFormat.parse("17:00");
        atm2.setClosingTime(date);

        Atm atm3=new Atm();
        date = simpleDateFormat.parse("22:00");
        atm3.setOpeningTime(date);
        date = simpleDateFormat.parse("13:00");
        atm3.setClosingTime(date);

        Atm atm4 = new Atm();
        date=simpleDateFormat.parse("17:00");
        atm4.setOpeningTime(date);
        date=simpleDateFormat.parse("01:00");
        atm4.setClosingTime(date);

        CreditCard silverCard = new CreditCard();
        silverCard.setFee(0.2f);
        silverCard.setWithdrawLimit(2000);
        Date date1 = new Date(2020,05,23);
        silverCard.setExpirationDate(date1);
        silverCard.setAvailableAmount(20000);

        CreditCard goldCard = new CreditCard();
        goldCard.setFee(0.1f);
        goldCard.setWithdrawLimit(2000);
        date1=new Date(2018,8,15);
        goldCard.setExpirationDate(date1);
        goldCard.setAvailableAmount(25000);

        CreditCard platinumCard=new CreditCard();
        platinumCard.setFee(0f);
        platinumCard.setWithdrawLimit(2000);
        date1= new Date(2019,03,20);
        platinumCard.setExpirationDate(date1);
        platinumCard.setAvailableAmount(3000);

        Calendar currentDate = GregorianCalendar.getInstance();
        currentDate.set(2019,03,19,11,13);
        //System.out.println(currentDate.getTime());




        System.out.println(currentDate);


    }
}
