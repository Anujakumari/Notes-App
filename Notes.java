package notesapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Notes {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        // Ask user for the file name
        System.out.print("Enter the name of the notes file (e.g., mynotes.txt): ");
        String fileName = sc.nextLine();

        int choice;

        do {
            System.out.println("\n=== Notes App ===");
            System.out.println("1. Write a new note");
            System.out.println("2. Read all notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    writeNote(sc, fileName);
                    break;
                case 2:
                    readNotes(fileName);
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 3);

        sc.close();
    }

    private static void writeNote(Scanner sc, String fileName) {
        System.out.print("Enter your note: ");
        String note = sc.nextLine();

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(note + System.lineSeparator());
            System.out.println("Note saved successfully to " + fileName + "!");
        } 
        catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void readNotes(String fileName) {
        System.out.println("\n--- All Notes from " + fileName + " ---");

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean empty = true;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                empty = false;
            }
            if (empty) {
                System.out.println("No notes found.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

	}

}
