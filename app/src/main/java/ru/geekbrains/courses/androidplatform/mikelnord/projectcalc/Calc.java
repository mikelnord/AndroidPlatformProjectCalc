package ru.geekbrains.courses.androidplatform.mikelnord.projectcalc;

import android.os.Parcel;
import android.os.Parcelable;

public class Calc implements Parcelable {

    public static final String plus = "+";
    public static final String umn = "*";
    public static final String minus = "-";
    public static final String div = "/";


    private String value1;
    private String value2;
    private String operator;
    private final int digit;
    private String rezult;

    public Calc() {
        value1 = "0";
        value2 = "";
        operator = "";
        rezult = "0";
        digit = 10;
    }

    protected Calc(Parcel in) {
        value1 = in.readString();
        value2 = in.readString();
        operator = in.readString();
        digit = in.readInt();
        rezult = in.readString();
    }

    public static final Creator<Calc> CREATOR = new Creator<Calc>() {
        @Override
        public Calc createFromParcel(Parcel in) {
            return new Calc(in);
        }

        @Override
        public Calc[] newArray(int size) {
            return new Calc[size];
        }
    };

    public void changingSign() {
        if (value2.equals(""))
            value1 = String.valueOf((-1) * Double.parseDouble(value1));
        else
            value2 = String.valueOf((-1) * Double.parseDouble(value2));
    }

    public void clear() {
        value1 = "0";
        value2 = "";
        operator = "";
    }

    public void clearLast() {
        if (value2.equals(""))
            value1 = "";
        else
            value2 = "";
    }

    public void setVal(String s) {
        if (operator.equals("")) {
            if (value1.equals("") && s.equals(".")) {
                value1 = "0.";
            } else {
                if (value1.length() < digit) {
                    if (s.equals(".")) {
                        if (!value1.contains("."))
                            value1 = value1 + s;
                    } else {
                        if (value1.equals("0"))
                            value1 = s;
                        else
                            value1 = value1 + s;
                    }
                }
            }
        } else {
            if (value2.equals("") && s.equals(".")) {
                value2 = "0.";
            } else {
                if (value2.length() < digit) {
                    if (s.equals(".")) {
                        if (!value2.contains("."))
                            value2 = value2 + s;
                    } else {
                        value2 = value2 + s;
                    }
                }
            }
        }
    }

    public String getVal() {
        if (operator.equals("")) {
            return value1;
        }
        return value2;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getRezult() {
        if (value1.equals("") || value2.equals("")) {
            return "0";
        } else {
            switch (operator) {
                case plus:
                    rezult = String.valueOf(Double.parseDouble(value1) + Double.parseDouble(value2));
                    value1 = rezult;
                    value2 = "";
                    break;
                case minus:
                    rezult = String.valueOf(Double.parseDouble(value1) - Double.parseDouble(value2));
                    value1 = rezult;
                    value2 = "";
                    break;
                case umn:
                    rezult = String.valueOf(Double.parseDouble(value1) * Double.parseDouble(value2));
                    value1 = rezult;
                    value2 = "";
                    break;
                case div:
                    if (Double.parseDouble(value2) == 0) {
                        rezult = "EROR";
                    } else {
                        rezult = String.valueOf(Double.parseDouble(value1) / Double.parseDouble(value2));
                        value1 = rezult;
                        value2 = "";
                    }
                    break;
            }
        }
        return rezult;
    }

    public String getProc() {
        if (operator.equals(umn)) {
            operator = "";
            return String.valueOf((Double.parseDouble(value1) * Double.parseDouble(value2)) / 100);
        } else {
            return "0";
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(value1);
        parcel.writeString(value2);
        parcel.writeString(operator);
        parcel.writeInt(digit);
    }

}
