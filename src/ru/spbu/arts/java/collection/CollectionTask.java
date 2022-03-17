package ru.spbu.arts.java.collection;

import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CollectionTask {
    public static void main(String[] args) throws Exception {
        System.out.println(count(5));

        List<String> list1 = List.of("abc", "xyz", "ooo");
        printList(list1);
        printListWithIndices(list1);

        List<String> list3 = List.of("aaa", "bbb", "ccc");
        List<String> list4 = List.of("xxx", "yyy", "zzz");
        List<String> list3plusList4 = concatenateLists(list3, list4);
        System.out.println(list3plusList4);

        //созадем изменяемый список list5.
        List<String> list5 = new ArrayList<>(List.of("first", "middle", "last"));
        //сначала чистая функция
        List<String> list5rev = reverseList(list5);
        //проверяем, что list5rev перевернутый, а list5 остался без изменений.
        System.out.println("list5rev = " + list5rev + ", but list5 = " + list5);

        //теперь функция, которая меняет сам список
        reverseListInPlace(list5);
        //проверяем, что список действительно изменился
        System.out.println("list5 = " + list5);

        System.out.println("------------------------------------------------");

        List<Integer> ints = List.of(11, 22, 33, 55, 66, 88, 100, 3, 4);

        System.out.println("ints = " + ints);
        //функция должна удалить элементы с четными индексами, т.е. оставить только каждое второе число
        System.out.println("ints no even indices = " + filterEvenIndices(ints)); //["22", "55", "88", "3"]
        //функция должна удалить четные числа
        System.out.println("ints without even = " + filterEven(ints)); //["11", "33", "55", "3"]

        // В этой части мы проделаем то же самое, но с функциями, которые изменяют переданные списки.
        // слово mutable означает "изменяемый", потому что в этой части мы будем использовать списки,
        // которые можно изменять.
        System.out.println(" ============= mutable lists =================== ");

        List<Integer> mutableInts = new ArrayList<>(ints);
        mutableFilterEvenIndices(mutableInts);
        System.out.println("ints no even indices = " + mutableInts); //[22, 55, 88, 3]

        mutableInts = new ArrayList<>(ints);
        mutableFilterEven(mutableInts);
        System.out.println("ints without even = " + mutableInts); //[11, 33, 55, 3]

        System.out.println("-------------------------------------------------");

        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        doReadWordsInFile("text-files/for-collection-task.txt", hashSet);
        doReadWordsInFile("text-files/for-collection-task.txt", linkedHashSet);
        doReadWordsInFile("text-files/for-collection-task.txt", treeSet);

        System.out.println(hashSet);
        System.out.println(linkedHashSet);
        System.out.println(treeSet);
    }
    public static List<Integer> count(int n) {
        List<Integer> listOfNumbers = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            listOfNumbers.add(i);
        return listOfNumbers;
    }

    public static void printList(List<String> list) {
        System.out.println("Элементов в списке: " + list.size());
        for (String s : list)
            System.out.println(s);
    }

    public static void printListWithIndices(List<String> list) {
        System.out.println("Элементов в списке: " + list.size());
        for (int i = 1; i <= list.size(); i++)
            System.out.println(i + ": " + list.get(i - 1));
    }

    public static List<String> concatenateLists(List<String> list1, List<String> list2) {
        List<String> result = new ArrayList<>();
        result.addAll(list1);
        result.addAll(list2);
        return result;
    }

    public static List<String> reverseList(List<String> list){
        List<String> reversedList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--)
            reversedList.add(list.get(i));
        return reversedList;
    }

    public static void reverseListInPlace(List<String> list){
        String elem;
        for (int i = 0; i < (list.size() / 2); i++) {
            elem = list.get(i);
            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size() - i - 1, elem);
        }
    }

    public static List<Integer> filterEvenIndices(List<Integer> l) {
        List<Integer> newList = new ArrayList<>();
        for (int i = 1; i < l.size(); i+=2)
            newList.add(l.get(i));
        return newList;
    }

    public static List<Integer> filterEven(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        for (Integer x : list)
            if (x % 2 != 0)
                newList.add(x);
        return newList;
    }

    public static void mutableFilterEvenIndices(List<Integer> l) {
        for (int i = l.size() - 1; i >= 0; i--) {
            if (i % 2  == 0)
                l.remove(i);
        }
    }

    public static void mutableFilterEven(List<Integer> l) {
        for (int i = 0; i < l.size(); i++)
            if (l.get(i) % 2  == 0) {
                l.remove(i + 1 - 1);
                i--;
            }
    }
    private static void doReadWordsInFile(String file, Set<String> wordsSet) throws Exception {
        Path txt = Path.of(file);
        Pattern wordPattern = Pattern.compile("[а-я]+", Pattern.CASE_INSENSITIVE + Pattern.UNICODE_CASE);
        try (Scanner in = new Scanner(txt, StandardCharsets.UTF_8)) {
            while (in.hasNext()) {
                Matcher c = wordPattern.matcher(in.next());
                if (c.find()) {
                    String word = c.group().toLowerCase();
                    wordsSet.add(word);
                }
            }
        }
    }
}

