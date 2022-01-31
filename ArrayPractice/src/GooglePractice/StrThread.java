package GooglePractice;

import java.util.concurrent.Callable;

public class StrThread implements Callable<StrModel> {

    int index;
    String chunk;
    public StrThread(int index,String chunk){
        this.index = index;
        this.chunk = chunk;

    }

    @Override
    public StrModel call() {
        StrModel result = new StrModel();
        result.index = index;
        for (int i = 0; i < chunk.length(); i++) {
            if (chunk.charAt(i) == '(') {
                result.balance++;
            } else {
                result.balance--;
                result.negativeDepth =
                        Math.min(result.balance, result.negativeDepth);
            }
        }
        System.out.println("str " + chunk + " index " + index +
                " balance " + result.balance +
                " negative depth " + result.negativeDepth);

        return result;
    }
}
