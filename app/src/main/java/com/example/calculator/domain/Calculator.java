package com.example.calculator.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class Calculator implements Parcelable {

    private static double firstDigit = 0;
    private static double secondDigit = 0;
    private static char symbol = '!';
    private static double lastNumber = 0;
    private static int dotFlag = 0;
    private static String returnStatement = "";
    private static boolean firstSecondFlag = false;
    private static char lastSymbol = '!';
    private static boolean firstDigitFlag = false;
    private static boolean secondDigitFlag = false;

    public Calculator() {
    }

    protected Calculator(Parcel in) {
        firstDigit = in.readDouble();
        secondDigit = in.readDouble();
        symbol = in.readString().charAt(0);
        lastNumber = in.readDouble();
        dotFlag = in.readInt();
        returnStatement = in.readString();
        firstSecondFlag = in.readBoolean();
        lastSymbol = in.readString().charAt(0);
        firstDigitFlag = in.readBoolean();
        secondDigitFlag = in.readBoolean();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(firstDigit);
        dest.writeDouble(secondDigit);
        dest.writeString(String.valueOf(symbol));
        dest.writeDouble(lastNumber);
        dest.writeInt(dotFlag);
        dest.writeString(returnStatement);
        dest.writeBoolean(firstSecondFlag);
        dest.writeString(String.valueOf(lastSymbol));
        dest.writeBoolean(firstDigitFlag);
        dest.writeBoolean(secondDigitFlag);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Calculator> CREATOR = new Creator<Calculator>() {
        @Override
        public Calculator createFromParcel(Parcel in) {
            return new Calculator(in);
        }

        @Override
        public Calculator[] newArray(int size) {
            return new Calculator[size];
        }
    };

    public static String getResult() {
        secondDigit = 0;
        symbol = '!';
        returnStatement = "";
        if (!secondDigitFlag && !firstSecondFlag) {
            if (dotFlag != 0) {
                firstDigit /= dotFlag;
            }
            return String.valueOf(firstDigit);
        } else {
            if (dotFlag != 0) {
                secondDigit /= dotFlag;
            }
        }
        secondDigitFlag = false;
        if (lastSymbol == '+') {
            firstDigit = firstDigit + lastNumber;
            returnStatement = String.valueOf(firstDigit);
            return String.valueOf(firstDigit);
        }
        if (lastSymbol == '-') {
            firstDigit = firstDigit - lastNumber;
            returnStatement = String.valueOf(firstDigit);
            return String.valueOf(firstDigit);
        }
        if (lastSymbol == '*') {
            firstDigit = firstDigit * lastNumber;
            returnStatement = String.valueOf(firstDigit);
            return String.valueOf(firstDigit);
        }
        if (lastSymbol == '/') {
            try {
                if (lastNumber == 0) {
                    throw new ArithmeticException();
                }
                firstDigit = firstDigit / lastNumber;
                returnStatement = String.valueOf(firstDigit);
                return String.valueOf(firstDigit);
            } catch (ArithmeticException e) {
                clear();
                return "ERROR";
            }
        }
        return "";
    }

    public static String newSymbol(char symb) {
        if (firstDigitFlag) {
            if (symbol == '!') {
                symbol = symb;
                returnStatement = returnStatement + " " + symbol + " ";
                if (dotFlag != 0) {
                    firstDigit /= dotFlag;
                    dotFlag = 0;
                }
            } else if (secondDigitFlag) {
                if (dotFlag != 0) {
                    secondDigit /= dotFlag;
                    dotFlag = 0;
                }
                getResult();
                symbol = symb;
                returnStatement = firstDigit + " " + symbol + " ";
            } else {
                returnStatement = returnStatement.replace(symbol, symb);
                symbol = symb;
            }
            firstSecondFlag = true;
        }
        lastSymbol = symbol;
        return returnStatement;
    }

    public static String number(int num) {
        firstDigitFlag = true;
        if (!firstSecondFlag) {
            firstDigit = firstDigit * 10 + num;
            dotFlag *= 10;
            returnStatement += String.valueOf(num);
        } else {
            if (symbol != '!') {
                secondDigitFlag = true;
                secondDigit = secondDigit * 10 + num;
                lastNumber = secondDigit;
                dotFlag *= 10;
                returnStatement += String.valueOf(num);
            } else {
                clear();
                number(num);
            }
        }
        return returnStatement;
    }

    public static String clear() {
        firstDigit = 0;
        secondDigit = 0;
        symbol = '!';
        lastNumber = 0;
        dotFlag = 0;
        returnStatement = "";
        firstSecondFlag = false;
        firstDigitFlag = false;
        secondDigitFlag = false;
        lastSymbol = '!';
        return returnStatement;
    }

    public static String dot() {
        if (firstSecondFlag && symbol == '!') {
            clear();
            returnStatement = "0.";
            dotFlag = 1;
        }
        if (dotFlag == 0 && !firstDigitFlag) {
            returnStatement = returnStatement + "0.";
            dotFlag = 1;
        } else if (dotFlag == 0 && !secondDigitFlag && firstSecondFlag) {
            returnStatement = returnStatement + "0.";
            dotFlag = 1;
        } else if (dotFlag == 0) {
            returnStatement = returnStatement + ".";
            dotFlag = 1;
        }
        return returnStatement;
    }
}
