package model;

import java.util.ArrayList;
import java.util.Stack;

public final class ValidationModel {
    private ArrayList<String> token;
    private boolean isValid = false;
    private ArrayList<TableFormat> tables = new ArrayList<>();

    public ValidationModel() {
    }

    public void setTables(ArrayList<TableFormat> tables) {
        this.tables = tables;
    }
    private ArrayList<String> getStringToken(){
        token = new ArrayList<>();
        for (TableFormat tableFormat : tables){
            token.add(tableFormat.getTokenLexic() + "");
        }
        token.add("END");
        return token;
    }
    public String isValid(){
        if (isValid){
            return "VALID";

        }
        else return "NOT VALID";
    }
    public void validation(){
        getStringToken();
        isValid = false;
        Stack stack = new Stack<>();
        int cc = 0;

        String state = "i";
        stack.push("#");
        state = "p";
        stack.push("S");
        state = "q";

        loop:
        while(!stack.peek().equals("#")){
            switch (stack.peek().toString()){
                case "S":
                    if (token.get(cc).equals("15")){
                        stack.pop();
                        stack.push("E");
                        stack.push("D");
                        stack.push("B");
                        stack.push("A");
                        stack.push("15");
                    }
                    else
                        stack.push("ERROR");
                    break;
                case "D":
                    stack.pop();
                    break;
                case "E":
                    if (token.get(cc).equals("25")) {
                        stack.pop();
                        stack.push("S");
                        stack.push("25");
                    } else {
                        stack.pop();
                    }
                    break;

                case "15":
                    if (token.get(cc).equals("15")) {
                        stack.pop();
                        cc++;
                    } else {
                        stack.push("ERROR");
                    }
                    break;
                case "25":
                    if (token.get(cc).equals("25")) {
                        stack.pop();
                        cc++;
                    } else {
                        stack.push("ERROR");
                    }
                    break;
                case "A":
                    if (token.get(cc).equals("2")) {
                        stack.pop();
                        stack.push("F");
                        stack.push("2");
                    } else if (token.get(cc).equals("12")) {
                        stack.pop();
                        stack.push("F");
                        stack.push("12");
                    } else if (token.get(cc).equals("12") && token.get(cc + 1).equals("3")
                            && token.get(cc + 2).equals("12")) {
                        stack.pop();
                        stack.push("F");
                        stack.push("12");
                        stack.push("3");
                        stack.push("12");
                    } else {
                        stack.push("ERROR");
                    }
                    break;
                case "F":
                    if (token.get(cc).equals("5")) {
                        stack.pop();
                        stack.push("A");
                        stack.push("5");
                    } else {
                        stack.pop();
                    }
                    break;
                case "2":
                    if (token.get(cc).equals("2")) {
                        stack.pop();
                        cc++;
                    } else {
                        stack.push("ERROR");
                    }
                    break;
                case "12":
                    if (token.get(cc).equals("12")) {
                        stack.pop();
                        cc++;
                    } else {
                        stack.push("ERROR");
                    }
                    break;
                case "3":
                    if (token.get(cc).equals("3")) {
                        stack.pop();
                        cc++;
                    } else {
                        stack.push("ERROR");
                    }
                    break;
                case "5":
                    if (token.get(cc).equals("5")) {
                        stack.pop();
                        cc++;
                    } else {
                        stack.push("ERROR");
                    }
                    break;
                case "B":
                    if (token.get(cc).equals("16")) {
                        stack.pop();
                        stack.push("G");
                        stack.push("16");
                    }
                    break;
                case "G":
                    if (token.get(cc).equals("12")) {
                        stack.pop();
                        stack.push("H");
                        stack.push("12");
                    } else {
                        stack.push("ERROR");
                    }
                    break;
                case "H":
                    if (token.get(cc).equals("5")) {
                        stack.pop();
                        stack.push("G");
                        stack.push("5");
                    } else {
                        stack.pop();
                    }
                    break;
                case "16":
                    if (token.get(cc).equals("16")) {
                        stack.pop();
                        cc++;
                    } else {
                        stack.push("ERROR");
                    }
                    break;
                default:
                    break loop;
            }
        }
        if (stack.peek().equals("#")) {
            if (token.get(token.size() - 2).equals("4") || (token.size()-1 == cc)) {
                stack.pop();
                state = "f";
                isValid = true;
            }
        }
    }
}
