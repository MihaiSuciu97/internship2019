package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AtmsRoute {
    public List<Atm>  getAtmsRoute() throws ParseException {

        List<Atm> finalATMList = new ArrayList<>();
        String pattern = "HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Date date = new Date();
        List<Atm> atms = new ArrayList<>();
        Atm atm1 = new Atm();
        atm1.setId(0);
        date = simpleDateFormat.parse("12:00");
        atm1.setOpeningTime(date);
        date=simpleDateFormat.parse("18:00");
        atm1.setClosingTime(date);
        int[] array1 = {0,40,0,45};
        atm1.setDistance(array1);
        atms.add(atm1);

        Atm atm2=new Atm();
        atm2.setId(1);
        date =simpleDateFormat.parse("10:00");
        atm2.setOpeningTime(date);
        date=simpleDateFormat.parse("17:00");
        atm2.setClosingTime(date);
        int[] array2={0,0,15,0};
        atm2.setDistance(array2);
        atms.add(atm2);

        Atm atm3=new Atm();
        atm3.setId(2);
        date = simpleDateFormat.parse("22:00");
        atm3.setOpeningTime(date);
        date = simpleDateFormat.parse("13:00");
        atm3.setClosingTime(date);
        int[] array3={40,0,0,15};
        atm3.setDistance(array3);
        atms.add(atm3);

        Atm atm4 = new Atm();
        atm4.setId(3);
        date=simpleDateFormat.parse("17:00");
        atm4.setOpeningTime(date);
        date=simpleDateFormat.parse("01:00");
        atm4.setClosingTime(date);
        int[] array4 = {0,30,0,0};
        atm4.setDistance(array4);
        atms.add(atm4);

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
        currentDate.set(2019,03,19,11,30,0);
        System.out.println("Current date : "+ currentDate.getTime());

        int sumafinala= 0;
        int firstDistance[] = {5,60,30,45};

       int first_min=Integer.MAX_VALUE;
       int id=0;
            for(int i=0;i<4;i++) {
                int x = (atms.get(i).getOpeningTime().getHours() * 60 + atms.get(i).getOpeningTime().getMinutes()) -
                        currentDate.get(Calendar.HOUR_OF_DAY) * 60 + currentDate.get(Calendar.MINUTE) - 60;
                if (Integer.max(x, firstDistance[i]) < first_min) {
                    id = i + 1;
                    first_min = Integer.max(x, firstDistance[i]);
                }


            }
        finalATMList.add(atms.get(id));

        sumafinala+=platinumCard.getWithdrawLimit();
        platinumCard.setAvailableAmount(platinumCard.getAvailableAmount()-platinumCard.getWithdrawLimit());
        currentDate.add(Calendar.MINUTE,first_min);

        System.out.println("After first withdraw: "+ currentDate.getTime()+" Current money: "+ sumafinala);

        int steps=1;
        while(sumafinala < 8000){
            steps++;
            int min=Integer.MAX_VALUE;
            int currentId=id;
            int[] distances = atms.get(id-1).getDistance();
            for(int i=0;i<atms.size();i++){
                int x = (atms.get(currentId).getOpeningTime().getHours()*60 + atms.get(currentId).getOpeningTime().getMinutes()) -
                        currentDate.get(Calendar.HOUR_OF_DAY)*60 +currentDate.get(Calendar.MINUTE)-60;
                if(Integer.max(x,distances[i]) < min && id != i){
                    id=i+1;
                    min=Integer.max(x,firstDistance[i]);
                }

            }
            currentDate.add(Calendar.MINUTE,min);
            finalATMList.add(atms.get(currentId));
            if(platinumCard.getAvailableAmount()>0) {
                if (platinumCard.getAvailableAmount() < platinumCard.getWithdrawLimit()) {
                    sumafinala += platinumCard.getAvailableAmount();
                    platinumCard.setAvailableAmount(0);
                } else {
                    sumafinala += platinumCard.getWithdrawLimit();
                    platinumCard.setAvailableAmount(platinumCard.getAvailableAmount() - platinumCard.getWithdrawLimit());
                }
            }
            if(goldCard.getAvailableAmount()>0){
                if(goldCard.getAvailableAmount()<goldCard.getWithdrawLimit()){
                    sumafinala += goldCard.getAvailableAmount()-goldCard.getFee()*goldCard.getAvailableAmount();
                    goldCard.setAvailableAmount(0);
                }
                else{
                    sumafinala+=goldCard.getWithdrawLimit()-goldCard.getFee()*goldCard.getWithdrawLimit();
                    goldCard.setAvailableAmount(goldCard.getAvailableAmount()-goldCard.getWithdrawLimit());
                }
            }
            System.out.println("Step : "+ steps +" "+ currentDate.getTime()+" Current money: "+ sumafinala);
        }

    return finalATMList;

    }
}
