package br.com.controle.horas.seguranca;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) /*impede que minha Annotetion seja descartada na compilação do java*/
@Target(ElementType.METHOD)
public @interface Open {

}
