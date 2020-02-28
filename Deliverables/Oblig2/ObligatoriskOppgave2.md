# Obligatorisk oppgave 2
## Deloppgave 1: Prosjekt og prosjektstruktur

#### Hvordan fungerer rollene i teamet? Trenger dere å oppdatere hvem som er teamleder eller kundekontakt
*   Rollene fungerer bra slik som de er. Teamleder og kundekontakt blir som de er. 
 
#### Trenger dere andre roller? Skriv ned noen linjer om hva de ulike rollene faktisk innebærer for dere
*   Nei, rollefordelingen fungerer som den er, vi har behov for en som kan jobbe ekstra med tester. I løpet av oblig 2 vil Vegard fungere som tester for Gutta Krutt.
*   Teamleder: Som teamleder må jeg organisere møter, holde meg oppdatert på hva de andre i teamet holder på med og løse eventuelle problemer som skulle oppstå innad.
*   Utvikler: Som utvikler har man hovedansvar for selve kodingen i prosjektet. 
*   Kundekontakt: Foreløpig har vi ikke hatt behov for en kundekontakt, men vi ser for oss at vi kommer til å trenge det i løp av prosjektet. 
 
#### Er det noen erfaringer enten team-messig eller mtp prosjektmetodikk som er verdt å nevne? Synes teamet at de valgene dere har tatt er gode? Hvis ikke, hva kan dere gjøre annerledes for å forbedre måten teamet fungerer på
*   Foreløpig har prosjektmetodikken fungert utmerket og når problemer har oppstått har vi løst de fortløpende. Valgene vi har tatt hittil har fungert bra, vi er løsningsorienterte og effektive når det kommer til kommunikasjon.
*   Vi er veldig fornøyd med "kanban" og får en god oversikt over prosjektet. 
 
#### Hvordan er gruppedynamikken
*   Gruppedynamikken fungere bra. Hittil har vi hatt noen diskusjoner og løst problemer effektivt. Alle har prestert bra og møtt opp i de ekstra møtene for å kunne fullføre oblig 1 og 2.
 
#### Hvordan fungerer kommunikasjonen for dere? forbedringspotensiale
*   Kommunikasjonen flyter bra og alle deltar. Ingen er redd for å ytre meningene sine, og alle forslag blir tatt på alvor. Siden vi alle kjenner hverandre så godt, skjønte vi tidlig at vi måtte fokusere på å holde seriøsiteten oppe. Dette har funket veldig bra.
 
#### Gjør et kort retrospektiv hvor dere vurderer hva dere har klart til nå, og hva som kan forbedres. Dette skal handle om prosjektstruktur, ikke kode. Dere kan selvsagt diskutere kode, men dette handler ikke om feilretting, men om hvordan man jobber og kommuniserer.
*   I gruppen har vi kommunisert daglig og har vært flinke til å planlegge uke for uke. Dette har medført at vi alle har hatt en god oversikt over hva som er gjort, hva som må gjøres og hvem som skal gjøre hva. Vi syns forholdet har fungert veldig bra til nå, men et forberingspotensiale i gruppen er å gi en kort breef/gjennomgang (bruke de første 10 min av møtene) av hva som er gjort hvis en av oss merger sub-branchen med master-branch. Dette tror vi kan føre til en bedre flyt, og vi kan spare tid på å slippe å lese gjennom hverandres kode.  
 
#### Under vurdering vil det vektlegges at alle bidrar til kodebasen. Hvis det er stor forskjell i hvem som committer, må dere legge ved en kort forklaring for hvorfor det er sånn. husk å committe alt. (Også designfiler)
*   Foreløpig har vi jobbet mye med parprogrammering, som har medført at commit-ene har blitt ujevnt fordelt på gruppen.
 
#### Referat fra møter siden forrige leveranse skal legges ved.
*   Alle møtereferatene ligger i assets/Deliverables/Møtereferat.md
 
#### Bli enige om maks tre forbedringspunkter fra retrospektivet, som skal følges opp under neste sprint.
1.   Breefe hverandre når man fullfører en brukerhistorie.
2.   Selvstendig jobbing på prosjektet.
3.   Seriøsitet i møter.

## Deloppgave 2: krav
####For hvert krav dere jobber med, må dere lage: 
#####1) ordentlige brukerhistorier, 2) akseptansekriterier, 3) arbeidsoppgaver. Husk at akseptansekriterier ofte skrives mer eller mindre som tester

####Dersom dere har oppgaver som dere skal til å starte med, hvor dere har oversikt over både brukerhistorie, akseptansekriterier og arbeidsoppgaver, kan dere ta med disse i innleveringen også.
*   Alt ligger i Deliverables/Oblig2/ObligatoriskOppgave2.md

####Forklar kort hvordan dere har prioritert oppgavene fremover
*   I begynnelsen valgte vi å prioritere kode-skjellettet. Det vil si at selve grunnlaget for spillet ble lagt. Fremmover vil vi fokusere mer på spillets funksjon og front end developent. 
 
####Forklar kort hvilke hovedkrav dere anser som en del av MVP og hvorfor. Hvis det er gjort endringer i rekkefølge ut ifra hva som er gitt fra kunde, hvorfor er dette gjort
*   Spillet må bli visualisert fordi man kan ikke spille spillet uten en visuell representasjon. 

####Oppdater hvilke krav dere har prioritert, hvor langt dere har kommet og hva dere har gjort siden forrige gang

####Husk å skrive hvilke bugs som finnes i de kravene dere har utført (dersom det finnes bugs).

####Kravlista er lang, men det er ikke nødvendig å levere på alle kravene hvis det ikke er realistisk. Det er viktigere at de oppgavene som er utført holder høy kvalitet. Utførte oppgaver skal være ferdige.

##Brukerhistorier

####Brukerhistorie - "Kort"

*   Som spiller trenger jeg muligheten til å programmere en sekvens for å kunne flytte brikken på brettet.

Arbeidsoppgaver:
*   Konstruer de 7 forskjellige sekvenskortene. 
*   Lage et overordnet system for kortene. Dette kan være en eller annen type for stack, for eksempel en kortstokk.
*   Gjøre det mulig for spiller å trekke ett til ni kort. 

Akseptansekrav:
*   Kortene må ha lokale varibler som lagrer verdiene som rettning, prioritet og distanse.
*   Kortene må korrespondere til riktig bevegelse.
*   Posisjon av spiller må oppdateres på brettet.  

####Brukerhistorie - "Vegger"

*   Som spiller må jeg forholde meg til brettets restriksjoner.  

Arbeidsoppgaver:
*   ForbedringspotensialeLegge til vegger visuelt på brettet i et nytt layer.
*   Få spiller til å stoppe å bevege seg hvis han krasjer med en vegg.

Akesptansekrav:
*   Bekreft at spiller-posisjon er den samme før og etter at en spiller har krasjet med en vegg.
*   Bekreft at en spiller kan entre posisjonen veggen befinner seg i, og at veggen ikke "bruker opp" den cellen. 

## Deloppgave 3: kode
*   Dere må dokumentere hvordan prosjektet bygger, testes og kjøres, slik at det er lett for gruppelederne å bygge, teste og kjøre koden deres. Under vurdering kommer koden også til å brukertestes.
*   Prosjektet skal kunne bygge, testes og kjøres på Linux, Windows og OSX.
*   Kodekvalitet og testdekning vektlegges. Merk at testene dere skriver skal brukes i produktet.
*   Utførte oppgaver skal være ferdige.
*   Lever klassediagram. (Hvis det er veldig mange klasser, lager dere for de viktigste.)
*   Hvis dere tester manuelt: lever beskrivelser av hvordan testen foregår, slik at gruppeleder kan utføre testen selv.

#### Vurderingskriterier og vekting
*   I denne leveransen blir det ingen presentasjon.
*   Om teamet ønsker, kan all tekst leveres på engelsk.
*   Vurderingskriterier vil bli publisert før deadline.
*   Innleveringsfrist: 28. februar 2020, klokken 16.00
*   For å få oppgaven godkjent, må gruppen:
*   Skrive fornuftige Commit meldinger når endringer lastes opp i gruppens repo.
*   Laste opp de etterspurte resultatene i repo.
*   Laste opp leveransen til github i markdown-format.
*   Leveransen skal lastes opp i egen mappe i repoet, som heter "Deliverables". Hver oblig blir da "ObligX.md" i den mappen. Eventuelle slides kan lastes inn opp til samme mappe.
*   Tag en commit av kildekoden som er leveransen til hver oblig. Dette gjør det enklere for de som skal vurdere å gjøre det på riktig tidspunkt.
*   I tillegg til koden, vil dere også vurderes på teamarbeidet gjennom semesteret.
*   For å få oppdraget godkjent, må hvert lagmedlem:
*   Møte og delta aktivt i minst 75% av ukentlige møter med deres TA og oblig.2 presentasjonen.
*   Utføre de tildelte oppgavene under og mellom disse ukentlige møtene, som avtalt i teamet.
*   Rapportere tilbake til teamet om framdrift og/eller problemer som oppstår, som avtalt i teamet.
*   Vektlegging: Denne leveransen teller 12,5% av sluttkarakteren.
#### Tips
*   Mockito kan være et bra mock-rammeverk i tillegg til JUnit. Generelt sett er det også mulig å skrive manuelle tester. Husk at testene dere skriver skal brukes. (Som nevnt i deloppgave 3)