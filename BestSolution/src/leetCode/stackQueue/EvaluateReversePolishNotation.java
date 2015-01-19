package leetCode.stackQueue;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
        Stack<Integer> oprands =new Stack<Integer> (); 
        String ops = "+-*/"; 
        for (String s : tokens) {
            if (ops.contains(s)) {
                if (oprands.isEmpty() || oprands.size()<=1) return 0; 
                int op2=oprands.pop(); 
                int op1=oprands.pop(); 
                int index=ops.indexOf(s); 
                switch (index) {
                    case 0: oprands.push(op2+op1); break; 
                    case 1: oprands.push(op1-op2); break;
                    case 2: oprands.push(op1*op2); break;
                    case 3: oprands.push(op1/op2);  
                }
            } else {
                oprands.push(Integer.parseInt(s));
            }
        }
        return oprands.isEmpty() ? 0 : oprands.pop();
    }
}
