public class Ticket {
    private int row;
    private int seat;
    private int price;
    private Person person;
    public Ticket(int row, int seat, int price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    public void print(){ //gets passed in the main code and is printed for option 7
        System.out.println("Name: "+person.getName()+" "+person.getSurname());
        System.out.println("Email Address: "+person.getEmail());
        System.out.println("Row: "+ row);
        System.out.println("Seat: "+seat);
        System.out.println("Price: £"+ price);
    }
}

