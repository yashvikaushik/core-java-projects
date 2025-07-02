
    import java.util.*;
public class BankingSystemApp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char c;
        String accountType="";
        //object of bank class
        Bank bank=new Bank();
        //objects of savings accounts and current account
       SavingsAccount savingsAccount=null;
       CurrentAccount currentAccount=null;
        do{
        System.out.println("Welcome to the Bank Management App");
        System.out.println("===== Java Bank Menu =====");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Display Account Details");
        System.out.println("5. Exit");
        System.out.println("Enter your choice");
        int choice=sc.nextInt();
        switch(choice){

            case 1:System.out.println("you have chosen to create a new account");
            System.out.println("enter the type of account that you want to create");
            accountType=sc.next();
            System.out.println("enter your account number");
            String accNumber=sc.next();
            System.out.println("enter the name of the account holder");
            String name=sc.next();
            System.out.println("enter the current balance");
            double balance=sc.nextDouble();

            if(accountType.equals("savings")){
                
                     savingsAccount=new SavingsAccount(accNumber, name, balance);
                    bank.addAccount(savingsAccount);
                    
              
                System.out.println("your account has been created successfully");

            }

                else{
                    
                     currentAccount=new CurrentAccount(accNumber, name, balance);
                    bank.addAccount(currentAccount);

                
                System.out.println("your account has been created successfully");


            }
            break;
            //account creation done

            case 2:
            System.out.println("you have chosen to deposit some amount");
            System.out.println("what is your account type");
            String accountTyp=sc.next();
            if(accountTyp.equals("savings")){
                System.out.println("enter your account number");
                String accnum=sc.next();
                Account found=bank.findAccount(accnum);
                System.out.println("enter the amount that you want to add");
                double amt=sc.nextDouble();
                if(found !=null){
                    savingsAccount.deposit(amt);
                    savingsAccount.displayAccoutDetails();
                }
                else{
                    System.out.println("account not found");
                }
            }

            else{
                 System.out.println("enter your account number");
                String accnum=sc.next();
                Account found=bank.findAccount(accnum);
                System.out.println("enter the amount that you want to add");
                double amt=sc.nextDouble();
                if(found !=null){
                   currentAccount.deposit(amt);
                    currentAccount.displayAccoutDetails();
                }
                else{
                    System.out.println("account not found");
                }

            }
          
        
           
        break;
            
            case 3:
             System.out.println("you have chosen to withdraw some amount");
            System.out.println("what is your account type");
            String accTyp=sc.next();
                if(accTyp.equals("savings")){
                System.out.println("enter your account number");
                String accnum=sc.next();
                Account found=bank.findAccount(accnum);
                System.out.println("enter the amount that you want to add");
                double amt=sc.nextDouble();
                if(found !=null){
                    savingsAccount.withdraw(amt);
                    savingsAccount.displayAccoutDetails();
                }
                else{
                    System.out.println("account not found");
                }
            }

            else{
                 System.out.println("enter your account number");
                String accnum=sc.next();
                Account found=bank.findAccount(accnum);
                System.out.println("enter the amount that you want to add");
                double amt=sc.nextDouble();
                if(found !=null){
                    currentAccount.deposit(amt);
                    currentAccount.displayAccoutDetails();
                }
                else{
                    System.out.println("account not found");
                }

            }
          
            break;
            
            case 4:
            if(savingsAccount==null && currentAccount==null){
                System.out.println("no account present");
            }

            else{

            System.out.println("savings accounts");
            savingsAccount.displayAccoutDetails();
            System.out.println("current accounts");
            currentAccount.displayAccoutDetails();
            } 
            
           
                
            
            break;
            
            case 5:
            System.out.println("you have been exites successfully");
            
            break;

            default: 
            System.out.println("wrong choice");
        }
        System.out.println("do you want to continue enter (y/n)");
         c=sc.next().charAt(0);

        }
        while(c=='y');
}
}
    


    

