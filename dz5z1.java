/**
Задание 1. 
Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что один человек может иметь несколько телефонов.
 */ 


 import java.util.*;

 public class dz5z1 {
     private static Scanner input = new Scanner(System.in, "Cp866");
     public static void main(String[] args) {
         
         
         Map<String, List<String>> phoneBook = abonents();
         
         
         boolean stopWhile = true;
         while (stopWhile){
             System.out.println(menu());
             int whatDo = input.nextInt();
             switch(whatDo) {
                 case 1: 
                     showAllContact(phoneBook);
                     break;
                 case 2:
                     findContact(phoneBook);
                     break;
                 case 3:
                     addContact(phoneBook);
                     break;
                 case 4:
                     stopWhile = false;
                     break;
                 default:
                     System.out.println("Нет такого пункта меню!");
             }
 
         }
     }
 
 
     
     private static Map<String, List<String>> abonents(){
         Map<String, List<String>> phoneBook = new HashMap<>();
         phoneBook.put("Васечкин", Arrays.asList("123456", "789654"));
         phoneBook.put("Пасечкин", Arrays.asList("654123"));
         phoneBook.put("Масочкин", Arrays.asList("147852", "258963", "357862"));
         phoneBook.put("Красочкин", Arrays.asList("159842", "248613"));
 
         return phoneBook;
     }
 
 
     
     private static String menu() {
         String menuStr = new StringBuilder()
         .append("Выберите действие: \n")
         .append("1 - Посмотреть все записи \n")
         .append("2 - Найти абонента по фамилии \n")
         .append("3 - Добавить абонента или номер к имеющемуся \n")
         .append("4 - Выход ")
         .toString();
 
         return menuStr;
 
     }
 
     
     private static void showAllContact(Map<String, List<String>> map){
         System.out.println("\nСписок абонентов: ");
         for (Map.Entry<String,List<String>> entry:map.entrySet()
              ) {
             System.out.println(entry.getKey()+" = "+ entry.getValue());
         }
         System.out.println("\n");
     }    
 
 
     
     private static void findContact(Map<String, List<String>> map) {
         System.out.print("Введите фамилию абонента с большой буквы: ");
         String name = input.next();
         if (map.containsKey(name)) {
             System.out.print("Номер телефона " + name + " " +map.get(name) + "\n");
         }
         else {
             
             System.out.print("Абонент с фамилией " + name + " отсутствует! \n");
         }
     }
 
 
     
     private static void addContact(Map<String, List<String>> map) {
         System.out.print("Введите фамилию абонента с большой буквы: ");
         String firstname = input.next();
         if (map.containsKey(firstname)) {
             System.out.print("Абонент с такой фамилией есть! \n Номер телефона будет добавлен к существующему \n");
             System.out.print("Введите номер телефона: ");
             String phone = input.next();
             ArrayList<String> oldPhone = new ArrayList<>(map.get(firstname));
             oldPhone.add(phone);
             map.put(firstname, oldPhone);
             showAllContact(map);
         }
         else {
             System.out.print("Введите номер телефона: ");
             String phone = input.next();
             map.put(firstname, Arrays.asList(phone));
             System.out.println("Абонент добавлен! ");
             showAllContact(map);
         }
     }
 
 }