package net.wamdue.lib.beans;

/**
 * @author Wamdue
 * @version 1.0
 * @since 31.05.2017
 */
public class Publisher {
    private static int counter = 0;
    private int id;
    private String name;

    public Publisher(String name) {
        this.name = name;
        this.id = counter++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        if(counter < id)
            counter = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
