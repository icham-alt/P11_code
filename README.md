
# Application de Gestion Hospitalière

Cette application est conçue pour gérer les opérations de base d'un système hospitalier, permettant aux utilisateurs d'interagir en tant que patients ou professionnels de santé. Les fonctionnalités principales incluent la gestion des hôpitaux, des patients et des réservations de lits.

## Configuration

### Profils Utilisateurs

L'application prend en charge deux profils utilisateurs : patient et professionnel de santé. Le comportement et les autorisations de chaque profil sont définis dans le système.

### Base de Données

L'application utilise une base de données relationnelle pour stocker les informations. Assurez-vous de configurer les paramètres de connexion appropriés dans le fichier `application.properties`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nom_de_la_base_de_données
spring.datasource.username=utilisateur
spring.datasource.password=mot_de_passe
```

### Sécurité

La sécurité de l'application est gérée à l'aide de Spring Security. Des règles d'autorisation spécifiques sont définies pour chaque profil utilisateur afin de contrôler l'accès aux fonctionnalités.

## Fonctionnalités

### Gestion des Hôpitaux

Les utilisateurs peuvent créer, modifier et supprimer des informations sur les hôpitaux. Les opérations incluent l'ajout de nouveaux hôpitaux, la mise à jour des détails existants et la suppression des hôpitaux inutilisés.

### Gestion des Patients

Les utilisateurs ont la possibilité de créer, modifier et supprimer des informations sur les patients. Cela comprend l'ajout de nouveaux patients, la mise à jour des dossiers existants et la suppression des patients qui ne sont plus actifs.

### Réservation de Lits

Les professionnels de santé peuvent effectuer des réservations de lits pour les patients dans les différents hôpitaux. Cette fonctionnalité permet de gérer efficacement la disponibilité des lits et d'assurer un suivi précis des admissions.

## Technologies Utilisées

- Java 8
- Spring Boot
- Spring Data JPA
- Spring Security
- Base H2
- HTML/CSS (Front-end)
- Thymeleaf (Template Engine)
- Angular (Framework front)

## Lancement de l'Application

Pour lancer l'application localement, assurez-vous d'avoir Maven et Java 8 installés sur votre système. Exécutez la commande suivante à partir du répertoire racine du projet :

```bash
mvn spring-boot:run
```

L'application sera déployée sur `localhost:9007`.


## Exécution des tests 


### Introduction

Ce projet contient des fichiers de tests pour JMeter et Selenium. Ce guide explique comment télécharger et installer ces outils, importer les fichiers de tests fournis (`http_request.jmx` pour JMeter et `Hopital_webapp.side` pour Selenium), et exécuter les tests.

### Prérequis

- Java Development Kit (JDK) installé sur votre machine.
- Un navigateur web compatible (de préférence Chrome ou Firefox).

## JMeter

### Installation de JMeter

1. **Télécharger JMeter :**
   Rendez-vous sur le site officiel d'Apache JMeter : [JMeter Download](https://jmeter.apache.org/download_jmeter.cgi)
   
2. **Extraire le fichier téléchargé :**
   Téléchargez la version binaire (zip ou tgz) de JMeter et extrayez-la dans le répertoire de votre choix.

3. **Configurer JMeter :**
   Assurez-vous que le chemin vers le JDK est correctement configuré dans votre variable d'environnement `PATH`.

### Importation et exécution du fichier `http_request.jmx`

1. **Lancer JMeter :**
   Accédez au répertoire où vous avez extrait JMeter, puis exécutez `jmeter.bat` (Windows) ou `jmeter` (Unix/Linux) situé dans le dossier `bin`.

2. **Importer le fichier de test :**
   - Dans l'interface de JMeter, allez dans `File` > `Open` et sélectionnez le fichier `HTTP Request.jmx` fourni.

3. **Exécuter les tests :**
   - Une fois le fichier importé, vous pouvez exécuter les tests en cliquant sur le bouton vert avec l'icône de lecture (`Start`).

## Selenium

### Installation de Selenium

1. **Télécharger Selenium IDE :**
   Selenium IDE est disponible en tant qu'extension de navigateur. Téléchargez et installez l'extension pour votre navigateur :
   - [Chrome Web Store](https://chrome.google.com/webstore/detail/selenium-ide/mooikfkahbdckldjjndioackbalphokd)
   - [Firefox Add-ons](https://addons.mozilla.org/en-US/firefox/addon/selenium-ide/)

### Importation et exécution du fichier `Hopital_webapp.side`

1. **Lancer Selenium IDE :**
   Ouvrez votre navigateur et lancez l'extension Selenium IDE.

2. **Importer le fichier de test :**
   - Dans Selenium IDE, cliquez sur `Open Project` et sélectionnez le fichier `Hopital_webapp.side` fourni.

3. **Exécuter les tests :**
   - Une fois le projet importé, cliquez sur le bouton de lecture (`Run all tests`) pour exécuter tous les tests dans le fichier.

## Conclusion des tests

Vous avez maintenant les instructions pour installer JMeter et Selenium, importer les fichiers de tests fournis et exécuter les tests. Pour toute question ou problème, veuillez consulter la documentation officielle de [JMeter](https://jmeter.apache.org/usermanual/get-started.html) et [Selenium IDE](https://www.selenium.dev/selenium-ide/docs/en/introduction/command-line-runner).


# Guide d'utilisation de la Pipeline GitLab CI

Ce guide fournit des instructions pour utiliser la pipeline GitLab CI pour construire, tester et déployer l'application Hopital.


## Builder et exécuter la PoC

1. Clonez le dépôt GitLab :

git clone https://gitlab.com/icham-alt/P11_code_gitlab.git

2. Accédez au répertoire Hopital_API :

cd Hopital_API

3. Lancez la construction et l'exécution de la preuve de concept :

mvn clean package

4. Répétez les étapes 2 et 3 pour le répertoire Hopital_webapp.



## Exécuter les tests

La pipeline GitLab CI exécute automatiquement les tests pour chaque étape. Vous pouvez consulter les résultats des tests dans l'interface GitLab.


## Exécuter la chaîne de build

Pour exécuter manuellement la chaîne de build dans GitLab CI :

1. Accédez au projet sur GitLab.
2. Cliquez sur l'onglet "CI / CD" dans le menu de navigation.
3. Cliquez sur le bouton "Run Pipeline" pour déclencher manuellement la chaîne de build.


## Règles du workflow pour le versioning

Nous utilisons les règles de versionnement sémantique pour notre projet Hopital :

- Les mises à jour majeures (1.0.0 -> 2.0.0) sont effectuées en cas de changements majeurs et incompatibles.
- Les mises à jour mineures (1.0.0 -> 1.1.0) ajoutent des fonctionnalités de manière rétrocompatible.
- Les corrections de bogues (1.0.0 -> 1.0.1) ne modifient pas les fonctionnalités existantes mais corrigent des problèmes.

Pour plus d'informations sur les règles de versionnement sémantique, consultez https://semver.org/.



## Contribuer

Les contributions sont les bienvenues ! Si vous souhaitez améliorer cette application, n'hésitez pas à soumettre une demande de tirage (pull request).

## Auteurs

- [Ouelaa Icham](https://github.com/icham-alt)

---

