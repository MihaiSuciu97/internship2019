import entities.Atm;
import entities.AtmsRoute;
import entities.CreditCard;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String args[]){
        AtmsRoute atmsRoute = new AtmsRoute();
        try {
            atmsRoute.getAtmsRoute();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
