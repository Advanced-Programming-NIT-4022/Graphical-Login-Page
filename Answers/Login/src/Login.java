public class Login {                             // ورود به حساب
    public static int login(String gmail , String password){
        if((Users.checkUsers(gmail))== -1){
            //"The desired gmail was not found"
            return -1;
        }
        if(!(Password.checkPass(Users.checkUsers(gmail),password))){
            // wrong pass
            return -2;
        }
        return 0;
    }
}


