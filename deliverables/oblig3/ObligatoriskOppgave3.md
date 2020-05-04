# Obligatorisk oppgave 3

## Deloppgave 1: Prosjekt og prosjektstruktur
*   Hvordan fungerer rollene i teamet? Trenger dere å oppdatere hvem som er teamlead eller kundekontakt
    *   Rollene fungerer bra som de er, har enda ikke fått bruk for kundekontakt, men det kan være greit å ha.
    
*   Er det noen erfaringer enten team-messig eller mtp prosjektmetodikk som er verdt å nevne? Synes teamet
    at de valgene dere har tatt er gode? Hvis ikke, hva kan dere gjøre annerledes for å forbedre måten teamet
    fungerer på
    *   Mtp prosjektmetodikken "kanban" som vi bruker er vi veldig fornøyd og har nå "modernisert" projectboardet
    vårt ved å automatisere det og legge til:
        *   Milestones
        *   Issues
        *   Tags
    *   Team-messig har vi erfart fra forrige innlevering (Oblig 2) at vi bør være mer oppmerksomme på hva vi faktisk
    velger å levere inn. Sist så leverte vi inn kode som så ut til å ikke kjøre fordi vi hadde
    glemt å assigne noen variabler. Og som en konsekvens av dette valgte vi implementerte "Travis",
    som du nå kan du se i README.md filen om prosjektet kjører. Vi har også bestemt at hele gruppen skal
    være tilstede når noen merger inn i master-branchen.
    
*   Hvordan er gruppedynamikken
    *   Gruppedynamikken er svært bra. Alle jobber bra sammen, og vi jobber hardt for å få tid til ekstra møter, selvstendig jobbing og en jevn progresjon. Selv utenom "oblig" periodene.
    Vi jobber for best mulig resultat og ser på dette prosjektet som en god mulighet til å prøve ut ulike metoder å jobbe og hvordan vi som gruppe kan sammarbeide best mulig ved hjelp av git, branches og 
    parprogrammering. 

*   Hvordan fungerer kommunikasjonen for dere
    *   Kommunikasjonen er bra, alle sier ifra hvis det er noe de ønsker å legge frem eller hvis det er noe h*n skulle vært misfornøyd med. Det blir selvfølgelig noen diskusjoner, men vi klarer å holde oss
    saklige. Vi prøver så godt vi kan å få hørt alles forslag slik at ingen i teamet ikke føler seg hørt.

*   Gjør et kort retrospektiv hvor dere vurderer hva dere har klart til nå, og hva som kan forbedres. Dette skal
    handle om prosjektstruktur, ikke kode. Dere kan selvsagt diskutere kode, men dette handler ikke om
    feilretting, men om hvordan man jobber og kommuniserer.
    *   Etter gruppepresentasjonene i klassen ble vår gruppe introdusert for "tags" noe vi selv har implementert i Project Boardet. Vi har også begynt med issues og milestones. Noe som skal gjøre
    den totale oversikten bedre.
    *   Vi har lagt til "Travis" etter at vi gikk på en smell på oblig 2 der koden ikke kjørte.
    *   Vi kan bli flinkere på å klargjøre akkurat hva vi jobber med til de andre teammedlemmene. Av og til glemmes dette 
    og da jobbes det dobbelt på noe av implementasjonen.
    
*   Under vurdering vil det vektlegges at alle bidrar til kodebasen. Hvis det er stor forskjell i hvem som
    committer, må dere legge ved en kort forklaring for hvorfor det er sånn. Husk å committe alt. (Også designfiler)
    *   Det har vært ujevn fordeling av commits hittil fordi under møter driver vi med parprogrammering og ulike personer får ulike oppgaver.
    Noe som fører til at det bli ujevn fordeling av commits.
    
*   Referat fra møter siden forrige leveranse skal legges ved
    *   Ligger i assets/Deliverables/Møtereferat.md

*   Bli enige om maks tre forbedringspunkter fra retrospektivet, som skal følges opp under neste sprint
    1.  Alle burde reviewe før noen merger inn i Master branchen
    2.  Fjerne unødvendig kode/kode som ikke kjører
    3.  Jobbe bedre selvstendig

## Deloppgave 2: Krav
*   For hvert krav dere jobber med, må dere lage:
    1.  Ordentlige brukerhistorier.
    2.  Akseptansekriterier (Husk at akseptansekriterier ofte skrives mer eller mindre som tester).
    3.  Arbeidsoppgaver.
    

1.  Spilleren skal kunne se kontrollbrett  
    *   Som spiller trenger jeg å se kontrollbrettet for å ha oversikt over sekvensen min.
    *   Som spiller trenger jeg å se kontrollbrettet for å ha oversikt over livene til roboten. (under implementasjon)
    *   Som spiller trenger jeg å se kontrollbrettet for å ha oversikt over skaden på roboten. (under implementasjon)
    *   Som spiller trenger jeg å se kontrollbrettet for å ha oversikt over powerdown. (under implementasjon)
    
2.  Spiller skal ha kontrollbrett
    *   Som spiller trenger jeg kontrollbrettet for å legge en sekvens for roboten min.
    *   Som spiller trenger jeg kontrollbrettet for å legge en sekvens og vinne RoboRally.
    *   Som spiller trenger jeg kontrollbrettet for å aktivere powerdown. (under implementasjon)

3.  Spiller skal motta kort
    *   Som spiller trenger jeg kort for å legge en sekvens.
    *   Som spiller trenger jeg kort for å legge en strategi.

4.  Spiller trenger en menu (under implementasjon)
    *   Som spiller trenger jeg en menu der jeg kan velge Bane.
    *   Som spiller trenger jeg en menu der jeg kan velge Robot.
    *   Som spiller trenger jeg en menu der jeg kan lese reglene til spillet.
    
*   Dersom dere har oppgaver som dere skal til å starte med, hvor dere har oversikt over både brukerhistorie, akseptansekriterier og arbeidsoppgaver, kan dere ta med disse i innleveringen også
    *   Starter med sekvensbrettet/kontrollbrettet og utvide funksjonaliteten på brettet.
    
*   Forklar kort hvordan dere har prioritert oppgavene fremover
    *   Vi har valgt å fokusere på de funksjonelle oppgavene fremover. Vi ønsker å kunne spille spillet ved neste innlevering.
    
*   Forklar kort hvilke hovedkrav dere anser som en del av MVP og hvorfor. Hvis det er gjort endringer i rekkefølge utfra hva som er gitt fra kunde, hvorfor er dette gjort
    *   Å kunne se brettet 
    *   Å kunne legge en sekvens
    *   At spillet kjører/(går ann å spille)
    
*   Oppdater hvilke krav dere har prioritert, hvor langt dere har kommet og hva dere har gjort siden forrige gang
    *   Prioriteten fremover ligger i de kravene vi har spesifisert ovenfor.
    
*   Husk å skrive hvilke bugs som finnes i de kravene dere har utført (dersom det finnes bugs)
    *   Du kan gå ut og inn av brettet

## Deloppgave 3: Kode
*   Dere må dokumentere hvordan prosjektet bygger, testes og kjøres, slik at det er lett for gruppelderne å bygge, teste og kjøre koden deres. Under vurdering kommer koden også til å brukertestes.

*   Prosjektet skal kunne bygge, testes og kjøres på Linux, Windows og OSX.

*   Lever klassediagram. (Hvis det er veldig mange klasser, lager dere for de viktigste.)

*   Kodekvalitet og testdekning vektlegges. Merk at testene dere skriver skal brukes i produktet. Det kan være smart å skrive manuelle tester for å teste det som er grafisk. 

*   Utførte oppgaver skal være ferdige.

*   Hvis dere tester manuelt: lever beskrivelser av hvordan testen foregår, slik at gruppeleder kan utføre testen selv.
    *   RegisterScreen (skjermen som brukes for å legge en sekvens) er hovedsakelig brukt manuelle tester på. Her har vi testet at alle bokstavene og tallene fungerer riktig
    for eksempel at om man beveger spiller i gamescreen, og så skifter til registerscreen (trykk G) for så å skifte tilbake til gamescreen så er roboten på samme sted som man beveget den.
    Har også testet at alle numre bare kan legges en gang og at man kan fjerne alle kortene om man skulle ønske det. Til slutt har vi også sjekket at man kan ta inn kortene i den rekkefølgen man skulle ønske.

## Vurderingskriterier og vekting
Innleveringsfrist: 27. mars 2020, klokken 16.00

For å få oppgaven godkjent, må gruppen:
*   Skrive fornuftige Commit meldinger når endringer lastes opp i gruppens repo.
*   Laste opp de etterspurte resultatene i repo.
*   Laste opp leveransen til github i markdown-format.
*   Leveransen skal lastes opp i egen mappe i repoet, som heter "Deliverables". Hver oblig blir da "ObligX.md" i den mappen. Eventuelle slides kan lastes inn opp til samme mappe.
*   Tag en commit av kildekoden som er leveransen til hver oblig. Dette gjør det enklere for de som skal vurdere å gjøre det på riktig tidspunkt.

I tillegg til koden, vil dere også vurderes på teamarbeidet gjennom semesteret.

For å få oppdraget godkjent, må hvert lagmedlem:
*   Møte og delta aktivt i minst 75% av ukentlige møter med deres TA og oblig.2 presentasjonen.
*   Utføre de tildelte oppgavene under og mellom disse ukentlige møtene, som avtalt i teamet.
*   Rapportere tilbake til teamet om framdrift og/eller problemer som oppstår, som avtalt i teamet.

Vektlegging: Denne leveransen teller 12,5% av sluttkarakteren.

## Tips
*   Husk å lese gjennom retteskjema for å få med alle punktene vi gir poeng for. 
*   Mockito kan være et bra mock-rammeverk i tillegg til JUnit. Generelt sett er det også mulig å skrive manuelle tester. Husk at testene dere skriver skal brukes. (Som nevnt i deloppgave 3)
*   Travis og Codacy kan være til god hjelp for å sjekke at koden bygger før dere pusher til master.
*   Husk å kjøre programmet før dere lager en tag til levering slik at dere vet at det kjører. 