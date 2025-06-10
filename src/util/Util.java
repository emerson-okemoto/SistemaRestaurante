package util;

/**
 * Classe utilitária que contém métodos auxiliares reutilizáveis no sistema.
 * Neste caso, há um método que valida se uma string representa um número válido.
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