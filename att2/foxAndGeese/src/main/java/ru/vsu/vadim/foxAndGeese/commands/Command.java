package ru.vsu.vadim.foxAndGeese.commands;

public class Command {
    private String cmd = "";

    public void makeContinue() {
         cmd = "continue";
    }

    public void makeMove(int from, int to) {
         cmd = "move " + from + " " + to;
    }

    public String getCmd() {
        return cmd;
    }
}
