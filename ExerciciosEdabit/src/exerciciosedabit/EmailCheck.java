package exerciciosedabit;
import java.text.StringCharacterIterator;
/*
Create a function that accepts a string, checks if it's a valid email address and returns either true or false, depending on the evaluation.

The string must contain an @ character.
The string must contain a . character.
The @ must have at least one character in front of it.
e.g. "e@edabit.com" is valid while "@edabit.com" is invalid.
The . and the @ must be in the appropriate places.
e.g. "hello.email@com" is invalid while "john.smith@email.com" is valid.
If the string passes these tests, it's considered a valid email address.

Examples
validateEmail("@gmail.com") ➞ false

validateEmail("hello.gmail@com") ➞ false

validateEmail("gmail") ➞ false

validateEmail("hello@gmail") ➞ false

validateEmail("hello@edabit.com") ➞ true
Notes
Check the Tests tab to see exactly what's being evaluated.
You can solve this challenge with RegEx, but it's intended to be solved with logic.
Solutions using RegEx will be accepted but frowned upon :(

email.startsWith("@") || email.startsWith(".") || email.startsWith("#") || email.startsWith("!") || emailValidation("?")

 */
public class EmailCheck {

    public boolean emailValidation(String email) {
        boolean invalido = true;
        String[] arrayEmail = new String[email.length()];
        char[] letrasENumeros ={'a','b','c','d','e','f','g','h','i',
            'j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
            '0','1','2','3','4','5','6','7','8','9'};
        
        int contadorAux = 0;
        for (int i = 1; i <= arrayEmail.length; i++) {
            arrayEmail[contadorAux] = email.substring(contadorAux,i);
            contadorAux++;
        }
        
        
        for (int i = 0; i < letrasENumeros.length; i++) {
            if(email.startsWith(String.valueOf(letrasENumeros[i]))){
                for (int j = 0; j < arrayEmail.length; j++) {
                    if(arrayEmail[j].equalsIgnoreCase("@")){
                        for (int k = 0; k < arrayEmail.length; k++) {
                              if(email.endsWith(".com") || email.endsWith(".com.br")){
                                  return true;
                              }
                        }
                    }
                }
            }
        }
        return false;
    }
    
}

