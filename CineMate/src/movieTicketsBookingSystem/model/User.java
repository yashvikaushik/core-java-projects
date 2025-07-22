package movieTicketsBookingSystem.model;

public class User {
    private int id;
    private String userName;
    private String email;
    private String password;
    private String role;

    public User(){

    }

    //constructor
    public User(int id,String userName,String email,String password){
        this.id=id;
        this.userName=userName;
        this.email=email;
        this.password=password;
        this.role=role;
}

//getters

public int getID(){
    return id;
}

public String getUserName(){
return userName;
}

public String getEmail(){
return email;
}

public String getPassword(){
return password;
}

public String getRole(){
return role;
}

//setters

public void setID(int id){
    this.id=id;
}

public void setUserName(String userName){
this.userName=userName;
}

public void setEmail(String email){
this.email=email;
}

public void setPassword(String password){
this.password=password;
}

public void setRole(String role){
this.role=role;
}

public String toString(){
    return "user name: "+userName+" email: "+email+" password: "+password;
}


    
}
