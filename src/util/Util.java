//Util.java – Classe utilitária com método de validação numérica

package util;

/**
 * Classe utilitária que contém métodos auxiliares reutilizáveis no sistema.
 * Neste caso, há um método que valida se uma string representa um número válido.
 * 
 * @author andre
 */
public class Util {

    /**
     * Verifica se o texto informado é um número válido (composto apenas por dígitos e ponto).
     * 
     * @param t Texto a ser verificado
     * @return O próprio texto, se for um número válido; caso contrário, retorna "0"
     */
    public static String numeroValido(String t) {
        // Verifica se o texto é nulo, está vazio ou não corresponde ao padrão numérico
        // O padrão "[0-9.]+" aceita apenas dígitos (0 a 9) e ponto decimal
        return t == null || t.isEmpty() || !t.matches("[0-9.]+") ? "0" : t;
    }

}
/*
Explicação para os alunos:
Classe Util: usada para colocar métodos que podem ser úteis em várias partes do sistema.

Método numeroValido:

Serve para evitar que valores inválidos (como letras ou campos vazios) sejam convertidos para números.

Se o valor estiver vazio, for null, ou não for um número (como "abc"), ele retorna "0".

Se for um número válido (como "123" ou "45.67"), ele retorna o próprio valor.

Uso comum: antes de converter um texto em número com Integer.valueOf() ou Double.valueOf(), o sistema pode usar numeroValido() para garantir que o valor é seguro.

*/