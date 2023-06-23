package company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args)
    {
        //Update this
        //Instantiates the new list (a set to keep the unique customers, positives and negatives )
        List<Customer> uniqueCustomers = new ArrayList<>();
        List<Customer> positiveCustomers = new ArrayList<>();
        List<Customer> negativeCustomers = new ArrayList<>();

        //iterate through the data
        for (String[] data : customerData)
        {
            int C_Id = Integer.parseInt(data[0]);
            String C_Name = data[1];
            int C_Balance = Integer.parseInt(data[2]);

            //create a customer object
            Customer customer = new Customer();
            customer.setId(C_Id);
            customer.setName(C_Name);

            //check if customer is unique
            boolean exists = false;
            for (Customer existingCust : uniqueCustomers)
            {
                if (existingCust.getId() == C_Id)
                {
                    // update the customer reference to point to the existing customer object
                    customer = existingCust;
                    exists = true;
                    break;
                }
            }
            if (!exists)
            {
                //populate uniqueCustomer list if the ID is unique
                uniqueCustomers.add(customer);
            }

            //create AccountRecordObject
            AccountRecord accountRecord = new AccountRecord();
            accountRecord.setCharge(C_Balance);
            accountRecord.setChargeDate(data[3]);
            //populate the charges list for each customer with the corresponding account records
            customer.getCharges().add(accountRecord);
            accountRecord.getChargeDate();

            // Determine if the account balance is positive or negative
            if (C_Balance > 0)
            {
                //create a separate customer object
                Customer positiveCustomer = new Customer();
                positiveCustomer.setId(C_Id);
                positiveCustomer.setName(C_Name);
                positiveCustomer.getCharges().add(accountRecord);
                positiveCustomers.add(positiveCustomer);


            } else if (C_Balance < 0)
            {
                //create a separate customer object
                Customer negativeCustomer = new Customer();
                negativeCustomer.setId(C_Id);
                negativeCustomer.setName(C_Name);
                negativeCustomer.getCharges().add(accountRecord);
                negativeCustomers.add(negativeCustomer);

            }

        }

        //print out the lists
        System.out.println("Customer Information: ");
        for(Customer customer: uniqueCustomers){
            System.out.println(customer);
        }
        System.out.println("Positive accounts:");
        for (Customer customer : positiveCustomers) {
            //System.out.println(customer);
            for (AccountRecord record : customer.getCharges()) {
                System.out.println(customer+ "[ \""+ record.getChargeDate()+ "\" ]");
            }
        }
        System.out.println("Negative accounts:");
        for (Customer customer : negativeCustomers) {
            //System.out.println(customer);
            for (AccountRecord record : customer.getCharges()) {
                System.out.println(customer+ "[ \""+ record.getChargeDate() + "\" ]");
            }
        }

    }
}
