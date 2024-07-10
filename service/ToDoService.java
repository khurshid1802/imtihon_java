package service;

import model.ToDo;

import java.util.UUID;

public class ToDoService {
    ToDo[] toDos = new ToDo[10];
    int count = 0;

    public void addToDo(ToDo toDo) {
        if(hasTodo(toDo)){
            return;
        }
        toDos[count++] = toDo;
    }

    public boolean hasTodo(ToDo toDo) {
        for (int i = 0; i < count; i++) {
            if(toDos[i] != null){
                if(toDos[i].owner.equals(toDo.owner) && toDos[i].todo.equals(toDo.todo)){
                    return true;
                }
            }
        }
        return false;
    }

    public void showUserTodo(UUID owner){
        for (ToDo toDo : toDos) {
            if(toDo != null) {
                if (toDo.owner.equals(owner)) {
                    System.out.println(toDo.toString());
                }
            }
        }
    }

    public void completeToDo(String text){
        for (ToDo toDo : toDos){
            if (toDo != null) {
                if (toDo.todo.equals(text)) {
                    toDo.complete = true;
                }
            }
        }
    }

}
