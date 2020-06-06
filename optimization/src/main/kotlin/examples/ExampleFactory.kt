package examples

class ExampleFactory {

    enum class ExampleId(val lp: Int, val title: String, val description: String) {
        OPERATION_ORDER(
            1,
            "Kolejność funkcyjnych operacji na listach",
            """
                https://github.com/emicsto/programming-paradigms/tree/master/src/main/kotlin/optimazation_13/examples/OperationOrderExample.kt
                
                Przed rozpocząciem algorytmu, tworzona jest lista z podanym rozmiarem, gdzie każdy element listy odpowiada kwadratowi swojego indeksu (index * index).
                Algorytm polega na wykonaniu następujących funkcyjnych operacjach na liście:
                - (map) Wyliczenie czterokrotności dla każdego elementu listy
                - (map) Wyliczenie pierwiastka kwadratowego dla każdego elementu listy
                - (filter) Usunięcie z listy elementów których indeks jest podzielny przez 2
                
                Optymalizacja polega na umiejscowieniu operacji filtrującej.
                Niepoprawna implementacja: map -> map -> filter
                Poprawna implementacja: filter -> map -> map
                
                Gdy operacja filtrująca jest na pierwszym miejscu, wszystkie następujące operacje zostaną wykonane na potencjalnie mniejszej liście. 
                W przypadku tego algorytmu lista ta będzie skrócona o mniej więcej połowę.
            
            """.trimIndent()
        ),
        FINDING_ELEMENT(
            2,
            "Szukanie elementu w kolekcji",
            """
                https://github.com/emicsto/programming-paradigms/tree/master/src/main/kotlin/optimazation_13/examples/FindingElementExample.kt
                
                Przed rozpocząciem algorytmu, tworzona jest lista oraz sekwencja w których każdy element odpowiada swojemu indeksowi
                
                Przypuszczając że algorytm polega transformacji kolekcji (map) i znalezienie elementu po transformacji. Przebieg wygląda następująco:
                W przypadku listy, na całym zbiorze jest wykonana transformacja, a następnie wykonana jest iteracja na tym zbiorze w celu znalezienia elementu.
                W przypadku sekwencji, transformacja jest wykonywana na jednym elemencie, a następnie element po transformacji jest porównywany z szukanym elementem. 
                
                Algorytm w tej optymalizacji polega na skomplikowanej transformacji (uśpienie wątku na 1ms) kolekcji, a następnie odszukanie jednego elementu w kolekcji po transformacji.
                
                Niepoprawna implementacja używa list
                Poprawna implementacja używa sekwencji
                
                W przypadku gdy element do znalezenia znajduje się na końcu listy, sekwencja może nawet mieć gorszy wynik niż implementacja na listach, ale w większości przypadków sekwencja będzie szybsza. 
                
            """.trimIndent()
        ),
//        PRIMITIVE_COLLECTION(
//            3,
//            "Operacje na kolekcji z liczbami prostymi",
//            """
//
//                https://github.com/emicsto/programming-paradigms/tree/master/src/main/kotlin/optimazation_13/examples/PrimitiveCollectionExample.kt
//
//                W języku programowania Java,
//
//            """.trimIndent()
//        ),
        MUTABLE_COLLECTION(
            3,
            "Porównanie operacji na kolekcji (niezmiennej - immutable oraz zmiennej - mutable)",
            """
                https://github.com/emicsto/programming-paradigms/tree/master/src/main/kotlin/optimazation_13/examples/MutableCollectionExample.kt
                
                Przed rozpoczęciem algorytmu, tworzona jest lista w której każdy element odpowiada swojemu indeksowi.
                 
                Algorytm polega na trzy etapowej transformacji elementów w liście:
                1. Obliczenie kwadratu
                2. Podzielenie przez 2
                3. Pomnożenie przez 3
                 
                Niepoprawna implementacja robi to za pomocą trzech operacji map, oznacza to że tworzone są dwie pośrednie listy aby otrzymać wynik.
                Poprawna implementacja używa zmiennej listy do której dodawane są elementy po trzy etapowej transformacji, dzięki temu żadne pośrednie listy nie są tworzone.
                
            """.trimIndent()
        )
    }

    private val examples = mapOf<ExampleId, (Int) -> Example>(
            ExampleId.OPERATION_ORDER to { size ->
                OperationOrderExample(
                    size
                )
            },
            ExampleId.FINDING_ELEMENT to { size ->
                FindingElementExample(
                    size
                )
            },
//            ExampleId.PRIMITIVE_COLLECTION to { size -> PrimitiveCollectionExample(size) },
            ExampleId.MUTABLE_COLLECTION to { size ->
                MutableCollectionExample(
                    size
                )
            }
    )

    fun getExample(exampleId: ExampleId, size: Int): Example {
        val factory = examples[exampleId] ?: throw IllegalArgumentException("exampleId is incorred $exampleId")

        return factory(size)
    }

}
