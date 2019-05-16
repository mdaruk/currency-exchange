# Zadanie - przelicznik walut

Celem zadania jest stworzenie aplikacji web'owej w java, która będzie udostępniała usługę rest do przeliczania walut.
Wymagania funkcjonalne:
Usługa rest będzie przyjmowała 3 parametry:
* kwota
* waluta kwoty
* waluta kwoty docelowej
Usługa będzie zwracała przeliczoną kwotę w walucie docelowej.
Do ustalenia kursów walut aplikacja powinna automatycznie zaciągać dane z NBP według instrukcji: http://api.nbp.pl/
Dane kursów powinny być zaciągane maksymalnie raz dziennie (danych nie trzeba nigdzie zapisywać, w związku z tym po restarcie
aplikacji mogą one być ściągnięte jeszcze raz)

Aplikacja udostępnia formularz do przeliczania walut oraz REST API.

Formularz jest dostępny pod adresem:
http://127.0.0.1:8080/

Formularz zawiera przykład użycia API.

URL API to:
http://127.0.0.1:8080/convertCurrency
API obsługuje tylko metodę POST
Content-Type: application-json
W body zapytania występują następujące pola:
amount - kwota waluty
myCurrencyCode - kod waluty
targetCurrencyCode - kod docelowej waluty
przykład body:
{"amount":100,
"myCurrencyCode":"GBP",
"targetCurrencyCode":"EUR"}

Przykładowy wynik:
{"amount": 115.147934,"currencyCode": "EUR"}


### Prerequisites

Program wymaga:
* JAVA JDK 1.8,
* MAVEN

Biblioteki Spring i SpringBoot zostaną pobrane podczas instalacji

Aplikacja uruchamia się na serwerze Tomcat, który jest zawartym w SpringBoot.
Aplikacja używa portu 8080, port ten musi być wolny przed uruchomieniem aplikacji.
Adres do aplikacji: http://127.0.0.1:8080/

### Instalacja

Instalacja (wymagane biblioteki zostaną pobrane):

cd currency-exchange

mvn install

uruchomienie:

mvn spring-boot:run

## Uruchomienie testów

mvn test
