import org.junit.Test;
import static org.junit.Assert.*;

public class AddTest {
@Test
public void testDeposit() {
    Add account = new Add("12345", 1000.0);
    
    // Deposit a valid amount
    double newBalance = account.deposit(500.0);
    assertEquals(1500.0, newBalance, 0.001);  // Assert the balance after deposit

    // Deposit an invalid amount (negative value)
    try {
        account.deposit(-200.0);
        fail("Exception not thrown for negative deposit.");
    } catch (IllegalArgumentException e) {
        assertEquals("Deposit amount must be positive.", e.getMessage());
    }
}
@Test
public void testWithdraw() {
   Add account = new Add("12345", 1000.0);
    
    // Withdraw a valid amount
    double newBalance = account.withdraw(500.0);
    assertEquals(500.0, newBalance, 0.001);  // Assert the balance after withdrawal

    // Withdraw an invalid amount (negative value)
    try {
        account.withdraw(-100.0);
        fail("Exception not thrown for negative withdrawal.");
    } catch (IllegalArgumentException e) {
        assertEquals("Withdrawal amount must be positive.", e.getMessage());
    }

    // Withdraw an amount greater than balance
    try {
        account.withdraw(600.0);
        fail("Exception not thrown for insufficient funds.");
    } catch (IllegalArgumentException e) {
        assertEquals("Insufficient balance.", e.getMessage());
    }
}

@Test
public void testBalanceInquiry() {
    Add account = new Add("12345", 1000.0);

    // Check balance after initialization
    assertEquals(1000.0, account.getBalance(), 0.001);

    // Perform a deposit and check balance
    account.deposit(200.0);
    assertEquals(1200.0, account.getBalance(), 0.001);

    // Perform a withdrawal and check balance
    account.withdraw(300.0);
    assertEquals(900.0, account.getBalance(), 0.001);
}
@Test
public void testTransactionHistory() {
    Add account = new Add("12345", 1000.0);
    
    // Deposit and check transaction history
    account.deposit(500.0);
    assertEquals(2, account.getTransactionHistory().size());  // Initial creation + 1 deposit
    assertTrue(account.getTransactionHistory().contains("Deposited: 500.0"));
    
    // Withdraw and check transaction history
    account.withdraw(200.0);
    assertEquals(3, account.getTransactionHistory().size());  // 2 transactions + 1 withdrawal
    assertTrue(account.getTransactionHistory().contains("Withdrew: 200.0"));
    
    // Ensure correct order of transactions
    assertEquals("Account created with initial balance: 1000.0", account.getTransactionHistory().get(0));
    assertEquals("Deposited: 500.0", account.getTransactionHistory().get(1));
    assertEquals("Withdrew: 200.0", account.getTransactionHistory().get(2));
}

   
}
i