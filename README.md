# New-Theatre-Seat-Management-System

This is a comprehensive Java application developed for a module coursework. The project is designed for the 'New Theatre' company to manage the sale and availability of seats across its three rows (12, 16, and 20 seats)  and handle the associated ticket and customer information.


Key Features & Implementation:
Seat Management: Uses three arrays to record sold (1) and available (0) seats across the three rows.
Console Menu Interface: Provides a full menu with options for buying tickets, cancelling tickets, printing the seating area, saving/loading data, and reporting ticket information.

Object-Oriented Design (OOP):
Person Class: Stores customer details (name, surname, email).
Ticket Class: Stores ticket details (row, seat, price) and holds an object of the Person class.

Data Structures & Algorithms:
An ArrayList is used to store Ticket objects.
Implements a method to sort the tickets by price in ascending order.

File I/O: Functionality to save the current seating arrangement to a file and load it back to restore the state of the theatre.
