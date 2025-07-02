
    public class Bank {
    private Account accounts[];
    private int accountCount;
    
    Bank(){
        this.accounts=new Account[100];//array initialization
        this.accountCount=0;
    }

    public boolean addAccount(Account account){
        if(accountCount<this.accounts.length){
            this.accounts[accountCount]=account;
            accountCount++;
            return true;

        }

        else{
            System.out.println("no more accounts could be added");
            return false;
        }
        }

    public Account findAccount(String accountNum){
        for(int i=0;i<accounts.length;i++){
            if(accounts[i].getAccountNumber().equals(accountNum) && accounts[i]!=null){
              
               
                return accounts[i];

            }
        }
            
                
                return null ;
            
            
        
        

    }
    public void displayAllAccounts(){
        for(int i=0;i<accounts.length;i++){
            System.out.println(accounts[i]);
        }
    }

    public Account[] getAccounts(){
        return accounts;
    }


    }
    


    

