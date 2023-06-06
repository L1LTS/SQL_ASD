import java.util.List;
import java.util.Stack;
import java.util.*;

public class Parser {

    private final List<Token> tokens;

    private final Token identificador = new Token(TipoToken.IDENTIFICADOR, "");
    private final Token select = new Token(TipoToken.SELECT, "select");
    private final Token from = new Token(TipoToken.FROM, "from");
    private final Token distinct = new Token(TipoToken.DISTINCT, "distinct");
    private final Token coma = new Token(TipoToken.COMA, ",");
    private final Token punto = new Token(TipoToken.PUNTO, ".");
    private final Token asterisco = new Token(TipoToken.ASTERISCO, "*");
    private final Token finCadena = new Token(TipoToken.EOF, "");

    private int i = 0;
    private boolean hayErrores = false;
    private Token preanalisis;

    String [][] matrix = { { "-", "SELECT", "FROM", "DISTINCT", "ASTERISCO", "COMA", "IDENTIFICADOR", "PUNTO", "EOF" },
            { "Q", "select D from T", "-", "-", "-", "-", "-", "-", "-"},
            { "D", "-", "-", "distinct P", "P", "P", "P", "-", "-"},
            { "P", "-", "-", "-", "*", "A", "A", "-", "-"},
            { "A", "-", "-", "-", "-", "A_2 A_1", "A_2 A_1", "-", "-"},
            { "A_1", "-", "E", "-", "-", ", A", "-", "-", "-"},
            { "A_2", "-", "-", "-", "-", "-", "identificador A_3", "-", "-"},
            { "A_3", "-", "E", "-", "-", "E", "-", ". identificador", "-"},
            { "T", "-", "-", "-", "-", "T_2 T_1", "T_2 T_1", "-", "-"},
            { "T_1", "-", "-", "-", "-", ", T", "-", "-", "E"},
            { "T_2", "-", "-", "-", "-", "-", "identificador T_3", "-", "-"},
            { "T_3", "-", "-", "-", "-", "-", "identificador", "-", "E"}};

    Stack<String> stk = new Stack<>();

    public Parser(List<Token> tokens){
        this.tokens = tokens;
    }

    public void parse(){
        i = 0;
        int row1=0, colm1=0;
        //System.out.println(preanalisis);

        preanalisis = tokens.get(i);
        String ar = tokens.get(i).tipo.toString();

        //System.out.println(preanalisis);
        //System.out.println(tokens);

        stk.push("EOF");
        stk.push("Q");


        String strpeek = stk.peek();

        //System.out.println(strpeek);
        //String str = matrix[0][1];
        //System.out.println(str);
        //System.out.println(matrix.length);
        /*
        for(int j=1; j<12; j++){
            if(matrix[j][0] == strpeek)
                row1 = j;
        }
        */
        //String prestr = preanalisis.lexema;
        //System.out.print(prestr instanceof String);
        //System.out.println(prestr);
        //System.out.println(ar);

        //System.out.println(matrix[0][1] == prestr);

        //System.out.print(matrix[0][1].toString() instanceof String);
        //System.out.println(matrix[0][1].getClass().getName());
        //System.out.println(preanalisis.tipo.toString().getClass().getName());

        //System.out.println(matrix[0][1].toString() == prestr);
        /*
        for(int h=1; h<9; h++){
            //System.out.println(matrix[0][h] == ar);
            //System.out.println(matrix[0][h].equals(preanalisis));
            //System.out.println(preanalisis.equals(matrix[0][h]));
            if(ar == matrix[0][h]){
                //System.out.println(matrix[0][h]);
                //System.out.println(h);
                colm1 = h;
            }
        }*/

        //System.out.println(preanalisis.lexema.toString());
        //System.out.println(preanalisis.posicion);
        //System.out.println(matrix[0][h].equals(preanalisis));

        //System.out.println(row1);
        //System.out.println(colm1);

        //String str1 = matrix[row1][colm1];
        //System.out.println(str1);

        //String[] strsplit = str1.split(" ");

        //System.out.println(strsplit[0]);
        //System.out.println(ar);
        //System.out.println(preanalisis.lexema);
        //System.out.println(preanalisis);
        /*
        for (int i=strsplit.length-1; i>=0; i--){
            System.out.println(strsplit[i] + i);
        }
        */
        /*
        String strsplit1 = strsplit[0].toString();

        System.out.println(strsplit[0] == ar.toLowerCase());
        System.out.println(strsplit[0].equals(ar));
        System.out.println(strsplit[0].equals(preanalisis.lexema));
        System.out.println(strsplit[0].toString() == preanalisis.lexema);
        System.out.println(strsplit[0].toString() == preanalisis.lexema.toString());
        System.out.println(strpeek == "Q");
         */


        while(strpeek != "EOF"){

            if(hayErrores == true)
                break;

            for(int j=1; j<12; j++){
                //System.out.println(j);
                //System.out.println(strpeek);
                if(strpeek.equals(matrix[j][0])) {
                    //System.out.println("row--: " + j);
                    //System.out.println(matrix[j][0]);
                    //System.out.println(strpeek);
                    row1 = j;
                }
            }

            for(int j=1; j<9; j++){
                if(matrix[0][j] == ar)
                    colm1 = j;
            }

            //String[] strsplit = str1.split(" ");

            String str = matrix[row1][colm1];

            /*
            System.out.println("PREANALEX: " + preanalisis.lexema);
            System.out.println("PREANATIPO: " + preanalisis.tipo);
            System.out.println("AR: " + ar);
            System.out.println("peek: " + strpeek);
            //System.out.println("split: " + strsplit[0]);
            System.out.println("str: " + str);
            //System.out.println(str != "-");
            //System.out.println("Ojo str peek y lexema: ");
            //System.out.println(strpeek.equals(preanalisis.lexema));
            //System.out.println("Ojo str peek y TIPO: ");
            //System.out.println(strpeek.equals(preanalisis.tipo));
            //System.out.println("Ojo ar y TIPO: ");
            //System.out.println(ar.equals(preanalisis.tipo));
            //System.out.println("Ojo ar y pre: ");
            //System.out.println(ar.equals(preanalisis));
            //System.out.println("Ojo str y pre: ");
            //System.out.println(ar.equals(preanalisis));
            System.out.println(row1);
            System.out.println(colm1);
            */

            //strpeek.equals(preanalisis.lexema)



            if(strpeek.equals(preanalisis.lexema) || strpeek.equals("identificador")){
                //System.out.println("asdf1");
                //System.out.println(preanalisis.lexema);
                stk.pop();
                i++;
                preanalisis = tokens.get(i);
                ar = tokens.get(i).tipo.toString();
                //System.out.println(preanalisis.lexema);
            }else if(str == "-"){
                //System.out.println("asdf3");
                hayErrores = true;
                System.out.println("Error en la posición " + preanalisis.posicion + ". No se esperaba el token " + preanalisis.tipo);
            }else if(str != "-"){
                //System.out.println("asdf4");
                if(str == "E") {
                    stk.pop();
                }else{
                    stk.pop();
                    String[] strsplit = str.split(" ");
                    for (int i=strsplit.length-1; i>=0; i--){
                        stk.push(strsplit[i]);
                    }
                    //System.out.println("Initial Stack: " + stk);
                }

                //strpeek = stk.peek();
                //System.out.println("Ojo peek y split: ");
                //System.out.println("peek: " + strpeek);
                //System.out.println("split: " + strsplit[0]);
                //System.out.println(strpeek.equals(strsplit[0]));
            }
            strpeek = stk.peek();

            //System.out.println("------------");
        }

        if(!hayErrores && !preanalisis.equals(finCadena)){
            System.out.println("Error en la posición " + preanalisis.posicion + ". No se esperaba el token " + preanalisis.tipo);
        }
        else if(!hayErrores && preanalisis.equals(finCadena)){
            System.out.println("Consulta válida");
        }
    }

    /*if(i != 0){
                System.out.println("asdf2");
                if(strpeek == "Q" || strpeek == "D" || strpeek == "P" || strpeek == "A" || strpeek == "A_1" || strpeek == "A_2" || strpeek == "A_3" || strpeek == "T" || strpeek == "T_1" || strpeek == "T_2" || strpeek == "T_3") {
                    System.out.println("asdf2");
                    hayErrores = true;
                    break;
                }
            }else */

}
