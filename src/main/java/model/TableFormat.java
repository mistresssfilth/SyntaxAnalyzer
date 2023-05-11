package model;

public final class TableFormat {
    private String text;
    private String valueLexic;
    private int tokenLexic;

    public TableFormat(String text, String valueLexic, int tokenLexic) {
        this.text = text;
        this.valueLexic = valueLexic;
        this.tokenLexic = tokenLexic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValueLexic() {
        return valueLexic;
    }

    public void setValueLexic(String valueLexic) {
        this.valueLexic = valueLexic;
    }

    public int getTokenLexic() {
        return tokenLexic;
    }

    public void setTokenLexic(int tokenLexic) {
        this.tokenLexic = tokenLexic;
    }

    public void print(){
        System.out.println("");
        if (text.length() < 4){
            System.out.println("\t\t" + text + "\t|\t\t" + valueLexic + "\t\t|\t\t" + tokenLexic);
        }
        else
            System.out.println("\t" + text + "\t|\t\t" + valueLexic + "\t\t|\t\t" + tokenLexic);
    }

}
