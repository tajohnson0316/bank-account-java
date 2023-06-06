public class TestBankAccount {
  public static void main(String[] args) {
    BankAccount account1 = new BankAccount();

    account1
      .checkingDeposit(100.00)
      .checkingWithdrawal(50.0)
      .savingsDeposit(1000)
      .savingsWithdrawal(100.05)
      .checkingWithdrawal(500)
      .viewAccountBalance();
  }
}
