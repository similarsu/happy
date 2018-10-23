package net.similarsu.commons.pool;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class PersonFactory implements PooledObjectFactory<Person> {
    @Override
    public PooledObject<Person> makeObject() throws Exception {
        Person person = new Person();
        return new DefaultPooledObject<>(person);
    }

    @Override
    public void destroyObject(PooledObject<Person> p) throws Exception {
        Person person = p.getObject();
        person = null;

    }

    @Override
    public boolean validateObject(PooledObject<Person> p) {
        System.out.println("validate");
        return false;
    }

    @Override
    public void activateObject(PooledObject<Person> p) throws Exception {
        System.out.println("activateObject");
    }

    @Override
    public void passivateObject(PooledObject<Person> p) throws Exception {
        System.out.println("passivateObject");
    }
}
