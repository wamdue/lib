package net.wamdue.lib.beans;

/**
 * @author Wamdue
 * @version 1.0
 * @since 31.05.2017
 */
public class Genre {
    private static int counter = 0;
    private int id;
    private int name;

    public Genre(int name) {
        this.id = counter++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        if (counter < id)
            counter = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}
