# VLille-Tracker-Consumer
Consommation des mises à jour des données du dataset VLille depuis un topic Kafka alimenté par l'application vlille-tracker-producer

# Fonctionnement de l'application
1) Ecoute un topic Kafka où sont publiées les informations de l'ensemble des stations du réseau VLille toutes les minutes
2) Sauvegarde une version de ce dataset dans un HashSet (mémoire volatile)
3) Met à jour ce dataset pour chaque changement détecté (timestamp d'update compris)
4) Log en console les changement de disponibilité des vélos retirés/déposés

# TODO
1) Détecter plus proprement quelles stations ont été updaté (equals exclude timestamp)
2) Afficher les changements sur une interface graphique (via coordonnées géographiques ?)