import entities.Atm;
import entities.AtmsRoute;
import entities.CreditCard;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String args[]){

        // I know it's not finished. But I uploaded it because I think that the idea matters.

        AtmsRoute atmsRoute = new AtmsRoute();
        List<Atm> atmList = new ArrayList<>();
        try {
            atmList = atmsRoute.getAtmsRoute();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
