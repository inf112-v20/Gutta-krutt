# Obligatorisk oppgave 4

## Deloppgave 1: Team og prosjekt

*   Referat fra møter siden forrige leveranse skal legges ved.
    *   deliverables/Møtereferat.md
    
*   Hvordan fungerer rollene i teamet? Trenger dere å oppdatere hvem som er teamlead eller kundekontakt?
    *   Rollene fungerer bra slik som de er satt, så vi velger å ikke oppdatere rollene. Fredrik som 
    teamlead setter opp møter i gruppen, mens utviklerne har jobbet godt med prosjektet, utover
    det som var forventet. Nå mot slutten har alle jobbet som utviklere og gått litt vekk fra å
    ha én leder til der alle leder sin del av prosjektet.

*   Er det noen erfaringer enten team-messig eller mtp prosjektmetodikk som er verdt å nevne? Synes teamet
at de valgene dere har tatt er gode? Hvis ikke, hva kan dere gjøre annerledes for å forbedre måten teamet
fungerer på?
    *   Vi syns prosjektmetodikken Kanban har hatt en svært positiv innvirkning på dette prosjektet. Vi har hatt god oversikt og fremgang siden starten av semesteret.
    Parprogrammering har blitt litt vanskelig, som har ført til at alle deler problemer (Discord),
    hjelper hverandre med å finne eventuelle løsninger og fordele arbeidsoppgaver.
    
*   Gjør et retrospektiv hvor dere vurderer prosjektet har gått. Hva har dere gjort bra, hva hadde dere gjort annerledes hvis dere begynte på nytt?
    *   Vi føler, etter pågående krise at vi har hatt kontroll og gjennomført oppgaven bra. Noe av det vi muligens ville gjort annerledes er at flere av medlemmene i gruppen hadde satt seg inn
        i LibGdx. Vi ville også ha spilt spillet fysisk slik at vi har personlig erfaring med spillet, men pga korona ble dette ikke til.
        I tilegg skulle vi ønske at vi startet med testbasert utvikling fra starten. Vi har møtt noen hindringer
        når det kommer til testing med tanke på at LibGDX er brukt i store deler av prosjektet.
    
*   Legg ved skjermdump av project board ved innlevering. Sørg for at det er oppdatert med siste status ved innlevering. 
    *   Ligger i oblig4 mappen
    
*   Hvordan fungerer gruppedynamikken og kommunikasjonen nå i forhold til i starten? Hvordan påvirket karantene og nedstengning teamet og fremdriften?
    *   Gruppedynamikken og kommunikasjonen har blitt noe påvirket av den pågåede pandemien. Det at vi ikke fysisk kan møtes og diskutere oppgaven sammen har satt sine preg.
        Vi er nok mindre effektive enn det vi var tidligere i år grunnet at det er vanskeligere å jobbe med et stort gruppeprosjekt sammen når medlemmene er spredt utover Norge.
        Det er vanskelig å forklare kode over discord/videochat når alle medlemmene ikke er fysisk til stedet.

## Deloppgave 2: Krav

*   Oppdater hvilke krav dere har prioritert, hvor langt dere har kommet og hva dere har gjort siden forrige gang.
    *   Vi har prioritert spill funksjonaliteter som brett og sequence-board. Siden sist innlevering har vi nå utviklet en gameloop slik at vi kan legge en sekvens og utføre den. Vi har også fått
        til et fungerende sequence board. I tilegg til dette har vi valgt å fokusere på tester, ulikt tidligere.
        Men vi føler at vi har tatt oss litt igjen nå på slutten.
     
*   For hvert krav dere jobber med, må dere lage 1) ordentlige brukerhistorier, 2) akseptansekriterier og 3) arbeidsoppgaver. Husk at akseptansekriterier ofte skrives mer eller mindre som tester
    1.  Spilleren skal kunne legge og utføre en sekvens
        *   Som spiller trenger jeg å kunne legge en sekvens for å bevege roboten min.
        *   Som spiller trenger jeg å kunne legge en sekvens for å spille roborally.
        *   Som spiller trenger jeg å kunne legge en sekvens for å vinne roborally.
    
    2.  Spiller trenger wincondition
        *   Som spiller trenger jeg en wincondition for å vinne spillet.
        *   Som spiller trenger jeg en wincondition for å ha et mål i spillet.
    
    3.  Spiller trenger ett fungerende brett
        *   Som spiller trenger jeg ett fungerende brett for å kunne spille.
        *   Som spiller trenger jeg ett fungerende brett for å ha ett mål.
        
    4.  Spiller trenger brukerhåndbok
        *   Som spiller trenger jeg en brukerhåndbok for å vite "the way of the game"
        *   Som spiller trenger jeg en brukerhåndbok for å vite hvordan jeg kan vinne.
        *   Som spiller trenger jeg en brukerhåndbok for å vite om spill objekter.
    
*   Dersom dere har oppgaver som dere skal til å starte med, hvor dere har oversikt over både brukerhistorie, akseptansekriterier og arbeidsoppgaver, kan dere ta med disse i innleveringen også.
    *   Starter med å kunne legge/urføre en kort sekvens.
    
*   Forklar kort hvilke hovedkrav dere anser som en del av MVP og hvorfor. Hvis det er gjort endringer i rekkefølge utfra hva som er gitt fra kunde, hvorfor er dette gjort?
    *   Spiller må kunne se brettet.
    *   Spiller må kunne legge en sekvens
    *   Spiller må kunne legge en spillsekvens
    *   Spiller må kunne spille multiplayer
    
*   Husk å skrive hvilke bugs som finnes i de kravene dere har utført (dersom det finnes bugs). 
    *   Conveyor belts er ikke feilfrie, vi har ikke funnet et bra måte å sjekke om spiller kommer fra 
    conveyorbelt. Men utenom det er det ikke flere bugs vi vet om.

## Deloppgave 3: Produktleveranse og kodekvalitet

*   Dere må dokumentere hvordan prosjektet bygger, testes og kjøres, slik at det er lett for gruppelderne å bygge, teste og kjøre koden deres. Under vurdering kommer koden også til å brukertestes.
    *   Står forklart i Readme.md
    
*   Prosjektet skal kunne bygge, testes og kjøres på Linux, Windows og OSX.

*   Lever klassediagram. (Hvis det er veldig mange klasser, lager dere for de viktigste.)
    *   Ligger i oblig4 mappen
    
*   Kodekvalitet og testdekning vektlegges. Merk at testene dere skriver skal brukes i produktet. Det kan være smart å skrive manuelle tester for å teste det som er grafisk.
    *   Kodekvaliteten ligger på en A i følge Travis CI
    
*   Utførte oppgaver skal være ferdige.

*   Hvis dere tester manuelt: lever beskrivelser av hvordan testen foregår, slik at gruppeleder kan utføre testen selv.
    *   Ved å bevege spilleren med piltastene kan du teste:
        *   Checkpoints, man beveger spilleren over et checkpoint og dør med vilje for å sjekke at det funker.
        *   Vegger, man beveger spiller mot en vegg for å sjekke at spilleren ikke går gjennom veggen.
        *   Conveyorbelts, man beveger spilleren inn på conveyorbelt fra ulike retninger for å sjekke at man blir dyttet/rotert i riktig retning.
        *   Hull, beveger seg over et hull og sjekker at spiller dør og respawner på riktig sted og at man mister et liv.
        *   Out of board, beveger seg ut av brettet og sjekker at spiller respawner på riktig sted og at man mister et liv.
        *   Gears, går på et gear fra ulike retninger for å sjekke at spilleren blir rotert riktig vei i henhold til spillers retning fra før.
        *   Pushers, går på en pusher og sjekker at man blir dyttet i riktig retning.
        *   Flag, går over flaggene i ulik rekkefølge for å sjekke at man bare kan ta flaggene i riktig rekkefølge.
        *   Win condition, går over alle flaggene i riktig rekkefølge og sjekker om man får opp riktig skjerm.
            
    
*   Under vurdering vil det vektlegges at alle bidrar til kodebasen. Hvis det er stor forskjell i hvem som
    committer, må dere legge ved en kort forklaring for hvorfor det er sånn. Husk å committe alt. (Også
    designfiler)
    *   Alle har bidratt bra i dette gruppeprosjektet, rollefordelingen har fungert utmerket og alle har vært med å dra på lasset. Eneste er at den ujevne fordelingen av commits 
    kan forklares ved at vi har brukt parprogrammering, og enkelte har også hatt oppgaver utenom koding som dokumentasjon og readme filer. Som lag føler vi at alle har gjort sitt beste.

*   Prosjektresentasjonen teller ved denne leveransen. Dere blir vurdert på demo av spillet, 
    en beskrivelse av det viktigste dere har lært, en beskrivelse av hvordan nedstengningen av universitetet påvirket prosjektet 
    og hva dere ville gjort annerledes nå som dere har mer erfaring med gruppearbeid. 

## Vurderingskriterier og vekting

*   Om teamet ønsker, kan all tekst leveres på engelsk.

*   Vurderingskriterier ligger på Mitt.Uib

### Innleveringsfrist: fredag 08. mai 2020, klokken 16.00

For å få oppgaven godkjent, må gruppen:
*   Skrive fornuftige Commit meldinger når endringer lastes opp i gruppens repo.

*   Laste opp de etterspurte resultatene i repo.

*   Laste opp leveransen til github i markdown-format.

*   Leveransen skal lastes opp i egen mappe i repoet, som heter "Deliverables". Hver oblig blir da "ObligX.md"
i den mappen. Eventuelle slides kan lastes inn opp til samme mappe.

*   Tag en commit av kildekoden som er leveransen til hver oblig. Dette gjør det enklere for de som skal vurdere å gjøre det på riktig tidspunkt.

### I tillegg til koden, vil dere også vurderes på teamarbeidet gjennom semesteret.**

For å få oppdraget godkjent, må hvert lagmedlem:
*   Møte og delta aktivt i minst 75% av ukentlige møter med deres TA og presentasjon av prosjektet til slutt.
    *   Alle i gruppen har deltatt mer enn 75% 

*   Utføre de tildelte oppgavene under og mellom disse ukentlige møtene, som avtalt i teamet.
    *   Alle har jobbet både i avtalte møter/timer og utenom. I dette gruppeprosjektet har vi hatt svært god kommunikasjon og jobbet bra sammen. Alle har deltatt på avtalte møter og jobbet bra.

*   Rapportere tilbake til teamet om framdrift og/eller problemer som oppstår, som avtalt i teamet.

**Vektlegging:** Denne leveransen teller 12,5% av sluttkarakteren.

## Tips
*   Husk å lese gjennom retteskjema for å få med alle punktene vi gir poeng for. 

*   Mockito kan være et bra mock-rammeverk i tillegg til JUnit. Generelt sett er det også mulig å skrive manuelle
tester. Husk at testene dere skriver skal brukes. (Som nevnt i deloppgave 3)

*   Travis og Codacy kan være til god hjelp for å sjekke at koden bygger før dere pusher til master.

*   Husk å kjøre programmet før dere lager en tag til levering slik at dere vet at det kjører.