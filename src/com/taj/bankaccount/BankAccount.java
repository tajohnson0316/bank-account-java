package com.taj.bankaccount;

public class BankAccount {
  private double checkingBalance;
  private double savingsBalance;
  private final long accountNumber;

  private static int totalAccounts = 0;
  private static double totalMoney = 0.0;

  // Constructors
  public BankAccount() {
    this.checkingBalance = 0.0;
    this.savingsBalance = 0.0;
    this.accountNumber = generateAccountNumber();

    totalAccounts++;

    System.out.print("Account creation successful!\nAccount Info:\n");
    this.viewAccountBalance();
  }

  public BankAccount(double initialChecking, double initialSaving) {
    this.checkingBalance = initialChecking;
    this.savingsBalance = initialSaving;
    this.accountNumber = generateAccountNumber();

    totalAccounts++;
    totalMoney += initialChecking + initialSaving;

    System.out.println("Account creation successful!\nAccount Info:");
    this.viewAccountBalance();
  }

  // Getters
  public double getCheckingBalance() {
    return this.checkingBalance;
  }

  public double getSavingsBalance() {
    return this.savingsBalance;
  }

  // Deposits
  public BankAccount checkingDeposit(double depositAmount) {
    if (depositAmount <= 0) {
      System.out.println("Please deposit a non-negative, non-zero amount.\n");
      return this;
    }

    System.out.printf(
      "Deposit successful!%n" +
        "Previous checking balance: $%0,3.2f%n" +
        "New checking balance: $%0,3.2f%n%n",
      this.checkingBalance, this.checkingBalance + depositAmount
    );

    this.checkingBalance += depositAmount;
    totalMoney += depositAmount;

    return this;
  }

  public BankAccount savingsDeposit(double depositAmount) {
    if (depositAmount <= 0) {
      System.out.println("Please deposit a non-negative, non-zero amount.\n");
      return this;
    }

    System.out.printf(
      "Deposit successful!%n" +
        "Previous savings balance: $%0,3.2f%n" +
        "New savings balance: $%0,3.2f%n%n",
      this.savingsBalance, this.savingsBalance + depositAmount
    );

    this.savingsBalance += depositAmount;
    totalMoney += depositAmount;

    return this;
  }

  // Withdrawals
  public BankAccount checkingWithdrawal(double withdrawalAmount) {
    if (withdrawalAmount <= 0) {
      System.out.println("Please withdraw a non-negative, non-zero amount.\n");
      return this;
    } else if (withdrawalAmount > this.checkingBalance) {
      System.out.println("Unable to complete withdrawal - INSUFFICIENT FUNDS. Please try again.");
      System.out.printf("Current checking balance: $%0,3.2f%n%n", this.checkingBalance);
      return this;
    }

    System.out.printf(
      "Withdrawal successful!%n" +
        "Previous checking balance: $%0,3.2f%n" +
        "New checking balance: $%0,3.2f%n%n",
      this.checkingBalance, this.checkingBalance - withdrawalAmount
    );

    this.checkingBalance -= withdrawalAmount;
    totalMoney -= withdrawalAmount;

    return this;
  }

  public BankAccount savingsWithdrawal(double withdrawalAmount) {
    if (withdrawalAmount <= 0) {
      System.out.println("Please withdraw a non-negative, non-zero amount.\n");
      return this;
    } else if (withdrawalAmount > this.savingsBalance) {
      System.out.println("Unable to complete withdrawal - INSUFFICIENT FUNDS. Please try again.");
      System.out.printf("Current savings balance: $%0,3.2f%n%n", this.savingsBalance);
      return this;
    }

    System.out.printf(
      "Withdrawal successful!%n" +
        "Previous savings balance: $%0,3.2f%n" +
        "New savings balance: $%0,3.2f%n%n",
      this.savingsBalance, this.savingsBalance - withdrawalAmount
    );

    this.savingsBalance -= withdrawalAmount;
    totalMoney -= withdrawalAmount;

    return this;
  }

  // View Account
  public void viewAccountBalance() {
    System.out.println("ACCOUNT INFO\n" +
      "--------------------");
    System.out.printf(
      "ACCOUNT NUMBER: %d%n" +
        "CHECKING BALANCE: $%0,3.2f%n" +
        "SAVINGS BALANCE: $%0,3.2f%n%n",
      this.accountNumber, this.checkingBalance, this.savingsBalance);
  }

  // Util
  private static long generateAccountNumber() {
    return (long) (Math.random() * 10000000000L);
  }
}
