package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.ReservationException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in: ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out: ");
			Date checkOut = sdf.parse(sc.next());
	
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
	
			System.out.println("\nEnter data to update the reservation:");
			System.out.print("Check-in: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out: ");
			checkOut = sdf.parse(sc.next());
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		} 
		catch (ParseException e) {
			System.out.println("Invalid data format.");
		}
		catch(ReservationException e) {
			System.out.println("Reservation error: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error my dear friend...");
		}

		sc.close();
	}
}
