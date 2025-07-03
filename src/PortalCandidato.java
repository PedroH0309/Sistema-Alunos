import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PortalCandidato {
    public static void main (String[] args) {
        var scanner = new Scanner(System.in);
        List<Candidato> candidatoList = new ArrayList<>();
        var erro = "ERRO: ";

        while (true) {
            System.out.println("=====BEM VINDO AO PORTAL ESTUDANTE=====");
            System.out.println("//entre para validar a sua nota!!");
            System.out.println("(1).CADASTRAR");
            System.out.println("(2).ENTRAR");
            System.out.println("(3).SAIR");
            var option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Cadastrando Informe:");
                    System.out.println("======================");

                    var novoUsuario = new Candidato();

                    while (true) {
                        System.out.println("Nome: ");
                        var nome = scanner.nextLine();

                        try {
                            novoUsuario.setName(nome);
                            break;
                        } catch (ValidarName e) {
                            System.out.println(erro + e.getMessage());
                        }
                    }

                    System.out.println("=====");

                    while (true) {
                        System.out.println("Idade: ");
                        var idade = scanner.nextInt();
                        scanner.nextLine();

                        try {
                            novoUsuario.setAge(idade);
                            break;
                        } catch (ValidarAge e) {
                            System.out.println(erro + e.getMessage());
                        }
                    }

                    System.out.println("=====");

                    while (true) {
                        System.out.println("Email: ");
                        var email = scanner.nextLine();

                        try {
                            novoUsuario.setEmail(email);
                            break;
                        } catch (ValidarEmail e) {
                            System.out.println(erro + e.getMessage());
                        }
                    }


                    System.out.println("=====");

                    while (true) {
                        System.out.println("Senha: (letra maiuscula e caracteres especiais.)");
                        var senha = scanner.nextLine();


                        try {
                            novoUsuario.setPassword(senha);
                            break;
                        } catch (ValidarPassword e) {
                            System.out.println(erro + e.getMessage());
                        }
                    }

                    System.out.println("Cadastro realizado com sucesso!");

                    candidatoList.add(novoUsuario);

                    break;

                case 2:
                    System.out.println("Entrando...Informe: ");
                    System.out.println("======================");

                    Candidato candidatoLogado = null;

                    while (true) {
                        System.out.println("Email: ");
                        var emailEntrar = scanner.nextLine();


                        System.out.println("Senha: ");
                        var senhaEntrar = scanner.nextLine();


                        for (Candidato c : candidatoList) {
                            if (c.autenticar(emailEntrar, senhaEntrar)) {
                                System.out.println("Login bem-sucedido!");
                                candidatoLogado = c;
                                break;
                            }
                        }

                        if (candidatoLogado == null) {
                            System.out.println("Email e senha inválidos!");
                        } else {
                            break;
                        }
                    }

                    while (true) {
                        System.out.println("Descobrindo sua aprovação....");
                        System.out.println("Informe sua nota: ");
                        var nota = scanner.nextInt();
                        scanner.nextLine();

                        try {
                            candidatoLogado.informarNota(nota);
                            break;
                        } catch (ValidarProva e) {
                            System.out.println(erro + e.getMessage());
                        }
                    }

                    if (candidatoLogado.getNotaProva() >= 70){
                        System.out.println("Parabéns, você foi APROVADO!");
                    } else {
                        System.out.println("Infelizmente, você foi REPROVADO.");
                    }

                    break;


                case 3:
                    System.out.println("==================");
                    System.out.println("SAINDO...");
                    scanner.close();
                    return;


                default:
                    System.out.println("Número Inválido");
                    break;
            }
        }
    }
}