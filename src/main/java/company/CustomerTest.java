package company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;



public class CustomerTest
{
    private AccountRecord createAccountRecord(int charge) {
        AccountRecord accountRecord = new AccountRecord();
        accountRecord.setCharge(charge);
        return accountRecord;
    }

    @Test
    public void testGetBalanceWithNoCharges() {
        // Create a customer with no charges
        Customer customer = new Customer();
        assertEquals(0, customer.getBalance());
    }
    @Test
    public void testGetBalanceWithCharges() {
        // Create a customer with charges
        Customer customer = new Customer();
        customer.getCharges().add(createAccountRecord(-50));
        customer.getCharges().add(createAccountRecord(500));
        customer.getCharges().add(createAccountRecord(-20));
        assertEquals(430, customer.getBalance());
    }

    @Test
    public void testToString() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Wayne Enterprises");

        String expected = " [ \"1\",  \"Wayne Enterprises\", \"0\" ]";
        String actual = customer.toString();

        assertEquals(expected, actual);
    }
}