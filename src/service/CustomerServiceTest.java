package service;

import model.Customer;


public class CustomerServiceTest {

    public static CustomerServiceTest customerServiceTestInstance = new CustomerServiceTest();

    static CustomerService service = CustomerService.customerServiceInstance;

    public static void populateCustomers() throws Exception {
        Customer josh = service.addCustomer(
                "Josh", "Rizal", "jkr@email.com"
        );
        Customer kevin = service.addCustomer(
                "Kevin", "Rizal", "kev@email.com"
        );
        Customer phil = service.addCustomer(
                "Phil", "Rizal", "phil@email.com"
        );

    }

    public static void main(String[] args) throws Exception {

        populateCustomers();
        System.out.println(
                service.getCustomer("kev@email.com").toString()
        );


    }

}
