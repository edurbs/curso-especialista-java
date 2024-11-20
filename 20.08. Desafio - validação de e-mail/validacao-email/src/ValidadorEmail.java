public class ValidadorEmail {

    public static boolean validar(String email) {

        return nomeValido(email) && dominioValido(email) && sufixoValido(email);

    }

    private static boolean nomeValido(String email) {
        int indexArroba = email.indexOf('@');
        if(indexArroba<0) {
            return false;
        }
        String nome = email.substring(0,indexArroba);
        if(nome.isBlank()) {
            return false;
        }
        if(naoTemEspaco(nome)){
            return false;
        }
        for(int i = 0; i<nome.length(); i++){
            char letra = nome.charAt(i);
            if(!Character.isLetter(letra)
                    && !Character.isDigit(letra)
                    && letra != '_'
                    && letra != '-'
                    && letra != '.'
            ) {
                return false;
            }
        }
        return true;
    }

    private static boolean naoTemEspaco(String nome) {
        return
                nome.strip().length() != nome.length();
    }

    private static boolean dominioValido(String email) {
        int indexArroba = email.indexOf('@');
        int indexSufixo = email.lastIndexOf('.');
        if(indexArroba < 0 || (indexSufixo < indexArroba)){
            return false;
        }
        String dominio = email.substring(indexArroba+1, indexSufixo);
        if(dominio.isBlank()){
            return false;
        }
        if(naoTemEspaco(dominio)){
            return false;
        }
        for(int i = 0; i<dominio.length(); i++){
            char letra = dominio.charAt(i);
            if(!Character.isLetter(letra)
                    && !Character.isDigit(letra)
                    && !Character.isLowerCase(letra)
                    && letra != '-'
                    && letra != '.'
            ) {
                return false;
            }
            if(Character.isUpperCase(letra)){
                return false;
            }
        }
        return true;
    }

    private static boolean sufixoValido(String email) {
        int index = email.lastIndexOf('.');
        String sufixo = email.substring(index+1);
        if(naoTemEspaco(sufixo)){
            return false;
        }
        for(int i = 0; i<sufixo.length(); i++){
            char letra = sufixo.charAt(i);
            if(!Character.isLetter(letra)
                    && !Character.isLowerCase(letra)
            ) {
                return false;
            }
            if(Character.isUpperCase(letra)){
                return false;
            }
        }
        if(sufixo.length()<2 || sufixo.length() > 3){
            return false;
        }
        return true;
    }

}
