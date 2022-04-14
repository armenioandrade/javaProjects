/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exerciciosedabit;

/**
 * Create a function that will test if a string is a valid PIN or not via a
 * regular expression.
 *
 * A valid PIN has:
 *
 * Exactly 4 or 6 characters. Only numeric characters (0-9). No whitespace.
 * Examples validate("121317") ➞ true
 *
 * validate("1234") ➞ true
 *
 * validate("45135") ➞ false
 *
 * validate("89abc1") ➞ false
 *
 * validate("900876") ➞ true
 *
 * validate(" 4983") ➞ false Notes Empty strings should return false when
 * tested. If you need help, look into the Resources tab.
 */
public class ValidatePIN {

    private String pin;

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public boolean PINValidation(String pin) {
        String[] arrayPin = pin.split(pin);
        boolean validador = false;
        for (int i = 0; i < arrayPin.length; i++) {
            if(arrayPin[i].contains(" ")){
                validador = false;
            }else if(arrayPin[i].matches("[a-z][A-Z]")){
                validador = false;
            }else if(arrayPin[i].isEmpty()){
                validador = false;
            }else{
                validador = true;
            }
        }
     return validador;
    }
  

}
