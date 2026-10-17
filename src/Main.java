import java.util.function.Predicate;

import model.Customer;
import service.ReservationService;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        Customer j = new Customer("Josh", "Rizal", "jkrs@domain.com");
//        Customer jb = new Customer("Josh", "Rizal", "jkr@mail.betlogshorts");

        ReservationService rs = new ReservationService();
        System.out.println(rs.toString());


    }


}