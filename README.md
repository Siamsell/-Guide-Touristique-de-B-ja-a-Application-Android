# -Guide-Touristique-de-B-ja-a-Application-Android
 
#  Guide Touristique — Béjaïa

Application Android (Java) qui fait découvrir la ville de **Béjaïa** (Algérie) : catégories de lieux, fiches détaillées avec photos, avis, et actions rapides (appel, SMS, e-mail, itinéraire).

##  Fonctionnalités

- **Écran d'accueil** avec carrousel d'images (défilement automatique toutes les 3 s, clic pour passer à l'image suivante) et indicateur de position.
- **7 catégories** : plages, montagnes, sites historiques, musées, restaurants, parcs et hôtels.
- **Liste des sites** par catégorie : galerie d'images défilante, description, localisation, avis des visiteurs.
- **Actions rapides** depuis chaque fiche :  appeler,  envoyer un SMS,  envoyer un e-mail.
- **Navigation GPS** vers la ville via Google Maps.
- **Bilingue** : bascule entre l'anglais et l'arabe (avec prise en charge de l'affichage droite-à-gauche).
- **Page « More informations »** de présentation de la ville.

##  Technologies

| | |
|---|---|
| Langage | Java |
| Plateforme | Android (minSdk 24 · targetSdk 35) |
| Build | Gradle (Kotlin DSL) |
| UI | AppCompat, Material Components, ConstraintLayout, GridLayout, ListView / RecyclerView |

## Lancer le projet

1. Cloner le dépôt :
   ```bash
   git clone https://github.com/<ton-compte>/guidetoristique.git
   ```
2. Ouvrir le dossier dans **Android Studio**.
3. Attendre la synchronisation Gradle (le fichier `local.properties` est créé automatiquement).
4. Lancer l'application (▶ **Run**) sur un émulateur ou un téléphone Android.

##  Structure du projet

```

├guidetoristique/
│   ├── MainActivity.java        # Accueil, carrousel, langue, navigation GPS
│   ├── Categorier.java          # Liste des catégories
│   ├── Siteinfo.java            # Liste des sites d'une catégorie
│   ├── MoreInfoActivity.java    # Page d'informations
│   ├── Generator.java           # Données des sites + boutons appel / SMS / e-mail
│   ├── CategoryAdapter.java
│   ├── ImageAdapter.java
│   ├── adapter/                 # SiteAdapter, imagePagerAdapter
│   └── models/                  # Site, SiteImage, SiteType, CategoryModel, Ville
└── res/
    ├── layout/                  # Écrans XML
    ├── drawable/                # Images et styles
    ├── values/                  # Textes (EN) et thèmes
    └── values-ar/               # Textes (AR)
```

