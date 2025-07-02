
    public class CurrentAccount extends Account {
    double overdraftLimit;

    CurrentAccount(String accountNumber,String accountHolderName,double balance){
        super(accountNumber, accountHolderName, balance);
        this.overdraftLimit=5000.0;

    }

    public void deposit(double amount){
        double total=amount+getBalance();
        setBalance(total);

    }

    public void withdraw(double amount){
        if(amount<=getBalance()){
            double total=getBalance()-amount;
            setBalance(total);
        }
        else if(amount>getBalance() && (amount-getBalance()<overdraftLimit)){
            double total=getBalance()-amount;
            setBalance(total);
         }
         else{
            System.out.println("Overdraft limit exceeded in Current Account.");
         } 


    }
     @Override
   public void displayAccoutDetails(){
    super.displayAccoutDetails();
    System.out.println("new balance after: "+getBalance());
   }

    
}

    


    

