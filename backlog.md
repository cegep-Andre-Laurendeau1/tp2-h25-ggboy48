# Backlog

### Acteurs:

1. **Emprunteur** : Résident de Javatown qui emprunte des documents.
2. **Préposé de la bibliothèque** : Employé qui gère l'entrée des documents dans le système et les opérations de la bibliothèque.
3. **Système du bibliotheque** : Le logiciel qui gère les opérations de la bibliothèque.

### Stories:

1. **En tant qu'Emprunteur, je veux emprunter un livre, un CD ou un DVD, afin de pouvoir les utiliser.**

    - Critères d'acceptation :
        - Le client peut emprunter un document pour une durée déterminée (3 semaines pour les livres, 2 semaines pour les CD, 1 semaine pour les DVD).
        - Le système enregistre la date d'emprunt et la date de retour prévue.
      
2. **En tant qu'Emprunteur, je veux savoir si j'ai des amendes, afin de pouvoir les régler avant d'emprunter de nouveaux documents.**

    - Critères d'acceptation :
        - Le système affiche le montant total des amendes accumulées par le client.
        - Le client ne peut pas emprunter de nouveaux documents s'il a des amendes.
      
3. **En tant que Préposé de la bibliothèque, je veux entrer de nouveaux documents dans le système, afin de les rendre disponibles pour les clients.**

    - Critères d'acceptation :
        - Le préposé peut entrer le titre, l'auteur, l'éditeur, l'année de publication, le nombre de pages et le genre du document.
        - Le préposé peut spécifier si le document est un roman ou un manuel scolaire pour les livres.
      
4. **En tant qu'Emprunteur, je veux rechercher des documents par auteur ou éditeur, afin de trouver facilement ce que je cherche.**

    - Critères d'acceptation :
        - Le système permet de rechercher des documents par auteur ou éditeur.
        - Les résultats de la recherche affichent les documents correspondants.
      
5. **En tant que Préposé de la bibliothèque, je veux consulter le nombre de documents empruntés par mois, afin de suivre l'activité de la bibliothèque.**

    - Critères d'acceptation :
        - Le système génère un rapport mensuel sur le nombre de documents empruntés.
      
6. **En tant que Préposé de la bibliothèque, je veux consulter le montant total des amendes produites, afin de suivre les revenus de la bibliothèque.**

    - Critères d'acceptation :
        - Le système génère un rapport sur le montant total des amendes.
      
7. **En tant que Préposé de la bibliothèque, je veux savoir à quelle date un document doit revenir, afin de gérer les retours.**

    - Critères d'acceptation :
        - Le système affiche la date de retour prévue pour chaque document emprunté.



### UML
![uml.png](uml.png)