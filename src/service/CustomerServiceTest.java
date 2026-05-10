package service;

import model.Customer;


public class CustomerServiceTest {

    public static void main(String[] args) throws Exception {
        CustomerService service = new CustomerService();

        Customer josh = service.addCustomer(
                "Josh", "Rizal", "jkr@email.com"
                );
        Customer kevin = service.addCustomer(
                "Kevin", "Rizal", "kev@email.com"
                );
        Customer phil = service.addCustomer(
                 "Phil", "Rizal", "phil@email.com"
        );

        System.out.println(
                CustomerService.getCustomer("kev@email.com").toString()
        );


    }

}
