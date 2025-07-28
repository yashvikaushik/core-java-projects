package movieTicketsBookingSystem.model;

public class Orders {
    private int id;
    private int userID;
    private int movieID;
    private Bookings booking;

    Orders(int userID,int movieID,Bookings booking){
        this.userID=userID;
        this.movieID=movieID;
        this.booking=booking;
    }
    public Orders(){

    }
    
    public int getUserID(){
          return userID;
    }

    public int getMovieID(){
          return movieID;
    }
    
    public int getID(){
        return id;
    }
    

    public void setUserID(int userID){
            this.userID=userID;
    }

    public void setMovieID(int movieID){
        this.movieID=movieID;
    }

   

    public void setBooking(Bookings booking){
        this.booking=booking;
    }
    public Bookings getBooking(){
        return booking;
    }

    public void setID(int id){
        this.id=id;

    }

    @Override
public String toString() {
    return "Orders{" +
            "userID=" + userID +
            ", movieID=" + movieID +
            ", booking=" + booking +
            '}';
}

    
}
