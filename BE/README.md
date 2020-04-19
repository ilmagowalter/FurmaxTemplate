# FURMAX TEMPLATE Backend

## Env locale

Il backend di FurmaxTemplate e' deployato come unico war su Wildfly. 

Accedendo all'indirizzo:

> [http://localhost:8080/siact/](http://localhost:8080/siact/)

Si viene indirizzati alla pagina generata con Swagger che documenta le api rest

I servizi rest rispondono all'indirizzo: 

> http://localhost:8080/siact/rest/


## Avvio

L'applicativo per funzionare ha bisogno che siano impostate alcune variabili di ambiente:

	chiave.jwt.keystore.dir		la directory nella quale e' presente il keystore ( default=/standalone/configuration/)

