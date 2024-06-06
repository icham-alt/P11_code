
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

## Contribuer

Les contributions sont les bienvenues ! Si vous souhaitez améliorer cette application, n'hésitez pas à soumettre une demande de tirage (pull request).

## Auteurs

- [Ouelaa Icham](https://github.com/icham-alt)

---

