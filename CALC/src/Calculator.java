/**
 * Created by prulov on 20.05.2016.
 */
public class Calculator {

    private String[] oper = new String[]{"*", "/", "+", "-"};
    private double one;
    private double two;
    private double result;

    public Calculator(){

        this.oper = oper;
        this.one = one;
        this.two = two;
        this.result = result;
    }

    public double getOne() {
        return one;
    }

    public String[] getOper() {
        return oper;
    }

    public double getResult() {
        return result;
    }

    public double getTwo() {
        return two;
    }

    public void setOne(double one) {
        this.one = one;
    }

    public void setResult(String str) {
        this.result = calculation(str, one, two);
    }

    public void setTwo(double two) {
        this.two = two;
    }

    public double getFirstDouble(String jtfDisplayed){

        return Double.parseDouble(jtfDisplayed.substring(0, jtfDisplayed.length()));
    }

    public double getSecondDouble(String jtfDisplayed){

        int a = getOperIndex(jtfDisplayed);

        if(a > 0){
            return Double.parseDouble(jtfDisplayed.substring(a + 1, jtfDisplayed.length()));
        }else{
            return 0.0;
        }
    }

    public String getOperand(String jtfDisplayed){

        String result = "-";
        for(int i = 0; i < oper.length; i++){
            if(jtfDisplayed.contains(oper[i])){
                result = oper[i];
                break;
            }
        }
        System.out.println(result);
        return result;
    }

    private int getOperIndex(String jtfDisplayed){

        int result = 0;
        for(int i = 0; i < oper.length; i++){
            if(jtfDisplayed.contains(oper[i])){
                result = jtfDisplayed.indexOf(oper[i]);
                break;
            }
        }
        System.out.println(result);
        return result;
    }

    public double calculation(String str, double one, double two){

        if(str.equals("+")){
            result = one + two;
        }else if(str.equals("-")){
            result = one - two;
        }else if(str.equals("*")){
            result = one * two;
        }else if(str.equals("/")){
            result = one / two;
        }
        return result;
    }

    public double calcPercentage(String str, double one, double two){

        if(str.equals("+")){
            result = one + one / 100 * two;
        }else if(str.equals("-")){
            result = one - one / 100 * two;
        }else if(str.equals("*")){
            result = one / 100 * two;
        }else if(str.equals("/")){
            result = one / (one / 100 * two);
        }
        return result;
    }

}
