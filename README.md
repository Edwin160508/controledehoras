# VRaptor Controle de horas project

This is "Controle de horas" project to help you to see VRaptor and Hibernate working together. You can easily import in you IDE as Maven project.

Este é o projeto "Controle de horas" para ajudar você a ver o VRaptor e o Hibernate trablhando juntos. Você pode facilmente importá-lo na sua IDE favorita como um projeto Maven.

Após criar seu projeto você pode rodá-lo com um tomcat7 ou +:

```
mvn tomcat7:run
```

Cuidado para *jamais* executar `mvn tomcat:run` pois ele usará um tomcat6 (incompatível).

Atualmente este projeto está utilizando MySql como banco de dados, para testar o projeto, será nescessário rodar o script "Script Mysql Controle de horas.sql" no seu Workbench ou afins. 