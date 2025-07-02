
    abstract public class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    //constructor 

    Account(String accountNumber,String accountHolderName,double balance){
        this.accountNumber=accountNumber;
         this.accountHolderName=accountHolderName;
         this.balance=balance;
    }

    //abstract methods these would be implemented later in the child classes where they will have the actual use case

   abstract public void withdraw(double amount);
   abstract public void deposit(double amount);

   public void setBalance(double balance){
    this.balance=balance;
   }

   //getter methods

   public String getAccountNumber(){
    return accountNumber;
   }
   public String getAccountHolderName(){
    return accountHolderName;
   }
   public double getBalance(){
    return balance;
   }

   public void displayAccoutDetails(){
    System.out.println("account number: "+accountNumber);
    System.out.println("name of the account holder: "+accountHolderName);
    System.out.println("current balance: "+balance);
   }
}

    

