package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void matchesForSimpleTaskIfTrue() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertTrue(actual);
    }

    @Test
    public void matchesForSimpleTaskIfFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("родственникам");

        Assertions.assertFalse(actual);
    }

    @Test
    public void matchesForEpicIfTrue() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        boolean actual = epic.matches("Молоко");
        Assertions.assertTrue(actual);
    }

    @Test
    public void matchesForEpicIfFalse() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        boolean actual = epic.matches("Мясо");
        Assertions.assertFalse(actual);
    }

    @Test
    public void matchesForMeetingTopicIfTrue() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        boolean actual = meeting.matches("Выкатка 3й версии приложения");
        Assertions.assertTrue(actual);
    }

    @Test
    public void matchesForMeetingProjectIfTrue() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        boolean actual = meeting.matches("Приложение НетоБанка");
        Assertions.assertTrue(actual);
    }

    @Test
    public void matchesForMeetingTopicIfFalse() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        boolean actual = meeting.matches("Выкатка 2й версии приложения");
        Assertions.assertFalse(actual);
    }

    @Test
    public void matchesForMeetingProjectIfFalse() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        boolean actual = meeting.matches("Приложение Банка");
        Assertions.assertFalse(actual);
    }
}
