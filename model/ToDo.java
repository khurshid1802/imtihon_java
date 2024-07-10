package model;

import java.util.UUID;

public class ToDo {
    public UUID id;
    public UUID owner;
    public String todo;
    public boolean complete = false;

    public ToDo(UUID owner, String todo) {
        this.id = UUID.randomUUID();
        this.owner = owner;
        this.todo = todo;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", owner=" + owner +
                ", todo='" + todo + '\'' +
                ", complete=" + (complete ? "completed" : "uncompleted") +
                '}';
    }
}
