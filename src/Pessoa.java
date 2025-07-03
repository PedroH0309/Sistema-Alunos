public sealed abstract class Pessoa permits Candidato{
    private String name;
    private int age;
    private String email;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws ValidarPassword{
        if (password.length() < 8 && !(password.matches(".*\\d.*")) && !(password.matches(".*[A-Z].*"))){
            throw new ValidarPassword("Senha inválida: pricisa de uma caráctere especial e letra maiuscula");
        }
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) throws ValidarEmail{
        if (email == null || !email.contains("@") || !email.contains(".")){
            throw new ValidarEmail("Email inválido: precisa conter '@' e '.'");
        }
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws ValidarAge{
        if (age < 18 || age > 80){
            throw new ValidarAge("Idade inválida");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws ValidarName{
        if (name.length() < 3 || name.matches(".*\\d.*")){
            throw new ValidarName("Nome inválido");
        }
        this.name = name;
    }

    public boolean autenticar(String autenticarUsuario, String autenticarSenha){
        return this.email.equals(autenticarUsuario) && this.password.equals(autenticarSenha);
    }
}

class ValidarPassword extends Exception{
    public ValidarPassword(String msg){
        super(msg);
    }
}

class ValidarEmail extends Exception{
    public ValidarEmail(String msg){
        super(msg);
    }
}

class ValidarAge extends Exception{
    public ValidarAge(String msg){
        super(msg);
    }
}

class ValidarName extends Exception{
    public ValidarName(String msg){
        super(msg);
    }
}

class ValidarProva extends Exception{
    public ValidarProva (String msg){
        super(msg);
    }
}