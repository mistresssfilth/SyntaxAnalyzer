package model;

import java.util.ArrayList;

public final class ParseModel {
    private String query;
    private String word = "";
    private ArrayList<TableFormat> tables = new ArrayList<>();


    public ParseModel() {
    }

    public ParseModel(String query) {
        this.query = query;
        this.tables = new ArrayList<>();

    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public ArrayList<TableFormat> getTables() {
        return tables;
    }

    public void setTables(ArrayList<TableFormat> tables) {
        this.tables = tables;
    }

    public void startParsing(){
        for (String queryLine : query.split("\\n")){
            boolean isString = false;
            queryLine = queryLine.toLowerCase() + "  ";
            int currentState = 0;
            char currentChar = queryLine.charAt(0);
            int i = 0;

            while(i < queryLine.length() - 1){
                if (currentChar == '*' && !isString){
                    finalState(currentState);
                    word += currentChar;
                    currentState = 30;
                    finalState(currentState);
                    currentState = 0;
                    currentChar = queryLine.charAt(++i);
                    continue;
                }
                else if(currentChar == '(' && !isString){
                    finalState(currentState);
                    word += currentChar;
                    currentState = 28;
                    finalState(currentState);
                    currentState = 0;
                    currentChar = queryLine.charAt(++i);
                    continue;
                }
                else if(currentChar == ')' && !isString){
                    finalState(currentState);
                    word += currentChar;
                    currentState = 29;
                    finalState(currentState);
                    currentState = 0;
                    currentChar = queryLine.charAt(++i);
                    continue;
                }
                else if(currentChar == ';' && !isString){
                    finalState(currentState);
                    word += currentChar;
                    currentState = 32;
                    finalState(currentState);
                    currentState = 0;
                    currentChar = queryLine.charAt(++i);
                    continue;
                }
                else if(currentChar == '.' && !isString){
                    finalState(currentState);
                    word += currentChar;
                    currentState = 31;
                    finalState(currentState);
                    currentState = 0;
                    currentChar = queryLine.charAt(++i);
                    continue;
                }
                else if(currentChar == '=' && !isString){
                    finalState(currentState);
                    word += currentChar;
                    currentState = 35;
                    finalState(currentState);
                    currentState = 0;
                    currentChar = queryLine.charAt(++i);
                    continue;
                }
                else if(currentChar == '<' && !isString){
                    finalState(currentState);
                    word += currentChar;
                    currentState = 33;
                    finalState(currentState);
                    currentState = 0;
                    currentChar = queryLine.charAt(++i);
                    continue;
                }
                else if(currentChar == '>' && !isString){
                    finalState(currentState);
                    word += currentChar;
                    currentState = 36;
                    finalState(currentState);
                    currentState = 0;
                    currentChar = queryLine.charAt(++i);
                    continue;
                }
                else if(currentChar == ',' && !isString){
                    finalState(currentState);
                    word += currentChar;
                    currentState = 43;
                    finalState(currentState);
                    currentState = 0;
                    currentChar = queryLine.charAt(++i);
                    continue;
                }
                if (currentState == 0){
                    if (currentChar == ' '){
                        currentState = 0;
                    }
                    else if (currentChar == 's') { //select
                        currentState = 1;
                    }
                    else if (currentChar == 'f') { // from
                        currentState = 7;
                    }
                    else if (currentChar == 'w') { //where
                        currentState = 11;
                    }
                    else if (currentChar == 'a') { //and
                        currentState = 16;
                    }
                    else if (currentChar == 'l') { //like
                        currentState = 19;
                    }
                    else if (currentChar == 'n') { // not
                        currentState = 23;
                    }
                    else if (currentChar == 'o') { //or
                        currentState = 26;
                    }
                    else if (currentChar == '"') {
                        currentState = 41;
                        isString = true;
                    }
                    else if (currentChar == '(') {
                        currentState = 28;
                    }
                    else if (currentChar == ')') {
                        currentState = 29;
                    }
                    else if (currentChar == '*') {
                        currentState = 30;
                    }
                    else if (currentChar == '.') {
                        currentState = 31;
                    }
                    else if (currentChar == ';') {
                        currentState = 32;
                    }
                    else if (currentChar == '<') {
                        currentState = 33;
                    }
                    else if (currentChar == '=') {
                        currentState = 35;
                    }
                    else if (currentChar == '>') {
                        currentState = 36;
                    }
                    else if (Character.isDigit(currentChar)) {
                        currentState = 38;
                    }
                    else if (currentChar == ',') {
                        currentState = 43;
                    }
                    else if (Character.isAlphabetic(currentChar)) {
                        currentState = 99;
                    }
                    else {
                        currentState = 999;
                    }

                }
                else if (currentState == 1) {
                    if (currentChar == ' '){
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (currentChar == 'e') {
                        currentState = 2;
                    }
                    else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    }
                    else currentState = 999;
                }
                else if (currentState == 2) {
                    if (currentChar == ' '){
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (currentChar == 'l') {
                        currentState = 3;
                    }
                    else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    }
                    else currentState = 999;
                }
                else if (currentState == 3) {
                    if (currentChar == ' '){
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (currentChar == 'e') {
                        currentState = 4;
                    }
                    else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    }
                    else currentState = 999;
                }
                else if (currentState == 4) {
                    if (currentChar == ' '){
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (currentChar == 'c') {
                        currentState = 5;
                    }
                    else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    }
                    else currentState = 999;
                }
                else if (currentState == 5) {
                    if (currentChar == ' '){
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (currentChar == 't') {
                        currentState = 6;
                    }
                    else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    }
                    else currentState = 999;
                }
                else if (currentState == 6) {
                    if (currentChar == ' '){
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    }
                    else currentState = 999;
                }
                else if (currentState == 7) {
                    if (currentChar == ' '){
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (currentChar == 'r') {
                        currentState = 8;
                    }
                    else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    }
                    else currentState = 999;
                }
                else if (currentState == 8) {
                    if (currentChar == ' '){
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (currentChar == 'o') {
                        currentState = 9;
                    }
                    else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    }
                    else currentState = 999;
                }
                else if (currentState == 9) {
                    if (currentChar == ' '){
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (currentChar == 'm') {
                        currentState = 10;
                    }
                    else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    }
                    else currentState = 999;
                }
                else if (currentState == 10) {
                    if (currentChar == ' ') {
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    }
                    else currentState = 999;
                }
                else if (currentState == 11) {
                    if (currentChar == ' '){
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (currentChar == 'h') {
                        currentState = 12;
                    }
                    else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    }
                    else currentState = 999;
                }
                else if (currentState == 12) {
                    if (currentChar == ' '){
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (currentChar == 'e') {
                        currentState = 13;
                    }
                    else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    }
                    else currentState = 999;
                }
                else if (currentState == 13) {
                    if (currentChar == ' '){
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (currentChar == 'r') {
                        currentState = 14;
                    }
                    else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    }
                    else currentState = 999;
                }
                else if (currentState == 14) {
                    if (currentChar == ' '){
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (currentChar == 'e') {
                        currentState = 15;
                    }
                    else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    }
                    else currentState = 999;
                }
                else if (currentState == 15) {
                    if (currentChar == ' '){
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    }

                    else currentState = 999;
                }
                else if (currentState == 16) {
                    if (currentChar == ' '){
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (currentChar == 'n') {
                        currentState = 17;
                    }
                    else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    }
                    else currentState = 999;
                }
                else if (currentState == 17) {
                    if (currentChar == ' '){
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (currentChar == 'd') {
                        currentState = 18;
                    }
                    else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    }
                    else currentState = 999;
                }
                else if (currentState == 18) {
                    if (currentChar == ' '){
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    }
                    else currentState = 999;
                }
                else if (currentState == 19) {
                    if (currentChar == ' '){
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (currentChar == 'i') {
                        currentState = 20;
                    }
                    else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    }
                    else currentState = 999;
                }
                else if (currentState == 20) {
                    if (currentChar == ' '){
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (currentChar == 'k') {
                        currentState = 21;
                    }
                    else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    }
                    else currentState = 999;
                }
                else if (currentState == 21) {
                    if (currentChar == ' '){
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (currentChar == 'e') {
                        currentState = 22;
                    }
                    else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    }

                    else currentState = 999;
                }
                else if (currentState == 22) {
                    if (currentChar == ' '){
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    }
                    else currentState = 999;
                }
                else if (currentState == 23) {
                    if (currentChar == ' '){
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (currentChar == 'o') {
                        currentState = 24;
                    }
                    else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    }
                    else currentState = 999;
                }
                else if (currentState == 24) {
                    if (currentChar == ' '){
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (currentChar == 't') {
                        currentState = 25;
                    }
                    else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    }
                    else currentState = 999;
                }
                else if (currentState == 25) {
                    if (currentChar == ' '){
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    }
                    else currentState = 999;
                }
                else if (currentState == 26) {
                    if (currentChar == ' '){
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (currentChar == 'r') {
                        currentState = 27;
                    }
                    else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    }
                    else currentState = 999;
                }
                else if (currentState == 27) {
                    if (currentChar == ' '){
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    }
                    else currentState = 999;
                }
                else if (currentState == 28) {
                    if (currentChar == ' '){
                        finalState(currentState);
                        currentState = 0;
                    }

                    else currentState = 999;
                }
                else if (currentState == 29) {
                    if (currentChar == ' '){
                        finalState(currentState);
                        currentState = 0;
                    }

                    else currentState = 999;
                }
                else if (currentState == 30) {
                    if (currentChar == ' '){
                        finalState(currentState);
                        currentState = 0;
                    }
                    else currentState = 999;
                }
                else if (currentState == 31) {
                    if (currentChar == ' '){
                        finalState(currentState);
                        currentState = 0;
                    }

                    else currentState = 999;
                }
                else if (currentState == 32) {
                    if (currentChar == ' '){
                        finalState(currentState);
                        currentState = 0;
                    }

                    else currentState = 999;
                }
                else if (currentState == 33) {
                    if (currentChar == ' '){
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (currentChar == '='){
                        currentState = 34;
                    }

                    else currentState = 999;
                }
                else if (currentState == 34) {
                    if (currentChar == ' '){
                        finalState(currentState);
                        currentState = 0;
                    }

                    else currentState = 999;
                }
                else if (currentState == 35) {
                    if (currentChar == ' '){
                        finalState(currentState);
                        currentState = 0;
                    }

                    else currentState = 999;
                }
                else if (currentState == 36) {
                    if (currentChar == ' '){
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (currentChar == '='){
                        currentState = 37;
                    }

                    else currentState = 999;
                }
                else if (currentState == 37) {
                    if (currentChar == ' '){
                        finalState(currentState);
                        currentState = 0;
                    }

                    else currentState = 999;
                }
                else if (currentState == 38) {
                    if (currentChar == ' '){
                        finalState(currentState);
                        currentState = 0;
                    }

                    else if (Character.isDigit(currentChar)){
                        currentState = 38;
                    }
                    else if (currentChar =='.'){
                        currentState = 39;
                    }
                    else currentState = 999;
                }
                else if (currentState == 39) {
                    if (Character.isDigit(currentChar)){
                        currentState = 40;
                    }
                    else currentState = 999;
                }
                else if (currentState == 40) {
                    if (currentChar == ' '){
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (Character.isDigit(currentChar)){
                        currentState = 40;
                    }
                    else currentState = 999;
                }
                else if (currentState == 41) {
                    if (currentChar == '"'){
                        currentState = 42;
                        isString = false;
                    }
                    else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    }
                    else currentState = 41;
                }
                else if (currentState == 42) {
                    if (currentChar == ' '){
                        finalState(currentState);
                        currentState = 0;
                    }
                    else currentState = 999;
                }
                else if (currentState == 43) {
                    if (currentChar == ' '){
                        finalState(currentState);
                        currentState = 0;
                    }
                    else currentState = 999;
                }
                else if (currentState == 99) {
                    if (currentChar == ' '){
                        finalState(currentState);
                        currentState = 0;
                    }
                    else if (Character.isAlphabetic(currentChar) ||  Character.isDigit(currentChar)) {
                        currentState = 99;
                    }
                    else currentState = 999;
                }
                else {
                    System.out.println("SYNTAX ERROR");
                    break;
                }
                if (currentChar != ' ' || isString){
                    word += currentChar;
                }
                currentChar = queryLine.charAt(++i);

            }

        }
    }
    private void finalState(int currentState){
        switch(currentState){
            case 6:
                //select
                tables.add(new TableFormat(word, "KEYWORD", 15));
                break;
            case 10:
                // from
                tables.add(new TableFormat(word, "KEYWORD", 16));
                break;
            case 15:
                // where
                tables.add(new TableFormat(word, "KEYWORD", 17));
                break;
            case 18:
                // and
                tables.add(new TableFormat(word, "KEYWORD", 18));
                break;
            case 22:
                // like
                tables.add(new TableFormat(word, "KEYWORD", 19));
                break;
            case 25:
                // not
                tables.add(new TableFormat(word, "KEYWORD", 20));
                break;
            case 27:
                // or
                tables.add(new TableFormat(word, "KEYWORD", 21));
                break;
            case 28:
                // (
                tables.add(new TableFormat(word, "KEYWORD", 0));
                break;
            case 29:
                // )
                tables.add(new TableFormat(word, "KEYWORD", 1));
                break;
            case 30:
                // *
                tables.add(new TableFormat(word, "KEYWORD", 2));
                break;
            case 31:
                // .
                tables.add(new TableFormat(word, "KEYWORD", 3));
                break;
            case 32:
                // ;
                tables.add(new TableFormat(word, "KEYWORD", 4));
                break;

            case 33:
                // <
                tables.add(new TableFormat(word, "KEYWORD", 6));
                break;
            case 34:
                // <=
                tables.add(new TableFormat(word, "KEYWORD", 9));
                break;
            case 35:
                // =
                tables.add(new TableFormat(word, "KEYWORD", 7));
                break;
            case 36:
                // >
                tables.add(new TableFormat(word, "KEYWORD", 8));
                break;
            case 37:
                // >=
                tables.add(new TableFormat(word, "KEYWORD", 10));
                break;
            case 38:
                // INTEGER
                tables.add(new TableFormat(word, "CONSTANT", 13));
                break;
            case 40:
                // REAL
                tables.add(new TableFormat(word, "CONSTANT", 13));
                break;
            case 42:
                // STRING
                tables.add(new TableFormat(word, "CONSTANT", 14));
                break;
            case 43:
                // ,
                tables.add(new TableFormat(word, "KEYWORD", 5));
                break;
            case 0:
                break;
            case 99:
                // VARIABLE
                tables.add(new TableFormat(word, "VARIABLE", 12));
                break;

        }
        word = "";
    }
}


