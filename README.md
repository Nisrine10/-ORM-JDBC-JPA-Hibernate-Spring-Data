# <span style="color: silver;">Rapport</span>


<span style="color: #f03c15;">Introduction :</span>

La gestion efficace de la persistance des données est un élément clé dans le développement d'applications. 
Au fil du temps, diverses technologies ont évolué pour relever ce défi, de l'ORM au JDBC, en passant par des cadres tels que JPA, Hibernate et Spring Data. Ces avancées ont révolutionné la manière dont les développeurs interagissent avec les bases de données en proposant des solutions flexibles et robustes.

Ce travail pratique se concentre sur une exploration approfondie de ces concepts essentiels. Nous avons examiné les différentes couches de l'architecture de persistance, depuis l'accès aux bases de données avec JDBC jusqu'à l'utilisation de JPA pour simplifier la gestion des objets persistants. En plus de cela, nous avons exploré Hibernate, un framework ORM populaire facilitant la liaison entre les objets Java et les bases de données relationnelles. Enfin, nous avons plongé dans Spring Data, un composant puissant du framework Spring, simplifiant davantage la gestion des données en fournissant une interface cohérente et flexible pour la persistance.
L'objectif était de mettre en lumière les avantages, les fonctionnalités clés et les scénarios d'utilisation de ces technologies, tout en illustrant leur mise en œuvre pratique.

<span style="color: teal;">**Énoncé :**</span>

1. Installer IntelliJ Ultimate
2. Créer un projet Spring Initializer avec les dépendances JPA, H2, Spring Web et Lombok
3. Créer l'entité JPA Patient ayant les attributs :
    - id de type Long
    - nom de type String
    - date de naissance de type Date
    - malade de type boolean
    - score de type int
4. Configurer l'unité de persistance dans le fichier application.properties
5. Créer l'interface JPA Repository basée sur Spring Data
6. Tester quelques opérations de gestion :
    - Ajouter des patients
    - Consulter tous les patients
    - Chercher un patient par Id
    - Mettre à jour un patient
    - Supprimer un patient
7. Migrer de H2 Database vers MySQL



<span style="color: teal;">**Architecture JPA :**</span>
![Architecture](captures/architecture.png)


<span style="color: teal;">**TP :**</span>

1. <span style="color:cadetblue ;">Installation d'IntelliJ Ultimate</span>
   La première étape de ce travail pratique consiste à procéder à l'installation d'IntelliJ IDEA Ultimate, un environnement de développement intégré (IDE) de grande puissance, qui va nous servir pour le développement de notre application.

2. <span style="color: cadetblue;">Création d'un Projet Spring Initializer ,Maven avec  les dépendances suivantes :</span>
    - Spring Data JPA
    - H2 Database (base de données en mémoire)
    - Spring Web 
    - Lombok (Generation du code automatique)
    - MySQL Driver
    - Thymeleaf

3. <span style="color: cadetblue;">Création de l'Entité JPA Patient :</span>
   Voici les attributs de cette entité :
    - id de type Long
    - nom de type String
    - date de naissance de type Date
    - malade de type boolean
    - score de type int
      ![Entity](captures/entity.png)

4. <span style="color: cadetblue;">Configuration de l'unité de persistance dans le fichier application.properties pour utiliser H2 Database :</span>
   Ces lignes de configuration définissent l'URL de la base de données (H2 en mémoire), activent la console H2 pour une gestion interactive, et spécifient le port (8082) sur lequel l'application sera accessible.
   ![Properties](captures/app_properties_h2.png)

5. <span style="color: cadetblue;">Création de l'interface JPA Repository basée sur Spring Data :</span>
   Cette interface "PatientRepository" étend "JpaRepository" pour gérer l'accès aux données de l'entité "Patient". Il fournit des méthodes pour rechercher des patients par différents critères, notamment le statut de maladie, le score, la date de naissance et le nom, ainsi qu'une requête personnalisée pour la recherche.
   ![JPA Repository](captures/repository.png)

6. <span style="color: cadetblue;">Tests des Opérations de Gestion :</span>
    - Le point d'entrée de l'application Spring Boot
      ![Démarrage](captures/demarrage.png)
    - Ajouter des patients
      ![Ajout](captures/ajout.png)
    - Consulter tous les patients
      ![Affichage](captures/consulter.png)
    - Chercher des patients selon des critères
      ![Critère](captures/critere.png)
    - Chercher un patient par Id
      ![Recherche par Id](captures/recherche_id.png)
    - Mettre à jour un patient
      ![Modifier](captures/modifier.png)
    - Supprimer un patient
      ![Supprimer](captures/supprimer.png)
    - Exécution avec H2 
      ![Exécution H2](captures/exe1_h2.png)
      ![Exécution H2](captures/exe2_h2.png)
    - Les données dans H2 Database
      ![Console H2 - Login](captures/h2_console_login.png)
      ![Console H2](captures/h2_console.png)

7. <span style="color: cadetblue;">Migration de H2 Database vers MySQL :</span>
    - Configuration de l'unité de persistance dans le fichier application.properties pour utiliser MySQL
      ![Properties MySQL](captures/app_properties_mysql.png)
    - Exécution avec MySQL
      ![Exécution MySQL](captures/exe1_mysql.png)
      ![Exécution MySQL](captures/exe2_mysql.png)
    - ![Exécution MySQL](captures/exe3_mysql.png)
    - Les données dans MySQL Database
      ![Console MySQL](captures/db_sql.png)
      ![Table MySQL](captures/mysql_table.png)

<span style="color: teal;">**Conclusion**</span>

Ce projet pratique a plongé au cœur de la gestion complexe de la persistance des données en utilisant des technologies essentielles telles que l'ORM, le JDBC, le JPA, Hibernate et Spring Data.
Notre exploration a mis en lumière la manière dont ces outils puissants simplifient considérablement le processus de développement des applications Java, les rendant robustes et adaptables.

L'expérience a également mis en avant l'importance cruciale du choix judicieux des outils en fonction des exigences spécifiques du projet. La maîtrise de ces concepts et de leur application pratique représente un atout majeur pour les développeurs qui recherchent l'efficacité, la performance et la fiabilité dans leurs applications.

En résumé, cette exploration a élargi notre compréhension des technologies de gestion de la persistance des données, ouvrant ainsi la voie à des projets plus avancés et à une expertise approfondie dans le développement d'applications Java. Elle souligne l'importance cruciale de ces outils dans le paysage moderne du développement logiciel, 
où la gestion efficace des données est un élément clé du succès des projets.