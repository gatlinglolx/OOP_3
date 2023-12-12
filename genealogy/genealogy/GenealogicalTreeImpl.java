package genealogy;

import java.util.*;

public class GenealogicalTreeImpl implements GenealogicalTree {
    private List<Person> people;

    public GenealogicalTreeImpl() {
        people = new ArrayList<>();
    }

    @Override
    public void add(Person person) {
        people.add(person);
    }

    @Override
    public void remove(Person person) {
        people.remove(person);
    }

    @Override
    public boolean contains(Person person) {
        return people.contains(person);
    }

    public void sortByName() {
        Collections.sort(people, Comparator.comparing(Person::getName));
    }

    public void sortByBirthDate() {
        Collections.sort(people, Comparator.comparing(Person::getBirthDate));
    }

    @Override
    public Iterator<Person> iterator() {
        return people.iterator();
    }
    public static void main(String[] args) {
        GenealogicalTreeImpl tree = new GenealogicalTreeImpl();
    
        // Создаем несколько объектов Person
        Person person1 = new Person("Vlad", new Date(1999));
        Person person2 = new Person("Olga", new Date(1987));
        Person person3 = new Person("Brad", new Date(1995));
    
        // Добавляем объекты в генеалогическое дерево
        tree.add(person1);
        tree.add(person2);
        tree.add(person3);
    
        // Выводим список людей до сортировки
        System.out.println("Список людей до сортировки: ");
        for (Person person : tree) {
            System.out.println(person.getName() + " - " + person.getBirthDate());
        }
    
        // Сортируем список по имени
        tree.sortByName();
    
        // Выводим отсортированный список
        System.out.println("Список людей после сортировки по имени: ");
        for (Person person : tree) {
            System.out.println(person.getName() + " - " + person.getBirthDate());
        }
    
        // Сортируем список по дате рождения
        tree.sortByBirthDate();
    
        // Выводим отсортированный список
        System.out.println("Список людей после сортировки по дате рождения: ");
        for (Person person : tree) {
            System.out.println(person.getName() + " - " + person.getBirthDate());
        }
    
        // Удаляем одного из людей
        tree.remove(person2);
    
        // Проверяем наличие оставшихся людей в генеалогическом дереве
        System.out.println("Проверка наличия людей: ");
        System.out.println("Содержит person1: " + tree.contains(person1));
        System.out.println("Содержит person2: " + tree.contains(person2));
        System.out.println("Содержит person3: " + tree.contains(person3));
    }
}