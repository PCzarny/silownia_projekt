#Aplikacja JAVA, uruchomienie:
3. Stawiamy bazę danych, ja to zrobiłem za pomocą wamp server, z użyciem phpMyAdmin
  4. Instalujecie wamp server
  3. Uruchamiacie go (ikonka będzie w trayu)
  4. Przechodzicie na stronę localhost
  5. Uruchamiacie phpMyAdmin
  6. Import -> Wybierz plik -> baza_danych.sql -> nazywacie ją "silownia_baza"
7. Pobieramy na dysk cały projekt (git pull)
8. Eclipse -> File -> Import -> General -> Existing Project into Workspace
9. Uruchamiamy projekt na Tomcacie lub GlassFishu, to bez znaczenia, ale moim zdaniem Tomcat działa szybciej
10. Pobieramy Chrome i instalujecie "Advanced Rest Client", on pozwala na łatwe wysyłanie zapytań Restowych do serwera
11. Włączamy Advanced Rest Client i gdy chcemy testować:
  12. Logowanie, to w polu URL wpisujemy: http://localhost:8080/silownia_java/rest/login/authenticate 
  13. Rejestrowanie, to w polu URL wpisujemy: http://localhost:8080/silownia_java/rest/register/doregister
  14. Po tym klikamy na tę strzałeczkę po lewej od pola URL
  15. Klikamy "Form" i wypełniamy pola "key" (logowanie ma pola 'username', 'password' rejestrowanie ma pola 'email', 'username', 'password') i wypełniamy pola "value" wartościami jakie chcemy wpisać do bazy
  16. Klikamy "Send"
  17. Jeśli wpisaliśmy poprawne dane to pojawi się odpowiedź w JSONie: {tag: "login" status: true}
18. Po "zarejestrowaniu" nowego użytkownika, w aplikacji phpMyAdmin pojawi się nowy użytkownik w bazie.
19. Jeśli nie chcecie się bawić w testowanie przez tę aplikację to można pisać zapytania tego typu:  http://localhost:8080/silownia_java/rest/login/dologin?username=admin&password=admin i wywoływać je w przeglądarce, to zwróci taki tekst: {"tag":"login","status":true} 


