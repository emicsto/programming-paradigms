# Paradygmaty programowania

## [Implementacja 6](https://github.com/emicsto/programming-paradigms/tree/readme/src/main/kotlin/algorithms_6)
Program umożliwia porównanie czasów działania wybranych algorytmów w podejściu iteracyjnym i rekurencyjnym.

Analizowane algorytmy to:
* liczby Fibonacciego
* wieże Hanoi
* quicksort

Po uruchomieniu programu pojawia się przyjazny i intuicyjny interfejs użytkownika, w którym za pomocą klawiszy klawiatury można sterować programem.

Dostępne polecenie w menu głównym programu to:

* _1_ – liczby Fibonacciego
* _2_ – wieże Hanoi
* _3_ – quicksort
* _q_ – wyjście z programu

Po wybraniu jednego z dostępnych algorymów użytkownik otrzyma informację o podaniu, zależnie od algorytmu: 
* która liczba ciągu Fibonacciego powinna zostać odnaleziona
* początkowa liczba krążków
* ile liczb powinno zostać posortowanych

Ostatecznie zostaje zaprezentowany czas, w jakim algorytm się wykonał w obu podejściach.


## [Implementacja 13](https://github.com/emicsto/programming-paradigms/tree/readme/src/main/kotlin/optimazation_13)
Program pokazuje trzy różnie optymalizacje jakie mogą zostać wykonane na kodzie źródłowym w języku Kotlin 
(Te optymalizacje mogą również zostać wykonane w innych językach programowania). 
Optymalizacje są opisane w programie wraz z linkiem do GitHub, gdzie zamieszczony jest kod źródłowy poszczególnej
optymalizacji.

Możliwe optymalizacje 

- [Kolejność funkcyjnych operacji na listach](https://github.com/emicsto/programming-paradigms/tree/master/src/main/kotlin/optimazation_13/examples/OperationOrderExample.kt)
- [Szukanie elementu w kolekcji](https://github.com/emicsto/programming-paradigms/tree/master/src/main/kotlin/optimazation_13/examples/FindingElementExample.kt)
- [Porównanie operacji na kolekcji (niezmiennej - immutable oraz zmiennej - mutable)](https://github.com/emicsto/programming-paradigms/tree/master/src/main/kotlin/optimazation_13/examples/MutableCollectionExample.kt)

W głównym menu jest wybór Trech optymalizacji, w każdym momencie w programie można wpisać "quit" aby zakończyć działanie.

Po wyborze którejś optymalizacji jest możliwość pokazania opisu lub nie. Nastepnie program poprosi o rozmiar listy
użytej w optymalizacji, w przypadku "szukania elementu w kolekcji" dodatkowo trzeba podać szukany element.

Po wykonaniu pomiaru czasu, program zapyta czy chcemy powtórzyć ten sam algorytm ale z innym rozmiarem lub 
wrócić do głównego menu.