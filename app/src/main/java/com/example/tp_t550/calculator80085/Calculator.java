package com.example.tp_t550.calculator80085;

class CalculatorMemory {

    private int[] numArray;
    private Operator operator;
    private boolean justPressedEquals;

    CalculatorMemory(Operator op){
        numArray = new int[2];
        operator = op;
        justPressedEquals = false;

    }

    public int enterNumber(int num) {
        int numUpdated;
        if(justPressedEquals == true){
            clearMemory();
        }
        if (operator == Operator.NULL) {
                updateNum1(num);
                numUpdated = 0;
        } else {
                updateNum2(num);
                numUpdated = 1;
        }

        return numUpdated;
    }


    public void setJustPressedEquals(boolean ex){
        justPressedEquals = ex;
    }

    public void updateNum1 (int num) {
        numArray[0] = numArray[0] * 10 + num;

    }

    public void updateNum2 (int num){
        numArray[1] = numArray[1] * 10 + num;
    }

    public void updateOperator(Operator op){
        if (numArray[1] != 0){
            execute();
        }
        operator = op;
    }

    public int getNum1() {
        return numArray[0];
    }

    public int getNum2() {
        return numArray[1];
    }

    public Operator getOperator() {
        return operator;
    }

    public void clearMemory(){
        numArray[0] = 0;
        numArray[1] = 0;
        operator = Operator.NULL;
    }

    public int execute(){
        int result = 0;
        if (numArray[1] == 0){
            result = numArray[0];}
        else {
            switch (operator.getValue()) {
                case "+":
                    result = numArray[0] + numArray[1];
                    break;
                case "-":
                    result = numArray[0] - numArray[1];
                    break;
                case "*":
                    result = numArray[0] * numArray[1];
                    break;
                case "/":
                    result = numArray[0] / numArray[1];
                    break;
            }
            clearMemory();
            numArray[0] = result;
        }

            return result;
        }
    }

