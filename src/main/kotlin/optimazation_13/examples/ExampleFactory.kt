package optimazation_13.examples

class ExampleFactory {

    enum class ExampleId(val lp: Int, val title: String, val description: String) {
        OPERATION_ORDER(
            1,
            "Kolejność funkcyjnych operacji na listach",
            """
                
                https://github.com/emicsto/programming-paradigms/blob/optimization/src/main/kotlin/optimazation_13/examples/OperationOrderExample.kt
                
                Przed rozpocząciem algorytmu tworzona jest lista z podanym rozmiarem, gdzie każdy element listy odpowiada kwadracie swojego indeksu (index * index)
                Algorytm polega na wykonaniu następujących funkcyjnych operacjach na liście:
                - (map) Wyliczenie czterokrotności dla każdego elementu listy
                - (map) Wyliczenie pierwiastka kwadratowego dla każdego elementu listy
                - (filter) Usunięcie z listy elementów których index jest podzielny przez 2
                
                Optymalizacja polega na umiejscowieniu operacji usunięcia z listy
                
                Niepoprawna implementacja: map -> map -> filter
                Poprawna implementacja: filter -> map -> map
                
                Gdy operacja filter jest na pierwszym miejscu, wszystkie operacje map wykonają się na liście skróconej o ~połowe~
            
            """.trimIndent()
        ),
        FINDING_ELEMENT(
            2,
            "Szukanie elementu w kolekcji",
            ""
        ),
        PRIMITIVE_COLLECTION(
            3,
            "Operacje na kolekcji z liczbami prostymi",
            "TODO"
        ),
        MUTABLE_COLLECTION(
            4,
            "Porównanie operacji na niezmiennej kolekcji i zmiennej kolekcji",
            "TODO"
        )
    }

    private val examples = mapOf<ExampleId, (Int) -> Example>(
            ExampleId.OPERATION_ORDER to { size -> OperationOrderExample(size) },
            ExampleId.FINDING_ELEMENT to { size -> FindingElementExample(size) },
            ExampleId.PRIMITIVE_COLLECTION to { size -> PrimitiveCollectionExample(size) },
            ExampleId.MUTABLE_COLLECTION to { size -> MutableCollectionExample(size) }
    )

    fun getExample(exampleId: ExampleId, size: Int): Example {
        val factory = examples[exampleId] ?: throw IllegalArgumentException("exampleId is incorred $exampleId")

        return factory(size)
    }

}