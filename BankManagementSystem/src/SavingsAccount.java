
public class SavingsAccount extends Account {
    double interestRate;

    SavingsAccount(String accountNumber,String accountHolderName,double balance){
        super(accountNumber, accountHolderName, balance);
        this.interestRate=0.03;

    }

    public void deposit(double amount){
        double interest=interestRate*getBalance();
        double totalBalance=getBalance()+interest+amount;
        setBalance(totalBalance);//balance updated
         }
     
    public void withdraw(double amount){
        if(amount<getBalance()){
            System.out.println("insufficient balance");
        }
        else{
            double leftover=getBalance()-amount;
            setBalance(leftover);
        }

    }

   @Override
   public void displayAccoutDetails(){
    super.displayAccoutDetails();
    System.out.println("new balance after: "+getBalance());
   }
}
 
    

