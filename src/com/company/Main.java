package com.company;

public class Main {

    public static void main(String[] args) throws MyArrayDataException{
        String[][]arr = {{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"}};
        String[][]arr2 = {{"1","2","3","4"},{"1","2","3","4","4"},{"1","2","3","4"},{"1","2","3","4"}};
        String[][]arr3 = {{"1","2","три","4"},{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"}};

        System.out.println("Проверка массива arr");
        chekArray(arr);
        System.out.println("Проверка массива arr2");
        chekArray(arr2);
        System.out.println("Проверка массива arr3");
        chekArray(arr3);    }
        
    public static int chekArray(String[][] args) throws MyArrayDataException{

        try {
            if (args.length!=4 || args[0].length!=4 || args[1].length!=4 || args[2].length!=4 || args[3].length!=4)
                throw new MyArraySizeException();

        }catch (MyArraySizeException e){
            System.out.println("Неправильный размер массива: " + e);

        }

        int summ = 0;
        int arrInt = 0;

        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < args[0].length; j++) {

                try {
                    arrInt = Integer.parseInt(args[i][j]);
                    summ = summ + arrInt;
                } catch (IllegalArgumentException e) {
                    throw new MyArrayDataException("Ошибка в " + (i+1) + " столбце " + (j+1) + " ячейке");
                }
            }
        }
        System.out.println("Сумма всех элементов массива составляет: " + summ);
        return summ;
    }
}

class MyArraySizeException extends Exception{
    public MyArraySizeException (){
        super();
    }
}

class MyArrayDataException extends Exception{
    public MyArrayDataException (String message){
        super(message);
    }
}
