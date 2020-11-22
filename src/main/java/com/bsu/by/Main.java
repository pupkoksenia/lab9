package com.bsu.by;
import java.io.IOException;
import java.util.List;
/*Фактически применение параллельных потоков сводится к тому, что данные в потоке будут разделены на части, каждая
часть обрабатывается на отдельном ядре процессора, и в конце эти части соединяются,
и над ними выполняются финальные операции. */

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> arrayOfStringsBook=function.readFromFile("C:\\Users\\lab9\\Books.txt");
        assert arrayOfStringsBook != null;
        List<Books> ListOfBooks = function.createListOfBooks(arrayOfStringsBook);
        function.filter(ListOfBooks);
        function.map(ListOfBooks);
        function.reduce(ListOfBooks);
        function.findfirst(ListOfBooks);
        function.collect(ListOfBooks);
    }

}

