package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entites.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Room number:");
		int roomNumber = scanner.nextInt();
		System.out.println("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(scanner.next());

		System.out.println("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(scanner.next());
		if (!checkOut.after(checkIn)) {
			System.out.println("Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println("Enter data to update the reservation:");
			System.out.println("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(scanner.next());

			System.out.println("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(scanner.next());

			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null) {
				System.out.println(error);

			} else {
				System.out.println("Reservation: " + reservation);
			}

		}
		scanner.close();
	}

}
