# dojo-mymoni

Dojo DDD conçu par Sipios

## Votre objectif

L'application MyMoni permet de proposer une stratégie d'investissement en fonction du profil du client.

Aujourd'hui, votre Product Owner vient vous voir avec un nouveau besoin : des utilisateurs remontent qu'ils souhaiteraient
investir uniquement dans des fonds avec un véritable engagement écologique.
Votre objectif sera de déterminer avec lui quel est ce nouveau besoin et implémenter cette nouvelle fonctionnalité. Vous pouvez vous aider d'un Event Storming afin de conceptualiser votre développement.


D'autre part, certains utilisateurs ont remonté certaines anomalies. Saurez-vous les spotter et apporter une correction ?

## Installation

### Pré-requis

- Avoir Node installé sur sa machine
- Avoir Java 17 installé sur sa machine


### Installation du Frontend

- Éxecuter : `cd my-moni-frontend/` pour aller dans le dossier du front
- Éxecuter : `npm install` pour installer les dépendances
- Éxecuter : `npm test` pour lancer les tests de l'app
- Éxecuter : `npm run dev` pour lancer l'application (appuyer sur o pour l'ouvrir dans le navigateur)


### Installation du Backend

Avec IntellJ (recommandé) :

- ouvrir le projet dans IntellJ
- Attendre l'indexation :)
- Ouvrir le fichier `BackendApplication.java`
- Cliquer sur le bouton play vert pour lancer l'application

En ligne de commande :

- Éxecuter : `cd my-moni-backend/` pour aller dans le dossier du back
- Éxecuter : `./mvnw test` pour compiler et lancer les tests
- Éxecuter : `./mvnw spring-boot:run` pour compiler et démarrer l'application


### Lancer les tests E2E

- Lancer le front + le back
- Se placer à la racine du projet
- Éxecuter : `npm install` pour installer les dépendances
- Éxecuter : `npm run e2e:ui` pour lancer les tests E2E
