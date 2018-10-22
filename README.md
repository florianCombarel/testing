# Object-Oriented Software Testing
## Combarel Florian, Thomas Aurélien

Master 1 ICE, GLa - V&V - Labs ([course materials](http://combemale.fr/teaching/m1ice/))

> Créez un projet Java, récupérez la classe MyPoint, et rajoutez la librairie JUnit à votre projet. 

## Test Unitaire pour Java avec JUnit

> Q.1a Tester les constructeurs 1 et 2 (dans une classe de test TestMyPoint). Pour cela, utiliser la Javadoc pour
comprendre le comportement attendu des constructeurs. Utilisez des assertions pour vérifier les valeurs, par exemple :

    ...
    assertEquals (0d, point . getX (), 0.0001);
    ...

> Q.1b Le test de ces constructeurs utilisent les opérations getX et getY. Ne trouvez-vous pas cela étrange qu’un test utilise d’autres opérations ? Que faire ?
>> Oui cela est étrange car nous n'avons pas encore testé les getters. On ne peut donc pas être sûr que le test sur le constructeur soit fonctionnel. Il faut écrire les tests des getters avant le test du constructeur.

> Q.1c Testez les accesseurs en lecture et écriture (les opérations get et set). Tout d’abord, testez getX et setX ensemble (car elles sont liées, idem pour y). Ensuite créez d’autres tests pour tester les opérations set avec la valeur Double.NaN (cf. la javadoc de ces opérations).
>> Il y avait le setteur de Y qui alloué la nouvelle valeur sur X. Nous avons donc corrigé cette erreur. Les setteurs permettaient une allocation des Double.NaN, nous avons donc changé leurs codes pour qu'ils ne fassent rien.

> Q.1d Testez le constructeur 3 et l’opération scale. Plusieurs tests (i.e. plusieurs opérations) seront nécessaires pour le constructeur 3. Vous pouvez constater que la plupart des tests nécessitent la création d’un point au début des opérations de test.
>> Nous avons corrigé l'erreur sur le constructeur 3 qui ne pouvait pas prendre en compte le passage en paramètre d'un objet null.

> Q.1e Définissez et utilisez l’opération @Before setUp() et tout ce qui est également nécessaire pour déléguer cette création à l’opération setUp.

> Q.1f Testez l’opération horizontalSymmetry. Là encore, plusieurs tests (i.e. plusieurs opérations) seront nécessaires. Vous remarquerez que cette opération peut lever une exception. Utilisez le paramètre expected de l’annotation Test pour vérifier que cette exception est bien levée en temps voulu.

## Couverture de code

> Q.2a Utilisez l’outil de couverture de code fourni dans Eclipse (ou autre IDE) pour identifier les chemins dans le code non couvert par vos tests. Rajoutez quelques tests si besoins (n’y passez pas trop de temps).
>> La première couverture faite du code fourni ne couvre que 53% des méthodes.
Les méthodes non couvertes sont les suivantes:
>> - computeAngle
>> - rotatePoint
>> - centralSymmetry
>> - getMiddlePoint
>> - translate
>> - setPoint

> Q.2b Est-ce que votre code est sûr lorsque toutes les instructions sont couvertes par au moins un test ?

>> Non le code  n'est pas sûr si toutes les instructions sont couvertes car les instruction peuvent être couvertes mais ne pas prendre en compte tous les cas d'utilisation.

> Q.2c Ajoutez le test unitaire suivant et exécutez-le. S’il passe, bien joué. Dans tout les cas cela peut certainement vous aidez à répondre à la question précédente.

    @Test public void testCentralSymmetryNULL ( ) {
        new MyPoint ( 1 0 , 2 0 ) . centralSymmetry ( null ) ;
    }

## Test d'intégration pour Java avec EasyMock ou Mockito

Cet exercice est une brève introduction au principe du mock.

L’opération setPoint(Random r1, Random r2) définit les coordonnées d’un point de manière aléatoire (x avec r1, et y avec r2).

> Q.3a Expliquez en quoi il est impossible de tester en l’état cette opération.
    >> On veut donc utiliser le principe du Mock pour tester cette opération.
>> Il est impossible de tester l'état du point avec Random car nous ne pouvons prévoir la position que le point aura.

> Q.3b Utilisez Easymock ou Mockito pour tester cette opération. 

Avec Mockito :
- N’oubliez pas @RunWith (MockitoJUnitRunner.class). Vous aurez besoin de 2 attributs Random annotée avec @Mock. Le but est de simuler l’opération nextInt(). 
- L’opération translate(ITranslation) déplace le point selon le vecteur de translation donné en paramètre. Cependant ITranslation est une interface, on ne peut donc pas l’instancier.

Avec Easymock : voir la refcard et les slides du cours.

> Q.3c Supposons que nous ne disposons pas d’une implémentation de ITranslation pour tester cette opération, utilisez Mockito ou Easymock et tester finalement cette opération.

## Evaluation 

1. faite un fork du repo github
2. répondez aux questions (dans un nouveau fichier Markdown ou directement dans README.md), dans lequel vous préciserez également les noms du binome.
3. rajoutez vos tests, modifications de la classe sous test, etc. 
4. soumettez votre pull request (qui servira à l'évaluation)
