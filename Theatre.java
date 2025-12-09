//importing all the needed utilities for the code
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Theatre {
    static String email_add=null;  //making email address a global variable
    public static void main(String[] args) {
        System.out.println("Welcome to the new Theatre");
//declaring all the arrays and arraylists
        ArrayList<Ticket> tickets = new ArrayList<>();
        int[] row1 = new int[12];
        int[] row2 = new int[16];
        int[] row3 = new int[20];
        int[][] seats = {row1, row2, row3};
        Scanner input = new Scanner(System.in);
        int status = 0;
        while (status == 0) {  //looping this block of code to do many tasks
            try {  //for invalid inputs
                String line = """

                        -------------------------------------------------
                        Please select an option:
                        1) Buy a ticket
                        2) Print seating area
                        3) Cancel ticket
                        4) List available seats
                        5) Save to file
                        6) Load from file
                        7) Print ticket information and total price
                        8) Sort tickets by price
                        0) Quit
                        -------------------------------------------------
                        Enter option:\s""";
                System.out.print(line);
                int num = input.nextInt();
                switch (num) {
                    case 0 -> {
                        status = 1;
                        System.exit(0);
                    }
                    case 1 -> buy_ticket(row1, row2, row3, tickets);
                    case 2 -> print_seating_area(row1, row2, row3);
                    case 3 -> cancel_ticket(row1, row2, row3, tickets);
                    case 4 -> show_available(row1, row2, row3);
                    case 5 -> save( seats);
                    case 6 -> load(seats);
                    case 7 -> show_tickets_info(tickets);
                    case 8 -> sort_tickets(tickets);
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid number");
                input.next();
            }
        }
    }

    public static void buy_ticket(int[] row1, int[] row2, int[] row3, ArrayList<Ticket> tickets) {
        int state = 0;
//taking all the inputs and doing a validation for email
        Scanner input = new Scanner(System.in);
        System.out.print("First name: ");
        String first_name = input.next();
        System.out.print("Surname: ");
        String Surname = input.next();
        int status = 0;
        while (status == 0) {
            System.out.print("Email Address: ");
            email_add = input.next();
            if (email_add.contains("@")) {
                status = 1;
            } else {
                System.out.println("Enter a valid email address");
            }
        }
        while (state == 0) {  //validating the row and seat input with while and try

            try {System.out.println("Row 1- £10\nRow 2- £20\nRow 3- £30");
                int row;
                int price;
                System.out.print("Row number: ");
                 row = input.nextInt();
                if (row == 1) {
                    price=10;
                    System.out.print("Seat number: ");
                    int seat = input.nextInt();
                    if (seat > 0 && seat <= 12) {
                        if (row1[seat - 1] == 1) {
                            System.out.println("Seat already booked, please try another seat\n");
                        } else {
                            row1[seat - 1] = 1;
                            System.out.println("Ticket booked successfully");
                            Person person = new Person (first_name,Surname,email_add);
                            Ticket ticket = new Ticket(row,seat,price,person);
                            tickets.add(ticket);
                            state = 1;
                        }
                    } else {
                        System.out.println("Enter a valid seat number\n");
                    }
                } else if (row == 2) {
                    price=20;
                    System.out.print("Seat number: ");
                    int seat = input.nextInt();
                    if (seat > 0 && seat <= 16) {
                        if (row2[seat - 1] == 1) {
                            System.out.println("Seat already booked, please try another seat\n");
                        } else {
                            row2[seat - 1] = 1;
                            System.out.println("Ticket booked successfully");
                            Person person = new Person (first_name,Surname,email_add);
                            Ticket ticket = new Ticket(row,seat,price,person);
                            tickets.add(ticket);
                            state = 1;
                        }
                    } else {
                        System.out.println("Enter a valid seat number\n");
                    }
                } else if (row == 3) {
                    price=30;
                    System.out.print("Seat number: ");
                    int seat = input.nextInt();
                    if (seat > 0 && seat <= 20) {
                        if (row3[seat - 1] == 1) {
                            System.out.println("Seat already booked, please try another seat\n");
                        } else {
                            row3[seat - 1] = 1;
                            System.out.println("Ticket booked successfully");
                            Person person = new Person (first_name,Surname,email_add);
                            Ticket ticket = new Ticket(row,seat,price,person);
                            tickets.add(ticket);
                            state = 1;
                        }
                    } else {
                        System.out.println("Enter a valid seat number\n");
                    }
                } else {
                    System.out.println("This row number does not exist. Please select 1-3\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid number");
                input.next();
            }
        }
    }

    public static void print_seating_area(int[] row1, int[] row2, int[] row3) {
//the following arrays are to make a new set of arrays as the original arrays are integer
        String[] prow1 = new String[12];
        String[] prow2 = new String[16];
        String[] prow3 = new String[20];
        int pr;
        for (pr = 0; pr <= prow1.length - 1; pr++) { //checking whether a seat is booked, if so, it will be marked as X
            if (row1[pr] == 0) {
                prow1[pr] = "O";
            } else {
                prow1[pr] = "X";
            }
        }
        for (pr = 0; pr <= prow2.length - 1; pr++) {
            if (row2[pr] == 0) {
                prow2[pr] = "O";
            } else {
                prow2[pr] = "X";
            }
        }
        for (pr = 0; pr <= prow3.length - 1; pr++) {
            if (row3[pr] == 0) {
                prow3[pr] = "O";
            } else {
                prow3[pr] = "X";
            }
        }
        System.out.println("     ***********\n"); //prints the stage
        System.out.println("     *  STAGE  *\n");
        System.out.println("     ***********\n");
        System.out.print("    ");
        int i;
        for (i = 0; i <= prow1.length - 1; i++) { //this is done to print the array and keep a space in the half of every row
            if (i == prow1.length / 2) {
                System.out.print(" ");
            }

            System.out.print(prow1[i]);
        }
        System.out.print("    \n");
        System.out.print("  ");
        for (i = 0; i <= prow2.length - 1; i++) {
            if (i == prow2.length / 2) {
                System.out.print(" ");
            }
            System.out.print(prow2[i]);
        }
        System.out.print("  \n");
        for (i = 0; i <= prow3.length - 1; i++) {
            if (i == prow3.length / 2) {
                System.out.print(" ");
            }
            System.out.print(prow3[i]);
        }
    }

    @SuppressWarnings("SuspiciousListRemoveInLoop")
    public static void cancel_ticket(int[] row1, int[] row2, int[] row3, ArrayList<Ticket> tickets) {
        Scanner input = new Scanner(System.in);
        int state = 0;
        while (state == 0) { //try and while loop is used to validate the row and seat inputs
            try {
                System.out.print("Row number: ");
                int row = input.nextInt();
                if (row == 1) {
                    System.out.print("Seat number: ");
                    int seat = input.nextInt();
                    if (seat > 0 && seat <= 12) { //to check if a seat is not booked, if not, it will print seat not booked
                        if (row1[seat - 1] == 0) {
                            System.out.println("Seat is not booked, please try another seat\n");
                        } else {
                            row1[seat - 1] = 0;
                            System.out.println("Ticket cancelled successfully");
                            for (int index = 0; index < tickets.size(); index++) {
                                if (tickets.get(index).getRow()==row && tickets.get(index).getSeat()==seat){
                                    tickets.remove(index);
                                }
                            }
                            state = 1;
                        }
                    } else {
                        System.out.println("Enter a valid seat number\n");
                    }
                } else if (row == 2) {
                    System.out.print("Seat number: ");
                    int seat = input.nextInt();
                    if (seat > 0 && seat <= 16) {
                        if (row2[seat - 1] == 0) {
                            System.out.println("Seat is not booked, please try another seat\n");
                        } else {
                            row2[seat - 1] = 0;
                            System.out.println("Ticket cancelled successfully");
                            for (int index = 0; index < tickets.size(); index++) {
                                if (tickets.get(index).getRow()==row && tickets.get(index).getSeat()==seat){
                                    tickets.remove(index);
                                }
                            }
                            state = 1;
                        }
                    } else {
                        System.out.println("Enter a valid seat number\n");
                    }
                } else if (row == 3) {
                    System.out.print("Seat number: ");
                    int seat = input.nextInt();
                    if (seat > 0 && seat <= 20) {
                        if (row3[seat - 1] == 0) {
                            System.out.println("Seat is not booked, please try another seat\n");
                        } else {
                            row3[seat - 1] = 0;
                            System.out.println("Ticket cancelled successfully");
                            for (int index = 0; index < tickets.size(); index++) {
                                if (tickets.get(index).getRow()==row && tickets.get(index).getSeat()==seat){
                                    tickets.remove(index);
                                }
                            }
                            state = 1;
                        }
                    } else {
                        System.out.println("Enter a valid seat number\n");
                    }
                } else {
                    System.out.println("Enter a valid row number\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid number");
                input.next();
            }
        }
    }

    public static void show_available(int[] row1, int[] row2, int[] row3) {
        new Scanner(System.in);
        StringBuilder available1 = new StringBuilder();
        int r1;
        for (r1 = 0; r1 <= row1.length - 1; r1++) {  //checks whether the seat is available or not, if available, it will print as available
            if (row1[r1] == 0) {
                int x = r1 + 1;
                available1.append(" ").append(x);
            }
        }
        StringBuilder available2 = new StringBuilder();
        int r2;
        for (r2 = 0; r2 <= row2.length - 1; r2++) {
            if (row2[r2] == 0) {
                int x = r2 + 1;
                available2.append(" ").append(x);
            }
        }
        StringBuilder available3 = new StringBuilder();
        int r3;
        for (r3 = 0; r3 <= row3.length - 1; r3++) {
            if (row3[r3] == 0) {
                int x = r3 + 1;
                available3.append(" ").append(x);
            }
        }
        System.out.println("Seats available in row 1: " + available1);
        System.out.println("Seats available in row 2: " + available2);
        System.out.println("Seats available in row 3: " + available3);
    }

    public static void save( int[][] seats) {
        new Scanner(System.in);
        try {
            File file = new File("theatre.txt"); //creating a file and checking whether it exists
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            PrintWriter writer = new PrintWriter("theatre.txt");
            for (int i = 0; i <= seats.length - 1; i++) { //this writes the array in the file one by one
                for (int j = 0; j <= seats[i].length - 1; j++) {
                    writer.write(seats[i][j] + " ");
                }
                writer.println();
            }
            writer.close();
            System.out.println("Information has been stored into the file");

        } catch (Exception e) {
            System.out.println("There was a problem saving the file");
        }
    }


    public static void load(int[][] seats) {
        new Scanner(System.in);
        try {
            File file = new File("theatre.txt");
            Scanner file_reader = new Scanner(file);
            for (int i = 0; i <= seats.length - 1; i++) {  //this adds the array from the file to the array one by one
                for (int j = 0; j <= seats[i].length - 1; j++) {
                    seats[i][j] = file_reader.nextInt();
                }
            }
        } catch (IOException e) {
            System.out.println("Error while loading this file");
        }
        System.out.println("Successfully updated previously saved information");

    }
    public static void show_tickets_info(ArrayList<Ticket> tickets) {
        int totalPrice = 0;

        for (Ticket ticket : tickets) { //calculates the total price
            ticket.print();
            totalPrice += ticket.getPrice();
            System.out.println();
        }

        System.out.println("Total ticket price: £" + totalPrice);
    }   public static void sort_tickets(ArrayList<Ticket> tickets){
        Ticket temp; //creates a temporary value in the ticket class
        for (int a = 0; a < tickets.size()-1; a++) {  //this is bubble sort
            for (int b = 0; b < tickets.size()-a-1; b++) {
                if (tickets.get(b).getPrice() > tickets.get(b+1).getPrice()) {
                    temp = tickets.get(b);
                    tickets.set(b, tickets.get(b+1));
                    tickets.set(b+1, temp);
                }
            }
        }
        System.out.println("Tickets successfully sorted!");
    }

}

