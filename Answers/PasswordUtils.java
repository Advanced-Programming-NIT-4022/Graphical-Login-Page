package Answers;

import java.util.SplittableRandom;

public class PasswordUtils
{
    public String PasswordDifficulty(String password)
    {
        char[] passwordArr = password.toCharArray();
        int passwordLength = password.length();

        if (passwordLength < 8)
        {
            return "Password must be longer than 8 characters!";
        }
        else if (!hasUpperCase(password) && !hasLowerCase(password))
        {
            return "Password must have UpperCase and LoweCase!";
        }
        else if (!hasUpperCase(password))
        {
            return "Password must have UpperCase!";
        }
        else if (!hasLowerCase(password))
        {
            return "Password must have LoweCase";
        }
        else if (!hasNumber(password))
        {
            return "Password must have Number";
        }
        else if (!hasSpecialCharacters(password))
        {
            return "Password must have Special Characters";
        }

        return "Password is Strong.";
    }
    public boolean hasUpperCase(String password)
    {
        char[] passwordArr = password.toCharArray();
        int passwordLength = password.length();

        for (int i = 0 ; i < passwordLength ; i++)
        {
            if (passwordArr[i] >= 65 && passwordArr[i] <= 90)
            {
                return true;
            }
        }
        return false;
    }
    public boolean hasLowerCase(String password)
    {
        char[] passwordArr = password.toCharArray();
        int passwordLength = password.length();

        for (int i = 0 ; i < passwordLength ; i++)
        {
            if (passwordArr[i] >= 97 && passwordArr[i] <= 122)
            {
                return true;
            }
        }
        return false;
    }
    public boolean hasNumber(String password)
    {
        char[] passwordArr = password.toCharArray();
        int passwordLength = password.length();

        for (int i = 0 ; i < passwordLength ; i++)
        {
            if (passwordArr[i] == '0' || passwordArr[i] == '1' || passwordArr[i] == '2' || passwordArr[i] == '3' || passwordArr[i] == '4' || passwordArr[i] == '5' || passwordArr[i] == '6' || passwordArr[i] == '7' || passwordArr[i] == '8' || passwordArr[i] == '9')
            {
                return true;
            }
        }
        return false;
    }
    public boolean hasSpecialCharacters(String password)
    {
        char[] passwordArr = password.toCharArray();
        int passwordLength = password.length();

        for (int i = 0 ; i < passwordLength ; i++)
        {
            if (passwordArr[i] == '!' || passwordArr[i] == '@' || passwordArr[i] == '$' || passwordArr[i] == '%' || passwordArr[i] == '^' || passwordArr[i] == '&' || passwordArr[i] == '*' || passwordArr[i] == '(' || passwordArr[i] == ')' || passwordArr[i] == '?' || passwordArr[i] == '/' || passwordArr[i] == ',' || passwordArr[i] == '.' || passwordArr[i] == '<' || passwordArr[i] == '>' || passwordArr[i] == ':' || passwordArr[i] == ';' || passwordArr[i] == '-' || passwordArr[i] == '_' || passwordArr[i] == '+' || passwordArr[i] == '=' || passwordArr[i] == '[' || passwordArr[i] == ']' || passwordArr[i] == '{' || passwordArr[i] == '}' || passwordArr[i] == '`' || passwordArr[i] == '~')
            {
                return true;
            }
        }
        return false;
    }
}