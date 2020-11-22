package com.bsu.by;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class function {
    public static List<String> readFromFile(String fileName) throws IOException {
        List<String> arrayOfLines = new ArrayList<String>();
        FileReader readerOfUsers = new FileReader(fileName);
        try (BufferedReader bufReaderOfUsers = new BufferedReader(readerOfUsers)) {
            String line;
            while ((line = bufReaderOfUsers.readLine()) != null) {
                arrayOfLines.add(line);
            }
            bufReaderOfUsers.close();
            readerOfUsers.close();
            return arrayOfLines;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static List<Books> createListOfBooks(List<String> arrayOfStringsBook) throws IOException {
        List<Books> ListOfBooks = new ArrayList<>();
        int i = 0;
        while (i < arrayOfStringsBook.size()) {
            Books book = new Books();
            book.setName(arrayOfStringsBook.get(i));
            book.setAmountOfPages(arrayOfStringsBook.get(i + 1));
            book.setRecommendation(arrayOfStringsBook.get(i + 2));
            ListOfBooks.add(book);
            i += 3;
        }
        return ListOfBooks;
    }

    public static void filter(List<Books> ListOfBooks) {
        System.out.println("filter method,take all books >100 pages: ");
        List<Books> bb = ListOfBooks.stream().filter(Books::hasOverHundredPages).collect(Collectors.toList());
        for (Books b : bb) {
            System.out.println(b.getName());
        }
        System.out.println("\n");
    }

    public static void map(List<Books> ListOfBooks) {
        System.out.println("map method,give all recommendations on all books: ");
        List<String> recomm = ListOfBooks.stream().map(b -> b.getRecommendation()).flatMap(n -> n.stream()).collect(Collectors.toList());
        for (String s : recomm) {
            System.out.println(s);
        }
        System.out.println("\n");
    }

    public static void reduce(List<Books> ListOfBooks) {
        System.out.println("map method,sum of all pages: ");
        int amountOfAllPages = ListOfBooks.stream().map(b -> b.getAmountOfPages()).reduce(0, (x, y) -> x + y);
        System.out.println(amountOfAllPages + "\n");
    }

    public static void findfirst(List<Books> ListOfBooks) {
        System.out.println("findfirst method,find first book with recommendation boring: ");
        Optional<Books> b = ListOfBooks.stream().filter(Books::hasRecommBoring).findFirst();
        System.out.println(b.get().getName() + "\n");
    }

    public static void collect(List<Books> ListOfBooks) {
        System.out.println("collect method,collect by amount of pages: ");
        Map<Integer, List<Books>> booksByAmountPages = ListOfBooks.stream().collect(Collectors.groupingBy(Books::getAmountOfPages));
        for (Map.Entry<Integer, List<Books>> item : booksByAmountPages.entrySet()) {
            System.out.print(item.getKey()+": ");
            for(Books b : item.getValue()){
                System.out.print(b.getName()+", ");
            }
            System.out.println();
        }
    }
}
