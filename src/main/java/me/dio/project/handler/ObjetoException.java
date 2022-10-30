package me.dio.project.handler;

public class ObjetoException extends BusinessException{
    public ObjetoException(String objeto) {
        super("O objeto %s não foi encontrado", objeto);
    }
}
