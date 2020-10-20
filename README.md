Opis:
•	Posiadał system rezerwacji, wraz z jej obsługą przez stronę internetową,


•	Umożliwiał przeglądanie ofert poprzez stronę internetową,


•	Prezentował oferty turystyczne firmy w łatwy i przejrzysty sposób,


•	Przechowywał, w sposób usystematyzowany i logiczny dane pracowników i klientów oraz oferty,


•	Prowadził podstawową ewidencję dokumentów.



- CRUD katalogu ofert
- CRUD rezerwacji
- Zapłata za rezerwacje
- CRUD danych  osobowych klienta
- Rejestracja nowego konta przez klientów poprzez stronę internetową
- Przechowywanie danych  o aktualnych ofertach
- Przechowywanie danych osobowych klientów i pracowników firmy „Via Europa”
- Przechowywanie faktur Vat.
- Przechowywanie archiwalnych ofert
- Archiwizacja danych osobowych klientów


<-Tworzone Encje->

1.Goscie (IdGosc, Nazwisko, Imie, TypDokumentu, NrDokumentu, Ulica, NrBudynku,
 NrLokalu, KodPocztowy, Miejscowosc, Kraj, Plec, Telefon, Email, Haslo)

2.Pracownicy (IdPracownik, Nazwisko, Imie, PESEL, DataUrodzenia, Plec,Ulica
NrBudynku, NrLokalu, KodPocztowy, Miejscowosc, Telefon ,Email, DataZatrudnienia, NrKonta, Pensja,  #IdStanowisko)

3.Pokoje (NrPokoju, Pietro, Dostepny, #IdTypPokoju)

4.TypyPokojow (IdTypPokoju, Standard, LiczbaMiejsc, Cena)

5.Rezerwacje (NrRezerwacja, Status,  DataZakonczeniaPobytu, Koszt, #IdGosc)

6.Stanowiska (IdStanowisko, NazwaS, CzlonekZarzadu)

7.Faktury (NrFaktury, DataWystawienia, RodzajOperacji, OpisFaktury, 
 WartoscBrutto, DataZaplaty)

8.RezerwowanePokoje (#NrRezerwacja, #NrPokoju)

9.ObiektySportowe (IdObiekt, NazwaO, Stawka, #IdPracownik)

10.KorzystanieZObiektu (#NrRezerwacja, #IdObiekt, LiczbaGodzin)
	FakturyRezerwacji (#NrRezerwacja, #NrFaktury)

Oczywiście jest możliwość dodania dodatkowych encji i logiki biznesowej oraz innych funkcjonalności
