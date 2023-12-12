package genealogy;

import java.util.Iterator;

public interface GenealogicalTree extends Iterable<Person> {
    void add(Person person);
    void remove(Person person);
    boolean contains(Person person);

    @Override
    Iterator<Person> iterator();
}