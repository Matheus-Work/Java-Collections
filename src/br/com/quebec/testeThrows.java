package br.com.quebec;

public class testeThrows {
    public static void main(String[] args) {
        try {
            String cepFormatado = FormatarCep("2376064");
            System.out.println(cepFormatado);
        }
        catch(CepInvalidoException e){
            System.out.println("O campo cep não pertence aos negocios");
        }
    }
    static String FormatarCep(String cep) throws CepInvalidoException{
        if (cep.length() != 8) {
            throw new CepInvalidoException();
        }
            return "23.765-064";
    }
}
